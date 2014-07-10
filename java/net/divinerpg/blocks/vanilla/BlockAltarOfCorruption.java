package net.divinerpg.blocks.vanilla;

import java.util.Random;

import net.divinerpg.DivineRPG;
import net.divinerpg.blocks.vanilla.container.tile_entity.TileEntityAltarOfCorruption;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAltarOfCorruption extends BlockContainer {

	private IIcon top, side, bottom;

	public BlockAltarOfCorruption(String name) {
		super(Material.rock);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
		setBlockName(name);
		setBlockTextureName(Reference.PREFIX + name);
		setCreativeTab(DivineRPGTabs.blocks);
		GameRegistry.registerBlock(this, name);
		LangRegistry.addBlock(this);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
		for(int var6 = par2 - 2; var6 <= par2 + 2; ++var6) {
			for(int var7 = par4 - 2; var7 <= par4 + 2; ++var7) {
				if(var6 > par2 - 2 && var6 < par2 + 2 && var7 == par4 - 1)  
					var7 = par4 + 2;

				if(par5Random.nextInt(16) == 0) {
					for (int var8 = par3; var8 <= par3 + 1; ++var8) {
						par1World.spawnParticle("enchantmenttable", (double)par2 + 0.5D, (double)par3 + 2.0D, (double)par4 + 0.5D, (double)((float)(var6 - par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(var8 - par3) - par5Random.nextFloat() - 1.0F), (double)((float)(var7 - par4) + par5Random.nextFloat()) - 0.5D);
					}
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 0 ? this.bottom : (side == 1 ? this.top : this.side);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.side = icon.registerIcon(this.getTextureName() + "_side");
		this.top = icon.registerIcon(this.getTextureName() + "_top");
		this.bottom = icon.registerIcon(this.getTextureName() + "_bottom");
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		TileEntityAltarOfCorruption tileEntity = (TileEntityAltarOfCorruption)par1World.getTileEntity(par2, par3, par4);
		if(!par1World.isRemote) {
			if(tileEntity != null) {
				par5EntityPlayer.openGui(DivineRPG.instance, GuiHandler.altar, par1World, par2, par3, par4);
				par5EntityPlayer.triggerAchievement(DivineRPGAchievements.perfectlyCorrupted);	
			}
			return true;
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityAltarOfCorruption();
	}
}