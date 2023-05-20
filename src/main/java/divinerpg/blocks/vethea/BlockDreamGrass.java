package divinerpg.blocks.vethea;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModGrass;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockDreamGrass extends BlockModGrass {

    public BlockDreamGrass(MaterialColor color) {
        super(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_dirt")), color);
    }
}
