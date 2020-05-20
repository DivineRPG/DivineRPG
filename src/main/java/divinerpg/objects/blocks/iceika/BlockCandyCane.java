package divinerpg.objects.blocks.iceika;

import divinerpg.objects.blocks.BlockMod;
import net.minecraft.block.material.Material;

public class BlockCandyCane extends BlockMod {
    public BlockCandyCane(String name) {
        super(name, 1.0F, Material.ROCK);
        this.setResistance(1.0F);
    }
}
