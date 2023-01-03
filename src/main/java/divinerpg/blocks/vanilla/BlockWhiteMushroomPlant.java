package divinerpg.blocks.vanilla;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModCrop;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockWhiteMushroomPlant extends BlockModCrop {
    public BlockWhiteMushroomPlant() {
        super(0.3);
    }

    @Override
    public int getMaxAge() {
        return 1;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "white_mushroom_seeds"));
    }
}