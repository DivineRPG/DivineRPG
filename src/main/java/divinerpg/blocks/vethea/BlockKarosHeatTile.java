package divinerpg.blocks.vethea;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import java.util.*;

public class BlockKarosHeatTile extends BlockModUnbreakable {
    private static final AxisAlignedBB KAROS_HEAT_TILE_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.9375D,
            0.9375D);

    public BlockKarosHeatTile(String name) {
        super(name, AbstractBlock.Properties.of(Material.STONE).randomTicks().strength(-1, 600000F));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, IBlockReader p_220071_2_, BlockPos p_220071_3_, ISelectionContext p_220071_4_) {
        return VoxelShapes.create(KAROS_HEAT_TILE_AABB);
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return VoxelShapes.create(KAROS_HEAT_TILE_AABB);
    }

    @Override
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (this == BlockRegistry.karosHeatTileRed) {
            world.setBlock(pos, BlockRegistry.karosHeatTileGreen.defaultBlockState(), 0);
        }
    }

    @Override
    public void entityInside(BlockState state, World world, BlockPos pos, Entity entityIn) {
            super.entityInside(state, world, pos, entityIn);
        if (this == BlockRegistry.karosHeatTileRed && entityIn instanceof ServerPlayerEntity) {
            entityIn.hurt(DamageSources.trapSource, 6);
            entityIn.setSecondsOnFire(5);
        }
    }


}
