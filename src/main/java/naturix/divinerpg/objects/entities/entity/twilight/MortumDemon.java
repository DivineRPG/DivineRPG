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

public class MortumDemon extends EntityDivineRPGMob {
    
    public MortumDemon(World var1) {
        super(var1);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.mortumDemonHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.mortumDemonDamage);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.mortumDemonSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.mortumDemonFollowRange);
    }
    
    @Override
    public int getTotalArmorValue() {
        return 10;
    }
 
    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : ModSounds.DEMON_OF_DARKNESS;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WOLF_GROWL;
    }
 
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_GROWL;
    }
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/demon_of_darkness");
    
    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

}