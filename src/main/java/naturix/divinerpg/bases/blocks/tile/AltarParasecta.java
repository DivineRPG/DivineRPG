package naturix.divinerpg.bases.blocks.tile;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.tile.entity.TileEntityParasectaAltar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class AltarParasecta extends BlockContainer {
	private static String name;
	public AltarParasecta(String name) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DivineRPG.BlocksTab);
		setBlockUnbreakable();
		setResistance(6000000F);
		this.name = name;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityParasectaAltar();
	}
	
	public void registerItemModel(Item itemBlock) {
		DivineRPG.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
}
