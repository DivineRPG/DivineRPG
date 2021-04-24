package divinerpg.blocks.base;

import divinerpg.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import javax.annotation.*;
import java.util.*;

public class BlockModFire extends FireBlock {

    public BlockModFire(String name) {
        super(AbstractBlock.Properties.of(Material.FIRE));
        this.setRegistryName(DivineRPG.MODID, name);
    }

    @Override
    public boolean canCatchFire(IBlockReader world, BlockPos pos, Direction face) {
        return false;
    }

    protected void lightPortal(World world, BlockPos pos, BlockState state) {
//    	BlockRegistry.edenPortal.makePortal(world, pos);
//    	BlockRegistry.wildwoodPortal.makePortal(world, pos);
//    	BlockRegistry.apalachiaPortal.makePortal(world, pos);
//    	BlockRegistry.skythernPortal.makePortal(world, pos);
//    	BlockRegistry.mortumPortal.makePortal(world, pos);
//    	BlockRegistry.iceikaPortal.makePortal(world, pos);
    }

    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity ent, ItemStack item) {
        super.setPlacedBy(world, pos, state, ent, item);
        lightPortal(world, pos, state);
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        lightPortal(worldIn, pos, state);
        if (worldIn.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            if (!worldIn.isAreaLoaded(pos, 2)) {
                return;
            }
                worldIn.removeBlock(pos, false);


            Block block = worldIn.getBlockState(pos.below()).getBlock();
            int i = state.getValue(AGE).intValue();

            if (worldIn.isRaining() && this.canSurvive(state, worldIn, pos) && rand.nextFloat() < 0.2F + i * 0.03F) {
                worldIn.removeBlock(pos, false);
            } else {
                if (i < 15) {
                    state = state.setValue(AGE, Integer.valueOf(i + rand.nextInt(3) / 2));
                    worldIn.removeBlock(pos, false);
                }
                if (i == 15 && rand.nextInt(4) == 0) {
                    worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 0);
                    return;
                }
            }
        }
    }
}