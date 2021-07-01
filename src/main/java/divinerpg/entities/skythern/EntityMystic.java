package divinerpg.entities.skythern;

import divinerpg.entities.base.*;
import divinerpg.enums.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class EntityMystic extends EntityMageBase {
    public EntityMystic(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn, BulletType.MYSTIC_SHOT);
    }

}