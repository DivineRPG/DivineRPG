package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineArrow;
import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityWildfire extends EntityDivineRPGMob implements IRangedAttackMob {
	
    private static final ItemStack defaultHeldItem = new ItemStack(VanillaItemsWeapons.infernoBow, 1);

    public EntityWildfire(World par1World) {
        super(par1World);
        float moveSpeed = 0.25F;
        this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.tasks.addTask(7, new EntityAIArrowAttack(this, 0.25F, 15, 10.0F));        
        this.isImmuneToFire = true;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.wildFireHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.wildFireDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.wildFireSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.wildFireFollowRange);
    }
    
    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.wildFire);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.wildFireHurt);
    }

    @Override
    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }

    @Override
    protected Item getDropItem() {
        return VanillaItemsOther.moltenShards;
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
    	this.dropItem(VanillaItemsOther.moltenShards, 4);
    }

    @Override
    protected void dropRareDrop(int var1) {
        if (this.rand.nextInt(5) == 0)
        {
            this.dropItem(VanillaItemsOther.hellstoneIngot, 1);
        } else {
        	this.dropItem(VanillaItemsOther.netheriteIngot, 40);
        }
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase var1, float f) {
        EntityDivineArrow var2 = new EntityDivineArrow(this.worldObj, this, var1, 1.6F, 12.0F, 5, "infernoArrow");
        var2.setFire(100);

        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(var2);
    }

	@Override
	public String mobName() {
		return "Wildfire";
	}
}