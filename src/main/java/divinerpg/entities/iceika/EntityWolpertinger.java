package divinerpg.entities.iceika;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.level.Level;

public class EntityWolpertinger extends Rabbit {
    public EntityWolpertinger(EntityType<? extends EntityWolpertinger> type, Level worldIn) {super(type, worldIn);}
    //TODO: to maybe add baby wolpertingers
    @Override public EntityWolpertinger getBreedOffspring(ServerLevel level, AgeableMob mob) {return null;}
    @Override public boolean canMate(Animal animal) {return false;}
}