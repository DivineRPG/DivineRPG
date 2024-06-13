package divinerpg.blocks.iceika;

import divinerpg.DivineRPG;
import divinerpg.blocks.arcana.BlockArcaniteVinesHead;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockWinterberryVinesHead extends BlockArcaniteVinesHead {
	public static final BooleanProperty RIPE = BlockStateProperties.BLOOM;

	public BlockWinterberryVinesHead(Properties properties) {
		super(properties.lightLevel((state) -> 1).dynamicShape());
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
		BlockState aboveState = level.getBlockState(pos.above());
		if (aboveState.getBlock() == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry_vines_body")) && aboveState.getValue(RIPE)) {
			popResource(level, pos.above(), new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry")), 1));
		}
		return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
	}

	@Override
	protected Block getBodyBlock() {
		return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry_vines_body"));
	}
}
