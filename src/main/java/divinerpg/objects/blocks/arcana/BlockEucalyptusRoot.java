package divinerpg.objects.blocks.arcana;

import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModSeeds;
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
        return ModSeeds.eucalyptusSeeds;
    }

    @Override
    public Item getCrop() {
        return Item.getItemFromBlock(ModBlocks.eucalyptusLogs);
    }
}