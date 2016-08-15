package net.divinerpg.entities.vanilla;

import java.util.List;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.entities.base.EntityPeacefulUntilAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityKingCrab extends EntityPeacefulUntilAttacked {

    public EntityKingCrab(World var1) {
        super(var1);
        this.setSize(1.55F, 1.25F);
        this.experienceValue = 40;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.kingCrabHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.kingCrabDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.kingCrabSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.kingCrabFollowRange);
    }

	@Override
    protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.crab);
	}

	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.crabHurt);
	}

	@Override
	protected String getDeathSound() {
		return Sounds.getSoundName(Sounds.crabHurt);
	}

	@Override
    protected void dropFewItems(boolean var1, int var2) {
	    this.dropItem(VanillaItemsOther.crabClaw, this.rand.nextInt(2 + var2));
	    this.dropItem(VanillaItemsOther.aquaticPellets, this.rand.nextInt(2 + var2)*3);
    }

    @Override
    protected Item getDropItem() {
        return VanillaItemsOther.crabClaw;
    }

	@Override
	public String mobName() {
		return "King Crab";
	}
}