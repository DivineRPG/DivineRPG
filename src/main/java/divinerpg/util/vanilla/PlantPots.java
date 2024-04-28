package divinerpg.util.vanilla;

import net.minecraft.world.level.block.*;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import static divinerpg.registries.BlockRegistry.*;

public class PlantPots {
    public static void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            //Saplings
            addPlant(divineSapling, divineSaplingPot);
            addPlant(shiverspineSapling, shiverspineSaplingPot);
            addPlant(auroraoakSapling, auroraoakSaplingPot);
            addPlant(cozybarkSapling, cozybarkSaplingPot);
            addPlant(streamleafSapling, streamleafSaplingPot);
            addPlant(edenSapling, edenSaplingPot);
            addPlant(wildwoodSapling, wildwoodSaplingPot);
            addPlant(apalachiaSapling, apalachiaSaplingPot);
            addPlant(skythernSapling, skythernSaplingPot);
            addPlant(mortumSapling, mortumSaplingPot);
            //Mushrooms
            addPlant(glowsprout, glowsproutPot);
            addPlant(lowsprout, lowsproutPot);
            addPlant(slowsprout, slowsproutPot);
            addPlant(dreamglow, dreamglowPot);
            //Short Flowers
            addPlant(crimpetal, crimpetalPot);
            addPlant(roofbell, roofbellPot);
            addPlant(winterbloom, winterbloomPot);
            addPlant(wispLeaf, wispLeafPot);
            addPlant(gemOfTheDunes, gemOfTheDunesPot);
            addPlant(sunBlossom, sunBlossomPot);
            addPlant(sunbloom, sunbloomPot);
            addPlant(moonlightFern, moonlightFernPot);
            addPlant(moonBud, moonBudPot);
            addPlant(duskBloom, duskBloomPot);
            addPlant(dustLily, dustLilyPot);
            addPlant(eyePlant, eyePlantPot);
            addPlant(shineGrass, shineGrassPot);
            addPlant(cracklespike, cracklespikePot);
            addPlant(fernite, fernitePot);
            addPlant(bulbatobe, bulbatobePot);
            addPlant(shimmer, shimmerPot);
            addPlant(yellowDulah, yellowDulahPot);
            addPlant(greenDulah, greenDulahPot);
            addPlant(greenGemtop, greenGemtopPot);
            addPlant(purpleGemtop, purpleGemtopPot);
            //Tall Flowers
            addPlant(globebrush, globebrushPot);
            addPlant(thermoliage, thermoliagePot);
            addPlant(duskFlower, duskFlowerPot);
            addPlant(dustBrambles, dustBramblesPot);
            addPlant(demonBrambles, demonBramblesPot);
            //Bushes
            addPlant(arcanaBush, arcanaBushPot);
            }
        );
    }
    private static void addPlant(RegistryObject<Block> plant, RegistryObject<FlowerPotBlock> pot) {((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(plant.getId(), pot);}
}