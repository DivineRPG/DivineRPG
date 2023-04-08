package divinerpg.util.vanilla;

import com.google.common.collect.ImmutableMap;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.*;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import static divinerpg.registries.BlockRegistry.*;

public class LogStripper {

    public static void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
                    AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES)
                            .put(apalachiaLog.get(), strippedApalachiaLog.get())
                            .put(divineLog.get(), strippedDivineLog.get())
                            .put(dreamwoodLog.get(), strippedDreamwoodLog.get())
                            .put(edenLog.get(), strippedEdenLog.get())
                            .put(eucalyptusLog.get(), strippedEucalyptusLog.get())
                            .put(firewoodLog.get(), strippedFirewoodLog.get())
                            .put(frozenLog.get(), strippedFrozenLog.get())
                            .put(hyrewoodLog.get(), strippedHyrewoodLog.get())
                            .put(mintwoodLog.get(), strippedMintwoodLog.get())
                            .put(mortumLog.get(), strippedMortumLog.get())
                            .put(skythernLog.get(), strippedSkythernLog.get())
                            .put(wildwoodLog.get(), strippedWildwoodLog.get())
                            .build();
                }
        );
    }
}