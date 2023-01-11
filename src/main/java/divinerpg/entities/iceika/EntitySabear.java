package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMonster;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntitySabear extends EntityDivineMonster {

    public EntitySabear(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    public boolean isAggressive() {
        return true;
    }
}
