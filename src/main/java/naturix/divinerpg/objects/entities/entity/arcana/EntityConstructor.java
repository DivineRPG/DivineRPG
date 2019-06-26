package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityConstructor extends EntityDivineRPGMob {
	public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/arcana/constructor");

    private int angerLevel;
    private float moveSpeed = 0.23F;
    
    public EntityConstructor(World par1World) {
        super(par1World);
        this.setSize(0.5F, 1.0F);
        addAttackingAI();
        this.angerLevel = 0;
        this.stepHeight = 1.0F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.constructorHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.constructorDamage);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.constructorSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.constructorFollowRange);
    }

    @Override
    public void onLivingUpdate() {
        if (this.getAttackTarget() != null) {
            this.faceEntity(this.getAttackTarget(), 100.0F, 100.0F);
        }

        if (!this.world.isRemote && this.isEntityAlive()) {
            if (this.getAttackTarget() != null) {
                if (this.getAttackTarget() instanceof EntityPlayer && this.angerLevel < 3) {
                    this.moveStrafing = this.moveForward = 0.0F;
                    this.moveSpeed = 0.0F;
                }
            }
        }
        super.onLivingUpdate();
    }
 
    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }
 
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.CONSTRUCTOR_HURT;
    }
 
    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }
    

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
    	par1Entity.playSound(ModSounds.CONSTRUCTOR_PUNCH, 1, 1);
        return super.attackEntityAsMob(par1Entity);
    }
    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

}