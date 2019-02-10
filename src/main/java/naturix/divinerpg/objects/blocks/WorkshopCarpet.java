package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Created by LiteWolf101 on Jan /28/2019
 */
public class WorkshopCarpet extends BlockBase {

	public WorkshopCarpet(String name) {
		super(Material.CARPET, name);
		setSoundType(SoundType.CLOTH);
		setCreativeTab(DivineRPG.BlocksTab);
		this.setHardness(1.5f);
	}

}
