package divinerpg.objects.entities.entity;

import net.minecraft.block.material.Material;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class EntityDivineWaterMob extends EntityPeacefulUntilAttacked {

    public EntityDivineWaterMob(World par1World) {
        super(par1World);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public void onEntityUpdate() {
        int i = this.getAir();
        super.onEntityUpdate();

        if (this.isEntityAlive() && !this.isInWater()) {
            if (!this.world.isRemote) {
                this.motionX = 0.0D;
                this.motionY -= 0.08D;
                this.motionY *= 0.9800000190734863D;
                this.motionZ = 0.0D;
            }
            --i;
            this.setAir(i);

            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.DROWN, 2.0F);
            }
        } else {
            this.setAir(300);
        }
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    public boolean isInWater() {
        return this.world.getBlockState(new BlockPos((int) this.posX, MathHelper.floor(this.posY), (int) this.posZ))
                .getMaterial() == Material.WATER;
    }

    @Override
    public boolean isValidLightLevel() {
        return true;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && this.posY > 45.0D && this.posY < (double) this.world.getSeaLevel()
                && isInWater();
    }
    @Override
    protected boolean canDespawn()
    {
        return true;
    }
}