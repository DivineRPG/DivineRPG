package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.api.items.ItemModBow;
import net.divinerpg.api.items.ItemModRanged;
import net.divinerpg.api.items.ItemModSword;
import net.divinerpg.entities.twilight.projectile.EntityApalachiaArrow;
import net.divinerpg.entities.twilight.projectile.EntityEdenArrow;
import net.divinerpg.entities.twilight.projectile.EntityHaliteArrow;
import net.divinerpg.entities.twilight.projectile.EntityMortumArrow;
import net.divinerpg.entities.twilight.projectile.EntitySkythernArrow;
import net.divinerpg.entities.twilight.projectile.EntityWildWoodArrow;
import net.divinerpg.entities.vanilla.projectile.EntityPoisonArrow;
import net.divinerpg.items.vanilla.ItemCyclopsianStaff;
import net.divinerpg.items.vanilla.ItemFrostCannon;
import net.divinerpg.items.vanilla.ItemInfernoSword;
import net.divinerpg.items.vanilla.ItemMaelstorm;
import net.divinerpg.items.vanilla.ItemMassivence;
import net.divinerpg.items.vanilla.ItemPalavence;
import net.divinerpg.items.vanilla.ItemScythe;
import net.divinerpg.items.vanilla.ItemSerenadeOfDeath;
import net.divinerpg.items.vanilla.ItemSerenadeOfHealth;
import net.divinerpg.items.vanilla.ItemSerenadeStriker;
import net.divinerpg.items.vanilla.ItemThrowable;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class VanillaItemsWeapons {

	public static final Item slimeSword         = new ItemModSword(ToolMaterialMod.Slime, "slimeSword");
    public static final Item oceanKnife         = new ItemModSword(ToolMaterialMod.OceanKnife, "oceanKnife");
    public static final Item aquaticMaul        = new ItemModSword(ToolMaterialMod.AquaMaul, "aquaMaul");
    public static final Item arlemiteSword      = new ItemModSword(ToolMaterialMod.Arlemite, "arlemiteSword");
    public static final Item bedrockSword       = new ItemModSword(ToolMaterialMod.Bedrock, "bedrockSword");
    public static final Item realmiteSword      = new ItemModSword(ToolMaterialMod.Realmite, "realmiteSword");
    public static final Item rupeeSword         = new ItemModSword(ToolMaterialMod.Rupee, "rupeeSword");
    public static final Item sandslash          = new ItemModSword(ToolMaterialMod.Sandslash, "sandslash");
    public static final Item divineSword        = new ItemModSword(ToolMaterialMod.Divine, "divineSword");
    public static final Item blueDivineSword    = new ItemModSword(ToolMaterialMod.Divine, "blueDivineSword");
    public static final Item yellowDivineSword  = new ItemModSword(ToolMaterialMod.Divine, "yellowDivineSword");
    public static final Item pinkDivineSword    = new ItemModSword(ToolMaterialMod.Divine, "pinkDivineSword");
    public static final Item purpleDivineSword  = new ItemModSword(ToolMaterialMod.Divine, "purpleDivineSword");
    public static final Item redDivineSword     = new ItemModSword(ToolMaterialMod.Divine, "redDivineSword");
    public static final Item greenDivineSword   = new ItemModSword(ToolMaterialMod.Divine, "greenDivineSword");
    public static final Item bedrockMaul        = new ItemModSword(ToolMaterialMod.Bedrock, "bedrockMaul");
    public static final Item jungleKnife        = new ItemModSword(ToolMaterialMod.OceanKnife, "jungleKnife");
    public static final Item donatorSword       = new ItemModSword(ToolMaterialMod.Donator, "donatorSword");
    public static final Item aquaticTrident     = new ItemModSword(ToolMaterialMod.AquaTrident, "aquaticTrident");
    public static final Item aquaticDagger      = new ItemModSword(ToolMaterialMod.AquaDagger, "aquaticDagger");
    public static final Item aquaton            = new ItemModSword(ToolMaterialMod.Aquaton, "aquaton");
    public static final Item sharkSword         = new ItemModSword(ToolMaterialMod.Shark, "sharkSword");
    public static final Item deathBringer       = new ItemModSword(ToolMaterialMod.DeathBringer, "deathBringer");
    public static final Item crabclawMaul       = new ItemModSword(ToolMaterialMod.CrabclawMaul, "crabclawMaul");
    public static final Item poisonSaber        = new ItemModSword(ToolMaterialMod.PoisonSaber, "poisonSaber");
    public static final Item furyMaul           = new ItemModSword(ToolMaterialMod.FuryMaul, "furyMaul");
    public static final Item corruptedMaul      = new ItemModSword(ToolMaterialMod.CorruptedMaul, "corruptedMaul");
    public static final Item frostSword         = new ItemModSword(ToolMaterialMod.Frost, "frostSword");
    public static final Item infernoSword       = new ItemInfernoSword(ToolMaterialMod.Inferno, "infernoSword");
    public static final Item bloodgemSword      = new ItemModSword(ToolMaterialMod.Bloodgem, "bloodgemSword");
    public static final Item moltenSword        = new ItemModSword(ToolMaterialMod.Molten, "moltenSword");
    public static final Item scorchingSword     = new ItemModSword(ToolMaterialMod.Scorching, "scorchingSword");
    public static final Item bluefireSword      = new ItemModSword(ToolMaterialMod.Bluefire, "bluefireSword");
    public static final Item enderSword         = new ItemModSword(ToolMaterialMod.Ender, "enderSword");
    public static final Item enderSwordBlue     = new ItemModSword(ToolMaterialMod.Ender, "enderSwordBlue");
    public static final Item enderSwordDark     = new ItemModSword(ToolMaterialMod.Ender, "enderSwordBlack");
    public static final Item enderSwordGreen    = new ItemModSword(ToolMaterialMod.Ender, "enderSwordGreen");
    public static final Item enderSwordRed      = new ItemModSword(ToolMaterialMod.Ender, "enderSwordRed");
    public static final Item enderSwordYellow   = new ItemModSword(ToolMaterialMod.Ender, "enderSwordYellow");
    public static final Item longsword   		= new ItemModSword(ToolMaterialMod.Longsword, "longsword").setFull3D();
    public static final Item cyclopsianSword    = new ItemModSword(ToolMaterialMod.Cyclops, "cyclopsianSword");
    
    public static final Item hunterBow          = new ItemModBow("hunterBow", 2500, 11, Items.arrow, EntityPoisonArrow.class);
    public static final Item shadowBow          = new ItemModBow("shadowBow", 10000, 11, 36000, Items.arrow, EntityArrow.class);
    public static final Item enderBow           = new ItemModBow("enderBow", -1, 11, EntityArrow.class);
    //public static final Item bluefireBow        = new ItemModBow("bluefiewBow", -1, 0, EntityExplosionArrow.class);
    //public static final Item infernoBow         = new ItemModBow("infernoBow", 10000, 11, EntityFireArrow.class);
    
    public static final Item poisonArrow        = new ItemMod("poisonArrow").setCreativeTab(null);

    public static final Item shuriken       	= new ItemThrowable(4, "shuriken");
    public static final Item vileStorm       	= new ItemThrowable(4, "vileStorm");
    public static final Item scythe		       	= new ItemScythe("scythe");
    public static final Item frostCannon       	= new ItemFrostCannon("frostCannon");
    public static final Item cyclopsianStaff    = new ItemCyclopsianStaff("cyclopsianStaff");
    public static final Item maelstorm          = new ItemMaelstorm("maelstorm");

    public static final Item serenadeOfHealth 	= new ItemSerenadeOfHealth("serenadeOfHealth");
    public static final Item serenadeStriker 	= new ItemSerenadeStriker("serenadeStriker");
    public static final Item serenadeOfDeath 	= new ItemSerenadeOfDeath("serenadeOfDeath");
    
    public static final Item palavence 		    = new ItemPalavence("palavence");
    public static final Item massivence 	    = new ItemMassivence("massivence");
	public static final Item flamingFury		= new ItemModSword(ToolMaterialMod.FlamingFury, "flamingFury"); 
}
