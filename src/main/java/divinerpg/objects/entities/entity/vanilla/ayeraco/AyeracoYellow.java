package divinerpg.objects.entities.entity.vanilla.ayeraco;

import divinerpg.registry.DRPGLootTables;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class AyeracoYellow extends Ayeraco {

    public AyeracoYellow(World worldIn) {
        super(worldIn);
    }

    public AyeracoYellow(World world, BlockPos beam) {
        super(world, beam, Color.YELLOW, DRPGLootTables.ENTITIES_AYERACO_YELLOW);
    }
}
