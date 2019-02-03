package naturix.divinerpg.entities.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityEnderTripletFireball extends EntityFireball {

    public EntityEnderTripletFireball(World world, EntityLivingBase entity, double i, double j, double k) {
        super(world, entity, i, j, k);
    }

    public EntityEnderTripletFireball(World world) {
        super(world);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            if (result.entityHit != null) {
                result.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 10);
            }
            this.world.createExplosion(null, this.posX, this.posY, this.posZ, 3F, false);
            this.setDead();
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onUpdate() {
        super.onUpdate();
        EntityTripletFX fx = new EntityTripletFX(this.world,
                this.posX + (this.rand.nextDouble() - this.rand.nextDouble()) / 6,
                this.posY + 0.5D + (this.rand.nextDouble() - this.rand.nextDouble()) / 6,
                this.posZ + (this.rand.nextDouble() - this.rand.nextDouble()) / 6, 0.0D, 0.0D, 0.0D);
        FMLClientHandler.instance().getClient().effectRenderer.addEffect(fx);
    }
}
