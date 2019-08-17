package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.enums.ArrowType;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class SkythernArcher extends EntityDivineRPGMob implements IRangedAttackMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID,
            "entities/twilight/skythern_archer");

    public SkythernArcher(World worldIn) {
        super(worldIn);
        this.setSize(1.8F, 3.0F);
    }

    @Override
    public float getEyeHeight() {
        return 2.9F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(14);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
        this.tasks.addTask(0, new EntityAIAttackRanged(this, 1, 15, 60, 15));
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
        this.world.spawnEntity(
                new EntityDivineArrow(this.world, ArrowType.SKYTHERN_ARCHER_ARROW, this, target, 1.6F, 12.0F));
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ARCHER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.HIGH_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.HIGH_HIT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
