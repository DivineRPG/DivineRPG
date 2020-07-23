package divinerpg.objects.blocks.iceika;

import divinerpg.objects.blocks.BlockModLadder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockChristmasLights extends BlockModLadder {

    public BlockChristmasLights(String name) {
        super(name);
        setLightLevel(1);
    }

    @Override
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
        return false;
    }
}
