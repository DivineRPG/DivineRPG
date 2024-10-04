package divinerpg.entities.arcana;

import divinerpg.attachments.Arcana;
import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.EntitySkyreBullet;
import divinerpg.registries.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntitySkyre extends EntityDivineMonster {
    public EntitySkyre(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override public boolean isAggressive() {return false;}
    @Override public boolean fireImmune() {return true;}
    @Override
    public void tick() {
        super.tick();
        if(!level().isClientSide()) {
            ServerPlayer player = (ServerPlayer) level().getNearestPlayer(this, 8);
            if(player != null && (!player.isCreative() || !player.isSpectator())) {
            	Arcana.modifyAmount(player, -1F);
            	Arcana.modifyAmount(this, 1F);
                if(Arcana.getAmount(this) >= 200F) {
                	Arcana.setAmount(this, 0F);
                    if(isAlive() && getTarget() != null && player.getHealth() >= 2) {
						EntitySkyreBullet entity = new EntitySkyreBullet(EntityRegistry.SKYRE_BULLET.get(), player, level());
                        double d0 = getTarget().getX() - this.getX();
                        double d1 = getTarget().getY(0.3333333333333333D) - entity.getY();
                        double d2 = getTarget().getZ() - this.getZ();
                        double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
                        entity.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.8F);
                        this.level().addFreshEntity(entity);
                        playSound(SoundRegistry.SKYRE_SHOOT.get());
                    }
                }
            }
        }
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SKYRE_AMBIENT.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.SKYRE_DIE.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.SKYRE_DIE.get();
    }
}