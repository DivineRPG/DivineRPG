package divinerpg.items.base.block;

import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;

public class DivineSign extends SignItem {
    public DivineSign(Block standingBlock, Block wallBlock) {super(new Properties().stacksTo(16), standingBlock, wallBlock);}
}