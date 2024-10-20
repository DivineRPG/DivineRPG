package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import divinerpg.world.placement.Surface;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.Optional;

public class SimplePortalBlock extends PortalBlock {
	public final Block frameBlock;
	public SimplePortalBlock(ResourceKey<Level> rootDimension, String frameTag, Block frameBlock) {
		super(Properties.ofFullCopy(Blocks.NETHER_PORTAL), rootDimension, TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, frameTag)));
		this.frameBlock = frameBlock;
	}
	@Override
	public BlockPos placePortal(ServerLevel level, BlockPos pos, Axis axis) {
		return placeVanillaLookingPortal(level, pos, frameBlock.defaultBlockState(), defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, axis), axis);
	}
	@Override
	public BlockPos applyPlacementLocationPreference(ServerLevel level, Entity entity, BlockPos pos) {
		return new BlockPos(pos.getX(), Surface.getSurface(Surface.Surface_Type.HIGHEST_GROUND, Surface.Mode.FULL, level.getMinBuildHeight(), level.dimensionType().logicalHeight(), 0, level, level.getRandom(), pos.getX(), pos.getZ()), pos.getZ());
	}
}