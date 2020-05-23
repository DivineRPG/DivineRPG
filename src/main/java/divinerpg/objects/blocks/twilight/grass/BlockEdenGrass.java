package divinerpg.objects.blocks.twilight.grass;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.material.MapColor;

public class BlockEdenGrass extends BlockModGrass {

    public BlockEdenGrass(String name, float hardness) {
        super(name, () -> BlockRegistry.edenDirt, hardness, MapColor.YELLOW);

        this.addGrowablePlant(() -> BlockRegistry.sunBlossom);
        this.addGrowablePlant(() -> BlockRegistry.sunbloom);
        this.addGrowablePlant(() -> BlockRegistry.edenBrush);
    }
}
