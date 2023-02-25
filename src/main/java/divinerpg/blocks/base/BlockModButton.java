package divinerpg.blocks.base;

import net.minecraft.sounds.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;

public class BlockModButton extends ButtonBlock {
    SoundEvent sound1, sound2;

    public BlockModButton() {
        super(true, BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON));
        this.sound1 = SoundEvents.WOODEN_BUTTON_CLICK_ON;
        this.sound2 = SoundEvents.WOODEN_BUTTON_CLICK_OFF;
    }

    @Override
    protected SoundEvent getSound(boolean on) {
        return on ? sound1 : sound2;
    }
}
