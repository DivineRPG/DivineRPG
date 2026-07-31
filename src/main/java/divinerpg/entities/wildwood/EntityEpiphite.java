package divinerpg.entities.wildwood;

import divinerpg.entities.base.EntityDivineNeutral;
import divinerpg.registries.SoundRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

import static net.minecraft.world.damagesource.DamageTypes.LIGHTNING_BOLT;

public class EntityEpiphite extends EntityDivineNeutral {
    public EntityEpiphite(EntityType<? extends EntityEpiphite> type, Level worldIn) {super(type, worldIn);}
    @Override public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
        if(source.is(LIGHTNING_BOLT)) return false;
        return super.hurtServer(level, source, amount);
    }
    @Override public boolean doHurtTarget(ServerLevel level, Entity target) {
        boolean attack = super.doHurtTarget(level, target);
        if(attack & random.nextInt(5) == 0) {
            LightningBolt bolt = new LightningBolt(EntityTypes.LIGHTNING_BOLT, level());
            bolt.setPos(target.getX(), target.getY(), target.getZ());
            if(!level().isClientSide()) level().addFreshEntity(bolt);
        } return attack;
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.GROWL.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GROWL_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GROWL_HURT.get();}
}