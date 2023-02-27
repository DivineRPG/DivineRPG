package divinerpg.compat;

import divinerpg.DivineRPG;
import divinerpg.registries.*;
import jeresources.api.*;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.drop.PlantDrop;
import jeresources.api.restrictions.*;
import jeresources.compatibility.api.JERAPI;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class JERCompat {

    public static void init() {
        IJERAPI jerApi = JERAPI.getInstance();


        IDungeonRegistry dungeonRegistry = jerApi.getDungeonRegistry();
        if (dungeonRegistry != null) {
            //Arcana
            dungeonRegistry.registerChest("Banquet Hall Chest", new ResourceLocation(DivineRPG.MODID, "chests/arcana/banquet_hall_loot"));
            dungeonRegistry.registerChest("Utility Hallway Chest", new ResourceLocation(DivineRPG.MODID, "chests/arcana/utility_hallway_loot"));

            //Iceika
            dungeonRegistry.registerChest("Iceika Chest", new ResourceLocation(DivineRPG.MODID, "chests/iceika/iceika_chest_dungeon"));
            dungeonRegistry.registerChest("Iceika Hut Chest", new ResourceLocation(DivineRPG.MODID, "chests/iceika/iceika_chest_hut"));

            //Overworld
            dungeonRegistry.registerChest("Diamond Dave's Chest", new ResourceLocation(DivineRPG.MODID, "chests/overworld/amethyst"));
            dungeonRegistry.registerChest("Ancient Tomb Chest", new ResourceLocation(DivineRPG.MODID, "chests/overworld/ancient_tomb"));
            dungeonRegistry.registerChest("Livestock Merchant's Chest", new ResourceLocation(DivineRPG.MODID, "chests/overworld/livestock_chest"));

            //Twilight
            dungeonRegistry.registerChest("Eden Hut Chest", new ResourceLocation(DivineRPG.MODID, "chests/twilight/eden/hut_chest"));
            dungeonRegistry.registerChest("Skythern Chest", new ResourceLocation(DivineRPG.MODID, "chests/twilight/skythern/chest"));
            dungeonRegistry.registerChest("Wildwood Chest", new ResourceLocation(DivineRPG.MODID, "chests/twilight/wildwood/chest"));

            //Vethea
            dungeonRegistry.registerChest("Crypt Loot Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/crypt_loot"));
            dungeonRegistry.registerChest("Karos Madhouse Loot Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/karos_madhouse_loot"));
            dungeonRegistry.registerChest("Quadrotic Post Loot Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/quadrotic_post_loot"));
            dungeonRegistry.registerChest("Raglok Chamber Loot Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/raglok_chamber_loot"));
            dungeonRegistry.registerChest("Temple Bottom Loot Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/temple_loot_bottom"));
            dungeonRegistry.registerChest("Temple Middle Loot Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/temple_loot_middle"));
            dungeonRegistry.registerChest("Temple Top Loot Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/temple_loot_top"));
            dungeonRegistry.registerChest("Wreck Hall Loot Chest", new ResourceLocation(DivineRPG.MODID, "chests/vethea/wreck_hall_loot"));
        }

        IWorldGenRegistry worldGenRegistry = jerApi.getWorldGenRegistry();
        if (worldGenRegistry != null) {
            worldGenRegistry.register(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arlemite_ore"))), new DistributionSquare(2, 8, 5, 70));
            worldGenRegistry.register(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "realmite_ore"))), new DistributionSquare(30, 8, 18, 52));
            worldGenRegistry.register(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "rupee_ore"))), new DistributionSquare(3, 8, -64, 64));
            worldGenRegistry.register(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "torridite_ore"))), new DistributionSquare(5, 4, 0, 256), new Restriction(new DimensionRestriction(Level.NETHER)));
            worldGenRegistry.register(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "bloodgem_ore"))), new DistributionSquare(5, 4, 0, 256), new Restriction(new DimensionRestriction(Level.NETHER)));
            worldGenRegistry.register(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_ore"))), new DistributionSquare(6, 5, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.EDEN)));
            worldGenRegistry.register(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_ore"))), new DistributionSquare(6, 8, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.WILDWOOD)));
            worldGenRegistry.register(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_ore"))), new DistributionSquare(12, 12, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.APALACHIA)));
            worldGenRegistry.register(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_ore"))), new DistributionSquare(7, 6, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.SKYTHERN)));
            worldGenRegistry.register(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_ore"))), new DistributionSquare(5, 5, -64, 256), new Restriction(new DimensionRestriction(LevelRegistry.MORTUM)));
        }

        IPlantRegistry plantRegistry = jerApi.getPlantRegistry();
        if(plantRegistry != null) {
            plantRegistry.register(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "moonbulb_seeds"))), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "moonbulb_plant")).defaultBlockState(), new PlantDrop(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "moonbulb"))), 1, 1));
            plantRegistry.register(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tomato_seeds"))), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "tomato_plant")).defaultBlockState(), new PlantDrop(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tomato"))), 1, 1));
            plantRegistry.register(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "white_mushroom_seeds"))), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "white_mushroom_plant")).defaultBlockState(), new PlantDrop(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "white_mushroom"))), 1, 1));
            plantRegistry.register(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquamarine_seeds"))), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "aquamarine_plant")).defaultBlockState(), new PlantDrop(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquamarine"))), 1, 1));
            plantRegistry.register(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eucalyptus_root_seeds"))), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eucalyptus_plant")).defaultBlockState(), new PlantDrop(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eucalyptus_log"))), 1, 1));
            plantRegistry.register(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "firestock_seeds"))), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "firestock_plant")).defaultBlockState(), new PlantDrop(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "firestock"))), 1, 1));
            plantRegistry.register(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "hitchak_seeds"))), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "hitchak_plant")).defaultBlockState(), new PlantDrop(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "hitchak"))), 1, 1));
            plantRegistry.register(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "lamona_seeds"))), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "lamona_plant")).defaultBlockState(), new PlantDrop(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "lamona"))), 1, 1));
            plantRegistry.register(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "marsine_seeds"))), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "marsine_plant")).defaultBlockState(), new PlantDrop(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "marsine"))), 1, 1));
            plantRegistry.register(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "pinfly_seeds"))), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "pinfly_plant")).defaultBlockState(), new PlantDrop(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "pinfly"))), 1, 1));
            plantRegistry.register(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "veilo_seeds"))), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "veilo_plant")).defaultBlockState(), new PlantDrop(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "veilo"))), 1, 1));
        }
    }
}
