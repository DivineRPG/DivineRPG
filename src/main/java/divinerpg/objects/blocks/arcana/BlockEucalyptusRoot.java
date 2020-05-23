package divinerpg.objects.blocks.arcana;

import divinerpg.registry.BlockRegistry;
import divinerpg.registry.ItemRegistry;
import net.minecraft.item.Item;

public class BlockEucalyptusRoot extends BlockArcanaCrop {

    public BlockEucalyptusRoot(String name) {
        super(name);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public Item getSeed() {
        return ItemRegistry.eucalyptusRootSeeds;
    }

    @Override
    public Item getCrop() {
        return Item.getItemFromBlock(BlockRegistry.eucalyptusLog);
    }
}