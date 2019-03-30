package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.registry.DRPGSoundHandler;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TheEye extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vanilla/the_eye");
    private boolean hasPotion = false;

    public TheEye(World worldIn) {
        super(worldIn);
        this.setSize(1.6F, 1.6f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityPlayer player = this.world.getNearestAttackablePlayer(this, 64.0D, 64.0D);
        if (player != null) {
            Vec3d lookVec = player.getLook(1.0F).normalize();
            Vec3d lookAtMeVec = new Vec3d(this.posX - player.posX,
                    this.getEntityBoundingBox().minY + this.height - (player.posY + player.getEyeHeight()),
                    this.posZ - player.posZ);
            double distMagnitude = lookAtMeVec.lengthVector();
            lookAtMeVec = lookAtMeVec.normalize();
            double var7 = lookVec.dotProduct(lookAtMeVec);
            if (var7 > 1.0D - 0.025D / distMagnitude && player.canEntityBeSeen(this)) {
                player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 100, 0, false, true));
                // player.triggerAchievement(DivineRPGAchievements.eyeOfEvil);
            }
        }
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DRPGSoundHandler.THE_EYE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return DRPGSoundHandler.THE_EYE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DRPGSoundHandler.THE_EYE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && this.posY <= 16.0D && super.getCanSpawnHere();
    }
}