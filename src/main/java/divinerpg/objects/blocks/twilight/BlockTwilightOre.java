package divinerpg.objects.blocks.twilight;

import divinerpg.objects.blocks.BlockModOre;
import net.minecraft.item.Item;

import java.util.function.Supplier;

public class BlockTwilightOre extends BlockModOre {
    public BlockTwilightOre(String name, float hardness, float resistance, int harvestLevel, Supplier<Item> drop) {
        super(name, hardness, resistance, harvestLevel, drop);
    }
}
