package naturix.divinerpg.registry;

import naturix.divinerpg.bases.liquid.LiquidTar;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class ModLiquids {

    public static final Fluid tar = new LiquidTar().setViscosity(800).setDensity(1153);

    public static void init() {
        FluidRegistry.registerFluid(tar);
        FluidRegistry.addBucketForFluid(tar);
    }

    public static boolean isValidtarStack(FluidStack stack){
        return getFluidFromStack(stack) == tar;
    }

    public static Fluid getFluidFromStack(FluidStack stack){
        return stack == null ? null : stack.getFluid();
    }

    public static String getFluidName(FluidStack stack){
        Fluid fluid = getFluidFromStack(stack);
        return getFluidName(fluid);
    }

    public static String getFluidName(Fluid fluid){
        return fluid == null ? "null" : fluid.getName();
    }

    public static int getAmount(FluidStack stack){
        return stack == null ? 0 : stack.amount;
    }
}