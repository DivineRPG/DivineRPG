package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import divinerpg.util.teleport.*;
import net.minecraft.core.*;
import net.minecraft.core.particles.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.pattern.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.api.distmarker.*;

import java.util.*;

import static divinerpg.blocks.arcana.BlockArcanaPortalFrame.getOrCreatePortalShape;

public class BlockArcanaPortal extends BlockMod {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);

    public BlockArcanaPortal() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).noCollission().lightLevel((p_235460_0_) -> {
            return 15;
        }).strength(-1.0F, 3600000.0F));
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return SHAPE;
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(this);
    }

    @Override
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (world instanceof ServerLevel && !entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions() && Shapes.joinIsNotEmpty(Shapes.create(entity.getBoundingBox().move((double) (-pos.getX()), (double) (-pos.getY()), (double) (-pos.getZ()))), state.getShape(world, pos), BooleanOp.AND)) {
            ServerLevel serverworld = ((ServerLevel) world).getServer().getLevel(world.dimension() == LevelRegistry.ARCANA ? Level.OVERWORLD : LevelRegistry.ARCANA);
            if (serverworld == null) {
                return;
            }
            ResourceKey<Level> destination = LevelRegistry.ARCANA;
            if (destination == world.dimension()) {
                destination = Level.OVERWORLD;
            }
            if (entity.getPortalWaitTime() > 0) {
                transferEntity(entity, world.getServer().getLevel(destination));
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState p_180655_1_, Level p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
        double d0 = (double) p_180655_3_.getX() + p_180655_4_.nextDouble();
        double d1 = (double) p_180655_3_.getY() + 0.8D;
        double d2 = (double) p_180655_3_.getZ() + p_180655_4_.nextDouble();
        p_180655_2_.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }

    public ItemStack getCloneItemStack(BlockGetter p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
        return ItemStack.EMPTY;
    }

    public boolean canBeReplaced(BlockState p_225541_1_, Fluid p_225541_2_) {
        return false;
    }

    public static void transferEntity(Entity e, ServerLevel modDimension) {
        if (e == null || modDimension == null)
            return;

//        ITeleporter teleporter;
//        if (e.level.dimension() == LevelRegistry.ARCANA) {
//            teleporter = new ArcanaTeleporter(e.getServer().getLevel(Level.OVERWORLD), Holder.direct(LevelRegistry.ARCANA_PORTAL));
//        } else {
//            teleporter = new ArcanaTeleporter(e.getServer().getLevel(LevelRegistry.ARCANA), Holder.direct(LevelRegistry.ARCANA_PORTAL));
//        }
        e.changeDimension(modDimension, new ArcanaTeleporter(modDimension, modDimension.getStructureManager().getOrCreate(new ResourceLocation(DivineRPG.MODID, "arcana/portal"))));
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos pos2, boolean unknown) {
        BlockPattern.BlockPatternMatch frame = getOrCreatePortalShape().find(world, pos);
        if (frame == null && world.dimension() != LevelRegistry.ARCANA) {
            world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        }
    }

}