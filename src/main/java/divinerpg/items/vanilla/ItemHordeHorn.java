package divinerpg.items.vanilla;

import divinerpg.items.base.ItemBossSpawner;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ItemHordeHorn extends ItemBossSpawner {
    public ItemHordeHorn() {super("item.end_only", Level.END);}
    @Override public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
        BlockState state = world.getBlockState(pos);
        if(!state.isAir()) return InteractionResult.FAIL;
        else if(world.dimension() == dimensionID && world.getDifficulty() != Difficulty.PEACEFUL) {
            world.playSound(null, pos, SoundRegistry.AYERACO_SPAWN.get(), SoundSource.HOSTILE, 20, 1);
            world.setBlock(pos, BlockRegistry.ayeracoSpawn.get().defaultBlockState(), 0);
        } return super.useOn(context);
    }
}