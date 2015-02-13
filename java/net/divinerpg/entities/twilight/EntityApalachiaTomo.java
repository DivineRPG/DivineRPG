package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityPeacefulUntilAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityApalachiaTomo extends EntityPeacefulUntilAttacked {

    public EntityApalachiaTomo(World var1) {
        super(var1);
        this.setSize(1.1F, 1.0F);
        this.experienceValue = 40;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.apalachiaTomoHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.apalachiaTomoDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.apalachiaTomoSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.apalachiaTomoFollowRange);
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
            this.dropItem(ItemsFood.enrichedMagicMeat, 2);
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
