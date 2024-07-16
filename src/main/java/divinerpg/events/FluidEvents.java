package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.registries.*;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry;
import net.neoforged.neoforge.fluids.FluidType;

@EventBusSubscriber(modid = DivineRPG.MODID, bus = EventBusSubscriber.Bus.MOD)
public class FluidEvents {
    @SubscribeEvent
    public static void register(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> addInteraction(FluidRegistry.SMOLDERING_TAR_FLUID.get().getFluidType()));
    }
    private static void addInteraction(FluidType fluidType) {
        FluidInteractionRegistry.addInteraction(NeoForgeMod.WATER_TYPE.value(), new FluidInteractionRegistry.InteractionInformation(fluidType, fluidState -> fluidState.isSource() ? Blocks.COBBLESTONE.defaultBlockState() : BlockRegistry.asphalt.get().defaultBlockState()));
        FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new FluidInteractionRegistry.InteractionInformation(fluidType, fluidState -> fluidState.isSource() ? Blocks.BLACKSTONE.defaultBlockState() : Blocks.COBBLED_DEEPSLATE.defaultBlockState()));
        FluidInteractionRegistry.addInteraction(fluidType, new FluidInteractionRegistry.InteractionInformation(NeoForgeMod.WATER_TYPE.value(), fluidState -> fluidState.isSource() ? BlockRegistry.asphalt.get().defaultBlockState() : Blocks.COBBLESTONE.defaultBlockState()));
        FluidInteractionRegistry.addInteraction(fluidType, new FluidInteractionRegistry.InteractionInformation(NeoForgeMod.LAVA_TYPE.value(), fluidState -> fluidState.isSource() ? Blocks.COBBLED_DEEPSLATE.defaultBlockState() : Blocks.BLACKSTONE.defaultBlockState()));
    }
}