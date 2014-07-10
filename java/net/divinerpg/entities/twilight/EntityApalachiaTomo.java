package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityPeacefullUntillAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityApalachiaTomo extends EntityPeacefullUntillAttacked {

    public EntityApalachiaTomo(World var1) {
        super(var1);
        this.setSize(2.0F, 2.0F);
        this.experienceValue = 40;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.apalachiaTomoHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.apalachiaTomoDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.apalachiaTomoSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.apalachiaTomoFollowRange);
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
        int var3 = this.rand.nextInt(2 + var2);
        int var4;

        for(var4 = 0; var4 < var3; ++var4) {
            this.dropItem(getDropItem(), 1);
            this.dropItem(ItemsFood.rawEmpoweredMeat, 2);
        }
        this.dropItem(getDropItem(), 1);
    }

    @Override
    protected Item getDropItem() {
        return TwilightItemsOther.apalachiaSoul;
    }
 
    @Override
	public String mobName() {
		return "Apalachia Tomo";
	}
}
