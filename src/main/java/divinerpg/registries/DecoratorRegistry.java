package divinerpg.registries;

import divinerpg.*;
import divinerpg.world.placement.*;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

import java.util.function.*;

public class DecoratorRegistry {
    public static final DeferredRegister<Placement<?>> DECORATORS = DeferredRegister.create(ForgeRegistries.DECORATORS, DivineRPG.MODID);

    public static final RegistryObject<TarLake> TAR_LAKE = register("tar_lake", () -> new TarLake(ChanceConfig.CODEC));
    public static final RegistryObject<VetheaPillars> VETHEA_PILLARS = register("vethea_pillar", () -> new VetheaPillars(ChanceConfig.CODEC));

    private static <T extends Placement<?>> RegistryObject<T> register(final String name, final Supplier<T> sup) {
        return DECORATORS.register(name, sup);
    }
}
