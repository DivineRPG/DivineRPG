package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.assets.render.projectile.RenderEnderTripletsFireball;
import naturix.divinerpg.utils.DRPGParticleTypes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityEnderTripletsFireball extends EntityFireball {

    @SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderTripletsFireball.class,
                manager -> new RenderEnderTripletsFireball(manager, 1f));
    }

    public EntityEnderTripletsFireball(World world, EntityLivingBase entity, double i, double j, double k) {
        super(world, entity, i, j, k);
    }

    public EntityEnderTripletsFireball(World world) {
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
        DivineRPG.proxy.spawnParticle(this.world, DRPGParticleTypes.ENDER_TRIPLET,
                this.posX + (this.rand.nextDouble() - this.rand.nextDouble()) / 6,
                this.posY + 0.5D + (this.rand.nextDouble() - this.rand.nextDouble()) / 6,
                this.posZ + (this.rand.nextDouble() - this.rand.nextDouble()) / 6, 0.0D, 0.0D, 0.0D);
    }
}
