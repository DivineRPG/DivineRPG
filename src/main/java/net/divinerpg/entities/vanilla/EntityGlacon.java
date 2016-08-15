package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.ItemsFood;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityGlacon extends EntityDivineRPGMob {
	
    public EntityGlacon(World var1) {
        super(var1);
        addAttackingAI();
        this.setSize(0.8F, 1.4F);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.glaconHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.glaconDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.glaconSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.glaconFollowRange);
    }

    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.glacide);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.glacideHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.glacideHurt);
    }

    @Override
    protected Item getDropItem() {
        return IceikaItems.iceShards;
    }

    @Override
    protected void dropFewItems(boolean var1, int var2) {
		this.dropItem(ItemsFood.whiteMushroom, this.rand.nextInt(2 + var2));
		this.dropItem(IceikaItems.iceShards, 3 + this.rand.nextInt(3 + var2));
    }

	@Override
	public String mobName() {
		return "Glacon";
	}
}