package naturix.divinerpg.objects.blocks.tile;

import naturix.divinerpg.objects.blocks.tile.entity.TileEntityDramixAltar;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityParasectaAltar;
import naturix.divinerpg.objects.blocks.tile.render.TileEntityDramixAltarRender;
import naturix.divinerpg.objects.blocks.tile.render.TileEntityParasectaAltarRender;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class RenderTiles {

	public static void init() {
		// ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVase.class, new TileEntityVaseRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDramixAltar.class, new TileEntityDramixAltarRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityParasectaAltar.class, new TileEntityParasectaAltarRender());
	
			}
	
}
