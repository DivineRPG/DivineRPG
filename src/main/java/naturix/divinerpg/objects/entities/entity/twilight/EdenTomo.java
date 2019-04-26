package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EdenTomo extends EntityPeacefulUntilAttacked {
    
    public EdenTomo(World var1) {
        super(var1);
        this.setSize(1.1F, 1.0F);
        this.experienceValue = 40;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.edenTomoHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.edenTomoDamage);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.edenTomoSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.edenTomoFollowRange);
    }
 
    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : ModSounds.CROAK;
    }
    //FIXME - Add Tomo sounds
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WOLF_GROWL;
    }
 
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
    }
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/eden_tomo");
    
    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

}