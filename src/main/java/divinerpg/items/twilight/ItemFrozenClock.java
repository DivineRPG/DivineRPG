package divinerpg.items.twilight;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import divinerpg.utils.Utils;
import net.minecraft.core.*;
import net.minecraft.core.Direction.Axis;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ItemFrozenClock extends ItemMod {
    public static final Identifier ADVANCEMENT_OOPS = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "divine/oops");
    public ItemFrozenClock(Properties properties) {super(properties.component(DataComponentRegistry.variant, (byte)0));}
    public static InteractionResult useOnPortalBlock(Level level, Player player, BlockPos facing, BlockState block, byte timeOfDay) {
        //TODO - portal block logic
//        PortalBlock portal = null;
//        ResourceKey<Level> dim = level.dimension();
//        if(block.is(BlockRegistry.edenBlock) && (timeOfDay == 0 || (timeOfDay == 5 && dim == LevelRegistry.EDEN))) portal = (PortalBlock)BlockRegistry.edenPortal.get();
//        else if(block.is(BlockRegistry.wildwoodBlock) && (timeOfDay == 1 || (timeOfDay == 0 && dim == LevelRegistry.WILDWOOD))) portal = (PortalBlock)BlockRegistry.wildwoodPortal.get();
//        else if(block.is(BlockRegistry.apalachiaBlock) && (timeOfDay == 2 || (timeOfDay == 1 && dim == LevelRegistry.APALACHIA))) portal = (PortalBlock)BlockRegistry.apalachiaPortal.get();
//        else if(block.is(BlockRegistry.skythernBlock) && (timeOfDay == 3 || (timeOfDay == 2 && dim == LevelRegistry.SKYTHERN))) portal = (PortalBlock)BlockRegistry.skythernPortal.get();
//        else if(block.is(BlockRegistry.mortumBlock) && (timeOfDay == 4 || (timeOfDay == 3 && dim == LevelRegistry.MORTUM))) portal = (PortalBlock)BlockRegistry.mortumPortal.get();
//        if(portal != null) {
//            Axis axis = portal.checkForFrame(level, facing);
//            if(axis != null) {
//                if(!level.isClientSide()) PortalBlock.spreadBlock(level, portal.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, axis), facing, Blocks.AIR, axis);
//                level.playSound(null, facing, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1, player.getRandom().nextFloat() * .4F + .8F);
//                return InteractionResult.SUCCESS;
//            }
//        }
        return InteractionResult.FAIL;
    }
    public static boolean useOnFire(Level level, Player player, BlockPos pos, BlockState state, byte timeOfDay) {
        switch(timeOfDay) {
        case 0:
            if(state.is(BlockRegistry.divineFlame)) {
                if(level.getBlockState(pos.above()).is(BlockRegistry.edenRift)) return false;
                level.setBlock(pos.above(), BlockRegistry.edenRift.get().defaultBlockState(), 3);
                return true;
            } break;
        case 1:
            if(state.is(BlockRegistry.wildFlame)) {
                if(level.getBlockState(pos.above()).is(BlockRegistry.wildwoodRift)) return false;
                level.setBlock(pos.above(), BlockRegistry.wildwoodRift.get().defaultBlockState(), 3);
                return true;
            } break;
        case 2:
            if(state.is(BlockRegistry.enchantedFlame)) {
                if(level.getBlockState(pos.above()).is(BlockRegistry.apalachiaRift)) return false;
                level.setBlock(pos.above(), BlockRegistry.apalachiaRift.get().defaultBlockState(), 3);
                return true;
            } break;
        case 3:
            if(state.is(BlockRegistry.skyFire)) {
                if(level.getBlockState(pos.above()).is(BlockRegistry.skythernRift)) return false;
                level.setBlock(pos.above(), BlockRegistry.skythernRift.get().defaultBlockState(), 3);
                return true;
            } break;
        case 4:
            if(state.is(BlockRegistry.mortumEmbers)) {
                if(level.getBlockState(pos.above()).is(BlockRegistry.mortumRift)) return false;
                level.setBlock(pos.above(), BlockRegistry.mortumRift.get().defaultBlockState(), 3);
                return true;
            } break;
        } level.explode(player, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 3, true, Level.ExplosionInteraction.BLOCK);
        if(level instanceof ServerLevel s) Utils.awardAdvancement(s.getServer(), (ServerPlayer) player, ADVANCEMENT_OOPS, "explode_rift");
        return true;
    }
}