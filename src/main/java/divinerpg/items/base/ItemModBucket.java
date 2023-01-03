package divinerpg.items.base;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class ItemModBucket extends BucketItem {

    public ItemModBucket(Supplier<? extends Fluid> supplier) {
        super(supplier, new Properties().stacksTo(1));
    }
}
