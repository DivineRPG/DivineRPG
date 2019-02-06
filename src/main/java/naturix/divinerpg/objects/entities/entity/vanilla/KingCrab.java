package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Biomes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class KingCrab extends EntityPeacefulUntilAttacked {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/king_crab");

    public KingCrab(World worldIn) {
        super(worldIn);
        this.setSize(1.55F, 1.25F);
        this.setHealth(this.getMaxHealth());
        this.experienceValue = 40;
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
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.world.getBiome(getPosition()) == Biomes.BEACH
                || this.world.getBiome(getPosition()) == Biomes.COLD_BEACH
                || this.world.getBiome(getPosition()) == Biomes.STONE_BEACH && super.getCanSpawnHere();
    }
}
