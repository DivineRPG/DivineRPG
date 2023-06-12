package divinerpg.blocks.vethea;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.*;

public class BlockLightCrystal extends BlockMod {
    public BlockLightCrystal(MapColor color) {
        super(BlockBehaviour.Properties.of().mapColor(color).strength(0.3F).sound(SoundType.GLASS).instrument(NoteBlockInstrument.PLING).lightLevel((state) -> 15));
    }
}
