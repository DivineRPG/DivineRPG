package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModGrass;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.material.MapColor;

public class BlockArcaniteGrass extends BlockModGrass{
    public BlockArcaniteGrass(String name, float hardness) {
        super(name, () -> ModBlocks.arcaniteDirt, hardness, MapColor.BLUE);
    }
}
