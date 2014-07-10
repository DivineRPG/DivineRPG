package net.divinerpg.blocks.vanilla;

import net.divinerpg.DivineRPG;
import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDivineTable extends BlockMod{

	@SideOnly(Side.CLIENT)
	private IIcon top, front, bottom, side;

	public BlockDivineTable() {
		super(EnumBlockType.ROCK, "divineTable", 3.0F, DivineRPGTabs.blocks);
		setCreativeTab(DivineRPGTabs.blocks);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		return par1 == 1 ? top : (par1 == 0 ? bottom : (par1 != 2 && par1 != 4 ? side : front));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.side = par1IconRegister.registerIcon(Reference.PREFIX + "divineTable_side");
		this.top = par1IconRegister.registerIcon(Reference.PREFIX + "divineTable_top");
		this.front = par1IconRegister.registerIcon(Reference.PREFIX + "divineTable_front");
		this.bottom = par1IconRegister.registerIcon(Reference.PREFIX + "divinePlank");
	}

	@Override
	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9) {
		if (!player.isSneaking()) {
			player.openGui(DivineRPG.instance, GuiHandler.divineTable, var1, var2, var3, var4);
			return true;
		} else {
			return false;
		}
	}
}