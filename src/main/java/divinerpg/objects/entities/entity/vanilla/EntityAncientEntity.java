package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo.Color;

public class EntityAncientEntity extends EntityDivineRPGBoss {

    public EntityAncientEntity(World worldIn) {
        super(worldIn);
        this.setSize(4.0F, 6.5F);
        this.experienceValue = 2000;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        super.attackEntityAsMob(entity);
        if (this.getAttackTarget() != null) {
            this.getAttackTarget().addVelocity(this.motionX * 10.0D, 2.0D, this.motionZ * 10.0D);
            if (this.getAttackTarget() instanceof EntityPlayer) {
                getAttackTarget().addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
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
        return LootTableRegistry.ENTITIES_ANCIENT_ENTITY;
    }
    
    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }
}
