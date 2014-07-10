package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityApalachiaWarrior extends EntityDivineRPGMob {
	
    private static final ItemStack defaultHeldItem = new ItemStack(TwilightItemsWeapons.apalachiaBlade, 1);

    public EntityApalachiaWarrior(World var1) {
        super(var1);
        addAttackingAI();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.apalachiaWarriorHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.apalachiaWarriorDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.apalachiaWarriorSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.apalachiaWarriorFollowRange);
    }
 
    @Override
    public int getTotalArmorValue() {
        return 10;
    }
 
    @Override
    public void onLivingUpdate() {
        if(this.worldObj.isDaytime() && !this.worldObj.isRemote) {
            float var1 = this.getBrightness(1.0F);
            if(var1 > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
                this.setFire(8);
            }
        }
        super.onLivingUpdate();
    }
 
    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.hiss);
    }
 
    @Override
    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }
 
    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.growlHurt);
    }
 
    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.growlHurt);
    }
 
    @Override
    protected void dropFewItems(boolean var1, int var2) {
        int var3 = this.rand.nextInt(2 + var2);
        int var4;
        for(var4 = 0; var4 < var3; ++var4) 
            this.dropItem(getDropItem(), 1);
        this.dropItem(getDropItem(), 1);
    }
 
    @Override
    protected Item getDropItem() {
        return TwilightItemsOther.apalachiaSoul;
    }
 
	@Override
	public String mobName() {
		return "Apalachia Warrior";
	}
}
