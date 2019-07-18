package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Seimer extends EntityDivineRPGTameable {
	

    public Seimer(World par1World, EntityPlayer p) {
        this(par1World);
        setTamed(true);
        setOwnerId(p.getUniqueID());
    }
    
    public Seimer(World par1World) {
        super(par1World);
        this.setSize(1.2f, 1);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.seimerHealth);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.seimerSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.seimerFollowRange);
    }

    @Override
    public boolean processInteract(EntityPlayer par1EntityPlayer, EnumHand hand) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

        if (this.isTamed()) {
            if (var2 != null) {
                if (var2.getItem() instanceof ItemFood) {
                    ItemFood var3 = (ItemFood)var2.getItem();

                    if (var3.isWolfsFavoriteMeat()) {
                    	//FIXME - data watcher
//                    		&& this.dataWatcher.getWatchableObjectInt(18) < 20) {
                        if (!par1EntityPlayer.capabilities.isCreativeMode) {
                            var2.shrink(1);
                        }

                        this.heal(var3.getHealAmount(var2));
                        return true;
                    }
                }
            }
        } else {
            this.setTamed(true);
            this.setOwnerId(par1EntityPlayer.getUniqueID());
            this.playTameEffect(true);
        }

        return super.processInteract(par1EntityPlayer, hand);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.getOwner() != null && this.getOwner() instanceof EntityPlayer) {
            IArcana arcana = this.getOwner().getCapability(ArcanaProvider.ARCANA_CAP, null);
        	arcana.consume(20);
        }
    }
    
    @Override
    public boolean attackEntityAsMob(Entity e) {
    	return e.attackEntityFrom(DamageSource.causeMobDamage(this), 6);
    }


	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}
}