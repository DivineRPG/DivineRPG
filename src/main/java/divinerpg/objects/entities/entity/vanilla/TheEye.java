package divinerpg.objects.entities.entity.vanilla;

import divinerpg.Reference;
import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import divinerpg.registry.ModTriggers;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TheEye extends EntityDivineRPGMob {
    private boolean hasPotion = false;

    public TheEye(World worldIn) {
        super(worldIn);
        this.setSize(1.3F, 2F);
    }

    @Override
    public float getEyeHeight() {
        return 1.75F;
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
                if (player instanceof EntityPlayerMP) {
                    ModTriggers.DIVINERPG_EYE.trigger((EntityPlayerMP) player);
                }
            }
        }
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.THE_EYE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.THE_EYE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.THE_EYE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_THE_EYE;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && this.posY <= 16.0D && super.getCanSpawnHere();
    }
}