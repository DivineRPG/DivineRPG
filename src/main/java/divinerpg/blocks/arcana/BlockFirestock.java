package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockStackPlant;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockFirestock extends BlockStackPlant {
    public BlockFirestock() {
        super();
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "firestock_seeds"));
    }
}
