package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.api.items.ItemModBow;
import net.divinerpg.items.vethea.ItemDisk;
import net.divinerpg.items.vethea.ItemNightmareBed;
import net.divinerpg.items.vethea.ItemStaff;
import net.divinerpg.items.vethea.ItemVetheanCannon;
import net.divinerpg.items.vethea.ItemVetheanClaw;
import net.divinerpg.items.vethea.ItemVetheanEversight;
import net.divinerpg.items.vethea.ItemVetheanFood;
import net.divinerpg.items.vethea.ItemVetheanHealingFood;
import net.divinerpg.items.vethea.ItemVetheanSword;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;

public class VetheaItems {

    public static final Item dirtyPearls        = new ItemMod("dirtyPearls").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item cleanPearls        = new ItemMod("cleanPearls").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item polishedPearls     = new ItemMod("polishedPearls").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item shinyPearls        = new ItemMod("shinyPearls").setCreativeTab(DivineRPGTabs.vethea);

    public static final Item teakerLump         = new ItemMod("teakerLump").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item amthrimisLump      = new ItemMod("amthirmisLump").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item darvenLump         = new ItemMod("darvenLump").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item cermileLump        = new ItemMod("cermileLump").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item pardimalLump       = new ItemMod("pardimalLump").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item quadroticLump      = new ItemMod("quadroticLump").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item karosLump          = new ItemMod("karosLump").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item heliosisLump       = new ItemMod("heliosisLump").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item arksianeLump       = new ItemMod("arksianeLump").setCreativeTab(DivineRPGTabs.vethea);

    public static final Item teakerDisk         = new ItemDisk(4, "teakerDisk");
    public static final Item amthrimisDisk      = new ItemDisk(6, "amthirmisDisk");
    public static final Item darvenDisk         = new ItemDisk(9, "darvenDisk");
    public static final Item cermileDisk        = new ItemDisk(13, "cermileDisk");
    public static final Item pardimalDisk       = new ItemDisk(16, "pardimalDisk");
    public static final Item quadroticDisk      = new ItemDisk(20, "quadroticDisk");
    public static final Item karosDisk          = new ItemDisk(22, "karosDisk");
    public static final Item heliosisDisk       = new ItemDisk(29, "heliosisDisk");
    public static final Item arksianeDisk       = new ItemDisk(37, "arksianeDisk");

    public static final Item teakerStaff        = new ItemStaff(3, 10, "teakerStaff");
    public static final Item amthrimisStaff     = new ItemStaff(5, 10, "amthirmisStaff");
    public static final Item darvenStaff        = new ItemStaff(8, 10, "darvenStaff");
    public static final Item cermileStaff       = new ItemStaff(12, 10, "cermileStaff");
    public static final Item pardimalStaff      = new ItemStaff(15, 10, "pardimalStaff");
    public static final Item quadroticStaff     = new ItemStaff(19, 10, "quadroticStaff");
    public static final Item karosStaff         = new ItemStaff(21, 10, "karosStaff");
    public static final Item heliosisStaff      = new ItemStaff(28, 10, "heliosisStaff");
    public static final Item arksianeStaff      = new ItemStaff(36, 10, "arksianeStaff");

    public static final Item honeysuckle        = new ItemVetheanFood(1, 0.2F, "honeysuckle");
    public static final Item honeychunk         = new ItemVetheanFood(1, 0.2F, "honeychunk");
    public static final Item dreamCarrot        = new ItemVetheanFood(3, 0.4F, "dreamCarrot");
    public static final Item dreamMelon         = new ItemVetheanFood(6, 0.6F, "dreamMelon");
    public static final Item dreamPie           = new ItemVetheanFood(4, 0.8F, "dreamPie");
    public static final Item dreamCake          = new ItemVetheanFood(8, 0.8F, "dreamCake");
    public static final Item dreamSweets        = new ItemVetheanHealingFood(0, 0F, false, 2, "dreamSweets");
    public static final Item dreamSours         = new ItemVetheanHealingFood(0, 0F, false, 8, "dreamSours");
    public static final Item acid               = new ItemMod("acid").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item heviaBelt          = new ItemMod("heviaBelt").setCreativeTab(DivineRPGTabs.vethea);

    public static final Item hammerTemplate     = new ItemMod("hammerTemplate").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item backswordTemplate  = new ItemMod("backswordTemplate").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item bowTemplate        = new ItemMod("bowTemplate").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item cannonTemplate     = new ItemMod("cannonTemplate").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item clawTemplate       = new ItemMod("clawTemplate").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item diskTemplate       = new ItemMod("diskTemplate").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item staffTemplate      = new ItemMod("staffTemplate").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item degradedTemplate   = new ItemMod("degradedTemplate").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item finishedTemplate   = new ItemMod("finishedTemplate").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item glisteningTemplate = new ItemMod("glisteningTemplate").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item demonizedTemplate  = new ItemMod("demonizedTemplate").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item tormentedTemplate  = new ItemMod("tormentedTemplate").setCreativeTab(DivineRPGTabs.vethea);

