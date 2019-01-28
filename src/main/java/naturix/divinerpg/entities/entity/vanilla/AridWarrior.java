package naturix.divinerpg.entities.entity.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class AridWarrior extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/arid_warrior");

    public AridWarrior(World worldIn) {
		super(worldIn);
		this.setSize(1.6F, 1.6f);
		this.setHealth(this.getMaxHealth());
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        IEntityLivingData ientitylivingdata = super.onInitialSpawn(difficulty, livingdata);
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);
        return ientitylivingdata;
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ModItems.shadowBow));
    }

    protected void initEntityAI()
    {
    	super.initEntityAI();
    	addAttackingAI();
    	this.tasks.addTask(0, new ArrowAttack(this));
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
		return ModSounds.ARID_WARRIOR;
    }
    
    @Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return ModSounds.ARID_WARRIOR_HURT;
	}

    @Override
	protected SoundEvent getDeathSound() {
		return ModSounds.ARID_WARRIOR_HURT;
    }
    
    @Override
	protected ResourceLocation getLootTable()
	{
		return this.LOOT;
	}

    //AI
    private class ArrowAttack extends EntityAIBase {
        private AridWarrior aridWarrior;
        private int tickCooldown;

        public ArrowAttack(AridWarrior aridWarrior) {
            this.aridWarrior = aridWarrior;
        }

        @Override
        public boolean shouldExecute() {
            EntityLivingBase entitylivingbase = this.aridWarrior.getAttackTarget();
            return entitylivingbase != null && entitylivingbase.isEntityAlive();
        }

        @Override
        public void updateTask() {
            tickCooldown++;
            if (tickCooldown % (120/this.aridWarrior.world.getDifficulty().getDifficultyId()) == 0) {
                shootArrow();
            }
        }

        private void shootArrow() {
            EntityLivingBase target = this.aridWarrior.getAttackTarget();
            EntityArrow entityarrow = this.getArrow(16);
            double d0 = target.posX - this.aridWarrior.posX;
            double d1 = target.getEntityBoundingBox().minY + (double)(target.height / 3.0F) - entityarrow.posY;
            double d2 = target.posZ - this.aridWarrior.posZ;
            double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
            entityarrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, (float)(14 - this.aridWarrior.world.getDifficulty().getDifficultyId() * 4));
            this.aridWarrior.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.aridWarrior.getRNG().nextFloat() * 0.4F + 0.8F));
            this.aridWarrior.world.spawnEntity(entityarrow);
        }

        protected EntityArrow getArrow(float p_190726_1_)
        {
            EntityTippedArrow entitytippedarrow = new EntityTippedArrow(this.aridWarrior.world, aridWarrior);
            entitytippedarrow.setEnchantmentEffectsFromEntity(this.aridWarrior, p_190726_1_);
            return entitytippedarrow;
        }

    }
}

