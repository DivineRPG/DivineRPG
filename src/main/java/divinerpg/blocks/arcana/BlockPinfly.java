package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockStackPlant;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

public class BlockPinfly extends BlockStackPlant {
    public BlockPinfly() {
        super();
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return BuiltInRegistries.ITEM.get(new ResourceLocation(DivineRPG.MODID, "pinfly_seeds"));
    }
}
