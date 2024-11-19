package net.divinerpg.items.vanilla;

import net.divinerpg.entities.vanilla.EntityAncientEntity;
import net.divinerpg.entities.vanilla.EntityTheWatcher;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.divinerpg.utils.MessageLocalizer;

public class ItemCallOfTheWatcher extends ItemMod {

    public ItemCallOfTheWatcher(String name) {
        super(name);
        setMaxStackSize(1);
        setCreativeTab(DivineRPGTabs.spawner);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
        if (!world.isRemote) {
            if (world.provider.dimensionId == ConfigurationHelper.theWatcherDim) {
                if (stack.getItem() == VanillaItemsOther.callWatcher) {
                    EntityTheWatcher e = new EntityTheWatcher(world);
                    e.setPosition(x, y + 1, z);
                    if (world.getCollidingBoundingBoxes(e, e.boundingBox).isEmpty()) {
                        world.spawnEntityInWorld(e);
                        if (!player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(stack.getItem());
                    }
                    return true;
                }
            } else {
                player.addChatMessage(Util.getChatComponent(Util.AQUA + MessageLocalizer.norecolor("message.spawner.callofthewatcher")));
            }
        }
        return false;
    }
}
