package divinerpg.objects.blocks.vanilla;

import divinerpg.objects.blocks.BlockMod;
import net.minecraft.block.material.Material;

public class BlockDarkstone extends BlockMod {
    public BlockDarkstone(String name, float hardness) {
        super(name, hardness, Material.ROCK);
        this.setHarvestLevel("pickaxe", 3);
        this.setResistance(2000F);
        this.setLightLevel(1F);
    }
}
