package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class BlockModUnbreakable extends BlockMod {
    public BlockModUnbreakable(Block.Properties properties) {super(properties);}
    public BlockModUnbreakable(MapColor color, boolean isLamp) {super(Block.Properties.of().mapColor(color).strength(-1, 3600000).noLootTable().sound(SoundType.GLASS).instrument(NoteBlockInstrument.HAT).lightLevel((p_235464_0_) -> 15));}
    public BlockModUnbreakable(MapColor color) {super(Block.Properties.of().mapColor(color).strength(-1, 3600000).noLootTable().sound(SoundType.STONE).instrument(NoteBlockInstrument.BASEDRUM));}
}