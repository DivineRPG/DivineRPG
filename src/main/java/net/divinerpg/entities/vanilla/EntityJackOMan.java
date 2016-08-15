package net.divinerpg.entities.vanilla;

import net.divinerpg.DivineRPG;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.entities.base.EntityDivineRPGVillager;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.MessageLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VanillaItemsArmor;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityJackOMan extends EntityDivineRPGVillager {
	
	private static final String[] MESSAGE = {"message.jackoman.boo", "message.jackoman.lost", "message.jackoman.hurah", "message.jackoman.seen"};
    
    public EntityJackOMan(World var1) {
		super(var1);
	}

	private static final ItemStack defaultHeldItem = new ItemStack(VanillaItemsWeapons.scythe, 1);

	@Override
	public ItemStack getHeldItem() {
		return defaultHeldItem;
	}

    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.jackOMan);
    }
 
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.jackOMan);
    }
 
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.jackOMan);
    }

	@Override
	public void extraInteract(EntityPlayer p) {
        p.addChatMessage(Util.getChatComponent("Jack'O Man: " + MessageLocalizer.normal(MESSAGE[rand.nextInt(4)])));
	}
	
	@Override
	public boolean interact(EntityPlayer var1) {
		if(!this.worldObj.isRemote) {
			extraInteract(var1);
			var1.openGui(DivineRPG.instance, guiID(), this.worldObj, getEntityId(), 0, 0);
			var1.triggerAchievement(DivineRPGAchievements.halloweenSpirit);
			return true;
		} else {
			return super.interact(var1);
		}
	}

	@Override
	public int guiID() {
		return GuiHandler.jackOMan;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(Items.bone, 60), new ItemStack(Items.spider_eye, 60), new ItemStack(VanillaItemsArmor.skelemanHelmet, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(Items.bone, 60), new ItemStack(Items.spider_eye, 60), new ItemStack(VanillaItemsArmor.skelemanBody, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(Items.bone, 60), new ItemStack(Items.spider_eye, 60), new ItemStack(VanillaItemsArmor.skelemanLegs, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(Items.bone, 40), new ItemStack(Items.spider_eye, 60), new ItemStack(VanillaItemsArmor.skelemanBoots, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(Blocks.pumpkin, 50), new ItemStack(Items.ender_eye, 10), new ItemStack(VanillaItemsArmor.jackOManHelmet)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.pumpkin, 50), new ItemStack(Items.ender_eye, 10), new ItemStack(VanillaItemsArmor.jackOManBody)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.pumpkin, 50), new ItemStack(Items.ender_eye, 10), new ItemStack(VanillaItemsArmor.jackOManLegs)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.pumpkin, 50), new ItemStack(Items.ender_eye, 10), new ItemStack(VanillaItemsArmor.jackOManBoots)));
        list.add(new MerchantRecipe(new ItemStack(Items.skull, 3, 1), new ItemStack(VanillaItemsArmor.witherReaperHelmet)));
        list.add(new MerchantRecipe(new ItemStack(Items.skull, 5, 1), new ItemStack(VanillaItemsArmor.witherReaperBody)));
        list.add(new MerchantRecipe(new ItemStack(Items.skull, 4, 1), new ItemStack(VanillaItemsArmor.witherReaperLegs)));
        list.add(new MerchantRecipe(new ItemStack(Items.skull, 2, 1), new ItemStack(VanillaItemsArmor.witherReaperBoots)));
        list.add(new MerchantRecipe(new ItemStack(Items.skull, 6, 1), new ItemStack(Items.ender_eye, 60), new ItemStack(VanillaItemsWeapons.scythe)));
	}
	
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
		return "Jack 'O' Man";
	}
	
	@Override
	public boolean canDespawn() {
		return true;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return this.isValidLightLevel() && super.getCanSpawnHere();
	}
}