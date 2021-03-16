package divinerpg.blocks.arcana;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;

public class BlockElevantium extends BlockMod {

    protected static final VoxelShape ELEVANTIUM = VoxelShapes.or(Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D), Block.box(4.0D, 1.0D, 4.0D, 12.0D, 2.0D, 12.0D));

    public BlockElevantium(String name) {
        super(name, Block.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_LIGHT_GREEN)
                .requiresCorrectToolForDrops()
                .strength(3.0F, 20.0F)
                .randomTicks()
                .sound(SoundType.WOOD));
    }

    @Override
    public void stepOn(World world, BlockPos pos, Entity entityIn) {
        super.stepOn(world, pos, entityIn);
        entityIn.lerpMotion(entityIn.getMotionDirection().getStepX(), 1, entityIn.getMotionDirection().getStepZ());
        entityIn.fallDistance = 0;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return ELEVANTIUM;
    }
}
