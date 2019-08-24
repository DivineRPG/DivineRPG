package divinerpg.objects.blocks.arcana;

import divinerpg.registry.ModItems;
import divinerpg.registry.ModSeeds;
import net.minecraft.item.Item;

public class BlockVeilo extends BlockArcanaCrop {

    public BlockVeilo(String name) {
        super(name);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected Item getSeed() {
        return ModSeeds.veiloSeeds;
    }

    @Override
    protected Item getCrop() {
        return ModItems.veilo;
    }
}