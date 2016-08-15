package net.divinerpg.entities.vanilla;

import java.util.List;

import net.divinerpg.entities.base.EntityPeacefulUntilAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityCyclops extends EntityPeacefulUntilAttacked {

	public EntityCyclops(World var1) {
		super(var1);
		this.setSize(1.5F, 3.9F);
		this.experienceValue = 40;
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.cyclopsHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.cyclopsDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.cyclopsSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.cyclopsFollowRange);
	}
	
	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.cyclops);
	}

	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.cyclopsHurt);
	}

	@Override
	protected String getDeathSound() {
		return Sounds.getSoundName(Sounds.cyclopsHurt);
	}

	@Override
	protected void dropFewItems(boolean var1, int loot) {
		dropItem(VanillaItemsOther.cyclopsEye, rand.nextInt(2 + loot));
		dropItem(Items.gold_ingot, rand.nextInt(2 + loot));
		if(rand.nextInt(40) == 0) dropItem(VanillaItemsOther.bloodgem, 1);
	}
	
	@Override
    public boolean attackEntityFrom(DamageSource source, float par2) {
	    boolean hurt = super.attackEntityFrom(source, par2);
	    if(hurt && source.getEntity() != null && source.getEntity() instanceof EntityPlayer) {
	        List<Entity> entities = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(20, 20, 20));
	        for(Entity e : entities) {
	            if(e instanceof EntityCyclops) ((EntityCyclops)e).makeAngryAt((EntityPlayer)source.getEntity());
	        }
	    }
	    return hurt;
	}
	
	@Override
	public boolean isValidLightLevel() {
	    int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);

        if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > this.rand.nextInt(32)) return false;
        else {
            int l = this.worldObj.getBlockLightValue(i, j, k);

            if (this.worldObj.isThundering()) {
                int i1 = this.worldObj.skylightSubtracted;
                this.worldObj.skylightSubtracted = 10;
                l = this.worldObj.getBlockLightValue(i, j, k);
                this.worldObj.skylightSubtracted = i1;
            }

            return l <= this.rand.nextInt(8);
        }
	}

	@Override
	public String mobName() {
		return "Cyclops";
	}
}
