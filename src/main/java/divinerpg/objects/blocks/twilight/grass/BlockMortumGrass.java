package divinerpg.objects.blocks.twilight.grass;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.material.MapColor;

public class BlockMortumGrass extends BlockModGrass {

    public BlockMortumGrass(String name, float hardness) {
        super(name, () -> ModBlocks.mortumDirt, hardness, MapColor.BLACK);

        this.addGrowablePlant(() -> ModBlocks.demonBrambles);
        this.addGrowablePlant(() -> ModBlocks.eyePlant);
        this.addGrowablePlant(() -> ModBlocks.mortumBrush);
    }
}