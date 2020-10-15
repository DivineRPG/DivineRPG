package TeamDivineRPG.divinerpg.entities.vanilla;

import TeamDivineRPG.divinerpg.entities.base.EntityDivineWaterMob;
import TeamDivineRPG.divinerpg.registries.LootTableRegistry;
import TeamDivineRPG.divinerpg.registries.SoundRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

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
    public void livingTick()
    {
        super.livingTick();
        if(getPosY() > world.getSeaLevel() - 1) {
            if(rand.nextInt(2) == 0) {

                for(float x = -0.25F; x <= 0.25F; x += 0.125F) {
                    for(float z = -0.25F; z <= 0.25F; z += 0.125F) {
                        world.addParticle(ParticleTypes.DRIPPING_WATER, getPosX() + x, getPosY(), getPosZ() + z, 0, 0.4, 0);
                    }
                }


            }
        }
    }
    public static boolean canSpawnHere(EntityType<EntityWhale> entity, IWorld world, SpawnReason spawn_reason, BlockPos pos, Random random) {
        return (random.nextInt(10) == 0 || !world.canBlockSeeSky(pos)) && (spawn_reason == SpawnReason.SPAWNER || world.getFluidState(pos).isTagged(FluidTags.WATER));
    }
}