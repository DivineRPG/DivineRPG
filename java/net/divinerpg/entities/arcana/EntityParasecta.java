package net.divinerpg.entities.arcana;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityParasecta extends EntityDivineRPGBoss {
	
    private ChunkCoordinates currentFlightTarget;
    private EntityCreature theEntity;
    private float farSpeed;
    private float nearSpeed;
    private Entity closestLivingEntity;
    private float distanceFromEntity;
    private PathEntity entityPathEntity;
    private PathNavigate entityPathNavigate;
    private Class targetEntityClass;

    public EntityParasecta(World var1) {
        super(var1);
        this.setSize(1.0F, 2.0F);
        targetEntityClass = EntityPlayerMP.class;
        addAttackingAI();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.parasectaHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.parasectaDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.parasectaSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.parasectaFollowRange);
    }

    @Override
    public String mobName() {
        return "Parasecta";
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
    protected String getLivingSound() {
        return this.rand.nextInt(4) != 0 ? null : Sounds.parasecta.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.parasectaHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return Sounds.parasectaHurt.getPrefixedName();
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
            this.currentFlightTarget = new ChunkCoordinates(var1, var2, var3);
        }

        this.motionY = 0;

        if (this.currentFlightTarget != null) {
            double var1 = this.currentFlightTarget.posX - this.posX;
            double var3 = this.currentFlightTarget.posY - this.posY;
            double var5 = this.currentFlightTarget.posZ - this.posZ;

            if (Math.signum(var1) != 0 || Math.signum(var3) != 0 || Math.signum(var5) != 0) {
                this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.10000000149011612D;
                this.motionY += (Math.signum(var3) * 1.699999988079071D - this.motionY) * 0.10000000149011612D;
                this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.10000000149011612D;
                float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
                this.moveForward = 0.5F;
                this.rotationYaw += var8;
            }
        }

    }

    @Override
    protected void fall(float par1) {}

    @Override
    protected void updateFallState(double par1, boolean par3) {}


    @Override
    protected void dropFewItems(boolean var1, int var2) {
        this.dropItem(ArcanaItems.dungeonTokens, 8);
    }

	@Override
	public String name() {
		return mobName();
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}