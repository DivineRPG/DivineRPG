package divinerpg.objects.blocks.twilight.grass;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.material.MapColor;

public class BlockMortumGrass extends BlockModGrass {

    public BlockMortumGrass(String name, float hardness) {
        super(name, () -> BlockRegistry.mortumDirt, hardness, MapColor.BLACK);

        this.addGrowablePlant(() -> BlockRegistry.demonBrambles);
        this.addGrowablePlant(() -> BlockRegistry.eyePlant);
        this.addGrowablePlant(() -> BlockRegistry.mortumBrush);
    }
}