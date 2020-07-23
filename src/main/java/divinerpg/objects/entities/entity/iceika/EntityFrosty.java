package divinerpg.objects.entities.entity.iceika;

import divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityFrosty extends EntityPeacefulUntilAttacked {

    public EntityFrosty(World worldIn) {
        super(worldIn);
        this.setSize(0.9F, 2.5F);
    }

    @Override
    public float getEyeHeight() {
        return 1.85F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D / 1.6D);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        boolean attack = super.attackEntityAsMob(entity);
        if (attack && entity instanceof EntityLivingBase) {
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 2, true, false));
            entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * 2.5 * 0.5F, 0.1D,
                    MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * 2.5 * 0.5F);
        }
        return attack;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.FROSTY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.FROSTY_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.FROSTY_HURT;
    }

    @Override
    public boolean shouldRenderInPass(int pass) {
        return pass == 1;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_FROSTY;
    }
}
