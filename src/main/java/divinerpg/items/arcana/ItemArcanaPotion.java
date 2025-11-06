package divinerpg.items.arcana;

import divinerpg.attachments.Arcana;
import divinerpg.items.base.ItemModFood;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.OnlyIn;
import java.util.List;

import static net.minecraft.advancements.CriteriaTriggers.CONSUME_ITEM;
import static net.minecraft.stats.Stats.ITEM_USED;
import static net.minecraft.world.item.Items.GLASS_BOTTLE;
import static net.neoforged.api.distmarker.Dist.CLIENT;

public class ItemArcanaPotion extends ItemModFood {
    protected int amountToAdd;
    public ItemArcanaPotion(FoodProperties food, int amountToAdd) {
        super(false, GLASS_BOTTLE, food);
        this.amountToAdd = amountToAdd;
    }
    @Override public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        if(entityLiving instanceof ServerPlayer player) {
            CONSUME_ITEM.trigger(player, stack);
            player.awardStat(ITEM_USED.get(this));
            stack.consume(1, player);
        } if(!level.isClientSide) {
            if(Arcana.hasArcana(entityLiving)) Arcana.modifyAmount(entityLiving, amountToAdd);
            if(stack.isEmpty()) return new ItemStack(Items.GLASS_BOTTLE);
            else if(entityLiving instanceof Player player && !player.hasInfiniteMaterials()) {
                ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
                if(!player.getInventory().add(itemstack)) player.drop(itemstack, false);
            }
        } return stack;
    }
    @Override public UseAnim getUseAnimation(ItemStack stack) {return UseAnim.DRINK;}
    @Override public boolean isFoil(ItemStack stack) {return true;}
    @OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaRegen(amountToAdd));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}