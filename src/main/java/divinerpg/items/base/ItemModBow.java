package divinerpg.items.base;

import divinerpg.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraftforge.event.*;

import javax.annotation.*;
import java.util.*;
import java.util.function.*;

public class ItemModBow extends BowItem {
    private net.minecraft.util.SoundEvent shootSound = SoundEvents.ARROW_SHOOT;
    public static final int DEFAULT_MAX_USE_DURATION = 72000;
    protected ArrowType arrowType;
    protected int maxUseDuration;
    protected boolean unbreakable;
    protected Supplier<Item> arrowSupplier;

    public ItemModBow(String name, ArrowType arrowType, int uses, Supplier<Item> arrowSupplier) {
        this(name, arrowType, uses, DEFAULT_MAX_USE_DURATION, arrowSupplier);
    }

    public ItemModBow(String name, ArrowType arrowType, int uses) {
        this(name, arrowType, uses, DEFAULT_MAX_USE_DURATION, () -> null);
    }

    public ItemModBow(String name, ArrowType arrowType, int uses, int maxUseDuration) {
        this(name, arrowType, uses, maxUseDuration, () -> null);
    }

    public ItemModBow(String name, ArrowType arrowType, int uses, int maxUseDuration, Supplier<Item> arrowSupplier) {
        super(new Properties().tab(DivineRPG.tabs.ranged).durability(uses));
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
            tooltip.add(new TranslationTextComponent("tooltip.bow_speed.faster", String.format("%s", speed)));
        if (speed < 1)
            tooltip.add(new TranslationTextComponent("tooltip.bow_speed.slower", String.format("%s", 1 / speed)));
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