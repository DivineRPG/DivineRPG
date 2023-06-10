package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;

public class BlockMod extends Block {
    private final int flammability;
    private final int fireSpread;

    public BlockMod(Block.Properties properties) {
        super(properties);
        this.flammability = 0;
        this.fireSpread = 0;
    }

    public BlockMod(MapColor color, float hardness, float resistance) {
        super(Block.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(hardness, resistance));
        this.flammability = 0;
        this.fireSpread = 0;
    }

    public BlockMod(float hardness, float resistance, MapColor color, SoundType sound, int flammability, int fireSpread) {
        super(Block.Properties.of().mapColor(color).strength(hardness, resistance).sound(sound));
        this.flammability = flammability;
        this.fireSpread = fireSpread;
    }

    public BlockMod(MapColor color, int luminance) {
        super(Block.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(50F, 1200F).pushReaction(PushReaction.BLOCK).lightLevel((state) -> luminance));
        this.flammability = 0;
        this.fireSpread = 0;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
            return flammability;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
            return fireSpread;
    }
}
