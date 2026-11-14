package divinerpg.blocks.vethea;

import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;

public class DungeonAir extends Block {
    public DungeonAir(Properties p) {
        super(p);
    }
    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        if(entity instanceof ServerPlayer && ((ServerPlayer) entity).gameMode.getGameModeForPlayer() == GameType.SURVIVAL)
            ((ServerPlayer) entity).addEffect(new MobEffectInstance(MobEffectRegistry.HEAVY_AIR, 20, 1, true, false, false));
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return context.isHoldingItem(BlockRegistry.dungeonAir.asItem()) ? Shapes.block() : Shapes.empty();
    }
    @Override
    public float getShadeBrightness(BlockState state, BlockGetter getter, BlockPos pos) {
        return 1.0F;
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }
    @Override
    protected boolean propagatesSkylightDown(BlockState state) {
        return true;
    }
    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if(random.nextInt(500) == 0) level.addParticle(ParticleTypes.SMOKE, pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(), .0, .0, .0);
    }
}