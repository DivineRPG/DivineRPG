package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;

public class BlockModPressurePlate extends PressurePlateBlock {

    public BlockModPressurePlate() {
        super(Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE));
    }
}
