package naturix.divinerpg.objects.entities.entity.arcana;


import naturix.divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo.Color;

public class Parasecta extends EntityDivineRPGBoss {
	
    private EntityCreature theEntity;
    private BlockPos currentFlightTarget;
    private float farSpeed;
    private float nearSpeed;
    private Entity closestLivingEntity;
    private float distanceFromEntity;
    private PathFinder entityPathEntity;
    private PathNavigate entityPathNavigate;
    private Class targetEntityClass;

    public Parasecta(World var1) {
        super(var1);
        this.setSize(1.0F, 2.0F);
        targetEntityClass = EntityPlayerMP.class;
        addAttackingAI();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.parasectaHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.parasectaDamage);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.parasectaSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.parasectaFollowRange);
    }

 
    @Override
    protected float getSoundVolume() {
        return 0.1F;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : ModSounds.PARASECTA;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return ModSounds.PARASECTA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.PARASECTA_HURT;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6000000238418579D;
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        if (this.getAttackTarget() != null) {
            int var1 = (int) this.getAttackTarget().posX;
            int var2 = (int) this.getAttackTarget().posY;
            int var3 = (int) this.getAttackTarget().posZ;
            this.currentFlightTarget = new BlockPos(var1, var2, var3);
        }

        this.motionY = 0;

        if (this.currentFlightTarget != null) {
            double var1 = this.currentFlightTarget.getX() - this.posX;
            double var3 = this.currentFlightTarget.getY() - this.posY;
            double var5 = this.currentFlightTarget.getZ() - this.posZ;

            if (Math.signum(var1) != 0 || Math.signum(var3) != 0 || Math.signum(var5) != 0) {
                this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.10000000149011612D;
                this.motionY += (Math.signum(var3) * 1.699999988079071D - this.motionY) * 0.10000000149011612D;
                this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.10000000149011612D;
                float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
                this.moveForward = 0.5F;
                this.rotationYaw += var8;
            }
        }

    }

    @Override
    protected void dropFewItems(boolean var1, int var2) {
        this.dropItem(ModItems.dungeonTokens, 8);
    }

    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }
}