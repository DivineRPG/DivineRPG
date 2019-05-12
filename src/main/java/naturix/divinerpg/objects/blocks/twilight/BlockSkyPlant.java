package naturix.divinerpg.objects.blocks.twilight;

import naturix.divinerpg.objects.blocks.BlockModCrop;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSeeds;
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