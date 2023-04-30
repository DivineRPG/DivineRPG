package divinerpg.entities.arcana;

import divinerpg.DivineRPG;
import divinerpg.capability.ArcanaProvider;
import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.EntitySkyreBullet;
import divinerpg.registries.SoundRegistry;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class EntitySkyre extends EntityDivineMonster {
    private static final EntityDataAccessor<Integer> ARCANA = SynchedEntityData.defineId(EntitySkyre.class, EntityDataSerializers.INT);


    public EntitySkyre(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ARCANA, 0);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.4375F;
    }
    @Override public boolean isAggressive() {return false;}
    @Override public boolean fireImmune() {return true;}
    @Override
    public void tick() {
        super.tick();
        Player player = level.getNearestPlayer(this, 8);
        if (player != null) {
            if (!player.isCreative() || !player.isSpectator()) {
                player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
                    arcana.consume(player, 1);
                    entityData.set(ARCANA, entityData.get(ARCANA) + 1);
                });


                if (entityData.get(ARCANA) == 200) {
                    entityData.set(ARCANA, 0);

                    if (isAlive() && getTarget() != null && !level.isClientSide && player.getHealth() >= 2) {
                        EntitySkyreBullet entity = new EntitySkyreBullet((EntityType<? extends ThrowableProjectile>) ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(DivineRPG.MODID, "skyre_bullet")), player, level);
                        double d0 = getTarget().getX() - this.getX();
                        double d1 = getTarget().getY(0.3333333333333333D) - entity.getY();
                        double d2 = getTarget().getZ() - this.getZ();
                        double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
                        entity.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.8F);
                        this.level.addFreshEntity(entity);
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