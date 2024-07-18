package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class BlockModButton extends ButtonBlock {
    public BlockModButton(BlockSetType type) {
        super(type, 30, Properties.ofFullCopy(Blocks.OAK_BUTTON));
    }
    public BlockModButton() {
        super(BlockSetType.STONE, 20, Properties.ofFullCopy(Blocks.STONE_BUTTON));
    }
}