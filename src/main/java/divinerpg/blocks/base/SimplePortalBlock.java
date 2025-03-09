package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.resources.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class SimplePortalBlock extends PortalBlock {
	public SimplePortalBlock(ResourceKey<Level> rootDimension, ResourceKey<Level> chainDimension, Block frameBlock, ResourceLocation particle) {
		super(Properties.ofFullCopy(Blocks.NETHER_PORTAL), rootDimension, chainDimension, frameBlock, particle);
	}
	@Override
	public BlockPos placePortal(ServerLevel level, BlockPos pos, Axis axis) {
		return placeVanillaLookingPortal(level, pos, frameBlock.defaultBlockState(), defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, axis), axis);
	}
}