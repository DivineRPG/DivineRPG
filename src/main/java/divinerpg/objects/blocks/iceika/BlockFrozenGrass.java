package divinerpg.objects.blocks.iceika;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.material.MapColor;

public class BlockFrozenGrass extends BlockModGrass {

    public BlockFrozenGrass(String name, float hardness) {
        super(name, () -> BlockRegistry.frozenDirt, hardness, MapColor.LIGHT_BLUE);
    }
}
