package divinerpg.objects.entities.entity.arcana;

import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityRazorback extends EntityDivineMob {

    public EntityRazorback(World world) {
        super(world);
        this.setSize(0.6F, 0.5F);
    }

    @Override
    public float getEyeHeight() {
        return 0.225F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.RAZORBACK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return SoundRegistry.RAZORBACK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.RAZORBACK_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_RAZORBACK;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}