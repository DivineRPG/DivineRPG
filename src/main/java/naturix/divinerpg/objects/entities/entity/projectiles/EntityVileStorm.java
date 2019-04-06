package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.objects.entities.assets.render.projectile.RenderVileStorm;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityVileStorm extends EntityThrowable {
    @SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityVileStorm.class,
                manager -> new RenderVileStorm(manager, 1f));
    }

    public EntityVileStorm(World var1) {
        super(var1);
    }

    public EntityVileStorm(World var1, EntityLivingBase var3) {
        super(var1, var3);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            if (result.entityHit instanceof EntityLiving) {
                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 4);
                ((EntityLivingBase) result.entityHit).addPotionEffect(new PotionEffect(MobEffects.POISON, 45, 3));
            }
        }

        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}
