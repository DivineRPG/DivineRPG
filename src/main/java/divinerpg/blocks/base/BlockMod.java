package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.material.PushReaction.BLOCK;

public class BlockMod extends Block {
    //Blocks with specific properties
    public BlockMod(Properties properties) {super(properties);}
    //Regular stone-like properties
    public BlockMod(MapColor color) {this(color, 1.5F, 6);}
    //Regular stone-like properties, but custom hardness/resistance
    public BlockMod(MapColor color, float hardness, float resistance) {
        super(Properties.ofFullCopy(Blocks.STONE).mapColor(color).strength(hardness, resistance));
    }
    //Regular stone-like properties, but custom hardness/resistance and friction
    public BlockMod(MapColor color, float hardness, float resistance, float friction) {
        super(Properties.ofFullCopy(Blocks.STONE).mapColor(color).strength(hardness, resistance).friction(friction));
    }
    //Custom hardness/resistance + instrument and sound
    public BlockMod(MapColor color, float hardness, float resistance, SoundType sound, NoteBlockInstrument instrument) {
        super(Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(hardness, resistance).sound(sound).instrument(instrument));
    }
    //Hard blocks like obsidian, but luminous
    public BlockMod(MapColor color, int luminance) {
        super(Properties.ofFullCopy(Blocks.OBSIDIAN).mapColor(color).pushReaction(BLOCK).lightLevel((state) -> luminance));
    }
}