package naturix.divinerpg.bases;

import naturix.divinerpg.Divine;
import net.minecraft.block.material.Material;

public class LampBase extends BlockBase {

	public LampBase(Material material, String name) {
		super(material, name);
		setLightLevel(1);
		this.setCreativeTab(Divine.BlocksTab);
	}

}
