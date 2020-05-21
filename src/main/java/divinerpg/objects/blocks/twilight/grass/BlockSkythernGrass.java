package divinerpg.objects.blocks.twilight.grass;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.material.MapColor;

public class BlockSkythernGrass extends BlockModGrass {

    public BlockSkythernGrass(String name, float hardness) {
        super(name, () -> ModBlocks.skythernDirt, hardness, MapColor.CLOTH);

        this.addGrowablePlant(() -> ModBlocks.dustBrambles);
        this.addGrowablePlant(() -> ModBlocks.dustLily);
        this.addGrowablePlant(() -> ModBlocks.skythernBrush);
    }
}