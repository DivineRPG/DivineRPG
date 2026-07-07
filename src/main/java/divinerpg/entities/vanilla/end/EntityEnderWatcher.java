package divinerpg.entities.vanilla.end;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.Level;

public class EntityEnderWatcher extends EnderMan {
    //TODO: they still take effects from arrows for some reason
    public EntityEnderWatcher(EntityType<? extends EntityEnderWatcher> type, Level worldIn) {super(type, worldIn);}
}