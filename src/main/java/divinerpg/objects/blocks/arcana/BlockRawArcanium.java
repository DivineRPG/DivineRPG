package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockMod;
import net.minecraft.block.material.Material;

public class BlockRawArcanium extends BlockMod {
    public BlockRawArcanium(String name) {
        super(name, 2.0F, Material.GROUND);
        this.setHarvestLevel("shovel", 3);
    }
}
