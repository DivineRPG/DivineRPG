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

	public static Item dirtyPearls;
	public static Item cleanPearls;
	public static Item polishedPearls;
	public static Item shinyPearls;
	
	public static Item barredDoor;

	public static Item teakerLump;
	public static Item amthirmisLump;
	public static Item darvenLump;
	public static Item cermileLump;
	public static Item pardimalLump;
	public static Item quadroticLump;
	public static Item karosLump;
	public static Item heliosisLump;
	public static Item arksianeLump;

	public static Item teakerDisk;
	public static Item amthrimisDisk;
	public static Item darvenDisk;
	public static Item cermileDisk;
	public static Item pardimalDisk;
	public static Item quadroticDisk;
	public static Item karosDisk;
	public static Item heliosisDisk;
	public static Item arksianeDisk;

	public static Item teakerStaff;
	public static Item amthrimisStaff;
	public static Item darvenStaff;
	public static Item cermileStaff;
	public static Item pardimalStaff;
	public static Item quadroticStaff;
	public static Item karosStaff;
	public static Item heliosisStaff;
	public static Item arksianeStaff;

	public static Item honeysuckle;
	public static Item honeychunk;
	public static Item dreamCarrot;
	public static Item dreamMelon;
	public static Item dreamPie;
	public static Item dreamCake;
	public static Item dreamSweets;
	public static Item dreamSours;
	public static Item acid;
	public static Item heivaBelt;

	public static Item hammerTemplate;
	public static Item backswordTemplate;
	public static Item bowTemplate;
	public static Item cannonTemplate;
	public static Item clawTemplate;
	public static Item diskTemplate;
	public static Item staffTemplate;
	public static Item degradedTemplate;
	public static Item finishedTemplate;
	public static Item glisteningTemplate;
	public static Item demonizedTemplate;
	public static Item tormentedTemplate;

	public static Item teakerCannon;
	public static Item amthrimisCannon;
	public static Item darvenCannon;
	public static Item cermileCannon;
	public static Item pardimalCannon;
	public static Item quadroticCannon;
	public static Item karosCannon;
	public static Item heliosisCannon;
	public static Item arksianeCannon;

	public static Item teakerHammer;
	public static Item amthrimisHammer;
	public static Item darvenHammer;
	public static Item cermileHammer;
	public static Item pardimalHammer;
	public static Item quadroticHammer;
	public static Item karosHammer;
	public static Item heliosisHammer;
	public static Item arksianeHammer;

	public static Item teakerSword;
	public static Item amthrimisSword;
	public static Item darvenSword;
	public static Item cermileSword;
	public static Item pardimalSword;
	public static Item quadroticSword;
	public static Item karosSword;
	public static Item heliosisSword;
	public static Item arksianeSword;

	public static Item teakerClaw;
	public static Item amthrimisClaw;
	public static Item darvenClaw;
	public static Item cermileClaw;
	public static Item pardimalClaw;
	public static Item quadroticClaw;
	public static Item karosClaw;
	public static Item heliosisClaw;
	public static Item arksianeClaw;

	public static Item eversight;
	public static Item everlight;
	public static Item everbright;
	public static Item everArrow;
	public static Item everfright;
	public static Item evernight;
	
	public static Item karosRockmaul;

	public static Item teakerArrow;
	public static Item darvenArrow;
	public static Item pardimalArrow;
	public static Item karosArrow;

	public static Item teakerBow;
	public static Item amthrimisBow;
	public static Item darvenBow;
	public static Item cermileBow;
	public static Item pardimalBow;
	public static Item quadroticBow;
	public static Item karosBow;
	public static Item heliosisBow;
	public static Item arksianeBow;

	public static Item dreamFlint;
	public static Item moonClock;
	public static Item rockChunks;
	public static Item nightmareBed;

	public static Item degradedHelmet;
	public static Item degradedMask;
	public static Item degradedHood;
	public static Item degradedBody;
	public static Item degradedLegs;
	public static Item degradedBoots;

	public static Item finishedHelmet;
	public static Item finishedMask;
	public static Item finishedHood;
	public static Item finishedBody;
	public static Item finishedLegs;
	public static Item finishedBoots;

	public static Item glisteningHelmet;
	public static Item glisteningMask;
	public static Item glisteningHood;
	public static Item glisteningBody;
	public static Item glisteningLegs;
	public static Item glisteningBoots;

	public static Item demonizedHelmet;
	public static Item demonizedMask;
	public static Item demonizedHood;
	public static Item demonizedBody;
	public static Item demonizedLegs;
	public static Item demonizedBoots;

	public static Item tormentedHelmet;
	public static Item tormentedMask;
	public static Item tormentedHood;
	public static Item tormentedBody;
	public static Item tormentedLegs;
	public static Item tormentedBoots;
	
	public static void init() {
		dirtyPearls        = new ItemMod("dirtyPearls").setCreativeTab(DivineRPGTabs.vethea);
	    cleanPearls        = new ItemMod("cleanPearls").setCreativeTab(DivineRPGTabs.vethea);
	    polishedPearls     = new ItemMod("polishedPearls").setCreativeTab(DivineRPGTabs.vethea);
	    shinyPearls        = new ItemMod("shinyPearls").setCreativeTab(DivineRPGTabs.vethea);
	    
	    barredDoor		   = new ItemModDoor(VetheaBlocks.barredDoor, "barredDoor").setCreativeTab(DivineRPGTabs.vethea);

	    teakerLump         = new ItemMod("teakerLump").setCreativeTab(DivineRPGTabs.vethea);
	    amthirmisLump      = new ItemMod("amthirmisLump").setCreativeTab(DivineRPGTabs.vethea);
	    darvenLump         = new ItemMod("darvenLump").setCreativeTab(DivineRPGTabs.vethea);
	    cermileLump        = new ItemMod("cermileLump").setCreativeTab(DivineRPGTabs.vethea);
	    pardimalLump       = new ItemMod("pardimalLump").setCreativeTab(DivineRPGTabs.vethea);
	    quadroticLump      = new ItemMod("quadroticLump").setCreativeTab(DivineRPGTabs.vethea);
	    karosLump          = new ItemMod("karosLump").setCreativeTab(DivineRPGTabs.vethea);
	    heliosisLump       = new ItemMod("heliosisLump").setCreativeTab(DivineRPGTabs.vethea);
	    arksianeLump       = new ItemMod("arksianeLump").setCreativeTab(DivineRPGTabs.vethea);

	    teakerDisk         = new ItemDisk(4, "teakerDisk");
	    amthrimisDisk      = new ItemDisk(6, "amthirmisDisk");
	    darvenDisk         = new ItemDisk(9, "darvenDisk");
	    cermileDisk        = new ItemDisk(13, "cermileDisk");
	    pardimalDisk       = new ItemDisk(16, "pardimalDisk");
	    quadroticDisk      = new ItemDisk(20, "quadroticWardisk");
	    karosDisk          = new ItemDisk(22, "karosWardisk");
	    heliosisDisk       = new ItemDisk(29, "heliosisWrathdisk");
	    arksianeDisk       = new ItemDisk(37, "arksianeWrathdisk");

	    teakerStaff        = new ItemStaff(3, 10, "teakerStaff");
	    amthrimisStaff     = new ItemStaff(5, 10, "amthirmisStaff");
	    darvenStaff        = new ItemStaff(8, 10, "darvenStaff");
	    cermileStaff       = new ItemStaff(12, 10, "cermileStaff");
	    pardimalStaff      = new ItemStaff(15, 10, "pardimalStaff");
	    quadroticStaff     = new ItemStaff(19, 10, "quadroticWarstaff");
	    karosStaff         = new ItemStaff(21, 10, "karosWarstaff");
	    heliosisStaff      = new ItemStaff(28, 10, "heliosisWrathstaff");
	    arksianeStaff      = new ItemStaff(36, 10, "arksianeWrathstaff");

	    honeysuckle        = new ItemVetheanFood(1, 0.2F, "honeysuckle");
	    honeychunk         = new ItemVetheanFood(1, 0.2F, "honeychunk");
	    dreamCarrot        = new ItemVetheanFood(3, 0.4F, "dreamCarrot");
	    dreamMelon         = new ItemVetheanFood(6, 0.6F, "dreamMelon");
	    dreamPie           = new ItemVetheanFood(4, 0.8F, "dreamPie");
	    dreamCake          = new ItemVetheanFood(8, 0.8F, "dreamCake");
	    dreamSweets        = new ItemVetheanHealingFood(0, 0F, false, 2, "dreamSweets");
	    dreamSours         = new ItemVetheanHealingFood(0, 0F, false, 8, "dreamSours");
	    acid               = new ItemMod("acid").setCreativeTab(DivineRPGTabs.vethea);
	    heivaBelt          = new ItemMod("bandOfHeivaHunting").setCreativeTab(DivineRPGTabs.vethea);

	    hammerTemplate     = new ItemMod("hammerTemplate").setCreativeTab(DivineRPGTabs.vethea);
	    backswordTemplate  = new ItemMod("backswordTemplate").setCreativeTab(DivineRPGTabs.vethea);
	    bowTemplate        = new ItemMod("bowTemplate").setCreativeTab(DivineRPGTabs.vethea);
	    cannonTemplate     = new ItemMod("cannonTemplate").setCreativeTab(DivineRPGTabs.vethea);
	    clawTemplate       = new ItemMod("clawTemplate").setCreativeTab(DivineRPGTabs.vethea);
	    diskTemplate       = new ItemMod("diskTemplate").setCreativeTab(DivineRPGTabs.vethea);
	    staffTemplate      = new ItemMod("staffTemplate").setCreativeTab(DivineRPGTabs.vethea);
	    degradedTemplate   = new ItemMod("degradedTemplate").setCreativeTab(DivineRPGTabs.vethea);
	    finishedTemplate   = new ItemMod("finishedTemplate").setCreativeTab(DivineRPGTabs.vethea);
	    glisteningTemplate = new ItemMod("glisteningTemplate").setCreativeTab(DivineRPGTabs.vethea);
	    demonizedTemplate  = new ItemMod("demonizedTemplate").setCreativeTab(DivineRPGTabs.vethea);
	    tormentedTemplate  = new ItemMod("tormentedTemplate").setCreativeTab(DivineRPGTabs.vethea);

	    teakerCannon       = new ItemVetheanCannon("teakerCannon", 3);
	    amthrimisCannon    = new ItemVetheanCannon("amthirmisCannon", 5);
	    darvenCannon       = new ItemVetheanCannon("darvenCannon", 8);
	    cermileCannon      = new ItemVetheanCannon("cermileCannon", 12);
	    pardimalCannon     = new ItemVetheanCannon("pardimalCannon", 15);
	    quadroticCannon    = new ItemVetheanCannon("quadroticWarcannon", 19);
	    karosCannon    	= new ItemVetheanCannon("karosWarcannon", 21);
	    heliosisCannon     = new ItemVetheanCannon("heliosisWrathcannon", 28);
	    arksianeCannon     = new ItemVetheanCannon("arksianeWrathcannon", 36);

	    teakerHammer       = new ItemVetheanSword("teakerHammer", Util.addHammerMaterial(6));
	    amthrimisHammer    = new ItemVetheanSword("amthirmisHammer", Util.addHammerMaterial(8));
	    darvenHammer       = new ItemVetheanSword("darvenHammer", Util.addHammerMaterial(12));
	    cermileHammer      = new ItemVetheanSword("cermileHammer", Util.addHammerMaterial(15));
	    pardimalHammer     = new ItemVetheanSword("pardimalHammer", Util.addHammerMaterial(19));
	    quadroticHammer    = new ItemVetheanSword("quadroticWarhammer", Util.addHammerMaterial(24));
	    karosHammer        = new ItemVetheanSword("karosWarhammer", Util.addHammerMaterial(26));
	    heliosisHammer     = new ItemVetheanSword("heliosisWrathhammer", Util.addHammerMaterial(33));
	    arksianeHammer     = new ItemVetheanSword("arksianeWrathhammer", Util.addHammerMaterial(39));
	    
	    teakerSword        = new ItemVetheanSword("teakerBacksword", Util.addHammerMaterial(4));
	    amthrimisSword     = new ItemVetheanSword("amthirmisBacksword", Util.addHammerMaterial(6));
	    darvenSword        = new ItemVetheanSword("darvenBacksword", Util.addHammerMaterial(9));
	    cermileSword       = new ItemVetheanSword("cermileBacksword", Util.addHammerMaterial(13));
	    pardimalSword      = new ItemVetheanSword("pardimalBacksword", Util.addHammerMaterial(16));
	    quadroticSword     = new ItemVetheanSword("quadroticWarsword", Util.addHammerMaterial(20));
	    karosSword         = new ItemVetheanSword("karosWarsword", Util.addHammerMaterial(22));
	    heliosisSword      = new ItemVetheanSword("heliosisWrathsword", Util.addHammerMaterial(29));
	    arksianeSword      = new ItemVetheanSword("arksianeWrathsword", Util.addHammerMaterial(37));

	    teakerClaw         = new ItemVetheanClaw(3, "teakerClaw");
	    amthrimisClaw      = new ItemVetheanClaw(5, "amthirmisClaw");
	    darvenClaw         = new ItemVetheanClaw(7, "darvenClaw");
	    cermileClaw        = new ItemVetheanClaw(8, "cermileClaw");
	    pardimalClaw       = new ItemVetheanClaw(12, "pardimalClaw");
	    quadroticClaw      = new ItemVetheanClaw(14, "quadroticWarclaw");
	    karosClaw          = new ItemVetheanClaw(19, "karosWarclaw");
	    heliosisClaw       = new ItemVetheanClaw(26, "heliosisWrathclaw");
	    arksianeClaw       = new ItemVetheanClaw(35, "arksianeWrathclaw");

	    eversight          = new ItemVetheanEversight("eversight");
	    everlight          = new ItemVetheanSword("everlight", Util.addHammerMaterial(44));
	    everbright         = new ItemVetheanClaw(42, "everbright");
	    everArrow          = new ItemMod("everArrow").setCreativeTab(DivineRPGTabs.vethea);
	    everfright		   = new ItemModBow("everfright", -1, 25, 46, everArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	    evernight          = new ItemStaff(115, 80, "evernight");
	    
	    karosRockmaul      = new ItemVetheanSword("karosRockmaul", Util.addHammerMaterial(46));
	    
	    teakerArrow        = new ItemMod("teakerArrow").setCreativeTab(DivineRPGTabs.vethea);
	    darvenArrow    	   = new ItemMod("darvenArrow").setCreativeTab(DivineRPGTabs.vethea);
	    pardimalArrow  	   = new ItemMod("pardimalArrow").setCreativeTab(DivineRPGTabs.vethea);
	    karosArrow         = new ItemMod("karosArrow").setCreativeTab(DivineRPGTabs.vethea);
	    
	    teakerBow        = new ItemModBow("teakerBow", -1, 2, 5, teakerArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	    amthrimisBow     = new ItemModBow("amthirmisBow", -1, 2, 7, teakerArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	    darvenBow        = new ItemModBow("darvenBow", -1, 3, 11, darvenArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	    cermileBow       = new ItemModBow("cermileBow", -1, 4, 14, darvenArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	    pardimalBow      = new ItemModBow("pardimalBow", -1, 5, 18, pardimalArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	    quadroticBow     = new ItemModBow("quadroticWarbow", -1, 6, 21, pardimalArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	    karosBow         = new ItemModBow("karosWarbow", -1, 7, 23, karosArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	    heliosisBow      = new ItemModBow("heliosisWrathbow", -1, 8, 28, karosArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	    arksianeBow      = new ItemModBow("arksianeWrathbow", -1, 12, 36, karosArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();

	    dreamFlint         = new ItemDreamFlint();
	    moonClock          = new ItemMoonClock();
	    rockChunks         = new ItemMod("rockChunks").setCreativeTab(DivineRPGTabs.vethea);
	    nightmareBed       = new ItemNightmareBed();
	    
	    Object[] basicHelmInfo = {15, ArmorInfo.MELEE_PROTECTION};
	    Object[] basicMaskInfo = {15, ArmorInfo.RANGED_PROTECTION};
	    Object[] basicHoodInfo = {15, ArmorInfo.ARCANA_PROTECTION};
	    Object[] glisteningHelmInfo = {15, ArmorInfo.MELEE_PROTECTION, 3, ArmorInfo.MELEE_DAMAGE};
	    Object[] glisteningMaskInfo = {15, ArmorInfo.RANGED_PROTECTION, 1.4, ArmorInfo.SPEED};
	    Object[] glisteningHoodInfo = {15, ArmorInfo.ARCANA_PROTECTION, 2, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL};
	    Object[] demonizedHelmInfo = {15, ArmorInfo.MELEE_PROTECTION, 6, ArmorInfo.MELEE_DAMAGE};
	    Object[] demonizedMaskInfo = {15, ArmorInfo.RANGED_PROTECTION, 1.8, ArmorInfo.SPEED};
	    Object[] demonizedHoodInfo = {15, ArmorInfo.ARCANA_PROTECTION, 3, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL};
	    Object[] tormentedHelmInfo = {15, ArmorInfo.MELEE_PROTECTION, 9, ArmorInfo.MELEE_DAMAGE};
	    Object[] tormentedMaskInfo = {15, ArmorInfo.RANGED_PROTECTION, 2.2, ArmorInfo.SPEED};
	    Object[] tormentedHoodInfo = {15, ArmorInfo.ARCANA_PROTECTION, 4, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL};
	    
	    degradedHelmet	= new ItemDivineArmor(EnumArmor.DEGRADED, HEAD, basicHelmInfo, true, "Helmet");
	    degradedMask		= new ItemDivineArmor(EnumArmor.DEGRADED, HEAD, basicMaskInfo, true, "Mask");
	    degradedHood		= new ItemDivineArmor(EnumArmor.DEGRADED, HEAD, basicHoodInfo, true, "Hood");
	    degradedBody		= new ItemDivineArmor(EnumArmor.DEGRADED, BODY, true);
	    degradedLegs		= new ItemDivineArmor(EnumArmor.DEGRADED, LEGS, true);
	    degradedBoots	= new ItemDivineArmor(EnumArmor.DEGRADED, BOOTS, true);
	    
	    finishedHelmet	= new ItemDivineArmor(EnumArmor.FINISHED, HEAD, basicHelmInfo, true, "Helmet");
	    finishedMask		= new ItemDivineArmor(EnumArmor.FINISHED, HEAD, basicMaskInfo, true, "Mask");
	    finishedHood		= new ItemDivineArmor(EnumArmor.FINISHED, HEAD, basicHoodInfo, true, "Hood");
	    finishedBody		= new ItemDivineArmor(EnumArmor.FINISHED, BODY, true);
	    finishedLegs		= new ItemDivineArmor(EnumArmor.FINISHED, LEGS, true);
	    finishedBoots	= new ItemDivineArmor(EnumArmor.FINISHED, BOOTS, true);
	    
	    glisteningHelmet	= new ItemDivineArmor(EnumArmor.GLISTENING, HEAD, glisteningHelmInfo, true, "Helmet");
	    glisteningMask		= new ItemDivineArmor(EnumArmor.GLISTENING, HEAD, glisteningMaskInfo, true, "Mask");
	    glisteningHood		= new ItemDivineArmor(EnumArmor.GLISTENING, HEAD, glisteningHoodInfo, true, "Hood");
	    glisteningBody		= new ItemDivineArmor(EnumArmor.GLISTENING, BODY, true);
	    glisteningLegs		= new ItemDivineArmor(EnumArmor.GLISTENING, LEGS, true);
	    glisteningBoots	= new ItemDivineArmor(EnumArmor.GLISTENING, BOOTS, true);
	    
	    demonizedHelmet	= new ItemDivineArmor(EnumArmor.DEMONIZED, HEAD, demonizedHelmInfo, true, "Helmet");
	    demonizedMask		= new ItemDivineArmor(EnumArmor.DEMONIZED, HEAD, demonizedMaskInfo, true, "Mask");
	    demonizedHood		= new ItemDivineArmor(EnumArmor.DEMONIZED, HEAD, demonizedHoodInfo, true, "Hood");
	    demonizedBody		= new ItemDivineArmor(EnumArmor.DEMONIZED, BODY, true);
	    demonizedLegs		= new ItemDivineArmor(EnumArmor.DEMONIZED, LEGS, true);
	    demonizedBoots	= new ItemDivineArmor(EnumArmor.DEMONIZED, BOOTS, true);
	    
	    tormentedHelmet	= new ItemDivineArmor(EnumArmor.TORMENTED, HEAD, tormentedHelmInfo, true, "Helmet");
	    tormentedMask		= new ItemDivineArmor(EnumArmor.TORMENTED, HEAD, tormentedMaskInfo, true, "Mask");
	    tormentedHood		= new ItemDivineArmor(EnumArmor.TORMENTED, HEAD, tormentedHoodInfo, true, "Hood");
	    tormentedBody		= new ItemDivineArmor(EnumArmor.TORMENTED, BODY, true);
	    tormentedLegs		= new ItemDivineArmor(EnumArmor.TORMENTED, LEGS, true);
	    tormentedBoots	= new ItemDivineArmor(EnumArmor.TORMENTED, BOOTS, true);
	}
}