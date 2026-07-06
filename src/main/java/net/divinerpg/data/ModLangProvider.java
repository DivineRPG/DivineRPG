package net.divinerpg.data;


import net.divinerpg.DivineRPG;
import net.divinerpg.registries.BlockRegistry;
import net.divinerpg.registries.DamageRegistry;
import net.divinerpg.registries.ItemRegistry;
import net.divinerpg.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import static net.divinerpg.DivineRPG.MODID;

public class ModLangProvider extends LanguageProvider {
    protected final String locale;
    private final Map<String, String> existingTranslations = new HashMap<>();
    private final Set<String> addedKeys = new HashSet<>();
    private static final Gson GSON = new Gson();

    public ModLangProvider(PackOutput output, String locale) {
        super(output, MODID, locale);
        this.locale = locale;
        loadExistingTranslations(output);
    }
    //addAuto for most things, especially translatable stuff
    //add is stuff you do not want translated
    @Override
    protected void addTranslations() {
        addAuto(ItemRegistry.arlemite_nugget, "Arlemite Nugget");
        addAuto(ItemRegistry.arlemite_ingot, "Arlemite Ingot");
        addAuto(ItemRegistry.raw_arlemite, "Raw Arlemite");
        addAuto(ItemRegistry.rupee_nugget, "Rupee Nugget");
        addAuto(ItemRegistry.rupee_ingot, "Rupee Ingot");
        addAuto(ItemRegistry.raw_rupee, "Raw Rupee");
        addAuto(ItemRegistry.realmite_nugget, "Realmite Nugget");
        addAuto(ItemRegistry.realmite_ingot, "Realmite Ingot");
        addAuto(ItemRegistry.raw_realmite, "Raw Realmite");
        addAuto(ItemRegistry.realmite_dust, "Realmite Dust");
        addAuto(ItemRegistry.torridite_nugget, "Torridite Nugget");
        addAuto(ItemRegistry.torridite_ingot, "Torridite Ingot");
        addAuto(ItemRegistry.raw_torridite, "Raw Torridite");
        addAuto(ItemRegistry.torridite_chunk, "Torridite Chunk");
        addAuto(ItemRegistry.oxdrite_nugget, "Oxdrite Nugget");
        addAuto(ItemRegistry.oxdrite_ingot, "Oxdrite Ingot");
        addAuto(ItemRegistry.raw_oxdrite, "Raw Oxdrite");
        addAuto(ItemRegistry.shadow_bar, "Shadow Bar");
        addAuto(ItemRegistry.hellstone_ingot, "Hellstone Ingot");
        addAuto(ItemRegistry.pieceOfRawArcanium, "Piece of Raw Arcanium");
        addAuto(ItemRegistry.aquatic_pellets, "Aquatic Pellets");
        addAuto(ItemRegistry.pure_aquatic_pellets, "Pure Aquatic Pellets");
        addAuto(ItemRegistry.aquatic_ingot, "Aquatic Ingot");
        addAuto(ItemRegistry.rock_chunks, "Rock Chunks");
        addAuto(ItemRegistry.bedrock_chunk, "Bedrock Chunk");
        addAuto(ItemRegistry.anthracite, "Anthracite");
        addAuto(ItemRegistry.bloodgem, "Bloodgem");
        addAuto(ItemRegistry.olivine, "Olivine");
        addAuto(ItemRegistry.arcanium, "Arcanium");
        addAuto(ItemRegistry.eden_fragments, "Eden Fragments");
        addAuto(ItemRegistry.wildwood_fragments, "Wildwood Fragments");
        addAuto(ItemRegistry.apalachia_fragments, "Apalachia Fragments");
        addAuto(ItemRegistry.skythern_fragments, "Skythern Fragments");
        addAuto(ItemRegistry.mortum_fragments, "Mortum Fragments");
        addAuto(ItemRegistry.collector_fragments, "Collector Fragments");
        addAuto(ItemRegistry.purple_blaze, "Purple Blaze");
        addAuto(ItemRegistry.fury_fire, "Fury Fire");
        addAuto(ItemRegistry.shadow_coins, "Shadow Coins");
        addAuto(ItemRegistry.snowflake, "Snowflake");
        addAuto(ItemRegistry.dungeon_tokens, "Dungeon Tokens");
        addAuto(ItemRegistry.backsword_template, "Backsword Template");
        addAuto(ItemRegistry.hammer_template, "Hammer Template");
        addAuto(ItemRegistry.eden_sparkles, "Eden Sparkles");
        addAuto(ItemRegistry.teaker_lump, "Teaker Lump");
        addAuto(ItemRegistry.amthirmis_lump, "Amthirmis Lump");
        addAuto(ItemRegistry.darven_lump, "Darven Lump");
        addAuto(ItemRegistry.cermile_lump, "Cermile Lump");

        addAuto(BlockRegistry.realmiteOre, "Realmite Ore");
        addAuto(BlockRegistry.realmiteOreDeepslate, "Deepslate Realmite Ore");
        addAuto(BlockRegistry.arlemiteOre, "Arlemite Ore");
        addAuto(BlockRegistry.arlemiteOreDeepslate, "Deepslate Arlemite Ore");
        addAuto(BlockRegistry.rupeeOre, "Rupee Ore");
        addAuto(BlockRegistry.rupeeOreDeepslate, "Deepslate Rupee Ore");
        addAuto(BlockRegistry.bloodgemOre, "Bloodgem Ore");
        addAuto(BlockRegistry.torriditeOre, "Torridite Ore");
        addAuto(BlockRegistry.realmiteBlock, "Block of Realmite");
        addAuto(BlockRegistry.arlemiteBlock, "Block of Arlemite");
        addAuto(BlockRegistry.rupeeBlock, "Block of Rupee");
        addAuto(BlockRegistry.bloodgemBlock, "Block of Bloodgem");
        addAuto(BlockRegistry.torriditeBlock, "Block of Torridite");
        addAuto(BlockRegistry.frozenStone, "Frozen Stone");
        addAuto(BlockRegistry.frozenStairs, "Frozen Stairs");
        addAuto(BlockRegistry.frozenSlab, "Frozen Slab");
        addAuto(BlockRegistry.frozenPressurePlate, "Frozen Pressure Plate");
        addAuto(BlockRegistry.frozenButton, "Frozen Button");
        addAuto(BlockRegistry.cobaltite, "Cobaltite");
        addAuto(BlockRegistry.cobaltiteStairs, "Cobaltite Stairs");
        addAuto(BlockRegistry.cobaltiteSlab, "Cobaltite Slab");
        addAuto(BlockRegistry.cobaltiteWall, "Cobaltite Wall");
        addAuto(BlockRegistry.coalstone, "Coalstone");
        addAuto(BlockRegistry.coalstoneStairs, "Coalstone Stairs");
        addAuto(BlockRegistry.coalstoneSlab, "Coalstone Slab");
        addAuto(BlockRegistry.coalstoneWall, "Coalstone Wall");
        addAuto(BlockRegistry.arcaniteStone, "Arcanite Stone");
        addAuto(BlockRegistry.arcaniteStairs, "Arcanite Stairs");
        addAuto(BlockRegistry.arcaniteSlab, "Arcanite Slab");
        addAuto(BlockRegistry.arcaniteWall, "Arcanite Wall");
        addAuto(BlockRegistry.divinePlanks, "Divine Planks");
        addAuto(BlockRegistry.divineFence, "Divine Fence");
        addAuto(BlockRegistry.shiverspinePlanks, "Shiverspine Planks");
        addAuto(BlockRegistry.shiverspineFence, "Shiverspine Fence");
        addAuto(BlockRegistry.auroraoakPlanks, "Auroraoak Planks");
        addAuto(BlockRegistry.auroraoakFence, "Auroraoak Fence");
        addAuto(BlockRegistry.cozybarkPlanks, "Cozybark Planks");
        addAuto(BlockRegistry.cozybarkFence, "Cozybark Fence");
        addAuto(BlockRegistry.streamleafPlanks, "Streamleaf Planks");
        addAuto(BlockRegistry.streamleafFence, "Streamleaf Fence");
        addAuto(BlockRegistry.fireCrystal, "Fire Crystal");
        addAuto(BlockRegistry.firelight, "Firelight");
        addAuto(BlockRegistry.arcanaPortalFrame, "Arcana Portal Frame");
        addAuto(BlockRegistry.olivineBlock, "Block of Olivine");
        addAuto(BlockRegistry.cobaltitePressurePlate, "Cobaltite Pressure Plate");
        addAuto(BlockRegistry.cobaltiteButton, "Cobaltite Button");
        addAuto(BlockRegistry.twilightStone, "Twilight Stone");
        addAuto(BlockRegistry.twilightStairs, "Twilight Stairs");
        addAuto(BlockRegistry.twilightSlab, "Twilight Slab");
        addAuto(BlockRegistry.twilightWall, "Twilight Wall");
        addAuto(BlockRegistry.scorchalt, "Scorchalt");
        addAuto(BlockRegistry.scorchaltStairs, "Scorchalt Stairs");
        addAuto(BlockRegistry.scorchaltSlab, "Scorchalt Slab");
        addAuto(BlockRegistry.scorchaltWall, "Scorchalt Wall");
        addAuto(BlockRegistry.rayStone, "Ray Stone");
        addAuto(BlockRegistry.rayStoneStairs, "Ray Stone Stairs");
        addAuto(BlockRegistry.rayStoneSlab, "Ray Stone Slab");
        addAuto(BlockRegistry.rayStoneWall, "Ray Stone Wall");
        addAuto(BlockRegistry.divinePlanks, "Divine Planks");
        addAuto(BlockRegistry.divineStairs, "Divine Stairs");
        addAuto(BlockRegistry.divineSlab, "Divine Slab");
        addAuto(BlockRegistry.cobbledFrozenStone, "Cobbled Frozen Stone");
        addAuto(BlockRegistry.cobbledFrozenStairs, "Cobbled Frozen Stairs");
        addAuto(BlockRegistry.cobbledFrozenSlab, "Cobbled Frozen Slab");
        addAuto(BlockRegistry.cobbledFrozenWall, "Cobbled Frozen Wall");
        addAuto(BlockRegistry.cobbledScorchalt, "Cobbled Scorchalt");
        addAuto(BlockRegistry.cobbledScorchaltStairs, "Cobbled Scorchalt Stairs");
        addAuto(BlockRegistry.cobbledScorchaltSlab, "Cobbled Scorchalt Slab");
        addAuto(BlockRegistry.cobbledScorchaltWall, "Cobbled Scorchalt Wall");
        addAuto(BlockRegistry.frozenDirt, "Frozen Dirt");
        addAuto(BlockRegistry.arcaniteDirt, "Arcanite Dirt");
        addAuto(BlockRegistry.scorchedDirt, "Scorched Dirt");
        addAuto(BlockRegistry.rayDirt, "Ray Dirt");
        addAuto(BlockRegistry.wildwoodDirt, "Wildwood Dirt");
        addAuto(BlockRegistry.apalachiaDirt, "Apalachia Dirt");
        addAuto(BlockRegistry.frozenGrass, "Frozen Grass");
        addAuto(BlockRegistry.arcaniteGrass, "Arcanite Grass");
        addAuto(BlockRegistry.scorchedGrass, "Scorched Grass");

        addAuto("itemGroup.divinerpg.blocks", "DivineRPG: Blocks");
        addAuto("itemGroup.divinerpg.tools", "DivineRPG: Tools & Weapons");
        addAuto("itemGroup.divinerpg.misc", "DivineRPG: Misc");

        addPainting("fall", "Fall", "Sir_Deccy");
        addPainting("moonlight_rave", "Moonlight Rave", "Sir_Deccy");
        addPainting("grazing", "Grazing", "Sir_Deccy");
        addPainting("disturbed", "Disturbed", "Sir_Deccy");
        addPainting("levels", "Levels", "Sir_Deccy");
        addPainting("ice_age", "Ice Age", "Sir_Deccy");
        addPainting("crawling", "Monster", "Sir_Deccy");
        addPainting("howling_at_the_moon", "Howling at the Moon", "Sir_Deccy & Crazymtch42");
        addPainting("lurking_terror", "Lurking Terror", "Sir_Deccy & Derpanzerfisch");

        add("death.attack.divinerpg.acid", "%1$s melted in acid");
        add("death.attack.divinerpg.acid.player", "%1$s melted in acid while fighting %2$s");
        add("death.attack.divinerpg.arcana", "%1$s was killed by Arcana magic");
        add("death.attack.divinerpg.arcana.player", "%1$s was killed by Arcana magic while fighting %2$s");
        add("death.attack.divinerpg.hail", "%1$s was hit fatally by hail");
        add("death.attack.divinerpg.hail.player", "%1$s was hit fatally by hail while trying to escape %2$s");
        add("death.attack.divinerpg.spike", "%1$s walked on spikes");
        add("death.attack.divinerpg.spike.player", "%1$s walked on spikes while trying to escape %2$s");
        add("death.attack.divinerpg.tar", "%1$s tried to swim in smoldering tar");
        add("death.attack.divinerpg.tar.player", "%1$s tried to swim in smoldering tar to escape %2$s");
        add("death.attack.divinerpg.turtle", "%1$s was eaten by a Turtle");
        add("death.attack.divinerpg.turtle.player", "%1$s was eaten by a Turtle while trying to escape %2$s");

        addAuto("enchantment.divinerpg.rive", "Rive");
        addAuto("enchantment.divinerpg.aftershock", "Aftershock");
        addAuto("enchantment.divinerpg.brain_freeze", "Brain Freeze");
        addAuto("enchantment.divinerpg.insulation", "Insulation");

        addAuto("subtitles.divinerpg.acid_hag", "Acid Hag hisses");
        addAuto("subtitles.divinerpg.acid_hag_hurt", "Acid Hag grunts");
        addAuto("subtitles.divinerpg.alicanto", "Alicanto chirps");
        addAuto("subtitles.divinerpg.alicanto_hurt", "Alicanto squeaks");
        addAuto("subtitles.divinerpg.archer", "Archer fires");
        addAuto("subtitles.divinerpg.arid_warrior", "Arid Warrior grunts");
        addAuto("subtitles.divinerpg.arid_warrior_hurt", "Arid Warrior hurt");
        addAuto("subtitles.divinerpg.arid_warrior_death", "Arid Warrior dies");
        addAuto("subtitles.divinerpg.ayeraco", "Ayeraco roars");
        addAuto("subtitles.divinerpg.ayeraco_hurt", "Ayeraco hurt");
        addAuto("subtitles.divinerpg.ayeraco_spawn", "Ayeraco awakens");
        addAuto("subtitles.divinerpg.ayeraco_teleport", "Ayeraco teleports");
        addAuto("subtitles.divinerpg.biphron", "Biphron grunts");
        addAuto("subtitles.divinerpg.biphron_hurt", "Biphron hurt");
        addAuto("subtitles.divinerpg.bohemite", "Bohemite moves");
        addAuto("subtitles.divinerpg.bohemite_hurt", "Bohemite hurt");
        addAuto("subtitles.divinerpg.glinthop", "Glinthop jumps");
        addAuto("subtitles.divinerpg.glinthop_hurt", "Glinthop hurt");
        addAuto("subtitles.divinerpg.cadillion", "Cadillion sounds");
        addAuto("subtitles.divinerpg.constructor_hurt", "Constructor hurt");
        addAuto("subtitles.divinerpg.constructor_punch", "Constructor hits");
        addAuto("subtitles.divinerpg.cori", "Cori moves");
        addAuto("subtitles.divinerpg.cori_hurt", "Cori hurt");
        addAuto("subtitles.divinerpg.cori_idle", "Cori hums");
        addAuto("subtitles.divinerpg.cori_shoot", "Cori shoots");
        addAuto("subtitles.divinerpg.crab", "Crab clicks");
        addAuto("subtitles.divinerpg.crab_hurt", "Crab hurt");
        addAuto("subtitles.divinerpg.crawler", "Crawler creeps");
        addAuto("subtitles.divinerpg.crawler_hurt", "Crawler hurt");
        addAuto("subtitles.divinerpg.cyclops", "Cyclops stomps");
        addAuto("subtitles.divinerpg.cyclops_hurt", "Cyclops hurt");
        addAuto("subtitles.divinerpg.cymesoid", "Cymesoid drones");
        addAuto("subtitles.divinerpg.cymesoid_hurt", "Cymesoid hurt");
        addAuto("subtitles.divinerpg.deathcryx", "Deathcryx shrieks");
        addAuto("subtitles.divinerpg.deathcryx_hurt", "Deathcryx hurt");
        addAuto("subtitles.divinerpg.death_hound", "Death Hound howls");
        addAuto("subtitles.divinerpg.death_hound_hurt", "Death Hound hurt");
        addAuto("subtitles.divinerpg.densos", "Densos shouts");
        addAuto("subtitles.divinerpg.densos_hurt", "Densos hurt");
        addAuto("subtitles.divinerpg.dissiment", "Dissiment hisses");
        addAuto("subtitles.divinerpg.dissiment_hurt", "Dissiment hurt");
        addAuto("subtitles.divinerpg.dramcryx", "Dramcryx chatters");
        addAuto("subtitles.divinerpg.dramcryx_hurt", "Dramcryx hurt");
        addAuto("subtitles.divinerpg.dramix", "Dramix growls");
        addAuto("subtitles.divinerpg.dramix_hurt", "Dramix hurt");
        addAuto("subtitles.divinerpg.dream_wrecker", "Dream Wrecker stomps");
        addAuto("subtitles.divinerpg.dream_wrecker_hurt", "Dream Wrecker hurt");
        addAuto("subtitles.divinerpg.dungeon_prisoner", "Prisoner moans");
        addAuto("subtitles.divinerpg.dungeon_prisoner_change", "Prisoner transforms");
        addAuto("subtitles.divinerpg.dungeon_prisoner_hurt", "Prisoner hurt");
        addAuto("subtitles.divinerpg.duo", "Duo noises");
        addAuto("subtitles.divinerpg.duo_hurt", "Duo hurt");
        addAuto("subtitles.divinerpg.endiku", "Endiku grunts");
        addAuto("subtitles.divinerpg.endiku_hurt", "Endiku hurt");
        addAuto("subtitles.divinerpg.endiku_death", "Endiku dies");
        addAuto("subtitles.divinerpg.ent", "Ent creaks");
        addAuto("subtitles.divinerpg.ent_hurt", "Ent hurt");
        addAuto("subtitles.divinerpg.fractite", "Fractite clinks");
        addAuto("subtitles.divinerpg.fractite_attack", "Fractite attacks");
        addAuto("subtitles.divinerpg.fractite_hurt", "Fractite hurt");
        addAuto("subtitles.divinerpg.frozen_flesh", "Frozen flesh squelches");
        addAuto("subtitles.divinerpg.frozen_flesh_hurt", "Frozen flesh hurt");
        addAuto("subtitles.divinerpg.galroid", "Galroid beeps");
        addAuto("subtitles.divinerpg.galroid_hurt", "Galroid hurt");
        addAuto("subtitles.divinerpg.glacide", "Glacide slides");
        addAuto("subtitles.divinerpg.glacide_hurt", "Glacide hurt");
        addAuto("subtitles.divinerpg.gorgosion", "Gorgosion growls");
        addAuto("subtitles.divinerpg.gorgosion_hurt", "Gorgosion hurt");
        addAuto("subtitles.divinerpg.grizzle", "Grizzle grunts");
        addAuto("subtitles.divinerpg.grizzle_hurt", "Grizzle hurt");
        addAuto("subtitles.divinerpg.hastreus", "Hastreus bellows");
        addAuto("subtitles.divinerpg.hastreus_hurt", "Hastreus hurt");
        addAuto("subtitles.divinerpg.helio", "Helio glows");
        addAuto("subtitles.divinerpg.helio_hurt", "Helio hurt");
        addAuto("subtitles.divinerpg.hive_queen", "Hive Queen screeches");
        addAuto("subtitles.divinerpg.hive_queen_hurt", "Hive Queen hurt");
        addAuto("subtitles.divinerpg.hover_stinger", "Stinger buzzes");
        addAuto("subtitles.divinerpg.hover_stinger_hurt", "Stinger hurt");
        addAuto("subtitles.divinerpg.jackoman", "Jackoman cackles");
        addAuto("subtitles.divinerpg.jungle_spider", "Jungle Spider hisses");
        addAuto("subtitles.divinerpg.kazrotic", "Kazrotic hisses");
        addAuto("subtitles.divinerpg.kazrotic_hurt", "Kazrotic hurt");
        addAuto("subtitles.divinerpg.king_of_scorchers", "King of Scorchers roars");
        addAuto("subtitles.divinerpg.king_of_scorchers_hurt", "King of Scorchers hurt");
        addAuto("subtitles.divinerpg.kobblin", "Kobblin grunts");
        addAuto("subtitles.divinerpg.lady_luna", "Lady Luna hums");
        addAuto("subtitles.divinerpg.lady_luna_hurt", "Lady Luna hurt");
        addAuto("subtitles.divinerpg.lheiva", "Lheiva cries");
        addAuto("subtitles.divinerpg.lheiva_hurt", "Lheiva hurt");
        addAuto("subtitles.divinerpg.liopleurodon", "Liopleurodon growls");
        addAuto("subtitles.divinerpg.liopleurodon_hurt", "Liopleurodon hurt");
        addAuto("subtitles.divinerpg.liopleurodon_death", "Liopleurodon dies");
        addAuto("subtitles.divinerpg.livestock_merchant", "Merchant speaks");
        addAuto("subtitles.divinerpg.livestock_merchant_hurt", "Merchant hurt");
        addAuto("subtitles.divinerpg.lorga", "Lorga chatters");
        addAuto("subtitles.divinerpg.lorga_hurt", "Lorga hurt");
        addAuto("subtitles.divinerpg.lorga_flight", "Lorga flies");
        addAuto("subtitles.divinerpg.lorga_flight_hurt", "Lorga flies hurt");
        addAuto("subtitles.divinerpg.madivel", "Madivel groans");
        addAuto("subtitles.divinerpg.madivel_hurt", "Madivel hurt");
        addAuto("subtitles.divinerpg.megalith", "Megalith groans");
        addAuto("subtitles.divinerpg.megalith_hurt", "Megalith hurt");
        addAuto("subtitles.divinerpg.merchant", "Merchant speaks");
        addAuto("subtitles.divinerpg.merchant_hurt", "Merchant hurt");
        addAuto("subtitles.divinerpg.mucky", "Mucky squelches");
        addAuto("subtitles.divinerpg.nesro", "Nesro grunts");
        addAuto("subtitles.divinerpg.nesro_hurt", "Nesro hurt");
        addAuto("subtitles.divinerpg.parasecta", "Parasecta chirps");
        addAuto("subtitles.divinerpg.parasecta_hurt", "Parasecta hurt");
        addAuto("subtitles.divinerpg.rainbour", "Rainbour neighs");
        addAuto("subtitles.divinerpg.rainbour_hurt", "Rainbour hurt");
        addAuto("subtitles.divinerpg.razorback", "Razorback snorts");
        addAuto("subtitles.divinerpg.razorback_hurt", "Razorback hurt");
        addAuto("subtitles.divinerpg.reyvor", "Reyvor hisses");
        addAuto("subtitles.divinerpg.reyvor_hurt", "Reyvor hurt");
        addAuto("subtitles.divinerpg.roamer", "Roamer wanders");
        addAuto("subtitles.divinerpg.roamer_hurt", "Roamer hurt");
        addAuto("subtitles.divinerpg.rollum", "Rollum rolls");
        addAuto("subtitles.divinerpg.rollum_hurt", "Rollum hurt");
        addAuto("subtitles.divinerpg.rotatick", "Rotatick ticks");
        addAuto("subtitles.divinerpg.rotatick_hurt", "Rotatick hurt");
        addAuto("subtitles.divinerpg.shadahier", "Shadahier groans");
        addAuto("subtitles.divinerpg.shadahier_hurt", "Shadahier hurt");
        addAuto("subtitles.divinerpg.shark", "Shark splashes");
        addAuto("subtitles.divinerpg.shark_hurt", "Shark hurt");
        addAuto("subtitles.divinerpg.the_eye", "The Eye blinks");
        addAuto("subtitles.divinerpg.the_eye_hurt", "The Eye hurt");
        addAuto("subtitles.divinerpg.tocaxin", "Tocaxin speaks");
        addAuto("subtitles.divinerpg.tocaxin_hurt", "Tocaxin hurt");
        addAuto("subtitles.divinerpg.verek", "Verek grunts");
        addAuto("subtitles.divinerpg.verek_hurt", "Verek hurt");
        addAuto("subtitles.divinerpg.vermenous", "Vermenous hisses");
        addAuto("subtitles.divinerpg.vermenous_hurt", "Vermenous hurt");
        addAuto("subtitles.divinerpg.vhraak", "Vhraak screeches");
        addAuto("subtitles.divinerpg.vhraak_hurt", "Vhraak hurt");
        addAuto("subtitles.divinerpg.whale", "Whale sings");
        addAuto("subtitles.divinerpg.whale_hurt", "Whale hurt");
        addAuto("subtitles.divinerpg.wildfire", "Wildfire ignites");
        addAuto("subtitles.divinerpg.wildfire_hurt", "Wildfire hurt");
        addAuto("subtitles.divinerpg.wraith", "Wraith wails");
        addAuto("subtitles.divinerpg.wraith_hurt", "Wraith hurt");
        addAuto("subtitles.divinerpg.zone", "Zone drones");
        addAuto("subtitles.divinerpg.zone_hurt", "Zone hurt");
        addAuto("subtitles.divinerpg.zoragon", "Zoragon roars");
        addAuto("subtitles.divinerpg.zoragon_hurt", "Zoragon hurt");
        addAuto("subtitles.divinerpg.seng_ambient", "Seng ambient");
        addAuto("subtitles.divinerpg.seng_growl", "Seng growls");
        addAuto("subtitles.divinerpg.seng_hurt", "Seng hurt");
        addAuto("subtitles.divinerpg.blitz", "Blitz fires");
        addAuto("subtitles.divinerpg.divine_accumulator", "Accumulator hums");
        addAuto("subtitles.divinerpg.fractite_cannon", "Fractite Cannon fires");
        addAuto("subtitles.divinerpg.frost_cannon", "Frost Cannon fires");
        addAuto("subtitles.divinerpg.ghast_cannon", "Ghast Cannon fires");
        addAuto("subtitles.divinerpg.inferno_bow_charge", "Inferno Bow charges");
        addAuto("subtitles.divinerpg.inferno_bow_shoot", "Inferno Bow fires");
        addAuto("subtitles.divinerpg.phaser", "Phaser fires");
        addAuto("subtitles.divinerpg.shadow_saber", "Shadow Saber swings");
        addAuto("subtitles.divinerpg.staff", "Staff hums");
        addAuto("subtitles.divinerpg.vethea_bow", "Vethea Bow fires");
        addAuto("subtitles.divinerpg.nobody_can_defeat", "Nobody can defeat me!");
        addAuto("subtitles.divinerpg.deep_laugh", "Deep laughter");
        addAuto("subtitles.divinerpg.insect_fourteen_hurt", "Insect screech");
        addAuto("subtitles.divinerpg.starlight", "Starlight");
        addAuto("subtitles.divinerpg.growl", "Growl");
        addAuto("subtitles.divinerpg.skyre_ambient", "Skyre chirping");
        addAuto("subtitles.divinerpg.ayeraco_pillar", "Ayeraco pillar rising");
        addAuto("subtitles.divinerpg.you_cant_kill_me", "You can't kill me!");
        addAuto("subtitles.divinerpg.rift_ambient", "Rift humming");
        addAuto("subtitles.divinerpg.hiss", "Hiss");
        addAuto("subtitles.divinerpg.roar", "Roar");
        addAuto("subtitles.divinerpg.patchouli_open", "Book opens");
        addAuto("subtitles.divinerpg.skyre_spark", "Skyre sparks");
        addAuto("subtitles.divinerpg.arcanium_saber", "Arcanium saber hums");
        addAuto("subtitles.divinerpg.quadro_die_before", "Quadro: You'll die before me!");
        addAuto("subtitles.divinerpg.quadro_no_die", "Quadro: No! I won't die!");
        addAuto("subtitles.divinerpg.quadro_enough", "Quadro: That's enough!");
        addAuto("subtitles.divinerpg.skyre_die", "Skyre dies");
        addAuto("subtitles.divinerpg.vethea_teleport", "Vethea teleporting");
        addAuto("subtitles.divinerpg.snap", "Snap");
        addAuto("subtitles.divinerpg.ceiling_explosions", "Ceiling explosions");
        addAuto("subtitles.divinerpg.serenade", "Serenade");
        addAuto("subtitles.divinerpg.ayeraco_half_health", "Ayeraco: Half health!");
        addAuto("subtitles.divinerpg.karos_laugh", "Karos laughs");
        addAuto("subtitles.divinerpg.quadro_incoming_punch", "Quadro: Incoming punch!");
        addAuto("subtitles.divinerpg.golem", "Golem stomps");
        addAuto("subtitles.divinerpg.karos_intro", "Karos: Welcome!");
        addAuto("subtitles.divinerpg.raglok_dark", "Raglok: Darkness approaches");
        addAuto("subtitles.divinerpg.rift_close_muffled", "Rift closing");
        addAuto("subtitles.divinerpg.iceman_hurt", "Iceman hurt");
        addAuto("subtitles.divinerpg.rift_instability", "Rift instability");
        addAuto("subtitles.divinerpg.cave_crawler_step", "Crawler steps");
        addAuto("subtitles.divinerpg.quadro_kill_mine", "Quadro: That kill is mine!");
        addAuto("subtitles.divinerpg.sound_of_carols", "Sound of carols");
        addAuto("subtitles.divinerpg.wreck_strength", "Wreck gains strength");
        addAuto("subtitles.divinerpg.raglok_awaken", "Raglok awakens");
        addAuto("subtitles.divinerpg.wreck_speed", "Wreck gains speed");
        addAuto("subtitles.divinerpg.sound_of_music", "Sound of music");
        addAuto("subtitles.divinerpg.demon_of_darkness", "Demon of darkness");
        addAuto("subtitles.divinerpg.meet_doom", "Meet your doom!");
        addAuto("subtitles.divinerpg.mage_fire", "Mage fire");
        addAuto("subtitles.divinerpg.try_your_best", "Try your best!");
        addAuto("subtitles.divinerpg.patchouli_flip", "Page flips");
        addAuto("subtitles.divinerpg.frost", "Frost");
        addAuto("subtitles.divinerpg.saguaro_worm", "Saguaro worm");
        addAuto("subtitles.divinerpg.rift_open", "Rift opens");
        addAuto("subtitles.divinerpg.raglok_rain", "Raglok rain");
        addAuto("subtitles.divinerpg.insect", "Insect");
        addAuto("subtitles.divinerpg.explosions", "Explosions");
        addAuto("subtitles.divinerpg.raglok_guardian", "Raglok guardian");
        addAuto("subtitles.divinerpg.sparkler", "Sparkler");
        addAuto("subtitles.divinerpg.growl_hurt", "Growl hurt");
        addAuto("subtitles.divinerpg.stop_at_once", "Stop at once!");
        addAuto("subtitles.divinerpg.iceman", "Iceman");
        addAuto("subtitles.divinerpg.quadro_is_next", "Quadro: Who is next?");
        addAuto("subtitles.divinerpg.frostclaw_cannon", "Frostclaw cannon");
        addAuto("subtitles.divinerpg.raglok_nothing", "Raglok: Nothing remains");
        addAuto("subtitles.divinerpg.rift_replenish", "Rift replenishing");
        addAuto("subtitles.divinerpg.hell_spider", "Hell spider");
        addAuto("subtitles.divinerpg.iceika_portal_trigger", "Iceika portal active");
        addAuto("subtitles.divinerpg.firefly", "Firefly buzzing");
        addAuto("subtitles.divinerpg.quadro_my_kill", "Quadro: My kill!");
        addAuto("subtitles.divinerpg.reflector", "Reflector");
        addAuto("subtitles.divinerpg.rift_close", "Rift closed");
        addAuto("subtitles.divinerpg.wreck_intro", "Wreck intro");
        addAuto("subtitles.divinerpg.freeze", "Freeze");
        addAuto("subtitles.divinerpg.skyre_shoot", "Skyre shoots");
        addAuto("subtitles.divinerpg.raglok_avenge", "Raglok: Avenge me!");
        addAuto("subtitles.divinerpg.la_vekor", "La vekor");
        addAuto("subtitles.divinerpg.heal", "Healing");
        addAuto("subtitles.divinerpg.quadro_sit_down", "Quadro: Sit down!");
        addAuto("subtitles.divinerpg.scorcher", "Scorcher");
        addAuto("subtitles.divinerpg.feel_soul_arksiane", "Feel the soul!");
        addAuto("subtitles.divinerpg.high_hit", "High hit");
        addAuto("subtitles.divinerpg.quadro_taste_fist", "Quadro: Taste my fist!");
        addAuto("subtitles.divinerpg.croak", "Croak");
        addAuto("subtitles.divinerpg.mandragora", "Mandragora");
    }

