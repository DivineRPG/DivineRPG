package divinerpg.items.iceika;

import divinerpg.items.base.ItemModFood;
import divinerpg.util.FoodList;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class ItemEggNog extends ItemModFood {
    public ItemEggNog() {super(new Item.Properties().food(FoodList.EGG_NOG).stacksTo(1));}
    @Override public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        Player player = (Player)entity;
        CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
        player.awardStat(Stats.ITEM_USED.get(this));
        player.getFoodData().eat(stack.getFoodProperties(entity).getNutrition(), stack.getFoodProperties(entity).getSaturationModifier());
        if(!player.isCreative()) stack.shrink(1);
        return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
    }
    @Override public UseAnim getUseAnimation(ItemStack stack) {return UseAnim.DRINK;}
}