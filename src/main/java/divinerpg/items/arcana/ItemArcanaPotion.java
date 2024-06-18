package divinerpg.items.arcana;

import divinerpg.capability.ArcanaProvider;
import divinerpg.items.base.ItemModFood;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import java.util.List;

public class ItemArcanaPotion extends ItemModFood {
    protected int amountToAdd;
    public ItemArcanaPotion(FoodProperties list, int amountToAdd) {
        super(new Properties().food(list));
        this.amountToAdd = amountToAdd;
    }
    @Override public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
    	if(!worldIn.isClientSide()) {
           entityLiving.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> arcana.modifyAmount(entityLiving, amountToAdd));
           if(entityLiving instanceof ServerPlayer player) {
        	   player.awardStat(Stats.ITEM_USED.get(this));
        	   if(!player.isCreative()) stack.shrink(1);
           }
    	} return stack;
    }
    @Override public UseAnim getUseAnimation(ItemStack stack) {return UseAnim.DRINK;}
    @Override public int getUseDuration(ItemStack par1ItemStack) {return 20;}
    @Override public boolean isFoil(ItemStack stack) {return true;}
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaRegen(amountToAdd));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}