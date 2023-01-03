package divinerpg.events;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FluidEvents {

    @SubscribeEvent
    public static void register(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            addInteraction(ForgeRegistries.FLUID_TYPES.get().getValue(new ResourceLocation(DivineRPG.MODID, "smoldering_tar_fluid_type")));
        });
    }

    private static void addInteraction(FluidType fluidType) {
        FluidInteractionRegistry.addInteraction(ForgeMod.WATER_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(fluidType, fluidState -> fluidState.isSource() ? Blocks.STONE.defaultBlockState() : ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "asphalt")).defaultBlockState()));
    }
}