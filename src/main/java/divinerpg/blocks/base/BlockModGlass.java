package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class BlockModGlass extends AbstractGlassBlock {
    public BlockModGlass() {
        super(BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.GLASS).instrument(NoteBlockInstrument.HAT).noOcclusion());
    }

}
