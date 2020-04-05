package divinerpg.objects.entities.entity.twilight.cories;

import divinerpg.objects.entities.ai.AIDivineFireballAttack;
import divinerpg.objects.entities.entity.EntityDivineGhast;
import divinerpg.objects.entities.entity.projectiles.EntityCoriShot;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityAdvancedCori extends EntityDivineGhast {

    public EntityAdvancedCori(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 1.5F);
    }

    @Override
    protected AIDivineFireballAttack createShootAI() {
        return new AIDivineFireballAttack(this, (world1, parent, x, y, z, fireballStrength) -> {
            EntityCoriShot shot = new EntityCoriShot(world, parent, 100);
            shot.shoot(x, y, z, 1.6f, 4);
            return shot;
        });
    }

    @Override
    public float getEyeHeight() {
        return 0.8F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.CORI_IDLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.CORI_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CORI_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_ADVANCED_CORI;
    }
}