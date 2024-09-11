package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.*;

public class BlockMod extends Block {
    public int flammability, fireSpread;
    public BlockMod(Properties properties) {
        super(properties);
        flammability = fireSpread = 0;
    }
    public BlockMod(MapColor color, float hardness, float resistance) {
        super(Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(hardness, resistance).instrument(NoteBlockInstrument.BASEDRUM));
        flammability = fireSpread = 0;
    }
    public BlockMod(MapColor color, float hardness, float resistance, SoundType sound, NoteBlockInstrument instrument) {
        super(Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(hardness, resistance).sound(sound).instrument(instrument));
        flammability = fireSpread = 0;
    }
    public BlockMod(MapColor color, float hardness, float resistance, int fAbility, int fSpread, SoundType sound, NoteBlockInstrument instrument) {
        super(Properties.of().mapColor(color).strength(hardness, resistance).sound(sound).instrument(instrument));
        flammability = fAbility;
        fireSpread = fSpread;
    }
    public BlockMod(MapColor color, int luminance) {
        super(Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(50, 1200).pushReaction(PushReaction.BLOCK).instrument(NoteBlockInstrument.BASEDRUM).lightLevel((state) -> luminance));
        flammability = fireSpread = 0;
    }
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return flammability;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return fireSpread;}
}