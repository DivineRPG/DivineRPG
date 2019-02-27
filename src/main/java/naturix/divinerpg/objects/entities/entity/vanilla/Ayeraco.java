package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityEnderTripletsFireball;
import naturix.divinerpg.registry.DRPGSoundHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Ayeraco extends EntityDivineRPGBoss {
    private int waitTick;
    BlockPos currentFlightTarget;
    private boolean attacks;
    private double moveX;
    private double moveZ;
    private boolean halfHp;
    public float moveSpeed = 0.3F;
    BlockPos beamLocation;

    public Ayeraco(World worldIn) {
        super(worldIn);
        this.setSize(2.8F, 1.2F);
        this.waitTick = 0;
        this.attacks = false;
        this.halfHp = false;
        this.moveX = this.rand.nextGaussian() * 0.25 - 0.125;
        this.moveZ = this.rand.nextGaussian() * 0.25 - 0.125;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(600.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6000000238418579D;
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        if (getHealth() * 2 < getMaxHealth()) {
            this.tickAbility();
            if (this.halfHp == false) {
                this.playSound(DRPGSoundHandler.AYERACO_HALF_HEALTH, 20.0F,
                        0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
                this.halfHp = true;
            }
        }

        EntityPlayer attackablePlayer = this.world.getNearestAttackablePlayer(this, 128.0D, 128.0D);
        if (attackablePlayer != null)
            this.setAttackTarget(attackablePlayer);

        if (this.waitTick == 0) {
            if (this.getAttackTarget() != null) {
                int var1 = (int) this.getAttackTarget().posX;
                int var2 = (int) this.getAttackTarget().posY;
                int var3 = (int) this.getAttackTarget().posZ;
                this.currentFlightTarget = this.getAttackTarget().getPosition();
            }

            this.motionY = 0;

            if (this.currentFlightTarget != null) {
                double var1 = this.currentFlightTarget.getX() - this.posX;
                double var3 = this.currentFlightTarget.getY() - this.posY;
                double var5 = this.currentFlightTarget.getZ() - this.posZ;

                if (Math.signum(var1) != 0 || Math.signum(var3) != 0 || Math.signum(var5) != 0) {
                    this.motionX = Math.signum(var1) * moveSpeed;
                    this.motionY += (Math.signum(var3) * 5.699999988079071D - this.motionY) * 0.10000000149011612D;
                    this.motionZ = Math.signum(var5) * moveSpeed;
                    float var7 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                    float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
                    this.moveForward = 0.5F;
                    this.rotationYaw += var8;
                }
            }
        } else {
            this.waitTick--;
            this.motionY = 0.3;
            this.motionX = this.moveX;
            this.motionZ = this.moveZ;
        }

        if (!this.attacks) {
            this.waitTick = 80;
            this.attacks = true;
            if (this.canTeleport()) {
                this.waitTick = 0;
                this.teleportRandomUp(this.world);
            }
        }
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float par2) {
        if (this.isEntityInvulnerable(damageSource))
            return false;
        else if (damageSource.getImmediateSource() instanceof EntityEnderTripletsFireball)
            return false;
        else if (damageSource.isProjectile() && this.canBlockProjectiles())
            return false;
        else {
            if (damageSource.getTrueSource() instanceof EntityPlayer) {
                this.attacks = false;
            }
            return super.attackEntityFrom(damageSource, par2);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        this.attacks = false;
        return super.attackEntityAsMob(entity);
    }

    protected void tickAbility() {
    }

    protected boolean canBlockProjectiles() {
        return true;
    }

    protected boolean canTeleport() {
        return true;
    }

    public boolean abilityActive() {
        if (getHealth() * 2 <= getMaxHealth() && !this.isDead)
            return true;
        return false;
    }

    protected void teleportRandomUp(World world) {
        this.playSound(DRPGSoundHandler.AYERACO_TELEPORT, 2.0F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
        this.motionY = 20;
        this.motionX = this.rand.nextInt(5);
        this.motionZ = this.rand.nextInt(5);
    }

    public void setBeamLocation(int x, int y, int z) {
        beamLocation = new BlockPos(x, y, z);
    }

    public Entity findEntityByUUID(String uuid) {
        for (int i = 0; i < this.world.loadedEntityList.size(); i++) {
            Entity e = (Entity) this.world.loadedEntityList.get(i);
            if (((Entity) this.world.loadedEntityList.get(i)).getPersistentID().toString().equals(uuid)) {
                return ((Entity) this.world.loadedEntityList.get(i));
            }
        }
        return null;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DRPGSoundHandler.AYERACO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return DRPGSoundHandler.AYERACO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DRPGSoundHandler.AYERACO_HURT;
    }
}
