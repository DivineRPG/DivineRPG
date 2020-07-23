package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockModFluid extends BlockFluidClassic {
    public BlockModFluid(String name, Fluid fluid, Material material) {
        super(fluid, material);
        setUnlocalizedName(name);
        setRegistryName(DivineRPG.MODID, name);
    }

    @Override
    @Deprecated
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
}