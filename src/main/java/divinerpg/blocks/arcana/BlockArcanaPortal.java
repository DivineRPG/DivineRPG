package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockMod;
import divinerpg.registries.LevelRegistry;
import divinerpg.util.teleport.ArcanaTeleporter;
import net.minecraft.core.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.*;

import static divinerpg.blocks.arcana.BlockArcanaPortalFrame.getOrCreatePortalShape;

public class BlockArcanaPortal extends BlockMod {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape SHAPE = Block.box(0, 5, 0, 16, 8, 16);
    public BlockArcanaPortal() {
        super(BlockBehaviour.Properties.copy(Blocks.END_PORTAL));
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(AXIS);}
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return SHAPE;}
    @Override public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {return new ItemStack(this);}
    @Override public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        if(world instanceof ServerLevel server && !entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions() && Shapes.joinIsNotEmpty(Shapes.create(entity.getBoundingBox().move(-pos.getX(), -pos.getY(), -pos.getZ())), state.getShape(world, pos), BooleanOp.AND)) {
        	if(entity.isOnPortalCooldown()) entity.setPortalCooldown();
        	else {
        		ServerLevel serverworld = server.getServer().getLevel(world.dimension() == LevelRegistry.ARCANA ? Level.OVERWORLD : LevelRegistry.ARCANA);
                if(serverworld == null) return;
                ResourceKey<Level> destination = LevelRegistry.ARCANA;
                if(destination == world.dimension()) destination = Level.OVERWORLD;
                transferEntity(entity, world.getServer().getLevel(destination));
        	}
        }
    }
    @Override public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {return ItemStack.EMPTY;}
    @Override public boolean canBeReplaced(BlockState state, Fluid fluid) {return false;}
    public static void transferEntity(Entity e, ServerLevel modDimension) {
        if(e == null || modDimension == null) return;
//        ITeleporter teleporter;
//        if (e.level.dimension() == LevelRegistry.ARCANA) {
//            teleporter = new ArcanaTeleporter(e.getServer().getLevel(Level.OVERWORLD), Holder.direct(LevelRegistry.ARCANA_PORTAL));
//        } else {
//            teleporter = new ArcanaTeleporter(e.getServer().getLevel(LevelRegistry.ARCANA), Holder.direct(LevelRegistry.ARCANA_PORTAL));
//        }
        e.changeDimension(modDimension, new ArcanaTeleporter(modDimension, modDimension.getStructureManager().getOrCreate(new ResourceLocation(DivineRPG.MODID, "arcana/portal"))));
    }
    @Override public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos pos2, boolean unknown) {
        BlockPattern.BlockPatternMatch frame = getOrCreatePortalShape().find(world, pos);
        if(frame == null && world.dimension() != LevelRegistry.ARCANA) world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
    }
}