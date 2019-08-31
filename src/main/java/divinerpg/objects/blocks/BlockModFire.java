package divinerpg.objects.blocks;

import java.util.Random;

import divinerpg.Config;
import divinerpg.DivineRPG;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import divinerpg.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockModFire extends BlockFire implements IHasModel {

    public BlockModFire(String name) {
        super();
        setLightLevel(1.0F);
        setCreativeTab(null);
        setUnlocalizedName(name);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    protected boolean canNeighborBurn(World world, BlockPos pos) {
        return false;
    }

    protected void lightPortal(World world, BlockPos pos, IBlockState state) {
        if (this == ModBlocks.blueFire) {
            if ((ModBlocks.edenPortal.makePortal(world, pos) || ModBlocks.wildwoodPortal.makePortal(world, pos)
                    || ModBlocks.apalachiaPortal.makePortal(world, pos)
                    || ModBlocks.skythernPortal.makePortal(world, pos) || ModBlocks.mortumPortal.makePortal(world, pos))
                    && Config.debug) {
                DivineRPG.logger.info("Twilight portal created");
            }
        } else {
            if (ModBlocks.iceikaPortal.makePortal(world, pos) && Config.debug) {
                DivineRPG.logger.info("Iceika portal created");
            }
        }
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        lightPortal(world, pos, state);
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
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