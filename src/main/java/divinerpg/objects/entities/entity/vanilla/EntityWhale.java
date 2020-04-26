package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineRPGSwimming;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityWhale extends EntityDivineRPGSwimming {

    public EntityWhale(World worldIn) {
        super(worldIn);
        this.setSize(3F, 0.8F);
    }

    @Override
    public float getEyeHeight() {
        return 0.4F;
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.WHALE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.WHALE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.WHALE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_WHALE;
    }
}
