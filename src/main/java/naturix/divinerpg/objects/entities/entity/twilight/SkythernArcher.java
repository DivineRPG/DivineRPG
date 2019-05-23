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
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SkythernArcher extends EntityDivineRPGMob implements IRangedAttackMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID,
            "entities/twilight/skythern_archer");

    public SkythernArcher(World worldIn) {
        super(worldIn);
        this.setSize(2F, 3f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(55);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);
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
        EntityDivineArrow arrow = new EntityDivineArrow(this.world, ArrowType.SKYTHERN_ARCHER_ARROW, this);
        double d0 = target.posX - this.posX;
        double d1 = target.getEntityBoundingBox().minY + (double) (target.height / 3.0F) - arrow.posY;
        double d2 = target.posZ - this.posZ;
        double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
        arrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, 12.0F);
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(arrow);
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
