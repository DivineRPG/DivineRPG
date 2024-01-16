package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.client.menu.*;
import divinerpg.client.screen.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.*;

import static divinerpg.DivineRPG.MODID;

public class MenuTypeRegistry
{
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(BuiltInRegistries.MENU, MODID);
    public static final DeferredHolder<MenuType<?>, MenuType<ArcaniumExtractorMenu>> ARCANIUM_EXTRACTOR = CONTAINERS.register("arcanium_extractor", () -> IMenuTypeExtension.create(ArcaniumExtractorMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<DreamLampMenu>> DREAM_LAMP = CONTAINERS.register("dream_lamp", () -> IMenuTypeExtension.create(DreamLampMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<InfusionTableMenu>> INFUSION_TABLE = CONTAINERS.register("infusion_table", () -> IMenuTypeExtension.create(InfusionTableMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<AltarOfCorruptionMenu>> ALTAR_OF_CORRUPTION = CONTAINERS.register("altar_of_corruption", () -> IMenuTypeExtension.create(AltarOfCorruptionMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<PresentBoxMenu>> PRESENT_BOX = CONTAINERS.register("present_box", () -> IMenuTypeExtension.create(PresentBoxMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<CoalstoneFurnaceMenu>> COALSTONE_FURNACE = CONTAINERS.register("coalstone_furnace", () -> IMenuTypeExtension.create(CoalstoneFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<DemonFurnaceMenu>> DEMON_FURNACE = CONTAINERS.register("demon_furnace", () -> IMenuTypeExtension.create(DemonFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<GreenlightFurnaceMenu>> GREENLIGHT_FURNACE = CONTAINERS.register("greenlight_furnace", () -> IMenuTypeExtension.create(GreenlightFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<MoltenFurnaceMenu>> MOLTEN_FURNACE = CONTAINERS.register("molten_furnace", () -> IMenuTypeExtension.create(MoltenFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<MoonlightFurnaceMenu>> MOONLIGHT_FURNACE = CONTAINERS.register("moonlight_furnace", () -> IMenuTypeExtension.create(MoonlightFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<OceanfireFurnaceMenu>> OCEANFIRE_FURNACE = CONTAINERS.register("oceanfire_furnace", () -> IMenuTypeExtension.create(OceanfireFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<WhitefireFurnaceMenu>> WHITEFIRE_FURNACE = CONTAINERS.register("whitefire_furnace", () -> IMenuTypeExtension.create(WhitefireFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<BoneChestMenu>> BONE_CHEST = CONTAINERS.register("bone_chest", () -> IMenuTypeExtension.create(BoneChestMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<FrostedChestMenu>> FROSTED_CHEST = CONTAINERS.register("frosted_chest", () -> IMenuTypeExtension.create(FrostedChestMenu::new));

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
