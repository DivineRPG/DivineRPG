package net.divinerpg.entities.iceika;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.IceikaItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityHastreus extends EntityDivineRPGMob implements IRangedAttackMob {
	
    public EntityHastreus(World var1) {
        super(var1);
        double moveSpeed = 0.3;
        this.setSize(1.0F, 1.9F);
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, new EntityAIArrowAttack(this, moveSpeed, 60, 10.0F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, moveSpeed, false));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, moveSpeed));
        this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, moveSpeed, false));
        this.tasks.addTask(6, new EntityAIWander(this, moveSpeed));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.hastreusHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.hastreusDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.hastreusSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.hastreusFollowRange);
    }

    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    @Override
    public void onLivingUpdate() {
        if(this.worldObj.isDaytime() && !this.worldObj.isRemote) {
            float var1 = this.getBrightness(1.0F);
        }
        super.onLivingUpdate();
    }

    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.hastreus);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.hastreusHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.hastreusHurt);
    }

    @Override
    protected Item getDropItem() {
        return IceikaItems.iceShards;
    }

    @Override
    protected void dropFewItems(boolean var1, int var2) {
        int var3 = this.rand.nextInt(2 + var2), var4;
        for (var4 = 0; var4 < var3; ++var4) {
            this.dropItem(IceikaItems.iceShards, 3);
        }
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLiving, float f) {
        /*EntityIce var2 = new EntityIce(this.worldObj);
        var2.rotationPitch -= -20.0F;
        double var3 = par1EntityLiving.posX + par1EntityLiving.motionX - this.posX;
        double var5 = par1EntityLiving.posY + par1EntityLiving.getEyeHeight() - 1.100000023841858D - this.posY;
        double var7 = par1EntityLiving.posZ + par1EntityLiving.motionZ - this.posZ;
        float var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7);

        if (var9 >= 8.0F && !par1EntityLiving.isPotionActive(Potion.moveSlowdown)) {
            //var2.set(32698);
        }

        var2.setThrowableHeading(var3, var5 + var9 * 0.2F, var7, 0.75F, 8.0F);
        this.worldObj.spawnEntityInWorld(var2);*/
    }

	@Override
	public String mobName() {
		return "Hastreus";
	}
}