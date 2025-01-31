package divinerpg.entities.mortum;

import divinerpg.entities.base.EntityBaseMage;
import divinerpg.registries.EntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntitySorcerer extends EntityBaseMage {
    public EntitySorcerer(EntityType<? extends EntitySorcerer> type, Level worldIn) {super(type, worldIn, EntityRegistry.SORCERER_SHOT::value);}
    @Override public boolean fireImmune() {return true;}
}