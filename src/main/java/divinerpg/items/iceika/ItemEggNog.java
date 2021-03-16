package divinerpg.items.iceika;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemModFood;
import divinerpg.util.FoodList;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemEggNog extends ItemModFood {

    public ItemEggNog(String name) {
        super(name, new Item.Properties().tab(DivineRPG.tabs.food).food(FoodList.EGG_NOG).stacksTo(1), FoodList.EGG_NOG);
    }

    public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isClientSide)
            entityLiving.curePotionEffects(stack); // FORGE - move up so stack.shrink does not turn stack into air

        if (entityLiving instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entityLiving;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
            serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
            serverplayerentity.getFoodData().eat(4, 1.5F);
        }

        if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).isCreative()) {
            stack.shrink(1);
        }

        return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
    }

    @Override
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return DrinkHelper.useDrink(worldIn, playerIn, handIn);
    }

}