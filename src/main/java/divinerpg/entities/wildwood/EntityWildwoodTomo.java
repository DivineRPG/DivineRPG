package divinerpg.entities.wildwood;

import divinerpg.entities.base.EntityTomo;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityWildwoodTomo extends EntityTomo {

    public EntityWildwoodTomo(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
}