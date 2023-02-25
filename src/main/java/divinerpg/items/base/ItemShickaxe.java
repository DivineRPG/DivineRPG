package divinerpg.items.base;

import com.google.common.collect.*;
import com.mojang.datafixers.util.Pair;

import divinerpg.*;
import divinerpg.util.*;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.common.*;

import javax.annotation.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.*;

import static net.minecraftforge.common.ToolActions.*;

public class ItemShickaxe extends DiggerItem {

    protected final Tier tier;

    public ItemShickaxe(Rarity rarity, Tier tier) {
        super(1.0F, -2.8F, tier, BlockTags.create(new ResourceLocation(DivineRPG.MODID, "shickaxe_effective")), new Item.Properties().tab(DivineRPG.tabs.tools).durability(tier.getUses()).rarity(rarity));
        this.tier = tier;
    }

    public ItemShickaxe(Tier tier) {
        super(1.0F, -2.8F, tier, BlockTags.create(new ResourceLocation(DivineRPG.MODID, "shickaxe_effective")), new Item.Properties().tab(DivineRPG.tabs.tools).durability(tier.getUses()));
        this.tier = tier;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency(speed));
        tooltip.add(LocalizeUtils.harvestLevel(getTier().getLevel()));

        if(getMaxDamage(stack) == -1) {
            tooltip.add(LocalizeUtils.infiniteUses());
        } else {
            tooltip.add(LocalizeUtils.usesRemaining(getTier().getUses() - getDamage(stack)));
        }
    }


    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, (context) -> {
            context.broadcastBreakEvent(attacker.getUsedItemHand());
        });
        return true;
    }

    private static final Set<ToolAction> TOOL_ACTIONS = Stream.of(AXE_DIG, PICKAXE_DIG, SHOVEL_DIG, HOE_DIG/*, HOE_TILL*/).collect(Collectors.toCollection(Sets::newIdentityHashSet));

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return TOOL_ACTIONS.contains(toolAction);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
    	Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(new UseOnContext(context.getLevel(), context.getPlayer(), context.getHand(), new ItemStack(Items.DIAMOND_HOE), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), context.getClickedPos(), context.isInside())), ToolActions.HOE_TILL, false);
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, HoeItem.changeIntoState(toolModifiedState));
        if(pair != null) {
        	Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();
            if(predicate.test(context)) {
               Player player = context.getPlayer();
               level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1F, 1F);
               if(!level.isClientSide) {
                  consumer.accept(context);
                  if(player != null) {
                     context.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> {
                        p_150845_.broadcastBreakEvent(context.getHand());
                     });
                  }
               }
               return InteractionResult.sidedSuccess(level.isClientSide);
            }
        } return InteractionResult.PASS;
    }
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_AXE)) return speed;
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) return speed;
        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL)) return speed;
        if (state.is(BlockTags.MINEABLE_WITH_HOE)) return speed;
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
            return TierSortingRegistry.isCorrectTierForDrops(tier, state);
        if (state.is(BlockTags.MINEABLE_WITH_AXE))
            return TierSortingRegistry.isCorrectTierForDrops(tier, state);
        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
            return TierSortingRegistry.isCorrectTierForDrops(tier, state);
        if (state.is(BlockTags.MINEABLE_WITH_HOE))
            return TierSortingRegistry.isCorrectTierForDrops(tier, state);
        return false;
    }
}