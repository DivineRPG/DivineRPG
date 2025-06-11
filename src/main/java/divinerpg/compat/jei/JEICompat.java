package divinerpg.compat.jei;

import blusunrize.immersiveengineering.api.crafting.CokeOvenRecipe;
import blusunrize.immersiveengineering.api.crafting.IERecipeTypes;
import blusunrize.immersiveengineering.client.gui.*;
import blusunrize.immersiveengineering.common.util.compat.jei.FluidSorterGhostHandler;
import blusunrize.immersiveengineering.common.util.compat.jei.IEGhostItemHandler;
import blusunrize.immersiveengineering.common.util.compat.jei.JEIRecipeTypes;
import divinerpg.DivineRPG;
import divinerpg.client.screen.ArcaniumExtractorScreen;
import divinerpg.client.screen.InfusionTableScreen;
import divinerpg.compat.jei.brewing.PotionRecipe;
import divinerpg.compat.jei.category.*;
import divinerpg.compat.jei.ingredient.*;
import divinerpg.entities.base.EntityDivineMerchant.DivineTrades;
import divinerpg.recipe.ArcaniumExtractorRecipe;
import divinerpg.registries.*;
import divinerpg.registries.RecipeRegistry.*;
import mezz.jei.api.*;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.*;

import static divinerpg.registries.BlockRegistry.*;

