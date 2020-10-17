package divinerpg.blocks.arcana;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;

public class BlockElevantium extends BlockMod {

    protected static final VoxelShape ELEVANTIUM = VoxelShapes.or(Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D), Block.makeCuboidShape(4.0D, 1.0D, 4.0D, 12.0D, 2.0D, 12.0D));

    public BlockElevantium(String name) {
        super(name, Block.Properties.create(Material.IRON, MaterialColor.LIME)
                .func_235861_h_()
                .hardnessAndResistance(3.0F, 20.0F)
                .tickRandomly()
                .sound(SoundType.WOOD));
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.setMotion(entityIn.getMotion().x, 1, entityIn.getMotion().z);
        entityIn.fallDistance = 0;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return ELEVANTIUM;
    }
}
