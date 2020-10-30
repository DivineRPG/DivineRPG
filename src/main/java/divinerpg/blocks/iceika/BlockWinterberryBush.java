package divinerpg.blocks.iceika;

import divinerpg.blocks.base.BlockMod;
import divinerpg.registries.ItemRegistry;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.state.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BlockWinterberryBush extends BlockMod implements IGrowable {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_1;

    public BlockWinterberryBush(String name) {
        super(name, Block.Properties
                .create(Material.LEAVES)
                .hardnessAndResistance(0.2F, 0.2F)
                .notSolid()
                .setRequiresTool()
                .sound(SoundType.PLANT)
                .tickRandomly()
                .setLightLevel((p_235464_0_) -> {
                    return 1;
                })
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
    }

    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(ItemRegistry.winterberry);
    }

    public boolean ticksRandomly(BlockState state) {
        return state.get(AGE) < 1;
    }

    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        int i = state.get(AGE);
        if (i < 3 && worldIn.getLightSubtracted(pos.up(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
        }

    }

    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        if (state.get(AGE) == 1) {
            int j = 1 + worldIn.getRandom().nextInt(1);
            if (!worldIn.isRemote()) {
                ItemEntity item = new ItemEntity((World) worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemRegistry.winterberry));
                worldIn.addEntity(item);
            }
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 2);
        }
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int i = state.get(AGE);
        if (state.get(AGE) == 0 && player.getHeldItem(handIn).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (state.get(AGE) == 1) {
            int j = 1 + worldIn.rand.nextInt(1);
            spawnAsEntity(worldIn, pos, new ItemStack(ItemRegistry.winterberry, j + worldIn.rand.nextInt(2)));
            worldIn.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 2);
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(AGE) < 1;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        int i = Math.min(3, state.get(AGE) + 1);
        worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
    }
}