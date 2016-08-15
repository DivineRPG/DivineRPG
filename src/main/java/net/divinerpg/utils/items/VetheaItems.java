package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemDivineArmor;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.items.base.ItemModBow;
import net.divinerpg.items.base.ItemModDoor;
import net.divinerpg.items.vethea.ItemDisk;
import net.divinerpg.items.vethea.ItemDreamFlint;
import net.divinerpg.items.vethea.ItemMoonClock;
import net.divinerpg.items.vethea.ItemNightmareBed;
import net.divinerpg.items.vethea.ItemStaff;
import net.divinerpg.items.vethea.ItemVetheanCannon;
import net.divinerpg.items.vethea.ItemVetheanClaw;
import net.divinerpg.items.vethea.ItemVetheanEversight;
import net.divinerpg.items.vethea.ItemVetheanFood;
import net.divinerpg.items.vethea.ItemVetheanHealingFood;
import net.divinerpg.items.vethea.ItemVetheanSword;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.item.Item;

public class VetheaItems {

	public static int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;

	public static Item dirtyPearls = new ItemMod("dirtyPearls").setCreativeTab(DivineRPGTabs.vethea);
	public static Item cleanPearls = new ItemMod("cleanPearls").setCreativeTab(DivineRPGTabs.vethea);
	public static Item polishedPearls = new ItemMod("polishedPearls").setCreativeTab(DivineRPGTabs.vethea);
	public static Item shinyPearls = new ItemMod("shinyPearls").setCreativeTab(DivineRPGTabs.vethea);

	public static Item barredDoor = new ItemModDoor(VetheaBlocks.barredDoor, "barredDoor").setCreativeTab(DivineRPGTabs.vethea);

	public static Item teakerLump = new ItemMod("teakerLump").setCreativeTab(DivineRPGTabs.vethea);
	public static Item amthirmisLump = new ItemMod("amthirmisLump").setCreativeTab(DivineRPGTabs.vethea);
	public static Item darvenLump = new ItemMod("darvenLump").setCreativeTab(DivineRPGTabs.vethea);
	public static Item cermileLump = new ItemMod("cermileLump").setCreativeTab(DivineRPGTabs.vethea);
	public static Item pardimalLump = new ItemMod("pardimalLump").setCreativeTab(DivineRPGTabs.vethea);
	public static Item quadroticLump = new ItemMod("quadroticLump").setCreativeTab(DivineRPGTabs.vethea);
	public static Item karosLump = new ItemMod("karosLump").setCreativeTab(DivineRPGTabs.vethea);
	public static Item heliosisLump = new ItemMod("heliosisLump").setCreativeTab(DivineRPGTabs.vethea);
	public static Item arksianeLump = new ItemMod("arksianeLump").setCreativeTab(DivineRPGTabs.vethea);

	public static Item teakerDisk = new ItemDisk(4, "teakerDisk");
	public static Item amthrimisDisk = new ItemDisk(6, "amthirmisDisk");
	public static Item darvenDisk = new ItemDisk(9, "darvenDisk");
	public static Item cermileDisk = new ItemDisk(13, "cermileDisk");
	public static Item pardimalDisk = new ItemDisk(16, "pardimalDisk");
	public static Item quadroticDisk = new ItemDisk(20, "quadroticWardisk");
	public static Item karosDisk = new ItemDisk(22, "karosWardisk");
	public static Item heliosisDisk = new ItemDisk(29, "heliosisWrathdisk");
	public static Item arksianeDisk = new ItemDisk(37, "arksianeWrathdisk");

	public static Item teakerStaff = new ItemStaff(3, 10, "teakerStaff");
	public static Item amthrimisStaff = new ItemStaff(5, 10, "amthirmisStaff");
	public static Item darvenStaff = new ItemStaff(8, 10, "darvenStaff");
	public static Item cermileStaff = new ItemStaff(12, 10, "cermileStaff");
	public static Item pardimalStaff = new ItemStaff(15, 10, "pardimalStaff");
	public static Item quadroticStaff = new ItemStaff(19, 10, "quadroticWarstaff");
	public static Item karosStaff = new ItemStaff(21, 10, "karosWarstaff");
	public static Item heliosisStaff = new ItemStaff(28, 10, "heliosisWrathstaff");
	public static Item arksianeStaff = new ItemStaff(36, 10, "arksianeWrathstaff");