    private void addAuto(Object key, String englishValue) {
        if (key instanceof String s) {
            addTranslation(s, englishValue);
            return;
        }
        String path = getPath(key);
        if (path == null) return;

        if (key instanceof Item || (key instanceof Supplier<?> s && s.get() instanceof Item)) {
            addTranslation("item." + MODID + "." + path, englishValue);
        }
        else if (key instanceof Block || (key instanceof Supplier<?> s && s.get() instanceof Block)) {
            addTranslation("block." + MODID + "." + path, englishValue);
            addTranslation("item." + MODID + "." + path, englishValue);
        } else {
            addTranslation(key.toString(), englishValue);
        }
    }

    private void addTranslation(String key, String englishValue) {
        if (!addedKeys.add(key)) {
            if (key.startsWith("subtitles.")) {
                DivineRPG.LOGGER.info("DEBUG: Subtitle key " + key + " was already registered. Checking if values match.");
            }
            return;
        }
        if (existingTranslations.containsKey(key)) {
            add(key, existingTranslations.get(key));
            return;
        }
        String targetText = englishValue;
        if (!locale.equals("en_us")) {
            String langCode = locale.split("_")[0];
            targetText = Utils.translate(langCode, englishValue);
        }
        add(key, targetText);
    }

    private String getPath(Object key) {
        if (key instanceof DeferredHolder<?, ?> holder) return holder.getId().getPath();
        if (key instanceof Block b) return BuiltInRegistries.BLOCK.getKey(b).getPath();
        if (key instanceof Item i) return BuiltInRegistries.ITEM.getKey(i).getPath();

        return null;
    }

    private void loadExistingTranslations(PackOutput output) {
        try {
            Path path = output.getOutputFolder().resolve("assets").resolve(MODID).resolve("lang").resolve(locale + ".json");
            if (Files.exists(path)) {
                try (Reader reader = Files.newBufferedReader(path)) {
                    JsonObject json = GSON.fromJson(reader, JsonObject.class);
                    if (json != null) {
                        json.entrySet().forEach(entry -> existingTranslations.put(entry.getKey(), entry.getValue().getAsString()));
                    }
                }
            }
        } catch (Exception e) {
            DivineRPG.LOGGER.info("Could not load existing translations for {}: {}", locale, e.getMessage());
        }
    }

    private void addPainting(String registryName, String title, String author) {
        addAuto("painting.divinerpg." + registryName + ".title", title);
        add("painting.divinerpg." + registryName + ".author", author);
    }

    @Override
    public String getName() {
        return "Languages: " + MODID + " (" + locale + ")";
    }
}