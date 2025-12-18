package divinerpg.compat.corail_woodcutter;

import net.minecraft.core.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.registries.DeferredBlock;
import ovh.corail.woodcutter.block.WoodcutterBlock;
import ovh.corail.woodcutter.inventory.WoodcutterContainer;

import static net.minecraft.world.level.block.Blocks.OAK_LOG;
import static ovh.corail.woodcutter.registry.ModStats.INTERACT_WITH_SAWMILL;

public class Woodcutter extends WoodcutterBlock {
    public Woodcutter(DeferredBlock<Block> base, WoodType type) {
        super(Properties.ofFullCopy(OAK_LOG).mapColor(base.get().defaultMapColor()).sound(type.hangingSignSoundType()));
    }
    @Override public InteractionResult useWithoutItem(BlockState state, Level worldIn, BlockPos pos, Player player, BlockHitResult hit) {
        if(!worldIn.isClientSide) {
            //It works I guess. Don't know why I had to change that; it wouldn't open (immediately closes) otherwise
            player.openMenu(new SimpleMenuProvider((id, playerInventory, p) -> new WoodcutterContainer(id, playerInventory), WoodcutterBlock.TRANSLATION));
            player.awardStat(INTERACT_WITH_SAWMILL);
            return InteractionResult.CONSUME;
        } else return InteractionResult.SUCCESS;
    }
}