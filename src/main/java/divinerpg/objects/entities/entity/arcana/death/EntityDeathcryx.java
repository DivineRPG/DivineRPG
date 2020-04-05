package divinerpg.objects.entities.entity.arcana.death;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
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
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(160.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DEATHCRYX;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.DEATHCRYX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DEATHCRYX_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_DEATHCRYX;
    }
}