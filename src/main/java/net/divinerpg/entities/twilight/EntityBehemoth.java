package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class EntityBehemoth extends EntityDivineRPGMob {
	
    public int eatX;
    public int eatY;
    public int eatZ;
    private boolean shouldEat = false;
    private int ability;
    float moveSpeed = 1;

    public EntityBehemoth(World var1) {
        super(var1);
        addAttackingAI();
        this.setSize(1.2f, 1);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.behemothHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.behemothDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.behemothSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.behemothFollowRange);
    }

    @Override
    protected void updateAITasks() {
    	if (this.getHealth() < this.getMaxHealth() * 0.5 && !this.shouldEat) {
    		for (int i = (int)this.posX - 16; i < (int)this.posX + 16; i++) {
    			for (int j = (int)this.posZ - 16; j < (int)this.posZ + 16; j++) {
    				for(int n = (int)this.posY - 2; n < (int)this.posY + 2; n++) {
        				boolean var1 = this.worldObj.getBlock(i, (int)this.posY, j).getMaterial() == Material.wood;
        				if (var1) {
        					this.shouldEat = true;
        					this.eatX = i;
        					this.eatY = (int)this.posY;
        					this.eatZ = j;
        				}
    				}
        		}
    		}
    	}
    	if(this.shouldEat && this.getHealth() >= this.getMaxHealth() * 0.5) this.shouldEat = false;
    	super.updateAITasks();
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        
        if(this.shouldEat && this.worldObj.getBlock(this.eatX, this.eatY, this.eatZ).getMaterial() != Material.wood) this.shouldEat = false;

        if(this.shouldEat && this.ability == 0) {
            if (this.getDistance(eatX, eatY, eatZ) < 2) {
                this.heal(70/8);
                this.worldObj.setBlock(eatX, eatY, eatZ, Blocks.air);
                this.shouldEat = false;
                this.ability = 5;
            } else {
                this.getNavigator().tryMoveToXYZ(eatX, eatY, eatZ, moveSpeed);
                this.getLookHelper().setLookPosition(eatX, eatY, eatZ, 15F, 15F);
                this.moveEntityWithHeading(0F, moveSpeed / 4);
            }
        }
        else if (this.shouldEat && this.ability > 0) {
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
        this.dropItem(TwilightItemsOther.wildwoodSoul, this.rand.nextInt(3 + par2));
        this.dropItem(ItemsFood.magicMeat, 1);
    }

    @Override
    public boolean isValidLightLevel() {
        return true;
    }

	@Override
	public String mobName() {
		return "ModelBehemoth";
	}
}