	public static Item honeysuckle = new ItemVetheanFood(1, 0.2F, "honeysuckle");
	public static Item honeychunk = new ItemVetheanFood(1, 0.2F, "honeychunk");
	public static Item dreamCarrot = new ItemVetheanFood(3, 0.4F, "dreamCarrot");
	public static Item dreamMelon = new ItemVetheanFood(6, 0.6F, "dreamMelon");
	public static Item dreamPie = new ItemVetheanFood(4, 0.8F, "dreamPie");
	public static Item dreamCake = new ItemVetheanFood(8, 0.8F, "dreamCake");
	public static Item dreamSweets = new ItemVetheanHealingFood(0, 0F, false, 2, "dreamSweets");
	public static Item dreamSours = new ItemVetheanHealingFood(0, 0F, false, 8, "dreamSours");
	public static Item acid = new ItemMod("acid").setCreativeTab(DivineRPGTabs.vethea);
	public static Item heivaBelt = new ItemMod("bandOfHeivaHunting").setCreativeTab(DivineRPGTabs.vethea);
	public static Item minersAmulet = new ItemMod("miner'sAmulet").setCreativeTab(DivineRPGTabs.vethea);

	public static Item hammerTemplate = new ItemMod("hammerTemplate").setCreativeTab(DivineRPGTabs.vethea);
	public static Item backswordTemplate = new ItemMod("backswordTemplate").setCreativeTab(DivineRPGTabs.vethea);
	public static Item bowTemplate = new ItemMod("bowTemplate").setCreativeTab(DivineRPGTabs.vethea);
	public static Item cannonTemplate = new ItemMod("cannonTemplate").setCreativeTab(DivineRPGTabs.vethea);
	public static Item clawTemplate = new ItemMod("clawTemplate").setCreativeTab(DivineRPGTabs.vethea);
	public static Item diskTemplate = new ItemMod("diskTemplate").setCreativeTab(DivineRPGTabs.vethea);
	public static Item staffTemplate = new ItemMod("staffTemplate").setCreativeTab(DivineRPGTabs.vethea);
	public static Item degradedTemplate = new ItemMod("degradedTemplate").setCreativeTab(DivineRPGTabs.vethea);
	public static Item finishedTemplate = new ItemMod("finishedTemplate").setCreativeTab(DivineRPGTabs.vethea);
	public static Item glisteningTemplate = new ItemMod("glisteningTemplate").setCreativeTab(DivineRPGTabs.vethea);
	public static Item demonizedTemplate = new ItemMod("demonizedTemplate").setCreativeTab(DivineRPGTabs.vethea);
	public static Item tormentedTemplate = new ItemMod("tormentedTemplate").setCreativeTab(DivineRPGTabs.vethea);

	public static Item teakerCannon = new ItemVetheanCannon("teakerCannon", 3);
	public static Item amthrimisCannon = new ItemVetheanCannon("amthirmisCannon", 5);
	public static Item darvenCannon = new ItemVetheanCannon("darvenCannon", 8);
	public static Item cermileCannon = new ItemVetheanCannon("cermileCannon", 12);
	public static Item pardimalCannon = new ItemVetheanCannon("pardimalCannon", 15);
	public static Item quadroticCannon = new ItemVetheanCannon("quadroticWarcannon", 19);
	public static Item karosCannon = new ItemVetheanCannon("karosWarcannon", 21);
	public static Item heliosisCannon = new ItemVetheanCannon("heliosisWrathcannon", 28);
	public static Item arksianeCannon = new ItemVetheanCannon("arksianeWrathcannon", 36);

	public static Item teakerHammer = new ItemVetheanSword("teakerHammer", Util.addHammerMaterial(6));
	public static Item amthrimisHammer = new ItemVetheanSword("amthirmisHammer", Util.addHammerMaterial(8));
	public static Item darvenHammer = new ItemVetheanSword("darvenHammer", Util.addHammerMaterial(12));
	public static Item cermileHammer = new ItemVetheanSword("cermileHammer", Util.addHammerMaterial(15));
	public static Item pardimalHammer = new ItemVetheanSword("pardimalHammer", Util.addHammerMaterial(19));
	public static Item quadroticHammer = new ItemVetheanSword("quadroticWarhammer", Util.addHammerMaterial(24));
	public static Item karosHammer = new ItemVetheanSword("karosWarhammer", Util.addHammerMaterial(26));
	public static Item heliosisHammer = new ItemVetheanSword("heliosisWrathhammer", Util.addHammerMaterial(33));
	public static Item arksianeHammer = new ItemVetheanSword("arksianeWrathhammer", Util.addHammerMaterial(39));

