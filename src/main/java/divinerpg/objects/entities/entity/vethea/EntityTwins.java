package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
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
    	EntityArrow entityarrow = this.getArrow(64);
        double d0 = entity.posX - this.posX;
        double d1 = entity.getEntityBoundingBox().minY + (double)(entity.height / 3.0F) - entityarrow.posY;
        double d2 = entity.posZ - this.posZ;
        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
        switch(ability) {
            case FAST:
                entityarrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, (float)(14 - this.world.getDifficulty().getDifficultyId() * 4));
                this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
                this.world.spawnEntity(entityarrow);
                break;
            case SLOW:
                this.rangedAttackCounter++;
                if ((this.rangedAttackCounter & 4) == 0) {
                    entityarrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, (float)(14 - this.world.getDifficulty().getDifficultyId() * 4));
                    this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
                    this.world.spawnEntity(entityarrow);
                }
                break;
            default: 
            	break;
        }
    }
    protected EntityArrow getArrow(float p_190726_1_)
    {
        EntityTippedArrow entitytippedarrow = new EntityTippedArrow(this.world, this);
        entitytippedarrow.setEnchantmentEffectsFromEntity(this, p_190726_1_);
        return entitytippedarrow;
    }
    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_TWINS;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DUO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DUO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DUO_HURT;
    }

	@Override
	public void setSwingingArms(boolean swingingArms) {		
	}
}
