package divinerpg.objects.entities.entity.vanilla.ayeraco;

import divinerpg.registry.DRPGLootTables;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class EntityAyeracoPurple extends EntityAyeraco {

    public EntityAyeracoPurple(World worldIn) {
        super(worldIn);
    }

    public EntityAyeracoPurple(World world, BlockPos beam) {
        super(world, beam, Color.PURPLE, DRPGLootTables.ENTITIES_AYERACO_PURPLE);
    }
}
