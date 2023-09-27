package divinerpg.util.vanilla;

import net.minecraft.world.level.block.*;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import static divinerpg.registries.BlockRegistry.*;

public class PlantPots {

    public static void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            addPlant(crimpetal, crimpetalPot);
            addPlant(globebrush, globebrushPot);
            addPlant(roofbell, roofbellPot);
            addPlant(thermoliage, thermoliagePot);
            addPlant(winterbloom, winterbloomPot);
            addPlant(wispLeaf, wispLeafPot);
            addPlant(bulbatobe, bulbatobePot);
            addPlant(cracklespike, cracklespikePot);
            addPlant(dreamglow, dreamglowPot);
            addPlant(fernite, fernitePot);
            addPlant(greenDulah, greenDulahPot);
            addPlant(greenGemtop, greenGemtopPot);
            addPlant(purpleGemtop, purpleGemtopPot);
            addPlant(shimmer, shimmerPot);
            addPlant(shineGrass, shineGrassPot);
            addPlant(yellowDulah, yellowDulahPot);
            addPlant(arcanaBrush, arcanaBrushPot);
            addPlant(arcanaBush, arcanaBushPot);
            addPlant(gemOfTheDunes, gemOfTheDunesPot);
            addPlant(demonBrambles, demonBramblesPot);
            addPlant(eyePlant, eyePlantPot);
            addPlant(mortumBrush, mortumBrushPot);
            addPlant(dustBrambles, dustBramblesPot);
            addPlant(dustLily, dustLilyPot);
            addPlant(skythernBrush, skythernBrushPot);
            addPlant(duskBloom, duskBloomPot);
            addPlant(duskFlower, duskFlowerPot);
            addPlant(moonBud, moonBudPot);
            addPlant(moonlightFern, moonlightFernPot);
            addPlant(sunBlossom, sunBlossomPot);
            addPlant(sunbloom, sunbloomPot);
            addPlant(edenBrush, edenBrushPot);
            addPlant(edenSapling, edenSaplingPot);
            addPlant(wildwoodSapling, wildwoodSaplingPot);
            addPlant(apalachiaSapling, apalachiaSaplingPot);
            addPlant(skythernSapling, skythernSaplingPot);
            addPlant(mortumSapling, mortumSaplingPot);
            addPlant(brittleGrass, brittleGrassPot);
            addPlant(shiverspineSapling, shiverspineSaplingPot);
            addPlant(auroraoakSapling, auroraoakSaplingPot);
            addPlant(cozybarkSapling, cozybarkSaplingPot);
            addPlant(divineSapling, divineSaplingPot);
            addPlant(streamleafSapling, streamleafSaplingPot);
            addPlant(glowsprout, glowsproutPot);
            addPlant(lowsprout, lowsproutPot);
            addPlant(slowsprout, slowsproutPot);
                }
        );
    }
    private static void addPlant(RegistryObject<Block> plant, RegistryObject<FlowerPotBlock> pot) {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(plant.getId(), pot);
    }
}
