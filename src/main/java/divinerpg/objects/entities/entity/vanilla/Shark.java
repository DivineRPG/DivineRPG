package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineRPGSwimming;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Shark extends EntityDivineRPGSwimming {

    public Shark(World worldIn) {
        super(worldIn);
        this.setSize(1F, 0.5F);
    }

    @Override
    public float getEyeHeight() {
        return 0.3F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.SHARK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.SHARK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.SHARK_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_SHARK;
    }
}
