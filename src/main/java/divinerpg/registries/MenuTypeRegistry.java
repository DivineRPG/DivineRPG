package divinerpg.registries;

import divinerpg.client.menu.*;
import divinerpg.client.screen.*;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MenuTypeRegistry {

    public static final DeferredHolder<MenuType<?>, MenuType<InfusionTableMenu>> INFUSION_TABLE = DivineRegistries.MENUS.register("infusion_table", () -> IMenuTypeExtension.create(InfusionTableMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<ArcaniumExtractorMenu>> ARCANIUM_EXTRACTOR = DivineRegistries.MENUS.register("arcanium_extractor", () -> IMenuTypeExtension.create(ArcaniumExtractorMenu::new));


    @SubscribeEvent
    public static void registerMenuScreensEvent(RegisterMenuScreensEvent event) {
        event.register(MenuTypeRegistry.ARCANIUM_EXTRACTOR.get(), ArcaniumExtractorScreen::new);
//        event.register(MenuTypeRegistry.DREAM_LAMP.get(), DreamLampScreen::new);
        event.register(MenuTypeRegistry.INFUSION_TABLE.get(), InfusionTableScreen::new);
//        event.register(MenuTypeRegistry.ALTAR_OF_CORRUPTION.get(), AltarOfCorruptionScreen::new);
//        event.register(MenuTypeRegistry.PRESENT_BOX.get(), PresentBoxScreen::new);
//        event.register(MenuTypeRegistry.COALSTONE_FURNACE.get(), CoalstoneFurnaceScreen::new);
//        event.register(MenuTypeRegistry.DEMON_FURNACE.get(), DemonFurnaceScreen::new);
//        event.register(MenuTypeRegistry.GREENLIGHT_FURNACE.get(), GreenlightFurnaceScreen::new);
//        event.register(MenuTypeRegistry.MOLTEN_FURNACE.get(), MoltenFurnaceScreen::new);
//        event.register(MenuTypeRegistry.MOONLIGHT_FURNACE.get(), MoonlightFurnaceScreen::new);
//        event.register(MenuTypeRegistry.OCEANFIRE_FURNACE.get(), OceanfireFurnaceScreen::new);
//        event.register(MenuTypeRegistry.WHITEFIRE_FURNACE.get(), WhitefireFurnaceScreen::new);
//        event.register(MenuTypeRegistry.BONE_CHEST.get(), BoneChestScreen::new);
//        event.register(MenuTypeRegistry.FROSTED_CHEST.get(), FrostedChestScreen::new);
    }

    public static void load() {}
}
