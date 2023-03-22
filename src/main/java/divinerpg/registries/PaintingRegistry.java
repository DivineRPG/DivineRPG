package divinerpg.registries;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.*;

import static divinerpg.DivineRPG.MODID;

public class PaintingRegistry {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, MODID);
    public static RegistryObject<PaintingVariant> ISLAND = PAINTING_VARIANTS.register("island",()-> new PaintingVariant(64,64));
    public static RegistryObject<PaintingVariant> HILL = PAINTING_VARIANTS.register("hill",()-> new PaintingVariant(64,64));
    public static RegistryObject<PaintingVariant> EDEN = PAINTING_VARIANTS.register("eden",()-> new PaintingVariant(32,32));
    public static RegistryObject<PaintingVariant> MONSTER = PAINTING_VARIANTS.register("monster",()-> new PaintingVariant(32,32));
    public static RegistryObject<PaintingVariant> CAVE = PAINTING_VARIANTS.register("cave",()-> new PaintingVariant(32,32));
    public static RegistryObject<PaintingVariant> PINK_ELEPHANT = PAINTING_VARIANTS.register("pink_elephant",()-> new PaintingVariant(96,96));
}