	public static Item teakerSword = new ItemVetheanSword("teakerBacksword", Util.addHammerMaterial(4));
	public static Item amthrimisSword = new ItemVetheanSword("amthirmisBacksword", Util.addHammerMaterial(6));
	public static Item darvenSword = new ItemVetheanSword("darvenBacksword", Util.addHammerMaterial(9));
	public static Item cermileSword = new ItemVetheanSword("cermileBacksword", Util.addHammerMaterial(13));
	public static Item pardimalSword = new ItemVetheanSword("pardimalBacksword", Util.addHammerMaterial(16));
	public static Item quadroticSword = new ItemVetheanSword("quadroticWarsword", Util.addHammerMaterial(20));
	public static Item karosSword = new ItemVetheanSword("karosWarsword", Util.addHammerMaterial(22));
	public static Item heliosisSword = new ItemVetheanSword("heliosisWrathsword", Util.addHammerMaterial(29));
	public static Item arksianeSword = new ItemVetheanSword("arksianeWrathsword", Util.addHammerMaterial(37));

	public static Item teakerClaw = new ItemVetheanClaw(3, "teakerClaw");
	public static Item amthrimisClaw = new ItemVetheanClaw(5, "amthirmisClaw");
	public static Item darvenClaw = new ItemVetheanClaw(7, "darvenClaw");
	public static Item cermileClaw = new ItemVetheanClaw(8, "cermileClaw");
	public static Item pardimalClaw = new ItemVetheanClaw(12, "pardimalClaw");
	public static Item quadroticClaw = new ItemVetheanClaw(14, "quadroticWarclaw");
	public static Item karosClaw = new ItemVetheanClaw(19, "karosWarclaw");
	public static Item heliosisClaw = new ItemVetheanClaw(26, "heliosisWrathclaw");
	public static Item arksianeClaw = new ItemVetheanClaw(35, "arksianeWrathclaw");

