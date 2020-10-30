package divinerpg.blocks.base;

import divinerpg.registries.BlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BlockModFence extends FenceBlock {
    private final boolean isOn;

    public BlockModFence(MaterialColor color, String name, boolean isOn, float hardness, int luminance) {
        super(Block.Properties.create(Material.ROCK, color).notSolid().setRequiresTool().hardnessAndResistance(hardness, 3.0F).sound(SoundType.GLASS).setLightLevel((p_235464_0_) -> {
            return luminance;
        }));
        this.isOn = isOn;
        setRegistryName(name);
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!worldIn.isRemote) {
            if (this.isOn && worldIn.isBlockPowered(pos)) {
                worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
            } else if (!this.isOn && worldIn.isBlockPowered(pos)) {
                if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.redFence) {
                    worldIn.setBlockState(pos, BlockRegistry.redFenceOn.getDefaultState(), 2);
                } else if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.blueFence) {
                    worldIn.setBlockState(pos, BlockRegistry.blueFenceOn.getDefaultState(), 2);
                } else if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.greenFence) {
                    worldIn.setBlockState(pos, BlockRegistry.greenFenceOn.getDefaultState(), 2);
                }
            }
        }
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isRemote) {
            if (this.isOn && !worldIn.isBlockPowered(pos)) {
                worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
            } else if (!this.isOn && worldIn.isBlockPowered(pos)) {
                if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.redFence) {
                    worldIn.setBlockState(pos, BlockRegistry.redFenceOn.getDefaultState(), 2);
                } else if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.blueFence) {
                    worldIn.setBlockState(pos, BlockRegistry.blueFenceOn.getDefaultState(), 2);
                } else if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.greenFence) {
                    worldIn.setBlockState(pos, BlockRegistry.greenFenceOn.getDefaultState(), 2);
                }
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!worldIn.isRemote) {
            if (this.isOn && !worldIn.isBlockPowered(pos)) {
                if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.redFenceOn) {
                    worldIn.setBlockState(pos, BlockRegistry.redFence.getDefaultState(), 2);
                } else if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.blueFenceOn) {
                    worldIn.setBlockState(pos, BlockRegistry.blueFence.getDefaultState(), 2);
                } else if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.greenFenceOn) {
                    worldIn.setBlockState(pos, BlockRegistry.greenFence.getDefaultState(), 2);
                }
            }
        }
        super.tick(state, worldIn, pos, rand);
    }


}
