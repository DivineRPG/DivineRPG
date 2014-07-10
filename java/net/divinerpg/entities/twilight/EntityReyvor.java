package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsArmor;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityReyvor extends EntityDivineRPGBoss implements IRangedAttackMob {
	
	private static final ItemStack defaultHeldItem = new ItemStack(TwilightItemsWeapons.mortumBow, 1);

    public EntityReyvor(World var1) {
        super(var1);        
        this.tasks.addTask(7, new EntityAIArrowAttack(this, 0.25F, 60, 64.0F));  
        addAttackingAI();
    }
    
	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.reyvorHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.reyvorDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.reyvorSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.reyvorFollowRange);
	}

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Integer(100));
    }

    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.reyvor);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.reyvorHurt);
    }

    @Override
    protected String getDeathSound() {
        return null;
    }

    @Override
    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }

    @Override
    public void dropFewItems(boolean par1, int par2) {
        this.dropItem(TwilightItemsArmor.haliteLegs, 1);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase var1, float f) {
        EntityArrow var2 = new EntityArrow(this.worldObj, this, var1, 1.6F, 12.0F);
        var2.setDamage(24D);
        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(var2);
    }

	@Override
	public String mobName() {
		return "Reyvor";
	}

	@Override
	public String name() {
		return "Reyvor";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}