    public static final Item teakerCannon       = new ItemVetheanCannon(3, "teakerCannon");
    public static final Item amthrimisCannon    = new ItemVetheanCannon(5, "amthirmisCannon");
    public static final Item darvenCannon       = new ItemVetheanCannon(8, "darvenCannon");
    public static final Item cermileCannon      = new ItemVetheanCannon(12, "cermileCannon");
    public static final Item pardimalCannon     = new ItemVetheanCannon(15, "pardimalCannon");
    public static final Item quadroticCannon    = new ItemVetheanCannon(19, "quadroticCannon");
    public static final Item karosCannonItem    = new ItemVetheanCannon(21, "karosCannonItem");
    public static final Item heliosisCannon     = new ItemVetheanCannon(28, "heliosisCannon");
    public static final Item arksianeCannon     = new ItemVetheanCannon(36, "arksianeCannon");

    public static final Item teakerHammer       = new ItemVetheanSword("teakerHammer", Util.addHammerMaterial(6));
    public static final Item amthrimisHammer    = new ItemVetheanSword("amthirmisHammer", Util.addHammerMaterial(8));
    public static final Item darvenHammer       = new ItemVetheanSword("darvenHammer", Util.addHammerMaterial(12));
    public static final Item cermileHammer      = new ItemVetheanSword("cermileHammer", Util.addHammerMaterial(15));
    public static final Item pardimalHammer     = new ItemVetheanSword("pardimalHammer", Util.addHammerMaterial(19));
    public static final Item quadroticHammer    = new ItemVetheanSword("quadroticHammer", Util.addHammerMaterial(24));
    public static final Item karosHammer        = new ItemVetheanSword("karosHammer", Util.addHammerMaterial(26));
    public static final Item heliosisHammer     = new ItemVetheanSword("heliosisHammer", Util.addHammerMaterial(33));
    public static final Item arksianeHammer     = new ItemVetheanSword("arksianeHammer", Util.addHammerMaterial(39));
    
    public static final Item teakerSword        = new ItemVetheanSword("teakerBacksword", Util.addHammerMaterial(4));
    public static final Item amthrimisSword     = new ItemVetheanSword("amthirmisBacksword", Util.addHammerMaterial(6));
    public static final Item darvenSword        = new ItemVetheanSword("darvenBacksword", Util.addHammerMaterial(9));
    public static final Item cermileSword       = new ItemVetheanSword("cermileBacksword", Util.addHammerMaterial(13));
    public static final Item pardimalSword      = new ItemVetheanSword("pardimalBacksword", Util.addHammerMaterial(16));
    public static final Item quadroticSword     = new ItemVetheanSword("quadroticBacksword", Util.addHammerMaterial(20));
    public static final Item karosSword         = new ItemVetheanSword("karosBacksword", Util.addHammerMaterial(22));
    public static final Item heliosisSword      = new ItemVetheanSword("heliosisBacksword", Util.addHammerMaterial(29));
    public static final Item arksianeSword      = new ItemVetheanSword("arksianeBacksword", Util.addHammerMaterial(37));

    public static final Item teakerClaw         = new ItemVetheanClaw(3, "teakerClaw");
    public static final Item amthrimisClaw      = new ItemVetheanClaw(5, "amthirmisClaw");
    public static final Item darvenClaw         = new ItemVetheanClaw(7, "darvenClaw");
    public static final Item cermileClaw        = new ItemVetheanClaw(8, "cermileClaw");
    public static final Item pardimalClaw       = new ItemVetheanClaw(12, "pardimalClaw");
    public static final Item quadroticClaw      = new ItemVetheanClaw(14, "quadroticClaw");
    public static final Item karosClaw          = new ItemVetheanClaw(19, "karosClaw");
    public static final Item heliosisClaw       = new ItemVetheanClaw(26, "heliosisClaw");
    public static final Item arksianeClaw       = new ItemVetheanClaw(35, "arksianeClaw");

    public static final Item eversight          = new ItemVetheanEversight(42, "eversight");
    public static final Item everlight          = new ItemVetheanSword("everlight", Util.addHammerMaterial(44));
    public static final Item everbright         = new ItemVetheanClaw(42, "everbright");
    public static final Item everArrow          = new ItemMod("everArrow").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item everfight		    = new ItemModBow("everfright", -1, 25, everArrow, EntityArrow.class);
    public static final Item evernight          = new ItemStaff(115, 200, "evernight");

    public static final Item teakerArrow        = new ItemMod("teakerArrow").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item darvenArrow    	= new ItemMod("darvenArrow").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item pardimalArrow  	= new ItemMod("pardimalArrow").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item karosArrow         = new ItemMod("karosArrow").setCreativeTab(DivineRPGTabs.vethea);

    public static final Item dreamFlint         = new ItemMod("dreamFlint").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item moonClock          = new ItemMod("moonClock").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item rockChunks         = new ItemMod("rockChunks").setCreativeTab(DivineRPGTabs.vethea);
    public static final Item nightmareBed       = new ItemNightmareBed();
}