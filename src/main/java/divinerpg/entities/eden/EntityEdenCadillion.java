package divinerpg.entities.eden;

import divinerpg.entities.base.EntityCadillion;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityEdenCadillion extends EntityCadillion {

    public EntityEdenCadillion(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
}
