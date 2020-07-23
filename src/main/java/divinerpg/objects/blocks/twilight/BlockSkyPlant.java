package divinerpg.objects.blocks.twilight;

import divinerpg.objects.blocks.BlockModCrop;
import divinerpg.registry.ItemRegistry;
import net.minecraft.item.Item;

public class BlockSkyPlant extends BlockModCrop {
    public BlockSkyPlant() {
        super("sky_plant", 0.5);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected Item getSeed() {
        return ItemRegistry.skyPlantSeeds;
    }

    @Override
    protected Item getCrop() {
        return ItemRegistry.skyFlower;
    }
}