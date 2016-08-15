package net.divinerpg.items.vanilla;

import net.divinerpg.entities.vanilla.EntityTheWatcher;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCallOfTheWatcher extends ItemMod {

    public ItemCallOfTheWatcher(String name) {
        super(name);
        setMaxStackSize(1);
        setCreativeTab(DivineRPGTabs.spawner);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
        if(world.provider.dimensionId != -1) player.addChatMessage(Util.getChatComponent(Util.AQUA + "This item can only be used in the Nether."));
        if(!world.isRemote && world.provider.dimensionId == -1) {
                EntityTheWatcher entity = new EntityTheWatcher(world);
                entity.setPosition(x, y + 1, z);
                if(world.getCollidingBoundingBoxes(entity, entity.boundingBox).isEmpty()) { 
                    world.spawnEntityInWorld(entity);
                    if(!player.capabilities.isCreativeMode) stack.stackSize--;
                }
                
        }
        return true;
    }
}