package divinerpg.objects.entities.entity.vanilla.ayeraco;

import divinerpg.registry.DRPGLootTables;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class EntityAyeracoRed extends EntityAyeraco {

    public EntityAyeracoRed(World worldIn) {
        super(worldIn);
    }

    public EntityAyeracoRed(World world, BlockPos beam) {
        super(world, beam, Color.RED, DRPGLootTables.ENTITIES_AYERACO_RED);
    }
}
