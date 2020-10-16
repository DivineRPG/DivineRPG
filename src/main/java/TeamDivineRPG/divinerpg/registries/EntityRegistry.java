package TeamDivineRPG.divinerpg.registries;

import TeamDivineRPG.divinerpg.DivineRPG;
import TeamDivineRPG.divinerpg.entities.vanilla.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry {
    //TODO - Fix loot tables
    // Finish mobs
    public static final EntityType<EntityAridWarrior> ARID_WARRIOR = registerEntity(EntityType.Builder.create(EntityAridWarrior::new, EntityClassification.MONSTER).size(1.4F, 2.8f), "arid_warrior");
    public static final EntityType<EntityShark> SHARK = registerEntity(EntityType.Builder.create(EntityShark::new, EntityClassification.WATER_CREATURE).size(1F, 0.5F), "shark");
    public static final EntityType<EntityWhale> WHALE = registerEntity(EntityType.Builder.create(EntityWhale::new, EntityClassification.WATER_CREATURE).size(3F, 1.2F), "whale");


    private static final EntityType registerEntity(EntityType.Builder builder, String entityName) {
        ResourceLocation nameLoc = new ResourceLocation(DivineRPG.MODID, entityName);
        return (EntityType) builder.build(entityName).setRegistryName(nameLoc);
    }


    public static void bakeAttributes() {
        //Old system was health, attack, armor. Just make sure to check its in the correct order
        GlobalEntityTypeAttributes.put(ARID_WARRIOR, EntityAridWarrior.attributes().func_233813_a_());
        GlobalEntityTypeAttributes.put(SHARK, EntityShark.attributes().func_233813_a_());
        GlobalEntityTypeAttributes.put(WHALE, EntityWhale.attributes().func_233813_a_());

    }


    static {
        EntitySpawnPlacementRegistry.register(ARID_WARRIOR, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityAridWarrior::canSpawnOn);
        EntitySpawnPlacementRegistry.register(SHARK, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityShark::canSpawnOn);
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

    @SubscribeEvent
    public void onBiomesLoad(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.Category.OCEAN) {
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(SHARK, 1, 1, 1));
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(WHALE, 1, 1, 1));
        }
        if (event.getCategory() == Biome.Category.DESERT) {
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ARID_WARRIOR, 35, 1, 4));
        }
    }

    @SubscribeEvent
    public static void registerSpawnEggs(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new SpawnEggItem(ARID_WARRIOR, -3546547, -65179583, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(DivineRPG.MODID, "arid_warrior_spawn_egg"),
                new SpawnEggItem(SHARK, -3546547, -65179583, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(DivineRPG.MODID, "shark_spawn_egg"),
                new SpawnEggItem(WHALE, -3546547, -65179583, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(DivineRPG.MODID, "whale_spawn_egg")

        );
    }
}