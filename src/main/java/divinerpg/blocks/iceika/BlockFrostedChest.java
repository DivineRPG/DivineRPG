package divinerpg.blocks.iceika;

import divinerpg.block_entities.chests.FrostedChestBlockEntity;
import divinerpg.blocks.base.BlockModChest;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.server.level.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;

public class BlockFrostedChest extends BlockModChest {
    public BlockFrostedChest() {
        super(Properties.copy(Blocks.ICE).strength(2.5F).randomTicks().noOcclusion(), () -> BlockEntityRegistry.FROSTED_CHEST.get());
    }
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    	MutableBlockPos p = pos.offset(2, 2, 2).mutable();
		for(int x = 0; x < 5; x++) {
			for(int y = 0; y < 5; y++) {
				for(int z = 0; z < 5; z++) {
					if(level.getBlockState(p).is(Blocks.WATER) && random.nextInt(x == 0 || x == 4 || y == 0 || y == 4 || z == 0 || z == 4 ? 4 : 2) == 0) {
						level.setBlock(p, Blocks.ICE.defaultBlockState(), UPDATE_ALL);
						return;
					} p.move(0, 0, -1);
				} p.move(0, -1, 5);
			} p.move(-1, 5, 0);
		}
    }
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
    	if(state.getValue(WATERLOGGED)) return InteractionResult.PASS;
    	return super.use(state, level, pos, player, hand, hit);
    }
    @Override
    public ItemStack pickupBlock(LevelAccessor level, BlockPos pos, BlockState state) {
    	return ItemStack.EMPTY;
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
    	if(state.getValue(WATERLOGGED)) return Shapes.block();
    	return super.getShape(state, getter, pos, context);
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new FrostedChestBlockEntity(p_153215_, p_153216_);
    }

    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity te, ItemStack stack) {
        super.playerDestroy(world, player, pos, state, te, stack);
        if (player instanceof ServerPlayer) {
            TriggerRegistry.DIVINERPG_BLOCK.trigger((ServerPlayer) player, this);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
        RandomSource random = rand;
        for (int i = 0; i < 6; ++i) {
            double d1 = pos.getX() + random.nextFloat();
            double d2 = pos.getY() + random.nextFloat();
            double d3 = pos.getZ() + random.nextFloat();

            if (i == 0 && !worldIn.getBlockState(pos.above()).canOcclude()) {
                d2 = pos.getY() + 0.0625D + 1.0D;
            }

            if (i == 1 && !worldIn.getBlockState(pos.below()).canOcclude()) {
                d2 = pos.getY() - 0.0625D;
            }

            if (i == 2 && !worldIn.getBlockState(pos.south()).canOcclude()) {
                d3 = pos.getZ() + 0.0625D + 1.0D;
            }

            if (i == 3 && !worldIn.getBlockState(pos.north()).canOcclude()) {
                d3 = pos.getZ() - 0.0625D;
            }

            if (i == 4 && !worldIn.getBlockState(pos.east()).canOcclude()) {
                d1 = pos.getX() + 0.0625D + 1.0D;
            }

            if (i == 5 && !worldIn.getBlockState(pos.west()).canOcclude()) {
                d1 = pos.getX() - 0.0625D;
            }

            if (d1 < pos.getX() || d1 > pos.getX() + 1 || d2 < 0.0D || d2 > pos.getY() + 1 || d3 < pos.getZ()
                    || d3 > pos.getZ() + 1) {
                if (rand.nextInt(10) <= 5) {
                    worldIn.addParticle(ParticleRegistry.FROST.get(), d1, d2, d3, 0.0D, 0.5D, 0.0D);
                }
            }
        }
    }
}