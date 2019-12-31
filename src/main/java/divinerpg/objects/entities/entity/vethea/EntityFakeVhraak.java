package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityFakeVhraak extends VetheaMob {

    private int lifeTick = 20;

    public EntityFakeVhraak(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(30.0D);
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
