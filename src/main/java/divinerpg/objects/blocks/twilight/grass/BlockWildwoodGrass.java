package divinerpg.objects.blocks.twilight.grass;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.material.MapColor;

public class BlockWildwoodGrass extends BlockModGrass {

    public BlockWildwoodGrass(String name, float hardness) {
        super(name, () -> ModBlocks.wildwoodDirt, hardness, MapColor.BLUE);

        this.addGrowablePlant(() -> ModBlocks.moonBud);
        this.addGrowablePlant(() -> ModBlocks.moonlightFern);
        this.addGrowablePlant(() -> ModBlocks.wildwoodGrass);
    }
}