package divinerpg.items.base;

import divinerpg.entities.projectile.EntityDivineArrow;
import divinerpg.enums.ArrowType;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
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
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.event.ForgeEventFactory;
import javax.annotation.Nullable;
import java.util.List;

public class ItemModBow extends BowItem {
    public static final int DEFAULT_MAX_USE_DURATION = 72000;
    protected ArrowType arrowType;
    protected int maxUseDuration;
    protected Item arrowSupplier;
    //No rarity, custom use duration
    public ItemModBow(ArrowType arrowType, int uses, int maxUseDuration) {
        super(new Properties().durability(uses));
        this.arrowType = arrowType;
        this.arrowSupplier = arrowType.getArrowSupplier();
        this.maxUseDuration = maxUseDuration;
    }
    //Have rarity, custom use duration
    public ItemModBow(Rarity rarity, ArrowType arrowType, int uses, int maxUseDuration) {
        super(new Properties().durability(uses).rarity(rarity));
        this.arrowType = arrowType;
        this.arrowSupplier = arrowType.getArrowSupplier();
        this.maxUseDuration = maxUseDuration;
    }
    //No rarity, default use duration
    public ItemModBow(ArrowType arrowType, int uses) {this(arrowType, uses, DEFAULT_MAX_USE_DURATION);}
    //Have rarity, default use duration
    public ItemModBow(Rarity rarity, ArrowType arrowType, int uses) {this(rarity, arrowType, uses, DEFAULT_MAX_USE_DURATION);}
    //Fire-resistant bows
    public ItemModBow(ArrowType arrowType, int maxUseDuration, Properties properties) {
        super(properties);
        this.arrowType = arrowType;
        this.arrowSupplier = arrowType.getArrowSupplier();
        this.maxUseDuration = maxUseDuration;
    }
    @Override public int getUseDuration(ItemStack stack) {return maxUseDuration;}
    public boolean needsArrow(ItemStack stack) {
        if(arrowSupplier != null) return stack.getEnchantmentLevel(Enchantments.INFINITY_ARROWS) <= 0;
        else return false;
    }
    @Override public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        boolean hasAmmo = (!needsArrow(stack) || !findAmmunition(player).isEmpty());
        InteractionResultHolder<ItemStack> ret = ForgeEventFactory.onArrowNock(stack, world, player, hand, hasAmmo);
        if(ret != null) return ret;
        if(!player.isCreative() && !hasAmmo) return InteractionResultHolder.fail(stack);
        else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(stack);
        }
    }
    @Override public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
        RandomSource random = worldIn.getRandom();
        if(entityLiving instanceof Player player) {
            boolean infiniteAmmo = !needsArrow(stack) || player.isCreative() || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY_ARROWS, entityLiving) > 0;
            ItemStack itemstack = findAmmunition(player);
            int charge = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, player, maxUseDuration - timeLeft, !itemstack.isEmpty() || infiniteAmmo);
            if(charge < 0) return;
            if(!itemstack.isEmpty() || infiniteAmmo) {
                float f = getScaledArrowVelocity(charge);
                if(f >= .1) {
                    if(!worldIn.isClientSide) {
                        AbstractArrow arrow = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), worldIn, arrowType, player);
                        arrow.shootFromRotation(player, player.xRot, player.yRot, 0, f * 3, 1);
                        if(f == 1) arrow.setCritArrow(true);
                        int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
                        if(j > 0) arrow.setBaseDamage(arrow.getBaseDamage() + (double)j * .5 + .5);
                        int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
                        if(k > 0) arrow.setKnockback(k);
                        if(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) {arrow.setSecondsOnFire(100);}
                        if(!player.isCreative()) stack.hurtAndBreak(1, player, (ctx) -> ctx.broadcastBreakEvent(player.getUsedItemHand()));
                        if(infiniteAmmo) {arrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;}
                        worldIn.addFreshEntity(arrow);
                    } worldIn.playSound(null, player.xo, player.yo, player.zo, SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1, 1 / (random.nextFloat() * .4F + 1.2F) + f * .5F);
                    if(!infiniteAmmo) {
                        itemstack.shrink(1);
                        if(itemstack.isEmpty()) player.inventory.removeItem(itemstack);
                    } player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }
    public float getScaledArrowVelocity(int charge) {
        float timeRatio = ((float)DEFAULT_MAX_USE_DURATION / (float)maxUseDuration);
        float f = ((float)charge / 20) * timeRatio;
        f = (f * f + f * 2) / 3;
        if(f > 1) f = 1;
        return f;
    }
    protected boolean isArrow(ItemStack stack) {return stack.getItem() == arrowSupplier;}
    /**
     * Copied from ItemBow class to avoid illegal access errors with recommended Forge.
     * Name changed from findAmmo to findAmmunition as a defensive measure.
     *
     * @param player the player using this bow
     * @return the stack of this bow's ammunition item
     */
    private ItemStack findAmmunition(Player player) {
        if(isArrow(player.getItemInHand(InteractionHand.OFF_HAND))) return player.getItemInHand(InteractionHand.OFF_HAND);
        else if(isArrow(player.getItemInHand(InteractionHand.MAIN_HAND))) return player.getItemInHand(InteractionHand.MAIN_HAND);
        else for(int i = 0; i < player.inventory.getContainerSize(); ++i) {
            ItemStack stack = player.inventory.getItem(i);
            if(isArrow(stack)) return stack;
        } return ItemStack.EMPTY;
    }
    @Override public boolean isEnchantable(ItemStack stack) {return canBeDepleted();}
    @Override public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if(arrowType.getArrowSpecial() == ArrowType.ArrowSpecial.FLAME && enchantment == Enchantments.FLAMING_ARROWS
        || !needsArrow(stack) && enchantment == Enchantments.INFINITY_ARROWS) return false;
        else return enchantment.category.canEnchant(stack.getItem());
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam((int)arrowType.getBaseDamage() + "-" + (int)(arrowType.getBaseDamage() * 4 + 3)));
        int speed = DEFAULT_MAX_USE_DURATION / getUseDuration(stack);
        if(speed > 1) tooltip.add(LocalizeUtils.i18n(ChatFormatting.DARK_GREEN, "bow_speed.faster", String.format("%s", speed)));
        if(speed < 1) tooltip.add(LocalizeUtils.i18n(ChatFormatting.RED, "bow_speed.slower", String.format("%s", 1 / speed)));
        if(arrowType.getArrowSpecial() == ArrowType.ArrowSpecial.POISON) tooltip.add(LocalizeUtils.poison(arrowType.effectSec));
        if(arrowType.getArrowSpecial() == ArrowType.ArrowSpecial.FLAME) tooltip.add(LocalizeUtils.burn(arrowType.effectSec));
        if(arrowType.getArrowSpecial() == ArrowType.ArrowSpecial.EXPLODE) tooltip.add(LocalizeUtils.explosiveShots());
        tooltip.add(needsArrow(stack) ? LocalizeUtils.ammo(arrowSupplier) : LocalizeUtils.infiniteAmmo());
        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}