package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.tags.BlockTags.SAND;
import static net.minecraft.world.level.block.Blocks.POPPY;

public class BlockModFlower extends FlowerBlock {
    private final boolean canGrowOnSand;

    public BlockModFlower(Holder<MobEffect> mobEffects, float seconds, Properties properties, boolean canGrowOnSand) {
        super(mobEffects, seconds, properties);
        this.canGrowOnSand = canGrowOnSand;
    }

    public BlockModFlower(Properties properties) {
        this(MobEffects.SPEED, 0.0F, properties, false);
    }

    public BlockModFlower(Holder<MobEffect> mobEffects, float seconds, MapColor color, boolean canGrowOnSand) {
        this(mobEffects, seconds, Properties.ofFullCopy(POPPY).mapColor(color).sound(SoundType.CROP), canGrowOnSand);
    }

    public BlockModFlower(Holder<MobEffect> mobEffects, float seconds, MapColor color) {
        this(mobEffects, seconds, color, false);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return super.mayPlaceOn(state, level, pos) || (canGrowOnSand && state.is(SAND));
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 100;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 60;
    }
}