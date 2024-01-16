package divinerpg.registries;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.neoforged.neoforge.registries.*;

import static divinerpg.DivineRPG.MODID;

public class PaintingRegistry {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(BuiltInRegistries.PAINTING_VARIANT, MODID);
    public static DeferredHolder<PaintingVariant, PaintingVariant> FALL = PAINTING_VARIANTS.register("fall",()-> new PaintingVariant(32,32));
    public static DeferredHolder<PaintingVariant, PaintingVariant> MOONLIGHT_RAVE = PAINTING_VARIANTS.register("moonlight_rave",()-> new PaintingVariant(32,16));
    public static DeferredHolder<PaintingVariant, PaintingVariant> GRAZING = PAINTING_VARIANTS.register("grazing",()-> new PaintingVariant(16,16));
    public static DeferredHolder<PaintingVariant, PaintingVariant> DISTURBED = PAINTING_VARIANTS.register("disturbed",()-> new PaintingVariant(16,32));
    public static DeferredHolder<PaintingVariant, PaintingVariant> LEVELS = PAINTING_VARIANTS.register("levels",()-> new PaintingVariant(32,32));
    public static DeferredHolder<PaintingVariant, PaintingVariant> ICE_AGE = PAINTING_VARIANTS.register("ice_age",()-> new PaintingVariant(64,64));
    public static DeferredHolder<PaintingVariant, PaintingVariant> CRAWLING = PAINTING_VARIANTS.register("crawling",()-> new PaintingVariant(16,16));
    public static DeferredHolder<PaintingVariant, PaintingVariant> HOWLING_AT_THE_MOON = PAINTING_VARIANTS.register("howling_at_the_moon",()-> new PaintingVariant(64,32));
    public static DeferredHolder<PaintingVariant, PaintingVariant> LURKING_TERROR = PAINTING_VARIANTS.register("lurking_terror",()-> new PaintingVariant(32,32));
}
