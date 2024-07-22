package divinerpg.blocks.vanilla;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.bosses.AyeracoBeamBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.Nullable;

public class BlockAyeracoBeam extends BaseEntityBlock {
    public static final MapCodec<BlockAyeracoBeam> CODEC = simpleCodec(BlockAyeracoBeam::new);
	private BossBarColor color;
    @Override public MapCodec<BlockAyeracoBeam> codec() {return CODEC;}
    public BlockAyeracoBeam(Properties properties) {
        super(properties);
    }
    public BlockAyeracoBeam(BossBarColor color) {
        super(Properties.of().strength(6000000, 6000000).air());
        this.color = color;
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
    	return Shapes.empty();
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new AyeracoBeamBlockEntity(p_153215_, p_153216_);
    }
    public BossBarColor getColor() {
    	return color;
    }
}
