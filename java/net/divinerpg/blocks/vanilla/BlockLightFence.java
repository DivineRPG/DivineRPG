package net.divinerpg.blocks.vanilla;

import java.util.Random;

import scala.xml.PrefixedAttribute;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.divinerpg.api.blocks.BlockModFence;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockLightFence extends BlockModFence {
	private final boolean powered;
	private String name;
	
	public BlockLightFence(boolean powered, String name, float hardness) {
		super(name);
		this.name = name;
		this.powered = powered;
		setBlockTextureName(Reference.PREFIX + name);
		setStepSound(Block.soundTypeGlass);
		LangRegistry.addBlock(this);
		setHardness(hardness);
		setCreativeTab(DivineRPGTabs.blocks);
		if(powered){
			this.setLightLevel(1.0F);
			setCreativeTab(null);
		}
	}
	
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon(Reference.PREFIX + this.name);
    }

	public void onBlockAdded(World par1, int par2, int par3, int par4) {
		if (!par1.isRemote) {
			if (this.powered && !par1.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
				par1.scheduleBlockUpdate(par2, par3, par4, this, 4);
			}
			else if (!this.powered && par1.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
				if(par1.getBlock(par2, par3, par4) == VanillaBlocks.lightFenceBlue){
					par1.setBlock(par2, par3, par4, VanillaBlocks.lightFenceBlueOn);
				}
				if(par1.getBlock(par2, par3, par4) == VanillaBlocks.lightFenceGreen){
					par1.setBlock(par2, par3, par4, VanillaBlocks.lightFenceGreenOn);
				}
				if(par1.getBlock(par2, par3, par4) == VanillaBlocks.lightFenceRed){
					par1.setBlock(par2, par3, par4, VanillaBlocks.lightFenceRedOn);
				}
			}
		}
	}

	public void onNeighborBlockChange(World par1, int par2, int par3, int par4, Block par5) {
		if (!par1.isRemote) {
			if (this.powered && !par1.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
				par1.scheduleBlockUpdate(par2, par3, par4, this, 4);
			}
			else if (!this.powered && par1.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
				if(par1.getBlock(par2, par3, par4) == VanillaBlocks.lightFenceBlue){
					par1.setBlock(par2, par3, par4, VanillaBlocks.lightFenceBlueOn);
				}
				if(par1.getBlock(par2, par3, par4) == VanillaBlocks.lightFenceGreen){
					par1.setBlock(par2, par3, par4, VanillaBlocks.lightFenceGreenOn);
				}
				if(par1.getBlock(par2, par3, par4) == VanillaBlocks.lightFenceRed){
					par1.setBlock(par2, par3, par4, VanillaBlocks.lightFenceRedOn);
				}
			}
		}
	}

	public void updateTick(World par1, int par2, int par3, int par4, Random par5) {
		if (!par1.isRemote && this.powered && !par1.isBlockIndirectlyGettingPowered(par2, par3, par4)) {

			if(par1.getBlock(par2, par3, par4) == VanillaBlocks.lightFenceBlueOn){
				par1.setBlock(par2, par3, par4, VanillaBlocks.lightFenceBlue);
			}
			if(par1.getBlock(par2, par3, par4) == VanillaBlocks.lightFenceGreenOn){
				par1.setBlock(par2, par3, par4, VanillaBlocks.lightFenceGreen);
			}
			if(par1.getBlock(par2, par3, par4) == VanillaBlocks.lightFenceRedOn){
				par1.setBlock(par2, par3, par4, VanillaBlocks.lightFenceRed);
			}
		}
	}

	public Item getItem(World w, int i, int j, int k) {
		return Item.getItemFromBlock(this);
	}
}