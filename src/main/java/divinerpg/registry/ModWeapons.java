package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.enums.ArrowType;
import divinerpg.enums.BulletType;
import divinerpg.enums.DiskType;
import divinerpg.objects.entities.entity.projectiles.EntitySoundOfCarols;
import divinerpg.objects.entities.entity.projectiles.EntitySoundOfMusic;
import divinerpg.objects.items.arcana.*;
import divinerpg.objects.items.base.*;
import divinerpg.objects.items.iceika.ItemMusicShooter;
import divinerpg.objects.items.iceika.ItemSerenadeOfIce;
import divinerpg.objects.items.twilight.*;
import divinerpg.objects.items.vanilla.*;
import divinerpg.objects.items.vethea.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created to ensure that weapons are registered after items, due to ToolMaterials requiring item instances.
 * Any weapons with tool materials must go here.
 * However, those without tool materials are still placed here for consistency and organizational purposes.
 */
@Mod.EventBusSubscriber
@ObjectHolder("divinerpg")
public class ModWeapons {

    // Vanilla dimension weapons
    @ObjectHolder("aquatic_maul")
    public static final Item aquaticMaul = null;
    @ObjectHolder("aquatic_dagger")
    public static final Item aquaticDagger = null;
    @ObjectHolder("aquatic_trident")
    public static final Item aquaticTrident = null;
    @ObjectHolder("aquaton")
    public static final Item aquaton = null;
    @ObjectHolder("aquatooth_maul")
    public static final Item aquatoothMaul = null;
    @ObjectHolder("aquatooth_sword")
    public static final Item aquatoothSword = null;
    @ObjectHolder("arlemite_stabber")
    public static final Item arlemiteStabber = null;
    @ObjectHolder("bedrock_maul")
    public static final Item bedrockMaul = null;
    @ObjectHolder("bedrock_sword")
    public static final Item bedrockSword = null;
    @ObjectHolder("black_ender_sword")
    public static final Item blackEnderSword = null;
    @ObjectHolder("bloodgem_sword")
    public static final Item bloodgem_sword = null;
    @ObjectHolder("blue_divine_sword")
    public static final Item blueDivineSword = null;
    @ObjectHolder("blue_ender_sword")
    public static final Item blueEnderSword = null;
    @ObjectHolder("bluefire_sword")
    public static final Item bluefireSword = null;
    @ObjectHolder("corrupted_maul")
    public static final Item corruptedMaul = null;
    @ObjectHolder("crabclaw_maul")
    public static final Item crabclawMaul = null;
    @ObjectHolder("cyclopsian_sword")
    public static final Item cyclopsianSword = null;
    @ObjectHolder("death_bringer")
    public static final Item deathBringer = null;
    @ObjectHolder("divine_sword")
    public static final Item divineSword = null;
    @ObjectHolder("dual_claw")
    public static final Item dualClaw = null;
    @ObjectHolder("ender_sword")
    public static final Item enderSword = null;
    @ObjectHolder("flaming_fury")
    public static final Item flamingFury = null;
    @ObjectHolder("frost_sword")
    public static final Item frostSword = null;
    @ObjectHolder("fury_maul")
    public static final Item furyMaul = null;
    @ObjectHolder("gray_divine_sword")
    public static final Item grayDivineSword = null;
    @ObjectHolder("green_divine_sword")
    public static final Item greenDivineSword = null;
    @ObjectHolder("green_ender_sword")
    public static final Item greenEnderSword = null;
    @ObjectHolder("inferno_sword")
    public static final Item infernoSword = null;
    @ObjectHolder("jungle_knife")
    public static final Item jungleKnife = null;
    @ObjectHolder("jungle_rapier")
    public static final Item jungleRapier = null;
    @ObjectHolder("molten_sword")
    public static final Item moltenSword = null;
    @ObjectHolder("ocean_knife")
    public static final Item oceanKnife = null;
    @ObjectHolder("poison_saber")
    public static final Item poisonSaber = null;
    @ObjectHolder("realmite_sword")
    public static final Item realmiteSword = null;
    @ObjectHolder("red_divine_sword")
    public static final Item redDivineSword = null;
    @ObjectHolder("red_ender_sword")
    public static final Item redEnderSword = null;
    @ObjectHolder("rupee_rapier")
    public static final Item rupeeRapier = null;
    @ObjectHolder("sandslash")
    public static final Item sandslash = null;
    @ObjectHolder("scorching_sword")
    public static final Item scorchingSword = null;
    @ObjectHolder("shark_sword")
    public static final Item sharkSword = null;
    @ObjectHolder("slime_sword")
    public static final Item slimeSword = null;
    @ObjectHolder("terran_dagger")
    public static final Item terranDagger = null;
    @ObjectHolder("terran_knife")
    public static final Item terranKnife = null;
    @ObjectHolder("terran_maul")
    public static final Item terranMaul = null;
    @ObjectHolder("yellow_divine_sword")
    public static final Item yellowDivineSword = null;
    @ObjectHolder("yellow_ender_sword")
    public static final Item yellowEnderSword = null;

