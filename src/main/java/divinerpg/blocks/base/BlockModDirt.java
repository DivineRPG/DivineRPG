package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;

public class BlockModDirt extends BlockMod {
    public BlockModDirt(MapColor color) {super(Block.Properties.of().mapColor(color).strength(.5F).sound(SoundType.ROOTED_DIRT));}
}