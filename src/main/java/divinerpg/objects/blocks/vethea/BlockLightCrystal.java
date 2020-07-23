package divinerpg.objects.blocks.vethea;

import divinerpg.objects.blocks.BlockMod;
import net.minecraft.block.material.Material;

public class BlockLightCrystal extends BlockMod {
    public BlockLightCrystal(String name, float hardness) {
        super(name, hardness, Material.GLASS);
        this.setLightLevel(1F);
    }
}
