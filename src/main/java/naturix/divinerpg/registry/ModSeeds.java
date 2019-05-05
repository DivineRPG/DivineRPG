package naturix.divinerpg.registry;

import naturix.divinerpg.objects.blocks.BlockModCrop;
import naturix.divinerpg.objects.items.ItemNotReady;
import naturix.divinerpg.objects.items.base.ItemModSeeds;
import net.minecraft.item.Item;

public class ModSeeds {
    public static Item whiteMushroomSeeds = new ItemModSeeds("white_mushroom_seeds",
            (BlockModCrop) ModBlocks.whiteMushroomPlant);
    public static Item tomatoSeeds = new ItemModSeeds("tomato_seeds", (BlockModCrop) ModBlocks.tomatoPlant);

    // public static Item moonbulbSeeds = new ItemTwilightSeeds("moonbulb_seeds", ModBlocks.moonbulb, Blocks.GRASS);
    public static Item moonbulbSeeds = new ItemNotReady("moonbulb_seeds", DRPGCreativeTabs.items);
    // public static Item purpleGlowboneSeeds = new ItemTwilightSeeds("purple_glowbone_seeds", ModBlocks.purpleGlowbone, Blocks.GRASS);
    public static Item purpleGlowboneSeeds = new ItemNotReady("purple_glowbone_seeds", DRPGCreativeTabs.items);
    // public static Item pinkGlowboneSeeds = new ItemTwilightSeeds("pink_glowbone_seeds", ModBlocks.pinkGlowbone, Blocks.GRASS);
    public static Item pinkGlowboneSeeds = new ItemNotReady("pink_glowbone_seeds", DRPGCreativeTabs.items);
    // public static Item skyPlantSeeds = new ItemTwilightSeeds("sky_plant_seeds", ModBlocks.skyPlant, Blocks.GRASS);
    public static Item skyPlantSeeds = new ItemNotReady("sky_plant_seeds", DRPGCreativeTabs.items);

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
