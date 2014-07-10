package net.divinerpg.blocks.arcana;

import cpw.mods.fml.common.registry.GameRegistry;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityParasectaAltar;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockParasectaAltar extends BlockContainer {

	public BlockParasectaAltar(String name) {
		super(Material.rock);
		setBlockName(name);
		setCreativeTab(DivineRPGTabs.blocks);
		setBlockUnbreakable();
		setBlockTextureName("stone");
		LangRegistry.addBlock(this);
		GameRegistry.registerBlock(this, name);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityParasectaAltar();
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}