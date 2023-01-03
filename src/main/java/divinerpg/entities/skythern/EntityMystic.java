package divinerpg.entities.skythern;

import divinerpg.entities.base.*;
import divinerpg.enums.*;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityMystic extends EntityMageBase {
    public EntityMystic(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn, BulletType.MYSTIC_SHOT);
    }

}