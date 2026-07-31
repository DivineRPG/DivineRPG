package divinerpg.items.ranged;

import divinerpg.entities.projectile.DivineThrownItem;
import divinerpg.items.base.ItemThrowable;
import divinerpg.utils.ArcanaHelper;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.*;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.CommonHooks;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.*;

public class ItemRangedWeapon extends ProjectileWeaponItem {
    public static final Identifier GENERIC = Identifier.withDefaultNamespace("textures/particle/generic_0.png");

    public final TagKey<Item> ammoType;
    public SoundEvent sound;
    public float power = 3F;
    public int arcanaConsumedUse, cooldown;
    public final Supplier<EntityType<? extends Projectile>> projectileType;
    public Integer nameColor = null;
    protected boolean infinite;
    protected final List<Component> tooltips = new ArrayList<>();
    public final Supplier<ItemStack> defaultItem;

    public ItemRangedWeapon(Properties properties, Supplier<EntityType<? extends Projectile>> projectileType) {
        this(properties, null, Items.ARROW::getDefaultInstance, projectileType);
    }

    public ItemRangedWeapon(Properties properties, @Nullable TagKey<Item> ammoType, Supplier<ItemStack> defaultItem, Supplier<EntityType<? extends Projectile>> projectileType) {
        super(properties);
        this.ammoType = ammoType;
        this.infinite = (ammoType == null);
        this.projectileType = projectileType;
        this.defaultItem = defaultItem;
    }

    public ItemRangedWeapon withCooldown(int cooldown) {
        this.cooldown = cooldown;
        return this;
    }

    public ItemRangedWeapon withTooltip(Component tip) {
        tooltips.add(tip);
        return this;
    }

    public ItemRangedWeapon withTooltips(List<Component> tooltip) {
        tooltips.addAll(tooltip);
        return this;
    }

    public ItemRangedWeapon withSound(SoundEvent s) {
        sound = s;
        return this;
    }

    public ItemRangedWeapon withPower(float pow) {
        power = pow;
        return this;
    }

    public ItemRangedWeapon arcanaUse(int arcana) {
        arcanaConsumedUse = arcana;
        return this;
    }

    public ItemRangedWeapon nameColor(int c) {
        nameColor = c;
        return this;
    }


    @Override
    protected Projectile createProjectile(Level level, LivingEntity shooter, ItemStack weapon, ItemStack ammo, boolean isCrit) {
        Projectile p = projectileType.get().create(level, EntitySpawnReason.EVENT);
        if (p instanceof DivineThrownItem t) {
            t.setItem(ammo);
        }
        p.setOwner(shooter);
        p.setPos(shooter.getEyePosition().add(0, -0.147, 0));
        return p;
    }

    @Override
    public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return defaultItem.get();
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        ItemStack ammo = findAmmo(player);
        if (ammo != null && !ammo.isEmpty() && ArcanaHelper.getArcana(player) >= arcanaConsumedUse) {
            if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
                shoot(serverLevel, player, player.getUsedItemHand(), stack, List.of(ammo), power, 1.0F, false, null);
                if (arcanaConsumedUse > 0) {
                    int currentArcana = (int) ArcanaHelper.getArcana(player);
                    ArcanaHelper.setArcana(player, currentArcana - arcanaConsumedUse);
                }
            }

            if (!player.isCreative() && serverLevelHasInfinity(level, stack)) {
            } else if (!player.isCreative() && stack.getEnchantmentLevel(level.holderOrThrow(Enchantments.INFINITY)) < 1) {
                ammo.consume(1, player);
            }

            if (cooldown > 0) {
                player.getCooldowns().addCooldown(stack, cooldown);
            }
            player.awardStat(Stats.ITEM_USED.get(this));

            if (stack.getItem() instanceof ItemThrowable) {
                player.playSound(sound != null ? sound : SoundEvents.ARROW_SHOOT, 0.5F, 0.4F / (player.getRandom().nextFloat() * 0.4F + 0.8F));
                return InteractionResult.SUCCESS;
            }
            player.playSound(sound != null ? sound : SoundEvents.ARROW_SHOOT, 1.0F, 1.0F);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

    private boolean serverLevelHasInfinity(Level level, ItemStack stack) {
        try {
            return stack.getEnchantmentLevel(level.holderOrThrow(Enchantments.INFINITY)) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    protected ItemStack findAmmo(Player player) {
        ItemStack shootable = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (ammoType == null) {
            return getDefaultCreativeAmmo(player, shootable);
        }
        ItemStack itemstack = ProjectileWeaponItem.getHeldProjectile(player, (item) -> item.is(ammoType));
        if (!itemstack.isEmpty()) {
            return CommonHooks.getProjectile(player, shootable, itemstack);
        } else {
            for (int i = 0; i < player.getInventory().getContainerSize(); ++i) {
                ItemStack itemstack1 = player.getInventory().getItem(i);
                if (itemstack1.is(ammoType)) {
                    return CommonHooks.getProjectile(player, shootable, itemstack1);
                }
            }
            return CommonHooks.getProjectile(player, shootable, player.isCreative() ? getDefaultCreativeAmmo(player, shootable) : ItemStack.EMPTY);
        }
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return this::isOfTag;
    }

    private boolean isOfTag(ItemStack stack) {
        return ammoType != null && stack.is(ammoType);
    }

    @Override
    public int getDefaultProjectileRange() {
        return 15;
    }

    @Override
    protected void shootProjectile(LivingEntity shooter, Projectile projectile, int i, float velocity, float inaccuracy, float angle, @Nullable LivingEntity livingEntity1) {
        projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, velocity, inaccuracy);
    }

    @Override
    protected void shoot(ServerLevel level, LivingEntity shooter, InteractionHand hand, ItemStack weapon, List<ItemStack> projectileItems, float velocity, float inaccuracy, boolean isCrit, @Nullable LivingEntity target) {
        float f = EnchantmentHelper.processProjectileSpread(level, weapon, shooter, 0.0F);
        float f1 = projectileItems.size() == 1 ? 0.0F : 2.0F * f / (projectileItems.size() - 1);
        float f2 = ((projectileItems.size() - 1) % 2) * f1 / 2.0F;
        float f3 = 1.0F;

        for (int i = 0; i < projectileItems.size(); ++i) {
            ItemStack itemstack = projectileItems.get(i);
            if (!itemstack.isEmpty()) {
                float f4 = f2 + f3 * ((i + 1) >> 1) * f1;
                f3 = -f3;
                Projectile projectile = createProjectile(level, shooter, weapon, itemstack, isCrit);
                if (projectile != null) {
                    shootProjectile(shooter, projectile, i, velocity, inaccuracy, f4, target);
                    level.addFreshEntity(projectile);

                    if (level.getChunkSource() instanceof ServerChunkCache chunkCache) {
                        chunkCache.sendToTrackingPlayers(projectile, new ClientboundSetEntityMotionPacket(projectile));
                    }
                }
                weapon.hurtAndBreak(1, shooter, hand);
                if (weapon.isEmpty()) {
                    break;
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        tooltips.stream().forEach(tip -> builder.accept(tip));
        if (arcanaConsumedUse > 0) {
            builder.accept(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
        }
        if (infinite) {
            builder.accept(LocalizeUtils.infiniteAmmo());
        } else if (ammoType != null) {
            builder.accept(LocalizeUtils.ammo(ammoType));
        }
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }

    @Override
    public Component getName(ItemStack pStack) {
        return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }

    @Override
    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return super.supportsEnchantment(stack, enchantment) || (ammoType != null && enchantment.is(Enchantments.INFINITY));
    }

}