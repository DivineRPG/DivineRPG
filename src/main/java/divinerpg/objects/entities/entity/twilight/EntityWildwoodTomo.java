package divinerpg.objects.entities.entity.twilight;

import divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityWildwoodTomo extends EntityPeacefulUntilAttacked {

    public EntityWildwoodTomo(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 1.0F);
        this.experienceValue = 40;
    }

    @Override
    public float getEyeHeight() {
        return 0.6F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.CROAK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.GROWL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GROWL_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_WILDWOOD_TOMO;
    }
}