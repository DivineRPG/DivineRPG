package net.divinerpg.entities.arcana;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityRazorback extends EntityDivineRPGMob {
	
    public EntityRazorback(World var1) {
        super(var1);
        addAttackingAI();
        this.height = 0.5F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.razorbackHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.razorbackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.razorbackSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.razorbackFollowRange);
    }

    @Override
    public String mobName() {
        return "Razorback";
    }

    @Override
    protected String getLivingSound() {
        return Sounds.razorback.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.razorbackHurt.getPrefixedName();
    }

    @Override
    protected void dropFewItems(boolean var1, int var2) {
        this.dropItem(ArcanaItems.collector, 1);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.razorbackHurt.getPrefixedName();
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }
}
