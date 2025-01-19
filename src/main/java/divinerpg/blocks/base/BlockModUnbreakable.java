package divinerpg.blocks.base;

import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.SEA_LANTERN;

public class BlockModUnbreakable extends BlockMod {
    //Unbreakable stone-like blocks
    public BlockModUnbreakable(MapColor color) {super(color, -1, 3600000);}
    //Unbreakable stone-like blocks with custom properties
    public BlockModUnbreakable(Properties properties) {super(properties.strength(-1, 3600000));}
    //Unbreakable lantern-like blocks
    public BlockModUnbreakable(MapColor color, int lightLevel) {this(Properties.ofFullCopy(SEA_LANTERN).mapColor(color).lightLevel((state) -> lightLevel));}
}