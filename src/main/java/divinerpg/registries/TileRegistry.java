package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.tiles.*;
import net.minecraft.tileentity.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder("divinerpg")
public class TileRegistry {

    public static TileEntityType<AltarOfCorruptionEntity> ALTAR_OF_CORRUPTION;
    public static TileEntityType<TileEntityNightmareBed> NIGHTMARE_BED;

    @SubscribeEvent
    public static void registerTE(RegistryEvent.Register<TileEntityType<?>> event) {
        ALTAR_OF_CORRUPTION = TileEntityType.Builder.create(() -> new AltarOfCorruptionEntity(ALTAR_OF_CORRUPTION), BlockRegistry.altarOfCorruption).build(null);
        NIGHTMARE_BED = TileEntityType.Builder.create(() -> new TileEntityNightmareBed(NIGHTMARE_BED), BlockRegistry.nightmareBed).build(null);
        event.getRegistry().registerAll(
                ALTAR_OF_CORRUPTION.setRegistryName(DivineRPG.MODID, "altar_of_corruption"),
                NIGHTMARE_BED.setRegistryName(DivineRPG.MODID, "nightmare_bed")
        );
    }
}
