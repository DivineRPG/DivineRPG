package TeamDivineRPG.divinerpg.registries;

import TeamDivineRPG.divinerpg.DivineRPG;
import TeamDivineRPG.divinerpg.entities.vanilla.EntityWhale;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry {

    public static final EntityType<EntityWhale> WHALE = registerEntity(EntityType.Builder.create(EntityWhale::new, EntityClassification.WATER_CREATURE).size(3F, 1.2F), "whale");


    private static final EntityType registerEntity(EntityType.Builder builder, String entityName) {
        ResourceLocation nameLoc = new ResourceLocation(DivineRPG.MODID, entityName);
        return (EntityType) builder.build(entityName).setRegistryName(nameLoc);
    }


    public static void bakeAttributes(){
        GlobalEntityTypeAttributes.put(WHALE, EntityWhale.attributes().func_233813_a_());

    }


    static {
        EntitySpawnPlacementRegistry.register(WHALE, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityWhale::canSpawnOn);
        }
    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        try {
            for (Field f : EntityRegistry.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof EntityType) {
                    event.getRegistry().register((EntityType) obj);
                } else if (obj instanceof EntityType[]) {
                    for (EntityType type : (EntityType[]) obj) {
                        event.getRegistry().register(type);

                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        bakeAttributes();
    }

    public static void onBiomesLoad(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.Category.OCEAN) {
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(WHALE, 1, 1, 1));
        }
    }
}