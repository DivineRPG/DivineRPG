package divinerpg.objects.entities.entity.arcana.death;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.init.MobEffects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityDeathHound extends EntityDeathBase {
    public EntityDeathHound(World world) {
        super(world, MobEffects.BLINDNESS);
        this.setSize(0.8F, 0.9F);
    }

    @Override
    public float getEyeHeight() {
        return 0.75F;
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DEATH_HOUND;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.DEATH_HOUND_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DEATH_HOUND;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_DEATH_HOUND;
    }
}