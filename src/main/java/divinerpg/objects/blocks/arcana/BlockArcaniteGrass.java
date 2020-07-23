package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.material.MapColor;

public class BlockArcaniteGrass extends BlockModGrass{
    public BlockArcaniteGrass(String name, float hardness) {
        super(name, () -> BlockRegistry.arcaniteDirt, hardness, MapColor.BLUE);
    }
}