    @ObjectHolder("bluefire_bow")
    public static final Item bluefireBow = null;
    @ObjectHolder("ender_bow")
    public static final Item enderBow = null;
    @ObjectHolder("hunter_bow")
    public static final Item hunterBow = null;
    @ObjectHolder("inferno_bow")
    public static final Item infernoBow = null;
    @ObjectHolder("shadow_bow")
    public static final Item shadowBow = null;

    @ObjectHolder("scythe")
    public static final Item scythe = null;

    @ObjectHolder("shuriken")
    public static final Item shuriken = null;
    @ObjectHolder("vile_storm")
    public static final Item vileStorm = null;

    @ObjectHolder("bowhead_anchor")
    public static final Item bowheadAnchor = null;
    @ObjectHolder("bowhead_cannon")
    public static final Item bowheadCannon = null;
    @ObjectHolder("corrupted_cannon")
    public static final Item corruptedCannon = null;
    @ObjectHolder("crab_anchor")
    public static final Item crabAnchor = null;
    @ObjectHolder("crabclaw_cannon")
    public static final Item crabclawCannon = null;
    @ObjectHolder("cyclopsian_staff")
    public static final Item cyclopsianStaff = null;
    @ObjectHolder("frost_cannon")
    public static final Item frostCannon = null;
    @ObjectHolder("ghast_cannon")
    public static final Item ghastCannon = null;
    @ObjectHolder("golden_fury")
    public static final Item goldenFury = null;
    @ObjectHolder("liopleurodon_anchor")
    public static final Item liopleurodonAnchor = null;
    @ObjectHolder("maelstrom")
    public static final Item maelstrom = null;
    @ObjectHolder("shark_anchor")
    public static final Item sharkAnchor = null;

    @ObjectHolder("sound_of_music")
    public static final Item soundOfMusic = null;

    @ObjectHolder("serenade_of_death")
    public static final Item serenadeOfDeath = null;
    @ObjectHolder("serenade_of_health")
    public static final Item serenadeOfHealth = null;
    @ObjectHolder("serenade_of_infusion")
    public static final Item serenadeOfInfusion = null;
    @ObjectHolder("serenade_striker")
    public static final Item serenadeStriker = null;

    @ObjectHolder("massivence")
    public static final Item massivence = null;
    @ObjectHolder("palavence")
    public static final Item palavence = null;


    // Iceika dimension weapons - melee
    @ObjectHolder("enderice")
    public static final Item enderice = null;
    @ObjectHolder("frostking_sword")
    public static final Item frostkingSword = null;
    @ObjectHolder("frozen_maul")
    public static final Item frozenMaul = null;
    @ObjectHolder("glacier_sword")
    public static final Item glacierSword = null;
    @ObjectHolder("icicle_bane")
    public static final Item icicleBane = null;
    @ObjectHolder("icine_sword")
    public static final Item icineSword = null;
    @ObjectHolder("snowslash")
    public static final Item snowslash = null;
    @ObjectHolder("frossivence")
    public static final Item frossivence = null;

    // Iceika dimension weapons - ranged
    @ObjectHolder("icicle_bow")
    public static final Item icicleBow = null;
    @ObjectHolder("snowstorm_bow")
    public static final Item snowstormBow = null;

    @ObjectHolder("snowflake_shuriken")
    public static final Item snowflakeShuriken = null;

    @ObjectHolder("fractite_cannon")
    public static final Item fractiteCannon = null;
    @ObjectHolder("frostclaw_cannon")
    public static final Item frostclawCannon = null;

    @ObjectHolder("sound_of_carols")
    public static final Item soundOfCarols = null;

    @ObjectHolder("serenade_of_ice")
    public static final Item serenadeOfIce = null;

    // Twilight swords
    @ObjectHolder("eden_blade")
    public static final Item edenBlade = null;
    @ObjectHolder("wildwood_blade")
    public static final Item wildwoodBlade = null;
    @ObjectHolder("apalachia_blade")
    public static final Item apalachiaBlade = null;
    @ObjectHolder("skythern_blade")
    public static final Item skythernBlade = null;
    @ObjectHolder("mortum_blade")
    public static final Item mortumBlade = null;
    @ObjectHolder("halite_blade")
    public static final Item haliteBlade = null;

    // Twilight bows
    @ObjectHolder("eden_bow")
    public static final Item edenBow = null;
    @ObjectHolder("wildwood_bow")
    public static final Item wildwoodBow = null;
    @ObjectHolder("apalachia_bow")
    public static final Item apalachiaBow = null;
    @ObjectHolder("skythern_bow")
    public static final Item skythernBow = null;
    @ObjectHolder("mortum_bow")
    public static final Item mortumBow = null;
    @ObjectHolder("halite_bow")
    public static final Item haliteBow = null;
    @ObjectHolder("twilight_bow")
    public static final Item twilightBow = null;

