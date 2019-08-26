package divinerpg.objects.blocks.vanilla;

import java.util.Random;

import divinerpg.objects.blocks.BlockModFence;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockLightFence extends BlockModFence {
    private final boolean isOn;
    private String name;

    public BlockLightFence(MapColor mapColor, String name, boolean isOn, float hardness) {
        super(mapColor, name);
        this.name = name;
        this.isOn = isOn;
        setSoundType(SoundType.GLASS);
        setHardness(hardness);
        if (isOn) {
            this.setLightLevel(1.0F);
            setCreativeTab(null);
        }
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            if (this.isOn && !worldIn.isBlockPowered(pos)) {
                worldIn.scheduleUpdate(pos, this, 4);
            } else if (!this.isOn && worldIn.isBlockPowered(pos)) {
                if (worldIn.getBlockState(pos) == ModBlocks.redFence.getDefaultState()) {
                    worldIn.setBlockState(pos, ModBlocks.redFenceOn.getDefaultState(), 2);
                } else if (worldIn.getBlockState(pos) == ModBlocks.blueFence.getDefaultState()) {
                    worldIn.setBlockState(pos, ModBlocks.blueFenceOn.getDefaultState(), 2);
                } else if (worldIn.getBlockState(pos) == ModBlocks.greenFence.getDefaultState()) {
                    worldIn.setBlockState(pos, ModBlocks.greenFenceOn.getDefaultState(), 2);
                }
            }
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if (!worldIn.isRemote) {
            if (this.isOn && !worldIn.isBlockPowered(pos)) {
                worldIn.scheduleUpdate(pos, this, 4);
            } else if (!this.isOn && worldIn.isBlockPowered(pos)) {
                if (worldIn.getBlockState(pos) == ModBlocks.redFence.getDefaultState()) {
                    worldIn.setBlockState(pos, ModBlocks.redFenceOn.getDefaultState(), 2);
                } else if (worldIn.getBlockState(pos) == ModBlocks.blueFence.getDefaultState()) {
                    worldIn.setBlockState(pos, ModBlocks.blueFenceOn.getDefaultState(), 2);
                } else if (worldIn.getBlockState(pos) == ModBlocks.greenFence.getDefaultState()) {
                    worldIn.setBlockState(pos, ModBlocks.greenFenceOn.getDefaultState(), 2);
                }
            }
        }
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            if (this.isOn && !worldIn.isBlockPowered(pos)) {
                if (worldIn.getBlockState(pos) == ModBlocks.redFenceOn.getDefaultState()) {
                    worldIn.setBlockState(pos, ModBlocks.redFence.getDefaultState(), 2);
                } else if (worldIn.getBlockState(pos) == ModBlocks.blueFenceOn.getDefaultState()) {
                    worldIn.setBlockState(pos, ModBlocks.blueFence.getDefaultState(), 2);
                } else if (worldIn.getBlockState(pos) == ModBlocks.greenFenceOn.getDefaultState()) {
                    worldIn.setBlockState(pos, ModBlocks.greenFence.getDefaultState(), 2);
                }
            }
        }
    }

    public Item getItem(World w, int i, int j, int k) {
        return Item.getItemFromBlock(this);
    }
}