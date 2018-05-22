package naturix.divinerpg.entities;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public abstract class ECustomArrow extends EntityArrow {

	private double damage;
	private Item pickedUp;
	
    public ECustomArrow(World par1World, double dam, Item pick) {
		super(par1World);
		damage = dam;
		pickedUp = pick;
		setDamage(damage);
	}
    
    public ECustomArrow(World par1World, double par2, double par4, double par6, double dam, Item pick) {
        super(par1World, par2, par4, par6);
        damage = dam;
		pickedUp = pick;
		setDamage(damage);
    }
    
    public ECustomArrow(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5, double dam, Item pick)  {
        super(par1World, par2EntityLivingBase);
        damage = dam;
		pickedUp = pick;
    }

    public ECustomArrow(World par1World, EntityLivingBase par2EntityLivingBase, float par3, double dam, Item pick) {
        super(par1World);
        damage = dam;
		pickedUp = pick;
		setDamage(damage);
    }
    
    @Override
    public double getDamage() {
    	return damage;
    }
    
    /*@Override
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
    	int ticks = 15;
        if (!this.worldObj.isRemote && this.arrowShake <= 0 && ticks >= 0) {
            boolean flag = this.canBePickedUp == 1 || this.canBePickedUp == 2 && par1EntityPlayer.capabilities.isCreativeMode;
            if (this.canBePickedUp == 1 && !par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(pickedUp, 1))) {
                flag = false;
            }
            if (flag) {
                this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                par1EntityPlayer.onItemPickup(this, 1);
                this.setDead();
            }
        }
        ticks--;
    }*/
}