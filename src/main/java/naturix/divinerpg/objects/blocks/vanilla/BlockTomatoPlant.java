package naturix.divinerpg.objects.blocks.vanilla;

import naturix.divinerpg.objects.blocks.BlockModCrop;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.item.Item;

public class BlockTomatoPlant extends BlockModCrop {
    public BlockTomatoPlant() {
        super("tomato_plant");
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected Item getSeed() {
        return ModItems.tomatoSeeds;
    }

    @Override
    protected Item getCrop() {
        return ModItems.tomato;
    }
}