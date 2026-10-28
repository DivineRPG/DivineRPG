package divinerpg.data;

import com.mojang.logging.LogUtils;
import divinerpg.DivineRPG;
import divinerpg.registries.EnchantmentRegistry;
import divinerpg.registries.SoundRegistry;
import divinerpg.registries.StructureRegistry;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {

    private static final Logger LOGGER = LogUtils.getLogger();

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.PAINTING_VARIANT, bootstrap -> {
                LOGGER.info("[DatapackGen] Bootstrapping Painting Variants...");
                registerPainting(bootstrap, "fall", 2, 2);
                registerPainting(bootstrap, "moonlight_rave", 2, 1);
                registerPainting(bootstrap, "grazing", 1, 1);
                registerPainting(bootstrap, "disturbed", 1, 2);
                registerPainting(bootstrap, "levels", 2, 2);
                registerPainting(bootstrap, "ice_age", 4, 4);
                registerPainting(bootstrap, "crawling", 1, 1);
                registerPainting(bootstrap, "howling_at_the_moon", 4, 2);
                registerPainting(bootstrap, "lurking_terror", 2, 2);
            })
            .add(Registries.DAMAGE_TYPE, bootstrap -> {
                LOGGER.info("[DatapackGen] Bootstrapping Damage Types...");
                registerDamage(bootstrap, "acid", 0.1F);
                registerDamage(bootstrap, "arcana", 0.0F);
                registerDamage(bootstrap, "hail", 0.1F);
                registerDamage(bootstrap, "spike", 0.1F);
                registerDamage(bootstrap, "tar", 0.1F);
                registerDamage(bootstrap, "turtle", 0.1F);
            })
            .add(Registries.ENCHANTMENT, bootstrap -> {
                LOGGER.info("[DatapackGen] Bootstrapping Enchantments...");
                HolderGetter<Item> items = bootstrap.lookup(Registries.ITEM);
                registerEnchantment(bootstrap, EnchantmentRegistry.RIVE, Enchantment.enchantment(Enchantment.definition(items.getOrThrow(ItemTags.PICKAXES), 5, 3, Enchantment.dynamicCost(5, 8), Enchantment.dynamicCost(25, 8), 2, EquipmentSlotGroup.MAINHAND)));
                registerEnchantment(bootstrap, EnchantmentRegistry.AFTERSHOCK, Enchantment.enchantment(Enchantment.definition(items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE), 2, 3, Enchantment.dynamicCost(10, 12), Enchantment.dynamicCost(40, 12), 4, EquipmentSlotGroup.MAINHAND)));
                registerEnchantment(bootstrap, EnchantmentRegistry.BRAIN_FREEZE, Enchantment.enchantment(Enchantment.definition(items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE), 5, 2, Enchantment.dynamicCost(15, 9), Enchantment.dynamicCost(35, 9), 2, EquipmentSlotGroup.MAINHAND)));
                registerEnchantment(bootstrap, EnchantmentRegistry.INSULATION, Enchantment.enchantment(Enchantment.definition(items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE), 10, 4, Enchantment.dynamicCost(1, 11), Enchantment.dynamicCost(21, 11), 1, EquipmentSlotGroup.ARMOR)));
            })
            .add(Registries.FEATURE, ctx -> {
                LOGGER.info("[DatapackGen] Bootstrapping Features...");
                ModFeatureProvider.bootstrap(ctx);
            })
            .add(Registries.PLACED_FEATURE, ctx -> {
                LOGGER.info("[DatapackGen] Bootstrapping Placed Features...");
                ModPlacedFeatureProvider.bootstrap(ctx);
            })
            .add(Registries.STRUCTURE, ctx -> {
                LOGGER.info("[DatapackGen] Bootstrapping Structures...");
                StructureRegistry.bootstrapStructure(ctx);
            })
            .add(Registries.TEMPLATE_POOL, ctx -> {
                LOGGER.info("[DatapackGen] Bootstrapping Structure Template Pools...");
                StructureRegistry.bootstrapStructureTemplatePool(ctx);
            })
            .add(Registries.STRUCTURE_SET, ctx -> {
                LOGGER.info("[DatapackGen] Bootstrapping Structure Sets...");
                StructureRegistry.bootstrapStructureSets(ctx);
            })
            .add(Registries.BIOME, ctx -> {
                LOGGER.info("[DatapackGen] Bootstrapping Biomes...");
                ModBiomeProvider.bootstrap(ctx);
            })
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ctx -> {
                LOGGER.info("[DatapackGen] Bootstrapping Biome Modifiers...");
                ModBiomeModifierBootstrap.bootstrap(ctx);
            })
            .add(Registries.JUKEBOX_SONG, ctx -> {
                LOGGER.info("[DatapackGen] Bootstrapping Jukebox Songs...");
                registerJukeboxSongs(ctx);
            })
            .add(Registries.DIMENSION_TYPE, ctx -> {
                LOGGER.info("[DatapackGen] Bootstrapping Dimension Types...");
                ModDimensionTypeProvider.bootstrap(ctx);
            })
            .add(Registries.LEVEL_STEM, ctx -> {
                LOGGER.info("[DatapackGen] Bootstrapping Level Stems...");
                ModDimensionProvider.bootstrap(ctx);
            })
            .add(Registries.NOISE_SETTINGS, ctx -> {
                LOGGER.info("[DatapackGen] Bootstrapping Noise Settings...");
                ModNoiseSettingsProvider.bootstrap(ctx);
            })
            .add(Registries.DENSITY_FUNCTION, ctx -> {
                LOGGER.info("[DatapackGen] Bootstrapping Density Settings...");
                ModDensityFunctionProvider.bootstrap(ctx);
            })
            .add(Registries.NOISE, ctx -> {
                LOGGER.info("[DatapackGen] Bootstrapping Noise Parameters...");
                ModNoiseParametersProvider.bootstrap(ctx);
            });

    public static final RegistrySetBuilder RELOADABLE_BUILDER = new RegistrySetBuilder().add(Registries.LOOT_TABLE, new ModLootTableProvider()).add(RecipeProvider.asBootstrap(ModRecipeProvider::new)).add(Registries.ADVANCEMENT, new AdvancementProvider(List.of(ModAdvancementProvider::new)));

    public ModDatapackProvider(PackOutput output, String name, Collection<RegistryDataLoader.RegistryData<?>> registryData, CompletableFuture<RegistrySetBuilder.PatchedRegistries> registries, @Nullable Set<String> modIds) {
        super(output, name, registryData, registries, modIds);
    }

    private static void registerPainting(BootstrapContext<PaintingVariant> bootstrap, String name, int widthInBlocks, int heightInBlocks) {
        try {
            ResourceKey<PaintingVariant> key = ResourceKey.create(Registries.PAINTING_VARIANT, Identifier.fromNamespaceAndPath(DivineRPG.MODID, name));
            PaintingVariant variant = new PaintingVariant(widthInBlocks, heightInBlocks, Identifier.fromNamespaceAndPath(DivineRPG.MODID, name), Optional.of(Component.translatable("painting." + DivineRPG.MODID + "." + name + ".title")), Optional.of(Component.translatable("painting." + DivineRPG.MODID + "." + name + ".author")));
            bootstrap.register(key, variant);
            LOGGER.debug("[DatapackGen] Registered Painting: {}", name);
        } catch (Exception e) {
            LOGGER.error("[DatapackGen] Failed to register painting: {}", name, e);
            throw e;
        }
    }

    private static void registerDamage(BootstrapContext<DamageType> bootstrap, String name, float exhaustion) {
        try {
            ResourceKey<DamageType> key = ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(DivineRPG.MODID, name));
            DamageType damageType = new DamageType(name, DamageScaling.NEVER, exhaustion);
            bootstrap.register(key, damageType);
            LOGGER.debug("[DatapackGen] Registered DamageType: {}", name);
        } catch (Exception e) {
            LOGGER.error("[DatapackGen] Failed to register damage type: {}", name, e);
            throw e;
        }
    }

    private static void registerEnchantment(BootstrapContext<Enchantment> bootstrap, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        try {
            bootstrap.register(key, builder.build(key.identifier()));
            LOGGER.debug("[DatapackGen] Registered Enchantment: {}", key.identifier().getPath());
        } catch (Exception e) {
            LOGGER.error("[DatapackGen] Failed to register enchantment: {}", key.identifier().getPath(), e);
            throw e;
        }
    }

    public static void registerJukeboxSongs(BootstrapContext<JukeboxSong> context) {
        HolderGetter<SoundEvent> sounds = context.lookup(Registries.SOUND_EVENT);
        if (SoundRegistry.DESTINY_SONG == null || SoundRegistry.DESTINY == null) {LOGGER.error("[DatapackGen] SoundRegistry holder for DESTINY or DESTINY_SONG is null!");} else {context.register(SoundRegistry.DESTINY_SONG.key(), new JukeboxSong(sounds.getOrThrow(SoundRegistry.DESTINY.key()), Component.translatable("jukebox_song.divinerpg.destiny"), 159.0F, 4));}
        if (SoundRegistry.RED_STAINS_SONG == null || SoundRegistry.RED_STAINS == null) {LOGGER.error("[DatapackGen] SoundRegistry holder for RED_STAINS or RED_STAINS_SONG is null!");} else {context.register(SoundRegistry.RED_STAINS_SONG.key(), new JukeboxSong(sounds.getOrThrow(SoundRegistry.RED_STAINS.key()), Component.translatable("jukebox_song.divinerpg.red_stains"), 120.0F, 10));}
    }

    public static DatapackBuiltinEntriesProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> world) {
        return DatapackBuiltinEntriesProvider.forWorldLayer(output, "DivineRPG World Registries", world, BUILDER, Set.of(DivineRPG.MODID));
    }

    public static DatapackBuiltinEntriesProvider createReloadable(PackOutput output, CompletableFuture<HolderLookup.Provider> world, CompletableFuture<HolderLookup.Provider> reloadable) {
        return DatapackBuiltinEntriesProvider.forReloadableLayer(output, "DivineRPG Reloadable Registries", world, reloadable, RELOADABLE_BUILDER, Set.of(DivineRPG.MODID));
    }
}