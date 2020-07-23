package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineWaterMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityShark extends EntityDivineWaterMob {

    public EntityShark(World worldIn) {
        super(worldIn);
        this.setSize(1F, 0.5F);
    }

    @Override
    public float getEyeHeight() {
        return 0.3F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SHARK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.SHARK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.SHARK_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SHARK;
    }
}
