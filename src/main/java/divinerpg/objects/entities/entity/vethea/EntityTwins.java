package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;


public class EntityTwins extends VetheaMob implements IRangedAttackMob {

    public static final int SLOW = 0, FAST = 1;
    public static int ability;
    private int abilityCoolDown;
    private EntityAIBase rangedAI;
    private int rangedAttackCounter;

    public EntityTwins(World par1World) {
        super(par1World);
        rangedAI = new EntityAIAttackRanged(this, 0.25F, 10, 64.0F);
        this.tasks.addTask(5, rangedAI);
        addAttackingAI();
        ability = SLOW;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }
    
    @Override
    public int getSpawnLayer() {
    	return 2;
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
    	//TODO - fix arrow shooting
    	Entity arrow = (entity);
        switch(ability) {
            case FAST:
            	EntityArrow var2 = (EntityArrow) arrow;
                var2.shoot(entity, entity.rotationPitch, entity.rotationYaw, 0.0F, 12.0F, 1.6F);
                var2.setDamage(2);
                this.world.spawnEntity(var2);
                break;
            case SLOW:
                this.rangedAttackCounter++;
                if ((this.rangedAttackCounter & 4) == 0) {
                	EntityArrow var4 = (EntityArrow) arrow;
                    var4.setDamage(4);
                    var4.shoot(entity, entity.rotationPitch, entity.rotationYaw, 0.0F, 12.0F, 1.6F);
                    this.world.spawnEntity(var4);
                }
                break;
            default: 
            	break;
        }
    }
    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_TWINS;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DUO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.DUO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DUO_HURT;
    }

	@Override
	public void setSwingingArms(boolean swingingArms) {
		// TODO Auto-generated method stub
		
	}
}
