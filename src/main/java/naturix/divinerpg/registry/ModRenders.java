package naturix.divinerpg.registry;

import naturix.divinerpg.bases.blocks.tile.render.itemstack.ItemStackParasectaAltarRender;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;

public class ModRenders {

	public static void init() {
	
		
		
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.altarParasecta), 0, new ModelResourceLocation(ModBlocks.altarParasecta.getRegistryName(), "inventory"));
		
		
		ItemStackParasectaAltarRender.instance = new TileEntityItemStackRenderer();
    	
		
	}

}
