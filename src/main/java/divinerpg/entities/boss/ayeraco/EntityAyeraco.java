package divinerpg.entities.boss.ayeraco;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

public class EntityAyeraco extends EntityDivineBoss {
    private int waitTick;
    private BlockPos currentFlightTarget;
    private boolean attacks;
    private double moveX;
    private double moveZ;
    private boolean halfHp;
    public float moveSpeed = 0.3F;
    private BlockPos beamLocation;

    /**
     * EntityAyeraco group refference. Exists only on server side!!!
     */
    private AyeracoGroup group;

    public EntityAyeraco(EntityType<? extends Entity> type, World worldIn) {
        super((EntityType<? extends MobEntity>) type, worldIn);
    }
    /**
     //     * Main constructor
     //     *
     //     * @param world
     //     * @param beam  - beam location
     //     */
    public EntityAyeraco(EntityType<? extends MobEntity> type, World world, BlockPos beam) {
        super(type, world);
        beamLocation = beam;
        this.waitTick = 0;
        this.attacks = false;
        this.halfHp = false;
        this.moveX = this.random.nextGaussian() * 0.25 - 0.125;
        this.moveZ = this.random.nextGaussian() * 0.25 - 0.125;

        moveTo(beam.getX(), beam.getY() + 4, beam.getZ(),
                this.level.random.nextFloat() * 360.0F, 0.0F);

        ServerWorld serverWorld = world instanceof ServerWorld
                ? ((ServerWorld) world)
                : null;

        group = new AyeracoGroup(serverWorld);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.ayeracoHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.ayeracoDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.ayeracoSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.ayeracoFollowRange);
    }
    @Override
    public void tick() {
        super.tick();
        setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y * 0.6000000238418579, getDeltaMovement().z);
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();

        if(group != null)
        group.tick(this);

        if (getHealth() * 2 < getMaxHealth()) {
            if (this.halfHp == false) {
                this.playSound(SoundRegistry.AYERACO_HALF_HEALTH, 20.0F,
                        0.4F / (this.random.nextFloat() * 0.4F + 0.8F));
                this.halfHp = true;
            }
        }

        PlayerEntity attackablePlayer = this.level.getNearestPlayer(this, 128.0D);
        if (attackablePlayer != null)
            this.setTarget(attackablePlayer);

        if (this.waitTick == 0) {
            if (this.getTarget() != null) {
                int var1 = (int) this.getTarget().getX();
                int var2 = (int) this.getTarget().getY();
                int var3 = (int) this.getTarget().getZ();
                this.currentFlightTarget = this.getTarget().blockPosition();
            }

            this.setDeltaMovement(getDeltaMovement().x, 0, getDeltaMovement().z);

            if (this.currentFlightTarget != null) {
                double var1 = this.currentFlightTarget.getX() - this.getX();
                double var3 = this.currentFlightTarget.getY() - this.getY();
                double var5 = this.currentFlightTarget.getZ() - this.getZ();

                if (Math.signum(var1) != 0 || Math.signum(var3) != 0 || Math.signum(var5) != 0) {
                    setDeltaMovement(Math.signum(var1) * moveSpeed, getDeltaMovement().y + (Math.signum(var3) * 5.699999988079071D - this.getDeltaMovement().y) * 0.10000000149011612D, Math.signum(var5) * moveSpeed);
                    float var7 = (float) (Math.atan2(this.getDeltaMovement().z, this.getDeltaMovement().x) * 180.0D / Math.PI) - 90.0F;
                    float var8 = MathHelper.wrapDegrees(var7 - this.xRot);
                    moveSpeed=0.5F;
                    this.xRot += var8;
                }
            }
        } else {
            this.waitTick--;
            setDeltaMovement(moveX, 0.3, moveZ);
        }

        if (!this.attacks) {
            this.waitTick = 80;
            this.attacks = true;

            if(group != null)
            if (group.canTeleport(this)) {
                this.waitTick = 0;
                this.teleportRandomUp();
            }
        }
    }

    protected boolean isMovementNoisy() {
        return false;
    }

    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        return false;
    }

    protected void checkFallDamage(double p_184231_1_, boolean p_184231_3_, BlockState p_184231_4_, BlockPos p_184231_5_) {
    }

    @Override
    public boolean hurt(DamageSource damageSource, float par2) {
        if(group != null) {
            if (isInvulnerableTo(damageSource)
                    || (damageSource.isProjectile() && group.projectileProtected(this))) {
                return false;
            }

            if (damageSource.getDirectEntity() instanceof PlayerEntity) {
                attacks = true;
            }
        }
        return super.hurt(damageSource, par2);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        this.attacks = false;
        return super.doHurtTarget(entity);
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.AYERACO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.AYERACO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.AYERACO_HURT;
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        compound.put("group", group.serializeNBT());
        compound.putLong("beamPos", beamLocation.asLong());
        super.addAdditionalSaveData(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        group.deserializeNBT(compound.getCompound("group"));
        beamLocation = BlockPos.of(compound.getLong("beamPos"));
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        if (level.isLoaded(beamLocation)) {
            level.setBlock(beamLocation, Blocks.AIR.defaultBlockState(), 1);
        }
    }

    /**
     * Should called before spawn entity in the world
     *
     * @param group - group of ayeracos
     */
    public void initGroup(AyeracoGroup group) {
        this.group = group;
    }

    protected void teleportRandomUp() {
        this.playSound(SoundRegistry.AYERACO_TELEPORT, 2.0F, 0.4F / (this.random.nextFloat() * 0.4F + 0.8F));
        setDeltaMovement(random.nextInt(5), 20, random.nextInt(5));
    }
}
