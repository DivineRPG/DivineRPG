package divinerpg.registries;

import divinerpg.*;
import net.minecraft.fluid.*;
import net.minecraft.util.*;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

public class FluidRegistry {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, DivineRPG.MODID);

    public static final ResourceLocation TAR_STILL_RL = new ResourceLocation(DivineRPG.MODID,
            "blocks/liquid_tar_still");
    public static final ResourceLocation TAR_FLOW_RL = new ResourceLocation(DivineRPG.MODID,
            "blocks/liquid_tar_flow");

    public static final RegistryObject<ForgeFlowingFluid.Source> TAR = FLUIDS.register("smoldering_tar",
            () -> new ForgeFlowingFluid.Source(tarProperties()));

    public static final RegistryObject<ForgeFlowingFluid.Flowing> TAR_FLOW = FLUIDS.register("smoldering_tar_flow",
            () -> new ForgeFlowingFluid.Flowing(tarProperties()));


    private static ForgeFlowingFluid.Properties tarProperties() {
        return new ForgeFlowingFluid.Properties(TAR, TAR_FLOW,
                FluidAttributes.builder(TAR_STILL_RL, TAR_FLOW_RL).overlay(TAR_STILL_RL).color(0xFF79CFD2)
                        .density(1153).viscosity(8000).temperature(1100).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA))
                .bucket(() ->ItemRegistry.smolderingTarBucket).block(() -> BlockRegistry.smolderingTar).explosionResistance(1000F).tickRate(9);
    }

}
