package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;


public class EntityGalroid extends VetheaMob {
	private static final DataParameter<Integer> PROTECTION = EntityDataManager.<Integer>createKey(EntityGalroid.class,
            DataSerializers.VARINT);
	private static final DataParameter<Integer> INVULNERABILITY = EntityDataManager.<Integer>createKey(EntityGalroid.class,
            DataSerializers.VARINT);
    public EntityGalroid(World var1) {
        super(var1);
        addAttackingAI();
    }
    
    @Override
    public void entityInit() {
    	super.entityInit();
        dataManager.register(PROTECTION, Integer.valueOf(200));
        dataManager.register(INVULNERABILITY, Integer.valueOf(1));
    }

    @Override
    public int getSpawnLayer() {
    	return 3;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.getProtectionTimer() <= 0 && !this.getInvincible()) {
            this.setProtectionTimer(200);
            this.setInvincible(1);
        }
        else if (this.getIsInvulnerable() && this.getProtectionTimer() <= 0) {
        	this.setProtectionTimer(200);
        	this.setInvincible(0);
        }
        this.setProtectionTimer(this.getProtectionTimer()-1);
    }
    
    public boolean getInvincible() {
    	return dataManager.get(INVULNERABILITY).bitCount(20) == 1;
    }
    
    public int getProtectionTimer() {
        return dataManager.get(PROTECTION).bitCount(19);
    }
    
    public void setInvincible(int i) {
    	dataManager.set(INVULNERABILITY, i);;
    }
    
    public void setProtectionTimer(int i) {
    	dataManager.set(PROTECTION, i);;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(25);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        float var2 = 25;

        if (this.isPotionActive(MobEffects.STRENGTH)) {
            var2 += 3 << this.getActivePotionEffect(MobEffects.STRENGTH).getAmplifier();
        }

        if (this.isPotionActive(MobEffects.WEAKNESS)) {
            var2 -= 2 << this.getActivePotionEffect(MobEffects.WEAKNESS).getAmplifier();
        }

        int var3 = 0;

        if (par1Entity instanceof EntityLiving) {
            var2 += EnchantmentHelper.getEfficiencyModifier((EntityLiving)par1Entity);
            var3 += EnchantmentHelper.getKnockbackModifier((EntityLiving)par1Entity);
        }

        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);

        if (var4) {
            if (var3 > 0) {
                par1Entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * var3 * 0.5F, 0.4D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * var3 * 0.5F);
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int var5 = EnchantmentHelper.getFireAspectModifier(this);

            if (var5 > 0) {
                par1Entity.setFire(var5 * 4);
            }
        }

        return var4;
    }

    @Override
    public boolean getIsInvulnerable()
    {
        return this.getInvincible();
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.GALROID;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.GALROID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GALROID_HURT;
    }
    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_GALROID;
    }
}
