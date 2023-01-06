package divinerpg;

import com.google.common.collect.ImmutableMap;
import divinerpg.compat.ModCompat;
import divinerpg.config.*;
import divinerpg.events.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.*;

import static divinerpg.registries.BlockRegistry.*;

@Mod(DivineRPG.MODID)
public class DivineRPG {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "divinerpg";

    public DivineRPG() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(DivineTab::registerTabs);
        BlockRegistry.BLOCKS.register(bus);
        ItemRegistry.ITEMS.register(bus);
        BLOCK_ITEMS.register(bus);
        BlockEntityRegistry.BLOCK_ENTITIES.register(bus);
        FluidRegistry.FLUIDS.register(bus);
        FluidRegistry.FLUID_TYPES.register(bus);
        MenuTypeRegistry.CONTAINERS.register(bus);
        EntityRegistry.ENTITIES.register(bus);
        ParticleRegistry.PARTICLES.register(bus);
        RecipeRegistry.Serailizers.SERIALIZER.register(bus);
        SoundRegistry.SOUNDS.register(bus);
        EnchantmentRegistry.ENCHANTS.register(bus);
        MobEffectRegistry.EFFECTS.register(bus);
        RecipeRegistry.Types.RECIPE_TYPES.register(bus);
        FeatureRegistry.FEATURES.register(bus);
        StructureRegistry.STRUCTURE_TYPE.register(bus);
        PaintingRegistry.PAINTING_VARIANTS.register(bus);
        PointOfInterestRegistry.POI.register(bus);
        LootModifierRegistry.GLOBAL_LOOT_MODIFIERS.register(bus);
        EventRegistry.init();
        bus.addListener(this::setup);
        bus.addListener(this::post);
        bus.addListener(this::client);
        MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, AttatchCapabilityEvent::onAttachCapabilitiesPlayer);
        MinecraftForge.EVENT_BUS.addListener(AttatchCapabilityEvent::onRegisterCapabilities);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC, DivineRPG.MODID + "/divinerpg-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC, DivineRPG.MODID + "/divinerpg-common.toml");
        NetworkingRegistry.register();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        ModCompat.initCommon(event);
        TriggerRegistry.registerTriggers();
        PlacementModifierRegistry.init();

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
            addPlant(bulbatobe, bulbatobePot);
            addPlant(cracklespike, cracklespikePot);
            addPlant(dreamglow, dreamglowPot);
            addPlant(fernite, fernitePot);
            addPlant(greenDulah, greenDulahPot);
            addPlant(greenGemtop, greenGemtopPot);
            addPlant(purpleGemtop, purpleGemtopPot);
            addPlant(shimmer, shimmerPot);
            addPlant(shineGrass, shineGrassPot);
            addPlant(yellowDulah, yellowDulahPot);
            addPlant(arcanaBrush, arcanaBrushPot);
            addPlant(arcanaBush, arcanaBushPot);
            addPlant(gemOfTheDunes, gemOfTheDunesPot);
            addPlant(demonBrambles, demonBramblesPot);
            addPlant(eyePlant, eyePlantPot);
            addPlant(mortumBrush, mortumBrushPot);
            addPlant(dustBrambles, dustBramblesPot);
            addPlant(dustLily, dustLilyPot);
            addPlant(skythernBrush, skythernBrushPot);
            addPlant(duskBloom, duskBloomPot);
            addPlant(duskFlower, duskFlowerPot);
            addPlant(moonBud, moonBudPot);
            addPlant(moonlightFern, moonlightFernPot);
            addPlant(sunBlossom, sunBlossomPot);
            addPlant(sunbloom, sunbloomPot);
            addPlant(edenBrush, edenBrushPot);
            addPlant(edenSapling, edenSaplingPot);
            addPlant(wildwoodSapling, wildwoodSaplingPot);
            addPlant(apalachiaSapling, apalachiaSaplingPot);
            addPlant(skythernSapling, skythernSaplingPot);
            addPlant(mortumSapling, mortumSaplingPot);
            addPlant(brittleGrass, brittleGrassPot);
            addPlant(frozenSapling, frozenSaplingPot);
            addPlant(divineSapling, divineSaplingPot);
        });
    }
    private void addPlant(RegistryObject<Block> plant, RegistryObject<FlowerPotBlock> pot) {
    	((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(plant.getId(), pot);
    }
    private void client(final FMLClientSetupEvent event) {
        ModelPropRegistry.init();
        MenuTypeRegistry.registerScreenFactories();
        BlockEntityRegistry.renderTiles();
        MinecraftForge.EVENT_BUS.register(new ArcanaRenderer());
        MinecraftForge.EVENT_BUS.register(new EventClientLogin());
        Utils.loadHatInformation();
    }
    private void post(final FMLLoadCompleteEvent event){
    }
}