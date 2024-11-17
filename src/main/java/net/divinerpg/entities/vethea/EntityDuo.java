package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityDuo extends VetheaMob {

    public static int ability;
    private final int SLOW = 0, FAST = 1;

    private int abilityCoolDown;

    float moveSpeed = 0.25F;

    public EntityDuo(World par1) {
        super(par1);
        addAttackingAI();
        ability = SLOW;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.duoHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.duoDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.duoSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.duoFollowRange);
    }

    @Override
    public int getSpawnLayer() {
    	return 1;
    }

    @Override
    protected void updateAITasks() {
    	if (ability == SLOW && this.abilityCoolDown == 0) {
            ability = FAST;
            this.abilityCoolDown = 350;
            this.setAIMoveSpeed(moveSpeed * 3);
        }
    	
        this.abilityCoolDown--;
        
        if (ability == FAST && this.abilityCoolDown == 0) {
        	ability = SLOW;
            this.abilityCoolDown = 350;
            this.setAIMoveSpeed(moveSpeed);
        }
        
        super.updateAITasks();
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.duo.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.duoHurt.getPrefixedName();
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
		return "Duo";
	}
}