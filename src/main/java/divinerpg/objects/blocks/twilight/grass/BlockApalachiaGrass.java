package divinerpg.objects.blocks.twilight.grass;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.material.MapColor;

public class BlockApalachiaGrass extends BlockModGrass {

    public BlockApalachiaGrass(String name, float hardness) {
        super(name, () -> ModBlocks.apalachiaDirt, hardness, MapColor.PURPLE);

        this.addGrowablePlant(() -> ModBlocks.duskBloom);
        this.addGrowablePlant(() -> ModBlocks.duskFlower);
        this.addGrowablePlant(() -> ModBlocks.apalachiaTallgrass);
    }
}