package divinerpg.compat.jei;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import divinerpg.DivineRPG;
import divinerpg.compat.jei.base.SmelterCategory;
import divinerpg.compat.jei.base.TripleRecipeWrapper;
import divinerpg.compat.jei.base.VillagerCategory;
import divinerpg.objects.blocks.tile.container.gui.ArcaniumExtractorGUI;
import divinerpg.objects.entities.container.gui.*;
import divinerpg.objects.entities.entity.arcana.*;
import divinerpg.objects.entities.entity.iceika.EntityWorkshopMerchant;
import divinerpg.objects.entities.entity.iceika.EntityWorkshopTinkerer;
import divinerpg.objects.entities.entity.vanilla.EntityJackOMan;
import divinerpg.objects.entities.entity.vanilla.EntityLivestockMerchant;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import divinerpg.utils.MessageLocalizer;

@JEIPlugin
public class JEICompat implements IModPlugin {

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();

        registry.addRecipeCategories(new VillagerCategory(guiHelper,
                GuiJackOMan.MERCHANT_GUI_TEXTURE,
                JeiReferences.JACK_O_MAN_CATEGORY,
                MessageLocalizer.normal("entity.divinerpg.jack_o_man.name"),
                ModItems.scythe));

        registry.addRecipeCategories(new VillagerCategory(guiHelper,
                GuiWorkshopMerchant.MERCHANT_GUI_TEXTURE,
                JeiReferences.WORKSHOP_MERCHANT_CATEGORY,
                MessageLocalizer.normal("entity.divinerpg.workshop_merchant.name"),
                ModItems.santaCap));

        registry.addRecipeCategories(new VillagerCategory(guiHelper,
                GuiWorkshopTinkerer.MERCHANT_GUI_TEXTURE,
                JeiReferences.WORKSHOP_TINKERER_CATEGORY,
                MessageLocalizer.normal("entity.divinerpg.workshop_tinkerer.name"),
                ModItems.frossivence));

        registry.addRecipeCategories(new VillagerCategory(guiHelper,
                GuiCaptainMerik.MERCHANT_GUI_TEXTURE,
                JeiReferences.CAPITAIN_MERIC_CATEGORY,
                MessageLocalizer.normal("entity.divinerpg.captain_merik.name"),
                ModItems.starlight));

        registry.addRecipeCategories(new VillagerCategory(guiHelper,
                GuiLivestockMerchant.MERCHANT_GUI_TEXTURE,
                JeiReferences.LIVESTOCK_MERCHANT_CATEGORY,
                MessageLocalizer.normal("entity.divinerpg.livestock_merchant.name"),
                ModItems.shadowCoins));

        registry.addRecipeCategories(new VillagerCategory(guiHelper,
                GuiWarGeneral.MERCHANT_GUI_TEXTURE,
                JeiReferences.WAR_GENERAL_CATEGORY,
                MessageLocalizer.normal("entity.divinerpg.war_general.name"),
                ModItems.arcaniteBlaster));

        registry.addRecipeCategories(new VillagerCategory(guiHelper,
                GuiLeorna.MERCHANT_GUI_TEXTURE,
                JeiReferences.LEORNA_CATEGORY,
                MessageLocalizer.normal("entity.divinerpg.leorna.name"),
                ModItems.firestockSeeds));

        registry.addRecipeCategories(new VillagerCategory(guiHelper,
                GuiDatticon.MERCHANT_GUI_TEXTURE,
                JeiReferences.DATTICON_CATEGORY,
                MessageLocalizer.normal("entity.divinerpg.datticon.name"),
                new ItemStack(ModBlocks.demonFurnace)));

        registry.addRecipeCategories(new VillagerCategory(guiHelper,
                GuiLordVatticus.MERCHANT_GUI_TEXTURE,
                JeiReferences.LORD_VATTICUS_CATEGORY,
                MessageLocalizer.normal("entity.divinerpg.lord_vatticus.name"),
                ModItems.strongArcanaPotion));

        registry.addRecipeCategories(new VillagerCategory(guiHelper,
                GuiZelus.MERCHANT_GUI_TEXTURE,
                JeiReferences.ZELUS_CATEGORY,
                MessageLocalizer.normal("entity.divinerpg.zelus.name"),
                ModItems.golemOfRejuvenationSpawner));

        registry.addRecipeCategories(new SmelterCategory(guiHelper,
                ArcaniumExtractorGUI.TEXTURES,
                JeiReferences.ARCANA_EXTRACTOR_CATEGORY,
                "Arcanium Extractor",
                new ItemStack(ModItems.chargedCollector)));
    }

    @Override
    public void register(IModRegistry registry) {
        DivineRPG.logger.info("Registering JEI compat");

        registerVillagerRecepies(registry, EntityJackOMan.getAllRecipies(), JeiReferences.JACK_O_MAN_CATEGORY);
        registerVillagerRecepies(registry, EntityWorkshopMerchant.getAllRecipies(), JeiReferences.WORKSHOP_MERCHANT_CATEGORY);
        registerVillagerRecepies(registry, EntityWorkshopTinkerer.getAllRecipies(), JeiReferences.WORKSHOP_TINKERER_CATEGORY);
        registerVillagerRecepies(registry, EntityCaptainMerik.getAllRecipies(), JeiReferences.CAPITAIN_MERIC_CATEGORY);
        registerVillagerRecepies(registry, EntityLivestockMerchant.getAllRecipies(), JeiReferences.LIVESTOCK_MERCHANT_CATEGORY);
        registerVillagerRecepies(registry, EntityWarGeneral.getAllRecipies(), JeiReferences.WAR_GENERAL_CATEGORY);
        registerVillagerRecepies(registry, EntityLeorna.getAllRecipies(), JeiReferences.LEORNA_CATEGORY);
        registerVillagerRecepies(registry, EntityDatticon.getAllRecipies(), JeiReferences.DATTICON_CATEGORY);
        registerVillagerRecepies(registry, EntityLordVatticus.getAllRecipies(), JeiReferences.LORD_VATTICUS_CATEGORY);
        registerVillagerRecepies(registry, EntityZelus.getAllRecipies(), JeiReferences.ZELUS_CATEGORY);
        registry.addRecipes(Arrays.asList(new TripleRecipeWrapper(new ItemStack(ModBlocks.arcaniumOre),
                new ItemStack(ModItems.chargedCollector), new ItemStack(ModItems.arcanium))), JeiReferences.ARCANA_EXTRACTOR_CATEGORY);

        registry.addRecipeCatalyst(new ItemStack(ModBlocks.demonFurnace), VanillaRecipeCategoryUid.SMELTING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.greenlightFurnace), VanillaRecipeCategoryUid.SMELTING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.moltenFurnace), VanillaRecipeCategoryUid.SMELTING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.moonlightFurnace), VanillaRecipeCategoryUid.SMELTING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.whitefireFurnace), VanillaRecipeCategoryUid.SMELTING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.coalstoneFurnace), VanillaRecipeCategoryUid.SMELTING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.oceanfireFurnace), VanillaRecipeCategoryUid.SMELTING);

        registry.addRecipeCatalyst(new ItemStack(ModBlocks.arcaniumExtractor), JeiReferences.ARCANA_EXTRACTOR_CATEGORY);
    }

    private void registerVillagerRecepies(IModRegistry registry, List<MerchantRecipe> receipes, String name){
        registry.addRecipes(receipes
        .stream()
                .map(TripleRecipeWrapper::new)
        .collect(Collectors.toList()), name);
    }
}