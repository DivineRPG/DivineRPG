package net.divinerpg.blocks.iceika;

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

public class BlockIceikaLava extends BlockFluidClassic{

	private IIcon[] theIIcon;
	
	public BlockIceikaLava() {
		super(DivineRPG.frozenLava, Material.water);
		DivineRPG.frozenLava.setBlock(this);
		setLightLevel(1F);
		GameRegistry.registerBlock(this, "coldLava");
		setBlockName("coldLava");
		LangRegistry.addBlock(this);
	}

	@Override
    public IIcon getIcon(int par1, int par2) {
        return par1 != 0 && par1 != 1 ? this.theIIcon[1] : this.theIIcon[0];
    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IIconRegister) {
		this.theIIcon = new IIcon[] {par1IIconRegister.registerIcon(Reference.PREFIX + "iceikaLava_still"), par1IIconRegister.registerIcon(Reference.PREFIX + "iceikaLava_flow")};
	}
}
