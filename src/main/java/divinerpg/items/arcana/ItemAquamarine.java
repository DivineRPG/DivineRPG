package divinerpg.items.arcana;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import static net.minecraft.advancements.triggers.CriteriaTriggers.PLACED_BLOCK;
import static net.minecraft.stats.Stats.ITEM_USED;
import static net.minecraft.world.level.material.Fluids.WATER;

public class ItemAquamarine extends BucketItem {
    public ItemAquamarine(Properties properties) {
        super(WATER, properties.durability(3));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        BlockHitResult blockhitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);

        if (blockhitresult.getType() == HitResult.Type.MISS || blockhitresult.getType() != HitResult.Type.BLOCK) {
            return InteractionResult.PASS;
        }

        BlockPos blockpos = blockhitresult.getBlockPos();
        BlockState blockstate = level.getBlockState(blockpos);

        if (blockstate.is(Blocks.CAULDRON)) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(blockpos, Blocks.WATER_CAULDRON.defaultBlockState().setValue(LayeredCauldronBlock.LEVEL, 3));
                level.playSound(null, blockpos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(player, GameEvent.FLUID_PLACE, blockpos);

                player.awardStat(ITEM_USED.get(this));
                if (!player.isCreative()) {
                    itemstack.hurtAndBreak(1, player, hand);
                }
            }
            return InteractionResult.SUCCESS;
        } else if (blockstate.is(Blocks.WATER_CAULDRON)) {
            int currentLevel = blockstate.getValue(LayeredCauldronBlock.LEVEL);
            if (currentLevel < 3) {
                if (!level.isClientSide()) {
                    level.setBlockAndUpdate(blockpos, blockstate.setValue(LayeredCauldronBlock.LEVEL, currentLevel + 1));
                    level.playSound(null, blockpos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.gameEvent(player, GameEvent.FLUID_PLACE, blockpos);

                    player.awardStat(ITEM_USED.get(this));
                    if (!player.isCreative()) {
                        itemstack.hurtAndBreak(1, player, hand);
                    }
                }
                return InteractionResult.SUCCESS;
            }
        }
        Direction direction = blockhitresult.getDirection();
        BlockPos blockpos1 = blockpos.relative(direction);

        if (level.mayInteract(player, blockpos) && player.mayUseItemAt(blockpos1, direction, itemstack)) {
            BlockPos blockpos2 = canBlockContainFluid(player, level, blockpos, blockstate) ? blockpos : blockpos1;
            if (emptyContents(player, level, blockpos2, blockhitresult, itemstack)) {
                if (player instanceof ServerPlayer) {
                    PLACED_BLOCK.trigger((ServerPlayer) player, blockpos2, itemstack);
                }
                player.awardStat(ITEM_USED.get(this));
                if (!player.isCreative()) {
                    itemstack.setDamageValue(itemstack.getDamageValue() + 1);
                    if (itemstack.getDamageValue() >= itemstack.getMaxDamage()) {
                        return InteractionResult.SUCCESS;
                    }
                }
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.FAIL;
            }
        } else {
            return InteractionResult.FAIL;
        }
    }
}