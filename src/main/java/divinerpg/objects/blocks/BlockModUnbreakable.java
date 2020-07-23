package divinerpg.objects.blocks;

import net.minecraft.block.material.Material;

public class BlockModUnbreakable extends BlockMod {

    public BlockModUnbreakable(String name) {
        this(name, Material.ROCK);
    }

    public BlockModUnbreakable(String name, Material material) {
        super(name, -1F, material);
        this.setResistance(6000000F);
    }


}
