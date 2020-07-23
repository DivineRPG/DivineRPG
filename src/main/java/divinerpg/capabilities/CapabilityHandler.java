package divinerpg.capabilities;

import divinerpg.DivineRPG;
import divinerpg.api.arcana.ArcanaProvider;
import divinerpg.api.armor.cap.ArmorProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler
{
    public static final ResourceLocation ARCANA_CAP = new ResourceLocation(DivineRPG.MODID, "arcana");
    public static final ResourceLocation ArmorCapabilityID = new ResourceLocation(DivineRPG.MODID, "armor");

    @SubscribeEvent
    public void attachCapability(final AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(ARCANA_CAP, new ArcanaProvider());
            event.addCapability(ArmorCapabilityID, new ArmorProvider((EntityPlayer) event.getObject()));
        }
    }
}