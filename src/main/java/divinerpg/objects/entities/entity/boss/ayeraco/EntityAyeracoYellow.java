package divinerpg.objects.entities.entity.boss.ayeraco;

import divinerpg.registry.LootTableRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class EntityAyeracoYellow extends EntityAyeraco {

    public EntityAyeracoYellow(World worldIn) {
        super(worldIn);
    }

    public EntityAyeracoYellow(World world, BlockPos beam) {
        super(world, beam, LootTableRegistry.ENTITIES_AYERACO_YELLOW);
    }
    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }
}
