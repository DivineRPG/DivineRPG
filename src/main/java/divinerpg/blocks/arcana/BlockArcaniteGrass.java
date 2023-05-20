package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModGrass;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockArcaniteGrass extends BlockModGrass {
    public BlockArcaniteGrass() {
        super(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_dirt")), MaterialColor.LAPIS);
    }
}
