package divinerpg.objects.entities.entity.iceika;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGlacide extends EntityDivineRPGMob {
    public EntityGlacide(World worldIn) {
        super(worldIn);
        this.setSize(0.9F, 2.0F);
    }

    @Override
    public float getEyeHeight() {
        return 1.8F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.GLACIDE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.GLACIDE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GLACIDE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_GLACIDE;
    }
}
