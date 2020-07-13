package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModCrop;
import divinerpg.registry.ItemRegistry;
import net.minecraft.item.Item;

public class BlockVeilo extends BlockModCrop {

    public BlockVeilo(String name) {
        super(name);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected Item getSeed() {
        return ItemRegistry.veiloSeeds;
    }

    @Override
    protected Item getCrop() {
        return ItemRegistry.veilo;
    }
}