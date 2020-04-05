package divinerpg.objects.entities.entity.arcana;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityDeathHound extends EntityDeathcryx {

    public EntityDeathHound(World world) {
        super(world);
        this.setSize(0.8F, 0.9F);
        potionEffect = MobEffects.BLINDNESS;
    }

    @Override
    public float getEyeHeight() {
        return 0.75F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DEATH_HOUND;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.DEATH_HOUND_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DEATH_HOUND;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_DEATH_HOUND;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}