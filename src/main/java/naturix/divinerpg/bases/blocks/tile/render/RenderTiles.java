package naturix.divinerpg.bases.blocks.tile.render;

import naturix.divinerpg.bases.blocks.tile.entity.TileEntityDramixAltar;
import naturix.divinerpg.bases.blocks.tile.entity.TileEntityParasectaAltar;
import naturix.divinerpg.bases.blocks.tile.entity.render.TileEntityDramixAltarRender;
import naturix.divinerpg.bases.blocks.tile.entity.render.TileEntityParasectaAltarRender;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class RenderTiles {

	public static void init() {
		// ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVase.class, new TileEntityVaseRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDramixAltar.class, new TileEntityDramixAltarRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityParasectaAltar.class, new TileEntityParasectaAltarRender());
	
	}
	
}
