package divinerpg.items.iceika;

import divinerpg.items.base.ItemModFood;
import divinerpg.util.FoodList;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.EffectCure;

public class ItemEggNog extends ItemModFood {

    public ItemEggNog() {
        super(new Item.Properties().food(FoodList.EGG_NOG).stacksTo(1), FoodList.EGG_NOG);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        if (!worldIn.isClientSide)
            //TODO - Double check cure names
            entityLiving.removeEffectsCuredBy(EffectCure.get(stack.getDescriptionId()));

        if (entityLiving instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, stack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
            serverplayer.getFoodData().eat(4, 0.8F);
        }

        if (entityLiving instanceof Player && !((Player) entityLiving).isCreative()) {
            stack.shrink(1);
        }

        return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        return ItemUtils.startUsingInstantly(worldIn, playerIn, handIn);
    }

}
