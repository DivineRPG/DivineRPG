package divinerpg.objects.blocks.twilight.grass;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.material.MapColor;

public class BlockWildwoodGrass extends BlockModGrass {

    public BlockWildwoodGrass(String name, float hardness) {
        super(name, () -> BlockRegistry.wildwoodDirt, hardness, MapColor.BLUE);

        this.addGrowablePlant(() -> BlockRegistry.moonBud);
        this.addGrowablePlant(() -> BlockRegistry.moonlightFern);
        this.addGrowablePlant(() -> BlockRegistry.wildwoodGrass);
    }
}