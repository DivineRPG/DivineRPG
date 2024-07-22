package divinerpg.blocks.vanilla;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.AltarOfCorruptionBlockEntity;
import divinerpg.client.menu.AltarOfCorruptionMenu;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.Nullable;
import java.util.List;

public class BlockAltarOfCorruption extends BaseEntityBlock {
    public static final MapCodec<BlockAltarOfCorruption> CODEC = simpleCodec(BlockAltarOfCorruption::new);
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
    @Override public MapCodec<BlockAltarOfCorruption> codec() {return CODEC;}
    public static final List<BlockPos> BOOKSHELF_OFFSETS = BlockPos.betweenClosedStream(-2, 0, -2, 2, 1, 2).filter((p_207914_) -> Math.abs(p_207914_.getX()) == 2 || Math.abs(p_207914_.getZ()) == 2).map(BlockPos::immutable).toList();

    public BlockAltarOfCorruption(Properties properties) {
        super(properties.mapColor(MapColor.COLOR_PURPLE));
    }

    public static boolean isValidBookShelf(Level p_207910_, BlockPos p_207911_, BlockPos p_207912_) {
        return true; // No bookshelves required.
    }

    public boolean useShapeForLightOcclusion(BlockState p_52997_) {
        return true;
    }

    public VoxelShape getShape(BlockState p_52988_, BlockGetter p_52989_, BlockPos p_52990_, CollisionContext p_52991_) {
        return SHAPE;
    }

    public void animateTick(BlockState p_221092_, Level p_221093_, BlockPos p_221094_, RandomSource p_221095_) {
        super.animateTick(p_221092_, p_221093_, p_221094_, p_221095_);

        for(BlockPos blockpos : BOOKSHELF_OFFSETS) {
            if (p_221095_.nextInt(16) == 0 && isValidBookShelf(p_221093_, p_221094_, blockpos)) {
                p_221093_.addParticle(ParticleTypes.ENCHANT, (double)p_221094_.getX() + 0.5D, (double)p_221094_.getY() + 2.0D, (double)p_221094_.getZ() + 0.5D, (double)((float)blockpos.getX() + p_221095_.nextFloat()) - 0.5D, (double)((float)blockpos.getY() - p_221095_.nextFloat() - 1.0F), (double)((float)blockpos.getZ() + p_221095_.nextFloat()) - 0.5D);
            }
        }

    }

    public RenderShape getRenderShape(BlockState p_52986_) {
        return RenderShape.MODEL;
    }

    public BlockEntity newBlockEntity(BlockPos p_153186_, BlockState p_153187_) {
        return new AltarOfCorruptionBlockEntity(p_153186_, p_153187_);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153182_, BlockState p_153183_, BlockEntityType<T> p_153184_) {
        return p_153182_.isClientSide ? createTickerHelper(p_153184_, BlockEntityRegistry.ALTAR_OF_CORRUPTION.get(), AltarOfCorruptionBlockEntity::bookAnimationTick) : null;
    }

    public InteractionResult use(BlockState p_52974_, Level p_52975_, BlockPos p_52976_, Player p_52977_, InteractionHand p_52978_, BlockHitResult p_52979_) {
        if (p_52975_.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            p_52977_.openMenu(p_52974_.getMenuProvider(p_52975_, p_52976_));
            return InteractionResult.CONSUME;
        }
    }

    @Nullable
    public MenuProvider getMenuProvider(BlockState p_52993_, Level p_52994_, BlockPos p_52995_) {
        BlockEntity blockentity = p_52994_.getBlockEntity(p_52995_);
        if (blockentity instanceof AltarOfCorruptionBlockEntity) {
            Component component = ((Nameable)blockentity).getDisplayName();
            return new SimpleMenuProvider((p_207906_, p_207907_, p_207908_) -> {
                return new AltarOfCorruptionMenu(p_207906_, p_207907_, ContainerLevelAccess.create(p_52994_, p_52995_));
            }, component);
        } else {
            return null;
        }
    }

//    public void setPlacedBy(Level p_52963_, BlockPos p_52964_, BlockState p_52965_, LivingEntity p_52966_, ItemStack p_52967_) {
//        if (p_52967_.hasCustomHoverName()) {
//            BlockEntity blockentity = p_52963_.getBlockEntity(p_52964_);
//            if (blockentity instanceof AltarOfCorruptionBlockEntity) {
//                ((AltarOfCorruptionBlockEntity)blockentity).setCustomName(p_52967_.getHoverName());
//            }
//        }
//
//    }

    public boolean isPathfindable(BlockState p_52969_, BlockGetter p_52970_, BlockPos p_52971_, PathComputationType p_52972_) {
        return false;
    }
}
