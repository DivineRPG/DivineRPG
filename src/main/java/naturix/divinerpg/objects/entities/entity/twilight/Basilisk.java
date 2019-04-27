package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Basilisk extends EntityDivineRPGMob {
    
    public Basilisk(World var1) {
        super(var1);
        //FIXME - needs to avoid water
//        this.getNavigator().setAvoidsWater(true);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.basliskHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.basliskDamage);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.basliskSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.basliskFollowRange);
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }
 
    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : ModSounds.MUCKY;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WOLF_GROWL;
    }
 
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_GROWL;
    }
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/basalisk");
    
    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}