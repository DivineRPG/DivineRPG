package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityDivineRPGMob;
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
        this.tasks.addTask(7, new EntityAIArrowAttack(this, 0.25F, 15, 40.0F));
    }

    @Override
    public int getSpawnLayer() {
    	return 3;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.kazroticHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.kazroticSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.kazroticFollowRange);
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
    public void attackEntityWithRangedAttack(EntityLivingBase entity, float par2) {
    	double tx = entity.posX - this.posX;
        double ty = entity.boundingBox.minY - this.posY;
        double tz = entity.posZ - this.posZ;
        EntityKazroticShot shot = new EntityKazroticShot(this.worldObj, this);
        shot.setThrowableHeading(tx, ty, tz, 0.6F, 0.3F);
        this.playSound("random.bow", 1.0F, 1.0F);
        this.worldObj.spawnEntityInWorld(shot);
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