package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

public class EntityTwins extends EntityDivineRPGMob implements IRangedAttackMob {

    private static final double spawnLayer = 2;
    public static final int SLOW = 0, FAST = 1;
    public static int ability;
    private int abilityCoolDown;
    private EntityAIBase rangedAI;
    private int rangedAttackCounter;

    public EntityTwins(World par1World) {
        super(par1World);
        rangedAI = new EntityAIArrowAttack(this, 0.25F, 10, 64.0F);
        this.tasks.addTask(5, rangedAI);
        addAttackingAI();
        ability = SLOW;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.twinsHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.twinsDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.twinsSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.twinsFollowRange);
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 64.0D * spawnLayer  && this.posY > 64.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }

    @Override
    protected void updateAITasks() {
        this.manageAbilities();
        super.updateAITasks();
    }

    public void manageAbilities() {
        if (ability == SLOW && abilityCoolDown == 0) {
            ability = FAST;
            abilityCoolDown = 50;
            this.rangedAttackCounter = 0;
        }
        else if (ability == FAST && abilityCoolDown == 0) {
            ability = SLOW;
            abilityCoolDown = 60;
            this.rangedAttackCounter = 0;
        }
        else if (abilityCoolDown > 0) {
            abilityCoolDown--;
        }
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase entity, float par2) {
        switch(ability) {
            case FAST:
                EntityArrow var2 = new EntityArrow(this.worldObj, this, entity, 1.6F, 12.0F);
                var2.setDamage(2);
                this.worldObj.spawnEntityInWorld(var2);
                break;
            case SLOW:
                this.rangedAttackCounter++;
                if ((this.rangedAttackCounter & 4) == 0) {
                	EntityArrow var4 = new EntityArrow(this.worldObj, this, entity, 1.6F, 12.0F);
                    var4.setDamage(4);
                    this.worldObj.spawnEntityInWorld(var4);
                }
                break;
            default: 
            	break;
        }
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.cleanPearls, 1);
    }

	@Override
	public String mobName() {
		return "Twins";
	}
}