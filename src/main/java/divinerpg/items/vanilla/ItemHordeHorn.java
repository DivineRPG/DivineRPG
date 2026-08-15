package divinerpg.items.vanilla;

import divinerpg.items.base.ItemBossSpawner;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.BlockRegistry.ayeracoSpawn;
import static divinerpg.registries.SoundRegistry.AYERACO_SPAWN;
import static net.minecraft.sounds.SoundSource.HOSTILE;
import static net.minecraft.world.Difficulty.PEACEFUL;
import static net.minecraft.world.InteractionResult.FAIL;
import static net.minecraft.world.level.Level.END;

public class ItemHordeHorn extends ItemBossSpawner {
    public ItemHordeHorn(Properties properties) {super("item.end_only", END, properties);}
    @Override public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
        BlockState state = world.getBlockState(pos);
        if(!state.isAir()) return FAIL;
        else if(world.dimension() == dimensionID && world.getDifficulty() != PEACEFUL) {
            world.playSound(null, pos, AYERACO_SPAWN.get(), HOSTILE, 20, 1);
            world.setBlock(pos, ayeracoSpawn.get().defaultBlockState(), 0);
        } return super.useOn(context);
    }
}