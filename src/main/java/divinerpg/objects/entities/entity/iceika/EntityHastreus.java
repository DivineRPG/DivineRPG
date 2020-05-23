package divinerpg.objects.entities.entity.iceika;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.List;

public class EntityHastreus extends EntityDivineRPGMob {

    public EntityHastreus(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 1.9F);
    }

    @Override
    public float getEyeHeight() {
        return 1.3F;
    }


    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public void onLivingUpdate() {
        List<Entity> e = this.world.getEntitiesWithinAABBExcludingEntity(this,
                this.getEntityBoundingBox().expand(5, 5, 5));

        for (Entity entity : e) {
            if (entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) {
                EntityPlayer player = (EntityPlayer)entity;

                if(!player.isCreative() && !player.isSpectator()) {
                    player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 12, 18, true, false));
                }
            }
        }

        super.onLivingUpdate();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HASTREUS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HASTREUS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HASTREUS_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_HASTREUS;
    }
}
