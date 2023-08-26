package divinerpg.blocks.iceika;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModLeaves;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockSnowyCozybarkLeaves extends BlockModLeaves {
	public BlockSnowyCozybarkLeaves() {
		super(MapColor.SNOW, SoundType.POWDER_SNOW);
	}
	@Override
	public BlockState updateShape(BlockState state, Direction direction, BlockState s, LevelAccessor level, BlockPos pos, BlockPos p) {
		if(state.getValue(WATERLOGGED)) return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "cozybark_leaves")).defaultBlockState().setValue(DISTANCE, state.getValue(DISTANCE)).setValue(PERSISTENT, state.getValue(PERSISTENT)).setValue(WATERLOGGED, true);
		return super.updateShape(state, direction, s, level, pos, p);
	}
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		ItemStack stack = player.getItemInHand(hand);
		if(stack.is(Items.BUCKET)) {
			if(level.isClientSide()) player.playSound(SoundEvents.BUCKET_FILL_POWDER_SNOW);
			else {
				if(!player.isCreative()) stack.shrink(1);
				player.addItem(new ItemStack(Items.POWDER_SNOW_BUCKET));
				level.setBlock(pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "cozybark_leaves")).defaultBlockState().setValue(DISTANCE, state.getValue(DISTANCE)).setValue(PERSISTENT, state.getValue(PERSISTENT)).setValue(WATERLOGGED, false), UPDATE_ALL);
			} return InteractionResult.SUCCESS;
		} else if(stack.is(Items.WATER_BUCKET)) {
			if(level.isClientSide()) player.playSound(SoundEvents.BUCKET_EMPTY);
			else {
				if(!player.isCreative()) stack.shrink(1);
				player.addItem(new ItemStack(Items.BUCKET));
				level.setBlock(pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "cozybark_leaves")).defaultBlockState().setValue(DISTANCE, state.getValue(DISTANCE)).setValue(PERSISTENT, state.getValue(PERSISTENT)).setValue(WATERLOGGED, true), UPDATE_ALL);
			} return InteractionResult.SUCCESS;
		} return InteractionResult.PASS;
	}
	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		if(random.nextInt(15) == 1) {
            BlockPos blockpos = pos.below();
            BlockState blockstate = level.getBlockState(blockpos);
            if(!blockstate.canOcclude() || !blockstate.isFaceSturdy(level, blockpos, Direction.UP)) ParticleUtils.spawnParticleBelow(level, pos, random, ParticleTypes.SNOWFLAKE);
        }
	}
}