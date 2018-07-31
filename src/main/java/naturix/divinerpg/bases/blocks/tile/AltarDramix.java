package naturix.divinerpg.bases.blocks.tile;

import naturix.divinerpg.bases.blocks.tile.entity.TileEntityDramixAltar;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class AltarDramix extends AltarParasecta {

	public AltarDramix(String name) {
		super(name);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityDramixAltar();
	}
	
	
}