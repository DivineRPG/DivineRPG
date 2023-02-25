package divinerpg.entities.projectile;

import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.network.NetworkHooks;
import net.minecraft.core.particles.*;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class DivineSnowball extends ThrowableItemProjectile {
    public DivineSnowball(EntityType<? extends DivineSnowball> type, Level world) {
        super(type, world);
    }

    public DivineSnowball(Level world, LivingEntity entity, EntityType<? extends DivineSnowball> type) {
        super(type, entity, world);
    }

    public DivineSnowball(Level world, double x, double y, double z, EntityType<? extends DivineSnowball> type) {
        super(type, x, y, z, world);
    }

    protected Item getDefaultItem() {
        return Items.SNOWBALL;
    }

    @OnlyIn(Dist.CLIENT)
    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return new ItemParticleOption(ParticleTypes.ITEM, itemstack);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte b) {
        if (b == 3) {
            ParticleOptions iparticledata = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(iparticledata, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.remove(RemovalReason.DISCARDED);
        }

    }


    @Override
    public void tick() {
        super.tick();

        if (this.tickCount > 200)
            this.kill();
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
