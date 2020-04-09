package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.ai.AIDivineFireballAttack;
import divinerpg.objects.entities.entity.EntityDivineGhast;
import divinerpg.objects.entities.entity.projectiles.EntityDissimentShot;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityDissiment extends EntityDivineGhast {
    private static final double spawnLayer = 4;

    public EntityDissiment(World par1World) {
        super(par1World);
        this.isImmuneToFire = true;
        this.experienceValue = 5;
        this.setSize(4.0F, 4.0F);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 48.0D * spawnLayer && this.posY > 48.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(70);
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
        return ModSounds.DISSIMENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.DISSIMENT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DISSIMENT_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_DISSIMENT;
    }

    @Override
    protected float getSoundVolume() {
        return 10.0F;
    }

}
