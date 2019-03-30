package naturix.divinerpg.objects.entities.entity.iceika;

import java.util.List;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.registry.DRPGSoundHandler;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Hastreus extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/iceika/hastreus");

    public Hastreus(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 1.9F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
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
                ((EntityPlayer) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 12, 18, true, false));
                // DivineRPG.logger.info("Hastreus has slowed player at " +
                // entity.getPosition());
            }
        }

        super.onLivingUpdate();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DRPGSoundHandler.HASTREUS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return DRPGSoundHandler.HASTREUS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DRPGSoundHandler.HASTREUS_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    /**
     * @Override public boolean getCanSpawnHere() { return
     *           world.provider.getDimension() ==
     *           ModDimensions.iceikaDimension.getId() && super.getCanSpawnHere(); }
     */
}
