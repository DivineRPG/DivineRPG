package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;

public class BlockMod extends Block {
    private final boolean isNotPushable;

    public BlockMod(Block.Properties properties) {
        super(properties);
        this.isNotPushable = false;
    }

    public BlockMod(MapColor color, float hardness, float resistance) {
        super(Block.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(hardness, resistance));
        this.isNotPushable = false;
    }

    public BlockMod(float hardness, float resistance, MapColor color, SoundType sound) {
        super(Block.Properties.of().mapColor(color).strength(hardness, resistance).sound(sound));
        this.isNotPushable = false;
    }

    public BlockMod(MapColor color, boolean isNotPushable, int luminance) {
        super(Block.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(50F, 1200F).lightLevel((state) -> luminance));
        this.isNotPushable = isNotPushable;
    }

}