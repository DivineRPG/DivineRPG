package divinerpg.blocks.vanilla;

import divinerpg.block_entities.block.BonfireBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CookingFuel;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.providers.number.ints.ResolvableInt;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.Optional;

import static net.minecraft.world.level.block.CampfireBlock.LIT;

public class Bonfire extends BaseEntityBlock {
    public Bonfire(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(LIT, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(LIT);}
    @Override protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(!stack.isEmpty() && level.getBlockEntity(pos) instanceof BonfireBlockEntity b) {
            int lifeTime = -1;
            if(stack.is(Blocks.NETHERRACK.asItem())) lifeTime = 0;
            if(level instanceof ServerLevel s) {
                int burntime = ResolvableInt.getFromItem(stack, DataComponents.COOKING_FUEL, CookingFuel::burnTime, new LootContext.Builder(new LootParams.Builder(s).withParameter(LootContextParams.BLOCK_STATE, state).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos)).withOptionalParameter(LootContextParams.BLOCK_ENTITY, b).withOptionalParameter(LootContextParams.INTERACTING_ENTITY, player).withOptionalParameter(LootContextParams.TOOL, stack.isEmpty() ? null : stack).create(LootContextParamSets.BLOCK_INTERACT)).create(Optional.empty()), 0);
                if(burntime > 0) lifeTime = b.lifeTime + burntime;
            }
            if(lifeTime > -1) {
                b.lifeTime = lifeTime;
                stack.consume(1, player);
                if(!state.getValue(LIT)) level.setBlock(pos, state.setValue(LIT, true), 3);
                level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 0.8F, 1F);
                return InteractionResult.SUCCESS;
            }
        } return InteractionResult.PASS;
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
    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
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
        if(level instanceof ServerLevel s && projectile.isOnFire() && projectile.mayInteract(s, blockpos) && !state.getValue(LIT)) {
            level.setBlock(blockpos, state.setValue(LIT, true), 11);
        }
    }
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.BONFIRE.get().create(pos, state);
    }
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if(state.getValue(LIT)) {
            return level.isClientSide() ? createTickerHelper(blockEntityType, BlockEntityRegistry.BONFIRE.get(), BonfireBlockEntity::particleTick)
                    : createTickerHelper(blockEntityType, BlockEntityRegistry.BONFIRE.get(), BonfireBlockEntity::serverTick);
        } return null;
    }
    @Override protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {return false;}
}