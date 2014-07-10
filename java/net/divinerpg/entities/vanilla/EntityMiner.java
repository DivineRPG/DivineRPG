package net.divinerpg.entities.vanilla;

import java.util.Calendar;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMiner extends EntityDivineRPGMob {
	
    private static final ItemStack defaultHeldItem = new ItemStack(Items.diamond_pickaxe);

    public EntityMiner(World var1) {
        super(var1);
        addAttackingAI();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.minerHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.minerDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.minerSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.minerFollowRange);
    }

	@Override
    public int getTotalArmorValue() {
        return 10;
    }

	@Override
    public void onLivingUpdate() {
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote) {
            float var1 = this.getBrightness(1.0F);

            if (var1 > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
                this.setFire(8);
            }
        }
        super.onLivingUpdate();
    }

	@Override
    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }
    
	@Override
    protected void addRandomArmor() {
		super.addRandomArmor();
		this.setCurrentItemOrArmor(0, defaultHeldItem);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData) {
		par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);

		if (this.getRNG().nextInt(5) > 0) {
			this.setCurrentItemOrArmor(0, defaultHeldItem);
		}
		return par1EntityLivingData;
	}

	@Override
    protected Item getDropItem() {
        return Items.rotten_flesh;
    }

	@Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

	@Override
    protected void dropRareDrop(int var1) {
        switch (this.rand.nextInt(5)) {
            case 0:
                this.dropItem(Items.diamond_pickaxe, 1);
                break;

            case 1:
                this.dropItem(Items.gold_ingot, 1);
                break;

            case 2:
                this.dropItem(Items.iron_ingot, 1);
                break;

            case 3:
                this.dropItem(Items.diamond, 1);
                break;

            case 4:
                this.dropItem(Item.getItemFromBlock(Blocks.torch), 32);
        }
    }

	@Override
	public String mobName() {
		return "Undead Miner";
	}
}