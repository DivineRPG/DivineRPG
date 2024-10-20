package divinerpg.items.base;

import divinerpg.entities.projectile.EntityDivineArrow;
import divinerpg.enums.ArrowType;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.api.distmarker.*;
import java.util.List;
import java.util.Optional;

public class ItemModBow extends BowItem {
    public static final int DEFAULT_MAX_USE_DURATION = 72000;
    protected ArrowType arrowType;
    protected int maxUseDuration;
    protected Item arrowSupplier;
    public Optional<Integer> nameColor;
    //No rarity, custom use duration
    public ItemModBow(ArrowType arrowType, int uses, int maxUseDuration) {
        super(new Properties().durability(uses));
        this.arrowType = arrowType;
        this.arrowSupplier = arrowType.getArrowSupplier();
        this.maxUseDuration = maxUseDuration;
    }
    //Have rarity, custom use duration
    public ItemModBow(int nameColor, ArrowType arrowType, int uses, int maxUseDuration) {
        super(new Properties().durability(uses));
        this.arrowType = arrowType;
        this.arrowSupplier = arrowType.getArrowSupplier();
        this.maxUseDuration = maxUseDuration;
        this.nameColor = Optional.of(nameColor);
    }
    //No rarity, default use duration
    public ItemModBow(ArrowType arrowType, int uses) {this(arrowType, uses, DEFAULT_MAX_USE_DURATION);}
    //Have rarity, default use duration
    public ItemModBow(int nameColor, ArrowType arrowType, int uses) {this(nameColor, arrowType, uses, DEFAULT_MAX_USE_DURATION);}
    //Fire-resistant bows
    public ItemModBow(ArrowType arrowType, int maxUseDuration, Properties properties) {
        super(properties);
        this.arrowType = arrowType;
        this.arrowSupplier = arrowType.getArrowSupplier();
        this.maxUseDuration = maxUseDuration;
    }
    @Override public int getUseDuration(ItemStack stack, LivingEntity entity) {return maxUseDuration;}
    @SuppressWarnings("unchecked")
	public boolean needsArrow(ItemStack stack, Level level) {
        if(arrowSupplier != null) return stack.getEnchantmentLevel(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.INFINITY)) <= 0;
        else return false;
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        boolean hasAmmo = (!needsArrow(stack, level) || !findAmmunition(player).isEmpty());
        InteractionResultHolder<ItemStack> ret = EventHooks.onArrowNock(stack, level, player, hand, hasAmmo);
        if(ret != null) return ret;
        if(!player.isCreative() && !hasAmmo) return InteractionResultHolder.fail(stack);
        else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(stack);
        }
    }
    @Override public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        RandomSource random = level.getRandom();
        if(entityLiving instanceof Player player) {
            boolean infiniteAmmo = !needsArrow(stack, level) || player.isCreative() || EnchantmentHelper.getEnchantmentLevel(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.INFINITY), entityLiving) > 0;
            ItemStack itemstack = findAmmunition(player);
            int charge = EventHooks.onArrowLoose(stack, level, player, maxUseDuration - timeLeft, !itemstack.isEmpty() || infiniteAmmo);
            if(charge < 0) return;
            if(!itemstack.isEmpty() || infiniteAmmo) {
                float f = getScaledArrowVelocity(charge);
                if(f >= .1) {
                    if(!level.isClientSide) {
                        AbstractArrow arrow = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), level, arrowType, player);
                        arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, f * 3, 1);
                        if(f == 1) arrow.setCritArrow(true);
                        int j = EnchantmentHelper.getEnchantmentLevel(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.POWER), entityLiving);
                        if(j > 0) arrow.setBaseDamage(arrow.getBaseDamage() + (double)j * .5 + .5);
//                        int k = EnchantmentHelper.getEnchantmentLevel(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.PUNCH), entityLiving);
//                        if(k > 0) arrow.setKnockback(k);
                        if(EnchantmentHelper.getEnchantmentLevel(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.FLAME), entityLiving) > 0) {arrow.igniteForSeconds(100);}
                        if(!player.isCreative()) stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
                        if(infiniteAmmo) {arrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;}
                        level.addFreshEntity(arrow);
                    } level.playSound(null, player.xo, player.yo, player.zo, SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1, 1 / (random.nextFloat() * .4F + 1.2F) + f * .5F);
                    if(!infiniteAmmo) {
                        itemstack.shrink(1);
                        if(itemstack.isEmpty()) player.getInventory().removeItem(itemstack);
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
        else for(int i = 0; i < player.getInventory().getContainerSize(); ++i) {
            ItemStack stack = player.getInventory().getItem(i);
            if(isArrow(stack)) return stack;
        } return ItemStack.EMPTY;
    }
    @Override public boolean isEnchantable(ItemStack stack) {return stack.isDamageableItem();}
//    @Override public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
//        if(arrowType.getArrowSpecial() == ArrowType.ArrowSpecial.FLAME && enchantment == Enchantments.FLAME
//                || !needsArrow(stack) && enchantment == Enchantments.INFINITY) return false;
//        else return enchantment.category.canEnchant(stack.getItem());
//    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam((int)arrowType.getBaseDamage() + "-" + (int)(arrowType.getBaseDamage() * 4 + 3)));
        int speed = DEFAULT_MAX_USE_DURATION / maxUseDuration;
        if(speed > 1) tooltip.add(LocalizeUtils.i18n(ChatFormatting.DARK_GREEN, "bow_speed.faster", String.format("%s", speed)));
        if(speed < 1) tooltip.add(LocalizeUtils.i18n(ChatFormatting.RED, "bow_speed.slower", String.format("%s", 1 / speed)));
        if(arrowType.getArrowSpecial() == ArrowType.ArrowSpecial.POISON) tooltip.add(LocalizeUtils.poison(arrowType.effectSec));
        if(arrowType.getArrowSpecial() == ArrowType.ArrowSpecial.FLAME) tooltip.add(LocalizeUtils.burn(arrowType.effectSec));
        if(arrowType.getArrowSpecial() == ArrowType.ArrowSpecial.EXPLODE) tooltip.add(LocalizeUtils.explosiveShots());
        //TODO - re-add infinity check
//        tooltip.add(needsArrow(stack) ? LocalizeUtils.ammo(arrowSupplier) : LocalizeUtils.infiniteAmmo());
        if(stack.getMaxDamage() == 0) stack.set(DataComponents.UNBREAKABLE, new Unbreakable(true));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
    @Override
    public Component getName(ItemStack pStack) {
    	return nameColor != null && nameColor.isPresent() ? ((MutableComponent) super.getName(pStack)).withColor(nameColor.get()) : super.getName(pStack);
    }
}