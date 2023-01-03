package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class BlockModMobCage extends BlockMod {
	public final ResourceLocation type, spawnItem;
	protected final BlockPos relativePos;
	public BlockModMobCage(ResourceLocation type, ResourceLocation spawnItem) {
		super(Properties.copy(Blocks.SPAWNER).strength(0.1F).noOcclusion());
		this.type = type;
		this.spawnItem = spawnItem;
		relativePos = null;
	}
	public BlockModMobCage(ResourceLocation type, @Nullable ResourceLocation spawnItem, @Nullable BlockPos relativePos) {
		super(Properties.copy(Blocks.SPAWNER).strength(.1F).noOcclusion());
		this.type = type;
		this.spawnItem = spawnItem;
		this.relativePos = relativePos;
	}
	@Override
	public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
		if(!level.isClientSide && !player.isCreative()) {
			ForgeRegistries.ENTITY_TYPES.getValue(type).spawn((ServerLevel) level, null, player, relativePos == null ? pos : pos.offset(relativePos), MobSpawnType.MOB_SUMMONED, true, false);
		} return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
	}
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		if(!level.isClientSide && !player.isCreative()) {
			ItemStack item = player.getItemInHand(hand);
			if(!player.getCooldowns().isOnCooldown(item.getItem()) && (spawnItem == null || item.is(ForgeRegistries.ITEMS.getValue(spawnItem)))) {
				if(!(spawnItem == null || player.isCreative())) {
					item.shrink(1);
					player.setItemInHand(hand, item);
					player.getCooldowns().addCooldown(item.getItem(), 40);
				}
				ForgeRegistries.ENTITY_TYPES.getValue(type).spawn((ServerLevel) level, null, player, relativePos == null ? pos : pos.offset(relativePos), MobSpawnType.MOB_SUMMONED, true, false);
				return InteractionResult.SUCCESS;
			}
		} return InteractionResult.FAIL;
	}
}