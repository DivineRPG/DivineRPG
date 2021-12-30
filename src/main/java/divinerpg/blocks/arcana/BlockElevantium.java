package divinerpg.blocks.arcana;

import divinerpg.blocks.base.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;

public class BlockElevantium extends BlockMod {

    protected static final VoxelShape ELEVANTIUM = VoxelShapes.or(Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D), Block.box(4.0D, 1.0D, 4.0D, 12.0D, 2.0D, 12.0D));

    public BlockElevantium(String name) {
        super(name, Block.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_LIGHT_GREEN)
                .requiresCorrectToolForDrops()
                .strength(3.0F, 20.0F)
                .randomTicks()
                .jumpFactor(2)
                .sound(SoundType.WOOD));
    }

    @Override
    public void stepOn(World world, BlockPos pos, Entity entity) {
        entity.setDeltaMovement(entity.getDeltaMovement().x, 1, entity.getDeltaMovement().z);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return ELEVANTIUM;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, IBlockReader p_220071_2_, BlockPos p_220071_3_, ISelectionContext p_220071_4_) {
        return VoxelShapes.create(ELEVANTIUM.bounds().inflate(0.3D));
    }
}
