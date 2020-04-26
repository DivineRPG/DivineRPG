package divinerpg.objects.entities.entity.iceika;

import divinerpg.objects.entities.ai.AIDivineFireballAttack;
import divinerpg.objects.entities.entity.EntityDivineGhast;
import divinerpg.objects.entities.entity.projectiles.EntityFractiteShot;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityFractite extends EntityDivineGhast {

    public EntityFractite(World worldIn) {
        super(worldIn);
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        this.setSize(1.7F, 1.3F);
    }

    @Override
    public float getEyeHeight() {
        return 0.7F;
    }

    @Nullable
    @Override
    protected AIDivineFireballAttack createShootAI() {
        return new AIDivineFireballAttack(this,
                (world1, parent, x, y, z, fireballStrength) ->
                        new EntityFractiteShot(world1, this, x, y, z),
                ModSounds.FRACTITE_ATTACK);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.FRACTITE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.FRACTITE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.FRACTITE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_FRACTITE;
    }
}
