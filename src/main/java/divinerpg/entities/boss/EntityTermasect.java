package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.entities.wildwood.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

public class EntityTermasect extends EntityDivineBoss {
	public int courseChangeCooldown = 0;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity = null;
    private int aggroCooldown = 0;
    public int prevAttackCounter = 0;
    public int attackCounter = 0;
    private BlockPos spawnPosition;

    public EntityTermasect(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 1500;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public CreatureAttribute getMobType() {
        return CreatureAttribute.UNDEFINED;
    }
    
    @Override
    public Color getBarColor() {
        return Color.BLUE;
    }


    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        return false;
    }

    protected void checkFallDamage(double p_184231_1_, boolean p_184231_3_, BlockState p_184231_4_, BlockPos p_184231_5_) {
    }

    @Override
    public void tick() {
        super.tick();
        setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y * 0.6000000238418579D, getDeltaMovement().z);

            this.prevAttackCounter = this.attackCounter;
            double var1 = this.waypointX - this.getX();
            double var3 = this.waypointY - this.getY();
            double var5 = this.waypointZ - this.getZ();
            double var7 = MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5);

            if (var7 < 1.0D || var7 > 60.0D) {
                this.waypointX = this.getX() + (double) ((this.random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                this.waypointY = this.getY() + (double) ((this.random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                this.waypointZ = this.getZ() + (double) ((this.random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            }

            if (this.courseChangeCooldown-- <= 0) {
                this.courseChangeCooldown += this.random.nextInt(5) + 2;

                if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, var7)) {
                    setDeltaMovement(getDeltaMovement().x + var1 / var7 * 0.1D, getDeltaMovement().y + var3 / var7 * 0.1D, getDeltaMovement().z + var5 / var7 * 0.1D);
                } else {
                    this.waypointX = this.getX();
                    this.waypointY = this.getY();
                    this.waypointZ = this.getZ();
                }
            }

            if (this.targetedEntity != null && !targetedEntity.isAlive()) {
                this.targetedEntity = null;
            }

            if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
                this.targetedEntity = this.level.getNearestPlayer(this, 100.0D);

                if (this.targetedEntity != null) {
                    this.aggroCooldown = 20;
                }
            }

            double var9 = 100.0D;
        if(getTarget() != null){
        if (canAttack(getTarget())) {
            if (this.targetedEntity != null && this.targetedEntity.distanceToSqr(this) < var9 * var9) {
                double y = this.getBoundingBox().minY + 2.7D;
                double tx = targetedEntity.getX() - getX();
                double ty = targetedEntity.getBoundingBox().minY - y;
                double tz = targetedEntity.getZ() - getZ();
                this.xRotO = this.xRot = -((float) Math.atan2(tx, tz)) * 180.0F / (float) Math.PI;

                if (this.canSee(this.targetedEntity)) {
                    if (this.attackCounter == 20) {
                        this.playSound(SoundRegistry.ROAR, 10.0F, 0.9F);
                    }

                    ++this.attackCounter;

                    if (this.attackCounter == 5) {
                        EntityWildwoodLog shot = new EntityWildwoodLog(EntityRegistry.WILDWOOD_LOG, this, this.level);
                        shot.shoot(tx, ty, tz, 4.0f, 1);
                        if (!this.level.isClientSide)
                            this.level.addFreshEntity(shot);
                        this.attackCounter = -40;
                    }
                } else if (this.attackCounter > 0) {
                    --this.attackCounter;
                }
            } else {
                this.xRotO = this.xRot = -((float) Math.atan2(this.getDeltaMovement().x, this.getDeltaMovement().z)) * 180.0F
                        / (float) Math.PI;

                if (this.attackCounter > 0) {
                    --this.attackCounter;
                }
            }
            if (this.isAlive() && this.random.nextInt(1000) < this.ambientSoundTime++) {
                this.playAmbientSound();
                if (!this.level.isClientSide) {
                    EntityTermid termid = new EntityTermid(EntityRegistry.TERMID, level);
                    termid.moveTo(this.getX() + random.nextInt(4), this.getY(), this.getZ() + random.nextInt(4), this.xRot, this.yRot);
                    double yMot = getDeltaMovement().y;
                    termid.setDeltaMovement(getDeltaMovement().x, yMot++, getDeltaMovement().z);
                    if (random.nextInt(5) == 1) {
                        level.addFreshEntity(termid);
                    }
                }
            }
        }
        }
    }

    private boolean isCourseTraversable(double par1, double par3, double par5, double par7) {
        double d4 = (this.waypointX - this.getX()) / par7;
        double d5 = (this.waypointY - this.getY()) / par7;
        double d6 = (this.waypointZ - this.getZ()) / par7;
        AxisAlignedBB axisalignedbb = this.getBoundingBox();

        for (int i = 1; (double) i < par7; ++i) {
            axisalignedbb.ofSize(d4, d5, d6);

            if (!this.level.getBlockCollisions(this, axisalignedbb).isParallel()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void travel(Vector3d vec) {
//    public void travel(float strafe, float vertical, float forward) {
        if (!level.isClientSide()) {
            if (!this.isInWater()) {
                if (!this.isInLava()) {
                    float f6 = 0.91F;
                    BlockPos blockpos$pooledmutableblockpos = new BlockPos(this.getX(), this.getBoundingBox().minY - 1.0D, this.getZ());

                    if (this.onGround) {
                        BlockState underState = this.level.getBlockState(blockpos$pooledmutableblockpos);
                        f6 = underState.getBlock().getSlipperiness(underState, this.level,
                                blockpos$pooledmutableblockpos, this) * 0.91F;
                    }

                    float f7 = 0.16277136F / (f6 * f6 * f6);
                    this.moveRelative(this.onGround ? 0.1F * f7 : 0.02F, vec);
                    f6 = 0.91F;

                    if (this.onGround) {
                        BlockState underState = this.level.getBlockState(blockpos$pooledmutableblockpos.offset(this.getX(), this.getBoundingBox().minY - 1.0D, this.getZ()));
                        f6 = underState.getBlock().getSlipperiness(underState, this.level,
                                blockpos$pooledmutableblockpos, this) * 0.91F;
                    }

                    this.move(MoverType.SELF, new Vector3d(this.getDeltaMovement().x, this.getDeltaMovement().y, this.getDeltaMovement().z));
                    setDeltaMovement(getDeltaMovement().x * f6, getDeltaMovement().y * f6, getDeltaMovement().z * f6);
                } else {
                    this.moveRelative(0.02F, vec);
                    this.move(MoverType.SELF, new Vector3d(this.getDeltaMovement().x, this.getDeltaMovement().y, this.getDeltaMovement().z));
                    setDeltaMovement(getDeltaMovement().x * 0.5D, getDeltaMovement().y * 0.5D, getDeltaMovement().z * 0.5D);
                }
            } else {
                this.moveRelative(0.02F, vec);
                this.move(MoverType.SELF, new Vector3d(this.getDeltaMovement().x, this.getDeltaMovement().y, this.getDeltaMovement().z));
                setDeltaMovement(getDeltaMovement().x * 0.800000011920929D, getDeltaMovement().y * 0.800000011920929D, getDeltaMovement().z * 0.800000011920929D);
            }
        }
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        if (this.spawnPosition != null
                && (this.level.getBlockState(spawnPosition) != Blocks.AIR.defaultBlockState() || this.spawnPosition.getY() < 1)) {
            this.spawnPosition = null;
        }

        if (this.spawnPosition == null || this.random.nextInt(30) == 0
                || this.spawnPosition.distSqr(new Vector3i(this.getX(), this.getY(), this.getZ())) < 4.0D) {
            this.spawnPosition = new BlockPos((int) this.getX() + this.random.nextInt(7) - this.random.nextInt(7),
                    (int) this.getY() + this.random.nextInt(6) - 2,
                    (int) this.getZ() + this.random.nextInt(7) - this.random.nextInt(7));
        }

        double d0 = (double) this.spawnPosition.getX() + 0.01D - this.getX();
        double d1 = (double) this.spawnPosition.getY() + 0.1D - this.getY();
        double d2 = (double) this.spawnPosition.getZ() + 0.01D - this.getZ();
        double d3 = MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
        setDeltaMovement(getDeltaMovement().x + d0 / d3 * 0.05D, getDeltaMovement().y + d1 / d3 * 0.1D, getDeltaMovement().z + d2 / d3 * 0.05D);
        float f = (float) (Math.atan2(this.getDeltaMovement().z, this.getDeltaMovement().x) * 180.0D / Math.PI) - 90.0F;
        float f1 = MathHelper.wrapDegrees(f - this.xRot);
        this.moveDist = 0.001F;
        this.yRot =+ f1;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WOOD_STEP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.WOOD_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WOOD_BREAK;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 1050).add(Attributes.ATTACK_DAMAGE, 0)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.skythernCoriSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.skythernCoriFollowRange);
    }

}
