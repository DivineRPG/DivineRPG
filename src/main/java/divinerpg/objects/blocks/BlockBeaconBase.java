package divinerpg.objects.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockBeaconBase extends BlockMod {

    public BlockBeaconBase(String name, float hardness) {
        this(name, hardness, Material.ROCK);
    }

    public BlockBeaconBase(String name, float hardness, Material material) {
        this(name, hardness, material, 0);
    }

    public BlockBeaconBase(String name, float hardness, Material material, int harvestLevel) {
        super(name, hardness, material);
        this.setHarvestLevel("pickaxe", harvestLevel);
    }

    @Override
    public boolean isBeaconBase(IBlockAccess world, BlockPos pos, BlockPos beacon){
        return true;
    }
}
