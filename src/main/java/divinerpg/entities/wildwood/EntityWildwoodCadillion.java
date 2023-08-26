package divinerpg.entities.wildwood;

import divinerpg.entities.base.EntityCadillion;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityWildwoodCadillion extends EntityCadillion {

    public EntityWildwoodCadillion(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
}
