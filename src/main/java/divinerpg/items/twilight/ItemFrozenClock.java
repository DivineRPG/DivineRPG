package divinerpg.items.twilight;

import divinerpg.blocks.base.PortalBlock;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.core.Direction.Axis;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ItemFrozenClock extends ItemMod {
    public ItemFrozenClock() {
        super(new Properties().component(DataComponentRegistry.variant, (byte)0));
    }
    public static InteractionResult useOnPortalBlock(Level level, Player player, BlockPos facing, BlockState block, byte timeOfDay) {
        PortalBlock portal = null;
        ResourceKey<Level> dim = level.dimension();
        if(block.is(BlockRegistry.edenBlock) && (timeOfDay == 0 || (timeOfDay == 5 && dim == LevelRegistry.EDEN))) portal = (PortalBlock)BlockRegistry.edenPortal.get();
        else if(block.is(BlockRegistry.wildwoodBlock) && (timeOfDay == 1 || (timeOfDay == 0 && dim == LevelRegistry.WILDWOOD))) portal = (PortalBlock)BlockRegistry.wildwoodPortal.get();
        else if(block.is(BlockRegistry.apalachiaBlock) && (timeOfDay == 2 || (timeOfDay == 1 && dim == LevelRegistry.APALACHIA))) portal = (PortalBlock)BlockRegistry.apalachiaPortal.get();
        else if(block.is(BlockRegistry.skythernBlock) && (timeOfDay == 3 || (timeOfDay == 2 && dim == LevelRegistry.SKYTHERN))) portal = (PortalBlock)BlockRegistry.skythernPortal.get();
        else if(block.is(BlockRegistry.mortumBlock) && (timeOfDay == 4 || (timeOfDay == 3 && dim == LevelRegistry.MORTUM))) portal = (PortalBlock)BlockRegistry.mortumPortal.get();
        if(portal != null) {
            if(!level.isClientSide()) {
                Axis axis = portal.checkForFrame(level, facing);
                if(axis != null) {
                    PortalBlock.spreadBlock(level, portal.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, axis), facing, Blocks.AIR, axis);
                    level.playSound(null, facing, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1, player.getRandom().nextFloat() * .4F + .8F);
                }
            } return InteractionResult.SUCCESS;
        } return InteractionResult.FAIL;
    }
    public static void useOnFire(Level level, Player player, BlockPos pos, BlockState state, byte timeOfDay) {
        switch(timeOfDay) {
        case 0:
            if(state.is(BlockRegistry.divineFlame)) {
                level.setBlock(pos.above(), BlockRegistry.edenRift.get().defaultBlockState(), 3);
                return;
            } break;
        case 1:
            if(state.is(BlockRegistry.wildFlame)) {
                level.setBlock(pos.above(), BlockRegistry.wildwoodRift.get().defaultBlockState(), 3);
                return;
            } break;
        case 2:
            if(state.is(BlockRegistry.enchantedFlame)) {
                level.setBlock(pos.above(), BlockRegistry.apalachiaRift.get().defaultBlockState(), 3);
                return;
            } break;
        case 3:
            if(state.is(BlockRegistry.skyFire)) {
                level.setBlock(pos.above(), BlockRegistry.skythernRift.get().defaultBlockState(), 3);
                return;
            } break;
        case 4:
            if(state.is(BlockRegistry.mortumEmbers)) {
                level.setBlock(pos.above(), BlockRegistry.mortumRift.get().defaultBlockState(), 3);
                return;
            } break;
        } level.explode(player, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 3, true, Level.ExplosionInteraction.BLOCK);
    }
}