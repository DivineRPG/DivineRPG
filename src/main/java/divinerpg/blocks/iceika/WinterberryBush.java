package divinerpg.blocks.iceika;

import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;

import static divinerpg.registries.ItemRegistry.winterberry;
import static net.minecraft.sounds.SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES;
import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.stats.Stats.ITEM_USED;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.BLOOM;
import static net.neoforged.neoforge.common.ItemAbilities.SHEARS_DIG;

public class WinterberryBush extends Block implements BonemealableBlock {
    public static final BooleanProperty RIPE = BLOOM;
    public WinterberryBush(Properties p) {
        super(p);
        registerDefaultState(stateDefinition.any().setValue(RIPE, false));
    }
    @Override protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        float baseProgress = super.getDestroyProgress(state, player, level, pos);
        return player.getMainHandItem().canPerformAction(SHEARS_DIG) ? baseProgress * 2 : baseProgress;
    }

    @Override
    public void playerDestroy(ServerLevel level, ServerPlayer player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        if(player.getMainHandItem().getItem() instanceof ShearsItem) player.awardStat(ITEM_USED.get(destroyedWith.getItem()));
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }
    @Override public boolean isRandomlyTicking(BlockState state) {return !state.getValue(RIPE);}
    @Override public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(random.nextFloat() < .11F) level.setBlock(pos, state.setValue(RIPE, true), 3);
    }
    @Override public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos pos, BlockState state, BonemealSource bonemealSource) {
        level.setBlock(pos, state.setValue(RIPE, true), 3);
    }
    @Override public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState state, BonemealSource bonemealSource) {return !state.getValue(RIPE);}
    @Override public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult p_60508_) {
        if(state.getValue(RIPE)) {
            popResource(level, pos, new ItemStack(winterberry.get(), 1));
            level.playSound(null, pos, SWEET_BERRY_BUSH_PICK_BERRIES, BLOCKS, 1, .8F + level.getRandom().nextFloat() * .4F);
            level.setBlock(pos, state.setValue(RIPE, false), 2);
            return InteractionResult.SUCCESS;
        } return InteractionResult.PASS;
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(RIPE);}
    @Override public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state, BonemealSource bonemealSource) {return true;}
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 100;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 60;}
}