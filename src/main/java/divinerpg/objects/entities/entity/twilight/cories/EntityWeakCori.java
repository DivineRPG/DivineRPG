package divinerpg.objects.entities.entity.twilight.cories;

import divinerpg.objects.entities.ai.AIDivineFireballAttack;
import divinerpg.objects.entities.ai.ILaunchThrowable;
import divinerpg.objects.entities.entity.EntityDivineFlyingMob;
import divinerpg.objects.entities.entity.projectiles.EntityCoriShot;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityWeakCori extends EntityDivineFlyingMob {

    public EntityWeakCori(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 1.5F);
    }

    @Override
    protected AIDivineFireballAttack createShootAI() {
        return new AIDivineFireballAttack(this,
                new ILaunchThrowable() {

                    @Override
                    public float getInaccuracy(World world) {
                        return 0;
                    }

                    @Override
                    public EntityThrowable createThowable(World world, EntityLivingBase parent, double x, double y, double z) {
                        return new EntityCoriShot(world, parent, (float) parent.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
                    }
                },
                SoundRegistry.CORI_SHOOT);
    }

    @Override
    public float getEyeHeight() {
        return 0.8F;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CORI_IDLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CORI_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CORI_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_WEAK_CORI;
    }
}