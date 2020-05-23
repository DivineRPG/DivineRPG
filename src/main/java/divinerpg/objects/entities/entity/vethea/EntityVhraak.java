package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityVhraak extends VetheaMob {

    private int spawnTick = 80;

    public EntityVhraak(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1F);
        this.addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if(!world.isRemote) {
            if(this.getAttackTarget() != null) {
                if (this.spawnTick == 0) {
                    EntityFakeVhraak fakeVhraak = new EntityFakeVhraak(this.world);
                    fakeVhraak.setLocationAndAngles(this.posX + 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
                    this.world.spawnEntity(fakeVhraak);

                    fakeVhraak = new EntityFakeVhraak(this.world);
                    fakeVhraak.setLocationAndAngles(this.posX - 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
                    this.world.spawnEntity(fakeVhraak);

                    fakeVhraak = new EntityFakeVhraak(this.world);
                    fakeVhraak.setLocationAndAngles(this.posX + 1, this.posY, this.posZ - 1, this.rotationYaw, this.rotationPitch);
                    this.world.spawnEntity(fakeVhraak);

                    fakeVhraak = new EntityFakeVhraak(this.world);
                    fakeVhraak.setLocationAndAngles(this.posX - 1, this.posY, this.posZ - 1, this.rotationYaw, this.rotationPitch);
                    this.world.spawnEntity(fakeVhraak);
                    this.spawnTick = 80;
                }
                else {
                    this.spawnTick--;
                }
            }
        }
    }

    @Override
    public int getSpawnLayer() {
        return 4;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_VHRAAK;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.VHRAAK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.VHRAAK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.VHRAAK_HURT;
    }
}