package divinerpg.objects.entities.entity.twilight;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class WildwoodGolem extends EntityDivineRPGMob {

    public WildwoodGolem(World worldIn) {
        super(worldIn);
        this.setSize(1.3F, 2.9F);
    }

    @Override
    public float getEyeHeight() {
        return 2.7F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200);
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
        return DRPGLootTables.ENTITIES_WILDWOOD_GOLEM;
    }
}