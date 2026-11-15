package divinerpg.blocks.arcana;

import divinerpg.block_entities.block.PortalBlockEntity;
import divinerpg.registries.DataComponentRegistry;
import divinerpg.utils.UniversalPosition;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import static divinerpg.registries.BlockEntityRegistry.PORTAL;
import static divinerpg.registries.ItemRegistry.teleportation_star;
import static divinerpg.registries.TagRegistry.Blocks.GATEWAY_RECEIVER;
import static net.minecraft.core.registries.Registries.DIMENSION;
import static net.minecraft.world.level.block.RenderShape.MODEL;

public class Gateway extends BaseEntityBlock implements Portal {
    public Gateway(Properties properties) {super(properties);}
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return PORTAL.get().create(pos, state);}
    @Override public RenderShape getRenderShape(BlockState state) {return MODEL;}
    @Override public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(!entity.isOnPortalCooldown() && level instanceof ServerLevel serverLevel) {
            TeleportTransition d = getPortalDestination(serverLevel, entity, pos);
            if(d != null) {
                level.playSound(null, pos, SoundEvents.BEACON_DEACTIVATE, SoundSource.BLOCKS);
                entity.teleport(d);
            }
        }
    }
    @Override public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(stack.is(teleportation_star) && !player.getCooldowns().isOnCooldown(teleportation_star.toStack()) && level.getBlockEntity(pos) instanceof PortalBlockEntity portal) {
            if(stack.has(DataComponentRegistry.dimension) && stack.has(DataComponentRegistry.position)) {
                portal.targetPosition = new UniversalPosition(ResourceKey.create(DIMENSION, stack.get(DataComponentRegistry.dimension)), stack.get(DataComponentRegistry.position));
                level.playSound(null, pos, SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS);
                player.getCooldowns().addCooldown(stack, 40);
                return InteractionResult.SUCCESS;
            }
        } return InteractionResult.PASS;
    }
    @Override public @Nullable TeleportTransition getPortalDestination(ServerLevel serverLevel, Entity entity, BlockPos blockPos) {
        if(serverLevel.getBlockEntity(blockPos) instanceof PortalBlockEntity portal && portal.targetPosition != null) {
            ServerLevel targetLevel = portal.targetPosition.level(serverLevel.getServer());
            if(targetLevel.getBlockState(portal.targetPosition.blockPos().below()).is(GATEWAY_RECEIVER))
                //TODO: to add separate sound event so that we can specify a different subtitle
                return new TeleportTransition(targetLevel, portal.targetPosition.blockPosVec().add(.5, 0, .5), entity.getKnownMovement(), entity.getYRot(), entity.getXRot(), TeleportTransition.DO_NOTHING.then(e -> e.level().playSound(null, e.getX(), e.getY(), e.getZ(), SoundEvents.PLAYER_TELEPORT, SoundSource.NEUTRAL, .7F, 1)).then(e -> e.setPortalCooldown(40)));
            //DivineRPG.LOGGER.info("invalid target: " + portal.targetPosition);
        } return null;
    }
}