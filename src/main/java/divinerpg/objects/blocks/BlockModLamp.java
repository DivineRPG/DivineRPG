package divinerpg.objects.blocks;

import net.minecraft.block.material.Material;

public class BlockModLamp extends BlockMod {

    public BlockModLamp(String name, float hardness) {
        super(name, hardness, Material.REDSTONE_LIGHT);
        this.setLightLevel(1.0F);
    }
}
