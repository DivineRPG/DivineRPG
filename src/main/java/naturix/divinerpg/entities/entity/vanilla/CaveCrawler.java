package naturix.divinerpg.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class CaveCrawler extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/cave_crawler");

    public CaveCrawler(World worldIn) {
        super(worldIn);
        this.setSize(1.5F, 2.0F);
        this.setHealth(this.getMaxHealth());
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
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
        return ModSounds.CRAWLER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.CRAWLER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CRAWLER_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 35.0D && super.getCanSpawnHere();
    }
}