	public static Item eversight = new ItemVetheanEversight("eversight");
	public static Item everlight = new ItemVetheanSword("everlight", Util.addHammerMaterial(44));
	public static Item everbright = new ItemVetheanClaw(42, "everbright");
	public static Item everArrow = new ItemMod("everArrow").setCreativeTab(DivineRPGTabs.vethea);
	public static Item everfright = new ItemModBow("everfright", -1, 25, 46, everArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	public static Item evernight = new ItemStaff(115, 80, "evernight");

	public static Item karosRockmaul = new ItemVetheanSword("karosRockmaul", Util.addHammerMaterial(46));

	public static Item teakerArrow = new ItemMod("teakerArrow").setCreativeTab(DivineRPGTabs.vethea);
	public static Item darvenArrow = new ItemMod("darvenArrow").setCreativeTab(DivineRPGTabs.vethea);
	public static Item pardimalArrow = new ItemMod("pardimalArrow").setCreativeTab(DivineRPGTabs.vethea);
	public static Item karosArrow = new ItemMod("karosArrow").setCreativeTab(DivineRPGTabs.vethea);

	public static Item teakerBow = new ItemModBow("teakerBow", -1, 2, 5, teakerArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	public static Item amthrimisBow = new ItemModBow("amthirmisBow", -1, 2, 7, teakerArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	public static Item darvenBow = new ItemModBow("darvenBow", -1, 3, 11, darvenArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	public static Item cermileBow = new ItemModBow("cermileBow", -1, 4, 14, darvenArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	public static Item pardimalBow = new ItemModBow("pardimalBow", -1, 5, 18, pardimalArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	public static Item quadroticBow = new ItemModBow("quadroticWarbow", -1, 6, 21, pardimalArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	public static Item karosBow = new ItemModBow("karosWarbow", -1, 7, 23, karosArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	public static Item heliosisBow = new ItemModBow("heliosisWrathbow", -1, 8, 28, karosArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	public static Item arksianeBow = new ItemModBow("arksianeWrathbow", -1, 12, 36, karosArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();

	public static Item dreamFlint = new ItemDreamFlint();
	public static Item moonClock = new ItemMoonClock();
	public static Item rockChunks = new ItemMod("rockChunks").setCreativeTab(DivineRPGTabs.vethea);
	public static Item nightmareBed = new ItemNightmareBed();

	private static Object[] basicHelmInfo = { 15, ArmorInfo.MELEE_PROTECTION };
	private static Object[] basicMaskInfo = { 15, ArmorInfo.RANGED_PROTECTION };
	private static Object[] basicHoodInfo = { 15, ArmorInfo.ARCANA_PROTECTION };
	private static Object[] glisteningHelmInfo = { 15, ArmorInfo.MELEE_PROTECTION, 3, ArmorInfo.MELEE_DAMAGE };
	private static Object[] glisteningMaskInfo = { 15, ArmorInfo.RANGED_PROTECTION, 1.4, ArmorInfo.SPEED };
	private static Object[] glisteningHoodInfo = { 15, ArmorInfo.ARCANA_PROTECTION, 2, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
	private static Object[] demonizedHelmInfo = { 15, ArmorInfo.MELEE_PROTECTION, 6, ArmorInfo.MELEE_DAMAGE };
	private static Object[] demonizedMaskInfo = { 15, ArmorInfo.RANGED_PROTECTION, 1.8, ArmorInfo.SPEED };
	private static Object[] demonizedHoodInfo = { 15, ArmorInfo.ARCANA_PROTECTION, 3, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
	private static Object[] tormentedHelmInfo = { 15, ArmorInfo.MELEE_PROTECTION, 9, ArmorInfo.MELEE_DAMAGE };
	private static Object[] tormentedMaskInfo = { 15, ArmorInfo.RANGED_PROTECTION, 2.2, ArmorInfo.SPEED };
	private static Object[] tormentedHoodInfo = { 15, ArmorInfo.ARCANA_PROTECTION, 4, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };

	public static Item degradedHelmet = new ItemDivineArmor(EnumArmor.DEGRADED, HEAD, basicHelmInfo, true, "Helmet");
	public static Item degradedMask = new ItemDivineArmor(EnumArmor.DEGRADED, HEAD, basicMaskInfo, true, "Mask");
	public static Item degradedHood = new ItemDivineArmor(EnumArmor.DEGRADED, HEAD, basicHoodInfo, true, "Hood");
	public static Item degradedBody = new ItemDivineArmor(EnumArmor.DEGRADED, BODY, true);
	public static Item degradedLegs = new ItemDivineArmor(EnumArmor.DEGRADED, LEGS, true);
	public static Item degradedBoots = new ItemDivineArmor(EnumArmor.DEGRADED, BOOTS, true);

	public static Item finishedHelmet = new ItemDivineArmor(EnumArmor.FINISHED, HEAD, basicHelmInfo, true, "Helmet");
	public static Item finishedMask = new ItemDivineArmor(EnumArmor.FINISHED, HEAD, basicMaskInfo, true, "Mask");
	public static Item finishedHood = new ItemDivineArmor(EnumArmor.FINISHED, HEAD, basicHoodInfo, true, "Hood");
	public static Item finishedBody = new ItemDivineArmor(EnumArmor.FINISHED, BODY, true);
	public static Item finishedLegs = new ItemDivineArmor(EnumArmor.FINISHED, LEGS, true);
	public static Item finishedBoots = new ItemDivineArmor(EnumArmor.FINISHED, BOOTS, true);

	public static Item glisteningHelmet = new ItemDivineArmor(EnumArmor.GLISTENING, HEAD, glisteningHelmInfo, true, "Helmet");
	public static Item glisteningMask = new ItemDivineArmor(EnumArmor.GLISTENING, HEAD, glisteningMaskInfo, true, "Mask");
	public static Item glisteningHood = new ItemDivineArmor(EnumArmor.GLISTENING, HEAD, glisteningHoodInfo, true, "Hood");
	public static Item glisteningBody = new ItemDivineArmor(EnumArmor.GLISTENING, BODY, true);
	public static Item glisteningLegs = new ItemDivineArmor(EnumArmor.GLISTENING, LEGS, true);
	public static Item glisteningBoots = new ItemDivineArmor(EnumArmor.GLISTENING, BOOTS, true);

	public static Item demonizedHelmet = new ItemDivineArmor(EnumArmor.DEMONIZED, HEAD, demonizedHelmInfo, true, "Helmet");
	public static Item demonizedMask = new ItemDivineArmor(EnumArmor.DEMONIZED, HEAD, demonizedMaskInfo, true, "Mask");
	public static Item demonizedHood = new ItemDivineArmor(EnumArmor.DEMONIZED, HEAD, demonizedHoodInfo, true, "Hood");
	public static Item demonizedBody = new ItemDivineArmor(EnumArmor.DEMONIZED, BODY, true);
	public static Item demonizedLegs = new ItemDivineArmor(EnumArmor.DEMONIZED, LEGS, true);
	public static Item demonizedBoots = new ItemDivineArmor(EnumArmor.DEMONIZED, BOOTS, true);

	public static Item tormentedHelmet = new ItemDivineArmor(EnumArmor.TORMENTED, HEAD, tormentedHelmInfo, true, "Helmet");
	public static Item tormentedMask = new ItemDivineArmor(EnumArmor.TORMENTED, HEAD, tormentedMaskInfo, true, "Mask");
	public static Item tormentedHood = new ItemDivineArmor(EnumArmor.TORMENTED, HEAD, tormentedHoodInfo, true, "Hood");
	public static Item tormentedBody = new ItemDivineArmor(EnumArmor.TORMENTED, BODY, true);
	public static Item tormentedLegs = new ItemDivineArmor(EnumArmor.TORMENTED, LEGS, true);
	public static Item tormentedBoots = new ItemDivineArmor(EnumArmor.TORMENTED, BOOTS, true);
	
	public static void init(){}
}