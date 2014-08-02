package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.entities.vanilla.projectile.EntityKingOfScorchersShot;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityKingOfScorchers extends EntityDivineRPGBoss implements IRangedAttackMob {
    private int special;

	public EntityKingOfScorchers(World var1) {
        super(var1);
        this.setSize(2.0F, 3.9F);
        this.tasks.addTask(4, new EntityAIArrowAttack(this, 0.56D, 3, 10));
        this.special = 0;
    }
    
	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.kingOfScorchersHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.kingOfScorchersDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.kingOfScorchersSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.kingOfScorchersFollowRange);
	}
	
	@Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Integer(100));
		this.dataWatcher.addObject(13, new Byte((byte)0));
    }
	
	@Override
    protected void updateAITasks() {
    	if (this.rand.nextInt(250) == 0 && this.special == 0) {
    		this.special = 25;
    	}
    	
    	if (this.special > 0 && this.getAttackTarget() != null) {
    		this.special--;
    		if (this.special % 5 == 0) {
    			EntityKingOfScorchersShot var1 = new EntityKingOfScorchersShot(this.worldObj, (double)this.getAttackTarget().posX, (double)this.getAttackTarget().posY + 10, (double)this.getAttackTarget().posZ);
    			var1.setVelocity(0, -0.5, 0);
                this.worldObj.spawnEntityInWorld(var1);
    		}
    	} else {
        	super.updateAITasks();
    	}
    }

	@Override
    public int getTotalArmorValue() {
        return 10;
    }

	@Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.kingScorcher);
    }

	@Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.kingScorcherHurt);
    }

	@Override
    protected String getDeathSound() {
        return null;
    }

	@Override
    protected Item getDropItem() {
        return VanillaItemsOther.furyFire;
    }

	@Override
    public void dropFewItems(boolean par1, int par2) {
        int var1 = this.rand.nextInt(4);
        this.dropItem(getDropItem(), 1);
        this.dropItem(VanillaItemsOther.bluefireStone, 7);
		
		if(this.rand.nextInt(1) == 0) {
			this.dropItem(Item.getItemFromBlock(VanillaBlocks.KingStatue), 1);
		}
    }

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entityliving, float f) {
		EntityArrow var3 = new EntityArrow(this.worldObj, this, entityliving, 1.6F, 1.6F);
        this.worldObj.playSoundAtEntity(this, "random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(var3);
        var3.setFire(100);
	}

	@Override
	public String mobName() {
		return "Scorcher King";
	}

	@Override
	public String name() {
		return "Scorcher King";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}