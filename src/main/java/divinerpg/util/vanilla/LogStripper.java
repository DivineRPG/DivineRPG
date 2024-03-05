package divinerpg.util.vanilla;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static divinerpg.registries.BlockRegistry.*;

public class LogStripper {
    public static void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES)
                .put(divineLog.get(), strippedDivineLog.get())
                .put(divineWood.get(), strippedDivineWood.get())
                .put(shiverspineLog.get(), strippedShiverspineLog.get())
                .put(shiverspineWood.get(), strippedShiverspineWood.get())
                .put(auroraoakLog.get(), strippedAuroraoakLog.get())
                .put(auroraoakWood.get(), strippedAuroraoakWood.get())
                .put(cozybarkLog.get(), strippedCozybarkLog.get())
                .put(cozybarkWood.get(), strippedCozybarkWood.get())
                .put(streamleafLog.get(), strippedStreamleafLog.get())
                .put(streamleafWood.get(), strippedStreamleafWood.get())
                .put(eucalyptusLog.get(), strippedEucalyptusLog.get())
                .put(eucalyptusWood.get(), strippedEucalyptusWood.get())
                .put(edenLog.get(), strippedEdenLog.get())
                .put(edenWood.get(), strippedEdenWood.get())
                .put(wildwoodLog.get(), strippedWildwoodLog.get())
                .put(wildwoodWood.get(), strippedWildwoodWood.get())
                .put(apalachiaLog.get(), strippedApalachiaLog.get())
                .put(apalachiaWood.get(), strippedApalachiaWood.get())
                .put(skythernLog.get(), strippedSkythernLog.get())
                .put(skythernWood.get(), strippedSkythernWood.get())
                .put(mortumLog.get(), strippedMortumLog.get())
                .put(mortumWood.get(), strippedMortumWood.get())
                .put(firewoodLog.get(), strippedFirewoodLog.get())
                .put(firewoodWood.get(), strippedFirewoodWood.get())
                .put(dreamwoodLog.get(), strippedDreamwoodLog.get())
                .put(dreamwoodWood.get(), strippedDreamwoodWood.get())
                .put(hyrewoodLog.get(), strippedHyrewoodLog.get())
                .put(hyrewoodWood.get(), strippedHyrewoodWood.get())
                .put(mintwoodLog.get(), strippedMintwoodLog.get())
                .put(mintwoodWood.get(), strippedMintwoodWood.get())
                .build();
            }
        );
    }
}