package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.capability.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.BulletType;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class ItemModRanged extends ItemMod {

    protected final String entityType;
    private final Supplier<SoundEvent> sound;
    private final SoundSource soundCategory;
    private final int delay;
    private final ResourceLocation ammoSupplier;
    private int arcanaConsuming;

//    private final String delayTagName = "CanShootTime";

    protected BulletType bulletType;

    /**
     * Constructor for Divine RPG ranged weapons
     *
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
    public ItemModRanged(Rarity rarity, String entityType, BulletType bulletType,
                         Supplier<SoundEvent> sound, SoundSource soundCategory, int maxDamage, int delay, ResourceLocation ammoSupplier, int arcanaConsuming) {
        super(new Properties().durability(maxDamage).rarity(rarity));
        this.entityType = entityType;
        this.sound = sound;
        this.soundCategory = soundCategory;
        this.delay = delay;

        if(ammoSupplier == null) {
            this.ammoSupplier = null;
        }
        else {
            this.ammoSupplier = ammoSupplier;
        }

        this.arcanaConsuming = arcanaConsuming;
        this.bulletType = bulletType;
    }

    public ItemModRanged(String entityType, BulletType bulletType,
                         Supplier<SoundEvent> sound, SoundSource soundCategory, int maxDamage, int delay, ResourceLocation ammoSupplier, int arcanaConsuming) {
        super(new Properties().durability(maxDamage));
        this.entityType = entityType;
        this.sound = sound;
        this.soundCategory = soundCategory;
        this.delay = delay;

        if(ammoSupplier == null) {
            this.ammoSupplier = null;
        }
        else {
            this.ammoSupplier = ammoSupplier;
        }

        this.arcanaConsuming = arcanaConsuming;
        this.bulletType = bulletType;
    }


    public ItemModRanged(BulletType bulletType, Supplier<SoundEvent> shotSound, ResourceLocation ammoSupplier, int maxDamange,
                         int counter) {
        this(null, bulletType, shotSound, SoundSource.MASTER, maxDamange, counter, ammoSupplier, 0);
    }

    public ItemModRanged(BulletType bulletType, Supplier<SoundEvent> shotSound, int uses, int counter) {
        this(bulletType, shotSound, null, uses, counter);
    }

    public ItemModRanged(Rarity rarity, BulletType bulletType, Supplier<SoundEvent> shotSound, ResourceLocation ammoSupplier, int maxDamange,
                         int counter) {
        this(rarity, null, bulletType, shotSound, SoundSource.MASTER, maxDamange, counter, ammoSupplier, 0);
    }

    public ItemModRanged(Rarity rarity, BulletType bulletType, Supplier<SoundEvent> shotSound, int uses, int counter) {
        this(rarity, bulletType, shotSound, null, uses, counter);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (bulletType != null) {
            tooltip.add(LocalizeUtils.rangedDam((int)bulletType.getDamage()));
        }

        if (!needsAmmo()) {
            tooltip.add(LocalizeUtils.i18n("tooltip.ammo.infinite"));
        } else {
            ItemStack ammo = new ItemStack(ForgeRegistries.ITEMS.getValue(ammoSupplier));
            tooltip.add(LocalizeUtils.ammo(getAmmo(), ammo != null));
        }

        tooltip.add(stack.getMaxDamage() == -1 ? LocalizeUtils.infiniteUses() :
                LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));

        if (arcanaConsuming > 0)
            tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsuming));
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        InteractionResult result = InteractionResult.FAIL;

        if (canUseRangedWeapon(player, stack)) {
            InteractionResultHolder<ItemStack> ammo = tryFindAmmo(player);
            InteractionResultHolder<Arcana> checkArcana = tryCheckArcana(player);

            if (ammo.getResult() == InteractionResult.SUCCESS && checkArcana.getResult() == InteractionResult.SUCCESS) {
                doPreUsageEffects(world, player);

                if (!world.isClientSide) {
                    world.playSound(null, player.blockPosition(),
                            this.sound.get() != null ? this.sound.get() : SoundEvents.ARROW_SHOOT,
                            this.soundCategory != null ? this.soundCategory : SoundSource.MASTER, 1, 1);

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

//                if (player instanceof ServerPlayer) {
//                    ((ServerPlayer) player)(player.containerMenu);
//                }

                doPostUsageEffects(world, player);
            }


        }

        return new InteractionResultHolder<>(result, stack);
    }


    private Item getAmmo() {
        if(ForgeRegistries.ITEMS.getValue(ammoSupplier) != Items.AIR) {
            return ForgeRegistries.ITEMS.getValue(ammoSupplier);
        }else {
            return null;
        }
    }

    private boolean needsAmmo() {
        return ForgeRegistries.ITEMS.getValue(ammoSupplier) != Items.AIR;
    }

    private boolean isAmmo(@Nullable ItemStack stack) {
        return stack != null && stack.getItem() == getAmmo();
    }

    private ItemStack findAmmo(Player player) {
        if (this.isAmmo(player.getItemInHand(InteractionHand.OFF_HAND))) {
            return player.getItemInHand(InteractionHand.OFF_HAND);
        } else if (this.isAmmo(player.getItemInHand(InteractionHand.MAIN_HAND))) {
            return player.getItemInHand(InteractionHand.MAIN_HAND);
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
    protected InteractionResultHolder<ItemStack> tryFindAmmo(Player player) {
        ItemStack stack = null;
        InteractionResult result = InteractionResult.SUCCESS;

        if (!player.isCreative() && needsAmmo()) {
            stack = findAmmo(player);
            if (stack == null || stack.getCount() < 1) {
                result = InteractionResult.FAIL;
            }
        }

        return new InteractionResultHolder<>(result, stack);
    }

    /*
        Trying to get capability and check if we have enough arcana
     */
    protected InteractionResultHolder<Arcana> tryCheckArcana(Player player) {
        Arcana arcana = null;
        InteractionResult result = InteractionResult.SUCCESS;

        if (!player.isCreative() && this.arcanaConsuming > 0) {
            arcana = player.getCapability(ArcanaProvider.ARCANA).orElseThrow(RuntimeException::new);
            if (arcana == null || arcana.getArcana() < this.arcanaConsuming) {
                result = InteractionResult.FAIL;
            }
        }

        return new InteractionResultHolder<>(result, arcana);
    }

    /*
        Trying to detect if we can use the item.
     */
    protected boolean canUseRangedWeapon(Player player, ItemStack stack) {
        return (player.isCreative() || stack.getMaxDamage() <= 0
                || stack.getDamageValue() < stack.getMaxDamage());
    }

    protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType,
                               String entityType) {

        ThrowableProjectile bullet = null;

        // Class has the most priority
        if (entityType != null) {
            try {
                bullet = (ThrowableProjectile) ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(DivineRPG.MODID, entityType)).create(world);
            } catch (Exception e) {
                e.printStackTrace();

                // Weapon will not work, so it would be better to crush
                throw new RuntimeException(e.getMessage());
            }
        }
        // In other cases we look to a BulletType field
        else if (bulletType.getParticle() != ParticleTypes.BUBBLE) {
            bullet = new EntityParticleBullet(EntityRegistry.PARTICLE_BULLET.get(), world, player, bulletType);
        } else if (bulletType.getRed() != 0 && bulletType.getGreen() != 0 && bulletType.getBlue() != 0) {
            bullet = new EntityColoredBullet(EntityRegistry.COLORED_BULLET.get(), player, world, bulletType);
        } else {
            bullet = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), player, world, bulletType);
        }
        bullet.moveTo(player.xo, player.getEyeY(), player.zo);
        bullet.setOwner(player);
        bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 0.5F);
        world.addFreshEntity(bullet);
    }

    protected void doPreUsageEffects(Level world, Player player) {
        return;
    }

    protected void doPostUsageEffects(Level world, Player player) {
        return;
    }
}