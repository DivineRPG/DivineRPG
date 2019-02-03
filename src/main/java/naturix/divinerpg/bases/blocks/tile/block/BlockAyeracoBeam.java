package naturix.divinerpg.bases.blocks.tile.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAyeracoBeam extends BlockContainer {
    private String tex;

    public BlockAyeracoBeam(String name, String tex) {
        super(Material.FIRE);
        this.setLightOpacity(0);
        setResistance(6000000.0F);
        this.tex = tex;
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
    public TileEntity createNewTileEntity(World var1, int var2) {
        // return new TileEntityAyeracoBeam(new
        // ResourceLocation("divinerpg:textures/blocks/beam_" + tex + ".png"));
        return new TileEntityBeacon();
    }
}