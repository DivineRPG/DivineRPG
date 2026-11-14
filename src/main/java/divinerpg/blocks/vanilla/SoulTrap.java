package divinerpg.blocks.vanilla;

import divinerpg.registries.AttachmentRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;

public class SoulTrap extends Block {
    public SoulTrap(Properties p) {super(p);}
    @Override public void onPlace(BlockState state, Level level, BlockPos pos, BlockState s, boolean b) {
        LevelChunk c = level.getChunk(pos.getX() >> 4, pos.getZ() >> 4);
        c.setData(AttachmentRegistry.SOUL_TRAP_COUNT, c.getData(AttachmentRegistry.SOUL_TRAP_COUNT) + 1);
    }
    @Override
    protected void affectNeighborsAfterRemoval(BlockState state, ServerLevel level, BlockPos pos, boolean movedByPiston) {
        LevelChunk c = level.getChunk(pos.getX() >> 4, pos.getZ() >> 4);
        c.setData(AttachmentRegistry.SOUL_TRAP_COUNT, c.getData(AttachmentRegistry.SOUL_TRAP_COUNT) - 1);
    }
}