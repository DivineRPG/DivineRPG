package divinerpg.registries;

import divinerpg.*;
import divinerpg.world.surface.*;
import net.minecraft.world.gen.surfacebuilders.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

public class BuilderRegistry {
    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, DivineRPG.MODID);
    public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> ICEIKA = SURFACE_BUILDERS.register("iceika", () -> new IceikaSurfaceBuilder(SurfaceBuilderConfig.CODEC));

}
