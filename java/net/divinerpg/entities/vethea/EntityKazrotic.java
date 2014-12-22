package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.entities.vethea.projectile.EntityKazroticShot;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityKazrotic extends VetheaMob implements IRangedAttackMob {
	
    public EntityKazrotic(World par1World) {
        super(par1World);
        this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.tasks.addTask(7, new EntityAIArrowAttack(this, 0.25F, 15, 10.0F));
    }

    @Override
    public int getSpawnLayer() {
    	return 3;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.kazroticHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.kazroticSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.kazroticFollowRange);
    }
    
    @Override
    protected String getLivingSound() {
        return Sounds.kazrotic.getPrefixedName();
    }

    @Override

    protected String getHurtSound() {
        return Sounds.kazroticHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }
    
    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase par1, float par2) {
        EntityKazroticShot var1 = new EntityKazroticShot(this.worldObj, this);
        var1.setThrowableHeading(var1.motionX, var1.motionY, var1.motionZ, 0.3F, 0.3F);
        this.playSound("random.bow", 1.0F, 1.0F);
        this.worldObj.spawnEntityInWorld(var1);
    }

    @Override
    public boolean attackEntityFrom(DamageSource par1, float par2) {
        if (par1.isExplosion())
            return false;
        return super.attackEntityFrom(par1, par2);
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.polishedPearls, 1);
    }

	@Override
	public String mobName() {
		return "Kazrotic";
	}
}