package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockModFire extends BlockFire {

    public BlockModFire(String name) {
        super();
        setLightLevel(1.0F);
        setCreativeTab(null);
        setUnlocalizedName(name);
        this.setRegistryName(DivineRPG.MODID, name);
    }

    protected boolean canNeighborBurn(World world, BlockPos pos) {
        return false;
    }

    protected void lightPortal(World world, BlockPos pos, IBlockState state) {
//    	BlockRegistry.edenPortal.makePortal(world, pos);
//    	BlockRegistry.wildwoodPortal.makePortal(world, pos);
//    	BlockRegistry.apalachiaPortal.makePortal(world, pos);
//    	BlockRegistry.skythernPortal.makePortal(world, pos);
//    	BlockRegistry.mortumPortal.makePortal(world, pos);
//    	BlockRegistry.iceikaPortal.makePortal(world, pos);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        lightPortal(world, pos, state);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        lightPortal(worldIn, pos, state);
        if (worldIn.getGameRules().getBoolean("doFireTick")) {
            if (!worldIn.isAreaLoaded(pos, 2)) {
                return;
            }
            if (!this.canPlaceBlockAt(worldIn, pos)) {
                worldIn.setBlockToAir(pos);
            }

            Block block = worldIn.getBlockState(pos.down()).getBlock();
            int i = state.getValue(AGE).intValue();

            if (worldIn.isRaining() && this.canDie(worldIn, pos) && rand.nextFloat() < 0.2F + i * 0.03F) {
                worldIn.setBlockToAir(pos);
            } else {
                if (i < 15) {
                    state = state.withProperty(AGE, Integer.valueOf(i + rand.nextInt(3) / 2));
                    worldIn.setBlockState(pos, state, 4);
                }

                worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + rand.nextInt(10));

                if (i == 15 && rand.nextInt(4) == 0) {
                    worldIn.setBlockToAir(pos);
                    return;
                }
            }
        }
    }
}