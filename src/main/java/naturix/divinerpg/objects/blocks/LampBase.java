package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.registry.DRPGCreativeTabs;
import net.minecraft.block.material.Material;

public class LampBase extends BlockMod {

	public LampBase(Material material, String name) {
		super(material, name);
		setLightLevel(1);
		this.setCreativeTab(DRPGCreativeTabs.BlocksTab);
		this.setHardness(0.5F);
	}
}
