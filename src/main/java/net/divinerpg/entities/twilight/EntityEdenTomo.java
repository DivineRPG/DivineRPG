package net.divinerpg.entities.twilight;

import java.util.List;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.entities.base.EntityPeacefulUntilAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityEdenTomo extends EntityPeacefulUntilAttacked {
	
    public EntityEdenTomo(World var1) {
        super(var1);
        this.setSize(1.1F, 1.0F);
        this.experienceValue = 40;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.edenTomoHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.edenTomoDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.edenTomoSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.edenTomoFollowRange);
    }
 
    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.croak);
    }
 
    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.growlHurt);
    }
 
    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.growlHurt);
    }
 
    @Override
    protected void dropFewItems(boolean beenHit, int lootingLevel) {
        super.dropFewItems(beenHit, lootingLevel);
        if(this.rand.nextInt(2) == 0) this.dropItem(TwilightItemsOther.edenSoul, 1+lootingLevel);
        if(this.isBurning()) this.dropItem(ItemsFood.empoweredMeat, 1);
        else this.dropItem(ItemsFood.rawEmpoweredMeat, 1);
        if(this.rand.nextInt(3) == 0) this.dropItem(Items.gold_ingot, this.rand.nextInt(3)+1);
    }

    @Override
	public String mobName() {
		return "Eden Tomo";
	}
}