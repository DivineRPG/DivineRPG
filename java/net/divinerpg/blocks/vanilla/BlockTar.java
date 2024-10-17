package net.divinerpg.blocks.vanilla;

import net.divinerpg.DivineRPG;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTar extends BlockFluidClassic{

	private IIcon[] theIIcon;
	
	public BlockTar() {
		super(DivineRPG.tarFluid, Material.lava);
		DivineRPG.tarFluid.setBlock(this);
		setLightLevel(1F);
		GameRegistry.registerBlock(this, "Tar");
		setBlockName("Tar");
		LangRegistry.addBlock(this);
	}

	@Override
    public IIcon getIcon(int par1, int par2) {
        return par1 != 0 && par1 != 1 ? this.theIIcon[1] : this.theIIcon[0];
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister registry) {
		this.theIIcon = new IIcon[] {registry.registerIcon(Reference.PREFIX + "Tar"), registry.registerIcon(Reference.PREFIX + "Tar")};
	}
}
