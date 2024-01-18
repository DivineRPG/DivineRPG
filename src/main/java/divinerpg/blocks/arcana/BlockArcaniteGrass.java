package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModGrass;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.MapColor;

public class BlockArcaniteGrass extends BlockModGrass {
    public BlockArcaniteGrass() {
        super(() -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "arcanite_dirt")), MapColor.TERRACOTTA_LIGHT_BLUE);
    }
}
