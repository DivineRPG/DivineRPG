package naturix.divinerpg.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.entity.EntityDivineRPGBoss;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class AyeracoPurple extends EntityDivineRPGBoss {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/ayeraco_purple");

    public AyeracoPurple(World worldIn) {
        super(worldIn);
        this.setSize(2.8F, 1.2F);
        this.setHealth(this.getMaxHealth());
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(600.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public Color getBarColor() {
        return Color.PURPLE;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.AYERACO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.AYERACO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.AYERACO_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
