package divinerpg;

import divinerpg.compat.ModCompat;
import divinerpg.config.*;
import divinerpg.events.*;
import divinerpg.events.enchant.RiveHandler;
import divinerpg.network.Payloads;
import divinerpg.registries.*;
import divinerpg.util.Utils;
import divinerpg.util.vanilla.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.*;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.*;

@Mod(DivineRPG.MODID)
public class DivineRPG {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "divinerpg";

    public DivineRPG(IEventBus bus, ModContainer container) {
        BlockRegistry.BLOCKS.register(bus);
        DataComponentRegistry.DATA_COMPONENTS.register(bus);
        ItemRegistry.ITEMS.register(bus);
        BlockRegistry.BLOCK_ITEMS.register(bus);
        BlockEntityRegistry.BLOCK_ENTITIES.register(bus);
        FluidRegistry.FLUIDS.register(bus);
        FluidRegistry.FLUID_TYPES.register(bus);
        MenuTypeRegistry.MENU_TYPE.register(bus);
        EntityRegistry.ENTITIES.register(bus);
        ParticleRegistry.PARTICLES.register(bus);
        RecipeRegistry.Serailizers.SERIALIZER.register(bus);
        SoundRegistry.SOUNDS.register(bus);
        SoundRegistry.SONGS.register(bus);
        DamageRegistry.DAMAGE_TYPE.register(bus);
        MobEffectRegistry.EFFECTS.register(bus);
        PotionRegistry.POTIONS.register(bus);
        RecipeRegistry.Types.RECIPE_TYPES.register(bus);
        FeatureRegistry.FEATURES.register(bus);
        StructureRegistry.STRUCTURE_TYPE.register(bus);
        PaintingRegistry.PAINTING_VARIANTS.register(bus);
        LootModifierRegistry.GLOBAL_LOOT_MODIFIERS.register(bus);
        CreativeTabRegistry.CREATIVE_MODE_TABS.register(bus);
        ArmorMaterialRegistry.ARMOR_MATERIALS.register(bus);
        AttachmentRegistry.ATTACHMENT_TYPES.register(bus);
        PlacementModifierRegistry.PLACEMENT_MODIFIER.register(bus);
        EventRegistry.init();
        NeoForge.EVENT_BUS.addListener(SpawnEvents::spawnPlacementCheck);
        bus.addListener(this::setup);
        bus.addListener(this::post);
        bus.addListener(this::client);
        bus.addListener(SpawnEvents::registerSpawnPlacements);
        bus.addListener(CreativeTabRegistry::creativeTab);
        bus.register(Payloads.class);
        bus.register(EntityRegistry.class);
        bus.register(MenuTypeRegistry.class);
        container.registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC, DivineRPG.MODID + "/common.toml");
        container.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC, DivineRPG.MODID + "/client.toml");
    }
    private void setup(final FMLCommonSetupEvent event) {
        ModCompat.initCommon(event);
        NeoForge.EVENT_BUS.register(new RiveHandler());
        NeoForge.EVENT_BUS.register(new Ticker());
        NeoForge.EVENT_BUS.register(new RecipeRegistry());
        event.enqueueWork(() -> {
            LogStripper.setup(event);
            PlantPots.setup(event);
            ItemRegistry.registerDispenserItems();
        });
    }
    private void client(final FMLClientSetupEvent event) {
        ModelPropRegistry.init();
        BlockEntityRegistry.renderTiles();
        NeoForge.EVENT_BUS.register(new BossBarRenderer());
        NeoForge.EVENT_BUS.register(new EventClientLogin());
        NeoForge.EVENT_BUS.register(new ClientSidedExtraEvents.MusicEvent());
        Utils.loadHatInformation();
        ItemPropertyRegistry.registerProperties();
    }
    private void post(final FMLLoadCompleteEvent event){
    }
}