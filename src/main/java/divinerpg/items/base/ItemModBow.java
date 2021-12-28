package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.entities.projectile.EntityDivineArrow;
import divinerpg.enums.ArrowType;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class ItemModBow extends BowItem {
    private net.minecraft.util.SoundEvent shootSound = SoundEvents.ARROW_SHOOT;
    public static final int DEFAULT_MAX_USE_DURATION = 72000;
    protected ArrowType arrowType;
    protected int maxUseDuration;
    protected boolean unbreakable;
    protected Supplier<Item> arrowSupplier;

    public ItemModBow(String name, Rarity rarity, ArrowType arrowType, int uses, Supplier<Item> arrowSupplier) {
        this(name, rarity, arrowType, uses, DEFAULT_MAX_USE_DURATION, arrowSupplier);
    }

    public ItemModBow(String name, ArrowType arrowType, int uses, Supplier<Item> arrowSupplier, Properties properties) {
        this(name, arrowType, uses, DEFAULT_MAX_USE_DURATION, arrowSupplier, properties);
    }


    public ItemModBow(String name, Rarity rarity, ArrowType arrowType, int uses) {
        this(name, rarity, arrowType, uses, DEFAULT_MAX_USE_DURATION, () -> null);
    }

    public ItemModBow(String name, Rarity rarity, ArrowType arrowType, int uses, int maxUseDuration) {
        this(name, rarity, arrowType, uses, maxUseDuration, () -> null);
    }

    public ItemModBow(String name, Rarity rarity, ArrowType arrowType, int uses, int maxUseDuration, Supplier<Item> arrowSupplier) {
        super(new Properties().tab(DivineRPG.tabs.ranged).durability(uses).rarity(rarity));
        this.setRegistryName(DivineRPG.MODID, name);
        this.arrowType = arrowType;
        this.arrowSupplier = arrowSupplier;
        this.maxUseDuration = maxUseDuration;
        unbreakable = true;

    }

    public ItemModBow(String name, ArrowType arrowType, int uses, int maxUseDuration, Supplier<Item> arrowSupplier, Properties properties) {
        super(properties);
        this.setRegistryName(DivineRPG.MODID, name);
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
        return this.arrowSupplier.get();
    }

    private boolean needsArrow() {
        return this.arrowSupplier.get() != null;
    }

    @Override
    public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
        return new EntityDivineArrow(EntityRegistry.ARROW_SHOT, arrow.level, arrowType, arrow.xo, arrow.yo, arrow.zo);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
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
        tooltip.add(this.needsArrow() ? LocalizeUtils.ammo(getArrowItem()) : LocalizeUtils.infiniteAmmo());
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        boolean hasAmmo = (!needsArrow() || !this.findAmmunition(player).isEmpty());

        ActionResult<ItemStack> ret = ForgeEventFactory.onArrowNock(itemstack, world, player, hand, hasAmmo);
        if (ret != null) return ret;

        if (!player.abilities.instabuild && !hasAmmo) {
            return ActionResult.fail(itemstack);
        } else {
            player.startUsingItem(hand);
            return ActionResult.consume(itemstack);
        }
    }

    @Override
    public void releaseUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity entityplayer = (PlayerEntity) entityLiving;
            boolean infiniteAmmo = !needsArrow() || entityplayer.isCreative()
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
                        EntityDivineArrow entityarrow = new EntityDivineArrow(EntityRegistry.ARROW_SHOT, worldIn, arrowType, entityplayer);
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
                            this.shootSound, SoundCategory.MASTER, 1.0F,
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
    private ItemStack findAmmunition(PlayerEntity player) {
        if (this.isArrow(player.getItemInHand(Hand.OFF_HAND))) {
            return player.getItemInHand(Hand.OFF_HAND);
        } else if (this.isArrow(player.getItemInHand(Hand.MAIN_HAND))) {
            return player.getItemInHand(Hand.MAIN_HAND);
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
        return this.getItemStackLimit(stack) == 1
                && (stack.getMaxDamage() < 0 || this.getItemStackLimit(stack) == 1);
    }

    public ItemModBow setSound(net.minecraft.util.SoundEvent shootSound) {
        this.shootSound = shootSound;
        return this;
    }
}