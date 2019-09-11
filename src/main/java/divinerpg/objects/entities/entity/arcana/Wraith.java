package divinerpg.objects.entities.entity.arcana;

import divinerpg.registry.ModSounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Wraith extends Paratiku {
    private int age;

    public Wraith(World world) {
        super(world);
        this.age = 120;
    }

    public Wraith(World par1World, EntityPlayer owner) {
        super(par1World);
        this.age = 120;
        this.setTamed(true);
        this.setOwnerId(owner.getUniqueID());
    }

    @Override
    public float getEyeHeight() {
        return 1.15F;
    }

    @Override
    protected float getSoundVolume() {
        return 0.1F;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : ModSounds.WRAITH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return ModSounds.WRAITH_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.WRAITH_HURT;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.age--;
        if (this.age == 0) {
            this.setDead();
        }
    }
}