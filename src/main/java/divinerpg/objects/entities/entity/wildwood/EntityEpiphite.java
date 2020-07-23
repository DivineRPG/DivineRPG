package divinerpg.objects.entities.entity.wildwood;

import divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityEpiphite extends EntityPeacefulUntilAttacked {

    public EntityEpiphite(World worldIn) {
        super(worldIn);
        this.setSize(0.9F, 1.3F);
        this.isImmuneToFire = true;
        this.experienceValue = 40;
    }

    @Override
    public float getEyeHeight() {
        return 1.1F;
    }


    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.rand.nextInt(5) == 0)
            this.world.spawnEntity(new EntityLightningBolt(this.world, entity.posX, entity.posY, entity.posZ, true));
        return super.attackEntityAsMob(entity);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GROWL;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GROWL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GROWL_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_EPIPHITE;
    }
}