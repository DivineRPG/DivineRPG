package divinerpg.blocks.arcana;

import divinerpg.blocks.base.BlockMod;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.*;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.Nullable;

public class BlockElevantium extends BlockMod {
    protected static final VoxelShape ELEVANTIUM = Shapes.or(box(1, 0, 1, 15, 1, 15),
                                                             box(4.5, 1, 4.5, 11.5, 2, 11.5));
    public BlockElevantium() {
        super(Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE).pushReaction(PushReaction.DESTROY));
    }
    @Override public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        int signal = world.getBestNeighborSignal(pos);
        if(signal > 0) {
            entity.addDeltaMovement(new Vec3(0, signal * .25, 0));
            entity.hasImpulse = true;
            world.playSound(null, pos, SoundRegistry.CONSTRUCTOR_PUNCH.get(), SoundSource.BLOCKS, .75F, .9F);
        }
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return ELEVANTIUM;
    }
    @Override public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return Shapes.create(ELEVANTIUM.bounds().inflate(.0625, .125, .0625));
    }
    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        return true;
    }
}