package naturix.divinerpg.objects.entities.entity.iceika;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.registry.ModDimensions;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Glacide extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/glacide");

    public Glacide(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 1.8F);
        this.setHealth(this.getMaxHealth());
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.GLACIDE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.GLACIDE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GLACIDE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == ModDimensions.iceikaDimension.getId() && super.getCanSpawnHere();
    }
}
