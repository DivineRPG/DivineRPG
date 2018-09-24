package naturix.divinerpg.bases.blocks.tile;

import naturix.divinerpg.bases.blocks.tile.entity.TileEntityDramixAltar;
import naturix.divinerpg.bases.blocks.tile.entity.TileEntityParasectaAltar;
import naturix.divinerpg.bases.blocks.tile.render.TileEntityDramixAltarRender;
import naturix.divinerpg.bases.blocks.tile.render.TileEntityParasectaAltarRender;
import naturix.divinerpg.bases.blocks.tile.render.itemstack.ItemStackParasectaAltarRender;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class RenderTiles {

	public static void init() {
		// ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVase.class, new TileEntityVaseRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDramixAltar.class, new TileEntityDramixAltarRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityParasectaAltar.class, new TileEntityParasectaAltarRender());
	
			}
	
}
