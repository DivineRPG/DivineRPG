package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class GolemOfRejuv extends EntityDivineRPGTameable {

	private int healTimer;

	public GolemOfRejuv(World par1World) {
		super(par1World);
		this.setSize(1F, 2.2F);
		this.healTimer = 0;
	}
	
	public GolemOfRejuv(World par1World, EntityPlayer p) {
		this(par1World);
		this.setOwnerId(p.getUniqueID());
		setTamed(true);
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.golemRejuvHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.golemRejuvSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.golemRejuvFollowRange);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSounds.GOLEM;
	}

	@Override
	public boolean processInteract(EntityPlayer par1EntityPlayer, EnumHand hand) {
		ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

		if (this.isTamed()) {
			if (var2 != null) {
				if (var2.getItem() instanceof ItemFood) {
					ItemFood var3 = (ItemFood)var2.getItem();

					if (var3.isWolfsFavoriteMeat()) {
						//FIXME - data watcher stuff
//							&& this.dataWatcher.getWatchableObjectInt(18) < 60) {
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
		if (this.getOwner() != null) {
			if (this.healTimer == 16) {
				this.getOwner().heal(1);
				this.healTimer = 0;
			} else {
				this.healTimer++;
			}
		}
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}

}