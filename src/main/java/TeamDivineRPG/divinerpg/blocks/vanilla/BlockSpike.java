package TeamDivineRPG.divinerpg.blocks.vanilla;

import TeamDivineRPG.divinerpg.blocks.base.BlockMod;
import TeamDivineRPG.divinerpg.util.DamageSources;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockSpike extends BlockMod {
    private final boolean isHot;
    protected static final VoxelShape collisionbox = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
    protected static final VoxelShape boundingbox = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    public BlockSpike(String name, boolean isHot) {
        super(name, 3);
        this.isHot=isHot;
    }
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return collisionbox;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return boundingbox;
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
    if(isHot){
        if(entityIn instanceof LivingEntity)
        {
            entityIn.attackEntityFrom(DamageSources.spikeSource, 8);
            entityIn.setFire(10);
        }
    }else{
        if(entityIn instanceof LivingEntity)
        {
            entityIn.attackEntityFrom(DamageSources.spikeSource, 5);
        }
    }
    }
}
