package net.divinerpg.entities.twilight;

import java.util.List;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.api.entity.EntityPeacefullUntillAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityEdenTomo extends EntityPeacefullUntillAttacked {
	
    public EntityEdenTomo(World var1) {
        super(var1);
        this.setSize(2.0F, 2.0F);
        this.experienceValue = 40;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.edenTomoHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.edenTomoDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.edenTomoSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.edenTomoFollowRange);
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
    protected void dropFewItems(boolean var1, int var2) {
        super.dropFewItems(var1, var2);
        this.dropItem(TwilightItemsOther.edenSoul, 1);
        this.dropItem(ItemsFood.rawEmpoweredMeat, 1);
    }

    @Override
	public String mobName() {
		return "Eden Tomo";
	}
}