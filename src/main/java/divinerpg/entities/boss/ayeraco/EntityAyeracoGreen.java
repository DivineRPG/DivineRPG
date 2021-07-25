package divinerpg.entities.boss.ayeraco;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

public class EntityAyeracoGreen extends EntityAyeraco {

    public EntityAyeracoGreen(EntityType<? extends Entity> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityAyeracoGreen(EntityType<? extends MobEntity> type, World world, BlockPos beam) {
        super(type, world, beam);
    }
    
    @Override
    public Color getBarColor() {
        return Color.GREEN;
    }
}
