package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsCrops;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMegalith extends EntityDivineRPGMob {
    
    public EntityMegalith(World var1) {
        super(var1);
        this.setSize(1F, 3.2F);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.megalithHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.megalithDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.megalithSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.megalithFollowRange);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1);
    }
    
    @Override
    public boolean attackEntityAsMob(Entity e) {
        boolean attack = super.attackEntityAsMob(e);
        if(attack) {
            if(e instanceof EntityLivingBase)((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 2));
            e.addVelocity(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * 1.5f, 0.1D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * 1.5f);
        }
        return attack;
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.megalith);
    }
 
    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.megalithHurt);
    }
 
    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.megalithHurt);
    }
    
    @Override
    public void dropFewItems(boolean beenHit, int lootingLevel) {
        dropItem(TwilightItemsOther.skythernSoul, this.rand.nextInt(2 + lootingLevel));
        if(this.rand.nextBoolean())dropItem(TwilightItemsCrops.skyPlantSeeds, this.rand.nextInt(3));
    }

    @Override
    public String mobName() {
        return "Megalith";
    }
}