package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityAridWarrior extends EntityDivineRPGMob {
	
    private static final ItemStack defaultHeldItem = new ItemStack(VanillaItemsWeapons.shadowBow, 1);

    public EntityAridWarrior(World par1World) {
        super(par1World);
        addAttackingAI();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.aridWarriorHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.aridWarriorDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.aridWarriorSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.aridWarriorFollowRange);
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.worldObj.isRemote) {
            this.entityToAttack = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16);
            if(this.entityToAttack != null && this.ticksExisted%18==0) this.attackEntityWithRangedAttack((EntityLivingBase)this.entityToAttack);
        }
    }

    protected String getLivingSound() {
    	 return Sounds.getSoundName(Sounds.aridWarrior);
    }

    protected String getHurtSound() {
    	 return Sounds.getSoundName(Sounds.aridWarriorHurt);
    }

    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.aridWarriorHurt);
    }

    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(Item.getItemFromBlock(Blocks.sandstone), this.rand.nextInt(10));
        this.entityDropItem(new ItemStack(Blocks.wool, this.rand.nextInt(10), 14), 0.0F);
    }

    public void attackEntityWithRangedAttack(EntityLivingBase e) {
        EntityArrow var2 = new EntityArrow(this.worldObj, this, e, 1.6F, 4.5F);
        var2.setDamage(1.5);

        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(var2);
    }

	protected Item getDropItem() {
        return Item.getItemFromBlock(Blocks.sandstone);
    }

	@Override
	public String mobName() {
		return "Arid Warrior";
	}
}