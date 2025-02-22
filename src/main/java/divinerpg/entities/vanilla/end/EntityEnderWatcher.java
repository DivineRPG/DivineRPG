package divinerpg.entities.vanilla.end;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.Level;

public class EntityEnderWatcher extends EnderMan {
    public EntityEnderWatcher(EntityType<? extends EntityEnderWatcher> type, Level worldIn) {super(type, worldIn);}
    int lastStareSound;
    @Override public void playStareSound() {
        if(tickCount >= lastStareSound + 400) {
            lastStareSound = tickCount;
            if(!isSilent()) level().playLocalSound(getX(), getEyeY(), getZ(), SoundEvents.ENDERMAN_SCREAM, getSoundSource(), 2.5F, 1.0F, false);
        }
    }
}