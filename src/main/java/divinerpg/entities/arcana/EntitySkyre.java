package divinerpg.entities.arcana;

import divinerpg.attachments.Arcana;
import divinerpg.entities.base.EntityDivineNeutral;
import divinerpg.entities.projectile.bullet.EntitySkyreBullet;
import divinerpg.registries.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
//TODO: to implement RangedAttackMob
public class EntitySkyre extends EntityDivineNeutral {
    public EntitySkyre(EntityType<? extends EntitySkyre> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override public boolean fireImmune() {return true;}
    @Override public void tick() {
        super.tick();
        if(!level().isClientSide()) {
            ServerPlayer player = (ServerPlayer) level().getNearestPlayer(this, 8);
            if(player != null && (!player.isCreative() || !player.isSpectator())) {
            	Arcana.modifyAmount(player, -1);
            	Arcana.modifyAmount(this, 1);
                if(Arcana.getAmount(this) >= 200) {
                	Arcana.setAmount(this, 0);
                    if(isAlive() && getTarget() != null && player.getHealth() >= 2) {
						EntitySkyreBullet entity = EntityRegistry.SKYRE_BULLET.get().create(level());
                        entity.setOwner(player);
                        entity.setPos(player.position());
                        double d0 = getTarget().getX() - this.getX();
                        double d1 = getTarget().getY(.3333333333333333) - entity.getY();
                        double d2 = getTarget().getZ() - getZ();
                        double d3 = Mth.sqrt((float)(d0 * d0 + d2 * d2));
                        entity.shoot(d0, d1 + d3 * .2, d2, 1.6F, .8F);
                        level().addFreshEntity(entity);
                        playSound(SoundRegistry.SKYRE_SHOOT.get());
                    }
                }
            }
        }
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.SKYRE_AMBIENT.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.SKYRE_DIE.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.SKYRE_DIE.get();}
}