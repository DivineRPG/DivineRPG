package divinerpg.entities.wildwood;

import divinerpg.entities.base.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class EntityMage extends EntityMageBase {
    public EntityMage(EntityType<? extends MobEntity> type, World worldIn) {
//        super(worldIn, BulletType.MAGE_SHOT);
        super(type, worldIn);
    }
}