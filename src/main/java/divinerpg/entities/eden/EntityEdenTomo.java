package divinerpg.entities.eden;

import divinerpg.entities.base.EntityTomo;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityEdenTomo extends EntityTomo {

    public EntityEdenTomo(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
}
