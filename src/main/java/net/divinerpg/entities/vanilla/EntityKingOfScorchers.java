package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGBoss;
import net.divinerpg.entities.vanilla.projectile.EntityKingOfScorchersMeteor;
import net.divinerpg.entities.vanilla.projectile.EntityKingOfScorchersShot;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityKingOfScorchers extends EntityDivineRPGBoss {
    private int special;

	public EntityKingOfScorchers(World var1) {
        super(var1);
        this.setSize(2.0F, 3.9F);
        this.special = 0;
        this.isImmuneToFire = true;
    }
    
	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.kingOfScorchersHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.kingOfScorchersDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.kingOfScorchersSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.kingOfScorchersFollowRange);
	}
	
	@Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Integer(100));
		this.dataWatcher.addObject(13, new Byte((byte)0));
    }
	
	@Override
    protected void updateAITasks() {
    	if (this.ticksExisted%250==0 && this.special == 0) {
    		this.special = 15;
    	}
    	
    	if (this.special > 0 && this.entityToAttack != null) {
    		this.special--;
    		if (this.special % 5 == 0) {
    			for(int i = 0; i<4; i++) {
    				EntityKingOfScorchersMeteor var1 = new EntityKingOfScorchersMeteor(this.worldObj, entityToAttack.posX + (rand.nextDouble()-rand.nextDouble())*2, entityToAttack.posY + 10, entityToAttack.posZ + (rand.nextDouble()-rand.nextDouble())*2);
    				var1.motionX = (rand.nextDouble()-rand.nextDouble())/5;
                	var1.motionY = -0.7;
                	var1.motionZ = (rand.nextDouble()-rand.nextDouble())/5;
    				this.worldObj.spawnEntityInWorld(var1);
    			}
    		}
    	}
        super.updateAITasks();
        this.entityToAttack = this.worldObj.getClosestPlayerToEntity(this, 40);
        if(this.entityToAttack != null && !this.worldObj.isRemote && this.ticksExisted%15==0) this.attackEntityWithRangedAttack(this.entityToAttack);
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
        this.dropItem(getDropItem(), 1);
        this.dropItem(VanillaItemsOther.bluefireStone, 6);
		
		if(this.rand.nextInt(2) == 0) this.dropItem(Item.getItemFromBlock(VanillaBlocks.kosStatue), 1);
    }
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float par2) {
	    if(source.isExplosion())return false;
	    return super.attackEntityFrom(source, par2);
	}

	public void attackEntityWithRangedAttack(Entity entity) {
		double tx = entity.posX - this.posX;
        double ty = entity.boundingBox.minY - this.posY-2;
        double tz = entity.posZ - this.posZ;
		EntityKingOfScorchersShot e = new EntityKingOfScorchersShot(this.worldObj, this);
		e.setThrowableHeading(tx, ty, tz, 1.3f, 1);
        this.worldObj.spawnEntityInWorld(e);
	}

	@Override
	public String mobName() {
		return "King of Scorchers";
	}

	@Override
	public String name() {
		return "King of Scorchers";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}