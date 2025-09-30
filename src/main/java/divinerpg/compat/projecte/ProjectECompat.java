package divinerpg.compat.projecte;

import divinerpg.registries.*;
import moze_intel.projecte.api.mapper.*;
import moze_intel.projecte.api.mapper.collector.IMappingCollector;
import moze_intel.projecte.api.nss.*;
import net.minecraft.core.RegistryAccess;
import net.minecraft.server.ReloadableServerResources;
import net.minecraft.server.packs.resources.ResourceManager;
import javax.annotation.Nonnull;
import java.util.*;

import static divinerpg.registries.BlockRegistry.*;
import static divinerpg.registries.ItemRegistry.*;

@EMCMapper
public class ProjectECompat implements IEMCMapper<NormalizedSimpleStack, Long> {
    private static final Map<NormalizedSimpleStack, Long> CUSTOM_EMC_VALUES = new HashMap<>();
    public static void init() {
        //Items
        //Fuels
        register(NSSItem.createItem(anthracite.get()), 256);
        //Nuggets
        register(NSSItem.createItem(realmite_nugget.get()), 42);
        register(NSSItem.createItem(arlemite_nugget.get()), 896);
        register(NSSItem.createItem(rupee_nugget.get()), 1024);
        register(NSSItem.createItem(torridite_nugget.get()), 912);
        //Ingots
        register(NSSItem.createItem(shadow_bar.get()), 17280);
        register(NSSItem.createItem(hellstone_ingot.get()), 58320);
        register(NSSItem.createItem(oxdrite_ingot.get()), 512);
        //Dust & Powders
        register(NSSItem.createItem(purple_blaze.get()), 1536);
        register(NSSItem.createItem(fury_fire.get()), 6144);
        register(NSSItem.createItem(arlemite_dust.get()), 8064);
        register(NSSItem.createItem(rupee_dust.get()), 9216);
        register(NSSItem.createItem(eden_dust.get()), 1024);
        register(NSSItem.createItem(wildwood_dust.get()), 1536);
        register(NSSItem.createItem(apalachia_dust.get()), 2048);
        register(NSSItem.createItem(skythern_dust.get()), 4072);
        register(NSSItem.createItem(mortum_dust.get()), 6096);
        //Souls
        register(NSSItem.createItem(eden_soul.get()), 1024);
        register(NSSItem.createItem(wildwood_soul.get()), 1536);
        register(NSSItem.createItem(apalachia_soul.get()), 2048);
        register(NSSItem.createItem(skythern_soul.get()), 4072);
        register(NSSItem.createItem(mortum_soul.get()), 6096);
        //Hearts
        register(NSSItem.createItem(eden_heart.get()), 4096);
        register(NSSItem.createItem(wildwood_heart.get()), 6144);
        register(NSSItem.createItem(apalachia_heart.get()), 8192);
        register(NSSItem.createItem(skythern_heart.get()), 16288);
        register(NSSItem.createItem(mortum_heart.get()), 24384);
        //Shards & Fragments
        register(NSSItem.createItem(ice_shards.get()), 910);
        register(NSSItem.createItem(terran_shards.get()), 910);
        register(NSSItem.createItem(jungle_shards.get()), 910);
        register(NSSItem.createItem(molten_shards.get()), 910);
        register(NSSItem.createItem(corrupted_shards.get()), 1420);
        register(NSSItem.createItem(ender_shards.get()), 1820);
        register(NSSItem.createItem(divine_shards.get()), 2048);
        register(NSSItem.createItem(collector_fragments.get()), 1820);
        register(NSSItem.createItem(bedrock_chunk.get()), 155520);
        //Gems
        register(NSSItem.createItem(shadow_stone.get()), 155520);
        register(NSSItem.createItem(bloodgem.get()), 8256);
        register(NSSItem.createItem(soulfire_stone.get()), 10128);
        register(NSSItem.createItem(olivine.get()), 32);
        register(NSSItem.createItem(arcanium.get()), 17109);
        register(NSSItem.createItem(dirty_pearls.get()), 128);
        register(NSSItem.createItem(clean_pearls.get()), 256);
        register(NSSItem.createItem(polished_pearls.get()), 512);
        register(NSSItem.createItem(shiny_pearls.get()), 1024);
        //Currency
        register(NSSItem.createItem(shadow_coins.get()), 8640);
        register(NSSItem.createItem(snowflake.get()), 512);
        register(NSSItem.createItem(dungeon_tokens.get()), 17109);
        register(NSSItem.createItem(rock_chunks.get()), 2048);
        //Mob Loot
        register(NSSItem.createItem(cyclops_eye_shards.get()), 46);
        register(NSSItem.createItem(crab_claw.get()), 150);
        register(NSSItem.createItem(aquatic_pellets.get()), 800);
        register(NSSItem.createItem(shark_fin.get()), 1020);
        register(NSSItem.createItem(whale_fin.get()), 1280);
        register(NSSItem.createItem(liopleurodon_teeth.get()), 2242);
        register(NSSItem.createItem(liopleurodon_skull.get()), 4942);
        register(NSSItem.createItem(blubber.get()), 64);
        register(NSSItem.createItem(seng_fur.get()), 128);
        register(NSSItem.createItem(sabear_fur.get()), 128);
        register(NSSItem.createItem(sabear_tooth.get()), 128);
        register(NSSItem.createItem(watching_eye.get()), 4096);
        register(NSSItem.createItem(acid.get()), 64);
        //Plants & Seeds
        register(NSSItem.createItem(aquamarine.get()), 128);
        register(NSSItem.createItem(firestock.get()), 64);
        register(NSSItem.createItem(marsine.get()), 64);
        register(NSSItem.createItem(eucalyptus_root_seeds.get()), 32);
        //Food & Drinks
        register(NSSItem.createItem(tomato.get()), 64);
        register(NSSItem.createItem(white_mushroom.get()), 32);
        register(NSSItem.createItem(winterberry.get()), 16);
        register(NSSItem.createItem(peppermints.get()), 14);
        register(NSSItem.createItem(robbin_egg.get()), 32);
        register(NSSItem.createItem(cauldron_flesh.get()), 64);
        register(NSSItem.createItem(raw_seng_meat.get()), 64);
        register(NSSItem.createItem(raw_wolpertinger_meat.get()), 64);
        register(NSSItem.createItem(snow_cones.get()), 64);
        register(NSSItem.createItem(chocolate_log.get()), 122);
        register(NSSItem.createItem(fruit_cake.get()), 182);
        register(NSSItem.createItem(egg_nog.get()), 800);
        register(NSSItem.createItem(weak_arcana_potion.get()), 5460);
        register(NSSItem.createItem(strong_arcana_potion.get()), 8190);
        register(NSSItem.createItem(hitchak.get()), 128);
        register(NSSItem.createItem(lamona.get()), 64);
        register(NSSItem.createItem(pinfly.get()), 128);
        register(NSSItem.createItem(veilo.get()), 64);
        register(NSSItem.createItem(raw_empowered_meat.get()), 64);
        register(NSSItem.createItem(forbidden_fruit.get()), 128);
        register(NSSItem.createItem(magic_meat.get()), 128);
        register(NSSItem.createItem(moonbulb.get()), 64);
        register(NSSItem.createItem(pink_glowbone.get()), 64);
        register(NSSItem.createItem(purple_glowbone.get()), 64);
        register(NSSItem.createItem(enriched_magic_meat.get()), 256);
        register(NSSItem.createItem(sky_flower.get()), 32);
        register(NSSItem.createItem(dream_sweets.get()), 64);
        register(NSSItem.createItem(dream_sours.get()), 256);
        register(NSSItem.createItem(dream_cake.get()), 160);
        register(NSSItem.createItem(dream_pie.get()), 130);
        register(NSSItem.createItem(dream_melon.get()), 96);
        register(NSSItem.createItem(honeysuckle.get()), 1);
        register(NSSItem.createItem(honeychunk.get()), 1);
        //Templates
        register(NSSItem.createItem(color_template.get()), 20121);
        register(NSSItem.createItem(aquatic_coating_template.get()), 12192);
        register(NSSItem.createItem(cannon_template.get()), 384);
        register(NSSItem.createItem(claw_template.get()), 384);
        register(NSSItem.createItem(backsword_template.get()), 384);
        register(NSSItem.createItem(bow_template.get()), 384);
        register(NSSItem.createItem(disk_template.get()), 384);
        register(NSSItem.createItem(dissipator_template.get()), 640);
        register(NSSItem.createItem(hammer_template.get()), 384);
        register(NSSItem.createItem(staff_template.get()), 384);
        register(NSSItem.createItem(degraded_template.get()), 640);
        register(NSSItem.createItem(finished_template.get()), 1280);
        register(NSSItem.createItem(glistening_template.get()), 2560);
        register(NSSItem.createItem(demonized_template.get()), 2560);
        register(NSSItem.createItem(tormented_template.get()), 5120);
        //Keys
        register(NSSItem.createItem(ancient_key.get()), 49140);
        register(NSSItem.createItem(degraded_key.get()), 49140);
        register(NSSItem.createItem(sludge_key.get()), 49140);
        register(NSSItem.createItem(soul_key.get()), 49140);
        //Music Discs
        register(NSSItem.createItem(md_red_stains.get()), 8192);
        register(NSSItem.createItem(md_destiny.get()), 8192);
        //Buckets
        register(NSSItem.createItem(smoldering_tar_bucket.get()), 832);
        register(NSSItem.createItem(gem_fin_bucket.get()), 832);
        register(NSSItem.createItem(cauldron_fish_bucket.get()), 832);
        //Extra Equipment & Stuff
        register(NSSItem.createItem(frozen_clock.get()), 8256);
        register(NSSItem.createItem(inferno_sword.get()), 4868);
        register(NSSItem.createItem(fury_maul.get()), 171753);
        register(NSSItem.createItem(teleportation_crystal.get()), 24570);
        register(NSSItem.createItem(teleportation_star.get()), 53242);
        register(NSSItem.createItem(wizards_book.get()), 34218);
        //Workshop Merchant Equipment Trades
        register(NSSItem.createItem(icicle_bane.get()), 10240);
        //Workshop Tinkerer Trades
        register(NSSItem.createItem(snowflake_shuriken.get()), 192);
        register(NSSItem.createItem(serenade_of_ice.get()), 43008);
        register(NSSItem.createItem(frossivence.get()), 52416);
        register(NSSItem.createItem(glacier_sword.get()), 53006);
        register(NSSItem.createItem(frostking_sword.get()), 24077);
        register(NSSItem.createItem(enderice.get()), 202080);
        register(NSSItem.createItem(icine_sword.get()), 94212);
        register(NSSItem.createItem(frozen_maul.get()), 645124);
        register(NSSItem.createItem(snowstorm_bow.get()), 44676);
        register(NSSItem.createItem(sound_of_carols.get()), 21519);
        register(NSSItem.createItem(frostclaw_cannon.get()), 13651);
        register(NSSItem.createItem(fractite_cannon.get()), 99840);
        //Captain Merik Trades
        register(NSSItem.createItem(korma_helmet.get()), 102654);
        register(NSSItem.createItem(korma_chestplate.get()), 171090);
        register(NSSItem.createItem(korma_leggings.get()), 171090);
        register(NSSItem.createItem(korma_boots.get()), 102654);
        register(NSSItem.createItem(ender_scepter.get()), 205308);
        register(NSSItem.createItem(ghostbane.get()), 342180);
        register(NSSItem.createItem(storm_sword.get()), 85545);
        register(NSSItem.createItem(arcanium_saber.get()), 136872);
        register(NSSItem.createItem(livicia_sword.get()), 513111);
        register(NSSItem.createItem(grenade.get()), 1710);
        register(NSSItem.createItem(la_vekor.get()), 102654);
        register(NSSItem.createItem(meriks_missile.get()), 256635);
        register(NSSItem.createItem(firefly.get()), 205308);
        register(NSSItem.createItem(captains_sparkler.get()), 342180);
        //War General
        register(NSSItem.createItem(vemos_helmet.get()), 102654);
        register(NSSItem.createItem(vemos_chestplate.get()), 171090);
        register(NSSItem.createItem(vemos_leggings.get()), 171090);
        register(NSSItem.createItem(vemos_boots.get()), 102654);
        register(NSSItem.createItem(arcanite_blade.get()), 513270);
        register(NSSItem.createItem(divine_accumulator.get()), 102654);
        register(NSSItem.createItem(arcanite_blaster.get()), 307962);
        register(NSSItem.createItem(generals_staff.get()), 307962);
        register(NSSItem.createItem(starlight.get()), 68436);
        register(NSSItem.createItem(staff_of_starlight.get()), 342180);
        register(NSSItem.createItem(meteor_mash.get()), 290853);
        register(NSSItem.createItem(arcanium_attractor.get()), 119763);
        register(NSSItem.createItem(arcanium_reflector.get()), 119763);
        //Jack O'Man Trades
        register(NSSItem.createItem(wither_reaper_helmet.get()), 256);
        register(NSSItem.createItem(wither_reaper_chestplate.get()), 256);
        register(NSSItem.createItem(wither_reaper_leggings.get()), 256);
        register(NSSItem.createItem(wither_reaper_boots.get()), 256);
        register(NSSItem.createItem(skeleman_helmet.get()), 2800);
        register(NSSItem.createItem(skeleman_chestplate.get()), 4160);
        register(NSSItem.createItem(skeleman_leggings.get()), 4160);
        register(NSSItem.createItem(skeleman_boots.get()), 2800);
        register(NSSItem.createItem(jack_o_man_helmet.get()), 2464);
        register(NSSItem.createItem(jack_o_man_chestplate.get()), 4208);
        register(NSSItem.createItem(jack_o_man_leggings.get()), 4208);
        register(NSSItem.createItem(jack_o_man_boots.get()), 2464);
        register(NSSItem.createItem(scythe.get()), 7696);
        //Leorna Trades
        register(NSSItem.createItem(staff_of_enrichment.get()), 98280);
        register(NSSItem.createItem(serenade_of_infusion.get()), 131040);
        //Vethea Extras
        register(NSSItem.createItem(miners_amulet.get()), 3840);
        register(NSSItem.createItem(band_of_lheiva_hunting.get()), 25600);
        register(NSSItem.createItem(dream_flint.get()), 10240);
        register(NSSItem.createItem(moon_clock.get()), 40960);
        //Vethea Arrows
        register(NSSItem.createItem(teaker_arrow.get()), 8);
        register(NSSItem.createItem(darven_arrow.get()), 16);
        register(NSSItem.createItem(pardimal_arrow.get()), 32);
        register(NSSItem.createItem(karos_arrow.get()), 48);
        register(NSSItem.createItem(ever_arrow.get()), 128);
        //Vethea Tools
        register(NSSItem.createItem(dream_axe.get()), 1278);
        register(NSSItem.createItem(dream_pickaxe.get()), 1278);
        register(NSSItem.createItem(dream_shovel.get()), 1278);
        register(NSSItem.createItem(karos_rockmaul.get()), 51200);

        //Blocks
        //Dirt
        register(NSSItem.createItem(frozenDirt.get()), 1);
        register(NSSItem.createItem(arcaniteDirt.get()), 16);
        register(NSSItem.createItem(edenDirt.get()), 1);
        register(NSSItem.createItem(wildwoodDirt.get()), 1);
        register(NSSItem.createItem(apalachiaDirt.get()), 1);
        register(NSSItem.createItem(skythernDirt.get()), 1);
        register(NSSItem.createItem(mortumDirt.get()), 1);
        register(NSSItem.createItem(dreamDirt.get()), 1);
        //Grass
        register(NSSItem.createItem(frozenGrass.get()), 1);
        register(NSSItem.createItem(arcaniteGrass.get()), 16);
        register(NSSItem.createItem(edenGrass.get()), 1);
        register(NSSItem.createItem(wildwoodGrass.get()), 1);
        register(NSSItem.createItem(apalachiaGrass.get()), 1);
        register(NSSItem.createItem(skythernGrass.get()), 1);
        register(NSSItem.createItem(mortumGrass.get()), 1);
        register(NSSItem.createItem(flameGrass.get()), 1);
        register(NSSItem.createItem(dreamGrass.get()), 1);
        register(NSSItem.createItem(evergrass.get()), 1);
        register(NSSItem.createItem(scorchedGrass.get()), 1);
        //Mud, Sand, Gravel, etc.
        register(NSSItem.createItem(gelidite.get()), 1);
        register(NSSItem.createItem(frozenGravel.get()), 4);
        register(NSSItem.createItem(soulSludgeBreakable.get()), 49);
        register(NSSItem.createItem(hiveWall.get()), 1);
        //Stone
        register(NSSItem.createItem(asphalt.get()), 16);
        register(NSSItem.createItem(frozenStone.get()), 1);
        register(NSSItem.createItem(cobbledFrozenStone.get()), 1);
        register(NSSItem.createItem(icyStone.get()), 16);
        register(NSSItem.createItem(cobaltite.get()), 32);
        register(NSSItem.createItem(arcaniteStone.get()), 1);
        register(NSSItem.createItem(soulStoneBreakable.get()), 16);
        register(NSSItem.createItem(ancientStoneBreakable.get()), 16);
        register(NSSItem.createItem(twilightStone.get()), 1);
        register(NSSItem.createItem(scorchalt.get()), 1);
        register(NSSItem.createItem(cobbledScorchalt.get()), 1);
        register(NSSItem.createItem(exposedScorchalt.get()), 1);
        register(NSSItem.createItem(rayStone.get()), 1);
        register(NSSItem.createItem(draughtStone.get()), 16);
        register(NSSItem.createItem(divineMossStone.get()), 9);
        register(NSSItem.createItem(dreamStone.get()), 1);
        register(NSSItem.createItem(lunaStone.get()), 16);
        //Decorative Features
        register(NSSItem.createItem(icicle.get()), 16);
        register(NSSItem.createItem(thermalVent.get()), 16);
        //Bricks
        register(NSSItem.createItem(snowBricks.get()), 16);
        register(NSSItem.createItem(icyBricks.get()), 16);
        register(NSSItem.createItem(runicIcyBricks.get()), 16);
        register(NSSItem.createItem(ancientBricksBreakable.get()), 16);
        register(NSSItem.createItem(degradedBricksBreakable.get()), 16);
        register(NSSItem.createItem(ancientTileBreakable.get()), 16);
        register(NSSItem.createItem(arcaniumMetalBreakable.get()), 16);
        register(NSSItem.createItem(arcaniumPowerBreakable.get()), 256);
        register(NSSItem.createItem(lunaBricks.get()), 64);
        register(NSSItem.createItem(redDreamBricks.get()), 8);
        register(NSSItem.createItem(darkDreamBricks.get()), 8);
        register(NSSItem.createItem(lightDreamBricks.get()), 8);
        //Plants
        register(NSSItem.createItem(brittleGrass.get()), 1);
        register(NSSItem.createItem(brittleMoss.get()), 12);
        register(NSSItem.createItem(snowyMoss.get()), 8);
        register(NSSItem.createItem(winterberryBush.get()), 32);
        register(NSSItem.createItem(winterberryVinesHead.get()), 16);
        register(NSSItem.createItem(arcanaBrush.get()), 1);
        register(NSSItem.createItem(arcanaBush.get()), 1);
        register(NSSItem.createItem(arcaniteMoss.get()), 12);
        register(NSSItem.createItem(arcaniteVinesHead.get()), 16);
        register(NSSItem.createItem(edenBrush.get()), 1);
        register(NSSItem.createItem(landVine.get()), 4);
        register(NSSItem.createItem(wildwoodVine.get()), 8);
        register(NSSItem.createItem(moonlightFern.get()), 1);
        register(NSSItem.createItem(wildwoodTallgrass.get()), 1);
        register(NSSItem.createItem(truffle.get()), 144);
        register(NSSItem.createItem(apalachiaTallgrass.get()), 1);
        register(NSSItem.createItem(skythernBrush.get()), 1);
        register(NSSItem.createItem(mortumBrush.get()), 1);
        register(NSSItem.createItem(weedwoodVine.get()), 8);
        register(NSSItem.createItem(blossomedWeedwoodVine.get()), 8);
        //Fungi
        register(NSSItem.createItem(glowsprout.get()), 32);
        register(NSSItem.createItem(lowsprout.get()), 32);
        register(NSSItem.createItem(slowsprout.get()), 32);
        register(NSSItem.createItem(lushroom.get()), 32);
        register(NSSItem.createItem(dreamglow.get()), 32);
        //Candy Cane
        register(NSSItem.createItem(redCandyCane.get()), 126);
        register(NSSItem.createItem(yellowCandyCane.get()), 126);
        register(NSSItem.createItem(greenCandyCane.get()), 126);
        register(NSSItem.createItem(blueCandyCane.get()), 126);
        register(NSSItem.createItem(pinkCandyCane.get()), 126);
        //Fairy Lights
        register(NSSItem.createItem(redFairyLights.get()), 14);
        register(NSSItem.createItem(yellowFairyLights.get()), 14);
        register(NSSItem.createItem(greenFairyLights.get()), 14);
        register(NSSItem.createItem(blueFairyLights.get()), 14);
        register(NSSItem.createItem(purpleFairyLights.get()), 14);
        //Glass
        register(NSSItem.createItem(frostedGlass.get()), 1);
        register(NSSItem.createItem(smoothGlass.get()), 1);
        //Lights
        register(NSSItem.createItem(workshopLamp.get()), 256);
        register(NSSItem.createItem(dungeonLampBreakable.get()), 256);
        register(NSSItem.createItem(slimeLight.get()), 1920);
        register(NSSItem.createItem(firelight.get()), 512);
        register(NSSItem.createItem(fireCrystal.get()), 512);
        register(NSSItem.createItem(dreamLamp.get()), 1792);
        register(NSSItem.createItem(cellLamp.get()), 256);
        register(NSSItem.createItem(villageLamp.get()), 256);
        //Furnaces
        register(NSSItem.createItem(coalstoneFurnace.get()), 2304);
        register(NSSItem.createItem(moltenFurnace.get()), 34218);
        register(NSSItem.createItem(greenlightFurnace.get()), 51327);
        register(NSSItem.createItem(oceanfireFurnace.get()), 68436);
        register(NSSItem.createItem(moonlightFurnace.get()), 85545);
        register(NSSItem.createItem(whitefireFurnace.get()), 119763);
        register(NSSItem.createItem(demonFurnace.get()), 153981);
        //Chests
        register(NSSItem.createItem(frostedChest.get()), 1024);
        register(NSSItem.createItem(presentBox.get()), 2048);
        //Doors
        register(NSSItem.createItem(steelDoor.get()), 512);
        register(NSSItem.createItem(barredDoor.get()), 512);
        //Ladders
        register(NSSItem.createItem(arcaniteTubes.get()), 14);
        register(NSSItem.createItem(arcaniteLadder.get()), 14);
        //Misc
        register(NSSItem.createItem(coldHellfireSponge.get()), 122488);
        register(NSSItem.createItem(starBridge.get()), 8554);
        register(NSSItem.createItem(elevantium.get()), 5703);
        register(NSSItem.createItem(acceleron.get()), 17109);
        register(NSSItem.createItem(metalCaging.get()), 64);
        register(NSSItem.createItem(hiveEgg.get()), 16384);
    }
    public static void register(@Nonnull NormalizedSimpleStack stack, long emcValue) {CUSTOM_EMC_VALUES.put(stack, emcValue);}
    @Override public String getName() {return "DivineRPGMapper";}
    @Override public String getTranslationKey() {return "tooltip.divinerpg.projecte.map";}
    @Override public String getDescription() {return "Adds EMC to DivineRPG";}
    @Override public void addMappings(IMappingCollector<NormalizedSimpleStack, Long> iMappingCollector, ReloadableServerResources reloadableServerResources, RegistryAccess registryAccess, ResourceManager resourceManager) {
        for(Map.Entry<NormalizedSimpleStack, Long> entry : CUSTOM_EMC_VALUES.entrySet()) {
            NormalizedSimpleStack normStack = entry.getKey();
            long value = entry.getValue();
            iMappingCollector.setValueBefore(normStack, value);
        }
    }
}