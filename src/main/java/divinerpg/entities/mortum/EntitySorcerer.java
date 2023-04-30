package divinerpg.entities.mortum;

import divinerpg.entities.base.*;
import divinerpg.enums.*;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntitySorcerer extends EntityMageBase {

    public EntitySorcerer(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn, BulletType.SORCERER_SHOT);
    }

    @Override public boolean fireImmune() {return true;}
}