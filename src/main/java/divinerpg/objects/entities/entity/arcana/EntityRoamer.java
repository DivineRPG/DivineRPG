package divinerpg.objects.entities.entity.arcana;

import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityRoamer extends EntityDivineMob {

    public EntityRoamer(World world) {
        super(world);
        this.setSize(0.6F, 1.8F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public float getEyeHeight() {
        return 1.625F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    protected float getSoundVolume() {
        return 0.3F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ROAMER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return SoundRegistry.ROAMER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ROAMER_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ROAMER;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}