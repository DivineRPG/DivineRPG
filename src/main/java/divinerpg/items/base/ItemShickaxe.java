package divinerpg.items.base;

import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;
import divinerpg.utils.ToolStats;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static divinerpg.registries.TagRegistry.MINEABLE_SHICKAXE;
import static net.minecraft.advancements.triggers.CriteriaTriggers.ITEM_USED_ON_BLOCK;
import static net.minecraft.core.Direction.DOWN;
import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.world.level.gameevent.GameEvent.BLOCK_CHANGE;
import static net.neoforged.neoforge.common.ItemAbilities.*;

public class ItemShickaxe extends ItemMod {
    public ItemShickaxe(ToolStats stats,Properties properties) {
        super(properties.tool(stats.getMaterial(), MINEABLE_SHICKAXE, 1.0F, -2.4F, 0));
    }

    private static final Set<ItemAbility> TOOL_ACTIONS = Stream.of(AXE_SCRAPE, AXE_STRIP, AXE_WAX_OFF, SHOVEL_FLATTEN, HOE_TILL).collect(Collectors.toCollection(Sets::newIdentityHashSet));

    @Override
    public boolean canPerformAction(ItemInstance stack, ItemAbility itemAbility) {
        return TOOL_ACTIONS.contains(itemAbility);
    }

    @Override public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState state = level.getBlockState(blockpos);
        InteractionHand hand = context.getHand();
        Player player = context.getPlayer();
        BlockState toolModifiedState = state.getToolModifiedState(context, HOE_TILL, false);
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, HoeItem.changeIntoState(toolModifiedState));
        Optional<BlockState> optional = Optional.ofNullable(state.getToolModifiedState(context, AXE_STRIP, false));
        Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(state.getToolModifiedState(context, AXE_SCRAPE, false));
        Optional<BlockState> optional2 = optional.isPresent() || optional1.isPresent() ? Optional.empty() : Optional.ofNullable(state.getToolModifiedState(context, AXE_WAX_OFF, false));
        ItemStack stack = context.getItemInHand();
        Optional<BlockState> optional3 = Optional.empty();
        if(optional.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, BLOCKS, 1, 1);
            optional3 = optional;
        } else if(optional1.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, BLOCKS, 1, 1);
            level.levelEvent(player, 3005, blockpos, 0);
            optional3 = optional1;
        } else if(optional2.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, BLOCKS, 1, 1);
            level.levelEvent(player, 3004, blockpos, 0);
            optional3 = optional2;
        } if(optional3.isPresent()) {
            if(player instanceof ServerPlayer) ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, stack);
            level.setBlock(blockpos, optional3.get(), 11);
            level.gameEvent(BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional3.get()));
            stack.hurtAndBreak(1, player, hand);
            return InteractionResult.SUCCESS;
        } if(pair != null && !player.isShiftKeyDown()) {
            Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();
            if(predicate.test(context)) {
                level.playSound(player, blockpos, SoundEvents.HOE_TILL, BLOCKS, 1, 1);
                if(!level.isClientSide()) {
                    consumer.accept(context);
                    stack.hurtAndBreak(1, player, hand);
                } return InteractionResult.SUCCESS;
            }
        } BlockState blockstate1 = state.getToolModifiedState(context, SHOVEL_FLATTEN, false);
        BlockState blockstate2 = null;
        if(context.getClickedFace() != DOWN) {
            if(blockstate1 != null && level.isEmptyBlock(blockpos.above()) && player.isShiftKeyDown()) {
                level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, BLOCKS, 1, 1);
                blockstate2 = blockstate1;
            } else if(state.getBlock() instanceof CampfireBlock && state.getValue(CampfireBlock.LIT)) {
                if(!level.isClientSide()) level.levelEvent(null, 1009, blockpos, 0);
                CampfireBlock.dowse(context.getPlayer(), level, blockpos, state);
                blockstate2 = state.setValue(CampfireBlock.LIT, false);
            } if(blockstate2 != null) {
                if(!level.isClientSide()) {
                    level.setBlock(blockpos, blockstate2, 11);
                    level.gameEvent(BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, blockstate2));
                    if(player != null) stack.hurtAndBreak(1, player, hand);
                } return InteractionResult.SUCCESS;
            }
        } return InteractionResult.PASS;
    }
}
