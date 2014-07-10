package net.divinerpg.blocks.vethea;

import net.divinerpg.DivineRPG;
import net.divinerpg.blocks.vethea.container.tile_entity.TileEntityInfusionTable;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockInfusionTable extends BlockContainer {

	private IIcon side, top;
	
	public BlockInfusionTable() {
		super(Material.rock);
		LangRegistry.addBlock(this);
		setCreativeTab(DivineRPGTabs.vethea);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityInfusionTable();
	}
	
    public Block setTextureName(String name) {
        return setBlockTextureName(Reference.PREFIX + name);
    }
	
	public Block setName(String name){
		setTextureName(name);
        setBlockName(name);
        GameRegistry.registerBlock(this, name);
		return this;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		TileEntityInfusionTable entity = (TileEntityInfusionTable)world.getTileEntity(x, y, z);
		if(entity == null || par5EntityPlayer.isSneaking()) return false;
		
		par5EntityPlayer.openGui(DivineRPG.instance, GuiHandler.infusionTable, world, x, y, z);
		return true;
	}
	
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        side = icon.registerIcon(getTextureName() + "_side");
        top = icon.registerIcon(getTextureName() + "_top");
    }
	
    public IIcon getIcon(int par1, int par2) {
        int var3 = par2 & 12;
        return var3 == 0 && (par1 == 1 || par1 == 0) ? this.top : (var3 == 4 && (par1 == 5 || par1 == 4) ? this.top  : (var3 == 8 && (par1 == 2 || par1 == 3) ? top  : this.side ));
    }
}
