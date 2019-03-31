package naturix.divinerpg.objects.entities.entity.iceika;

import naturix.divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import naturix.divinerpg.registry.DRPGSoundHandler;
import naturix.divinerpg.utils.Reference;
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

public class Frosty extends EntityPeacefulUntilAttacked {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/iceika/frosty");

    public Frosty(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 2.5F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
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
        return DRPGSoundHandler.FROSTY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return DRPGSoundHandler.FROSTY_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DRPGSoundHandler.FROSTY_HURT;
    }

    @Override
    public boolean shouldRenderInPass(int pass) {
        return pass == 1;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    /**
     * @Override public boolean getCanSpawnHere() { return
     *           world.provider.getDimension() ==
     *           ModDimensions.iceikaDimension.getId() && super.getCanSpawnHere(); }
     */
}
