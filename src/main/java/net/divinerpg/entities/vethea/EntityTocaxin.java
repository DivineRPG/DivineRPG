package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTocaxin extends VetheaMob {
	
    public int hurtTimer;
    
    public EntityTocaxin(World var1) {
        super(var1);
        addAttackingAI();
        this.hurtTimer = 0;
    }
 
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.tocaxinHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.tocaxinDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.tocaxinSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.tocaxinFollowRange);
    }
    
    @Override
    public int getSpawnLayer() {
    	return 3;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityLivingBase var1 = this.getAttackTarget();

        if (var1 == null || var1.getDistanceToEntity(this) > 8 || this.hurtTimer != 0) {
            this.hurtTimer--;
            return;
        } else {
            this.hurtTimer = 10;
            var1.attackEntityFrom(DamageSource.magic, (int) (8 - var1.getDistanceToEntity(this)));
        }
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.tocaxin.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.tocaxinHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.polishedPearls, 1);
    }

	@Override
	public String mobName() {
		return "Tocxin";
	}
}