    // Twilight slicers
    @ObjectHolder("eden_slicer")
    public static final Item edenSlicer = null;
    @ObjectHolder("wildwood_slicer")
    public static final Item wildwoodSlicer = null;
    @ObjectHolder("apalachia_slicer")
    public static final Item apalachiaSlicer = null;
    @ObjectHolder("skythern_slicer")
    public static final Item skythernSlicer = null;
    @ObjectHolder("mortum_slicer")
    public static final Item mortumSlicer = null;
    @ObjectHolder("halite_slicer")
    public static final Item haliteSlicer = null;

    // Twilight blitzes
    @ObjectHolder("eden_blitz")
    public static final Item edenBlitz = null;
    @ObjectHolder("wildwood_blitz")
    public static final Item wildwoodBlitz = null;
    @ObjectHolder("apalachia_blitz")
    public static final Item apalachiaBlitz = null;
    @ObjectHolder("skythern_blitz")
    public static final Item skythernBlitz = null;
    @ObjectHolder("mortum_blitz")
    public static final Item mortumBlitz = null;
    @ObjectHolder("halite_blitz")
    public static final Item haliteBlitz = null;

    // Twilight phasers
    @ObjectHolder("eden_phaser")
    public static final Item edenPhaser = null;
    @ObjectHolder("wildwood_phaser")
    public static final Item wildwoodPhaser = null;
    @ObjectHolder("apalachia_phaser")
    public static final Item apalachiaPhaser = null;
    @ObjectHolder("skythern_phaser")
    public static final Item skythernPhaser = null;
    @ObjectHolder("mortum_phaser")
    public static final Item mortumPhaser = null;
    @ObjectHolder("halite_phaser")
    public static final Item halitePhaser = null;

    // Arcana melee
    @ObjectHolder("arcanite_blade")
    public static final Item arcaniteBlade = null;
    @ObjectHolder("arcanium_saber")
    public static final Item arcaniumSaber = null;
    @ObjectHolder("ender_scepter")
    public static final Item enderScepter = null;
    @ObjectHolder("livicia_sword")
    public static final Item liviciaSword = null;
    @ObjectHolder("shadow_saber")
    public static final Item shadowSaber = null;
    @ObjectHolder("storm_sword")
    public static final Item stormSword = null;

    // Arcana ranged
    @ObjectHolder("arcanite_blaster")
    public static final Item arcaniteBlaster = null;
    @ObjectHolder("captains_sparkler")
    public static final Item captainsSparkler = null;
    @ObjectHolder("firefly")
    public static final Item firefly = null;
    @ObjectHolder("generals_staff")
    public static final Item generalsStaff = null;
    @ObjectHolder("la_vekor")
    public static final Item laVekor = null;
    @ObjectHolder("meriks_missile")
    public static final Item meriksMissile = null;
    @ObjectHolder("meteor_mash")
    public static final Item meteorMash = null;
    @ObjectHolder("staff_of_starlight")
    public static final Item staffOfStarlight = null;
    @ObjectHolder("starlight")
    public static final Item starlight = null;

    // Arcana throwable
    @ObjectHolder("grenade")
    public static final Item grenade = null;

    // Vethea weapons
    // Backsword
    @ObjectHolder("teaker_backsword")
    public static final Item teakerBacksword = null;
    @ObjectHolder("amthirmis_backsword")
    public static final Item amthirmisBacksword = null;
    @ObjectHolder("darven_backsword")
    public static final Item darvenBacksword = null;
    @ObjectHolder("cermile_backsword")
    public static final Item cermileBacksword = null;
    @ObjectHolder("pardimal_backsword")
    public static final Item pardimalBacksword = null;
    @ObjectHolder("quadrotic_backsword")
    public static final Item quadroticBacksword = null;
    @ObjectHolder("karos_backsword")
    public static final Item karosBacksword = null;
    @ObjectHolder("heliosis_backsword")
    public static final Item heliosisBacksword = null;
    @ObjectHolder("arksiane_backsword")
    public static final Item arksianeBacksword = null;

    // Bow
    @ObjectHolder("teaker_bow")
    public static final Item teakerBow = null;
    @ObjectHolder("amthirmis_bow")
    public static final Item amthirmisBow = null;
    @ObjectHolder("darven_bow")
    public static final Item darvenBow = null;
    @ObjectHolder("cermile_bow")
    public static final Item cermileBow = null;
    @ObjectHolder("pardimal_bow")
    public static final Item pardimalBow = null;
    @ObjectHolder("quadrotic_bow")
    public static final Item quadroticBow = null;
    @ObjectHolder("karos_bow")
    public static final Item karosBow = null;
    @ObjectHolder("heliosis_bow")
    public static final Item heliosisBow = null;
    @ObjectHolder("arksiane_bow")
    public static final Item arksianeBow = null;
    @ObjectHolder("everfright")
    public static final Item everfright = null;

