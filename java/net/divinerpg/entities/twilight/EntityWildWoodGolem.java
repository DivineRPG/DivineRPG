package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
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
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityWildWoodGolem extends EntityDivineRPGMob {
	
    public EntityWildWoodGolem(World var1) {
        super(var1);
        this.setSize(1.5F, 3.0F);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.wildWoodGolemHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.wildWoodGolemDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.wildWoodGolemSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.wildWoodGolemFollowRange);
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }
  
    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.growlHurt);
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
    protected Item getDropItem() {
        return TwilightItemsOther.wildwoodSoul;
    }

	@Override
	public String mobName() {
		return "Wild Wood Golem";
	}
}
