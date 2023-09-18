package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.client.menu.*;
import divinerpg.client.screen.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.*;

import static divinerpg.DivineRPG.MODID;

public class MenuTypeRegistry
{
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MODID);
    public static final RegistryObject<MenuType<ArcaniumExtractorMenu>> ARCANIUM_EXTRACTOR = CONTAINERS.register("arcanium_extractor", () -> IForgeMenuType.create(ArcaniumExtractorMenu::new));
    public static final RegistryObject<MenuType<DreamLampMenu>> DREAM_LAMP = CONTAINERS.register("dream_lamp", () -> IForgeMenuType.create(DreamLampMenu::new));
    public static final RegistryObject<MenuType<InfusionTableMenu>> INFUSION_TABLE = CONTAINERS.register("infusion_table", () -> IForgeMenuType.create(InfusionTableMenu::new));
    public static final RegistryObject<MenuType<AltarOfCorruptionMenu>> ALTAR_OF_CORRUPTION = CONTAINERS.register("altar_of_corruption", () -> IForgeMenuType.create(AltarOfCorruptionMenu::new));
    public static final RegistryObject<MenuType<PresentBoxMenu>> PRESENT_BOX = CONTAINERS.register("present_box", () -> IForgeMenuType.create(PresentBoxMenu::new));
    public static final RegistryObject<MenuType<CoalstoneFurnaceMenu>> COALSTONE_FURNACE = CONTAINERS.register("coalstone_furnace", () -> IForgeMenuType.create(CoalstoneFurnaceMenu::new));
    public static final RegistryObject<MenuType<DemonFurnaceMenu>> DEMON_FURNACE = CONTAINERS.register("demon_furnace", () -> IForgeMenuType.create(DemonFurnaceMenu::new));
    public static final RegistryObject<MenuType<GreenlightFurnaceMenu>> GREENLIGHT_FURNACE = CONTAINERS.register("greenlight_furnace", () -> IForgeMenuType.create(GreenlightFurnaceMenu::new));
    public static final RegistryObject<MenuType<MoltenFurnaceMenu>> MOLTEN_FURNACE = CONTAINERS.register("molten_furnace", () -> IForgeMenuType.create(MoltenFurnaceMenu::new));
    public static final RegistryObject<MenuType<MoonlightFurnaceMenu>> MOONLIGHT_FURNACE = CONTAINERS.register("moonlight_furnace", () -> IForgeMenuType.create(MoonlightFurnaceMenu::new));
    public static final RegistryObject<MenuType<OceanfireFurnaceMenu>> OCEANFIRE_FURNACE = CONTAINERS.register("oceanfire_furnace", () -> IForgeMenuType.create(OceanfireFurnaceMenu::new));
    public static final RegistryObject<MenuType<WhitefireFurnaceMenu>> WHITEFIRE_FURNACE = CONTAINERS.register("whitefire_furnace", () -> IForgeMenuType.create(WhitefireFurnaceMenu::new));
    public static final RegistryObject<MenuType<BoneChestMenu>> BONE_CHEST = CONTAINERS.register("bone_chest", () -> IForgeMenuType.create(BoneChestMenu::new));
    public static final RegistryObject<MenuType<FrostedChestMenu>> FROSTED_CHEST = CONTAINERS.register("frosted_chest", () -> IForgeMenuType.create(FrostedChestMenu::new));

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
        MenuScreens.register(MenuTypeRegistry.BONE_CHEST.get(), BoneChestScreen::new);
        MenuScreens.register(MenuTypeRegistry.FROSTED_CHEST.get(), FrostedChestScreen::new);
    }
}
