package naturix.divinerpg.registry;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.assets.model.iceika.model.RenderWorkshopTinkerer;
import naturix.divinerpg.objects.entities.assets.render.RenderHat;
import naturix.divinerpg.objects.entities.assets.render.RenderProjectile;
import naturix.divinerpg.objects.entities.assets.render.arcana.RenderApalachiaTomo;
import naturix.divinerpg.objects.entities.assets.render.arcana.RenderDeathHound;
import naturix.divinerpg.objects.entities.assets.render.arcana.RenderDeathcryx;
import naturix.divinerpg.objects.entities.assets.render.arcana.RenderDramix;
import naturix.divinerpg.objects.entities.assets.render.arcana.RenderDungeonDemon;
import naturix.divinerpg.objects.entities.assets.render.arcana.RenderLeorna;
import naturix.divinerpg.objects.entities.assets.render.arcana.RenderParasecta;
import naturix.divinerpg.objects.entities.assets.render.arcana.RenderParatiku;
import naturix.divinerpg.objects.entities.assets.render.arcana.RenderRazorback;
import naturix.divinerpg.objects.entities.assets.render.arcana.RenderRejuvGolem;
import naturix.divinerpg.objects.entities.assets.render.arcana.RenderRoamer;
import naturix.divinerpg.objects.entities.assets.render.arcana.RenderSeimer;
import naturix.divinerpg.objects.entities.assets.render.arcana.RenderWraith;
import naturix.divinerpg.objects.entities.assets.render.iceika.RenderAlicanto;
import naturix.divinerpg.objects.entities.assets.render.iceika.RenderFractite;
import naturix.divinerpg.objects.entities.assets.render.iceika.RenderFrostArcher;
import naturix.divinerpg.objects.entities.assets.render.iceika.RenderFrosty;
import naturix.divinerpg.objects.entities.assets.render.iceika.RenderGlacide;
import naturix.divinerpg.objects.entities.assets.render.iceika.RenderHastreus;
import naturix.divinerpg.objects.entities.assets.render.iceika.RenderRollum;
import naturix.divinerpg.objects.entities.assets.render.iceika.RenderWorkshopMerchant;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderAngryBunny;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderApalachiaCadillion;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderApalachiaGolem;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderBasalisk;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderBehemoth;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderBunny;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderDenseDemon;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderDensos;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderEdenCadillion;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderEdenCori;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderEdenTomo;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderEnchantedArcher;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderEnchantedWarrior;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderEpiphite;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderEternalArcher;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderGreenfeet;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderKarot;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderMadivel;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderMage;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderMegalith;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderMoonWolf;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderMortumArcher;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderMortumCadillion;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderMortumDemon;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderMystic;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderSamek;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderSkythernArcher;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderSkythernCori;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderSkythernFiend;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderSkythernGolem;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderSorcerer;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderSoulFiend;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderSoulSpider;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderSoulStealer;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderSunArcher;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderTameAngryBunny;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderTwilightArcher;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderTwilightDemon;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderVamacheron;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderVerek;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderWildwoodCadillion;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderWildwoodGolem;
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderWildwoodTomo;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderAncientEntity;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderAridWarrior;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderAyeracoBlue;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderAyeracoGreen;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderAyeracoPurple;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderAyeracoYellow;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderAyerecoRed;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderCaveCrawler;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderCaveclops;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderCrab;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderCyclops;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderDesertCrawler;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderEhu;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderEnderSpider;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderEnderTriplets;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderEnderWatcher;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderEnthralledDramcryx;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderFrost;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderGlacon;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderGrizzle;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderGrizzleWhite;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderHellPig;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderHellSpider;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderHusk;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderJackOMan;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderJungleBat;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderJungleDramcryx;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderJungleSpider;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderKingCrab;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderKingOfScorchers;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderKobblin;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderLiopleurodon;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderLivestockMerchant;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderMiner;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderPumpkinSpider;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderRainbour;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderRotatick;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderSaguaroWorm;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderScorcher;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderShark;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderSmelter;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderSnapper;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderStoneGolem;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderTheEye;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderTheGrue;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderTheWatcher;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderWhale;
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderWildFire;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderAcidHag;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderBiphron;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderBohemite;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderCryptKeeper;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderCymesoid;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderDissiment;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderDreamwrecker;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderDuo;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderEnt;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderGalroid;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderGorgosion;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderHelio;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderHerbomancer;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderHiveQueen;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderHiveSoldier;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderHoverStinger;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderKaros;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderKazrotic;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderLadyLuna;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderLheiva;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderLorga;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderLorgaFlight;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderMandragora;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderMysteriousMan;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderQuadro;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderRaglokGogdure;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderShadahier;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderSpinarus;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderTheHunger;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderTocaxin;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderTwins;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderVermenous;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderVhraak;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderWreckForm;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderZone;
import naturix.divinerpg.objects.entities.assets.render.vethia.RenderZoragon;
import naturix.divinerpg.objects.entities.entity.EntityDisk;
import naturix.divinerpg.objects.entities.entity.EntityEMP;
import naturix.divinerpg.objects.entities.entity.EntityFrostCloud;
import naturix.divinerpg.objects.entities.entity.arcana.DeathHound;
import naturix.divinerpg.objects.entities.entity.arcana.Deathcryx;
import naturix.divinerpg.objects.entities.entity.arcana.Dramix;
import naturix.divinerpg.objects.entities.entity.arcana.DungeonDemon;
import naturix.divinerpg.objects.entities.entity.arcana.EdenCadillion;
import naturix.divinerpg.objects.entities.entity.arcana.EdenCori;
import naturix.divinerpg.objects.entities.entity.arcana.EdenTomo;
import naturix.divinerpg.objects.entities.entity.arcana.Leorna;
import naturix.divinerpg.objects.entities.entity.arcana.Parasecta;
import naturix.divinerpg.objects.entities.entity.arcana.Paratiku;
import naturix.divinerpg.objects.entities.entity.arcana.Razorback;
import naturix.divinerpg.objects.entities.entity.arcana.RejuvGolem;
import naturix.divinerpg.objects.entities.entity.arcana.Roamer;
import naturix.divinerpg.objects.entities.entity.arcana.Seimer;
import naturix.divinerpg.objects.entities.entity.arcana.Wraith;
import naturix.divinerpg.objects.entities.entity.iceika.Alicanto;
import naturix.divinerpg.objects.entities.entity.iceika.Fractite;
import naturix.divinerpg.objects.entities.entity.iceika.FrostArcher;
import naturix.divinerpg.objects.entities.entity.iceika.Frosty;
import naturix.divinerpg.objects.entities.entity.iceika.Glacide;
import naturix.divinerpg.objects.entities.entity.iceika.Hastreus;
import naturix.divinerpg.objects.entities.entity.iceika.Rollum;
import naturix.divinerpg.objects.entities.entity.iceika.WorkshopMerchant;
import naturix.divinerpg.objects.entities.entity.iceika.WorkshopTinkerer;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityCaveRock;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityDeath;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityFrostShot;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityInfernoArrow;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityShuriken;
import naturix.divinerpg.objects.entities.entity.projectiles.EntitySparkler;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityVileStorm;
import naturix.divinerpg.objects.entities.entity.projectiles.SaguaroWormShot;
import naturix.divinerpg.objects.entities.entity.twilight.AngryBunny;
import naturix.divinerpg.objects.entities.entity.twilight.ApalachiaCadillion;
import naturix.divinerpg.objects.entities.entity.twilight.ApalachiaGolem;
import naturix.divinerpg.objects.entities.entity.twilight.ApalachiaTomo;
import naturix.divinerpg.objects.entities.entity.twilight.Basalisk;
import naturix.divinerpg.objects.entities.entity.twilight.Bohemoth;
import naturix.divinerpg.objects.entities.entity.twilight.Bunny;
import naturix.divinerpg.objects.entities.entity.twilight.DenseDemon;
import naturix.divinerpg.objects.entities.entity.twilight.Densos;
import naturix.divinerpg.objects.entities.entity.twilight.EnchantedArcher;
import naturix.divinerpg.objects.entities.entity.twilight.EnchantedWarrior;
import naturix.divinerpg.objects.entities.entity.twilight.Epiphite;
import naturix.divinerpg.objects.entities.entity.twilight.EternalArcher;
import naturix.divinerpg.objects.entities.entity.twilight.Greenfeet;
import naturix.divinerpg.objects.entities.entity.twilight.Karot;
import naturix.divinerpg.objects.entities.entity.twilight.Madivel;
import naturix.divinerpg.objects.entities.entity.twilight.Mage;
import naturix.divinerpg.objects.entities.entity.twilight.Megalith;
import naturix.divinerpg.objects.entities.entity.twilight.MoonWolf;
import naturix.divinerpg.objects.entities.entity.twilight.MortumArcher;
import naturix.divinerpg.objects.entities.entity.twilight.MortumCadillion;
import naturix.divinerpg.objects.entities.entity.twilight.MortumDemon;
import naturix.divinerpg.objects.entities.entity.twilight.Mystic;
import naturix.divinerpg.objects.entities.entity.twilight.Samek;
import naturix.divinerpg.objects.entities.entity.twilight.SkythernArcher;
import naturix.divinerpg.objects.entities.entity.twilight.SkythernCori;
import naturix.divinerpg.objects.entities.entity.twilight.SkythernFiend;
import naturix.divinerpg.objects.entities.entity.twilight.SkythernGolem;
import naturix.divinerpg.objects.entities.entity.twilight.Sorcerer;
import naturix.divinerpg.objects.entities.entity.twilight.SoulFiend;
import naturix.divinerpg.objects.entities.entity.twilight.SoulSpider;
import naturix.divinerpg.objects.entities.entity.twilight.SoulStealer;
import naturix.divinerpg.objects.entities.entity.twilight.SunArcher;
import naturix.divinerpg.objects.entities.entity.twilight.TameAngryBunny;
import naturix.divinerpg.objects.entities.entity.twilight.TwilightArcher;
import naturix.divinerpg.objects.entities.entity.twilight.TwilightDemon;
import naturix.divinerpg.objects.entities.entity.twilight.Vamecheron;
import naturix.divinerpg.objects.entities.entity.twilight.Verek;
import naturix.divinerpg.objects.entities.entity.twilight.WildwoodCadillion;
import naturix.divinerpg.objects.entities.entity.twilight.WildwoodGolem;
import naturix.divinerpg.objects.entities.entity.twilight.WildwoodTomo;
import naturix.divinerpg.objects.entities.entity.vanilla.AncientEntity;
import naturix.divinerpg.objects.entities.entity.vanilla.AridWarrior;
import naturix.divinerpg.objects.entities.entity.vanilla.AyeracoBlue;
import naturix.divinerpg.objects.entities.entity.vanilla.AyeracoGreen;
import naturix.divinerpg.objects.entities.entity.vanilla.AyeracoPurple;
import naturix.divinerpg.objects.entities.entity.vanilla.AyeracoRed;
import naturix.divinerpg.objects.entities.entity.vanilla.AyeracoYellow;
import naturix.divinerpg.objects.entities.entity.vanilla.CaveCrawler;
import naturix.divinerpg.objects.entities.entity.vanilla.Caveclops;
import naturix.divinerpg.objects.entities.entity.vanilla.Crab;
import naturix.divinerpg.objects.entities.entity.vanilla.Cyclops;
import naturix.divinerpg.objects.entities.entity.vanilla.DesertCrawler;
import naturix.divinerpg.objects.entities.entity.vanilla.Ehu;
import naturix.divinerpg.objects.entities.entity.vanilla.EnderSpider;
import naturix.divinerpg.objects.entities.entity.vanilla.EnderTriplets;
import naturix.divinerpg.objects.entities.entity.vanilla.EnderWatcher;
import naturix.divinerpg.objects.entities.entity.vanilla.EnthralledDramcryx;
import naturix.divinerpg.objects.entities.entity.vanilla.Frost;
import naturix.divinerpg.objects.entities.entity.vanilla.Glacon;
import naturix.divinerpg.objects.entities.entity.vanilla.Grizzle;
import naturix.divinerpg.objects.entities.entity.vanilla.GrizzleWhite;
import naturix.divinerpg.objects.entities.entity.vanilla.HellPig;
import naturix.divinerpg.objects.entities.entity.vanilla.HellSpider;
import naturix.divinerpg.objects.entities.entity.vanilla.Husk;
import naturix.divinerpg.objects.entities.entity.vanilla.JackOMan;
import naturix.divinerpg.objects.entities.entity.vanilla.JungleBat;
import naturix.divinerpg.objects.entities.entity.vanilla.JungleDramcryx;
import naturix.divinerpg.objects.entities.entity.vanilla.JungleSpider;
import naturix.divinerpg.objects.entities.entity.vanilla.KingCrab;
import naturix.divinerpg.objects.entities.entity.vanilla.KingOfScorchers;
import naturix.divinerpg.objects.entities.entity.vanilla.Kobblin;
import naturix.divinerpg.objects.entities.entity.vanilla.Liopleurodon;
import naturix.divinerpg.objects.entities.entity.vanilla.LivestockMerchant;
import naturix.divinerpg.objects.entities.entity.vanilla.Miner;
import naturix.divinerpg.objects.entities.entity.vanilla.PumpkinSpider;
import naturix.divinerpg.objects.entities.entity.vanilla.Rainbour;
import naturix.divinerpg.objects.entities.entity.vanilla.Rotatick;
import naturix.divinerpg.objects.entities.entity.vanilla.SaguaroWorm;
import naturix.divinerpg.objects.entities.entity.vanilla.Scorcher;
import naturix.divinerpg.objects.entities.entity.vanilla.Shark;
import naturix.divinerpg.objects.entities.entity.vanilla.Smelter;
import naturix.divinerpg.objects.entities.entity.vanilla.Snapper;
import naturix.divinerpg.objects.entities.entity.vanilla.StoneGolem;
import naturix.divinerpg.objects.entities.entity.vanilla.TheEye;
import naturix.divinerpg.objects.entities.entity.vanilla.TheGrue;
import naturix.divinerpg.objects.entities.entity.vanilla.TheWatcher;
import naturix.divinerpg.objects.entities.entity.vanilla.Whale;
import naturix.divinerpg.objects.entities.entity.vanilla.WildFire;
import naturix.divinerpg.objects.entities.entity.vethia.AcidHag;
import naturix.divinerpg.objects.entities.entity.vethia.Biphron;
import naturix.divinerpg.objects.entities.entity.vethia.Bohemite;
import naturix.divinerpg.objects.entities.entity.vethia.CryptKeeper;
import naturix.divinerpg.objects.entities.entity.vethia.Cymesoid;
import naturix.divinerpg.objects.entities.entity.vethia.Dissiment;
import naturix.divinerpg.objects.entities.entity.vethia.Dreamwrecker;
import naturix.divinerpg.objects.entities.entity.vethia.Duo;
import naturix.divinerpg.objects.entities.entity.vethia.Ent;
import naturix.divinerpg.objects.entities.entity.vethia.Galroid;
import naturix.divinerpg.objects.entities.entity.vethia.Gorgosion;
import naturix.divinerpg.objects.entities.entity.vethia.Helio;
import naturix.divinerpg.objects.entities.entity.vethia.Herbomancer;
import naturix.divinerpg.objects.entities.entity.vethia.HiveQueen;
import naturix.divinerpg.objects.entities.entity.vethia.HiveSoldier;
import naturix.divinerpg.objects.entities.entity.vethia.HoverStinger;
import naturix.divinerpg.objects.entities.entity.vethia.Karos;
import naturix.divinerpg.objects.entities.entity.vethia.Kazrotic;
import naturix.divinerpg.objects.entities.entity.vethia.LadyLuna;
import naturix.divinerpg.objects.entities.entity.vethia.Lheiva;
import naturix.divinerpg.objects.entities.entity.vethia.Lorga;
import naturix.divinerpg.objects.entities.entity.vethia.Lorgaflight;
import naturix.divinerpg.objects.entities.entity.vethia.Mandragora;
import naturix.divinerpg.objects.entities.entity.vethia.MysteriousMan;
import naturix.divinerpg.objects.entities.entity.vethia.Quadro;
import naturix.divinerpg.objects.entities.entity.vethia.RaglokGogdure;
import naturix.divinerpg.objects.entities.entity.vethia.Shadahier;
import naturix.divinerpg.objects.entities.entity.vethia.Spinarus;
import naturix.divinerpg.objects.entities.entity.vethia.TheHunger;
import naturix.divinerpg.objects.entities.entity.vethia.Tocaxin;
import naturix.divinerpg.objects.entities.entity.vethia.Twins;
import naturix.divinerpg.objects.entities.entity.vethia.Vermenous;
import naturix.divinerpg.objects.entities.entity.vethia.Vhraak;
import naturix.divinerpg.objects.entities.entity.vethia.WreckForm;
import naturix.divinerpg.objects.entities.entity.vethia.Zone;
import naturix.divinerpg.objects.entities.entity.vethia.Zoragon;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {

	public static void init() {
		// register basic mobs
		int id = 1;
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".arrow_inferno"),
		        EntityInfernoArrow.class, DivineRPG.modId + ".arrow_inferno", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".arrow_acid"),
		        EntityEMP.class, DivineRPG.modId + ".arrow_acid", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".rock_cave"),
		        EntityCaveRock.class, DivineRPG.modId + ".rock_cave", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".frost_shot"),
		        EntityFrostShot.class, DivineRPG.modId + ".frost_shot", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".frost_cloud"),
		        EntityFrostCloud.class, DivineRPG.modId + ".frost_cloud", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".saguaro_worm_shot"),
		        SaguaroWormShot.class, DivineRPG.modId + ".saguaro_worm_shot", id++, DivineRPG.instance, 64, 3, true);

		Utils.registerProjectile(EntityVileStorm.class, "vilestorm");
		Utils.registerProjectile(EntityShuriken.class, "shuriken");
		Utils.registerProjectile(EntityDeath.class, "death");
		Utils.registerProjectile(EntityDisk.class, "disk_amthrimis");
		Utils.registerProjectile(EntitySparkler.class, "sparkler");
		// register advanced mobs
		id = 100;
		// arcana
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".deathcryx"),
		        Deathcryx.class, DivineRPG.modId + ".deathcryx", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".death_hound"),
		        DeathHound.class, DivineRPG.modId + ".death_hound", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".dramix"),
		        Dramix.class, DivineRPG.modId + ".dramix", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".dungeon_demon"),
		        DungeonDemon.class, DivineRPG.modId + ".dungeon_demon", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".leorna"),
		        Leorna.class, DivineRPG.modId + ".leorna", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".parasecta"),
		        Parasecta.class, DivineRPG.modId + ".parasecta", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".paratiku"),
		        Paratiku.class, DivineRPG.modId + ".paratiku", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".razorback"),
		        Razorback.class, DivineRPG.modId + ".razorback", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".rejuv_golem"),
		        RejuvGolem.class, DivineRPG.modId + ".rejuv_golem", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".roamer"),
		        Roamer.class, DivineRPG.modId + ".roamer", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".seimer"),
		        Seimer.class, DivineRPG.modId + ".seimer", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".wraith"),
		        Wraith.class, DivineRPG.modId + ".wraith", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		id = 200;
		// iceika
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".alicanto"),
		        Alicanto.class, DivineRPG.modId + ".allicanto", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".fractite"),
		        Fractite.class, DivineRPG.modId + ".fractite", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".frosty"),
		        Frosty.class, DivineRPG.modId + ".frosty", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".glacide"),
		        Glacide.class, DivineRPG.modId + ".glacide", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".hastreus"),
		        Hastreus.class, DivineRPG.modId + ".hastreus", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".rollum"),
		        Rollum.class, DivineRPG.modId + ".rollum", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".workshop_merchant"),
		        WorkshopMerchant.class, DivineRPG.modId + ".workshop_merchant", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".workshop_tinkerer"),
		        WorkshopTinkerer.class, DivineRPG.modId + ".workshop_tinkerer", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".frost_archer"),
		        FrostArcher.class, DivineRPG.modId + ".frost_archer", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		id = 300;
		// twilight
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".enchanted_archer"),
		        EnchantedArcher.class, DivineRPG.modId + ".enchanted_archer", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".skythern_archer"),
		        SkythernArcher.class, DivineRPG.modId + ".skythern_archer", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".mortum_archer"),
		        MortumArcher.class, DivineRPG.modId + ".mortum_archer", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".angry_bunny"),
		        AngryBunny.class, DivineRPG.modId + ".angry_bunny", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".tamed_angry_bunny"),
		        TameAngryBunny.class, DivineRPG.modId + ".tamed_angry_bunny", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".basalisk"),
		        Basalisk.class, DivineRPG.modId + ".basalisk", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".behemoth"),
		        Bohemoth.class, DivineRPG.modId + ".behemoth", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".bunny"), Bunny.class,
		        DivineRPG.modId + ".bunny", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".eden_cadillion"),
		        EdenCadillion.class, DivineRPG.modId + ".eden_cadillion", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(
		        new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".apalachia_cadillion"),
		        ApalachiaCadillion.class, DivineRPG.modId + ".apalachia_cadillion", id++, DivineRPG.instance, 64, 3,
		        true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".mortum_cadillion"),
		        MortumCadillion.class, DivineRPG.modId + ".mortum_cadillion", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".wildwood_cadillion"),
		        WildwoodCadillion.class, DivineRPG.modId + ".wildwood_cadillion", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".eden_cori"),
		        EdenCori.class, DivineRPG.modId + ".eden_cori", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".skythern_cori"),
		        SkythernCori.class, DivineRPG.modId + ".skythern_cori", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".dense_demon"),
		        DenseDemon.class, DivineRPG.modId + ".dense_demon", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".densos"),
		        Densos.class, DivineRPG.modId + ".densos", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".epiphite"),
		        Epiphite.class, DivineRPG.modId + ".epiphite", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".eternal_archer"),
		        EternalArcher.class, DivineRPG.modId + ".eternal_archer", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".greenfeet"),
		        Greenfeet.class, DivineRPG.modId + ".greenfeet", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".karot"), Karot.class,
		        DivineRPG.modId + ".karot", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".madivel"),
		        Madivel.class, DivineRPG.modId + ".madivel", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".mage"), Mage.class,
		        DivineRPG.modId + ".mage", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".megalith"),
		        Megalith.class, DivineRPG.modId + ".megalith", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".moon_wolf"),
		        MoonWolf.class, DivineRPG.modId + ".moon_wolf", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".mystic"),
		        Mystic.class, DivineRPG.modId + ".mystic", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".samek"), Samek.class,
		        DivineRPG.modId + ".samek", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".skythern_fiend"),
		        SkythernFiend.class, DivineRPG.modId + ".skythern_fiend", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".sorcerer"),
		        Sorcerer.class, DivineRPG.modId + ".sorcerer", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".soul_fiend"),
		        SoulFiend.class, DivineRPG.modId + ".soul_fiend", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".soul_spider"),
		        SoulSpider.class, DivineRPG.modId + ".soul_spider", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".soul_stealer"),
		        SoulStealer.class, DivineRPG.modId + ".soul_stealer", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".sun_archer"),
		        SunArcher.class, DivineRPG.modId + ".sun_archer", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".eden_tomo"),
		        EdenTomo.class, DivineRPG.modId + ".eden_tomo", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".wildwood_tomo"),
		        WildwoodTomo.class, DivineRPG.modId + ".wildwood_tomo", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".apalachia_tomo"),
		        ApalachiaTomo.class, DivineRPG.modId + ".apalachia_tomo", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".twilight_archer"),
		        TwilightArcher.class, DivineRPG.modId + ".twilight_archer", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".twilight_demon"),
		        TwilightDemon.class, DivineRPG.modId + ".twilight_demon", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".mortum_demon"),
		        MortumDemon.class, DivineRPG.modId + ".mortum_demon", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".apalachia_golem"),
		        ApalachiaGolem.class, DivineRPG.modId + ".apalachia_golem", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".skythern_golem"),
		        SkythernGolem.class, DivineRPG.modId + ".skythern_golem", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".enchanted_warrior"),
		        EnchantedWarrior.class, DivineRPG.modId + ".enchanted_warrior", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".wildwood_golem"),
		        WildwoodGolem.class, DivineRPG.modId + ".wildwood_golem", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".vamacheron"),
		        Vamecheron.class, DivineRPG.modId + ".vamacheron", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".varek"), Verek.class,
		        DivineRPG.modId + ".varek", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		id = 400;
		// vanilla
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".ancient_entity"),
		        AncientEntity.class, DivineRPG.modId + ".ancient_entity", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".shark"), Shark.class,
		        DivineRPG.modId + ".shark", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".wildfire"),
		        WildFire.class, DivineRPG.modId + ".wildfire", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".rotatick"),
		        Rotatick.class, DivineRPG.modId + ".rotatick", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".the_eye"),
		        TheEye.class, DivineRPG.modId + ".the_eye", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".ender_triplets"),
		        EnderTriplets.class, DivineRPG.modId + ".ender_triplets", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".the_watcher"),
		        TheWatcher.class, DivineRPG.modId + ".the_watcher", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".ayeraco_red"),
		        AyeracoRed.class, DivineRPG.modId + ".ayeraco_red", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".ayeraco_blue"),
		        AyeracoBlue.class, DivineRPG.modId + ".ayeraco_blue", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".ayeraco_yellow"),
		        AyeracoYellow.class, DivineRPG.modId + ".ayeraco_yellow", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".ayeraco_purple"),
		        AyeracoPurple.class, DivineRPG.modId + ".ayeraco_purple", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".ayeraco_green"),
		        AyeracoGreen.class, DivineRPG.modId + ".ayeraco_green", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".arid_warrior"),
		        AridWarrior.class, DivineRPG.modId + ".arid_warrior", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".crab"), Crab.class,
		        DivineRPG.modId + ".crab", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".king_crab"),
		        KingCrab.class, DivineRPG.modId + ".king_crab", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".king_of_scorchers"),
		        KingOfScorchers.class, DivineRPG.modId + ".king_of_scorchers", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".jungle_dramcryx"),
		        JungleDramcryx.class, DivineRPG.modId + ".jungle_dramcryx", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(
		        new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".enthralled_dramcryx"),
		        EnthralledDramcryx.class, DivineRPG.modId + ".enthralled_dramcryx", id++, DivineRPG.instance, 64, 3,
		        true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".ehu"), Ehu.class,
		        DivineRPG.modId + ".ehu", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		// HERE
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".frost"), Frost.class,
		        DivineRPG.modId + ".frost", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".cave_crawler"),
		        CaveCrawler.class, DivineRPG.modId + ".cave_crawler", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".desert_crawler"),
		        DesertCrawler.class, DivineRPG.modId + ".desert_crawler", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".glacon"),
		        Glacon.class, DivineRPG.modId + ".glacon", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".grizzle"),
		        Grizzle.class, DivineRPG.modId + ".grizzle", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".the_grue"),
		        TheGrue.class, DivineRPG.modId + ".the_grue", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".hell_spider"),
		        HellSpider.class, DivineRPG.modId + ".hell_spider", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".husk"), Husk.class,
		        DivineRPG.modId + ".husk", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".miner"), Miner.class,
		        DivineRPG.modId + ".miner", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".jackoman"),
		        JackOMan.class, DivineRPG.modId + ".jackoman", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".jungle_bat"),
		        JungleBat.class, DivineRPG.modId + ".jungle_bat", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".jungle_spider"),
		        JungleSpider.class, DivineRPG.modId + ".jungle_spider", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".kobblin"),
		        Kobblin.class, DivineRPG.modId + ".kobblin", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".liopleurodon"),
		        Liopleurodon.class, DivineRPG.modId + ".liopleurodon", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".livestock_merchant"),
		        LivestockMerchant.class, DivineRPG.modId + ".livestock_merchant", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".pumpkin_spider"),
		        PumpkinSpider.class, DivineRPG.modId + ".pumpkin_spider", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".rainbour"),
		        Rainbour.class, DivineRPG.modId + ".rainbour", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".scorcher"),
		        Scorcher.class, DivineRPG.modId + ".scorcher", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".smelter"),
		        Smelter.class, DivineRPG.modId + ".smelter", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".snapper"),
		        Snapper.class, DivineRPG.modId + ".snapper", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".stone_golem"),
		        StoneGolem.class, DivineRPG.modId + ".stone_golem", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".whale"), Whale.class,
		        DivineRPG.modId + ".whale", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".grizzle_white"),
		        GrizzleWhite.class, DivineRPG.modId + ".grizzle_white", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".ender_watcher"),
		        EnderWatcher.class, DivineRPG.modId + ".ender_watcher", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".cyclops"),
		        Cyclops.class, DivineRPG.modId + ".cyclops", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".caveclops"),
		        Caveclops.class, DivineRPG.modId + ".caveclops", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".ender_spider"),
		        EnderSpider.class, DivineRPG.modId + ".ender_spider", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".hell_pig"),
		        HellPig.class, DivineRPG.modId + ".hell_pig", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".saguaro_worm"),
		        SaguaroWorm.class, DivineRPG.modId + ".saguaro_worm", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);

		id = 500;
		// vethia
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".acid_hag"),
		        AcidHag.class, DivineRPG.modId + ".acid_hag", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		// HERE
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".basalisk"),
		        Basalisk.class, DivineRPG.modId + ".basalisk", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".biphron"),
		        Biphron.class, DivineRPG.modId + ".biphron", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".bohemite"),
		        Bohemite.class, DivineRPG.modId + ".bohemite", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".crypt_keeper"),
		        CryptKeeper.class, DivineRPG.modId + ".crypt_keeper", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".cymesoid"),
		        Cymesoid.class, DivineRPG.modId + ".cymesoid", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".dissiment"),
		        Dissiment.class, DivineRPG.modId + ".dissiment", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".dreamwrecker"),
		        Dreamwrecker.class, DivineRPG.modId + ".dreamwrecker", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".duo"), Duo.class,
		        DivineRPG.modId + ".duo", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".ent"), Ent.class,
		        DivineRPG.modId + ".ent", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".galroid"),
		        Galroid.class, DivineRPG.modId + ".galroid", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".gorgosion"),
		        Gorgosion.class, DivineRPG.modId + ".gorgosion", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".helio"), Helio.class,
		        DivineRPG.modId + ".helio", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".herbomancer"),
		        Herbomancer.class, DivineRPG.modId + ".herbomancer", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".hive_queen"),
		        HiveQueen.class, DivineRPG.modId + ".hive_queen", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".hive_soldier"),
		        HiveSoldier.class, DivineRPG.modId + ".hive_soldier", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".hover_stinger"),
		        HoverStinger.class, DivineRPG.modId + ".hover_stinger", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".karos"), Karos.class,
		        DivineRPG.modId + ".karos", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".kazrotic"),
		        Kazrotic.class, DivineRPG.modId + ".kazrotic", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".lady_luna"),
		        LadyLuna.class, DivineRPG.modId + ".lady_luna", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".lheiva"),
		        Lheiva.class, DivineRPG.modId + ".lheiva", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".lorga"), Lorga.class,
		        DivineRPG.modId + ".lorga", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".lorga_flight"),
		        Lorgaflight.class, DivineRPG.modId + ".lorga_flight", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".mandragora"),
		        Mandragora.class, DivineRPG.modId + ".mandragora", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".mysterious_man"),
		        MysteriousMan.class, DivineRPG.modId + ".mysterious_man", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".quadro"),
		        Quadro.class, DivineRPG.modId + ".quadro", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".raglok_gogdure"),
		        RaglokGogdure.class, DivineRPG.modId + ".raglok_gogdure", id++, DivineRPG.instance, 64, 3, true,
		        0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".shadahier"),
		        Shadahier.class, DivineRPG.modId + ".shadahier", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".spinarus"),
		        Spinarus.class, DivineRPG.modId + ".spinarus", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".tocaxin"),
		        Tocaxin.class, DivineRPG.modId + ".tocaxin", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".twins"), Twins.class,
		        DivineRPG.modId + ".twins", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".vermenous"),
		        Vermenous.class, DivineRPG.modId + ".vermenous", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".vhraak"),
		        Vhraak.class, DivineRPG.modId + ".vhraak", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".wreck_form"),
		        WreckForm.class, DivineRPG.modId + ".wreck_form", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".zone"), Zone.class,
		        DivineRPG.modId + ".zone", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".zoragon"),
		        Zoragon.class, DivineRPG.modId + ".zoragon", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, DivineRPG.modId + ".the_hunger"),
		        TheHunger.class, DivineRPG.modId + ".the_hunger", id++, DivineRPG.instance, 64, 3, true, 0x00000,
		        0xff0000);

		if (Config.debug) {
			DivineRPG.logger.info(DivineRPG.modId + " entities have been loaded");
		}

	}

	public static void initLoot() {
		// loot
		LootTableList.register(JungleDramcryx.LOOT);
		LootTableList.register(Shark.LOOT);
		LootTableList.register(WildFire.LOOT);
		LootTableList.register(Rotatick.LOOT);
		LootTableList.register(EnderTriplets.LOOT);
		LootTableList.register(Leorna.LOOT);
		LootTableList.register(Parasecta.LOOT);
		LootTableList.register(Paratiku.LOOT);
		LootTableList.register(AcidHag.LOOT);
		LootTableList.register(Razorback.LOOT);
		LootTableList.register(RejuvGolem.LOOT);
		LootTableList.register(Roamer.LOOT);
		LootTableList.register(Seimer.LOOT);
		LootTableList.register(Wraith.LOOT);
		LootTableList.register(HellSpider.LOOT);
		LootTableList.register(Alicanto.LOOT);
		LootTableList.register(Fractite.LOOT);
		LootTableList.register(Frosty.LOOT);
		LootTableList.register(Glacide.LOOT);
		LootTableList.register(Hastreus.LOOT);
		LootTableList.register(Rollum.LOOT);
		LootTableList.register(AngryBunny.LOOT);
		LootTableList.register(Basalisk.LOOT);
		LootTableList.register(Bohemoth.LOOT);
		LootTableList.register(Bunny.LOOT);
		LootTableList.register(EdenCadillion.LOOT);
		LootTableList.register(EdenCori.LOOT);
		LootTableList.register(DenseDemon.LOOT);
		LootTableList.register(Densos.LOOT);
		LootTableList.register(EnchantedArcher.LOOT);
		LootTableList.register(EnchantedWarrior.LOOT);
		LootTableList.register(Epiphite.LOOT);
		LootTableList.register(EternalArcher.LOOT);
		LootTableList.register(Greenfeet.LOOT);
		LootTableList.register(Karot.LOOT);
		LootTableList.register(Madivel.LOOT);
		LootTableList.register(Mage.LOOT);
		LootTableList.register(Megalith.LOOT);
		LootTableList.register(MoonWolf.LOOT);
		LootTableList.register(Mystic.LOOT);
		LootTableList.register(Samek.LOOT);
		LootTableList.register(SkythernFiend.LOOT);
		LootTableList.register(Sorcerer.LOOT);
		LootTableList.register(SoulFiend.LOOT);
		LootTableList.register(SoulSpider.LOOT);
		LootTableList.register(SoulStealer.LOOT);
		LootTableList.register(SunArcher.LOOT);
		LootTableList.register(EdenTomo.LOOT);
		LootTableList.register(TwilightArcher.LOOT);
		LootTableList.register(TwilightDemon.LOOT);
		LootTableList.register(ApalachiaGolem.LOOT);
		LootTableList.register(AyeracoRed.LOOT);
		LootTableList.register(AyeracoBlue.LOOT);
		LootTableList.register(AyeracoYellow.LOOT);
		LootTableList.register(AyeracoPurple.LOOT);
		LootTableList.register(AyeracoGreen.LOOT);
		LootTableList.register(AridWarrior.LOOT);
		LootTableList.register(Crab.LOOT);
		LootTableList.register(KingCrab.LOOT);
		LootTableList.register(KingOfScorchers.LOOT);
		LootTableList.register(EnthralledDramcryx.LOOT);
		LootTableList.register(TameAngryBunny.LOOT);
		LootTableList.register(Frost.LOOT);
		LootTableList.register(CaveCrawler.LOOT);
		LootTableList.register(DesertCrawler.LOOT);
		LootTableList.register(Glacon.LOOT);
		LootTableList.register(TheGrue.LOOT);
		LootTableList.register(Miner.LOOT);
		LootTableList.register(JackOMan.LOOT);
		LootTableList.register(JungleBat.LOOT);
		LootTableList.register(JungleSpider.LOOT);
		LootTableList.register(Kobblin.LOOT);
		LootTableList.register(Liopleurodon.LOOT);
		LootTableList.register(LivestockMerchant.LOOT);
		LootTableList.register(PumpkinSpider.LOOT);
		LootTableList.register(Rainbour.LOOT);
		LootTableList.register(Scorcher.LOOT);
		LootTableList.register(Whale.LOOT);
		LootTableList.register(EnderWatcher.LOOT);
		LootTableList.register(Verek.LOOT);
		LootTableList.register(TheEye.LOOT);
		LootTableList.register(TheWatcher.LOOT);
		LootTableList.register(Cyclops.LOOT);
		LootTableList.register(Caveclops.LOOT);
		LootTableList.register(EnderSpider.LOOT);

		if (Config.debug) {
			DivineRPG.logger.info(DivineRPG.modId + " loot has been loaded");
		}
	}

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		// arcana
		RenderingRegistry.registerEntityRenderingHandler(Deathcryx.class, RenderDeathcryx.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(DeathHound.class, RenderDeathHound.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(DungeonDemon.class, RenderDungeonDemon.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Dramix.class, RenderDramix.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Razorback.class, RenderRazorback.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(RejuvGolem.class, RenderRejuvGolem.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Roamer.class, RenderRoamer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Seimer.class, RenderSeimer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Wraith.class, RenderWraith.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Leorna.class, RenderLeorna.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Parasecta.class, RenderParasecta.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Paratiku.class, RenderParatiku.FACTORY);

		// iceika
		RenderingRegistry.registerEntityRenderingHandler(Alicanto.class, RenderAlicanto.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(FrostArcher.class, RenderFrostArcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Fractite.class, RenderFractite.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Frosty.class, RenderFrosty.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Glacide.class, RenderGlacide.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Hastreus.class, RenderHastreus.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Rollum.class, RenderRollum.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(WorkshopTinkerer.class, RenderWorkshopTinkerer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(WorkshopMerchant.class, RenderWorkshopMerchant.FACTORY);

		// twilight
		RenderingRegistry.registerEntityRenderingHandler(AngryBunny.class, RenderAngryBunny.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TameAngryBunny.class, RenderTameAngryBunny.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Basalisk.class, RenderBasalisk.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Bohemoth.class, RenderBehemoth.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Bunny.class, RenderBunny.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EdenCadillion.class, RenderEdenCadillion.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EdenCori.class, RenderEdenCori.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(DenseDemon.class, RenderDenseDemon.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Densos.class, RenderDensos.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Epiphite.class, RenderEpiphite.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EternalArcher.class, RenderEternalArcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Greenfeet.class, RenderGreenfeet.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Karot.class, RenderKarot.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Madivel.class, RenderMadivel.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Mage.class, RenderMage.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Megalith.class, RenderMegalith.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(MoonWolf.class, RenderMoonWolf.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Mystic.class, RenderMystic.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Samek.class, RenderSamek.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SkythernFiend.class, RenderSkythernFiend.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Sorcerer.class, RenderSorcerer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SoulFiend.class, RenderSoulFiend.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SoulSpider.class, RenderSoulSpider.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SoulStealer.class, RenderSoulStealer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SunArcher.class, RenderSunArcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EdenTomo.class, RenderEdenTomo.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TwilightArcher.class, RenderTwilightArcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TwilightDemon.class, RenderTwilightDemon.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(ApalachiaGolem.class, RenderApalachiaGolem.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Vamecheron.class, RenderVamacheron.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EnchantedArcher.class, RenderEnchantedArcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(MortumArcher.class, RenderMortumArcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SkythernArcher.class, RenderSkythernArcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(ApalachiaCadillion.class, RenderApalachiaCadillion.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(MortumCadillion.class, RenderMortumCadillion.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(WildwoodCadillion.class, RenderWildwoodCadillion.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SkythernCori.class, RenderSkythernCori.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(MortumDemon.class, RenderMortumDemon.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SkythernGolem.class, RenderSkythernGolem.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(WildwoodGolem.class, RenderWildwoodGolem.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(ApalachiaTomo.class, RenderApalachiaTomo.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(WildwoodTomo.class, RenderWildwoodTomo.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EnchantedWarrior.class, RenderEnchantedWarrior.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Verek.class, RenderVerek.FACTORY);

		// vanilla
		RenderingRegistry.registerEntityRenderingHandler(JungleDramcryx.class, RenderJungleDramcryx.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(AncientEntity.class, RenderAncientEntity.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Shark.class, RenderShark.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(WildFire.class, RenderWildFire.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Rotatick.class, RenderRotatick.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TheEye.class, RenderTheEye.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EnderTriplets.class, RenderEnderTriplets.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TheWatcher.class, RenderTheWatcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(AyeracoRed.class, RenderAyerecoRed.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(AyeracoBlue.class, RenderAyeracoBlue.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(AyeracoYellow.class, RenderAyeracoYellow.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(AyeracoGreen.class, RenderAyeracoGreen.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(AyeracoPurple.class, RenderAyeracoPurple.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(AridWarrior.class, RenderAridWarrior.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Crab.class, RenderCrab.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(KingCrab.class, RenderKingCrab.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(KingOfScorchers.class, RenderKingOfScorchers.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EnthralledDramcryx.class, RenderEnthralledDramcryx.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Ehu.class, RenderEhu.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Frost.class, RenderFrost.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(CaveCrawler.class, RenderCaveCrawler.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(DesertCrawler.class, RenderDesertCrawler.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Glacon.class, RenderGlacon.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Grizzle.class, RenderGrizzle.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(GrizzleWhite.class, RenderGrizzleWhite.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TheGrue.class, RenderTheGrue.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(HellSpider.class, RenderHellSpider.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Husk.class, RenderHusk.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Miner.class, RenderMiner.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(JackOMan.class, RenderJackOMan.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(JungleBat.class, RenderJungleBat.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(JungleSpider.class, RenderJungleSpider.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Kobblin.class, RenderKobblin.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Liopleurodon.class, RenderLiopleurodon.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(LivestockMerchant.class, RenderLivestockMerchant.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(PumpkinSpider.class, RenderPumpkinSpider.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Rainbour.class, RenderRainbour.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Scorcher.class, RenderScorcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Snapper.class, RenderSnapper.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Smelter.class, RenderSmelter.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(StoneGolem.class, RenderStoneGolem.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Whale.class, RenderWhale.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EnderWatcher.class, RenderEnderWatcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Cyclops.class, RenderCyclops.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Caveclops.class, RenderCaveclops.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EnderSpider.class, RenderEnderSpider.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(HellPig.class, RenderHellPig.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SaguaroWorm.class, RenderSaguaroWorm.FACTORY);

		// vethia
		RenderingRegistry.registerEntityRenderingHandler(AcidHag.class, RenderAcidHag.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Basalisk.class, RenderBasalisk.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Biphron.class, RenderBiphron.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Bohemite.class, RenderBohemite.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(CryptKeeper.class, RenderCryptKeeper.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Cymesoid.class, RenderCymesoid.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Dissiment.class, RenderDissiment.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Dreamwrecker.class, RenderDreamwrecker.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Duo.class, RenderDuo.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Ent.class, RenderEnt.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Galroid.class, RenderGalroid.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Gorgosion.class, RenderGorgosion.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Helio.class, RenderHelio.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Herbomancer.class, RenderHerbomancer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(HiveQueen.class, RenderHiveQueen.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(HiveSoldier.class, RenderHiveSoldier.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(HoverStinger.class, RenderHoverStinger.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Karos.class, RenderKaros.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Kazrotic.class, RenderKazrotic.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(LadyLuna.class, RenderLadyLuna.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Lheiva.class, RenderLheiva.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Lorga.class, RenderLorga.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Lorgaflight.class, RenderLorgaFlight.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Mandragora.class, RenderMandragora.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(MysteriousMan.class, RenderMysteriousMan.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Quadro.class, RenderQuadro.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(RaglokGogdure.class, RenderRaglokGogdure.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Shadahier.class, RenderShadahier.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Spinarus.class, RenderSpinarus.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Tocaxin.class, RenderTocaxin.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Twins.class, RenderTwins.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Vermenous.class, RenderVermenous.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Vhraak.class, RenderVhraak.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(WreckForm.class, RenderWreckForm.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Zone.class, RenderZone.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Zoragon.class, RenderZoragon.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TheHunger.class, RenderTheHunger.FACTORY);
		// other
		RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, RenderHat.FACTORY);

		// Projectiles
		EntityVileStorm.renderMe();
		EntityCaveRock.renderMe();
		EntityFrostShot.renderMe();
		EntityFrostCloud.renderMe();
		SaguaroWormShot.renderMe();
		EntityEMP.renderMe();

		RenderingRegistry.registerEntityRenderingHandler(EntityShuriken.class,
		        manager -> new RenderProjectile(ModItems.shuriken));
	}

	public static void initSpawns() {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			Biome edenBiome = Biome.getBiome(ModBiomes.Eden.getIdForBiome(ModBiomes.Eden));
			Biome iceikaBiome = ModBiomes.Iceika;
			Biome wildwoodBiome = ModBiomes.WildWood;
			Biome apalachiaBiome = ModBiomes.Apalachia;
			Biome skythernBiome = ModBiomes.Skythern;
			Biome mortumBiome = ModBiomes.Mortum;

			EntityRegistry.addSpawn(Alicanto.class, 2, 1, 10, EnumCreatureType.MONSTER, iceikaBiome);
			EntityRegistry.addSpawn(Fractite.class, 2, 1, 10, EnumCreatureType.MONSTER, iceikaBiome);
			EntityRegistry.addSpawn(Glacide.class, 2, 1, 10, EnumCreatureType.MONSTER, iceikaBiome);
			EntityRegistry.addSpawn(Hastreus.class, 2, 1, 10, EnumCreatureType.MONSTER, iceikaBiome);
			EntityRegistry.addSpawn(FrostArcher.class, 2, 1, 10, EnumCreatureType.MONSTER, iceikaBiome);
			EntityRegistry.addSpawn(Frosty.class, 2, 1, 10, EnumCreatureType.MONSTER, iceikaBiome);
			EntityRegistry.addSpawn(Rollum.class, 2, 1, 10, EnumCreatureType.MONSTER, iceikaBiome);

			EntityRegistry.addSpawn(EdenTomo.class, 20, 4, 4, EnumCreatureType.MONSTER, edenBiome);
			EntityRegistry.addSpawn(EdenCadillion.class, 20, 4, 4, EnumCreatureType.MONSTER, edenBiome);
			EntityRegistry.addSpawn(Bunny.class, 20, 4, 4, EnumCreatureType.MONSTER, edenBiome);
			EntityRegistry.addSpawn(EdenTomo.class, 20, 4, 4, EnumCreatureType.CREATURE, edenBiome);
			EntityRegistry.addSpawn(EdenCadillion.class, 20, 4, 4, EnumCreatureType.CREATURE, edenBiome);
			EntityRegistry.addSpawn(Bunny.class, 20, 4, 4, EnumCreatureType.CREATURE, edenBiome);
			EntityRegistry.addSpawn(EdenCori.class, 1, 4, 4, EnumCreatureType.CREATURE, edenBiome);
			EntityRegistry.addSpawn(EdenCori.class, 1, 4, 4, EnumCreatureType.MONSTER, edenBiome);
			EntityRegistry.addSpawn(Greenfeet.class, 20, 4, 4, EnumCreatureType.MONSTER, edenBiome);
			EntityRegistry.addSpawn(Madivel.class, 20, 4, 4, EnumCreatureType.MONSTER, edenBiome);
			EntityRegistry.addSpawn(SunArcher.class, 6, 4, 4, EnumCreatureType.CREATURE, edenBiome);
			EntityRegistry.addSpawn(SunArcher.class, 6, 4, 4, EnumCreatureType.MONSTER, edenBiome);

			EntityRegistry.addSpawn(WildwoodCadillion.class, 4, 4, 4, EnumCreatureType.MONSTER, wildwoodBiome);
			EntityRegistry.addSpawn(WildwoodTomo.class, 4, 4, 4, EnumCreatureType.MONSTER, wildwoodBiome);
			EntityRegistry.addSpawn(WildwoodCadillion.class, 4, 4, 4, EnumCreatureType.CREATURE, wildwoodBiome);
			EntityRegistry.addSpawn(WildwoodTomo.class, 4, 4, 4, EnumCreatureType.CREATURE, wildwoodBiome);
			EntityRegistry.addSpawn(Epiphite.class, 1, 2, 2, EnumCreatureType.MONSTER, wildwoodBiome);
			EntityRegistry.addSpawn(Epiphite.class, 1, 2, 2, EnumCreatureType.CREATURE, wildwoodBiome);
			EntityRegistry.addSpawn(Bohemoth.class, 1, 1, 1, EnumCreatureType.MONSTER, wildwoodBiome);
			EntityRegistry.addSpawn(Bohemoth.class, 1, 1, 1, EnumCreatureType.CREATURE, wildwoodBiome);
			EntityRegistry.addSpawn(WildwoodGolem.class, 3, 4, 4, EnumCreatureType.MONSTER, wildwoodBiome);
			EntityRegistry.addSpawn(Verek.class, 4, 4, 4, EnumCreatureType.MONSTER, wildwoodBiome);
			EntityRegistry.addSpawn(Mage.class, 2, 4, 4, EnumCreatureType.MONSTER, wildwoodBiome);
			EntityRegistry.addSpawn(MoonWolf.class, 4, 4, 4, EnumCreatureType.CREATURE, wildwoodBiome);

			EntityRegistry.addSpawn(ApalachiaCadillion.class, 2, 4, 4, EnumCreatureType.MONSTER, apalachiaBiome);
			EntityRegistry.addSpawn(ApalachiaGolem.class, 2, 4, 4, EnumCreatureType.MONSTER, apalachiaBiome);
			EntityRegistry.addSpawn(ApalachiaTomo.class, 2, 4, 4, EnumCreatureType.MONSTER, apalachiaBiome);
			// EntityRegistry.addSpawn(ApalachiaWarrior.class, 2, 4, 4,
			// EnumCreatureType.monster, apalachiaBiome);
			// EntityRegistry.addSpawn(ApalachiaArcher.class, 2, 4, 4,
			// EnumCreatureType.monster, apalachiaBiome);
			// EntityRegistry.addSpawn(Spellbinder.class, 1, 4, 4, EnumCreatureType.MONSTER,
			// apalachiaBiome);

			EntityRegistry.addSpawn(SkythernFiend.class, 4, 4, 4, EnumCreatureType.MONSTER, skythernBiome);
			EntityRegistry.addSpawn(SkythernGolem.class, 4, 4, 4, EnumCreatureType.MONSTER, skythernBiome);
			EntityRegistry.addSpawn(SkythernArcher.class, 4, 4, 4, EnumCreatureType.MONSTER, skythernBiome);
			EntityRegistry.addSpawn(Samek.class, 4, 4, 4, EnumCreatureType.MONSTER, skythernBiome);
			EntityRegistry.addSpawn(SkythernCori.class, 1, 4, 4, EnumCreatureType.MONSTER, skythernBiome);
			EntityRegistry.addSpawn(Mystic.class, 2, 4, 4, EnumCreatureType.MONSTER, skythernBiome);
			EntityRegistry.addSpawn(Megalith.class, 1, 4, 4, EnumCreatureType.MONSTER, skythernBiome);

			EntityRegistry.addSpawn(MortumDemon.class, 2, 4, 4, EnumCreatureType.MONSTER, mortumBiome);
			EntityRegistry.addSpawn(Basalisk.class, 2, 4, 4, EnumCreatureType.MONSTER, mortumBiome);
			EntityRegistry.addSpawn(SoulStealer.class, 2, 4, 4, EnumCreatureType.MONSTER, mortumBiome);
			EntityRegistry.addSpawn(MortumCadillion.class, 2, 4, 4, EnumCreatureType.MONSTER, mortumBiome);
			EntityRegistry.addSpawn(TwilightArcher.class, 2, 4, 4, EnumCreatureType.MONSTER, mortumBiome);
			EntityRegistry.addSpawn(Sorcerer.class, 1, 4, 4, EnumCreatureType.MONSTER, mortumBiome);

			// all biomes
			EntityRegistry.addSpawn(Miner.class, 5, 1, 1, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(JackOMan.class, 5, 1, 1, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(CaveCrawler.class, 70, 2, 3, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(Rotatick.class, 70, 3, 4, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(EnthralledDramcryx.class, 70, 3, 4, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(TheEye.class, 30, 1, 4, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(TheGrue.class, 30, 1, 4, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(Caveclops.class, 70, 1, 4, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(EnderSpider.class, 4, 1, 4, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(Rainbour.class, 1, 1, 1, EnumCreatureType.AMBIENT, biome);

			// Beach Mobs
			EntityRegistry.addSpawn(Crab.class, 100, 4, 4, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(KingCrab.class, 40, 4, 4, EnumCreatureType.MONSTER, biome);

			EntityRegistry.addSpawn(EnderSpider.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(EnderTriplets.class, 1, 1, 4, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(EnderWatcher.class, 10, 4, 4, EnumCreatureType.MONSTER, biome);

			if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.NETHER)) {
				// EntityRegistry.addSpawn(HellBat.class, 50, 1, 1, EnumCreatureType.MONSTER,
				// biome);
				EntityRegistry.addSpawn(HellPig.class, 25, 5, 50, EnumCreatureType.CREATURE, biome);
				EntityRegistry.addSpawn(HellSpider.class, 50, 1, 1, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(Scorcher.class, 7, 4, 4, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(WildFire.class, 50, 1, 1, EnumCreatureType.MONSTER, biome);
			}

			if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.SNOWY)) {
				EntityRegistry.addSpawn(Glacon.class, 30, 1, 1, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(Glacon.class, 30, 1, 1, EnumCreatureType.CREATURE, biome);
				EntityRegistry.addSpawn(Frost.class, 50, 1, 4, EnumCreatureType.MONSTER, biome);
			}
			if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.SANDY)) {
				EntityRegistry.addSpawn(DesertCrawler.class, 50, 1, 4, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(AridWarrior.class, 35, 1, 4, EnumCreatureType.MONSTER, biome);
				// EntityRegistry.addSpawn(SaguaroWorm.class, 20, 1, 4,
				// EnumCreatureType.MONSTER, biome);
			}
			if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.JUNGLE)) {
				EntityRegistry.addSpawn(JungleBat.class, 50, 1, 4, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(JungleDramcryx.class, 80, 1, 4, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(JungleSpider.class, 80, 1, 4, EnumCreatureType.MONSTER, biome);
			}
			if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.PLAINS)) {
				EntityRegistry.addSpawn(Kobblin.class, 5, 1, 1, EnumCreatureType.MONSTER, biome);
			}
			if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.PLAINS)
			        || BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.MOUNTAIN)) {
				EntityRegistry.addSpawn(Cyclops.class, 80, 2, 4, EnumCreatureType.MONSTER, biome);
			}
			if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.FOREST)) {
				EntityRegistry.addSpawn(PumpkinSpider.class, 20, 1, 1, EnumCreatureType.MONSTER, biome);
			}

			if (Config.debug) {
				DivineRPG.logger.info(DivineRPG.modId + " spawns have been loaded");
			}
		}
	}
}