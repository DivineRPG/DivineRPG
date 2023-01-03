package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockStackPlant;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockPinfly extends BlockStackPlant {
    public BlockPinfly() {
        super();
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "pinfly_seeds"));
    }
}
