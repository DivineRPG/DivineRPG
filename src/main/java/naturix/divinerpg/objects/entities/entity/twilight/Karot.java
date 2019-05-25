package naturix.divinerpg.objects.entities.entity.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Karot extends EntityDivineRPGBoss {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/karot");
    private int spawnTick;

    public Karot(World worldIn) {
        super(worldIn);
        this.spawnTick = 240;
        this.setSize(3.25F, 4F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1250);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(32);
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
        if (this.spawnTick == 0 && !this.world.isRemote) {
            AngryBunny angryBunny = new AngryBunny(this.world);
            angryBunny.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rand.nextFloat() * 360.0F, 0.0F);
            this.world.spawnEntity(angryBunny);
            this.world.spawnParticle(EnumParticleTypes.REDSTONE, angryBunny.posX, angryBunny.posY + 0.5D,
                    angryBunny.posZ, this.rand.nextGaussian() * 2.0D - 1.0D, this.rand.nextGaussian() * 2.0D - 1.0D,
                    this.rand.nextGaussian() * 2.0D - 1.0D);
            this.spawnTick = 240;
        }

        this.spawnTick--;
        super.onLivingUpdate();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        if (!this.world.isRemote) {
            for (int i = 0; i < 5; i++) {
                AngryBunny angryBunny = new AngryBunny(this.world);
                angryBunny.setPosition(this.posX, this.posY, this.posZ);
                this.world.spawnEntity(angryBunny);
            }
        }
        super.setDead();
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
