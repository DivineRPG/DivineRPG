package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.*;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.BlockHitResult;
import javax.annotation.Nullable;

import static net.minecraft.stats.Stats.ITEM_USED;

public class BlockModMobCage extends BlockMod {
	public final ResourceLocation type;
	public final TagKey<Item> spawnItem;
	protected final BlockPos relativePos;
	public BlockModMobCage(Properties properties, ResourceLocation type, @Nullable TagKey<Item> spawnItem, @Nullable BlockPos relativePos) {
		super(properties.pushReaction(PushReaction.BLOCK));
		this.type = type;
		//TODO: to make a check `isTagEmpty ? null : spawnItem`, that should allow stuff like: 1. if the tag is empty, all interactions summon; 2. if it contains only air — none, but breaking the block.
		this.spawnItem = spawnItem;
		this.relativePos = relativePos;
	}
	public BlockModMobCage(ResourceLocation type, TagKey<Item> spawnItem) {
		super(Properties.ofFullCopy(Blocks.SPAWNER).noOcclusion().pushReaction(PushReaction.BLOCK));
		this.type = type;
		this.spawnItem = spawnItem;
		relativePos = null;
	}
	public BlockModMobCage(ResourceLocation type, TagKey<Item> spawnItem, MapColor color) {
		super(Properties.ofFullCopy(Blocks.SPAWNER).noOcclusion().pushReaction(PushReaction.BLOCK).mapColor(color));
		this.type = type;
		this.spawnItem = spawnItem;
		relativePos = null;
	}
	public BlockModMobCage(ResourceLocation type, @Nullable TagKey<Item> spawnItem, MapColor color, @Nullable BlockPos relativePos) {
		super(Properties.ofFullCopy(Blocks.SPAWNER).noOcclusion().pushReaction(PushReaction.BLOCK).mapColor(color));
		this.type = type;
		this.spawnItem = spawnItem;
		this.relativePos = relativePos;
	}
	@Override public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
		if(!level.isClientSide && !player.isCreative()) BuiltInRegistries.ENTITY_TYPE.get(type).spawn((ServerLevel) level, null, player, relativePos == null ? pos : pos.offset(relativePos), MobSpawnType.MOB_SUMMONED, true, false);
		return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
	}
	@Override public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		if(!player.getCooldowns().isOnCooldown(stack.getItem()) && (spawnItem == null || stack.is(BuiltInRegistries.ITEM.getOrCreateTag(spawnItem)) && !stack.is(Items.AIR))) {
			if(!level.isClientSide) BuiltInRegistries.ENTITY_TYPE.get(type).spawn((ServerLevel) level, null, player, relativePos == null ? pos : pos.offset(relativePos), MobSpawnType.MOB_SUMMONED, true, false);
			if(spawnItem != null) {
				player.awardStat(ITEM_USED.get(stack.getItem()));
				stack.consume(1, player);
			} player.getCooldowns().addCooldown(stack.getItem(), 40);
			return ItemInteractionResult.SUCCESS;
		} return ItemInteractionResult.FAIL;
	}
}