package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Verek extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/verek");

    public Verek(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 2.0F);
    }

    @Override
    public float getEyeHeight() {
        return 1.8F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public int getTotalArmorValue() {
        return 6;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.VEREK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.VEREK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.VEREK_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}