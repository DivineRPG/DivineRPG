package divinerpg.util.vanilla;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class Compostables {

    public static void setup(final FMLCommonSetupEvent event) {
        add(0.3F, "divine_leaves");
        add(0.3F, "eden_leaves");
        add(0.3F, "wildwood_leaves");
        add(0.3F, "apalachia_leaves");
        add(0.3F, "skythern_leaves");
        add(0.3F, "mortum_leaves");
        add(0.3F, "brittle_leaves");
        add(0.3F, "eden_sapling");
        add(0.3F, "wildwood_sapling");
        add(0.3F, "apalachia_sapling");
        add(0.3F, "skythern_sapling");
        add(0.3F, "mortum_sapling");
        add(0.3F, "brittle_grass");
        add(0.3F, "frozen_sapling");
        add(0.3F, "divine_sapling");
        add(0.3F, "aquamarine_seeds");
        add(0.3F, "eucalyptus_root_seeds");
        add(0.3F, "firestock_seeds");
        add(0.3F, "hitchak_seeds");
        add(0.3F, "lamona_seeds");
        add(0.3F, "marsine_seeds");
        add(0.3F, "moonbulb_seeds");
        add(0.3F, "pinfly_seeds");
        add(0.3F, "pink_glowbone_seeds");
        add(0.3F, "purple_glowbone_seeds");
        add(0.3F, "sky_plant_seeds");
        add(0.3F, "tomato_seeds");
        add(0.3F, "veilo_seeds");
        add(0.3F, "white_mushroom_seeds");
        add(0.3F, "winterberry");
        add(0.3F, "apalachia_tallgrass");

        add(0.5F, "winterberry_vines_head");
        add(0.5F, "arcanite_vines_head");
        add(0.5F, "dream_melon");
        add(0.5F, "wildwood_vine");
        add(0.5F, "weedwood_vine");
        add(0.5F, "blossomed_weedwood_vine");
        add(0.5F, "wildwood_tallgrass");
        add(0.5F, "arcana_brush");
        add(0.5F, "mortum_brush");
        add(0.5F, "eden_brush");
        add(0.5F, "skythern_brush");

        add(0.65F, "blaze_pumpkin");
        add(0.65F, "creeper_pumpkin");
        add(0.65F, "cyclops_pumpkin");
        add(0.65F, "ender_pumpkin");
        add(0.65F, "ender_watcher_pumpkin");
        add(0.65F, "frost_pumpkin");
        add(0.65F, "ghast_pumpkin");
        add(0.65F, "glacon_pumpkin");
        add(0.65F, "hellspider_pumpkin");
        add(0.65F, "jungle_spider_pumpkin");
        add(0.65F, "skeleton_pumpkin");
        add(0.65F, "spider_pumpkin");
        add(0.65F, "zombie_pumpkin");
        add(0.65F, "bulbatobe");
        add(0.65F, "cracklespike");
        add(0.65F, "dreamglow");
        add(0.65F, "fernite");
        add(0.65F, "green_dulah");
        add(0.65F, "green_gemtop");
        add(0.65F, "purple_gemtop");
        add(0.65F, "shimmer");
        add(0.65F, "shine_grass");
        add(0.65F, "yellow_dulah");
        add(0.65F, "arcana_bush");
        add(0.65F, "gem_of_the_dunes");
        add(0.65F, "demon_brambles");
        add(0.65F, "eye_plant");
        add(0.65F, "dust_brambles");
        add(0.65F, "dust_lily");
        add(0.65F, "dusk_flower");
        add(0.65F, "moon_bud");
        add(0.65F, "moonlight_fern");
        add(0.65F, "sun_blossom");
        add(0.65F, "sunbloom");
        add(0.65F, "winterberry_bush");
        add(0.65F, "dream_carrot");
        add(0.65F, "tomato");
        add(0.65F, "arcanite_moss");
        add(0.65F, "brittle_moss");
        add(0.65F, "white_mushroom");
        add(0.65F, "moonbulb");
        add(0.65F, "pink_glowbone");
        add(0.65F, "purple_glowbone");
        add(0.65F, "aquamarine");
        add(0.65F, "pinfly");
        add(0.65F, "hitchak");

        add(0.85F, "chocolate_log");
        add(0.85F, "donut");
        add(0.85F, "forbidden_fruit");

        add(1.0F, "dream_cake");
        add(1.0F, "dream_pie");
        add(1.0F, "fruit_cake");
        add(1.0F, "hot_pumpkin_pie");

    }

    public static void add(float quantity, String itemId) {
        DivineRPG.LOGGER.info("tried to add " + itemId);
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, itemId));
        DivineRPG.LOGGER.info("id: " + itemId + ". descriptionID: " + item.getDescriptionId());
        ComposterBlock.add(quantity, item);
    }
}
