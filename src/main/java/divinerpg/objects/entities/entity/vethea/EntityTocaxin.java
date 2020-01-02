package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(65);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }
    
    @Override
    public int getSpawnLayer() {
    	return 3;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityLivingBase var1 = this.getAttackTarget();

        if (var1 == null || var1.getDistance(this) > 8 || this.hurtTimer != 0) {
            this.hurtTimer--;
            return;
        } else {
            this.hurtTimer = 10;
            var1.attackEntityFrom(DamageSource.MAGIC, (int) (8 - var1.getDistance(this)));
        }
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_TOCAXIN;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.TOCAXIN;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.TOCAXIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.TOCAXIN_HURT;
    }
}
