package divinerpg.blocks.iceika;

import divinerpg.DivineRPG;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockWinterberryVinesBody extends WeepingVinesPlantBlock implements BonemealableBlock {
	public static final BooleanProperty RIPE = BlockStateProperties.BERRIES;
	public BlockWinterberryVinesBody(Properties properties) {
		super(properties.randomTicks().lightLevel((state) -> state.getValue(RIPE) ? 5 : 1).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ));
		registerDefaultState(this.stateDefinition.any().setValue(RIPE, false));
	}
	@Override protected GrowingPlantHeadBlock getHeadBlock() {return (GrowingPlantHeadBlock) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry_vines_head"));}
	@Override
	public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(RIPE);
    }
	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(random.nextFloat() < 0.3F) level.setBlock(pos, state.setValue(RIPE, true), 3);
    }
	@Override
	public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		super.performBonemeal(level, random, pos, state);
		level.setBlock(pos, state.setValue(RIPE, true), 3);
	}
	@Override
	public boolean isValidBonemealTarget(BlockGetter p_53900_, BlockPos p_53901_, BlockState state, boolean p_53903_) {
		return !state.getValue(RIPE) || super.isValidBonemealTarget(p_53900_, p_53901_, state, p_53903_);
	}
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand p_60507_, BlockHitResult p_60508_) {
		if(state.getValue(RIPE)) {
	        popResource(level, pos, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry")), 1));
	        level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
	        level.setBlock(pos, state.setValue(RIPE, false), 2);
	        return InteractionResult.SUCCESS;
		} return InteractionResult.PASS;
	}
	@Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(RIPE);
    }
}