package divinerpg.objects.entities.entity.arcana;

import divinerpg.Reference;
import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Roamer extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/arcana/roamer");

    public Roamer(World world) {
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(110.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
    }

    @Override
    protected float getSoundVolume() {
        return 0.3F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ROAMER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return ModSounds.ROAMER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ROAMER_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}