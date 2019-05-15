package naturix.divinerpg.registry;

import naturix.divinerpg.objects.items.ItemNotReady;
import naturix.divinerpg.objects.items.base.ItemModSeeds;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class ModSeeds {
    public static Item whiteMushroomSeeds = new ItemModSeeds("white_mushroom_seeds", ModBlocks.whiteMushroomPlant);
    public static Item tomatoSeeds = new ItemModSeeds("tomato_seeds", ModBlocks.tomatoPlant);

    public static Item moonbulbSeeds = new ItemModSeeds("moonbulb_seeds", ModBlocks.moonbulb, Blocks.GRASS);
    public static Item purpleGlowboneSeeds = new ItemModSeeds("purple_glowbone_seeds", ModBlocks.purpleGlowbone,
            Blocks.GRASS);
    public static Item pinkGlowboneSeeds = new ItemModSeeds("pink_glowbone_seeds", ModBlocks.pinkGlowbone,
            Blocks.GRASS);
    public static Item skyPlantSeeds = new ItemModSeeds("sky_plant_seeds", ModBlocks.skyPlant, Blocks.GRASS);

    // public static Item hitchakSeeds = new ItemArcanaSeeds("hitchakSeeds", (BlockModCrop) ArcanaBlocks.hitchak);
    public static Item hitchakSeeds = new ItemNotReady("hitchak_seeds", DRPGCreativeTabs.items);
    // public static Item veiloSeeds = new ItemArcanaSeeds("veiloSeeds", (BlockModCrop) ArcanaBlocks.veilo);
    public static Item veiloSeeds = new ItemNotReady("veilo_seeds", DRPGCreativeTabs.items);
    // public static Item marsineSeeds = new ItemArcanaSeeds("marsineSeeds", (BlockModCrop) ArcanaBlocks.marsine);
    public static Item marsineSeeds = new ItemNotReady("marsine_seeds", DRPGCreativeTabs.items);
    // public static Item lamonaSeeds = new ItemArcanaSeeds("lamonaSeeds", (BlockModCrop) ArcanaBlocks.lamona);
    public static Item lamonaSeeds = new ItemNotReady("lamona_seeds", DRPGCreativeTabs.items);
    // public static Item firestockSeeds = new ItemTwilightSeeds("firestockSeeds", ArcanaBlocks.firestock, ArcanaBlocks.arcanaGrass);
    public static Item firestockSeeds = new ItemNotReady("firestock_seeds", DRPGCreativeTabs.items);
    // public static Item pinflySeeds = new ItemTwilightSeeds("pinflySeeds", ArcanaBlocks.pinfly, ArcanaBlocks.arcanaGrass);
    public static Item pinflySeeds = new ItemNotReady("pinfly_seeds", DRPGCreativeTabs.items);
    // public static Item aquamarineSeeds = new ItemArcanaSeeds("aquamarineSeeds", (BlockModCrop) ArcanaBlocks.aquamarine);
    // public static Item eucalyptusSeeds = new ItemArcanaSeeds("eucalyptusRootSeeds", (BlockModCrop) ArcanaBlocks.eucalyptusRoot);
    public static Item aquamarineSeeds = new ItemNotReady("aquamarine_seeds", DRPGCreativeTabs.items);
    public static Item eucalyptusSeeds = new ItemNotReady("eucalyptus_root_seeds", DRPGCreativeTabs.items);

    public static void init() {
    }
}
