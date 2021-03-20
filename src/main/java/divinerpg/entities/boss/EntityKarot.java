package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.entities.mortum.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.particles.*;
import net.minecraft.util.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class EntityKarot extends EntityDivineBoss {

    private int spawnTick;

    public EntityKarot(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        spawnTick=240;
    }


    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 3.7F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.karotHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.karotDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.karotSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.karotFollowRange);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public void tick() {
        if (this.spawnTick == 0 && !this.level.isClientSide) {
            EntityAngryBunny angryBunny = new EntityAngryBunny(EntityRegistry.ANGRY_BUNNY, level);
            angryBunny.moveTo(this.getX(), this.getY(), this.getZ(), this.random.nextFloat() * 360.0F, 0.0F);
            this.level.addFreshEntity(angryBunny);
            this.level.addParticle(ParticleTypes.FLASH, angryBunny.getX(), angryBunny.getY() + 0.5D,
                    angryBunny.getZ(), this.random.nextGaussian() * 2.0D - 1.0D, this.random.nextGaussian() * 2.0D - 1.0D,
                    this.random.nextGaussian() * 2.0D - 1.0D);
            this.spawnTick = 240;
        }

        this.spawnTick--;
        super.tick();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        if (!this.level.isClientSide) {
            for (int i = 0; i < 5; i++) {
                EntityAngryBunny angryBunny = new EntityAngryBunny(EntityRegistry.ANGRY_BUNNY, this.level);
                angryBunny.moveTo(this.getX(), this.getY(), this.getZ());
                this.level.addFreshEntity(angryBunny);
            }
        }
        super.kill();
    }

    @Override
    public Color getBarColor() {
        return Color.WHITE;
    }
}
