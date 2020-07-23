package divinerpg.objects.blocks.twilight.grass;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.material.MapColor;

public class BlockApalachiaGrass extends BlockModGrass {

    public BlockApalachiaGrass(String name, float hardness) {
        super(name, () -> BlockRegistry.apalachiaDirt, hardness, MapColor.PURPLE);

        this.addGrowablePlant(() -> BlockRegistry.duskBloom);
        this.addGrowablePlant(() -> BlockRegistry.duskFlower);
        this.addGrowablePlant(() -> BlockRegistry.apalachiaTallgrass);
    }
}