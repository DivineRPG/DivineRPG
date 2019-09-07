package divinerpg.objects.entities.entity.vanilla.ayeraco;

import divinerpg.registry.DRPGLootTables;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class AyeracoBlue extends Ayeraco {

    public AyeracoBlue(World worldIn) {
        super(worldIn);
    }

    public AyeracoBlue(World world, BlockPos beam) {
        super(world, beam, Color.BLUE, DRPGLootTables.ENTITIES_AYERACO_BLUE);
    }
}
