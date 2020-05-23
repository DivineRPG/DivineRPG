package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityBiphron extends VetheaMob {

    private boolean gravity;

    public EntityBiphron(World worldIn) {
        super(worldIn);
        this.setSize(1F, 2f);
        this.addAttackingAI();
    }


    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.rand.nextInt(50) == 0) {
            this.gravity = !this.gravity;
        }

        if (this.gravity) {
            this.motionY = 0.4;
        }
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
        return;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(source == DamageSource.FALL) {
            return false;
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public int getSpawnLayer() {
        return 2;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_BIPHRON;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.BIPHRON;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.BIPHRON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.BIPHRON_HURT;
    }


}