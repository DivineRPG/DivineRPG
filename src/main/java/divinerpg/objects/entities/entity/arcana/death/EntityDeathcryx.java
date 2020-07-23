package divinerpg.objects.entities.entity.arcana.death;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityDeathcryx extends EntityDeathBase {
    protected Potion potionEffect;

    public EntityDeathcryx(World world) {
        super(world, MobEffects.SLOWNESS);
        this.setSize(1.0F, 1.2F);

        potionEffect = MobEffects.SLOWNESS;
    }

    @Override
    public float getEyeHeight() {
        return 0.85F;
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DEATHCRYX;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DEATHCRYX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DEATHCRYX_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_DEATHCRYX;
    }
}