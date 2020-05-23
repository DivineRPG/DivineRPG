package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityTocaxin extends VetheaMob {

    private int hurtTimer;

    public EntityTocaxin(World worldIn) {
        super(worldIn);
        this.setSize(1F, 3.3f);
        this.hurtTimer = 10;
        this.addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityLivingBase var1 = this.getAttackTarget();
        if(var1 != null) {
            if(this.getDistance(var1) > 8 || this.hurtTimer != 0) {
                this.hurtTimer--;
            }
            else {
                this.hurtTimer = 10;
                var1.attackEntityFrom(DamageSource.causeMobDamage(this), (int) (8 - this.getDistance(var1)));
            }
        }
    }

    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_TOCAXIN;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.TOCAXIN;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.TOCAXIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.TOCAXIN_HURT;
    }
}