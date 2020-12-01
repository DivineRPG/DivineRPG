package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.tiles.AltarOfCorruptionEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder("divinerpg")
public class TileRegistry {

    public static TileEntityType<AltarOfCorruptionEntity> ALTAR_OF_CORRUPTION_TE_TYPE;

    @SubscribeEvent
    public static void registerTE(RegistryEvent.Register<TileEntityType<?>> event) {
        ALTAR_OF_CORRUPTION_TE_TYPE = TileEntityType.Builder.create(() -> new AltarOfCorruptionEntity(ALTAR_OF_CORRUPTION_TE_TYPE), BlockRegistry.altarOfCorruption).build(null);
        event.getRegistry().registerAll(
                ALTAR_OF_CORRUPTION_TE_TYPE.setRegistryName(DivineRPG.MODID, "altar_of_corruption"));
    }
}
