
package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityApalachiaGolem extends EntityDivineRPGMob {
	
    public EntityApalachiaGolem(World var1) {
        super(var1);
        addAttackingAI();
        this.setSize(1.5F, 3.0F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.apalachiaGolemHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.apalachiaGolemDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.apalachiaGolemSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.apalachiaGolemFollowRange);
    }
 
    @Override
    public int getTotalArmorValue() {
        return 10;
    }
 
    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.growl);
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
        return TwilightItemsOther.apalachiaSoul;
    }
 
    @Override
    protected void dropFewItems(boolean var1, int var2)  {
        this.dropItem(ItemsFood.rawEmpoweredMeat, 1);
    }

	@Override
	public String mobName() {
		return "Apalachia Golem";
	}
}
