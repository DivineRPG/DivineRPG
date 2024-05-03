package divinerpg.items.twilight;

import divinerpg.blocks.base.BlockModPortal;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import java.io.Serial;
import java.util.*;

public class ItemTwilightClock extends ItemMod {
    private final Set<Block> possibleBlocks = new HashSet<>() {
        @Serial private static final long serialVersionUID = 1L;
        {
            add(BlockRegistry.divineRock.get());
            add(BlockRegistry.edenBlock.get());
            add(BlockRegistry.wildwoodBlock.get());
            add(BlockRegistry.apalachiaBlock.get());
            add(BlockRegistry.skythernBlock.get());
        }
    };
    public ItemTwilightClock() {super(new Properties().stacksTo(1));}
    @Override public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getClickedFace();
        InteractionHand hand = context.getHand();
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack stack = player.getItemInHand(hand);
        RandomSource random = level.random;
        if(!player.mayUseItemAt(pos, facing, stack)) return InteractionResult.FAIL;
        if(facing != Direction.UP) return InteractionResult.FAIL;
        for(Direction direction : Direction.Plane.VERTICAL) {
            BlockModPortal portalBlock = null;
            BlockPos framePos = pos.relative(direction);
            if(level.getBlockState(framePos.below()) == BlockRegistry.divineRock.get().defaultBlockState() && (level.dimension().equals(LevelRegistry.EDEN) || level.dimension().equals(Level.OVERWORLD))) {
                portalBlock = (BlockModPortal)BlockRegistry.edenPortal.get();
            } else if(level.getBlockState(framePos.below()) == BlockRegistry.edenBlock.get().defaultBlockState() && (level.dimension().equals(LevelRegistry.WILDWOOD) || level.dimension().equals(Level.OVERWORLD))) {
                portalBlock = (BlockModPortal)BlockRegistry.wildwoodPortal.get();
            } else if(level.getBlockState(framePos.below()) == BlockRegistry.wildwoodBlock.get().defaultBlockState() && (level.dimension().equals(LevelRegistry.APALACHIA) || level.dimension().equals(Level.OVERWORLD))) {
                portalBlock = (BlockModPortal)BlockRegistry.apalachiaPortal.get();
            } else if(level.getBlockState(framePos.below()) == BlockRegistry.apalachiaBlock.get().defaultBlockState() && (level.dimension().equals(LevelRegistry.SKYTHERN) || level.dimension().equals(Level.OVERWORLD))) {
                portalBlock = (BlockModPortal)BlockRegistry.skythernPortal.get();
            } else if(level.getBlockState(framePos.below()) == BlockRegistry.skythernBlock.get().defaultBlockState() && (level.dimension().equals(LevelRegistry.MORTUM) || level.dimension().equals(Level.OVERWORLD))) {
                portalBlock = (BlockModPortal)BlockRegistry.mortumPortal.get();
            } else if(BaseFireBlock.canBePlacedAt(level, pos.relative(facing), context.getHorizontalDirection()) && possibleBlocks.contains(level.getBlockState(pos).getBlock())) {
                level.setBlock(pos.above(), BlockRegistry.blueFire.get().defaultBlockState(), 0);
                level.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1, random.nextFloat() * .4F + .8F);
                return InteractionResult.SUCCESS;
            } if(portalBlock != null && portalBlock.makePortal(level, framePos)) {
                level.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1, random.nextFloat() * .4F + .8F);
                return InteractionResult.SUCCESS;
            }
        } return InteractionResult.FAIL;
    }
}