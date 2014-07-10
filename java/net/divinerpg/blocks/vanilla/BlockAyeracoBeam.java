package net.divinerpg.blocks.vanilla;

import net.divinerpg.blocks.vanilla.container.tile_entity.TileEntityAyeracoBeam;
import net.divinerpg.libs.Reference;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockAyeracoBeam extends BlockContainer {

	private String tex;
	
	public BlockAyeracoBeam(String name, String tex) {
		super(Material.cactus); 
		setBlockTextureName(Reference.PREFIX + "beam" + tex);
		setBlockName(name);
		setCreativeTab(null);
		this.tex = tex;
		GameRegistry.registerBlock(this, name);
	}

	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess w, int x, int y, int z) {
		setBlockBounds(0.0F, 0.0F, 0.0F, 0.0F, 200.0F, 0.0F);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityAyeracoBeam(new ResourceLocation(Reference.PREFIX + "textures/blocks/beam" + tex + ".png"));
	}
}