    // Cannon
    @ObjectHolder("teaker_cannon")
    public static final Item teakerCannon = null;
    @ObjectHolder("amthirmis_cannon")
    public static final Item amthirmisCannon = null;
    @ObjectHolder("darven_cannon")
    public static final Item darvenCannon = null;
    @ObjectHolder("cermile_cannon")
    public static final Item cermileCannon = null;
    @ObjectHolder("pardimal_cannon")
    public static final Item pardimalCannon = null;
    @ObjectHolder("quadrotic_cannon")
    public static final Item quadroticCannon = null;
    @ObjectHolder("karos_cannon")
    public static final Item karosCannon = null;
    @ObjectHolder("heliosis_cannon")
    public static final Item heliosisCannon = null;
    @ObjectHolder("arksiane_cannon")
    public static final Item arksianeCannon = null;
    @ObjectHolder("eversight")
    public static final Item eversight = null;

    // Claw
    @ObjectHolder("teaker_claw")
    public static final Item teakerClaw = null;
    @ObjectHolder("amthirmis_claw")
    public static final Item amthirmisClaw = null;
    @ObjectHolder("darven_claw")
    public static final Item darvenClaw = null;
    @ObjectHolder("cermile_claw")
    public static final Item cermileClaw = null;
    @ObjectHolder("pardimal_claw")
    public static final Item pardimalClaw = null;
    @ObjectHolder("quadrotic_claw")
    public static final Item quadroticClaw = null;
    @ObjectHolder("karos_claw")
    public static final Item karosClaw = null;
    @ObjectHolder("heliosis_claw")
    public static final Item heliosisClaw = null;
    @ObjectHolder("arksiane_claw")
    public static final Item arksianeClaw = null;
    @ObjectHolder("everbright")
    public static final Item everbright = null;

    // Disk
    @ObjectHolder("teaker_disk")
    public static final Item teakerDisk = null;
    @ObjectHolder("amthirmis_disk")
    public static final Item amthirmisDisk = null;
    @ObjectHolder("darven_disk")
    public static final Item darvenDisk = null;
    @ObjectHolder("cermile_disk")
    public static final Item cermileDisk = null;
    @ObjectHolder("pardimal_disk")
    public static final Item pardimalDisk = null;
    @ObjectHolder("quadrotic_disk")
    public static final Item quadroticDisk = null;
    @ObjectHolder("karos_disk")
    public static final Item karosDisk = null;
    @ObjectHolder("heliosis_disk")
    public static final Item heliosisDisk = null;
    @ObjectHolder("arksiane_disk")
    public static final Item arksianeDisk = null;

    // Hammer
    @ObjectHolder("teaker_hammer")
    public static final Item teakerHammer = null;
    @ObjectHolder("amthirmis_hammer")
    public static final Item amthirmisHammer = null;
    @ObjectHolder("darven_hammer")
    public static final Item darvenHammer = null;
    @ObjectHolder("cermile_hammer")
    public static final Item cermileHammer = null;
    @ObjectHolder("pardimal_hammer")
    public static final Item pardimalHammer = null;
    @ObjectHolder("quadrotic_hammer")
    public static final Item quadroticHammer = null;
    @ObjectHolder("karos_hammer")
    public static final Item karosHammer = null;
    @ObjectHolder("heliosis_hammer")
    public static final Item heliosisHammer = null;
    @ObjectHolder("arksiane_hammer")
    public static final Item arksianeHammer = null;
    @ObjectHolder("everlight")
    public static final Item everlight = null;
    @ObjectHolder("karos_rockmaul")
    public static final Item karosRockmaul = null;

    // Staff
    @ObjectHolder("teaker_staff")
    public static final Item teakerStaff = null;
    @ObjectHolder("amthirmis_staff")
    public static final Item amthirmisStaff = null;
    @ObjectHolder("darven_staff")
    public static final Item darvenStaff = null;
    @ObjectHolder("cermile_staff")
    public static final Item cermileStaff = null;
    @ObjectHolder("pardimal_staff")
    public static final Item pardimalStaff = null;
    @ObjectHolder("quadrotic_staff")
    public static final Item quadroticStaff = null;
    @ObjectHolder("karos_staff")
    public static final Item karosStaff = null;
    @ObjectHolder("heliosis_staff")
    public static final Item heliosisStaff = null;
    @ObjectHolder("arksiane_staff")
    public static final Item arksianeStaff = null;
    @ObjectHolder("evernight")
    public static final Item evernight = null;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        DivineRPG.logger.info("Registering DivineRPG weapons");

        IForgeRegistry<Item> registry = event.getRegistry();

