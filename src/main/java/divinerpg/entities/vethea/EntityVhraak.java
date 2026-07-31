package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityVhraak extends EntityDivineMonster {
    private int spawnTick = 80;
    public EntityVhraak(EntityType<? extends EntityVhraak> type, Level worldIn) {super(type, worldIn);}
    @Override public void tick() {
        super.tick();
        if(!level().isClientSide() && getTarget() != null) {
            if(spawnTick == 0) {
                //TODO fake vhraak
//                EntityRegistry.FAKE_VHRAAK.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition().offset(1, 0, 1), EntitySpawnReason.MOB_SUMMONED, true, false);
//                EntityRegistry.FAKE_VHRAAK.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition().offset(-1, 0, 1), EntitySpawnReason.MOB_SUMMONED, true, false);
//                EntityRegistry.FAKE_VHRAAK.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition().offset(1, 0, -1), EntitySpawnReason.MOB_SUMMONED, true, false);
//                EntityRegistry.FAKE_VHRAAK.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition().offset(-1, 0, -1), EntitySpawnReason.MOB_SUMMONED, true, false);
                spawnTick = 80;
            } else spawnTick--;
        }
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.VHRAAK.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.VHRAAK_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.VHRAAK_HURT.get();}
}