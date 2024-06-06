package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;

public class BlockModStem extends RotatedPillarBlock {
    public BlockModStem(MapColor color) {super(Properties.copy(Blocks.MUSHROOM_STEM).mapColor(color));}
}