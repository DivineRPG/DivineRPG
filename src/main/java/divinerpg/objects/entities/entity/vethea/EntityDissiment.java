package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.ai.AIDivineFireballAttack;
import divinerpg.objects.entities.entity.EntityDivineFlyingMob;
import divinerpg.objects.entities.entity.projectiles.EntityDissimentShot;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityDissiment extends EntityDivineFlyingMob {
    private static final int spawnLayer = 4;

    public EntityDissiment(World par1World) {
        super(par1World);
        this.setSize(4.0F, 4.0F);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 48.0D * spawnLayer && this.posY > 48.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }

    @Nullable
    @Override
    protected AIDivineFireballAttack createShootAI() {
        return new AIDivineFireballAttack(this,
                (world1, parent, x, y, z) -> new EntityDissimentShot(this.world, this),
                null);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DISSIMENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DISSIMENT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DISSIMENT_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_DISSIMENT;
    }

    @Override
    protected float getSoundVolume() {
        return 2.0F;
    }

}
