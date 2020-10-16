package divinerpg.objects.entities.entity.skythern;

import divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntitySamek extends EntityPeacefulUntilAttacked {

    public EntitySamek(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 2.0F);
        this.experienceValue = 40;
    }

    @Override
    public float getEyeHeight() {
        return 1.7F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.VEREK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.VEREK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.VEREK_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SAMEK;
    }
}