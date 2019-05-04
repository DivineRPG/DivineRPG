package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Madivel extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/madivel");

    public Madivel(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(18);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.MADIVEL;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.MADIVEL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.MADIVEL_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}