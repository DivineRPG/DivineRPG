package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityKarot extends EntityDivineRPGBoss {
	
    private int spawnTick;

    public EntityKarot(World var1)  {
        super(var1);
        this.spawnTick = 240;
        this.setSize(5.5F, 7.0F);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.karotHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.karotDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.karotSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.karotFollowRange);
    }
 
    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    public void onLivingUpdate() {
        if (this.spawnTick == 0 && !this.worldObj.isRemote) {
            EntityAngryBunny var2 = new EntityAngryBunny(this.worldObj);
            var2.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rand.nextFloat() * 360.0F, 0.0F);
            this.worldObj.spawnEntityInWorld(var2);
            this.worldObj.spawnParticle("reddust", var2.posX, var2.posY + 0.5D, var2.posZ, this.rand.nextGaussian() * 2.0D - 1.0D, this.rand.nextGaussian() * 2.0D - 1.0D, this.rand.nextGaussian() * 2.0D - 1.0D);
            //this.worldObj.playSoundAtEntity(var2, Sound.KarotSummon, 10.0F, 1.0F);
            this.spawnTick = 240;
        }

        this.spawnTick--;
        super.onLivingUpdate();
    }
 
    @Override
    protected String getLivingSound() {
        return null;
    }
 
    @Override
    protected String getHurtSound() {
        return null;
    }
 
    @Override
    protected String getDeathSound() {
        return null;
    }

    @Override
    public void onDeath(DamageSource par1DamageSource) {
        for (int i = 0; i < 5; i++) {
        	EntityAngryBunny var1 = new EntityAngryBunny(this.worldObj);
            var1.setPosition(this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld(var1);
        }
        super.setDead();
    }

    @Override
    protected Item getDropItem() {
        return TwilightItemsWeapons.halitePhaser;
    }

    @Override
    public void dropFewItems(boolean par1, int par2) {
        this.dropItem(this.getDropItem(), 1);
    }

	@Override
	public String mobName() {
		return "Karot";
	}

	@Override
	public String name() {
		return "Karot";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}
