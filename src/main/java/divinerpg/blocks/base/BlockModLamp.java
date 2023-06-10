package divinerpg.blocks.base;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class BlockModLamp extends BlockMod {
    public BlockModLamp(MapColor color) {
        super(Block.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.LANTERN).lightLevel((state) -> 15));
    }

    public BlockModLamp(MapColor color, SoundType sound) {
        super(Block.Properties.of().mapColor(color).strength(0.3F).sound(sound).lightLevel((state) -> 15));
    }

}