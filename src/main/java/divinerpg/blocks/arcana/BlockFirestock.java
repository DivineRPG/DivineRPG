package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockStackPlant;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

public class BlockFirestock extends BlockStackPlant {
    public BlockFirestock() {
        super();
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return BuiltInRegistries.ITEM.get(new ResourceLocation(DivineRPG.MODID, "firestock_seeds"));
    }
}
