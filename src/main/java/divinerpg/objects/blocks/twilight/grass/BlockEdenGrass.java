package divinerpg.objects.blocks.twilight.grass;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.material.MapColor;

public class BlockEdenGrass extends BlockModGrass {

    public BlockEdenGrass(String name, float hardness) {
        super(name, () -> ModBlocks.edenDirt, hardness, MapColor.YELLOW);

        this.addGrowablePlant(() -> ModBlocks.sunBlossom);
        this.addGrowablePlant(() -> ModBlocks.sunbloom);
        this.addGrowablePlant(() -> ModBlocks.edenBrush);
    }
}
