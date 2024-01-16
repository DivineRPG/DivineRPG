package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.effect.dimension.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.*;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LevelRegistry {
    public static final ResourceKey<Level> EDEN = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DivineRPG.MODID, "eden"));
    public static final ResourceKey<Level> WILDWOOD = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DivineRPG.MODID, "wildwood"));
    public static final ResourceKey<Level> APALACHIA = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DivineRPG.MODID, "apalachia"));
    public static final ResourceKey<Level> SKYTHERN = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DivineRPG.MODID, "skythern"));
    public static final ResourceKey<Level> MORTUM = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DivineRPG.MODID, "mortum"));
    public static final ResourceKey<Level> ICEIKA = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DivineRPG.MODID, "iceika"));
    public static final ResourceKey<Level> ARCANA = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DivineRPG.MODID, "arcana"));
    public static final ResourceKey<Level> VETHEA = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DivineRPG.MODID, "vethea"));

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
    	event.register(new ResourceLocation(DivineRPG.MODID, "iceika_sky"), new IceikaSky());
        event.register(new ResourceLocation(DivineRPG.MODID, "twilight_sky"), new TwilightSky());
        event.register(new ResourceLocation(DivineRPG.MODID, "vethea_sky"), new VetheaSky());
    }
}
