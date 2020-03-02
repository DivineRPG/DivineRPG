package divinerpg.dimensions.vethea;

import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

/**
 * Overridden version of WorldGenAbstractTree to use Vethean logs, leaves, and blocks in place of overworld ones.
 */
public abstract class WorldGenVetheaTree extends WorldGenAbstractTree {

    public WorldGenVetheaTree(boolean notify) {
        super(notify);
    }

    @Override
    protected boolean canGrowInto(Block blockType) {
        Block[] logs = {
                ModBlocks.dreamwoodLog,
                ModBlocks.firewoodLog,
                ModBlocks.hyrewoodLog,
                ModBlocks.mintwoodLog
        };

        for(Block log: logs) {
            if(blockType == log) {
                return true;
            }
        }

        Material material = blockType.getDefaultState().getMaterial();
        return material == Material.AIR || material == Material.LEAVES || blockType == ModBlocks.dreamGrass || blockType == ModBlocks.dreamDirt;
    }

    @Override
    protected void setDirtAt(World worldIn, BlockPos pos) {
        if (worldIn.getBlockState(pos).getBlock() != ModBlocks.dreamDirt) {
            this.setBlockAndNotifyAdequately(worldIn, pos, ModBlocks.dreamDirt.getDefaultState());
        }
    }

    //Apparently isWood() or whatever is hardcoded to be false unless you manually override it. not going to bother with this for now
    public boolean isReplaceable(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos) || state.getBlock().isWood(world, pos) || this.canGrowInto(state.getBlock());
    }
}
