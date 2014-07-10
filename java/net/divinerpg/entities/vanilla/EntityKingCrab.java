package net.divinerpg.entities.vanilla;

import java.util.List;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.api.entity.EntityPeacefullUntillAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityKingCrab extends EntityPeacefullUntillAttacked {

    public EntityKingCrab(World var1) {
        super(var1);
        this.setSize(2.0F, 1.5F);
        this.experienceValue = 40;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.kingCrabHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.kingCrabDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.kingCrabSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.kingCrabFollowRange);
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
        int var3 = this.rand.nextInt(2 + var2);
        int var4;

        for(var4 = 0; var4 < var3; ++var4)
            this.dropItem(VanillaItemsOther.crabClaw, 1);

        for(var4 = 0; var4 < var3; ++var4) 
            this.dropItem(VanillaItemsOther.aquaticPellets, 3);
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