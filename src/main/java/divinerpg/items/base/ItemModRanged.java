package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.capability.Arcana;
import divinerpg.capability.ArcanaCapability;
import divinerpg.entities.projectile.EntityColoredBullet;
import divinerpg.entities.projectile.EntityParticleBullet;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class ItemModRanged extends ItemMod {

    private final EntityType<?> entityType;
    private final SoundEvent sound;
    private final SoundCategory soundCategory;
    private final int delay;
    private final Supplier<Item> ammoSupplier;
    private int arcanaConsuming;

    private final String delayTagName = "CanShootTime";

    protected BulletType bulletType;

    /**
     * Constructor for Divine RPG ranged weapons
     *
     * @param name
     *            - name of resource
     * @param entityType
     *            - entity type
     * @param bulletType
     *            - Type of bullets. Has lower priority than entityType param
     * @param sound
     *            - what sound will be on bullet spawn
     * @param soundCategory
     *            - sound category, mostly MASTER
     * @param maxDamage
     *            - max usage of item
     * @param delay
     *            - cooldown for shoot
     * @param ammoSupplier
     *            - Ammo for weapon. If supplier returns null, no ammo required
     * @param arcanaConsuming
     *            - Arcana consuming per shot. Pass 0 to not consume at all
     */
    public ItemModRanged(String name, Rarity rarity, EntityType<?> entityType, BulletType bulletType,
                         SoundEvent sound, SoundCategory soundCategory, int maxDamage, int delay, Supplier<Item> ammoSupplier, int arcanaConsuming) {
        super(name, new Properties().tab(DivineRPG.tabs.ranged).durability(maxDamage).rarity(rarity));
        this.entityType = entityType;
        this.sound = sound;
        this.soundCategory = soundCategory;
        this.delay = delay;

        if(ammoSupplier == null) {
            this.ammoSupplier = () -> null;
        }
        else {
            this.ammoSupplier = ammoSupplier;
        }

        this.arcanaConsuming = arcanaConsuming;
        this.bulletType = bulletType;
    }

    public ItemModRanged(String name, EntityType<?> entityType, BulletType bulletType,
                         SoundEvent sound, SoundCategory soundCategory, int maxDamage, int delay, Supplier<Item> ammoSupplier, int arcanaConsuming, ItemGroup tab) {
        super(name, new Properties().tab(tab).durability(maxDamage));
        this.entityType = entityType;
        this.sound = sound;
        this.soundCategory = soundCategory;
        this.delay = delay;

        if(ammoSupplier == null) {
            this.ammoSupplier = () -> null;
        }
        else {
            this.ammoSupplier = ammoSupplier;
        }

        this.arcanaConsuming = arcanaConsuming;
        this.bulletType = bulletType;
    }

    public ItemModRanged(String name, Rarity rarity, BulletType bulletType, SoundEvent shotSound, Supplier<Item> ammoSupplier, int maxDamange,
                            int counter) {
        this(name, rarity, null, bulletType, shotSound, SoundCategory.MASTER, maxDamange, counter, ammoSupplier, 0);
    }

    public ItemModRanged(String name, Rarity rarity, BulletType bulletType, SoundEvent shotSound, int uses, int counter) {
        this(name, rarity, bulletType, shotSound, () -> null, uses, counter);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (bulletType != null) {
            tooltip.add(LocalizeUtils.rangedDam(bulletType.getDamage()));
        }

        if (!needsAmmo()) {
            tooltip.add(LocalizeUtils.i18n("tooltip.ammo.infinite"));
        } else {
            ItemStack ammo = new ItemStack(ammoSupplier.get());
            tooltip.add(LocalizeUtils.ammo(getAmmo(), ammo != null));
        }

        tooltip.add(stack.getMaxDamage() == -1 ? LocalizeUtils.infiniteUses() :
                LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));

        if (arcanaConsuming > 0)
            tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsuming));
    }


    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        ActionResultType result = ActionResultType.FAIL;

        if (canUseRangedWeapon(player, stack)) {
            ActionResult<ItemStack> ammo = tryFindAmmo(player);
            ActionResult<Arcana> checkArcana = tryCheckArcana(player);

            if (ammo.getResult() == ActionResultType.SUCCESS && checkArcana.getResult() == ActionResultType.SUCCESS) {
                doPreUsageEffects(world, player);

                if (!world.isClientSide) {
                    world.playSound(null, player.blockPosition(),
                            this.sound != null ? this.sound : SoundEvents.ARROW_SHOOT,
                            this.soundCategory != null ? this.soundCategory : SoundCategory.MASTER, 1, 1);

                        spawnEntity(world, player, stack, bulletType, entityType);
                }

                Arcana arcana = checkArcana.getObject();
                if (arcana != null)
                    arcana.consume(player, arcanaConsuming);

                ItemStack ammoStack = ammo.getObject();
                if (ammoStack != null) {
                    ammoStack.shrink(1);
                }

                if (!player.isCreative()) {
                    stack.hurtAndBreak(1, player, (p_220009_1_) -> {
                        p_220009_1_.broadcastBreakEvent(player.getUsedItemHand());
                    });
                }

                player.getCooldowns().addCooldown(stack.getItem(), delay * 4 + 1);

                if (player instanceof ServerPlayerEntity) {
                    ((ServerPlayerEntity) player).refreshContainer(player.containerMenu);
                }

                doPostUsageEffects(world, player);
            }


        }

        return new ActionResult<>(result, stack);
    }


    private Item getAmmo() {
        return this.ammoSupplier.get();
    }

    private boolean needsAmmo() {
        return this.ammoSupplier.get() != null;
    }

    private boolean isAmmo(@Nullable ItemStack stack) {
        return stack != null && stack.getItem() == getAmmo();
    }

    private ItemStack findAmmo(PlayerEntity player) {
        if (this.isAmmo(player.getItemInHand(Hand.OFF_HAND))) {
            return player.getItemInHand(Hand.OFF_HAND);
        } else if (this.isAmmo(player.getItemInHand(Hand.MAIN_HAND))) {
            return player.getItemInHand(Hand.MAIN_HAND);
        } else {
            for (int i = 0; i < player.inventory.getContainerSize(); ++i) {
                ItemStack itemstack = player.inventory.getItem(i);
                if (this.isAmmo(itemstack)) {
                    return itemstack;
                }
            }
            return null;
        }
    }

    /*
        Trying to find ammo stack.
        If SUCCESS, can continue
        If ItemStack is not null, we need to shrink it
     */
    protected ActionResult<ItemStack> tryFindAmmo(PlayerEntity player) {
        ItemStack stack = null;
        ActionResultType result = ActionResultType.SUCCESS;

        if (!player.isCreative() && needsAmmo()) {
            stack = findAmmo(player);
            if (stack == null || stack.getCount() < 1) {
                result = ActionResultType.FAIL;
            }
        }

        return new ActionResult<>(result, stack);
    }

    /*
        Trying to get capability and check if we have enough arcana
     */
    protected ActionResult<Arcana> tryCheckArcana(PlayerEntity player) {
        Arcana arcana = null;
        ActionResultType result = ActionResultType.SUCCESS;

        if (!player.isCreative() && this.arcanaConsuming > 0) {
            arcana = player.getCapability(ArcanaCapability.CAPABILITY_ARCANA).orElse(null);
            if (arcana == null || arcana.getArcana() < this.arcanaConsuming) {
                result = ActionResultType.FAIL;
            }
        }

        return new ActionResult<>(result, arcana);
    }

    /*
        Trying to detect if we can use the item.
     */
    protected boolean canUseRangedWeapon(PlayerEntity player, ItemStack stack) {
        return (player.isCreative() || stack.getMaxDamage() <= 0
                || stack.getDamageValue() < stack.getMaxDamage());
    }

    protected void spawnEntity(World world, PlayerEntity player, ItemStack stack, BulletType bulletType,
                               EntityType<?> entityType) {

        ThrowableEntity bullet = null;

        // Class has the most priority
        if (entityType != null) {
            try {
                bullet = (ThrowableEntity) entityType.create(world);
            } catch (Exception e) {
                e.printStackTrace();

                // Weapon will not work, so it would be better to crush
                throw new RuntimeException(e.getMessage());
            }
        }
        // In other cases we look to a BulletType field
        else if (bulletType.getParticle() != ParticleTypes.BUBBLE) {
            bullet = new EntityParticleBullet(EntityRegistry.PARTICLE_BULLET, world, player, bulletType);
        } else if (bulletType.getColor() != null) {
            bullet = new EntityColoredBullet(EntityRegistry.COLORED_BULLET, player, world, bulletType);
        } else {
            bullet = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET, player, world, bulletType);
        }
        bullet.moveTo(player.xo, player.getEyeY(), player.zo);
        bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
        world.addFreshEntity(bullet);
    }

    protected void doPreUsageEffects(World world, PlayerEntity player) {
        return;
    }

    protected void doPostUsageEffects(World world, PlayerEntity player) {
        return;
    }
}