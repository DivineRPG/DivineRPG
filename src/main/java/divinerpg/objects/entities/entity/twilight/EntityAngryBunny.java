package divinerpg.objects.entities.entity.twilight;

import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityAngryBunny extends EntityDivineMob {
    public EntityAngryBunny(World worldIn) {
        super(worldIn);
        this.setSize(1.1F, 1.8F);
        this.experienceValue = 40;
    }

    @Override
    public float getEyeHeight() {
        return 1.4F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 12);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HISS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GROWL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GROWL_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ANGRY_BUNNY;
    }
}