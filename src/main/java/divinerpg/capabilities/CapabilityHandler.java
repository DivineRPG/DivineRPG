package divinerpg.capabilities;

import divinerpg.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler
{
    public static final ResourceLocation ARCANA_CAP = new ResourceLocation(Reference.MODID, "arcana");

    @SubscribeEvent
    public void attachCapability(final AttachCapabilitiesEvent<Entity> event)
    {
        if (!(event.getObject() instanceof EntityPlayer)) return;

        event.addCapability(ARCANA_CAP, new ArcanaProvider());
    }
}