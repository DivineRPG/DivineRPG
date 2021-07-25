package divinerpg.compat;

import divinerpg.config.*;
import divinerpg.registries.*;
import jeresources.api.*;
import jeresources.api.distributions.*;
import jeresources.api.drop.*;
import jeresources.api.restrictions.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.event.lifecycle.*;

public class JERCompat {
    @JERPlugin
    public static IJERAPI jerAPI;


    public static void init(FMLCommonSetupEvent event) {
        if (jerAPI == null)
        return;

        initOreGen();
        initPlants();

    }

    private static void initDungeonLoot() {
        IDungeonRegistry dungeonRegistry = jerAPI.getDungeonRegistry();
        dungeonRegistry.registerChest("Iceika Chest", LootTableRegistry.ICEIKA_CHEST_DUNGEON);
        dungeonRegistry.registerChest("Iceika Hut Chest", LootTableRegistry.ICEIKA_CHEST_HUT);
        dungeonRegistry.registerChest("Crypt Loot", LootTableRegistry.CRYPT_LOOT);
        dungeonRegistry.registerChest("Lower Temple Loot", LootTableRegistry.TEMPLE_LOOT_BOTTOM);
        dungeonRegistry.registerChest("Middle Temple Loot", LootTableRegistry.TEMPLE_LOOT_MIDDLE);
        dungeonRegistry.registerChest("Higher Temple Loot", LootTableRegistry.TEMPLE_LOOT_TOP);
        dungeonRegistry.registerChest("Quadrotic Post Loot", LootTableRegistry.QUADROTIC_POST_LOOT);
        dungeonRegistry.registerChest("Karos Mad House Loot", LootTableRegistry.KAROS_MADHOUSE_LOOT);
        dungeonRegistry.registerChest("Raglok Chamber Loot", LootTableRegistry.RAGLOK_CHAMBER_LOOT);
        dungeonRegistry.registerChest("Wreck Hall Loot", LootTableRegistry.WRECK_HALL_LOOT);
    }

    private static void initOreGen() {
        IWorldGenRegistry worldGenRegistry = jerAPI.getWorldGenRegistry();
        worldGenRegistry.register(new ItemStack(BlockRegistry.arlemiteOre), new DistributionSquare(Config.arlemiteTries.get(), Config.arlemiteVeinSize.get(), 0, Config.arlemiteMaxHeight.get()));
        worldGenRegistry.register(new ItemStack(BlockRegistry.realmiteOre), new DistributionSquare(Config.realmiteTries.get(), Config.realmiteVeinSize.get(), 0, Config.realmiteMaxHeight.get()));
        worldGenRegistry.register(new ItemStack(BlockRegistry.rupeeOre), new DistributionSquare(Config.rupeeTries.get(), Config.rupeeVeinSize.get(), 0, Config.rupeeMaxHeight.get()));
        worldGenRegistry.register(new ItemStack(BlockRegistry.torriditeOre), new DistributionSquare(Config.netherTries.get(), Config.netherVein.get(), 0, 256), new Restriction(new DimensionRestriction(World.NETHER)));
        worldGenRegistry.register(new ItemStack(BlockRegistry.bloodgemOre), new DistributionSquare(Config.netherTries.get(), Config.netherVein.get(), 0, 256), new Restriction(new DimensionRestriction(World.NETHER)));
        worldGenRegistry.register(new ItemStack(BlockRegistry.edenOre), new DistributionSquare(Config.twilightTries.get(), Config.twilightVein.get(), 0, 256), new Restriction(new DimensionRestriction(KeyRegistry.EDEN_WORLD)));
        worldGenRegistry.register(new ItemStack(BlockRegistry.wildwoodOre), new DistributionSquare(Config.twilightTries.get(), Config.twilightVein.get(), 0, 256), new Restriction(new DimensionRestriction(KeyRegistry.WILDWOOD_WORLD)));
        worldGenRegistry.register(new ItemStack(BlockRegistry.apalachiaOre), new DistributionSquare(Config.twilightTries.get(), Config.twilightVein.get(), 0, 256), new Restriction(new DimensionRestriction(KeyRegistry.APALACHIA_WORLD)));
        worldGenRegistry.register(new ItemStack(BlockRegistry.skythernOre), new DistributionSquare(Config.twilightTries.get(), Config.twilightVein.get(), 0, 256), new Restriction(new DimensionRestriction(KeyRegistry.SKYTHERN_WORLD)));
        worldGenRegistry.register(new ItemStack(BlockRegistry.mortumOre), new DistributionSquare(Config.twilightTries.get(), Config.twilightVein.get(), 0, 256), new Restriction(new DimensionRestriction(KeyRegistry.MORTUM_WORLD)));
    }

    private static void initPlants() {
        IPlantRegistry plantRegistry = jerAPI.getPlantRegistry();
        plantRegistry.register(new ItemStack(ItemRegistry.moonbulbSeeds), new PlantDrop(new ItemStack(ItemRegistry.moonbulb), 1, 1));
        plantRegistry.register(new ItemStack(ItemRegistry.tomatoSeeds), new PlantDrop(new ItemStack(ItemRegistry.tomato), 1, 1));
        plantRegistry.register(new ItemStack(ItemRegistry.whiteMushroomSeeds), new PlantDrop(new ItemStack(ItemRegistry.whiteMushroom), 1, 1));
        plantRegistry.register(new ItemStack(ItemRegistry.aquamarineSeeds), new PlantDrop(new ItemStack(ItemRegistry.aquamarine), 1, 1));
        plantRegistry.register(new ItemStack(ItemRegistry.eucalyptusRootSeeds), new PlantDrop(new ItemStack(BlockRegistry.eucalyptusLog), 1, 1));
        plantRegistry.register(new ItemStack(ItemRegistry.firestockSeeds), new PlantDrop(new ItemStack(ItemRegistry.firestock), 1, 1));
        plantRegistry.register(new ItemStack(ItemRegistry.hitchakSeeds), new PlantDrop(new ItemStack(ItemRegistry.hitchak), 1, 1));
        plantRegistry.register(new ItemStack(ItemRegistry.lamonaSeeds), new PlantDrop(new ItemStack(ItemRegistry.lamona), 1, 1));
        plantRegistry.register(new ItemStack(ItemRegistry.marsineSeeds), new PlantDrop(new ItemStack(ItemRegistry.marsine), 1, 1));
        plantRegistry.register(new ItemStack(ItemRegistry.pinflySeeds), new PlantDrop(new ItemStack(ItemRegistry.pinfly), 1, 1));
        plantRegistry.register(new ItemStack(ItemRegistry.veiloSeeds), new PlantDrop(new ItemStack(ItemRegistry.veilo), 1, 1));
    }
}
