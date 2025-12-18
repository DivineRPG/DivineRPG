package divinerpg.compat.corail_woodcutter;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public class WoodcutterLoader {
    public static Supplier<Block> create(DeferredBlock<Block> base, WoodType type) {return () -> new Woodcutter(base, type);}
    public static Supplier<BlockItem> createBlockItem(Block base) {return () -> new WoodcutterBlockItem(base);}
}