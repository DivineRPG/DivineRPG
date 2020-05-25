package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineWaterMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityWhale extends EntityDivineWaterMob {

    public EntityWhale(World worldIn) {
        super(worldIn);
        this.setSize(3F, 0.8F);
    }

    @Override
    public float getEyeHeight() {
        return 0.4F;
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.WHALE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.WHALE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.WHALE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_WHALE;
    }
}
