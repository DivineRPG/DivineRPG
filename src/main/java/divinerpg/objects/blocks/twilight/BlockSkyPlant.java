package divinerpg.objects.blocks.twilight;

import divinerpg.objects.blocks.BlockModCrop;
import divinerpg.registry.ModItems;
import divinerpg.registry.ModSeeds;
import net.minecraft.item.Item;

public class BlockSkyPlant extends BlockModCrop {
    public BlockSkyPlant() {
        super("sky_plant");
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected Item getSeed() {
        return ModSeeds.skyPlantSeeds;
    }

    @Override
    protected Item getCrop() {
        return ModItems.skyFlower;
    }
}