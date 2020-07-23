package divinerpg.objects.blocks.vanilla;

import divinerpg.objects.blocks.tile.entity.TileEntityAyeracoSpawn;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAyeracoSpawn extends BlockContainer {

    public BlockAyeracoSpawn() {
        super(Material.FIRE);
        this.setLightOpacity(0);
        setResistance(6000000.0F);

        // Need to register it!
        setRegistryName("ayeraco_spawn");
        setUnlocalizedName("ayeraco_spawn");
    }

    @Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
        return true;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityAyeracoSpawn();
    }
}
