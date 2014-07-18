package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTocaxin extends EntityDivineRPGMob {
	
    private static final double spawnLayer = 3;
    public int hurtTimer;
    
    public EntityTocaxin(World var1) {
        super(var1);
        addAttackingAI();
        this.hurtTimer = 0;
    }
 
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.tocaxinHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.tocaxinDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.tocaxinSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.tocaxinFollowRange);
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 64.0D * spawnLayer  && this.posY > 64.0D * (spawnLayer - 1) && super.getCanSpawnHere();
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