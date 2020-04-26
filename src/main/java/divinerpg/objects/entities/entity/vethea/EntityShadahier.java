package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityShadahier extends VetheaMob {

    public EntityShadahier(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 1.3f);
        this.addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    public boolean attackEntityAsMob(Entity target) {
        if(super.attackEntityAsMob(target)) {
            if(!this.world.isRemote && target instanceof EntityLivingBase) {
                ((EntityLivingBase) target).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 1, 1));
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int getSpawnLayer() {
        return 1;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_SHADAHIER;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.SHADAHIER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.SHADAHIER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.SHADAHIER_HURT;
    }

}