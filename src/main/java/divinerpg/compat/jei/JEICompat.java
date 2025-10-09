package divinerpg.compat.jei;

import divinerpg.client.screen.*;
import divinerpg.compat.jei.brewing.PotionRecipe;
import divinerpg.compat.jei.category.*;
import divinerpg.compat.jei.ingredient.*;
import divinerpg.entities.base.EntityDivineMerchant.DivineTrades;
import divinerpg.registries.*;
import mezz.jei.api.*;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;

import java.util.List;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.PotionRegistry.*;
import static divinerpg.registries.RecipeRegistry.Trades.*;
import static divinerpg.registries.RecipeRegistry.Types.*;

@JeiPlugin
public class JEICompat implements IModPlugin {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(MODID, "jei_plugin");
    public static final IIngredientType<Block> BLOCK_INGREDIENT_TYPE = () -> Block.class;
    @Override public ResourceLocation getPluginUid() {return UID;}
    @Override public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalysts(RecipeTypes.SMELTING, Ingredient.of(TagRegistry.FURNACES).getItems());
        registration.addRecipeCatalysts(SmashingCategory.RECIPE_TYPE, Ingredient.of(TagRegistry.MAULS).getItems());
        registration.addRecipeCatalyst(BlockRegistry.arcaniumExtractor, ArcaniumExtractorCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(BlockRegistry.infusionTable, InfusionTableCategory.RECIPE_TYPE);
    }
    @Override public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Minecraft.getInstance().level.getRecipeManager();
        registration.addRecipes(ArcaniumExtractorCategory.RECIPE_TYPE, manager.getAllRecipesFor(ARCANIUM_EXTRACTOR_RECIPE_TYPE.get()));
        registration.addRecipes(InfusionTableCategory.RECIPE_TYPE, manager.getAllRecipesFor(INFUSION_TABLE_RECIPE_TYPE.get()));
        registration.addRecipes(SmashingCategory.RECIPE_TYPE, manager.getAllRecipesFor(MAUL_SMASHING.get()));
        registration.addRecipes(FireConversionCategory.RECIPE_TYPE, manager.getAllRecipesFor(FIRE_CONVERSION.get()));
        registration.addRecipes(RecipeTypes.BREWING, List.of(
                //TODO: some potion recipe variants display "?" as steps count (those that are added automatically)
                new PotionRecipe(Items.POTION, Potions.AWKWARD, GROG, 2, ResourceLocation.fromNamespaceAndPath(MODID, "brewing.grog.regular"), ItemRegistry.cauldron_flesh.toStack()),
                new PotionRecipe(Items.SPLASH_POTION, Potions.AWKWARD, GROG, 3, ResourceLocation.fromNamespaceAndPath(MODID, "brewing.grog.splash"), ItemRegistry.cauldron_flesh.toStack()),
                new PotionRecipe(Items.LINGERING_POTION, Potions.AWKWARD, GROG, 4, ResourceLocation.fromNamespaceAndPath(MODID, "brewing.grog.lingering"), ItemRegistry.cauldron_flesh.toStack()),
                new PotionRecipe(Items.POTION, TEA, WARMTH, 2, ResourceLocation.fromNamespaceAndPath(MODID, "brewing.warmth.regular"), ItemRegistry.olivine.toStack()),
                new PotionRecipe(Items.SPLASH_POTION, TEA, WARMTH, 3, ResourceLocation.fromNamespaceAndPath(MODID, "brewing.warmth.splash"), ItemRegistry.olivine.toStack()),
                new PotionRecipe(Items.LINGERING_POTION, TEA, WARMTH, 4, ResourceLocation.fromNamespaceAndPath(MODID, "brewing.warmth.lingering"), ItemRegistry.olivine.toStack()),
                new PotionRecipe(Items.POTION, Potions.WATER, TEA, 1, ResourceLocation.fromNamespaceAndPath(MODID, "brewing.tea.regular"), ItemRegistry.winterberry.toStack(), Items.SWEET_BERRIES.getDefaultInstance()),
                new PotionRecipe(Items.SPLASH_POTION, Potions.WATER, TEA, 2, ResourceLocation.fromNamespaceAndPath(MODID, "brewing.tea.splash"), ItemRegistry.winterberry.toStack(), Items.SWEET_BERRIES.getDefaultInstance()),
                new PotionRecipe(Items.LINGERING_POTION, Potions.WATER, TEA, 3, ResourceLocation.fromNamespaceAndPath(MODID, "brewing.tea.lingering"), ItemRegistry.winterberry.toStack(), Items.SWEET_BERRIES.getDefaultInstance())
        ));
        registerMerchantTrade(registration, LIVESTOCK_MERCHANT, "livestock_merchant");
        registerMerchantTrade(registration, JACK_O_MAN, "jack_o_man");
        registerMerchantTrade(registration, DIAMOND_DAVE, "diamond_dave");
        registerMerchantTrade(registration, WORKSHOP_MERCHANT, "workshop_merchant");
        registerMerchantTrade(registration, WORKSHOP_TINKERER, "workshop_tinkerer");
        registerMerchantTrade(registration, GROGLIN_CHIEFTAIN, "groglin_chieftain");
        registerMerchantTrade(registration, GROGLIN_HUNTER, "groglin_hunter");
        registerMerchantTrade(registration, GROGLIN_MERCHANT, "groglin_merchant");
        registerMerchantTrade(registration, GROGLIN_RANGER, "groglin_ranger");
        registerMerchantTrade(registration, GROGLIN_SHARLATAN, "groglin_sharlatan");
        registerMerchantTrade(registration, GROGLIN_WARRIOR, "groglin_warrior");
        registerMerchantTrade(registration, GRUZZORLUG_CANNONEER, "gruzzorlug_cannoneer");
        registerMerchantTrade(registration, GRUZZORLUG_COMMANDER, "gruzzorlug_commander");
        registerMerchantTrade(registration, GRUZZORLUG_GENERAL, "gruzzorlug_general");
        registerMerchantTrade(registration, GRUZZORLUG_KNIGHT, "gruzzorlug_knight");
        registerMerchantTrade(registration, GRUZZORLUG_MINER, "gruzzorlug_miner");
        registerMerchantTrade(registration, GRUZZORLUG_SWORDSMAN, "gruzzorlug_swordsman");
        registerMerchantTrade(registration, CAPTAIN_MERIK, "captain_merik");
        registerMerchantTrade(registration, DATTICON, "datticon");
        registerMerchantTrade(registration, KAZARI, "kazari");
        registerMerchantTrade(registration, LEORNA, "leorna");
        registerMerchantTrade(registration, LORD_VATTICUS, "lord_vatticus");
        registerMerchantTrade(registration, WAR_GENERAL, "war_general");
        registerMerchantTrade(registration, ZELUS, "zelus");
        registerMerchantTrade(registration, THE_HUNGER, "the_hunger");
        //Information
        registerIngredientInfo(registration, List.of(ItemRegistry.armor_pouch.toStack(),
                ItemRegistry.red_armor_pouch.toStack(),
                ItemRegistry.yellow_armor_pouch.toStack(),
                ItemRegistry.green_armor_pouch.toStack(),
                ItemRegistry.blue_armor_pouch.toStack(),
                ItemRegistry.gray_armor_pouch.toStack()), ItemRegistry.armor_pouch.getId().getPath());
        //TODO: to add lang keys for commented out ones
//        registerIngredientInfo(registration, ItemRegistry.terran_shifter, ItemRegistry.terran_shifter.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.jungle_hook, ItemRegistry.jungle_hook.getId().getPath());
        registerIngredientInfo(registration, ItemRegistry.frozen_clock, ItemRegistry.frozen_clock.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.mysterious_clock, ItemRegistry.mysterious_clock.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.call_of_the_watcher, ItemRegistry.call_of_the_watcher.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.infernal_flame, ItemRegistry.infernal_flame.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.horde_horn, ItemRegistry.horde_horn.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.wizards_book, ItemRegistry.wizards_book.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.dream_flint, ItemRegistry.dream_flint.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.moon_clock, ItemRegistry.moon_clock.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.liopleurodon_skull, ItemRegistry.liopleurodon_skull.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.aquatic_coating_template, ItemRegistry.aquatic_coating_template.getId().getPath());
        registerIngredientInfo(registration, ItemRegistry.collector, ItemRegistry.collector.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.aquamarine, ItemRegistry.aquamarine.getId().getPath());
        registerIngredientInfo(registration, ItemRegistry.firestock, ItemRegistry.firestock.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.hitchak, ItemRegistry.hitchak.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.lamona, ItemRegistry.lamona.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.marsine, ItemRegistry.marsine.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.pinfly, ItemRegistry.pinfly.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.veilo, ItemRegistry.veilo.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.teleportation_star, ItemRegistry.teleportation_star.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.eden_chunk, ItemRegistry.eden_chunk.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.wildwood_chunk, ItemRegistry.wildwood_chunk.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.apalachia_chunk, ItemRegistry.apalachia_chunk.getId().getPath());
//        registerIngredientInfo(registration, ItemRegistry.skythern_chunk, ItemRegistry.skythern_chunk.getId().getPath());
        registerIngredientInfo(registration, ItemRegistry.acid, ItemRegistry.acid.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.aquaTorch, BlockRegistry.aquaTorch.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.icyFire, BlockRegistry.icyFire.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.hellFire, BlockRegistry.hellFire.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.divineFlame, BlockRegistry.divineFlame.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.wildFlame, BlockRegistry.wildFlame.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.enchantedFlame, BlockRegistry.enchantedFlame.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.skyFire, BlockRegistry.skyFire.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.mortumEmbers, BlockRegistry.mortumEmbers.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.rawArcanium, BlockRegistry.rawArcanium.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.proximitySpawner, BlockRegistry.proximitySpawner.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.calcifiedBrain, BlockRegistry.calcifiedBrain.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.sunstormSpawner, BlockRegistry.sunstormSpawner.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.termasectSpawner, BlockRegistry.termasectSpawner.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.eternalArcherSpawner, BlockRegistry.eternalArcherSpawner.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.experiencedCoriSpawner, BlockRegistry.experiencedCoriSpawner.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.encagedCaptainMerik, BlockRegistry.encagedCaptainMerik.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.encagedDatticon, BlockRegistry.encagedDatticon.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.encagedKazari, BlockRegistry.encagedKazari.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.encagedLeorna, BlockRegistry.encagedLeorna.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.encagedLordVatticus, BlockRegistry.encagedLordVatticus.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.encagedWarGeneral, BlockRegistry.encagedWarGeneral.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.encagedZelus, BlockRegistry.encagedZelus.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.dramixAltar, BlockRegistry.dramixAltar.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.parasectaAltar, BlockRegistry.parasectaAltar.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.hiveEgg, BlockRegistry.hiveEgg.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.karosAltar, BlockRegistry.karosAltar.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.lunicAltar, BlockRegistry.lunicAltar.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.quadroticAltar, BlockRegistry.quadroticAltar.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.raglokAltar, BlockRegistry.raglokAltar.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.wreckAltar, BlockRegistry.wreckAltar.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.robbinHut, BlockRegistry.robbinHut.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.crate, BlockRegistry.crate.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.oxcrate, BlockRegistry.oxcrate.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.altarOfCorruption, BlockRegistry.altarOfCorruption.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.booster, BlockRegistry.booster.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.limiter, BlockRegistry.limiter.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.oxdriteRail, BlockRegistry.oxdriteRail.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.oxdriteLamp, BlockRegistry.oxdriteLamp.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.capacitor, BlockRegistry.capacitor.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.gateway, BlockRegistry.gateway.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.miner, BlockRegistry.miner.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.softMiner, BlockRegistry.softMiner.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.placer, BlockRegistry.placer.getId().getPath());
//        registerIngredientInfo(registration, BlockRegistry.acceleron, BlockRegistry.acceleron.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.elevantium, BlockRegistry.elevantium.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.soulTrap, BlockRegistry.soulTrap.getId().getPath());
        registerIngredientInfo(registration, BlockRegistry.nightmareBed, BlockRegistry.nightmareBed.getId().getPath());
    }
    static final RandomSource random = RandomSource.create();
    static void registerMerchantTrade(IRecipeRegistration registration, TradeGetter getter, String profession) {
        Level level = Minecraft.getInstance().level;
        Component name = Component.translatable("entity.divinerpg." + profession);
        DivineTrades[] trades = getter.get(level, random);
        for(DivineTrades trade : trades) trade.name = name;
        registration.addRecipes(MerchantTradeCategory.RECIPE_TYPE, List.of(trades));
    }
    static void registerIngredientInfo(IRecipeRegistration registration, ItemLike item, String description) {
        Component name = Component.translatable("info.divinerpg.jei." + description);
        registration.addIngredientInfo(item, name);
    }
    static void registerIngredientInfo(IRecipeRegistration registration, List<ItemStack> item, String description) {
        Component name = Component.translatable("info.divinerpg.jei." + description);
        registration.addItemStackInfo(item, name);
    }
    @Override public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper helper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new ArcaniumExtractorCategory(helper), new InfusionTableCategory(helper), new SmashingCategory(helper), new FireConversionCategory(helper), new MerchantTradeCategory(helper));
    }
    @Override public void registerIngredients(IModIngredientRegistration registration) {
        registration.register(BLOCK_INGREDIENT_TYPE, List.of(), new BlockIngredientHelper(), new BlockIngredientRenderer(), Block.CODEC.codec());
    }
    @Override public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(ArcaniumExtractorScreen.class, 79, 34, 24, 16, new RecipeType<>(ResourceLocation.fromNamespaceAndPath(MODID, "arcanium_extractor"), RecipeHolder.class));
        registration.addRecipeClickArea(InfusionTableScreen.class, 36, 47, 25, 18, new RecipeType<>(ResourceLocation.fromNamespaceAndPath(MODID, "infusion_table"), RecipeHolder.class));
    }
}