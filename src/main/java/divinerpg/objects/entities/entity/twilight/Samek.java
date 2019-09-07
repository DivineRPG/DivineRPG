package divinerpg.objects.entities.entity.twilight;

import divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Samek extends EntityPeacefulUntilAttacked {

    public Samek(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 2.0F);
        this.experienceValue = 40;
    }

    @Override
    public float getEyeHeight() {
        return 1.7F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(160);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.VEREK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.VEREK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.VEREK_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_SAMEK;
    }
}