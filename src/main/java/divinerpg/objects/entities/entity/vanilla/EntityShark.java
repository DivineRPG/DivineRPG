package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineRPGSwimming;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityShark extends EntityDivineRPGSwimming {

    public EntityShark(World worldIn) {
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
