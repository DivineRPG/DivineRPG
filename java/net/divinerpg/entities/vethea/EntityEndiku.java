package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class EntityEndiku extends EntityDivineRPGMob {
	
    private static final double spawnLayer = 3;
    public int eatX;
    public int eatY;
    public int eatZ;
    public Block[] edible = new Block[]{Blocks.log, VetheaBlocks.firewood, VetheaBlocks.mintwood, VetheaBlocks.hyrewood, VetheaBlocks.dreamWoodLog};
    private boolean isEaten;
    private int ability;
    float moveSpeed;

    public EntityEndiku(World var1) {
        super(var1);
        addAttackingAI();
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 64.0D * spawnLayer  && this.posY > 64.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.endikuHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.endikuDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.endikuSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.endikuFollowRange);
    }

    /*protected void updateAITasks() {
    	System.out.println(this.health);
    	if (this.health < this.getMaxHealth() * 0.2 && !this.isEaten) {
    		for (int i = (int)this.posX - 2; i < (int)this.posX + 16; i++) {
    			for (int j = (int)this.posZ - 2; j < (int)this.posZ + 16; j++) {
    				for(int n = (int)this.posY - 2; n < (int)this.posY + 2; n++) {
        				boolean var1 = this.worldObj.getBlockMaterial(i,(int)this.posY, j) == Material.wood;
        		    	System.out.println(i + " " + n + " " + j);
        		    	System.out.println(var1);
        				if (var1) {
        			    	System.out.println("Moving");
        					this.isEaten = true;
        					this.eatX = i;
        					this.eatY = (int)this.posY;
        					this.eatZ = j;
        				}
    				}
        		}
    		}
    	}
    	super.updateAITasks();
    }*/
    //TODO: Look into this.

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if(this.isEaten && this.ability == 0) {
            if (this.getDistance(eatX, eatY, eatZ) < 2) {
                this.heal(70/8);
                this.worldObj.setBlock(eatX, eatY, eatZ, null);
                this.isEaten = false;
                this.ability = 5;
            } else {
                this.getMoveHelper().setMoveTo(eatX, eatY, eatZ, moveSpeed);
                this.getLookHelper().setLookPosition(eatX, eatY, eatZ, 15F, 15F);
                this.moveEntityWithHeading(0F, moveSpeed / 4);
            }
        }
        else if (this.isEaten && this.ability > 0) {
            this.ability--;
        }
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.endiku.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.endikuHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.polishedPearls, 1);
    }

	@Override
	public String mobName() {
		return "Endiku";
	}
}