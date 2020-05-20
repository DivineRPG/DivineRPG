package divinerpg.objects.blocks;

import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class BlockModDirt extends BlockMod {
    private MapColor mapColor;

    public BlockModDirt(String name, float hardness, @Nonnull MapColor mapColorIn) {
        super(name, hardness, Material.GROUND);
        this.setHarvestLevel("shovel", 0);
        this.setMapColor(mapColorIn);
    }

    /**
     * Defensive helper method used to intercept null map colors.
     * Private access used to force the map color to be included in the constructor.
     *
     * @param mapColorIn the map color to set
     */
    private void setMapColor(MapColor mapColorIn) {
        if (mapColorIn == null) {
            this.mapColor = Material.GROUND.getMaterialMapColor();
        } else {
            this.mapColor = mapColorIn;
        }
    }

    /**
     * Tells maps to use the map color we set.
     *
     * @param state   the blockstate
     * @param worldIn the world
     * @param pos     the block position
     * @return the map color
     */
    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return this.mapColor;
    }

}
