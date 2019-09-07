package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class KingCrab extends EntityPeacefulUntilAttacked {

    public KingCrab(World worldIn) {
        super(worldIn);
        this.setSize(1.8F, 1.7F);
        this.experienceValue = 40;
    }

    @Override
    public float getEyeHeight() {
        return 1.4F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(9.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.CRAB;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.CRAB_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CRAB_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_KING_CRAB;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && super.getCanSpawnHere();
    }
}
