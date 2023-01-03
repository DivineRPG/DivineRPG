package divinerpg.blocks.base;

import net.minecraft.sounds.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;

public class BlockModButton extends ButtonBlock {
    public BlockModButton() {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON);
    }

}
