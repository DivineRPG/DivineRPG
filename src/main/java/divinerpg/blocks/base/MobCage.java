package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

import static net.minecraft.stats.Stats.ITEM_USED;

public class MobCage extends Block {
    public final Holder<EntityType<?>> type;
    public final TagKey<Item> spawnItem;
    protected final BlockPos relativePos;
    public MobCage(Properties properties, Holder<EntityType<?>> type, @Nullable TagKey<Item> spawnItem, @Nullable BlockPos relativePos) {
        super(properties);
        this.type = type;
        //TODO: to make a check `isTagEmpty ? null : spawnItem`, that should allow stuff like: 1. if the tag is empty, all interactions summon; 2. if it contains only air — none, but breaking the block.
        this.spawnItem = spawnItem;
        this.relativePos = relativePos;
    }
    public MobCage(Properties p, Holder<EntityType<?>> type, TagKey<Item> spawnItem) {
        super(p);
        this.type = type;
        this.spawnItem = spawnItem;
        relativePos = null;
    }
    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, ItemStack toolStack, boolean willHarvest, FluidState fluid) {
        if(!level.isClientSide() && !player.isCreative()) type.value().spawn((ServerLevel) level, null, player, relativePos == null ? pos : pos.offset(relativePos), EntitySpawnReason.SPAWNER, true, false);
        return super.onDestroyedByPlayer(state, level, pos, player, toolStack, willHarvest, fluid);
    }
    @Override public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(!player.getCooldowns().isOnCooldown(stack) && (spawnItem == null || stack.is(spawnItem) && !stack.is(Items.AIR))) {
            if(!level.isClientSide()) type.value().spawn((ServerLevel) level, null, player, relativePos == null ? pos : pos.offset(relativePos), EntitySpawnReason.SPAWNER, true, false);
            if(spawnItem != null) {
                player.awardStat(ITEM_USED.get(stack.getItem()));
                stack.consume(1, player);
            } player.getCooldowns().addCooldown(stack, 40);
            return InteractionResult.SUCCESS;
        } return InteractionResult.FAIL;
    }
}