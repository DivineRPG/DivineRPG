package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;

public class BlockModCrop extends CropsBlock {
    private int maxAge = 0;

    public BlockModCrop(String name) {
        this(name, 0.8);
    }

    public BlockModCrop(String name, double maxHeight) {
        super(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP));
        this.setRegistryName(name);
    }

    public BlockModCrop(String name, double maxHeight, int maxAge) {
        super(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP));
        this.setRegistryName(name);
        this.maxAge = maxAge;
    }

    @Override
    public int getMaxAge() {
        int age = maxAge;
        if (maxAge == 0) {
            return 7;
        } else {
            return maxAge;
        }
    }
}
