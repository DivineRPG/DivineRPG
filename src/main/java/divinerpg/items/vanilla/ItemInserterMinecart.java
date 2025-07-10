package divinerpg.items.vanilla;

import divinerpg.entities.base.EntityInserterMinecart;
import divinerpg.items.base.ItemMod;
import net.minecraft.core.*;
import net.minecraft.core.dispenser.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class ItemInserterMinecart extends ItemMod {
    public ItemInserterMinecart() {DispenserBlock.registerBehavior(this, DISPENSE_ITEM_BEHAVIOR);}
    private static final DispenseItemBehavior DISPENSE_ITEM_BEHAVIOR = new DefaultDispenseItemBehavior() {
        private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();
        @Override public ItemStack execute(BlockSource source, ItemStack stack) {
            Direction direction = source.state().getValue(DispenserBlock.FACING);
            ServerLevel serverlevel = source.level();
            Vec3 vec3 = source.center();
            double d0 = vec3.x() + direction.getStepX() * 1.125;
            double d1 = Math.floor(vec3.y()) + direction.getStepY();
            double d2 = vec3.z() + direction.getStepZ() * 1.125;
            BlockPos blockpos = source.pos().relative(direction);
            BlockState blockstate = serverlevel.getBlockState(blockpos);
            RailShape railshape = blockstate.getBlock() instanceof BaseRailBlock ? ((BaseRailBlock)blockstate.getBlock()).getRailDirection(blockstate, serverlevel, blockpos, null) : RailShape.NORTH_SOUTH;
            double d3;
            if(blockstate.is(BlockTags.RAILS)) {
                if(railshape.isAscending()) d3 = .6;
                else d3 = .1;
            } else {
                if(!blockstate.isAir() || !serverlevel.getBlockState(blockpos.below()).is(BlockTags.RAILS)) return defaultDispenseItemBehavior.dispense(source, stack);
                BlockState blockstate1 = serverlevel.getBlockState(blockpos.below());
                RailShape railshape1 = blockstate1.getBlock() instanceof BaseRailBlock ? ((BaseRailBlock)blockstate1.getBlock()).getRailDirection(blockstate1, serverlevel, blockpos.below(), null) : RailShape.NORTH_SOUTH;
                if(direction != Direction.DOWN && railshape1.isAscending()) d3 = -.4;
                else d3 = -.9;
            } AbstractMinecart abstractminecart = createMinecart(serverlevel, d0, d1 + d3, d2, stack, null);
            serverlevel.addFreshEntity(abstractminecart);
            stack.shrink(1);
            return stack;
        }
        @Override protected void playSound(BlockSource source) {source.level().levelEvent(1000, source.pos(), 0);}
    };
    public static AbstractMinecart createMinecart(ServerLevel level, double x, double y, double z, ItemStack stack, @javax.annotation.Nullable Player player) {
        AbstractMinecart abstractminecart = new EntityInserterMinecart(level, x, y, z);
        EntityType.createDefaultStackConfig(level, stack, player).accept(abstractminecart);
        return abstractminecart;
    }
    @Override public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        if(!blockstate.is(BlockTags.RAILS)) return InteractionResult.FAIL;
        ItemStack itemstack = context.getItemInHand();
        if(level instanceof ServerLevel serverlevel) {
            RailShape railshape = blockstate.getBlock() instanceof BaseRailBlock ? ((BaseRailBlock)blockstate.getBlock()).getRailDirection(blockstate, level, blockpos, null) : RailShape.NORTH_SOUTH;
            double d0 = 0D;
            if(railshape.isAscending()) d0 = .5;
            AbstractMinecart abstractminecart = createMinecart(serverlevel, blockpos.getX() + .5, blockpos.getY() + .0625 + d0, blockpos.getZ() + .5, itemstack, context.getPlayer());
            serverlevel.addFreshEntity(abstractminecart);
            serverlevel.gameEvent(GameEvent.ENTITY_PLACE, blockpos, GameEvent.Context.of(context.getPlayer(), serverlevel.getBlockState(blockpos.below())));
        } itemstack.shrink(1);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}