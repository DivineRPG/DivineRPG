package divinerpg.blocks.vethea;

import divinerpg.config.Config;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.attribute.BedRule;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.phys.*;
import net.minecraft.world.ticks.TickPriority;

import java.util.*;

public class BlockNightmareBed extends BedBlock {
    public BlockNightmareBed(Properties properties) {
        super(DyeColor.BLACK, properties);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level worldIn, BlockPos pos, Player player, BlockHitResult hit) {
        if(player.getInventory().isEmpty() || !Config.Values.SAFER_VETHEA) {
            if(!worldIn.isClientSide()) {
                if(state.getValue(PART) != BedPart.HEAD) {
                    pos = pos.relative(state.getValue(FACING));
                    state = worldIn.getBlockState(pos);
                    if(!state.is(this)) return InteractionResult.CONSUME;
                }
                if(state.getValue(OCCUPIED)) {
                    player.sendSystemMessage(Component.translatable("block.minecraft.bed.occupied"));
                    return InteractionResult.SUCCESS;
                }
                if(worldIn.getChunkSource().getLightEngine().getLayerListener(LightLayer.BLOCK).getLightValue(pos) < 7 && worldIn.getChunkSource().getLightEngine().getLayerListener(LightLayer.SKY).getLightValue(pos) < 7) {
                    player.startSleepInBed(this, state, BedRule.CAN_SLEEP_WHEN_DARK, pos).ifLeft((problem) -> {
                        if(problem.message() != null) player.sendOverlayMessage(problem.message());
                    });
                    return InteractionResult.SUCCESS;
                } else {
                    Component message = LocalizeUtils.clientMessage(ChatFormatting.RED, "nightmare_bed.restrict", player.getDisplayName());
                    player.sendOverlayMessage(message);
                }
            }
        } else {
            Component message = LocalizeUtils.clientMessage(ChatFormatting.RED, "nightmare_bed.inventory_full", player.getDisplayName());
            player.sendSystemMessage(message);
        }
        return InteractionResult.CONSUME;
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(state.getValue(OCCUPIED)) {
            List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class, new AABB(pos), LivingEntity::isSleeping);
            setBedOccupied(state, level, pos, null, false);
        }
    }

    public void setBedOccupied(BlockState state, Level level, BlockPos pos, LivingEntity sleeper, boolean occupied) {
        if(occupied) level.scheduleTick(pos, this, 70, TickPriority.HIGH);
    }

    @Override
    public Optional<ServerPlayer.RespawnPosAngle> getRespawnPosition(BlockState state, EntityType<?> type, LevelReader level, BlockPos pos, float angle) {
        return BedBlock.findStandUpPosition(type, level, pos, state.getValue(BedBlock.FACING), angle).map((v) -> ServerPlayer.RespawnPosAngle.of(v, pos, angle));
    }
}