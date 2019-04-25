package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Reyvor extends EntityDivineRPGBoss implements IRangedAttackMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/reyvor");

    public Reyvor(World worldIn) {
        super(worldIn);
        this.setSize(1F, 2.4f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        //EntityDivineArrow var2 = new EntityDivineArrow(this.world, 1.6F, 12.0F, 22);
        // this.playSound(soundIn, 1, 1);
        //this.world.spawnEntity(var2);
        //var2.shoot(posX, posY, posZ, 1, 1);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.REYVOR_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
        // TODO Auto-generated method stub

    }
}
