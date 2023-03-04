package divinerpg.util.vanilla;

import com.google.common.collect.ImmutableMap;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.*;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import static divinerpg.registries.BlockRegistry.*;

public class LogStripper {

    public static void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
                    AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES)
                            .put(apalachiaLog.get(), strippedApalachiaLog.get())
                            .put(divineLog.get(), strippedDivineLog.get())
                            .put(dreamwoodLog.get(), strippedDreamwoodLog.get())
                            .put(edenLog.get(), strippedEdenLog.get())
                            .put(eucalyptusLog.get(), strippedEucalyptusLog.get())
                            .put(firewoodLog.get(), strippedFirewoodLog.get())
                            .put(frozenLog.get(), strippedFrozenLog.get())
                            .put(hyrewoodLog.get(), strippedHyrewoodLog.get())
                            .put(mintwoodLog.get(), strippedMintwoodLog.get())
                            .put(mortumLog.get(), strippedMortumLog.get())
                            .put(skythernLog.get(), strippedSkythernLog.get())
                            .put(wildwoodLog.get(), strippedWildwoodLog.get())
                            .build();
                }
        );



        // Compostable Items (Some of these Floats should be raised in accordance with the Item)
        ComposterBlock.COMPOSTABLES.put(divineLeaves.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(edenLeaves.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(wildwoodLeaves.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(apalachiaLeaves.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(skythernLeaves.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(mortumLeaves.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(brittleLeaves.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(edenSapling.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(wildwoodSapling.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(apalachiaSapling.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(skythernSapling.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(mortumSapling.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(brittleGrass.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(frozenSapling.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(divineSapling.get().asItem(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.aquamarine_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.eucalyptus_root_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.firestock_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.hitchak_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.lamona_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.marsine_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.moonbulb_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.pinfly_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.pink_glowbone_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.purple_glowbone_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.sky_plant_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.tomato_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.veilo_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.white_mushroom_seeds.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.winterberry.get(), 0.3F);

        ComposterBlock.COMPOSTABLES.put(winterberryVinesHead.get().asItem(), 0.5F);
        ComposterBlock.COMPOSTABLES.put(winterberryVinesBody.get().asItem(), 0.5F);
        ComposterBlock.COMPOSTABLES.put(arcaniteVinesHead.get().asItem(), 0.5F);
        ComposterBlock.COMPOSTABLES.put(arcaniteVinesBody.get().asItem(), 0.5F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.dream_melon.get(), 0.5F);

        ComposterBlock.COMPOSTABLES.put(blazePumpkin.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(creeperPumpkin.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(cyclopsPumpkin.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(enderPumpkin.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(enderWatcherPumpkin.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(frostPumpkin.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(ghastPumpkin.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(glaconPumpkin.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(hellspiderPumpkin.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(jungleSpiderPumpkin.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(skeletonPumpkin.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(spiderPumpkin.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(zombiePumpkin.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(bulbatobe.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(cracklespike.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(dreamglow.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(fernite.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(greenDulah.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(greenGemtop.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(purpleGemtop.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(shimmer.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(shineGrass.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(yellowDulah.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(arcanaBrush.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(arcanaBush.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(gemOfTheDunes.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(demonBrambles.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(eyePlant.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(mortumBrush.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(dustBrambles.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(duskFlower.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(moonBud.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(moonlightFern.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(sunBlossom.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(sunbloom.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(edenBrush.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(winterberryBush.get().asItem(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.dream_carrot.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.tomato.get(), 0.65F);

        ComposterBlock.COMPOSTABLES.put(ItemRegistry.donut.get(), 0.85F);

        ComposterBlock.COMPOSTABLES.put(ItemRegistry.dream_cake.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.dream_pie.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.fruit_cake.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(ItemRegistry.hot_pumpkin_pie.get(), 1.0F);
    }
}
