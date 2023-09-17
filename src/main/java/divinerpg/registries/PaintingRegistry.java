package divinerpg.registries;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.*;

import static divinerpg.DivineRPG.MODID;

public class PaintingRegistry {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, MODID);
    public static RegistryObject<PaintingVariant> FALL = PAINTING_VARIANTS.register("fall",()-> new PaintingVariant(32,32));
    public static RegistryObject<PaintingVariant> MOONLIGHT_RAVE = PAINTING_VARIANTS.register("moonlight_rave",()-> new PaintingVariant(32,16));
    public static RegistryObject<PaintingVariant> GRAZING = PAINTING_VARIANTS.register("grazing",()-> new PaintingVariant(16,16));
    public static RegistryObject<PaintingVariant> DISTURBED = PAINTING_VARIANTS.register("disturbed",()-> new PaintingVariant(16,32));
    public static RegistryObject<PaintingVariant> LEVELS = PAINTING_VARIANTS.register("levels",()-> new PaintingVariant(32,32));
    public static RegistryObject<PaintingVariant> ICE_AGE = PAINTING_VARIANTS.register("ice_age",()-> new PaintingVariant(64,64));
    public static RegistryObject<PaintingVariant> CRAWLING = PAINTING_VARIANTS.register("crawling",()-> new PaintingVariant(16,16));
    public static RegistryObject<PaintingVariant> HOWLING_AT_THE_MOON = PAINTING_VARIANTS.register("howling_at_the_moon",()-> new PaintingVariant(64,32));
    public static RegistryObject<PaintingVariant> LURKING_TERROR = PAINTING_VARIANTS.register("lurking_terror",()-> new PaintingVariant(32,32));
}
