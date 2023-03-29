package divinerpg.items.base;

import divinerpg.entities.projectile.EntityDivineArrow;
import divinerpg.enums.ArrowType;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class ItemModBow extends BowItem {
    public static final int DEFAULT_MAX_USE_DURATION = 72000;
    protected ArrowType arrowType;
    protected int maxUseDuration;
    protected boolean unbreakable;
    protected ResourceLocation arrowSupplier;
    private net.minecraft.sounds.SoundEvent shootSound = SoundEvents.ARROW_SHOOT;

    public ItemModBow(Rarity rarity, ArrowType arrowType, int uses, ResourceLocation arrowSupplier) {
        this(rarity, arrowType, uses, DEFAULT_MAX_USE_DURATION, arrowSupplier);
    }

    public ItemModBow(ArrowType arrowType, int uses, ResourceLocation arrowSupplier) {
        this(arrowType, uses, DEFAULT_MAX_USE_DURATION, arrowSupplier);
    }

    public ItemModBow(ArrowType arrowType, int uses, ResourceLocation arrowSupplier, Properties properties) {
        this(arrowType, uses, DEFAULT_MAX_USE_DURATION, arrowSupplier, properties);
    }

    public ItemModBow(ArrowType arrowType, int uses) {
        this(arrowType, uses, DEFAULT_MAX_USE_DURATION, null);
    }

    public ItemModBow(Rarity rarity, ArrowType arrowType, int uses) {
        this(rarity, arrowType, uses, DEFAULT_MAX_USE_DURATION, null);
    }


    public ItemModBow(ArrowType arrowType, int uses, int maxUseDuration, ResourceLocation arrowSupplier) {
        super(new Properties().durability(uses));
        this.arrowType = arrowType;
        this.arrowSupplier = arrowSupplier;
        this.maxUseDuration = maxUseDuration;
        unbreakable = true;

    }

    public ItemModBow(Rarity rarity, ArrowType arrowType, int uses, int maxUseDuration, ResourceLocation arrowSupplier) {
        super(new Properties().durability(uses).rarity(rarity));
        this.arrowType = arrowType;
        this.arrowSupplier = arrowSupplier;
        this.maxUseDuration = maxUseDuration;
        unbreakable = true;

    }

    public ItemModBow(ArrowType arrowType, int uses, int maxUseDuration, ResourceLocation arrowSupplier, Properties properties) {
        super(properties);
        this.arrowType = arrowType;
        this.arrowSupplier = arrowSupplier;
        this.maxUseDuration = maxUseDuration;
        unbreakable = true;

    }

    @Override
    public int getDefaultProjectileRange() {
        return (int) (super.getDefaultProjectileRange() + arrowType.getMaxDamage());
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return maxUseDuration;
    }

    private Item getArrowItem() {
        if(ForgeRegistries.ITEMS.getValue(arrowSupplier) != Items.AIR) {
            return ForgeRegistries.ITEMS.getValue(arrowSupplier);
        }else {
            return null;
        }
    }

    private boolean needsArrow(ItemStack stack) {
        if (ForgeRegistries.ITEMS.getValue(arrowSupplier) != Items.AIR) {
            if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0) {
                return false; // bow has Infinity enchantment, no ammo needed
            } else {
                return true; // bow doesn't have Infinity enchantment, ammo needed
            }
        } else {
            return false; // no arrow supplier, no ammo needed
        }
    }

    @Override
    public AbstractArrow customArrow(AbstractArrow arrow) {
        return new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), arrow.level, arrowType, arrow.xo, arrow.yo, arrow.zo);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.bowDam(arrowType.getMinDamage() + "-" + arrowType.getMaxDamage()));
        double speed = (double) DEFAULT_MAX_USE_DURATION / (double) getUseDuration(stack);
        if (speed > 1)
            tooltip.add(LocalizeUtils.i18n("tooltip.bow_speed.faster", String.format("%s", speed)));
        if (speed < 1)
            tooltip.add(LocalizeUtils.i18n("tooltip.bow_speed.slower", String.format("%s", 1 / speed)));
        tooltip.add(!unbreakable ? LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()) :
                LocalizeUtils.infiniteUses());
        if (arrowType.getArrowSpecial() == ArrowType.ArrowSpecial.POSION)
            tooltip.add(LocalizeUtils.poison(2));
        if (arrowType.getArrowSpecial() == ArrowType.ArrowSpecial.FLAME)
            tooltip.add(LocalizeUtils.burn(12));
        if (arrowType.getArrowSpecial() == ArrowType.ArrowSpecial.EXPLODE)
            tooltip.add(LocalizeUtils.explosiveShots());
        tooltip.add(this.needsArrow(stack) ? LocalizeUtils.ammo(getArrowItem()) : LocalizeUtils.infiniteAmmo());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        boolean hasAmmo = (!needsArrow(itemstack) || !this.findAmmunition(player).isEmpty());

        InteractionResultHolder<ItemStack> ret = ForgeEventFactory.onArrowNock(itemstack, world, player, hand, hasAmmo);
        if (ret != null) return ret;

        if (!player.abilities.instabuild && !hasAmmo) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    @Override
    public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
        RandomSource random = worldIn.getRandom();
        if (entityLiving instanceof Player) {
            Player entityplayer = (Player) entityLiving;
            boolean infiniteAmmo = !needsArrow(stack) || entityplayer.isCreative()
                    || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY_ARROWS, entityLiving) > 0;
            ItemStack itemstack = this.findAmmunition(entityplayer);

            int charge = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer,
                    this.maxUseDuration - timeLeft, !itemstack.isEmpty() || infiniteAmmo);
            if (charge < 0)
                return;

            if (!itemstack.isEmpty() || infiniteAmmo) {
                float f = getScaledArrowVelocity(charge);
                if ((double) f >= 0.1D) {
                    if (!worldIn.isClientSide) {
                        EntityDivineArrow entityarrow = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), worldIn, arrowType, entityplayer);
                        entityarrow.setAmmoItem(getArrowItem(), infiniteAmmo);
                        entityarrow.shootFromRotation(entityplayer, entityplayer.xRot, entityplayer.yRot, 0.0F,
                                f * 3.0F, 1.0F);
                        if (f == 1.0F) {
                            entityarrow.setIsCritical(true);
                        }
                        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER_ARROWS, entityLiving);
                        if (j > 0) {
                            entityarrow.setDamage(entityarrow.getDamage() + (double) j * 0.5D + 0.5D);
                        }
                        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH_ARROWS, entityLiving);
                        if (k > 0) {
                            entityarrow.setKnockback(k);
                        }
                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAMING_ARROWS, entityLiving) > 0) {
                            entityarrow.setSecondsOnFire(100);
                        }
                        if (!unbreakable)
                            stack.hurtAndBreak(1, entityplayer, (p_220009_1_) -> {
                                p_220009_1_.broadcastBreakEvent(entityplayer.getUsedItemHand());
                            });
                        worldIn.addFreshEntity(entityarrow);
                    }
                    worldIn.playSound(null, entityplayer.xo, entityplayer.yo, entityplayer.zo,
                            this.shootSound, SoundSource.MASTER, 1.0F,
                            1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!infiniteAmmo) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            entityplayer.inventory.removeItem(itemstack);
                        }
                    }
                    entityplayer.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public float getScaledArrowVelocity(int charge) {
        float timeRatio = ((float) DEFAULT_MAX_USE_DURATION / (float) this.maxUseDuration);
        float f = ((float) charge / 20.0F) * timeRatio;
        f = (f * f + f * 2.0F) / 3.0F;

        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    protected boolean isArrow(ItemStack stack) {
        return stack.getItem() == getArrowItem();
    }

    /**
     * Copied from ItemBow class to avoid illegal access errors with recommended Forge.
     * Name changed from findAmmo to findAmmunition as a defensive measure.
     *
     * @param player the player using this bow
     * @return the stack of this bow's ammunition item
     */
    private ItemStack findAmmunition(Player player) {
        if (this.isArrow(player.getItemInHand(InteractionHand.OFF_HAND))) {
            return player.getItemInHand(InteractionHand.OFF_HAND);
        } else if (this.isArrow(player.getItemInHand(InteractionHand.MAIN_HAND))) {
            return player.getItemInHand(InteractionHand.MAIN_HAND);
        } else {
            for (int i = 0; i < player.inventory.getContainerSize(); ++i) {
                ItemStack itemstack = player.inventory.getItem(i);
                if (this.isArrow(itemstack)) {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return this.getMaxStackSize(stack) == 1
                && (stack.getMaxDamage() < 0 || this.getMaxStackSize(stack) == 1);
    }

    public ItemModBow setSound(net.minecraft.sounds.SoundEvent shootSound) {
        this.shootSound = shootSound;
        return this;
    }
}