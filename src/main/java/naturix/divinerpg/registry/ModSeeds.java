package naturix.divinerpg.registry;

import naturix.divinerpg.objects.blocks.BlockModCrop;
import naturix.divinerpg.objects.items.arcana.ItemArcanaSeeds;
import naturix.divinerpg.objects.items.base.ItemModSeeds;
import naturix.divinerpg.objects.items.twilight.ItemTwilightSeeds;
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

     public static Item hitchakSeeds = new ItemArcanaSeeds("hitchak_seeds", (BlockModCrop) ModBlocks.hitchak);
     public static Item veiloSeeds = new ItemArcanaSeeds("veilo_seeds", (BlockModCrop) ModBlocks.veilo);
     public static Item marsineSeeds = new ItemArcanaSeeds("marsine_seeds", (BlockModCrop) ModBlocks.marsine);
     public static Item lamonaSeeds = new ItemArcanaSeeds("lamona_seeds", (BlockModCrop) ModBlocks.lamona);
     public static Item firestockSeeds = new ItemTwilightSeeds("firestock_seeds", ModBlocks.firestock, ModBlocks.arcanaGrass);
     public static Item pinflySeeds = new ItemTwilightSeeds("pinfly_seeds", ModBlocks.pinfly, ModBlocks.arcanaGrass);
     public static Item aquamarineSeeds = new ItemArcanaSeeds("aquamarine_seeds", (BlockModCrop) ModBlocks.aquamarine);
     public static Item eucalyptusSeeds = new ItemArcanaSeeds("eucalyptus_root_seeds", (BlockModCrop) ModBlocks.eucalyptusRoot);
    
    public static void init() {
    }
}
