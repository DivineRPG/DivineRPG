package divinerpg.entities.vanilla;

import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.*;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityWhale extends EntityDivineWaterMob {

    public EntityWhale(EntityType<? extends EntityWhale> type, World worldIn) {
        super(type, worldIn);
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

    @Override
    public void livingTick() {
        super.livingTick();
        if (!this.isInWater()) {
            if (rand.nextInt(2) == 0) {

                for (float x = -0.25F; x <= 0.25F; x += 0.125F) {
                    for (float z = -0.25F; z <= 0.25F; z += 0.125F) {
                        world.addParticle(ParticleTypes.DRIPPING_WATER, getPosX() + x, getPosY(), getPosZ() + z, 0, 0.4, 0);
                    }
                }


            }
        }
    }
}