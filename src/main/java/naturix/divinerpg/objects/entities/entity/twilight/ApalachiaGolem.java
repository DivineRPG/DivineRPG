package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ApalachiaGolem extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID,
            "entities/twilight/apalachia_golem");

    public ApalachiaGolem(World worldIn) {
        super(worldIn);
        this.setSize(1F, 2.8F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(250);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(16);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.GROWL_HURT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.GROWL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GROWL_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}