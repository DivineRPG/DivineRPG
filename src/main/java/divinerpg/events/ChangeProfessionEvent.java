package divinerpg.events;

import divinerpg.entities.base.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.*;

public class ChangeProfessionEvent {

    @SubscribeEvent
    public static void changeProfession(LivingConversionEvent.Pre event){
        if(event.getEntityLiving() instanceof EntityDivineMerchant){
            event.setCanceled(true);
        }
    }
}
