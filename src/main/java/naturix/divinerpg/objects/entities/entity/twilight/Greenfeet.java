package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Greenfeet extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/greenfeet");

    public Greenfeet(World worldIn) {
        super(worldIn);
        this.setSize(1, 2);
    }

    @Override
    public float getEyeHeight() {
        return 1.75F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(14);
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
    public void onLivingUpdate() {
        if (this.world.isDaytime() && !this.world.isRemote) {
            float lightLevel = this.getBrightness();
            if (lightLevel > 0.5F
                    && this.world.canBlockSeeSky(new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.posY),
                            MathHelper.floor(this.posZ)))
                    && this.rand.nextFloat() * 30.0F < (lightLevel - 0.4F) * 2.0F) {
                this.setFire(8);
            }
        }
        super.onLivingUpdate();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.NESRO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.NESRO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.NESRO_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
