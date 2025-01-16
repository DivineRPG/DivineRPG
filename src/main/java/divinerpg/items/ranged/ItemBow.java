package divinerpg.items.ranged;

import divinerpg.util.LocalizeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.*;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ItemBow extends BowItem {
    public final int useDuration;
    public final Integer nameColor;
    public final Supplier<Item> infinityArrow;
    public final float speedScale;
    public ItemBow(Properties properties, int uses, int useDuration, float speedScale, Supplier<Item> infinityArrow, Integer nameColor) {
        super((uses == 0 ? properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true)) : properties.durability(uses)));
        this.useDuration = useDuration;
        this.nameColor = nameColor;
        this.infinityArrow = infinityArrow;
        this.speedScale = speedScale;
    }
    @Override public int getUseDuration(ItemStack stack, LivingEntity entity) {return useDuration;}
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        boolean flag = !player.getProjectile(itemstack).isEmpty();
        InteractionResultHolder<ItemStack> ret = EventHooks.onArrowNock(itemstack, level, player, hand, flag);
        if(ret != null) return ret;
        else if(infinityArrow == null && !player.hasInfiniteMaterials() && !flag) return InteractionResultHolder.fail(itemstack);
        else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }
    }
    @Override public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if(entityLiving instanceof Player player) {
            ItemStack itemstack = player.getProjectile(stack);
            if(infinityArrow != null && (itemstack.isEmpty() || itemstack.is(infinityArrow.get()))) itemstack = new ItemStack(infinityArrow.get());
            if(itemstack.isEmpty()) return;
            int i = EventHooks.onArrowLoose(stack, level, player, (getUseDuration(stack, entityLiving) - timeLeft) * 72000 / useDuration, true);
            if(i < 0) return;
            float f = getPowerForTime(i);
            if(f >= .1F) {
                List<ItemStack> list = draw(stack, itemstack, player);
                if(level instanceof ServerLevel serverlevel && !list.isEmpty()) shoot(serverlevel, player, player.getUsedItemHand(), stack, list, f * 3F * speedScale, 1, f == 1, null);
                level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1, 1 / (level.getRandom().nextFloat() * .4F + 1.2F) + f * .5F);
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }
    @Override public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(infinityArrow == null ? Items.ARROW : infinityArrow.get());
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        float speed = 72000F / useDuration;
        if(speed > 1) tooltip.add(LocalizeUtils.i18n(ChatFormatting.DARK_GREEN, "bow_speed.faster", String.format("%s", speed)));
        if(speed < 1) tooltip.add(LocalizeUtils.i18n(ChatFormatting.RED, "bow_speed.slower", String.format("%s", 1 / speed)));
        if(infinityArrow != null) tooltip.add(LocalizeUtils.infiniteAmmo());
        tooltip.add(LocalizeUtils.shootingPower(speedScale));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
    @Override public Component getName(ItemStack pStack) {
        return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}