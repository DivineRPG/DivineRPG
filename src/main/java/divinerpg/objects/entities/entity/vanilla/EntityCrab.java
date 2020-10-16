package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCrab extends EntityPeacefulUntilAttacked {

    public EntityCrab(World worldIn) {
        super(worldIn);
        this.setSize(1.1F, 0.8F);
        this.experienceValue = 40;
    }

    @Override
    public float getEyeHeight() {
        return 0.6F;
    }
@Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CRAB;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CRAB_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CRAB_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_CRAB;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && super.getCanSpawnHere();
    }
}
