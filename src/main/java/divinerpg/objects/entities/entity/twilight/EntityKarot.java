package divinerpg.objects.entities.entity.twilight;

import divinerpg.objects.entities.entity.EntityDivineBoss;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo.Color;

import javax.annotation.Nullable;

public class EntityKarot extends EntityDivineBoss {

    private int spawnTick;

    public EntityKarot(World worldIn) {
        super(worldIn);
        this.spawnTick = 240;
        this.setSize(3.25F, 4F);
    }

    @Override
    public float getEyeHeight() {
        return 3.7F;
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
            EntityAngryBunny angryBunny = new EntityAngryBunny(this.world);
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
                EntityAngryBunny angryBunny = new EntityAngryBunny(this.world);
                angryBunny.setPosition(this.posX, this.posY, this.posZ);
                this.world.spawnEntity(angryBunny);
            }
        }
        super.setDead();
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_KAROT;
    }
    
    @Override
    public Color getBarColor() {
        return Color.WHITE;
    }
}
