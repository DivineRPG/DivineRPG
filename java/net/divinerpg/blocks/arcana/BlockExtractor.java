package net.divinerpg.blocks.arcana;

import net.divinerpg.DivineRPG;
import net.divinerpg.api.blocks.BlockModFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityExtractor;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockExtractor extends BlockModFurnace {

	public BlockExtractor(String name) {
		super(name, false, GuiHandler.extractor);
		setCreativeTab(DivineRPGTabs.blocks);
		setBlockUnbreakable();
		setBlockTextureName("stone");
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityExtractor();
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess w, int x, int y, int z) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
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