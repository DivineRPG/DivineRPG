package divinerpg.registries;

import divinerpg.*;
import divinerpg.blocks.fluid.*;
import net.minecraft.fluid.*;
import net.minecraft.util.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FluidRegistry {
    public static final FlowingFluid TAR = registerFluid("tar", new FluidTar.Source());
    public static final FlowingFluid TAR_FLOW = registerFluid("tar_flow", new FluidTar.Flowing());

    private static <T extends Fluid> T registerFluid(String key, T fluid) {
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, key);
        fluid.setRegistryName(location);
        return fluid;
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Fluid> registry) {
        registry.getRegistry().registerAll(TAR, TAR_FLOW);
    }

}
