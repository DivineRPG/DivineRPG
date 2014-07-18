package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityKaros extends EntityDivineRPGBoss {

	private static int ability;
	private final int DEFAULT = 0;
	private final int CEILING = 1;
	private final int CANNONS = 2;
	private final int FLOOR = 3;

	private int abilityCoolDown;
	private int[][] cannonList = new int[36][3];
	private int[][] ceilingList = new int[47][3];
	private int targetY;

	private int rangedAttackCounter;
	private int deathTicks;

	public EntityKaros(World par1) {
		super(par1);
		addAttackingAI();
		ability = DEFAULT;
		if(!this.worldObj.isRemote){
			Util.sendMessageToAll("Dr. Karos: So you came to play a game?");
			Util.sendMessageToAll("Dr. Karos: Let the game begin!");
		}
		this.playSound(Sounds.karosIntro.getPrefixedName(), 1.0F, 1.0F);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.karosHealth);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.karosDamage);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.karosSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.karosFollowRange);
	}

	public EntityKaros(World par1, int par2, int par3, int par4) {
		this(par1);
		this.cannonList[0] = new int[]{par2 + 10, par3 + 2, par4 + 3};
		this.cannonList[1] = new int[]{par2 + 10, par3 + 2, par4 + 5};
		this.cannonList[2] = new int[]{par2 + 10, par3 + 2, par4 + 7};
		this.cannonList[3] = new int[]{par2 + 10, par3 + 2, par4 + 12};
		this.cannonList[4] = new int[]{par2 + 10, par3 + 2, par4 + 14};
		this.cannonList[5] = new int[]{par2 + 10, par3 + 2, par4 + 16};
		this.cannonList[6] = new int[]{par2 + 12, par3 + 2, par4 + 1};
		this.cannonList[7] = new int[]{par2 + 12, par3 + 2, par4 + 18};
		this.cannonList[8] = new int[]{par2 + 14, par3 + 2, par4 + 1};
		this.cannonList[9] = new int[]{par2 + 14, par3 + 2, par4 + 18};
		this.cannonList[10] = new int[]{par2 + 16, par3 + 2, par4 + 1};
		this.cannonList[11] = new int[]{par2 + 16, par3 + 2, par4 + 18};
		this.cannonList[12] = new int[]{par2 + 18, par3 + 2, par4 + 1};
		this.cannonList[13] = new int[]{par2 + 18, par3 + 2, par4 + 18};
		this.cannonList[14] = new int[]{par2 + 20, par3 + 2, par4 + 1};
		this.cannonList[15] = new int[]{par2 + 20, par3 + 2, par4 + 18};
		this.cannonList[16] = new int[]{par2 + 20, par3 + 2, par4 + 1};
		this.cannonList[17] = new int[]{par2 + 20, par3 + 2, par4 + 18};
		this.cannonList[18] = new int[]{par2 + 24, par3 + 2, par4 + 1};
		this.cannonList[19] = new int[]{par2 + 24, par3 + 2, par4 + 18};
		this.cannonList[20] = new int[]{par2 + 26, par3 + 2, par4 + 1};
		this.cannonList[21] = new int[]{par2 + 26, par3 + 2, par4 + 18};
		this.cannonList[22] = new int[]{par2 + 28, par3 + 2, par4 + 1};
		this.cannonList[23] = new int[]{par2 + 28, par3 + 2, par4 + 18};
		this.cannonList[24] = new int[]{par2 + 28, par3 + 3, par4 + 9};
		this.cannonList[25] = new int[]{par2 + 28, par3 + 3, par4 + 10};
		this.cannonList[26] = new int[]{par2 + 29, par3 + 2, par4 + 2};
		this.cannonList[27] = new int[]{par2 + 29, par3 + 2, par4 + 4};
		this.cannonList[28] = new int[]{par2 + 29, par3 + 2, par4 + 6};
		this.cannonList[29] = new int[]{par2 + 29, par3 + 2, par4 + 8};
		this.cannonList[30] = new int[]{par2 + 29, par3 + 2, par4 + 9};
		this.cannonList[31] = new int[]{par2 + 29, par3 + 2, par4 + 10};
		this.cannonList[32] = new int[]{par2 + 29, par3 + 2, par4 + 11};
		this.cannonList[33] = new int[]{par2 + 29, par3 + 2, par4 + 13};
		this.cannonList[34] = new int[]{par2 + 29, par3 + 2, par4 + 15};
		this.cannonList[35] = new int[]{par2 + 29, par3 + 2, par4 + 17};

		this.ceilingList[0] = new int[]{par2 + 13, par3 + 4, par4 + 4};
		this.ceilingList[1] = new int[]{par2 + 13, par3 + 4, par4 + 5};
		this.ceilingList[2] = new int[]{par2 + 13, par3 + 4, par4 + 6};
		this.ceilingList[3] = new int[]{par2 + 14, par3 + 4, par4 + 4};
		this.ceilingList[4] = new int[]{par2 + 14, par3 + 4, par4 + 5};
		this.ceilingList[5] = new int[]{par2 + 14, par3 + 4, par4 + 6};
		this.ceilingList[6] = new int[]{par2 + 15, par3 + 4, par4 + 4};
		this.ceilingList[7] = new int[]{par2 + 15, par3 + 4, par4 + 5};
		this.ceilingList[8] = new int[]{par2 + 15, par3 + 4, par4 + 6};
		this.ceilingList[9] = new int[]{par2 + 13, par3 + 4, par4 + 14};
		this.ceilingList[10] = new int[]{par2 + 13, par3 + 4, par4 + 15};
		this.ceilingList[11] = new int[]{par2 + 13, par3 + 4, par4 + 16};
		this.ceilingList[12] = new int[]{par2 + 14, par3 + 4, par4 + 14};
		this.ceilingList[13] = new int[]{par2 + 14, par3 + 4, par4 + 15};
		this.ceilingList[14] = new int[]{par2 + 14, par3 + 4, par4 + 16};
		this.ceilingList[15] = new int[]{par2 + 15, par3 + 4, par4 + 14};
		this.ceilingList[16] = new int[]{par2 + 15, par3 + 4, par4 + 15};
		this.ceilingList[17] = new int[]{par2 + 15, par3 + 4, par4 + 16};
		this.ceilingList[18] = new int[]{par2 + 18, par3 + 4, par4 + 9};
		this.ceilingList[19] = new int[]{par2 + 18, par3 + 4, par4 + 10};
		this.ceilingList[20] = new int[]{par2 + 18, par3 + 4, par4 + 11};
		this.ceilingList[21] = new int[]{par2 + 19, par3 + 4, par4 + 9};
		this.ceilingList[22] = new int[]{par2 + 19, par3 + 4, par4 + 10};
		this.ceilingList[23] = new int[]{par2 + 19, par3 + 4, par4 + 11};
		this.ceilingList[23] = new int[]{par2 + 20, par3 + 4, par4 + 9};
		this.ceilingList[24] = new int[]{par2 + 20, par3 + 4, par4 + 10};
		this.ceilingList[25] = new int[]{par2 + 20, par3 + 4, par4 + 11};
		this.ceilingList[26] = new int[]{par2 + 22, par3 + 4, par4 + 12};
		this.ceilingList[27] = new int[]{par2 + 22, par3 + 4, par4 + 13};
		this.ceilingList[28] = new int[]{par2 + 22, par3 + 4, par4 + 14};
		this.ceilingList[29] = new int[]{par2 + 23, par3 + 4, par4 + 12};
		this.ceilingList[30] = new int[]{par2 + 23, par3 + 4, par4 + 13};
		this.ceilingList[31] = new int[]{par2 + 23, par3 + 4, par4 + 14};
		this.ceilingList[32] = new int[]{par2 + 24, par3 + 4, par4 + 12};
		this.ceilingList[33] = new int[]{par2 + 24, par3 + 4, par4 + 13};
		this.ceilingList[34] = new int[]{par2 + 24, par3 + 4, par4 + 14};
		this.ceilingList[35] = new int[]{par2 + 23, par3 + 4, par4 + 4};
		this.ceilingList[36] = new int[]{par2 + 23, par3 + 4, par4 + 5};
		this.ceilingList[37] = new int[]{par2 + 23, par3 + 4, par4 + 6};
		this.ceilingList[38] = new int[]{par2 + 24, par3 + 4, par4 + 4};
		this.ceilingList[39] = new int[]{par2 + 24, par3 + 4, par4 + 5};
		this.ceilingList[40] = new int[]{par2 + 24, par3 + 4, par4 + 6};
		this.ceilingList[41] = new int[]{par2 + 25, par3 + 4, par4 + 4};
		this.ceilingList[42] = new int[]{par2 + 25, par3 + 4, par4 + 5};
		this.ceilingList[43] = new int[]{par2 + 25, par3 + 4, par4 + 6};
		this.ceilingList[44] = new int[]{par2 + 24, par3 + 4, par4 + 12};
		this.ceilingList[45] = new int[]{par2 + 24, par3 + 4, par4 + 13};
		this.ceilingList[46] = new int[]{par2 + 24, par3 + 4, par4 + 14};
		this.targetY = par3;
	}

	@Override
	protected void updateAITasks() {
		this.manageAbilities();
		super.updateAITasks();
	}

	public void manageAbilities() {
		if (ability == DEFAULT && this.abilityCoolDown == 0 ) {
			this.abilityCoolDown = 200;
			switch(this.rand.nextInt(3)) {
			case 0:
				ability = CEILING;
				this.rangedAttackCounter = 200;
				this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0);
				this.playSound(Sounds.ceilingExplosions.getPrefixedName(), 1.0F, 1.0F);
				if(!this.worldObj.isRemote)
				Util.sendMessageToAll("Dr. Karos: I heard you like explosions! Hahaha");
				break;
			case 1:
				ability = CANNONS;
				this.rangedAttackCounter = 200;
				break;
			case 2:
				ability = FLOOR;
				this.rangedAttackCounter = 0;
				break;
			default: break;
			}
		}
		else if (ability == DEFAULT && this.abilityCoolDown > 0) {
			this.abilityCoolDown--;
		}
		else if (ability != 0 && this.abilityCoolDown == 0) {
			this.abilityCoolDown = 10;
		}

	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		int var2;
		if (this.rangedAttackCounter == 0) {
			ability = DEFAULT;
		}
		else if(ability == CEILING) {
			var2 = this.rand.nextInt(46);
			if ((this.rangedAttackCounter % 4) == 0) {
				VetheaBlocks.helioticBeam.dispense(this.worldObj, ceilingList[var2][0], ceilingList[var2][1], ceilingList[var2][2]);
			}
			this.rangedAttackCounter--;
		}
		else if(ability == CANNONS) {
			var2 = this.rand.nextInt(36);
			if ((this.rangedAttackCounter % 4) == 0) {
				VetheaBlocks.karosCannon.dispense(this.worldObj, cannonList[var2][0], cannonList[var2][1], cannonList[var2][2]);
			}
			this.rangedAttackCounter--;
		}
		else if(ability == FLOOR) {
			for (int i = 0; i < 10; i++) {
				double var4 = 0;
				while (var4 < 2 * Math.PI) {
					int var1 = (int) Math.round(Math.sin(var4)*i);
					int var3 = (int) Math.round(Math.cos(var4)*i);
					if (this.worldObj.getBlock((int)this.posX + var1, this.targetY, (int)this.posZ + var3) == VetheaBlocks.karosHeatTileGreen) {
						this.worldObj.setBlock((int)this.posX + var1, this.targetY, (int)this.posZ + var3, VetheaBlocks.karosHeatTileRed);
					}
					var4 += Math.PI / 8.0D;
				}
			}
			ability = DEFAULT;
		}
	}

	@Override
	protected float getSoundVolume() {
		return 0.7F;
	}

	@Override
	protected String getLivingSound() {
		switch(this.rand.nextInt(4)) {
		case 0:
			if(!this.worldObj.isRemote)
			Util.sendMessageToAll("Dr. Karos: Hahahaha");
			return Sounds.karosLaugh.getPrefixedName();
		case 1:
			if(!this.worldObj.isRemote)
			Util.sendMessageToAll("Dr. Karos: I'm here for you to meet your doom!");
			return Sounds.meetDoom.getPrefixedName();
		case 2:
			if(!this.worldObj.isRemote)
			Util.sendMessageToAll("Dr. Karos: C'mon c'mon get me, try your best!");
			return Sounds.tryYourBest.getPrefixedName();
		default:
			if(!this.worldObj.isRemote){
			Util.sendMessageToAll("Dr. Karos: You can't kill me! You weak excuse for a");
			Util.sendMessageToAll("human.", true);
			}
			return Sounds.youCantKillMe.getPrefixedName();
		}
	}

	@Override
	protected String getHurtSound() {
		return null;
	}

	@Override
	protected String getDeathSound() {
		return getHurtSound();
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		this.dropItem(VetheaItems.rockChunks, par2);
		this.dropItem(VetheaItems.karosLump, 20);
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1, float par2) {
		if (par1.isExplosion())
			return false;
		return super.attackEntityFrom(par1, par2);
	}

	@Override
	protected void onDeathUpdate() {
		++this.deathTicks;

		if (this.deathTicks >= 180 && this.deathTicks <= 200) {
			float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.worldObj.spawnParticle("hugeexplosion", this.posX + var1, this.posY + 2.0D + var2, this.posZ + var3, 0.0D, 0.0D, 0.0D);
		}

		int var4, var5;

		if (!this.worldObj.isRemote) {
			if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
				var4 = 1000;

				while (var4 > 0) {
					var5 = EntityXPOrb.getXPSplit(var4);
					var4 -= var5;
					this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
				}
			}

			if (this.deathTicks == 1) {
				this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
			}
		}

		this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
		this.renderYawOffset = this.rotationYaw += 20.0F;

		if (this.deathTicks == 200 && !this.worldObj.isRemote) {
			var4 = 2000;

			while (var4 > 0) {
				var5 = EntityXPOrb.getXPSplit(var4);
				var4 -= var5;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
			}
			this.setDead();
		}
	}

	@Override
	public String mobName() {
		return "Dr Karos";
	}

	@Override
	public String name() {
		return "Dr Karos";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}