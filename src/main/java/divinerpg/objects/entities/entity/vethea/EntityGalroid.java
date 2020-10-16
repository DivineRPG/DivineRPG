package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGalroid extends VetheaMob {

    private int protectionTimer;

    public EntityGalroid(World worldIn) {
        super(worldIn);
        this.setSize(1F, 3f);
        this.protectionTimer = 200;
        this.addAttackingAI();
    }


    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.getProtectionTimer() <= 0 && !this.getIsInvulnerable()) {
            this.setProtectionTimer(200);
            this.setEntityInvulnerable(true);
        }
        else if (this.getIsInvulnerable() && this.getProtectionTimer() <= 0) {
            this.setProtectionTimer(200);
            this.setEntityInvulnerable(false);
        }
        this.setProtectionTimer(this.getProtectionTimer()-1);
    }

    private int getProtectionTimer() {
        return this.protectionTimer;
    }

    private void setProtectionTimer(int value) {
        this.protectionTimer = value;
    }

    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_GALROID;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GALROID;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GALROID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GALROID_HURT;
    }
}