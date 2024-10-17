package net.divinerpg.blocks.vanilla;

import cpw.mods.fml.common.registry.GameRegistry;
import net.divinerpg.blocks.vanilla.container.tileentity.TileEntityAyeracoSpawn;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAyeracoSpawn extends BlockContainer {

	public BlockAyeracoSpawn() {
		super(Material.rock);
		setBlockUnbreakable();
		setResistance(6000000F);
		setBlockBounds(0, 0, 0, 0, 0, 0);
		String name = "ayeracoSpawn";
		setBlockName(name);
		setBlockTextureName(Reference.PREFIX + name);
		LangRegistry.addBlock(this);
		GameRegistry.registerBlock(this, name);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityAyeracoSpawn();
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
    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
	    return false;
	}
}
