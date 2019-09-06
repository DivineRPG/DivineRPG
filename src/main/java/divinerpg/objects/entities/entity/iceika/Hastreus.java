package divinerpg.objects.entities.entity.iceika;

import java.util.List;

import divinerpg.Reference;
import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
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

    public Hastreus(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 1.9F);
    }

    @Override
    public float getEyeHeight() {
        return 1.3F;
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
        return ModSounds.HASTREUS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.HASTREUS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.HASTREUS_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_HASTREUS;
    }
}
