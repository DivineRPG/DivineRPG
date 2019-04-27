package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class SoulStealer extends EntityDivineRPGMob {
    
    public SoulStealer(World var1) {
        super(var1);
        addAttackingAI();
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.soulStealerHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.soulStealerDamage);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.soulStealerSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.soulStealerFollowRange);
    }

    @Override
    public boolean attackEntityAsMob(Entity var1) {
        if(super.attackEntityAsMob(var1)) {
            if(var1 instanceof EntityLiving) {
                ((EntityLiving)var1).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 12 * 20, 0, false, false));
                ((EntityLiving)var1).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 12 * 20, 0, false, false));
            }
            return true;
        } else {
            return false;
        }
    }
 
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.INSECT;
    }
public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/soul_stealer");
    
    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

}