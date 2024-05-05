package divinerpg.items.arcana;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.*;

public class ItemAquamarine extends BucketItem {
    public ItemAquamarine() {super(() -> Fluids.WATER, new Properties().durability(10));}
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
    	ItemStack itemstack = player.getItemInHand(hand);
    	BlockHitResult blockhitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);
	    if(blockhitresult.getType() == HitResult.Type.MISS || blockhitresult.getType() != HitResult.Type.BLOCK) return InteractionResultHolder.pass(itemstack);
        Direction direction = blockhitresult.getDirection();
        BlockPos blockpos = blockhitresult.getBlockPos(), blockpos1 = blockpos.relative(direction);
	    if(level.mayInteract(player, blockpos) && player.mayUseItemAt(blockpos1, direction, itemstack)) {
           BlockState blockstate = level.getBlockState(blockpos);
           BlockPos blockpos2 = canBlockContainFluid(level, blockpos, blockstate) ? blockpos : blockpos1;
           if(emptyContents(player, level, blockpos2, blockhitresult, itemstack)) {
              if(player instanceof ServerPlayer) CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, blockpos2, itemstack);
              player.awardStat(Stats.ITEM_USED.get(this));
              if(!player.isCreative()) {
            	  itemstack.setDamageValue(itemstack.getDamageValue() + 1);
            	  if(itemstack.getDamageValue() >= itemstack.getMaxDamage()) return InteractionResultHolder.sidedSuccess(ItemStack.EMPTY, level.isClientSide());
              } return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
           } else return InteractionResultHolder.fail(itemstack);
	    } else return InteractionResultHolder.fail(itemstack);
    }
}