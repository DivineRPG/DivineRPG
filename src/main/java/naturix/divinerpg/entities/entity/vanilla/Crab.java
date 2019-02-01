package naturix.divinerpg.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.entity.EntityPeacefulUntilAttacked;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Biomes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class Crab extends EntityPeacefulUntilAttacked {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/crab");

    public Crab(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1F);
        this.setHealth(this.getMaxHealth());
        this.experienceValue = 40;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(45.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
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
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL
                && this.world.getBiome(getPosition()) == Biomes.BEACH
                || this.world.getBiome(getPosition()) == Biomes.COLD_BEACH
                || this.world.getBiome(getPosition()) == Biomes.STONE_BEACH;
    }
}
