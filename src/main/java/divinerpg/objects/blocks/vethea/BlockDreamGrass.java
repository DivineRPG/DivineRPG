package divinerpg.objects.blocks.vethea;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.material.MapColor;

public class BlockDreamGrass extends BlockModGrass {
    public BlockDreamGrass(String name, float hardness) {
        super(name, () -> BlockRegistry.dreamDirt, hardness, MapColor.LIME);
    }
}
