package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.util.*;

public class BlockModButton extends AbstractButtonBlock {
    SoundEvent sound1, sound2;

    public BlockModButton(String name) {
        super(true, AbstractBlock.Properties.copy(Blocks.OAK_BUTTON));
        setRegistryName(name);
        this.sound1 = SoundEvents.WOODEN_BUTTON_CLICK_ON;
        this.sound2 = SoundEvents.WOODEN_BUTTON_CLICK_OFF;
    }

    @Override
    protected SoundEvent getSound(boolean on) {
        return on ? sound1 : sound2;
    }
}
