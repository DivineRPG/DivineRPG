package divinerpg.blocks.vanilla;

import divinerpg.client.containers.*;
import divinerpg.registries.*;
import divinerpg.block_entities.*;
import net.minecraft.core.*;
import net.minecraft.core.particles.*;
import net.minecraft.network.chat.*;
import net.minecraft.server.level.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.level.pathfinder.*;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;

public class BlockAltarOfCorruption extends BaseEntityBlock {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);

    public BlockAltarOfCorruption() {
        super(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).requiresCorrectToolForDrops().strength(5.0F, 1200.0F).sound(SoundType.STONE));
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
        super.animateTick(stateIn, worldIn, pos, rand);

        for(int i = -2; i <= 2; ++i) {
            for(int j = -2; j <= 2; ++j) {
                if (i > -2 && i < 2 && j == -1) {
                    j = 2;
                }

                if (rand.nextInt(16) == 0) {
                    for(int k = 0; k <= 1; ++k) {
                        BlockPos blockpos = pos.offset(i, k, j);
                        if (worldIn.getBlockState(blockpos).getEnchantPowerBonus(worldIn, blockpos) > 0) {
                            if (!worldIn.isEmptyBlock(pos.offset(i / 2, 0, j / 2))) {
                                break;
                            }

                            worldIn.addParticle(ParticleTypes.ENCHANT, (double)pos.getX() + 0.5D, (double)pos.getY() + 2.0D, (double)pos.getZ() + 0.5D, (double)((float)i + rand.nextFloat()) - 0.5D, (double)((float)k - rand.nextFloat() - 1.0F), (double)((float)j + rand.nextFloat()) - 0.5D);
                        }
                    }
                }
            }
        }

    }

    public RenderShape getRenderShape(BlockState p_149645_1_) {
        return RenderShape.MODEL;
    }
    public boolean useShapeForLightOcclusion(BlockState p_220074_1_) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new AltarOfCorruptionBlockEntity(p_153215_, p_153216_);
    }

    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (worldIn.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(state.getMenuProvider(worldIn, pos));
            TriggerRegistry.DIVINERPG_BLOCK.trigger((ServerPlayer) player, this);
            return InteractionResult.CONSUME;
        }
    }

    @Nullable
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        BlockEntity blockEntity = worldIn.getBlockEntity(pos);
        if (blockEntity instanceof AltarOfCorruptionBlockEntity) {
            Component itextcomponent = ((Nameable)blockEntity).getDisplayName();
            return new SimpleMenuProvider((id, inventory, player) -> {
                return new AltarOfCorruptionContainer(id, inventory, ContainerLevelAccess.create(worldIn, pos));
            }, itextcomponent);
        } else {
            return null;
        }
    }

    /**
     * Called by ItemBlocks after a block is set in the world, to allow post-place logic
     */
    public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        if (stack.hasCustomHoverName()) {
            BlockEntity blockEntity = worldIn.getBlockEntity(pos);
            if (blockEntity instanceof AltarOfCorruptionBlockEntity) {
                ((AltarOfCorruptionBlockEntity)blockEntity).setCustomName(stack.getDisplayName());
            }
        }

    }

    public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
        return false;
    }
}
