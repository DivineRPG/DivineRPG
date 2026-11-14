package divinerpg.blocks.vethea;

import divinerpg.utils.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import static net.minecraft.ChatFormatting.AQUA;
import static net.minecraft.world.Difficulty.PEACEFUL;

public abstract class VetheaAltar extends Block {
    protected VetheaAltar(Properties p) {super(p);}
    @Override public InteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(stack.getItem() == acceptedItem()) {
            if(world.getDifficulty() == PEACEFUL) {
                player.sendOverlayMessage(LocalizeUtils.clientMessage(AQUA, "boss.peaceful"));
                return InteractionResult.CONSUME;
            } else {
                player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                player.getCooldowns().addCooldown(stack, 40);
                stack.consume(1, player);
                spawnBoss(world, pos);
                return InteractionResult.SUCCESS;
            }
        } else onFailure();
        return InteractionResult.PASS;
    }
    public void spawnBoss(Level worldIn, BlockPos pos) {
        if(!worldIn.isClientSide()) getBoss(worldIn).getType().spawn((ServerLevel) worldIn, ItemStack.EMPTY, null, pos, EntitySpawnReason.MOB_SUMMONED, false, false);
    }
    protected abstract Item acceptedItem();
    protected abstract LivingEntity getBoss(Level world);
    protected abstract void onFailure();
}