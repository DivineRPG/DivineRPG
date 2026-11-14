package divinerpg.registries;

import divinerpg.client.menu.*;
import divinerpg.client.screen.*;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MenuTypeRegistry {
    public static final DeferredHolder<MenuType<?>, MenuType<DreamLampMenu>> DREAM_LAMP = DivineRegistries.MENUS.register("dream_lamp", () -> IMenuTypeExtension.create(DreamLampMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<InfusionTableMenu>> INFUSION_TABLE = DivineRegistries.MENUS.register("infusion_table", () -> IMenuTypeExtension.create(InfusionTableMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<AltarOfCorruptionMenu>> ALTAR_OF_CORRUPTION = DivineRegistries.MENUS.register("altar_of_corruption", () -> IMenuTypeExtension.create(AltarOfCorruptionMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<ArcaniumExtractorMenu>> ARCANIUM_EXTRACTOR = DivineRegistries.MENUS.register("arcanium_extractor", () -> IMenuTypeExtension.create(ArcaniumExtractorMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<CoalstoneFurnaceMenu>> COALSTONE_FURNACE = DivineRegistries.MENUS.register("coalstone_furnace", () -> IMenuTypeExtension.create(CoalstoneFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<MoltenFurnaceMenu>> MOLTEN_FURNACE = DivineRegistries.MENUS.register("molten_furnace", () -> IMenuTypeExtension.create(MoltenFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<GreenlightFurnaceMenu>> GREENLIGHT_FURNACE = DivineRegistries.MENUS.register("greenlight_furnace", () -> IMenuTypeExtension.create(GreenlightFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<OceanfireFurnaceMenu>> OCEANFIRE_FURNACE = DivineRegistries.MENUS.register("oceanfire_furnace", () -> IMenuTypeExtension.create(OceanfireFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<MoonlightFurnaceMenu>> MOONLIGHT_FURNACE = DivineRegistries.MENUS.register("moonlight_furnace", () -> IMenuTypeExtension.create(MoonlightFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<WhitefireFurnaceMenu>> WHITEFIRE_FURNACE = DivineRegistries.MENUS.register("whitefire_furnace", () -> IMenuTypeExtension.create(WhitefireFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<DemonFurnaceMenu>> DEMON_FURNACE = DivineRegistries.MENUS.register("demon_furnace", () -> IMenuTypeExtension.create(DemonFurnaceMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<BoneChestMenu>> BONE_CHEST = DivineRegistries.MENUS.register("bone_chest", () -> IMenuTypeExtension.create(BoneChestMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<FrostedChestMenu>> FROSTED_CHEST = DivineRegistries.MENUS.register("frosted_chest", () -> IMenuTypeExtension.create(FrostedChestMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<PresentBoxMenu>> PRESENT_BOX = DivineRegistries.MENUS.register("present_box", () -> IMenuTypeExtension.create(PresentBoxMenu::new));

    @SubscribeEvent
    public static void registerMenuScreensEvent(RegisterMenuScreensEvent event) {
        event.register(MenuTypeRegistry.ARCANIUM_EXTRACTOR.get(), ArcaniumExtractorScreen::new);
        event.register(MenuTypeRegistry.DREAM_LAMP.get(), DreamLampScreen::new);
        event.register(MenuTypeRegistry.INFUSION_TABLE.get(), InfusionTableScreen::new);
        event.register(MenuTypeRegistry.ALTAR_OF_CORRUPTION.get(), AltarOfCorruptionScreen::new);
        event.register(MenuTypeRegistry.PRESENT_BOX.get(), PresentBoxScreen::new);
        event.register(MenuTypeRegistry.COALSTONE_FURNACE.get(), CoalstoneFurnaceScreen::new);
        event.register(MenuTypeRegistry.DEMON_FURNACE.get(), DemonFurnaceScreen::new);
        event.register(MenuTypeRegistry.GREENLIGHT_FURNACE.get(), GreenlightFurnaceScreen::new);
        event.register(MenuTypeRegistry.MOLTEN_FURNACE.get(), MoltenFurnaceScreen::new);
        event.register(MenuTypeRegistry.MOONLIGHT_FURNACE.get(), MoonlightFurnaceScreen::new);
        event.register(MenuTypeRegistry.OCEANFIRE_FURNACE.get(), OceanfireFurnaceScreen::new);
        event.register(MenuTypeRegistry.WHITEFIRE_FURNACE.get(), WhitefireFurnaceScreen::new);
        event.register(MenuTypeRegistry.BONE_CHEST.get(), BoneChestScreen::new);
        event.register(MenuTypeRegistry.FROSTED_CHEST.get(), FrostedChestScreen::new);
    }
    public static void load() {}
}