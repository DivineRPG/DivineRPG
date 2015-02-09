package net.divinerpg.api.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class ItemModOrb extends ItemMod {

	public ItemModOrb(String name) {
		super(name);
	}
	
	@Override
	public void onUpdate(ItemStack item, World world, Entity entity, int var4, boolean var5) {
		world.setLightValue(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY, (int)entity.posZ, 15);
        world.markBlockRangeForRenderUpdate((int)entity.posX, (int)entity.posY, (int)entity.posX, 12, 12, 12);
        world.markBlockForUpdate((int)entity.posX, (int)entity.posY, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY +1, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY +1, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY +1, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY +1, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY +1, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY +1, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY +1, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY +1, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY +1, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY -1, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY -1, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY -1, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY -1, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY -1, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY -1, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY -1, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY -1, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY -1, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY, (int)entity.posZ -1);
	}
}
