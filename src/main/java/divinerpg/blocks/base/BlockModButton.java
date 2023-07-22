package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class BlockModButton extends ButtonBlock {
    public BlockModButton(BlockSetType type) {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), type, 30, true);
    }
}
