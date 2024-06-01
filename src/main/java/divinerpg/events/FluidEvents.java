package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.registries.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FluidEvents {
    @SubscribeEvent public static void register(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> addInteraction(FluidRegistry.SMOLDERING_TAR_FLUID.get().getFluidType()));
    }
    private static void addInteraction(FluidType fluidType) {
        FluidInteractionRegistry.addInteraction(ForgeMod.WATER_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(fluidType, fluidState -> fluidState.isSource() ? Blocks.COBBLESTONE.defaultBlockState() : BlockRegistry.asphalt.get().defaultBlockState()));
        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(fluidType, fluidState -> fluidState.isSource() ? Blocks.BLACKSTONE.defaultBlockState() : Blocks.COBBLED_DEEPSLATE.defaultBlockState()));
        FluidInteractionRegistry.addInteraction(fluidType, new FluidInteractionRegistry.InteractionInformation(ForgeMod.WATER_TYPE.get(), fluidState -> fluidState.isSource() ? BlockRegistry.asphalt.get().defaultBlockState() : Blocks.COBBLESTONE.defaultBlockState()));
        FluidInteractionRegistry.addInteraction(fluidType, new FluidInteractionRegistry.InteractionInformation(ForgeMod.LAVA_TYPE.get(), fluidState -> fluidState.isSource() ? Blocks.COBBLED_DEEPSLATE.defaultBlockState() : Blocks.BLACKSTONE.defaultBlockState()));
    }
}