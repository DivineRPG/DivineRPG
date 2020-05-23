package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityVermenous extends VetheaMob {

    public EntityVermenous(World worldIn) {
        super(worldIn);
        this.setSize(1F, 3f);
        this.addAttackingAI();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityPlayer var1 = this.world.getClosestPlayerToEntity(this, 64.0D);

        if (var1 == null || var1.isCreative())
            return;
        else {
            Vec3d var3 = var1.getLook(1.0F).normalize();
            Vec3d var4 = new Vec3d(this.posX - var1.posX, this.getEntityBoundingBox().minY + this.height / 2.0F - (var1.posY + var1.getEyeHeight()), this.posZ - var1.posZ);
            double var5 = var4.lengthVector();
            var4 = var4.normalize();
            double var7 = var3.dotProduct(var4);
            if( var7 > 1.0D - 0.025D / var5 && var1.canEntityBeSeen(this)) {
                var1.attackEntityFrom(DamageSource.causeMobDamage(this), 4);
            }
        }
    }

    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_VERMENOUS;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.VERMENOUS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.VERMENOUS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.VERMENOUS_HURT;
    }
}