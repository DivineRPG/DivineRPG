package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGMob;
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

public class EntityDuo extends EntityDivineRPGMob {

    private static final double spawnLayer = 1;
    public static int ability;
    private final int SLOW = 0, FAST = 1;

    private int abilityCoolDown;

    private EntityAIBase meleeAI;
    float moveSpeed = 0.25F;

    public EntityDuo(World par1) {
        super(par1);
        meleeAI = new EntityAIAttackOnCollide(this, EntityPlayer.class, moveSpeed, false);
        addAttackingAI();
        ability = SLOW;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.duoHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.duoDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.duoSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.duoFollowRange);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 64.0D * spawnLayer  && this.posY > 64.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }

    @Override
    protected void updateAITasks() {
    	if (ability == SLOW && this.abilityCoolDown == 0) {
            ability = FAST;
            this.abilityCoolDown = 350;
            this.setAIMoveSpeed(moveSpeed * 3);
        }
        else if (ability == SLOW && this.abilityCoolDown > 0) {
            this.abilityCoolDown--;
        }
        else if (ability != 0 && this.abilityCoolDown == 0) {
            this.abilityCoolDown = 350;
        } else {
            ability = SLOW;
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