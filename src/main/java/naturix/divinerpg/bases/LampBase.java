package naturix.divinerpg.bases;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.material.Material;

public class LampBase extends BlockBase {

	public LampBase(Material material, String name) {
		super(material, name);
		setLightLevel(1);
		this.setCreativeTab(DivineRPG.BlocksTab);
	}

}
