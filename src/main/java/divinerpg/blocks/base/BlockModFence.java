package divinerpg.blocks.base;

import divinerpg.registries.BlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.*;
import java.util.Random;

public class BlockModFence extends FenceBlock {
    private final boolean isOn;

    public BlockModFence(MaterialColor color, String name, boolean isOn, float hardness, int luminance) {
        super(Block.Properties.of(Material.STONE, color).dynamicShape().strength(hardness, 3.0F).sound(SoundType.GLASS).lightLevel((p_235464_0_) -> {
            return luminance;
        }));
        this.isOn = isOn;
        setRegistryName(name);
    }

    @Override
    public void setPlacedBy(World worldIn, BlockPos pos, BlockState p_180633_3_, @Nullable LivingEntity p_180633_4_, ItemStack p_180633_5_) {
        if (!worldIn.isClientSide) {
            if (this.isOn && worldIn.hasNeighborSignal(pos)) {
                worldIn.getBlockTicks().scheduleTick(pos, this, 4);
            } else if (!this.isOn && worldIn.hasNeighborSignal(pos)) {
                if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.redFence) {
                    worldIn.setBlock(pos, BlockRegistry.redFenceOn.defaultBlockState(), 2);
                } else if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.blueFence) {
                    worldIn.setBlock(pos, BlockRegistry.blueFenceOn.defaultBlockState(), 2);
                } else if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.greenFence) {
                    worldIn.setBlock(pos, BlockRegistry.greenFenceOn.defaultBlockState(), 2);
                }
            }
        }
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isClientSide) {
            if (this.isOn && !worldIn.hasNeighborSignal(pos)) {
                worldIn.getBlockTicks().scheduleTick(pos, this, 4);
            } else if (!this.isOn && worldIn.hasNeighborSignal(pos)) {
                if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.redFence) {
                    worldIn.setBlock(pos, BlockRegistry.redFenceOn.defaultBlockState(), 2);
                } else if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.blueFence) {
                    worldIn.setBlock(pos, BlockRegistry.blueFenceOn.defaultBlockState(), 2);
                } else if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.greenFence) {
                    worldIn.setBlock(pos, BlockRegistry.greenFenceOn.defaultBlockState(), 2);
                }
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!worldIn.isClientSide) {
            if (this.isOn && !worldIn.hasNeighborSignal(pos)) {
                if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.redFenceOn) {
                    worldIn.setBlock(pos, BlockRegistry.redFence.defaultBlockState(), 2);
                } else if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.blueFenceOn) {
                    worldIn.setBlock(pos, BlockRegistry.blueFence.defaultBlockState(), 2);
                } else if (worldIn.getBlockState(pos).getBlock() == BlockRegistry.greenFenceOn) {
                    worldIn.setBlock(pos, BlockRegistry.greenFence.defaultBlockState(), 2);
                }
            }
        }
        super.tick(state, worldIn, pos, rand);
    }


}
