package divinerpg.data;

import divinerpg.DivineRPG;
import divinerpg.registries.EnchantmentRegistry;
import divinerpg.registries.SoundRegistry;
import divinerpg.registries.StructureRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.PAINTING_VARIANT, bootstrap -> {
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
                registerDamage(bootstrap, "acid", 0.1F);
                registerDamage(bootstrap, "arcana", 0.0F);
                registerDamage(bootstrap, "hail", 0.1F);
                registerDamage(bootstrap, "spike", 0.1F);
                registerDamage(bootstrap, "tar", 0.1F);
                registerDamage(bootstrap, "turtle", 0.1F);
            })
            .add(Registries.ENCHANTMENT, bootstrap -> {
                var items = bootstrap.lookup(Registries.ITEM);
                registerEnchantment(bootstrap, EnchantmentRegistry.RIVE, new Enchantment.Builder(Enchantment.definition(items.getOrThrow(ItemTags.PICKAXES), 5, 3, Enchantment.dynamicCost(5, 8), Enchantment.dynamicCost(25, 8), 2, EquipmentSlotGroup.MAINHAND)));
                registerEnchantment(bootstrap, EnchantmentRegistry.AFTERSHOCK, new Enchantment.Builder(Enchantment.definition(items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE), 2, 3, Enchantment.dynamicCost(10, 12), Enchantment.dynamicCost(40, 12), 4, EquipmentSlotGroup.MAINHAND)));
                registerEnchantment(bootstrap, EnchantmentRegistry.BRAIN_FREEZE, new Enchantment.Builder(Enchantment.definition(items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE), 5, 2, Enchantment.dynamicCost(15, 9), Enchantment.dynamicCost(35, 9), 2, EquipmentSlotGroup.MAINHAND)));
                registerEnchantment(bootstrap, EnchantmentRegistry.INSULATION, new Enchantment.Builder(Enchantment.definition(items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE), 10, 4, Enchantment.dynamicCost(1, 11), Enchantment.dynamicCost(21, 11), 1, EquipmentSlotGroup.ARMOR)));
            })
            .add(Registries.CONFIGURED_FEATURE, ModFeatureProvider::bootstrap)
            .add(Registries.STRUCTURE, StructureRegistry::bootstrapStructure)
            .add(Registries.TEMPLATE_POOL, StructureRegistry::bootstrapStructureTemplatePool)
            .add(Registries.STRUCTURE_SET, StructureRegistry::bootstrapStructureSets)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatureProvider::bootstrap)
            .add(Registries.BIOME, ModBiomeProvider::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifierBootstrap::bootstrap)
            .add(Registries.JUKEBOX_SONG, ModDatapackProvider::registerJukeboxSongs)
            .add(Registries.DIMENSION_TYPE, ModDimensionTypeProvider::bootstrap)
            .add(Registries.LEVEL_STEM, ModDimensionProvider::bootstrap)
            .add(Registries.NOISE_SETTINGS, ModNoiseSettingsProvider::bootstrap);


    public ModDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DivineRPG.MODID));
    }

    private static void registerPainting(BootstrapContext<PaintingVariant> bootstrap, String name, int widthInBlocks, int heightInBlocks) {
        ResourceKey<PaintingVariant> key = ResourceKey.create(Registries.PAINTING_VARIANT, Identifier.fromNamespaceAndPath(DivineRPG.MODID, name));
        PaintingVariant variant = new PaintingVariant(widthInBlocks, heightInBlocks, Identifier.fromNamespaceAndPath(DivineRPG.MODID, name), Optional.of(Component.translatable("painting." + DivineRPG.MODID + "." + name + ".title")), Optional.of(Component.translatable("painting." + DivineRPG.MODID + "." + name + ".author")));
        bootstrap.register(key, variant);
    }

    private static void registerDamage(BootstrapContext<DamageType> bootstrap, String name, float exhaustion) {
        ResourceKey<DamageType> key = ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(DivineRPG.MODID, name));
        DamageType damageType = new DamageType(name, DamageScaling.NEVER, exhaustion);
        bootstrap.register(key, damageType);
    }

    private static void registerEnchantment(BootstrapContext<Enchantment> bootstrap, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        bootstrap.register(key, builder.build(key.identifier()));
    }

    public static void registerJukeboxSongs(BootstrapContext<JukeboxSong> context) {
        context.register(SoundRegistry.DESTINY_SONG.getKey(), new JukeboxSong(Holder.direct(SoundRegistry.DESTINY.get()), Component.translatable("jukebox_song.divinerpg.destiny"), 159.0F, 4));
        context.register(SoundRegistry.RED_STAINS_SONG.getKey(), new JukeboxSong(Holder.direct(SoundRegistry.RED_STAINS.get()), Component.translatable("jukebox_song.divinerpg.red_stains"), 120.0F, 10));
    }
}