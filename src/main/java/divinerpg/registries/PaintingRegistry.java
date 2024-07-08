package divinerpg.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static divinerpg.DivineRPG.MODID;

public class PaintingRegistry {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(Registries.PAINTING_VARIANT, MODID);
    public static DeferredHolder<PaintingVariant, PaintingVariant> FALL = PAINTING_VARIANTS.register("fall",()-> new PaintingVariant(32,32, ResourceLocation.fromNamespaceAndPath(MODID, "textures/painting/fall.png")));
    public static DeferredHolder<PaintingVariant, PaintingVariant> MOONLIGHT_RAVE = PAINTING_VARIANTS.register("moonlight_rave",()-> new PaintingVariant(32,16, ResourceLocation.fromNamespaceAndPath(MODID, "textures/painting/moonlight_rave.png")));
    public static DeferredHolder<PaintingVariant, PaintingVariant> GRAZING = PAINTING_VARIANTS.register("grazing",()-> new PaintingVariant(16,16, ResourceLocation.fromNamespaceAndPath(MODID, "textures/painting/grazing.png")));
    public static DeferredHolder<PaintingVariant, PaintingVariant> DISTURBED = PAINTING_VARIANTS.register("disturbed",()-> new PaintingVariant(16,32, ResourceLocation.fromNamespaceAndPath(MODID, "textures/painting/disturbed.png")));
    public static DeferredHolder<PaintingVariant, PaintingVariant> LEVELS = PAINTING_VARIANTS.register("levels",()-> new PaintingVariant(32,32, ResourceLocation.fromNamespaceAndPath(MODID, "textures/painting/levels.png")));
    public static DeferredHolder<PaintingVariant, PaintingVariant> ICE_AGE = PAINTING_VARIANTS.register("ice_age",()-> new PaintingVariant(64,64, ResourceLocation.fromNamespaceAndPath(MODID, "textures/painting/ice_age.png")));
    public static DeferredHolder<PaintingVariant, PaintingVariant> CRAWLING = PAINTING_VARIANTS.register("crawling",()-> new PaintingVariant(16,16, ResourceLocation.fromNamespaceAndPath(MODID, "textures/painting/crawling.png")));
    public static DeferredHolder<PaintingVariant, PaintingVariant> HOWLING_AT_THE_MOON = PAINTING_VARIANTS.register("howling_at_the_moon",()-> new PaintingVariant(64,32, ResourceLocation.fromNamespaceAndPath(MODID, "textures/painting/howling_at_the_moon.png")));
    public static DeferredHolder<PaintingVariant, PaintingVariant> LURKING_TERROR = PAINTING_VARIANTS.register("lurking_terror",()-> new PaintingVariant(32,32, ResourceLocation.fromNamespaceAndPath(MODID, "textures/painting/lurking_terror.png")));
}
