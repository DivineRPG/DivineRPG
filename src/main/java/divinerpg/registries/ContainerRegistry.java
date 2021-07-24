package divinerpg.registries;

import divinerpg.*;
import divinerpg.containers.*;
import divinerpg.containers.screen.*;
import net.minecraft.client.gui.*;
import net.minecraft.inventory.container.*;
import net.minecraftforge.common.extensions.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;


public class ContainerRegistry
{
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, DivineRPG.MODID);

    public static final RegistryObject<ContainerType<ArcaniumExtractorContainer>> ARCANIUM_EXTRACTOR = CONTAINER_TYPES.register("arcanium_extractor", () -> IForgeContainerType.create(ArcaniumExtractorContainer::new));


    public static void registerScreenFactories() {
        ScreenManager.register(ContainerRegistry.ARCANIUM_EXTRACTOR.get(), ArcaniumExtractorScreen::new);
    }
}
