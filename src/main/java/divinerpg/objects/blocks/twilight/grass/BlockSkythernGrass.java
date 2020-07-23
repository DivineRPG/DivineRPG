package divinerpg.objects.blocks.twilight.grass;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.material.MapColor;

public class BlockSkythernGrass extends BlockModGrass {

    public BlockSkythernGrass(String name, float hardness) {
        super(name, () -> BlockRegistry.skythernDirt, hardness, MapColor.CLOTH);

        this.addGrowablePlant(() -> BlockRegistry.dustBrambles);
        this.addGrowablePlant(() -> BlockRegistry.dustLily);
        this.addGrowablePlant(() -> BlockRegistry.skythernBrush);
    }
}