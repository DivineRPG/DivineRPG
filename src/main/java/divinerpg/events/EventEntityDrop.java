package divinerpg.events;

import divinerpg.objects.entities.entity.boss.ayeraco.EntityAyeraco;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventEntityDrop {

    @SubscribeEvent
    public void onDrop(LivingDropsEvent event){

        if (event.getEntity() instanceof EntityAyeraco
            && event.getSource().getTrueSource() instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();

            event.getDrops().forEach(item -> {
                ItemStack stack = item.getItem();

                // If we can't place it in inventory, drop then
                if (!player.inventory.addItemStackToInventory(stack)){
                    item.setPosition(player.posX, player.posY, player.posZ);
                    player.world.spawnEntity(item);
                }
            });


            event.setCanceled(true);
        }
    }
}
