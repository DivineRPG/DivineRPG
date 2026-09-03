package divinerpg.registries;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import divinerpg.DivineRPG;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.*;

import java.util.function.Supplier;

public class DivineRegistries {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DivineRPG.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DivineRPG.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, DivineRPG.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, DivineRPG.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, DivineRPG.MODID);
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, DivineRPG.MODID);
    public static final DeferredRegister<JukeboxSong> MUSIC = DeferredRegister.create(Registries.JUKEBOX_SONG, DivineRPG.MODID);
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, DivineRPG.MODID);
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, DivineRPG.MODID);
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, DivineRPG.MODID);
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, DivineRPG.MODID);
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, DivineRPG.MODID);
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, DivineRPG.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, DivineRPG.MODID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, DivineRPG.MODID);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, DivineRPG.MODID);
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS = DeferredRegister.create(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, DivineRPG.MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, DivineRPG.MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, DivineRPG.MODID);
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, DivineRPG.MODID);
    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(Registries.PAINTING_VARIANT, DivineRPG.MODID);
    public static final DeferredRegister<DamageType> DAMAGE_TYPES = DeferredRegister.create(Registries.DAMAGE_TYPE, DivineRPG.MODID);
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(Registries.ENCHANTMENT, DivineRPG.MODID);
    public static final DeferredRegister<StructureType<?>> STRUCTURES = DeferredRegister.create(Registries.STRUCTURE_TYPE, DivineRPG.MODID);
    public static final DeferredRegister<MapCodec<? extends DensityFunction>> DENSITY_FUNCTION = DeferredRegister.create(BuiltInRegistries.DENSITY_FUNCTION_TYPE, DivineRPG.MODID);
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(BuiltInRegistries.FOLIAGE_PLACER_TYPE, DivineRPG.MODID);
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(BuiltInRegistries.TRUNK_PLACER_TYPE, DivineRPG.MODID);

    public static final Supplier<CreativeModeTab> BLOCKS_TAB = CREATIVE_MODE_TABS.register("blocks_tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.divinerpg.blocks")).icon(() -> BlockRegistry.arlemiteOre.asItem().getDefaultInstance()).build());
    public static final Supplier<CreativeModeTab> TOOLS_TAB = CREATIVE_MODE_TABS.register("tools_tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.divinerpg.tools")).icon(() -> Items.IRON_PICKAXE.getDefaultInstance()).build());
    public static final Supplier<CreativeModeTab> MISC_TAB = CREATIVE_MODE_TABS.register("misc_tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.divinerpg.misc")).icon(() -> ItemRegistry.arlemite_ingot.toStack()).build());

    public static void creativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == BLOCKS_TAB.get()) {
            for (var entry : DivineRegistries.BLOCKS.getEntries()) {
                Item item = entry.get().asItem();
                if (item instanceof BlockItem) {
                    event.accept(item.getDefaultInstance());
                }
            }
        } else if (event.getTab() == TOOLS_TAB.get()) {
            for (var entry : DivineRegistries.BLOCKS.getEntries()) {
                Item item = entry.get().asItem();
                if (ItemTags.SWORDS.equals(item) || ItemTags.SHOVELS.equals(item) || ItemTags.PICKAXES.equals(item) || ItemTags.AXES.equals(item) || ItemTags.HOES.equals(item)) {
                    event.accept(item.getDefaultInstance());
                }
            }
        } else if (event.getTab() == MISC_TAB.get()) {
            for (var entry : DivineRegistries.ITEMS.getEntries()) {
                Item item = entry.get();
                if (!(item instanceof BlockItem)) {
                    event.accept(item.getDefaultInstance());
                }
            }
        }
    }

    public static void register(IEventBus bus) {
        ItemRegistry.load();
        BlockRegistry.load();
        AttachmentRegistry.load();
        BlockEntityRegistry.load();
        DamageRegistry.load();
        DataComponentRegistry.load();
        EnchantmentRegistry.load();
        EntityRegistry.load();
        FeatureRegistry.load();
        FluidRegistry.load();
        LevelRegistry.load();
        LootModifierRegistry.load();
        LootTableRegistry.load();
        MenuTypeRegistry.load();
        MobEffectRegistry.load();
        PaintingRegistry.load();
        ParticleRegistry.load();
        PlacementModifierRegistry.load();
        PotionRegistry.load();
        RecipeRegistry.load();
        RecipeRegistry.Types.load();
        RecipeRegistry.Serializers.load();
        SoundRegistry.load();
        StructureRegistry.load();
        TrunkPlacerRegistry.load();
        FoliagePlacerRegistry.load();

        BLOCKS.register(bus);
        ITEMS.register(bus);
        CREATIVE_MODE_TABS.register(bus);
        ENTITIES.register(bus);
        BLOCK_ENTITIES.register(bus);
        SOUNDS.register(bus);
        MUSIC.register(bus);
        MENUS.register(bus);
        MOB_EFFECTS.register(bus);
        ATTACHMENTS.register(bus);
        DATA_COMPONENTS.register(bus);
        POTIONS.register(bus);
        PARTICLES.register(bus);
        FLUIDS.register(bus);
        FLUID_TYPES.register(bus);
        FEATURES.register(bus);
        PLACEMENT_MODIFIERS.register(bus);
        FOLIAGE_PLACERS.register(bus);
        TRUNK_PLACERS.register(bus);
        RECIPE_SERIALIZERS.register(bus);
        RECIPE_TYPES.register(bus);
        LOOT_MODIFIERS.register(bus);
        PAINTINGS.register(bus);
        DAMAGE_TYPES.register(bus);
        ENCHANTMENTS.register(bus);
        STRUCTURES.register(bus);
        DENSITY_FUNCTION.register(bus);
    }
}