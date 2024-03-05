package divinerpg.util.vanilla;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class Compostables {
    public static void setup(final FMLCommonSetupEvent event) {
        //Leaves
        add(.3F, "divine_leaves");
        add(.3F, "brittle_leaves");
        add(.3F, "auroraoak_leaves");
        add(.3F, "cozybark_leaves");
        add(.3F, "streamleaf_leaves");
        add(.3F, "eden_leaves");
        add(.3F, "wildwood_leaves");
        add(.3F, "apalachia_leaves");
        add(.3F, "skythern_leaves");
        add(.3F, "mortum_leaves");
        add(.3F, "firewood_leaves");
        add(.3F, "dreamwood_leaves");
        add(.3F, "hyrewood_leaves");
        add(.3F, "mintwood_leaves");
        //Saplings
        add(.3F, "divine_sapling");
        add(.3F, "shiverspine_sapling");
        add(.3F, "auroraoak_sapling");
        add(.3F, "cozybark_sapling");
        add(.3F, "streamleaf_sapling");
        add(.3F, "eden_sapling");
        add(.3F, "wildwood_sapling");
        add(.3F, "apalachia_sapling");
        add(.3F, "skythern_sapling");
        add(.3F, "mortum_sapling");
        //Short Grass
        add(.3F, "brittle_grass");
        add(.3F, "apalachia_tallgrass");
        //Seeds
        add(.3F, "tomato_seeds");
        add(.3F, "white_mushroom_seeds");
        add(.3F, "aquamarine_seeds");
        add(.3F, "eucalyptus_root_seeds");
        add(.3F, "firestock_seeds");
        add(.3F, "hitchak_seeds");
        add(.3F, "lamona_seeds");
        add(.3F, "marsine_seeds");
        add(.3F, "pinfly_seeds");
        add(.3F, "veilo_seeds");
        add(.3F, "moonbulb_seeds");
        add(.3F, "pink_glowbone_seeds");
        add(.3F, "purple_glowbone_seeds");
        add(.3F, "sky_plant_seeds");
        //Berries
        add(.3F, "winterberry");

        //Tall Grass
        add(.5F, "wildwood_tallgrass");
        //Melon
        add(.5F, "dream_melon");
        //Brushes
        add(.5F, "arcana_brush");
        add(.5F, "eden_brush");
        add(.5F, "skythern_brush");
        add(.5F, "mortum_brush");
        //Vines
        add(.5F, "winterberry_vines_head");
        add(.5F, "arcanite_vines_head");
        add(.5F, "weedwood_vine");
        add(.5F, "blossomed_weedwood_vine");
        add(.5F, "wildwood_vine");

        //Pumpkins
        add(.65F, "blaze_pumpkin");
        add(.65F, "creeper_pumpkin");
        add(.65F, "cyclops_pumpkin");
        add(.65F, "ender_pumpkin");
        add(.65F, "ender_watcher_pumpkin");
        add(.65F, "frost_pumpkin");
        add(.65F, "ghast_pumpkin");
        add(.65F, "glacon_pumpkin");
        add(.65F, "hellspider_pumpkin");
        add(.65F, "jungle_spider_pumpkin");
        add(.65F, "skeleton_pumpkin");
        add(.65F, "spider_pumpkin");
        add(.65F, "zombie_pumpkin");
        //Mushrooms
        add(.65F, "glowsprout");
        add(.65F, "lowsprout");
        add(.65F, "slowsprout");
        add(.65F, "truffle");
        add(.65F, "dreamglow");
        //Short Flowers
        add(.65F, "crimpetal");
        add(.65F, "roofbell");
        add(.65F, "winterbloom");
        add(.65F, "wisp_leaf");
        add(.65F, "gem_of_the_dunes");
        add(.65F, "sun_blossom");
        add(.65F, "sunbloom");
        add(.65F, "moonlight_fern");
        add(.65F, "moon_bud");
        add(.65F, "dust_lily");
        add(.65F, "eye_plant");
        add(.65F, "shine_grass");
        add(.65F, "cracklespike");
        add(.65F, "fernite");
        add(.65F, "bulbatobe");
        add(.65F, "shimmer");
        add(.65F, "yellow_dulah");
        add(.65F, "green_dulah");
        add(.65F, "green_gemtop");
        add(.65F, "purple_gemtop");
        //Tall Flowers
        add(.65F, "globebrush");
        add(.65F, "thermoliage");
        add(.65F, "dusk_flower");
        add(.65F, "dust_brambles");
        add(.65F, "demon_brambles");
        //Bushes
        add(.65F, "winterberry_bush");
        add(.65F, "arcana_bush");
        //Moss
        add(.65F, "brittle_moss");
        add(.65F, "arcanite_moss");
        //Crops & Stuff
        add(.65F, "tomato");
        add(.65F, "white_mushroom");
        add(.65F, "aquamarine");
        add(.65F, "hitchak");
        add(.65F, "pinfly");
        add(.65F, "moonbulb");
        add(.65F, "pink_glowbone");
        add(.65F, "purple_glowbone");
        add(.65F, "dream_carrot");

        add(.85F, "chocolate_log");
        add(.85F, "donut");
        add(.85F, "forbidden_fruit");
        //Mushroom Blocks
        add(.85F, "glowsprout_bulb");
        add(.85F, "glowsprout_stem");
        add(.85F, "lowsprout_bulb");
        add(.85F, "lowsprout_stem");
        add(.85F, "slowsprout_bulb");
        add(.85F, "slowsprout_stem");

        add(1, "dream_cake");
        add(1, "dream_pie");
        add(1, "fruit_cake");
        add(1, "hot_pumpkin_pie");

    }
    public static void add(float quantity, String itemId) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, itemId));
        ComposterBlock.add(quantity, item);
    }
}