package divinerpg.registries;

import com.google.common.collect.ImmutableSet;
import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.*;

public class PointOfInterestRegistry {
    public static final DeferredRegister<PoiType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, DivineRPG.MODID);

    public static final RegistryObject<PoiType> EDEN_PORTAL = POI.register("eden_portal", () -> new PoiType(ImmutableSet.copyOf(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_portal")).getStateDefinition().getPossibleStates()), 0, 1));
    public static final RegistryObject<PoiType> WILDWOOD_PORTAL = POI.register("wildwood_portal", () -> new PoiType(ImmutableSet.copyOf(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_portal")).getStateDefinition().getPossibleStates()), 0, 1));
    public static final RegistryObject<PoiType> APALACHIA_PORTAL = POI.register("apalachia_portal", () -> new PoiType(ImmutableSet.copyOf(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_portal")).getStateDefinition().getPossibleStates()), 0, 1));
    public static final RegistryObject<PoiType> SKYTHERN_PORTAL = POI.register("skythern_portal", () -> new PoiType(ImmutableSet.copyOf(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_portal")).getStateDefinition().getPossibleStates()), 0, 1));
    public static final RegistryObject<PoiType> MORTUM_PORTAL = POI.register("mortum_portal", () -> new PoiType(ImmutableSet.copyOf(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_portal")).getStateDefinition().getPossibleStates()), 0, 1));
    public static final RegistryObject<PoiType> ICEIKA_PORTAL = POI.register("iceika_portal", () -> new PoiType(ImmutableSet.copyOf(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "iceika_portal")).getStateDefinition().getPossibleStates()), 0, 1));
    public static final RegistryObject<PoiType> ARCANA_PORTAL = POI.register("arcana_portal", () -> new PoiType(ImmutableSet.copyOf(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal")).getStateDefinition().getPossibleStates()), 0, 1));
    public static final RegistryObject<PoiType> SOUL_TRAP = POI.register("soul_trap", () -> new PoiType(ImmutableSet.copyOf(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "soul_trap")).getStateDefinition().getPossibleStates()), 0, 1));
}
