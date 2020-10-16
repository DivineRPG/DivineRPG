package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityCymesoid extends VetheaMob {

    public EntityCymesoid(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 2f);
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
                this.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 200, 1));
            }
        }
    }

    @Override
    public int getSpawnLayer() {
        return 1;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_CYMESOID;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CYMESOID;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CYMESOID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CYMESOID_HURT;
    }
}