package divinerpg.items.base;

import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static divinerpg.registries.TagRegistry.MINEABLE_SHICKAXE;
import static net.minecraft.advancements.CriteriaTriggers.ITEM_USED_ON_BLOCK;
import static net.minecraft.core.Direction.DOWN;
import static net.minecraft.core.component.DataComponents.UNBREAKABLE;
import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.tags.BlockTags.*;
import static net.minecraft.world.item.Items.*;
import static net.minecraft.world.level.gameevent.GameEvent.BLOCK_CHANGE;
import static net.neoforged.api.distmarker.Dist.CLIENT;
import static net.neoforged.neoforge.common.ItemAbilities.*;

public class ItemShickaxe extends DiggerItem {
	public Integer nameColor;
    //Base constructor
    public ItemShickaxe(Tier tier, Properties properties) {
        super(tier, MINEABLE_SHICKAXE, (tier.getUses() == 0 ? properties.component(UNBREAKABLE, new Unbreakable(true)) : properties).attributes(ShovelItem.createAttributes(tier, 1, -2.4F)));
    }
    //Base shickaxes
    public ItemShickaxe(Tier tier) {this(tier, new Properties());}
    //Shickaxes with custom rarity
    public ItemShickaxe(Tier tier, int rarity) {
        this(tier, new Properties());
        nameColor = rarity;
    }
    private static final Set<ItemAbility> TOOL_ACTIONS = Stream.of(AXE_DIG, AXE_SCRAPE, AXE_STRIP, AXE_WAX_OFF, PICKAXE_DIG, SHOVEL_DIG, SHOVEL_FLATTEN, HOE_DIG, HOE_TILL).collect(Collectors.toCollection(Sets::newIdentityHashSet));
    @Override public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {return TOOL_ACTIONS.contains(itemAbility);}
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
            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } if(pair != null && !player.isShiftKeyDown()) {
        	Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();
            if(predicate.test(context)) {
               level.playSound(player, blockpos, SoundEvents.HOE_TILL, BLOCKS, 1, 1);
               if(!level.isClientSide) {
                  consumer.accept(context);
                  stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
               } return InteractionResult.sidedSuccess(level.isClientSide);
            }
        } BlockState blockstate1 = state.getToolModifiedState(context, SHOVEL_FLATTEN, false);
        BlockState blockstate2 = null;
        if(context.getClickedFace() != DOWN) {
        if(blockstate1 != null && level.isEmptyBlock(blockpos.above()) && player.isShiftKeyDown()) {
            level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, BLOCKS, 1, 1);
            blockstate2 = blockstate1;
        } else if(state.getBlock() instanceof CampfireBlock && state.getValue(CampfireBlock.LIT)) {
            if(!level.isClientSide) level.levelEvent(null, 1009, blockpos, 0);
            CampfireBlock.dowse(context.getPlayer(), level, blockpos, state);
            blockstate2 = state.setValue(CampfireBlock.LIT, Boolean.FALSE);
        } if(blockstate2 != null) {
                if(!level.isClientSide) {
                    level.setBlock(blockpos, blockstate2, 11);
                    level.gameEvent(BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, blockstate2));
                    if(player != null) stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
                } return InteractionResult.sidedSuccess(level.isClientSide);
            }
        } return InteractionResult.PASS;
    }
    @OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency((int)getTier().getSpeed()));
        TagKey<Block> tagKey = getTier().getIncorrectBlocksForDrops();
        if(tagKey == INCORRECT_FOR_DIAMOND_TOOL || tagKey == INCORRECT_FOR_NETHERITE_TOOL) tooltip.add(LocalizeUtils.harvestLevel(OBSIDIAN.asItem().getName(stack)));
        else if(tagKey == INCORRECT_FOR_IRON_TOOL) tooltip.add(LocalizeUtils.harvestLevel(DIAMOND.getName(stack)));
    }
    @Override public Component getName(ItemStack pStack) {
    	return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}