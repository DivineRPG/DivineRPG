package divinerpg.blocks.vanilla;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.BonfireBlockEntity;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.*;

import static net.minecraft.world.level.block.CampfireBlock.LIT;

public class Bonfire extends BaseEntityBlock {
    public static final MapCodec<Bonfire> CODEC = simpleCodec(Bonfire::new);
    public Bonfire(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(LIT, false));
    }
    @Override protected MapCodec<? extends BaseEntityBlock> codec() {return CODEC;}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(LIT);}
    @Override protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(!stack.isEmpty() && level.getBlockEntity(pos) instanceof BonfireBlockEntity b) {
            int lifeTime = -1;
            if(stack.is(Blocks.NETHERRACK.asItem())) lifeTime = 0;
            int burntime = stack.getBurnTime(RecipeType.SMELTING);
            if(burntime > 0) lifeTime = b.lifeTime + burntime;
            if(lifeTime > -1) {
                b.lifeTime = lifeTime;
                stack.consume(1, player);
                if(!state.getValue(LIT)) level.setBlock(pos, state.setValue(LIT, true), 3);
                level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 0.8F, 1F);
                return ItemInteractionResult.SUCCESS;
            }
        } return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    @Override public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if(ItemAbilities.SHOVEL_DOUSE == itemAbility && state.is(BlockRegistry.bonfire) && state.getValue(LIT)) {
            if(!simulate) {
                Level level = context.getLevel();
                BlockPos pos = context.getClickedPos();
                if(level.isClientSide()) for(int i = 0; i < 20; ++i) CampfireBlock.makeParticles(level, pos, true, true);
                if(level.getBlockEntity(pos) instanceof BonfireBlockEntity b) b.lifeTime = 0;
                level.gameEvent(context.getPlayer(), GameEvent.BLOCK_CHANGE, pos);
            } return state.setValue(LIT, false);
        } return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
    @Override protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(state.getValue(LIT) && entity instanceof LivingEntity) entity.hurt(level.damageSources().campfire(), 1);
    }
    @Override protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
    @Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if(state.getValue(LIT)) {
            if(random.nextInt(10) == 0) level.playLocalSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 0.5F + random.nextFloat(), random.nextFloat() * 0.7F + 0.6F, false);
            if(random.nextInt(5) == 0) for(int i = 0; i < random.nextInt(1) + 1; ++i) level.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, (random.nextFloat() / 2.0F), 5.0E-5, (random.nextFloat() / 2.0F));
        }
    }
    @Override protected void onProjectileHit(Level level, BlockState state, BlockHitResult hit, Projectile projectile) {
        BlockPos blockpos = hit.getBlockPos();
        if(!level.isClientSide && projectile.isOnFire() && projectile.mayInteract(level, blockpos) && !state.getValue(LIT)) {
            level.setBlock(blockpos, state.setValue(LIT, true), 11);
        }
    }
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.BONFIRE.get().create(pos, state);
    }
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if(state.getValue(LIT)) {
            return level.isClientSide ? createTickerHelper(blockEntityType, BlockEntityRegistry.BONFIRE.get(), BonfireBlockEntity::particleTick)
            : createTickerHelper(blockEntityType, BlockEntityRegistry.BONFIRE.get(), BonfireBlockEntity::serverTick);
        } return null;
    }
    @Override protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {return false;}
}