package divinerpg.registry;

import divinerpg.api.Reference;
import divinerpg.objects.liquid.FluidLiquid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModLiquids {

    public static Fluid tar = new FluidLiquid("tar",
            new ResourceLocation(Reference.MODID, "blocks/liquid_tar_still"),
            new ResourceLocation(Reference.MODID, "blocks/liquid_tar_flow"))
            // more than lava
            .setViscosity(8000)
            // a bit colder than lava
            .setTemperature(1100)
            .setDensity(1153);


    public static void registerFluids(){
        registerFluid(tar);
    }

    public static void registerFluid(Fluid fluid){
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }
}