package divinerpg.blocks.twilight;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.PortalBlock;
import divinerpg.blocks.vanilla.FireBlock;
import divinerpg.registries.*;
import divinerpg.util.Utils;
import net.minecraft.core.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public abstract class PortalFire extends FireBlock {
    public static final ResourceLocation ADVANCEMENT_OOPS = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "divine/oops");
    public PortalFire() {
        super();
    }
    public PortalFire(float fireDamage) {
        super(fireDamage);
    }
    public PortalFire(Properties properties, float fireDamage) {
        super(properties, fireDamage);
    }
    @Override protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        return initiatePortal(level, (PortalFire) state.getBlock(), List.of(player), pos, stack) ? ItemInteractionResult.SUCCESS : ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    public static boolean initiatePortal(Level level, PortalFire fire, List<? extends Player> players, BlockPos pos, ItemStack stack) {
        if(!fire.validateItem(level, stack)) return false;
        byte timeOfDay = getTimeOfDay(level, stack);
        PortalBlock portal = fire.getPortalBlock(level, level.getBlockState(pos.below()), timeOfDay);
        if(portal != null) {
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_NONE);
            Direction.Axis axis = portal.checkForFrame(level, pos);
            if(axis != null) {
                if(!level.isClientSide) PortalBlock.spreadBlock(level, portal.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, axis), pos, Blocks.AIR, axis);
                fire.playPortalCreationSound(level, pos);
                return true;
            } level.setBlock(pos, fire.defaultBlockState(), Block.UPDATE_NONE);
        } Block rift = fire.getRift(timeOfDay);
        if(rift != null) {
            BlockPos above = pos.above();
            if(level.getBlockState(above).is(rift)) return false;
            level.setBlock(above, rift.defaultBlockState(), 3);
            return true;
        } level.explode(null, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 3, true, Level.ExplosionInteraction.BLOCK);
        for(Player player : players) if(level instanceof ServerLevel s) Utils.awardAdvancement(s.getServer(), (ServerPlayer) player, ADVANCEMENT_OOPS, "explode_rift");
        return true;
    }
    public static byte getTimeOfDay(Level level, ItemStack stack) {
        return (stack.is(Items.CLOCK) || stack.is(ItemRegistry.mysterious_clock)) ? Utils.determineTimeOfDay(level) : (stack.is(ItemRegistry.frozen_clock) ? stack.get(DataComponentRegistry.variant) : -1);
    }
    public boolean validateItem(Level level, ItemStack stack) {
        return stack.is(Items.CLOCK) || stack.is(ItemRegistry.frozen_clock) || stack.is(ItemRegistry.mysterious_clock);
    }
    public abstract PortalBlock getPortalBlock(Level level, BlockState frame, byte timeOfDay);
    public abstract Block getRift(byte timeOfDay);
    public void playPortalCreationSound(Level level, BlockPos pos) {
        level.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1, level.random.nextFloat() * .4F + .8F);
    }
}