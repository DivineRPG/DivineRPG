package divinerpg.entities.boss.ayeraco;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

public class EntityAyeracoBlue extends EntityAyeraco {

    public EntityAyeracoBlue(EntityType<? extends MobEntity> type, World world, BlockPos beam) {
        super(type, world, beam);
    }

    public EntityAyeracoBlue(EntityType<Entity> type, World world) {
        super(type, world);
    }

    @Override
    public Color getBarColor() {
        return Color.BLUE;
    }
}
