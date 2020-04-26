package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityFakeVhraak extends VetheaMob {

    private int lifeTick = 20;

    public EntityFakeVhraak(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1F);
        this.addAttackingAI();
    }


    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        this.lifeTick--;
        if(this.lifeTick <= 0) {
            this.setDead();
        }
    }

    @Override
    public int getSpawnLayer() {
        return 0;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_FAKE_VHRAAK;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.VHRAAK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.VHRAAK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.VHRAAK_HURT;
    }
}
