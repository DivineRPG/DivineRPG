package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityHelio extends VetheaMob {

    public EntityHelio(World worldIn) {
        super(worldIn);
        this.setSize(1F, 2f);
        this.addAttackingAI();
    }


    @Override
    public boolean attackEntityAsMob(Entity target) {
        if(super.attackEntityAsMob(target)) {
            target.addVelocity(MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * 7.0F * 0.5F, 0.4D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * 7.0F * 0.5F);
            this.motionX *= 0.6D;
            this.motionZ *= 0.6D;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int getSpawnLayer() {
        return 4;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_HELIO;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HELIO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HELIO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HELIO_HURT;
    }
}