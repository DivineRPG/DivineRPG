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
        super(name, new Item.Properties().group(DivineRPG.tabs.food).food(FoodList.EGG_NOG).maxStackSize(1), FoodList.EGG_NOG);
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote)
            entityLiving.curePotionEffects(stack); // FORGE - move up so stack.shrink does not turn stack into air

        if (entityLiving instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entityLiving;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
            serverplayerentity.addStat(Stats.ITEM_USED.get(this));
            serverplayerentity.getFoodStats().addStats(4, 1.5F);
        }

        if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.isCreativeMode) {
            stack.shrink(1);
        }

        return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return DrinkHelper.startDrinking(worldIn, playerIn, handIn);
    }

}