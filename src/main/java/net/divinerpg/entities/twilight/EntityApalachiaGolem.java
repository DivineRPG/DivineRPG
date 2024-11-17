
package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsCrops;
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
        this.setSize(1F, 2.8F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.apalachiaGolemHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.apalachiaGolemDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.apalachiaGolemSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.apalachiaGolemFollowRange);
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
        this.dropItem(ItemsFood.enrichedMagicMeat, 1);
        this.dropItem(TwilightItemsOther.apalachiaSoul, this.rand.nextInt(3)+1);
        int i = rand.nextInt(4);
        if(i == 0) this.dropItem(TwilightItemsCrops.pinkGlowboneSeeds, rand.nextInt(3)+1);
        else if(i == 1) this.dropItem(TwilightItemsCrops.purpleGlowboneSeeds, rand.nextInt(3)+1);
    }

	@Override
	public String mobName() {
		return "Apalachia Golem";
	}
}
