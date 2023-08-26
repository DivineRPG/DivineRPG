package divinerpg.blocks.iceika;

import static net.minecraft.world.level.material.MapColor.CRIMSON_STEM;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModLeaves;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockCozybarkLeaves extends BlockModLeaves {
	public BlockCozybarkLeaves() {
		super(CRIMSON_STEM, SoundType.CHERRY_LEAVES);
	}
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		ItemStack stack = player.getItemInHand(hand);
		if(stack.is(Items.POWDER_SNOW_BUCKET)) {
			if(level.isClientSide()) player.playSound(SoundEvents.BUCKET_EMPTY_POWDER_SNOW);
			else {
				if(!player.isCreative()) stack.shrink(1);
				player.addItem(new ItemStack(Items.BUCKET));
				level.setBlock(pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "snowy_cozybark_leaves")).defaultBlockState().setValue(DISTANCE, state.getValue(DISTANCE)).setValue(PERSISTENT, state.getValue(PERSISTENT)).setValue(WATERLOGGED, false), UPDATE_ALL);
			} return InteractionResult.SUCCESS;
		} return InteractionResult.PASS;
	}
}