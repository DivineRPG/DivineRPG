package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityShadahier extends VetheaMob {
	
    public EntityShadahier(World var1) {
        super(var1);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.shadahierHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.shadahierDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.shadahierSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.shadahierFollowRange);
    }
    
    @Override
    public int getSpawnLayer() {
    	return 1;
    }

    @Override
    public void onLivingUpdate() {
    	super.onLivingUpdate();
        EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 6.0D);
        if(var1 != null) {
            var1.addPotionEffect(new PotionEffect(Potion.blindness.id, 1, 1));
        }
    }
 
    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }
 
    @Override
    protected String getLivingSound() {
        return Sounds.shadahier.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.shadahierHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }
    
    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.dirtyPearls, 1);
    }

	@Override
	public String mobName() {
		return "Shadahier";
	}
}