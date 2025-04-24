package divinerpg.blocks.arcana;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.PortalBlockEntity;
import divinerpg.registries.*;
import divinerpg.util.UniversalPosition;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class BlockGateway extends BaseEntityBlock implements Portal {
    public static final MapCodec<BlockGateway> CODEC = simpleCodec(BlockGateway::new);
    @Override public MapCodec<BlockGateway> codec() {return CODEC;}
    public BlockGateway(Properties properties) {
        super(properties.instrument(NoteBlockInstrument.BASS));
    }
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.PORTAL.get().create(pos, state);
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(!entity.isOnPortalCooldown() && level instanceof ServerLevel serverLevel) {
            DimensionTransition d = getPortalDestination(serverLevel, entity, pos);
            if(d != null) {
                level.playSound(null, pos, SoundEvents.BEACON_DEACTIVATE, SoundSource.BLOCKS);
                entity.changeDimension(d);
            }
        }
    }
    @Override public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(stack.is(ItemRegistry.teleportation_star) && level.getBlockEntity(pos) instanceof PortalBlockEntity portal) {
            if(stack.has(DataComponentRegistry.dimension) && stack.has(DataComponentRegistry.position)) {
                portal.targetPosition = new UniversalPosition(ResourceKey.create(Registries.DIMENSION, stack.get(DataComponentRegistry.dimension)), stack.get(DataComponentRegistry.position));
                level.playSound(null, pos, SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS);
                player.getCooldowns().addCooldown(stack.getItem(), 40);
                return ItemInteractionResult.SUCCESS;
            }
        } return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    @Override
    public @Nullable DimensionTransition getPortalDestination(ServerLevel serverLevel, Entity entity, BlockPos blockPos) {
        if(serverLevel.getBlockEntity(blockPos) instanceof PortalBlockEntity portal && portal.hasTargetPos()) {
            ServerLevel targetLevel = portal.targetPosition.level(serverLevel.getServer());
            if(targetLevel.getBlockState(portal.targetPosition.blockPos().below()).is(TagRegistry.GATEWAY_RECEIVER))
                return new DimensionTransition(targetLevel, portal.targetPosition.blockPosVec().add(.5, 0, .5), entity.getKnownMovement(), entity.getYRot(), entity.getXRot(), false, DimensionTransition.DO_NOTHING.then(e -> e.level().playSound(null, e.getX(), e.getY(), e.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, .7F, 1F)).then(e -> e.setPortalCooldown(40)));
            //DivineRPG.LOGGER.info("invalid target: " + portal.targetPosition);
        } return null;
    }
}