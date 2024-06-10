package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.capability.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class AttatchCapabilityEvent {
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(Arcana.class);
        event.register(SoulTrapCount.class);
        event.register(Reputation.class);
        event.register(DimensionalInventory.class);
    }
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof Player player) {
            if(!player.getCapability(ArcanaProvider.ARCANA).isPresent()) event.addCapability(new ResourceLocation(DivineRPG.MODID, "arcana"), new ArcanaProvider());
            if(!player.getCapability(ReputationProvider.REPUTATION).isPresent()) event.addCapability(new ResourceLocation(DivineRPG.MODID, "reputation"),  new ReputationProvider());
            if(!player.getCapability(DimensionalInventoryProvider.DIMENIONAL_INVENTORY).isPresent()) event.addCapability(new ResourceLocation(DivineRPG.MODID, "dimensional_inventory"),  new DimensionalInventoryProvider());
        }
    }
    public static void onAttachCapabilitiesLevelChunk(AttachCapabilitiesEvent<LevelChunk> event){
        if(event.getObject() instanceof LevelChunk && !event.getObject().getCapability(SoulTrapCountProvider.SOUL_TRAP_COUNT).isPresent()) event.addCapability(new ResourceLocation(DivineRPG.MODID, "soul_trap_count"), new SoulTrapCountProvider());
    }
}