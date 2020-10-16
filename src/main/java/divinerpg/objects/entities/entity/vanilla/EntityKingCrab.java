package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityKingCrab extends EntityPeacefulUntilAttacked {

    public EntityKingCrab(World worldIn) {
        super(worldIn);
        this.setSize(1.8F, 1.7F);
        this.experienceValue = 40;
    }

    @Override
    public float getEyeHeight() {
        return 1.4F;
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
        return LootTableRegistry.ENTITIES_KING_CRAB;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && super.getCanSpawnHere();
    }
}
