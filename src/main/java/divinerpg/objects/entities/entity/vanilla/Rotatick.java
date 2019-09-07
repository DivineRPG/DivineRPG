package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Rotatick extends EntityDivineRPGMob {
    public Rotatick(World worldIn) {
        super(worldIn);
        this.setSize(0.85F, 1F);
    }

    @Override
    public float getEyeHeight() {
        return 0.75F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ROTATICK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ROTATICK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ROTATICK_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_ROTATICK;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && this.posY < 25.0D && super.getCanSpawnHere();
    }
}
