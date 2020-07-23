package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModDoubleCrop;
import divinerpg.registry.BlockRegistry;
import divinerpg.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockStackPlant extends BlockModDoubleCrop {
    public BlockStackPlant(String name) {
        super(name);
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState state = worldIn.getBlockState(pos.down());
        Block block = state.getBlock();
        return block == this || (block == BlockRegistry.arcaniteGrass
                && Utils.bordersTar(worldIn, pos.getX(), pos.getY() - 1, pos.getZ()));
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return net.minecraftforge.common.EnumPlantType.Beach;
    }
}
