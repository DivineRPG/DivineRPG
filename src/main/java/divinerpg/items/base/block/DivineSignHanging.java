package divinerpg.items.base.block;

import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.level.block.Block;

public class DivineSignHanging extends HangingSignItem {
    public DivineSignHanging(Block block, Block wallBlock) {super(block, wallBlock, new Properties().stacksTo(16));}
}