@JeiPlugin
public class JEICompat implements IModPlugin {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "jei_plugin");
    public static final IIngredientType<Block> BLOCK_INGREDIENT_TYPE = () -> Block.class;
    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalysts(RecipeTypes.SMELTING, Ingredient.of(TagRegistry.FURNACES).getItems());

        registration.addRecipeCatalysts(SmashingCategory.RECIPE_TYPE, Ingredient.of(TagRegistry.MAULS).getItems());
        registration.addRecipeCatalyst(arcaniumExtractor, ArcaniumExtractorCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(infusionTable, InfusionTableCategory.RECIPE_TYPE);
    }
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Minecraft.getInstance().level.getRecipeManager();

        registration.addRecipes(ArcaniumExtractorCategory.RECIPE_TYPE, manager.getAllRecipesFor(Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE.get()));
        registration.addRecipes(InfusionTableCategory.RECIPE_TYPE, manager.getAllRecipesFor(Types.INFUSIION_TABLE_RECIPE_TYPE.get()));
        registration.addRecipes(SmashingCategory.RECIPE_TYPE, manager.getAllRecipesFor(Types.MAUL_SMASHING.get()));
        registration.addRecipes(FireConversionCategory.RECIPE_TYPE, manager.getAllRecipesFor(Types.FIRE_CONVERSION.get()));

        registration.addRecipes(RecipeTypes.BREWING, List.of(
                new PotionRecipe(Items.POTION, Potions.AWKWARD, PotionRegistry.GROG, 2, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "brewing.grog.regular"), ItemRegistry.cauldron_flesh.toStack()),
                new PotionRecipe(Items.SPLASH_POTION, Potions.AWKWARD, PotionRegistry.GROG, 3, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "brewing.grog.splash"), ItemRegistry.cauldron_flesh.toStack()),
                new PotionRecipe(Items.LINGERING_POTION, Potions.AWKWARD, PotionRegistry.GROG, 4, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "brewing.grog.lingering"), ItemRegistry.cauldron_flesh.toStack()),
                new PotionRecipe(Items.POTION, PotionRegistry.TEA, PotionRegistry.WARMTH, 2, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "brewing.warmth.regular"), ItemRegistry.olivine.toStack()),
                new PotionRecipe(Items.SPLASH_POTION, PotionRegistry.TEA, PotionRegistry.WARMTH, 3, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "brewing.warmth.splash"), ItemRegistry.olivine.toStack()),
                new PotionRecipe(Items.LINGERING_POTION, PotionRegistry.TEA, PotionRegistry.WARMTH, 4, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "brewing.warmth.lingering"), ItemRegistry.olivine.toStack()),
                new PotionRecipe(Items.POTION, Potions.WATER, PotionRegistry.TEA, 1, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "brewing.tea.regular"), ItemRegistry.winterberry.toStack(), Items.SWEET_BERRIES.getDefaultInstance()),
                new PotionRecipe(Items.SPLASH_POTION, Potions.WATER, PotionRegistry.TEA, 2, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "brewing.tea.splash"), ItemRegistry.winterberry.toStack(), Items.SWEET_BERRIES.getDefaultInstance()),
                new PotionRecipe(Items.LINGERING_POTION, Potions.WATER, PotionRegistry.TEA, 3, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "brewing.tea.lingering"), ItemRegistry.winterberry.toStack(), Items.SWEET_BERRIES.getDefaultInstance())
        ));

        registerMerchantTrade(registration, Trades.LIVESTOCK_MERCHANT, "livestock_merchant");
        registerMerchantTrade(registration, Trades.JACK_O_MAN, "jack_o_man");
        registerMerchantTrade(registration, Trades.DIAMOND_DAVE, "diamond_dave");
        registerMerchantTrade(registration, Trades.WORKSHOP_MERCHANT, "workshop_merchant");
        registerMerchantTrade(registration, Trades.WORKSHOP_TINKERER, "workshop_tinkerer");
        registerMerchantTrade(registration, Trades.GROGLIN_CHIEFTAIN, "groglin_chieftain");
        registerMerchantTrade(registration, Trades.GROGLIN_HUNTER, "groglin_hunter");
        registerMerchantTrade(registration, Trades.GROGLIN_MERCHANT, "groglin_merchant");
        registerMerchantTrade(registration, Trades.GROGLIN_RANGER, "groglin_ranger");
        registerMerchantTrade(registration, Trades.GROGLIN_SHARLATAN, "groglin_sharlatan");
        registerMerchantTrade(registration, Trades.GROGLIN_WARRIOR, "groglin_warrior");
        registerMerchantTrade(registration, Trades.GRUZZORLUG_CANNONEER, "gruzzorlug_cannoneer");
        registerMerchantTrade(registration, Trades.GRUZZORLUG_COMMANDER, "gruzzorlug_commander");
        registerMerchantTrade(registration, Trades.GRUZZORLUG_GENERAL, "gruzzorlug_general");
        registerMerchantTrade(registration, Trades.GRUZZORLUG_KNIGHT, "gruzzorlug_knight");
        registerMerchantTrade(registration, Trades.GRUZZORLUG_MINER, "gruzzorlug_miner");
        registerMerchantTrade(registration, Trades.GRUZZORLUG_SWORDSMAN, "gruzzorlug_swordsman");
        registerMerchantTrade(registration, Trades.CAPTAIN_MERIK, "captain_merik");
        registerMerchantTrade(registration, Trades.DATTICON, "datticon");
        registerMerchantTrade(registration, Trades.KAZARI, "kazari");
        registerMerchantTrade(registration, Trades.LEORNA, "leorna");
        registerMerchantTrade(registration, Trades.LORD_VATTICUS, "lord_vatticus");
        registerMerchantTrade(registration, Trades.WAR_GENERAL, "war_general");
        registerMerchantTrade(registration, Trades.ZELUS, "zelus");
        registerMerchantTrade(registration, Trades.THE_HUNGER, "the_hunger");
    }
    static final RandomSource random = RandomSource.create();
    static void registerMerchantTrade(IRecipeRegistration registration, Trades.TradeGetter getter, String profession) {
        Level level = Minecraft.getInstance().level;
        Component name = Component.translatable("entity.divinerpg." + profession);
        DivineTrades[] trades = getter.get(level, random);
        for(DivineTrades trade : trades) trade.name = name;
        registration.addRecipes(MerchantTradeCategory.RECIPE_TYPE, List.of(trades));
    }
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper helper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new ArcaniumExtractorCategory(helper), new InfusionTableCategory(helper), new SmashingCategory(helper), new FireConversionCategory(helper), new MerchantTradeCategory(helper));
    }
    @Override
    public void registerIngredients(IModIngredientRegistration registration) {
        registration.register(BLOCK_INGREDIENT_TYPE, List.of(), new BlockIngredientHelper(), new BlockIngredientRenderer(), Block.CODEC.codec());
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration)
    {
        registration.addRecipeClickArea(ArcaniumExtractorScreen.class, 79, 34, 24, 16, new RecipeType<>(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "arcanium_extractor"), (Class)RecipeHolder.class));
        registration.addRecipeClickArea(InfusionTableScreen.class, 36, 47, 25, 18, new RecipeType<>(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "infusion_table"), (Class)RecipeHolder.class));
    }

}