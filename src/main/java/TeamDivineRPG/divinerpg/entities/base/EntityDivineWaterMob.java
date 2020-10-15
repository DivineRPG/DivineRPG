package TeamDivineRPG.divinerpg.entities.base;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class EntityDivineWaterMob extends AbstractFishEntity {


    public EntityDivineWaterMob(EntityType<? extends EntityDivineWaterMob> type, World worldIn)
    {
        super(type, worldIn);
        this.rand.setSeed((long)(1 + this.getEntityId()));
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.WATER;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }
    @Override
    public void livingTick() {
        if (getEntityWorld().isRemote) {
            if (isInWater()) {
                Vector3d vec3d = getLook(0.0F);
                for (int i = 0; i < 2; ++i)
                    getEntityWorld().addParticle(ParticleTypes.BUBBLE, getPosX() + (this.rand.nextDouble() - 0.5D) * (double)this.getWidth() - vec3d.x * 1.5D, getPosY() + this.rand.nextDouble() * (double)this.getHeight() - vec3d.y * 1.5D, getPosZ() + (this.rand.nextDouble() - 0.5D) * (double)this.getWidth() - vec3d.z * 1.5D, 0.0D, 0.0D, 0.0D);
            }
        }

        if (inWater) {
            setAir(300);
        } else if (onGround) {
            setMotion(this.getMotion().add((double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F), 0.5D, (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F)));
            rotationYaw = rand.nextFloat() * 360.0F;
            onGround = false;
            isAirBorne = true;
            if(getEntityWorld().getGameTime()%5==0)
                getEntityWorld().playSound(null, getPosX(), getPosY(), getPosZ(), SoundEvents.ENTITY_GUARDIAN_FLOP, SoundCategory.HOSTILE, 1F, 1F);
            this.damageEntity(DamageSource.DROWN, 0.5F);
        }

        super.livingTick();
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233819_b_, 20.0D).func_233815_a_(Attributes.field_233821_d_, 0.27F);
    }
    @Override
    protected ItemStack getFishBucket() {
        return null;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }

    @Override
    public void travel(Vector3d travel_vector) {
        if (isServerWorld()) {
            if (isInWater()) {
                moveRelative(0.1F, travel_vector);
                move(MoverType.SELF, getMotion());
                setMotion(getMotion().scale(0.8999999761581421D));
                if (getAttackTarget() == null) {
                    setMotion(getMotion().add(0.0D, -0.005D, 0.0D));
                }
            } else {
                super.travel(travel_vector);
            }
        } else {
            super.travel(travel_vector);
        }
    }

    @Override
    public void tick() {
        if(!getEntityWorld().isRemote) {
            if(getAttackTarget() != null && !getEntityWorld().containsAnyLiquid(getAttackTarget().getBoundingBox())) {
                Double distance = (double) getDistance(getAttackTarget());
                if (distance > 1.0F && distance < 6.0F) // && getAttackTarget().getEntityBoundingBox().maxY >= getEntityBoundingBox().minY && getAttackTarget().getEntityBoundingBox().minY <= getEntityBoundingBox().maxY && rand.nextInt(3) == 0)
                    if (isInWater() && getEntityWorld().isAirBlock(new BlockPos((int) getPosX(), (int) getPosY() + 1, (int) getPosZ()))) {

                        double distanceX = getAttackTarget().getPosX() - getPosX();
                        double distanceY = getAttackTarget().getPosY() + (double)(getAttackTarget().getHeight() * 0.5F) - (this.getPosY() + (double)this.getEyeHeight());
                        double distanceZ = getAttackTarget().getPosZ() - getPosZ();
                        float distanceSqrRoot = MathHelper.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
                        double motionX = distanceX / distanceSqrRoot * 0.5D * 0.900000011920929D + getMotion().getX() * 0.70000000298023224D;
                        double motionY = 0.125D;
                        double motionZ = distanceZ / distanceSqrRoot * 0.5D * 0.900000011920929D + getMotion().getZ() * 0.70000000298023224D;
                        setMotion(getMotion().add(motionX * 0.25D, motionY, motionZ * 0.25D));
                    }
            }
        }
        super.tick();
    }
}