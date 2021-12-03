package divinerpg.events;

import divinerpg.*;
import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.*;

import javax.annotation.*;
import java.util.*;

public class VetheaInventorySwapEvent {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onDimensionChange(PlayerEvent.PlayerChangedDimensionEvent event){
        //TODO - make vethea inventory swap back to overworld when leaving vethea
        if (event.isCanceled() || !(event.getEntity() instanceof PlayerEntity))
            return;

        RegistryKey<World> sourceDimension = event.getEntity().level.dimension();
        RegistryKey<World> destinationDimension = event.getTo();

        RegistryKey<World> vetheaID = KeyRegistry.VETHEA_WORLD;

        if (vetheaID != sourceDimension && vetheaID != destinationDimension)
            return;

        PlayerEntity player = (PlayerEntity) event.getEntity();
        CompoundNBT tag = getPersistedDivineTag(player);

        List<String> tagNames = Arrays.asList("OverworldInv", "VetheaInv");

        if (sourceDimension == vetheaID) {
            Collections.reverse(tagNames);
        }

        String saveTo = tagNames.get(0);
        tag.put(saveTo, player.inventory.save(new ListNBT()));
        player.inventory.clearContent();

        String loadFrom = tagNames.get(1);
        INBT newDimensionNBT = tag.get(loadFrom);
        if (newDimensionNBT instanceof ListNBT) {
            player.inventory.load((ListNBT) newDimensionNBT);
        }

        player.inventoryMenu.broadcastChanges();

    }
    public static CompoundNBT getPersistedDivineTag(@Nonnull PlayerEntity e) {
        CompoundNBT playerData = e.serializeNBT();

        if (!playerData.contains(PlayerEntity.PERSISTED_NBT_TAG)) {
            playerData.put(PlayerEntity.PERSISTED_NBT_TAG, new CompoundNBT());
        }

        CompoundNBT persistantData = playerData.getCompound(PlayerEntity.PERSISTED_NBT_TAG);

        if (!persistantData.contains(DivineRPG.MODID)) {
            persistantData.put(DivineRPG.MODID, new CompoundNBT());
        }

        return persistantData.getCompound(DivineRPG.MODID);
    }

}
