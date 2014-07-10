package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityMadivel extends EntityDivineRPGMob {
	
    public EntityMadivel(World var1) {
        super(var1);
        addBasicAI();
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.madivelHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.madivelDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.madivelSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.madivelFollowRange);
    }

    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.madivel);
    }
 
    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.madivelHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.madivelHurt);
    }
 
    @Override
    protected Item getDropItem() {
        return TwilightItemsOther.edenSoul;
    }
 
    @Override
    protected void dropFewItems(boolean var1, int var2) {
        super.dropFewItems(var1, var2);
        this.dropItem(ItemsFood.rawEmpoweredMeat, 1);
    }

	@Override
	public String mobName() {
		return "Madivel";
	}
}