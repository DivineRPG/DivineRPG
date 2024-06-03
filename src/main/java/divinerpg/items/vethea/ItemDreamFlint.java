package divinerpg.items.vethea;

import divinerpg.blocks.base.BlockModPortal;
import divinerpg.registries.BlockRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemDreamFlint extends ItemVethean {
	public ItemDreamFlint() {super(new Properties().stacksTo(1));}
	@Override public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		MutableBlockPos pos = context.getClickedPos().mutable();
		Block mortumBlock = BlockRegistry.mortumBlock.get();
		if(world.getBlockState(pos).is(mortumBlock)) {
			boolean northSouth = world.getBlockState(pos.above().north()).is(mortumBlock);
			if(!northSouth && !world.getBlockState(pos.above().east()).is(mortumBlock)) return InteractionResult.FAIL;
			//TODO: to fix the portal blocks placement, you can create some unexpected shapes with it
			while(pos.getY() < world.getMaxBuildHeight() && world.getBlockState(pos.move(Direction.UP)).isAir()) {
				MutableBlockPos search = pos.mutable();
				if(northSouth) {
					for(int i = 0; !world.getBlockState(search.move(Direction.NORTH)).is(mortumBlock); i++) if(i > 1) return InteractionResult.FAIL;
					search = pos.mutable();
					for(int i = 0; !world.getBlockState(search.move(Direction.SOUTH)).is(mortumBlock); i++) if(i > 1) return InteractionResult.FAIL;
				} else {
					for(int i = 0; !world.getBlockState(search.move(Direction.EAST)).is(mortumBlock); i++) if(i > 1) return InteractionResult.FAIL;
					search = pos.mutable();
					for(int i = 0; !world.getBlockState(search.move(Direction.WEST)).is(mortumBlock); i++) if(i > 1) return InteractionResult.FAIL;
				}
			} if(world.getBlockState(pos).is(mortumBlock)) {
				BlockState portal = BlockRegistry.vetheaPortal.get().defaultBlockState().setValue(BlockModPortal.AXIS, northSouth ? Axis.Z : Axis.X);
				while(world.getBlockState(pos.move(Direction.DOWN)).isAir()) {
					world.setBlock(pos, portal, 2);
					MutableBlockPos place = pos.mutable();
					if(northSouth) {
						while(world.getBlockState(place.move(Direction.NORTH)).isAir()) world.setBlock(place, portal, 2);
						place = pos.mutable();
						while(world.getBlockState(place.move(Direction.SOUTH)).isAir()) world.setBlock(place, portal, 2);
					} else {
						while(world.getBlockState(place.move(Direction.EAST)).isAir()) world.setBlock(place, portal, 2);
						place = pos.mutable();
						while(world.getBlockState(place.move(Direction.WEST)).isAir()) world.setBlock(place, portal, 2);
					}
				} Player player = context.getPlayer();
				if(!player.isCreative()) context.getItemInHand().shrink(1);
				player.playSound(SoundEvents.FLINTANDSTEEL_USE, 1, 1);
				return InteractionResult.SUCCESS;
			}
		} return InteractionResult.FAIL;
	}
	@OnlyIn(Dist.CLIENT)
	@Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(LocalizeUtils.i18n("dream_flint"));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}
}