        // Vanilla dimension weapons
        register(registry, new ItemModSword(ToolMaterialMod.AQUA_DAGGER, "aquatic_dagger"));
        register(registry, new ItemModSword(ToolMaterialMod.AQUA_MAUL, "aquatic_maul"));
        register(registry, new ItemModSword(ToolMaterialMod.AQUA_TRIDENT, "aquatic_trident"));
        register(registry, new ItemModSword(ToolMaterialMod.AQUATON, "aquaton"));
        register(registry, new ItemModSword(ToolMaterialMod.AQUATOOTH_MAUL, "aquatooth_maul"));
        register(registry, new ItemModSword(ToolMaterialMod.AQUATOOTH_SWORD, "aquatooth_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.ARLEMITE_STABBER, "arlemite_stabber"));
        register(registry, new ItemModSword(ToolMaterialMod.BEDROCK_SWORD, "bedrock_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.BEDROCK_MAUL, "bedrock_maul"));
        register(registry, new ItemModSword(ToolMaterialMod.BLOODGEM_SWORD, "bloodgem_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.BLUEFIRE_SWORD, "bluefire_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.CORRUPTED_MAUL, "corrupted_maul"));
        register(registry, new ItemModSword(ToolMaterialMod.CRABCLAW_MAUL, "crabclaw_maul"));
        register(registry, new ItemModSword(ToolMaterialMod.CYCLOPSIAN_SWORD, "cyclopsian_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.DEATH_BRINGER, "death_bringer"));
        register(registry, new ItemModSword(ToolMaterialMod.DIVINE_SWORD, "blue_divine_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.DIVINE_SWORD, "divine_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.DIVINE_SWORD, "gray_divine_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.DIVINE_SWORD, "green_divine_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.DIVINE_SWORD, "red_divine_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.DIVINE_SWORD, "yellow_divine_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.DUAL_CLAW, "dual_claw"));
        register(registry, new ItemModSword(ToolMaterialMod.ENDER_SWORD, "black_ender_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.ENDER_SWORD, "blue_ender_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.ENDER_SWORD, "ender_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.ENDER_SWORD, "green_ender_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.ENDER_SWORD, "red_ender_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.ENDER_SWORD, "yellow_ender_sword"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.FROST_SWORD, "frost_sword"));
        register(registry, new ItemBurningSword(ToolMaterialMod.FLAMING_FURY, "flaming_fury", 15));
        register(registry, new ItemModSword(ToolMaterialMod.FURY_MAUL, "fury_maul"));
        register(registry, new ItemBurningSword(ToolMaterialMod.INFERNO_SWORD, "inferno_sword", 12));
        register(registry, new ItemPoisonousSword(ToolMaterialMod.JUNGLE_KNIFE, "jungle_knife", 2.5f));
        register(registry, new ItemPoisonousSword(ToolMaterialMod.JUNGLE_RAPIER, "jungle_rapier", 4f));
        register(registry, new ItemBurningSword(ToolMaterialMod.MOLTEN_SWORD, "molten_sword", 5));
        register(registry, new ItemModSword(ToolMaterialMod.OCEAN_KNIFE, "ocean_knife"));
        register(registry, new ItemPoisonousSword(ToolMaterialMod.POISON_SABER, "poison_saber", 5));
        register(registry, new ItemModSword(ToolMaterialMod.REALMITE_SWORD, "realmite_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.RUPEE_RAPIER, "rupee_rapier"));
        register(registry, new ItemModSword(ToolMaterialMod.SANDSLASH, "sandslash"));
        register(registry, new ItemModSword(ToolMaterialMod.SCORCHING_SWORD, "scorching_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.SHARK_SWORD, "shark_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.SLIME_SWORD, "slime_sword"));
        register(registry, new ItemModSword(ToolMaterialMod.TERRAN_DAGGER, "terran_dagger"));
        register(registry, new ItemModSword(ToolMaterialMod.TERRAN_KNIFE, "terran_knife"));
        register(registry, new ItemModSword(ToolMaterialMod.TERRAN_MAUL, "terran_maul"));

        register(registry, new ItemModBow("bluefire_bow", ArrowType.BLUEFIRE_ARROW, -1));
        register(registry, new ItemModBow("ender_bow", ArrowType.ENDER_ARROW, -1));
        register(registry, new ItemModBow("hunter_bow", ArrowType.HUNTER_ARROW, 2500, () -> Items.ARROW));
        register(registry, new ItemModBow("inferno_bow", ArrowType.INFERNO_ARROW, 10000));
        register(registry, new ItemModBow("shadow_bow", ArrowType.SHADOW_ARROW, 10000, 36000, () -> Items.ARROW));

        register(registry, new ItemScythe("scythe"));

        register(registry, new ItemThrowable("shuriken", BulletType.SHURIKEN_SHOT));
        register(registry, new ItemVileStorm("vile_storm"));

        register(registry, new ItemAnchor("bowhead_anchor", BulletType.BOWHEAD_ANCHOR_SHOT));
        register(registry, new RangedWeaponBase("bowhead_cannon", BulletType.BOWHEAD_CANNON_SHOT, ModSounds.GHAST_CANNON, () -> Item.getItemFromBlock(Blocks.CACTUS), 1000, 12));
        register(registry, new ItemCorruptedCannon("corrupted_cannon"));
        register(registry, new ItemAnchor("crab_anchor", BulletType.CRAB_ANCHOR_SHOT));
        register(registry, new RangedWeaponBase("crabclaw_cannon", BulletType.CRABCLAW_CANNON_SHOT, ModSounds.GHAST_CANNON, () -> Item.getItemFromBlock(Blocks.CACTUS), 1000, 12));
        register(registry, new RangedWeaponBase("cyclopsian_staff", BulletType.CYCLOPSIAN_STAFF_SHOT, ModSounds.STAFF, 600, 0));
        register(registry, new RangedWeaponBase("frost_cannon", BulletType.FROST_CANNON_SHOT, ModSounds.FROST_CANNON, () -> Items.SNOWBALL, 15000, 0));
        register(registry, new RangedWeaponBase("ghast_cannon", BulletType.GHAST_CANNON_SHOT, ModSounds.GHAST_CANNON, 100, 20));
        register(registry, new RangedWeaponBase("golden_fury", BulletType.GOLDEN_FURY_SHOT, ModSounds.BLITZ, () -> Items.GOLD_NUGGET, -1, 0));
        register(registry, new ItemAnchor("liopleurodon_anchor", BulletType.LIOPLEURODON_ANCHOR_SHOT));
        register(registry, new RangedWeaponBase("maelstrom", BulletType.MAELSTROM_SHOT, ModSounds.GHAST_CANNON, 100, 0));
        register(registry, new ItemAnchor("shark_anchor", BulletType.SHARK_ANCHOR_SHOT));

        register(registry, new ItemSerenadeOfDeath("serenade_of_death"));
        register(registry, new ItemSerenadeOfHealth("serenade_of_health"));
        register(registry, new ItemSerenadeOfInfusion("serenade_of_infusion"));
        register(registry, new ItemSerenadeStriker("serenade_striker"));

        register(registry, new ItemHealingSword("massivence", ToolMaterialMod.PALAVENCE, 1F));
        register(registry, new ItemHealingSword("palavence", ToolMaterialMod.PALAVENCE, 0.5F));

        // Iceika
        // Iceika dimension weapons - melee
        register(registry, new ItemSlowingSword(ToolMaterialMod.ENDERICE, "enderice"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.FROSTKING_SWORD, "frostking_sword"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.FROZEN_MAUL, "frozen_maul"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.GLACIER_SWORD, "glacier_sword"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.ICINE_SWORD, "icine_sword"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.SNOWSLASH, "snowslash"));
        register(registry, new ItemSlowingSword(ToolMaterialMod.ICICLE_BANE, "icicle_bane"));

        register(registry, new ItemHealingSword("frossivence", ToolMaterialMod.FROSSIVENCE, 1F));

        // Iceika dimension weapons - ranged
        register(registry, new ItemModBow("snowstorm_bow", ArrowType.SNOWSTORM_ARROW, -1));
        register(registry, new ItemModBow("icicle_bow", ArrowType.ICICLE_ARROW, 10000, 24000, () -> Items.ARROW));

        register(registry, new ItemThrowable("snowflake_shuriken", BulletType.SNOWFLAKE_SHURIKEN_SHOT));

        register(registry, new RangedWeaponBase("fractite_cannon", BulletType.FRACTITE_CANNON_SHOT, ModSounds.FRACTITE_CANNON, () -> ModItems.iceShards, 10000, 0));
        register(registry, new RangedWeaponBase("frostclaw_cannon", BulletType.FROSTCLAW_CANNON_SHOT, ModSounds.FROSTCLAW_CANNON, () -> Item.getItemFromBlock(Blocks.CACTUS), 10000, 0));

        register(registry, new ItemMusicShooter("sound_of_music", ModSounds.SOUND_OF_MUSIC, EntitySoundOfMusic.class));
        register(registry, new ItemMusicShooter("sound_of_carols", ModSounds.SOUND_OF_CAROLS, EntitySoundOfCarols.class));

        register(registry, new ItemSerenadeOfIce("serenade_of_ice"));

        // Twilight Dimensions
        // Twilight swords
        register(registry, new ItemModSword(ToolMaterialMod.EDEN_BLADE, "eden_blade"));
        register(registry, new ItemModSword(ToolMaterialMod.WILDWOOD_BLADE, "wildwood_blade"));
        register(registry, new ItemModSword(ToolMaterialMod.APALACHIA_BLADE, "apalachia_blade"));
        register(registry, new ItemModSword(ToolMaterialMod.SKYTHERN_BLADE, "skythern_blade"));
        register(registry, new ItemModSword(ToolMaterialMod.MORTUM_BLADE, "mortum_blade"));
        register(registry, new ItemModSword(ToolMaterialMod.HALITE_BLADE, "halite_blade"));

        // Twilight bows
        register(registry, new ItemModBow("eden_bow", ArrowType.EDEN_ARROW, -1, () -> ModItems.edenArrow));
        register(registry, new ItemModBow("wildwood_bow", ArrowType.LESSER_WILDWOOD_ARROW, -1, 36000, () -> ModItems.wildwoodArrow));
        register(registry, new ItemModBow("apalachia_bow", ArrowType.GREATER_WILDWOOD_ARROW, -1, () -> ModItems.wildwoodArrow));
        register(registry, new ItemModBow("skythern_bow", ArrowType.GREATER_WILDWOOD_ARROW, -1, 36000, () -> ModItems.wildwoodArrow));
        register(registry, new ItemModBow("mortum_bow", ArrowType.FURY_ARROW, -1, () -> ModItems.furyArrow));
        register(registry, new ItemModBow("halite_bow", ArrowType.FURY_ARROW, -1, 36000, () -> ModItems.furyArrow));
        register(registry, new ItemModBow("twilight_bow", ArrowType.FURY_ARROW, -1, 14400, () -> ModItems.furyArrow));

        // Twilight slicers
        register(registry, new ItemThrowable("eden_slicer", BulletType.EDEN_SLICER_SHOT));
        register(registry, new ItemThrowable("wildwood_slicer", BulletType.WILDWOOD_SLICER_SHOT));
        register(registry, new ItemThrowable("apalachia_slicer", BulletType.APALACHIA_SLICER_SHOT));
        register(registry, new ItemThrowable("skythern_slicer", BulletType.SKYTHERN_SLICER_SHOT));
        register(registry, new ItemThrowable("mortum_slicer", BulletType.MORTUM_SLICER_SHOT));
        register(registry, new ItemThrowable("halite_slicer", BulletType.HALITE_SLICER_SHOT));

        // Twilight blitzes
        register(registry, new ItemTwilightBlitz("eden_blitz", BulletType.EDEN_BLITZ_SHOT, () -> ModItems.edenDust));
        register(registry, new ItemTwilightBlitz("wildwood_blitz", BulletType.WILDWOOD_BLITZ_SHOT, () -> ModItems.wildwoodDust));
        register(registry, new ItemTwilightBlitz("apalachia_blitz", BulletType.APALACHIA_BLITZ_SHOT, () -> ModItems.apalachiaDust));
        register(registry, new ItemTwilightBlitz("skythern_blitz", BulletType.SKYTHERN_BLITZ_SHOT, () -> ModItems.skythernDust));
        register(registry, new ItemTwilightBlitz("mortum_blitz", BulletType.MORTUM_BLITZ_SHOT, () -> ModItems.mortumDust));
        register(registry, new ItemTwilightBlitz("halite_blitz", BulletType.HALITE_BLITZ_SHOT, () -> ModItems.mortumDust));

        // Twilight phasers
        register(registry, new RangedWeaponBase("eden_phaser", BulletType.EDEN_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        register(registry, new RangedWeaponBase("wildwood_phaser", BulletType.WILDWOOD_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        register(registry, new RangedWeaponBase("apalachia_phaser", BulletType.APALACHIA_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        register(registry, new RangedWeaponBase("skythern_phaser", BulletType.SKYTHERN_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        register(registry, new RangedWeaponBase("mortum_phaser", BulletType.MORTUM_PHASER_SHOT, ModSounds.PHASER, 3000, 12));
        register(registry, new RangedWeaponBase("halite_phaser", BulletType.HALITE_PHASER_SHOT, ModSounds.PHASER, 3000, 12));

        // Arcana
        // Arcana melee
        register(registry, new ItemArcaniteBlade());
        register(registry, new ItemArcaniumSaber("arcanium_saber", ToolMaterialMod.ARCANIUM_SABER));
        register(registry, new ItemEnderScepter("ender_scepter"));
        register(registry, new ItemModSword(ToolMaterialMod.LIVICIA_SWORD, "livicia_sword"));
        register(registry, new ItemStormSword("storm_sword", ToolMaterialMod.STORM_SWORD));
        register(registry, new ItemShadowSaber("shadow_saber", ToolMaterialMod.SHADOW_SABER));

        // Arcana ranged
        register(registry, new ItemArcaniteBlaster());
        register(registry, new ItemCaptainsSparkler("captains_sparkler"));
        register(registry, new ItemFirefly());
        register(registry, new ItemGeneralsStaff());
        register(registry, new ItemLaVekor());
        register(registry, new ItemMeriksMissile("meriks_missile"));
        register(registry, new ItemMeteorMash());
        register(registry, new ItemStaffStarlight("starlight", 5, 1));
        register(registry, new ItemStaffStarlight("staff_of_starlight", 25, 8));

        // Arcana throwable
        register(registry, new ItemGrenade("grenade"));

        // Vethea weapons
        // Backsword
        register(registry, new ItemVetheanSword(ToolMaterialMod.TEAKER_BACKSWORD, "teaker_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.AMTHIRMIS_BACKSWORD, "amthirmis_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.DARVEN_BACKSWORD, "darven_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.CERMILE_BACKSWORD, "cermile_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.PARDIMAL_BACKSWORD, "pardimal_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.QUADROTIC_BACKSWORD, "quadrotic_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.KAROS_BACKSWORD, "karos_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.HELIOSIS_BACKSWORD, "heliosis_backsword"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.ARKSIANE_BACKSWORD, "arksiane_backsword"));

        // Bow
        register(registry, new ItemVetheanBow("teaker_bow", ArrowType.TEAKER_ARROW, -1, () -> ModItems.teakerArrow));
        register(registry, new ItemVetheanBow("amthirmis_bow", ArrowType.AMTHIRMIS_ARROW, -1, () -> ModItems.teakerArrow));
        register(registry, new ItemVetheanBow("darven_bow", ArrowType.DARVEN_ARROW, -1, () -> ModItems.darvenArrow));
        register(registry, new ItemVetheanBow("cermile_bow", ArrowType.CERMILE_ARROW, -1, () -> ModItems.darvenArrow));
        register(registry, new ItemVetheanBow("pardimal_bow", ArrowType.PARDIMAL_ARROW, -1, () -> ModItems.pardimalArrow));
        register(registry, new ItemVetheanBow("quadrotic_bow", ArrowType.QUADROTIC_ARROW, -1, () -> ModItems.pardimalArrow));
        register(registry, new ItemVetheanBow("karos_bow", ArrowType.KAROS_ARROW, -1, () -> ModItems.karosArrow));
        register(registry, new ItemVetheanBow("heliosis_bow", ArrowType.HELIOSIS_ARROW, -1, () -> ModItems.karosArrow));
        register(registry, new ItemVetheanBow("arksiane_bow", ArrowType.ARKSIANE_ARROW, -1, () -> ModItems.karosArrow));
        register(registry, new ItemVetheanBow("everfright", ArrowType.EVERFRIGHT, -1, () -> ModItems.everArrow));

        // Cannon
        register(registry, new ItemVetheanCannon("teaker_cannon", BulletType.TEAKER_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("amthirmis_cannon", BulletType.AMTHIRMIS_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("darven_cannon", BulletType.DARVEN_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("cermile_cannon", BulletType.CERMILE_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("pardimal_cannon", BulletType.PARDIMAL_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("quadrotic_cannon", BulletType.QUADROTIC_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("karos_cannon", BulletType.KAROS_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("heliosis_cannon", BulletType.HELIOSIS_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("arksiane_cannon", BulletType.ARKSIANE_CANNON_SHOT, () -> ModItems.acid));
        register(registry, new ItemVetheanCannon("eversight", BulletType.EVERSIGHT_SHOT, () -> ModItems.acid));

        // Claw
        register(registry, new ItemVetheanSword(ToolMaterialMod.TEAKER_CLAW, "teaker_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.AMTHIRMIS_CLAW, "amthirmis_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.DARVEN_CLAW, "darven_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.CERMILE_CLAW, "cermile_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.PARDIMAL_CLAW, "pardimal_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.QUADROTIC_CLAW, "quadrotic_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.KAROS_CLAW, "karos_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.HELIOSIS_CLAW, "heliosis_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.ARKSIANE_CLAW, "arksiane_claw"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.EVERBRIGHT, "everbright"));

        // Disk
        register(registry, new ItemVetheanDisk("teaker_disk", DiskType.TEAKER_DISK));
        register(registry, new ItemVetheanDisk("amthirmis_disk", DiskType.AMTHRIMIS_DISK));
        register(registry, new ItemVetheanDisk("darven_disk", DiskType.DARVEN_DISK));
        register(registry, new ItemVetheanDisk("cermile_disk", DiskType.CERMILE_DISK));
        register(registry, new ItemVetheanDisk("pardimal_disk", DiskType.PARDIMAL_DISK));
        register(registry, new ItemVetheanDisk("quadrotic_disk", DiskType.QUADROTIC_DISK));
        register(registry, new ItemVetheanDisk("karos_disk", DiskType.KAROS_DISK));
        register(registry, new ItemVetheanDisk("heliosis_disk", DiskType.HELIOSIS_DISK));
        register(registry, new ItemVetheanDisk("arksiane_disk", DiskType.ARKSIANE_DISK));

        // Hammer
        register(registry, new ItemVetheanSword(ToolMaterialMod.TEAKER_HAMMER, "teaker_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.AMTHIRMIS_HAMMER, "amthirmis_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.DARVEN_HAMMER, "darven_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.CERMILE_HAMMER, "cermile_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.PARDIMAL_HAMMER, "pardimal_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.QUADROTIC_HAMMER, "quadrotic_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.KAROS_HAMMER, "karos_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.HELIOSIS_HAMMER, "heliosis_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.ARKSIANE_HAMMER, "arksiane_hammer"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.EVERLIGHT, "everlight"));
        register(registry, new ItemVetheanSword(ToolMaterialMod.KAROS_ROCKMAUL, "karos_rockmaul"));

        // Staff
        register(registry, new ItemStaff(3, 10, "teaker_staff"));
        register(registry, new ItemStaff(5, 10, "amthirmis_staff"));
        register(registry, new ItemStaff(8, 10, "darven_staff"));
        register(registry, new ItemStaff(12, 10, "cermile_staff"));
        register(registry, new ItemStaff(15, 10, "pardimal_staff"));
        register(registry, new ItemStaff(19, 10, "quadrotic_staff"));
        register(registry, new ItemStaff(21, 10, "karos_staff"));
        register(registry, new ItemStaff(28, 10, "heliosis_staff"));
        register(registry, new ItemStaff(36, 10, "arksiane_staff"));
        register(registry, new ItemEvernight(115, 80, "evernight"));
    }

    private static void register(IForgeRegistry<Item> registry, Item item) {
        registry.register(item);
        ModItems.itemMap.put(item.getRegistryName().getResourcePath(), item);
    }
}
