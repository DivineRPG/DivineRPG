package divinerpg.blocks.base;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.SEA_LANTERN;

public class BlockModUnbreakable extends Block {
    //Unbreakable blocks with specific properties
    public BlockModUnbreakable(Properties properties) {super(properties.strength(-1, 3600000).noLootTable());}
    //Unbreakable stone-like blocks with custom color
    public BlockModUnbreakable(MapColor color) {this(Properties.ofFullCopy(Blocks.STONE).mapColor(color));}
    //Unbreakable lantern-like blocks (+ custom color)
    public BlockModUnbreakable(MapColor color, int lightLevel) {this(Properties.ofFullCopy(SEA_LANTERN).mapColor(color).lightLevel((state) -> lightLevel));}
}