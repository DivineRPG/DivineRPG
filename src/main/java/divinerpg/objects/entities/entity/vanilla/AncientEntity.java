package divinerpg.objects.entities.entity.vanilla;

import divinerpg.Reference;
import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class AncientEntity extends EntityDivineRPGBoss {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID,
            "entities/vanilla/ancient_entity");

    public AncientEntity(World worldIn) {
        super(worldIn);
        this.setSize(4.0F, 6.5F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(800.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        super.attackEntityAsMob(entity);
        if (this.getAttackTarget() != null) {
            this.getAttackTarget().addVelocity(this.motionX * 10.0D, 2.0D, this.motionZ * 10.0D);
            if (this.getAttackTarget() instanceof EntityPlayer) {
                ((EntityLivingBase) getAttackTarget()).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
                playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
            }
            return true;
        }
        return false;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_IRONGOLEM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRONGOLEM_DEATH;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
