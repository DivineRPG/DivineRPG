package divinerpg.objects.blocks;

import divinerpg.enums.EnumBlockType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockBeaconBase extends BlockMod {

    public BlockBeaconBase(String name, float hardness) {
        super(EnumBlockType.ROCK, name, hardness);
    }

    public BlockBeaconBase(EnumBlockType blockType, String name, float hardness, int harvest) {
        super(blockType, name, hardness, harvest);
    }

    @Override
    public boolean isBeaconBase(IBlockAccess world, BlockPos pos, BlockPos beacon){
        return true;
    }
}
