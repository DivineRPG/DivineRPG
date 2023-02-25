package divinerpg.items.iceika;

import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import net.minecraft.advancements.*;
import net.minecraft.server.level.*;
import net.minecraft.stats.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

public class ItemEggNog extends ItemModFood {

    public ItemEggNog() {
        super(new Item.Properties().tab(DivineRPG.tabs.food).food(FoodList.EGG_NOG).stacksTo(1), FoodList.EGG_NOG);
    }

    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        if (!worldIn.isClientSide)
            entityLiving.curePotionEffects(stack);

        if (entityLiving instanceof ServerPlayer) {
            ServerPlayer serverplayerentity = (ServerPlayer) entityLiving;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
            serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
            serverplayerentity.getFoodData().eat(4, 1.5F);
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

    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        return ItemUtils.startUsingInstantly(worldIn, playerIn, handIn);
    }

}