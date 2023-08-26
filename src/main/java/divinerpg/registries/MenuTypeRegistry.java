package divinerpg.registries;

import divinerpg.*;
import divinerpg.client.containers.*;
import divinerpg.client.containers.screen.*;
import net.minecraftforge.common.extensions.*;
import net.minecraftforge.registries.*;


import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;

import static divinerpg.DivineRPG.MODID;

public class MenuTypeRegistry
{
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MODID);
    public static final RegistryObject<MenuType<ArcaniumExtractorContainer>> ARCANIUM_EXTRACTOR = CONTAINERS.register("arcanium_extractor", () -> IForgeMenuType.create(ArcaniumExtractorContainer::new));
    public static final RegistryObject<MenuType<DreamLampContainer>> DREAM_LAMP = CONTAINERS.register("dream_lamp", () -> IForgeMenuType.create(DreamLampContainer::new));
    public static final RegistryObject<MenuType<InfusionTableContainer>> INFUSION_TABLE = CONTAINERS.register("infusion_table", () -> IForgeMenuType.create(InfusionTableContainer::new));
    public static final RegistryObject<MenuType<AltarOfCorruptionMenu>> ALTAR_OF_CORRUPTION = CONTAINERS.register("altar_of_corruption", () -> IForgeMenuType.create(AltarOfCorruptionMenu::new));
    public static final RegistryObject<MenuType<PresentBoxContainer>> PRESENT_BOX = CONTAINERS.register("present_box", () -> IForgeMenuType.create(PresentBoxContainer::new));
    public static final RegistryObject<MenuType<CoalstoneFurnaceContainer>> COALSTONE_FURNACE = CONTAINERS.register("coalstone_furnace", () -> IForgeMenuType.create(CoalstoneFurnaceContainer::new));
    public static final RegistryObject<MenuType<DemonFurnaceContainer>> DEMON_FURNACE = CONTAINERS.register("demon_furnace", () -> IForgeMenuType.create(DemonFurnaceContainer::new));
    public static final RegistryObject<MenuType<GreenlightFurnaceContainer>> GREENLIGHT_FURNACE = CONTAINERS.register("greenlight_furnace", () -> IForgeMenuType.create(GreenlightFurnaceContainer::new));
    public static final RegistryObject<MenuType<MoltenFurnaceContainer>> MOLTEN_FURNACE = CONTAINERS.register("molten_furnace", () -> IForgeMenuType.create(MoltenFurnaceContainer::new));
    public static final RegistryObject<MenuType<MoonlightFurnaceContainer>> MOONLIGHT_FURNACE = CONTAINERS.register("moonlight_furnace", () -> IForgeMenuType.create(MoonlightFurnaceContainer::new));
    public static final RegistryObject<MenuType<OceanfireFurnaceContainer>> OCEANFIRE_FURNACE = CONTAINERS.register("oceanfire_furnace", () -> IForgeMenuType.create(OceanfireFurnaceContainer::new));
    public static final RegistryObject<MenuType<WhitefireFurnaceContainer>> WHITEFIRE_FURNACE = CONTAINERS.register("whitefire_furnace", () -> IForgeMenuType.create(WhitefireFurnaceContainer::new));

    public static void registerScreenFactories() {
        DivineRPG.LOGGER.info("[DivineRPG] Registered screens");
        MenuScreens.register(MenuTypeRegistry.ARCANIUM_EXTRACTOR.get(), ArcaniumExtractorScreen::new);
        MenuScreens.register(MenuTypeRegistry.DREAM_LAMP.get(), DreamLampScreen::new);
        MenuScreens.register(MenuTypeRegistry.INFUSION_TABLE.get(), InfusionTableScreen::new);
        MenuScreens.register(MenuTypeRegistry.ALTAR_OF_CORRUPTION.get(), AltarOfCorruptionScreen::new);
        MenuScreens.register(MenuTypeRegistry.PRESENT_BOX.get(), PresentBoxScreen::new);
        MenuScreens.register(MenuTypeRegistry.COALSTONE_FURNACE.get(), CoalstoneFurnaceScreen::new);
        MenuScreens.register(MenuTypeRegistry.DEMON_FURNACE.get(), DemonFurnaceScreen::new);
        MenuScreens.register(MenuTypeRegistry.GREENLIGHT_FURNACE.get(), GreenlightFurnaceScreen::new);
        MenuScreens.register(MenuTypeRegistry.MOLTEN_FURNACE.get(), MoltenFurnaceScreen::new);
        MenuScreens.register(MenuTypeRegistry.MOONLIGHT_FURNACE.get(), MoonlightFurnaceScreen::new);
        MenuScreens.register(MenuTypeRegistry.OCEANFIRE_FURNACE.get(), OceanfireFurnaceScreen::new);
        MenuScreens.register(MenuTypeRegistry.WHITEFIRE_FURNACE.get(), WhitefireFurnaceScreen::new);
    }
}
