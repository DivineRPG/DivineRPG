package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.VINE;

public class BlockModVine extends VineBlock {
    public BlockModVine(MapColor color) {super(Properties.ofFullCopy(VINE).mapColor(color));}
    @Override public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        float f = state.getDestroySpeed(level, pos);
        if(player.getMainHandItem().getItem() instanceof ShearsItem) return player.getDigSpeed(state, pos) / f / 15;
        else return super.getDestroyProgress(state, player, level, pos);
    }
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 100;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 15;}
}