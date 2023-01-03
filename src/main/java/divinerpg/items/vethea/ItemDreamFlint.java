package divinerpg.items.vethea;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModPortal;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDreamFlint extends ItemVethean {
	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		MutableBlockPos pos = context.getClickedPos().mutable();
		Block mortumBlock = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_block"));
		if(world.getBlockState(pos).is(mortumBlock)) {
			boolean northSouth = world.getBlockState(pos.above().north()).is(mortumBlock);
			if(!northSouth && !world.getBlockState(pos.above().east()).is(mortumBlock)) return InteractionResult.PASS;
			while(pos.getY() < world.getMaxBuildHeight() && world.getBlockState(pos.move(Direction.UP)).isAir()) {
				MutableBlockPos search = pos.mutable();
				if(northSouth) {
					for(int i = 0; !world.getBlockState(search.move(Direction.NORTH)).is(mortumBlock); i++) if(i > 1) return InteractionResult.PASS;
					search = pos.mutable();
					for(int i = 0; !world.getBlockState(search.move(Direction.SOUTH)).is(mortumBlock); i++) if(i > 1) return InteractionResult.PASS;
				} else {
					for(int i = 0; !world.getBlockState(search.move(Direction.EAST)).is(mortumBlock); i++) if(i > 1) return InteractionResult.PASS;
					search = pos.mutable();
					for(int i = 0; !world.getBlockState(search.move(Direction.WEST)).is(mortumBlock); i++) if(i > 1) return InteractionResult.PASS;
				}
			} if(world.getBlockState(pos).is(mortumBlock)) {
				BlockState portal = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "vethea_portal")).defaultBlockState().setValue(BlockModPortal.AXIS, northSouth ? Axis.Z : Axis.X);
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
				} if(!context.getPlayer().isCreative()) {
					ItemStack flint = context.getItemInHand();
					flint.setCount(context.getItemInHand().getCount() - 1);
					context.getPlayer().setItemInHand(context.getHand(), flint);
				}
				context.getPlayer().playSound(SoundEvents.FLINTANDSTEEL_USE, 1F, 1F);
				return InteractionResult.SUCCESS;
			}
		} return InteractionResult.PASS;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(LocalizeUtils.i18n("tooltip.divinerpg.dream_flint"));
	}
}