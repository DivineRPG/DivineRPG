package naturix.divinerpg.objects.blocks.twilight;

import naturix.divinerpg.objects.blocks.BlockModCrop;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSeeds;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockSkyPlant extends BlockModCrop {
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);
    
    public BlockSkyPlant() {
        super("sky_plant");
    }
    @Override
    protected Item getSeed()
    {
        return ModSeeds.skyPlantSeeds;
    }
    @Override
    protected Item getCrop()
    {
        return ModItems.skyFlower;
    }
    
}