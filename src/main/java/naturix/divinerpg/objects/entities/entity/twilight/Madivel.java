package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Madivel extends EntityDivineRPGMob {
    
    public Madivel(World var1) {
        super(var1);
        addBasicAI();
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.madivelHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.madivelDamage);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.madivelSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.madivelFollowRange);
        }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : ModSounds.MADIVEL;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.MADIVEL_HURT;
    }
 
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.MADIVEL_HURT;
    }
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/madivel");
    
    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
 

}