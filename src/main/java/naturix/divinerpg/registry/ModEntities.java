package naturix.divinerpg.registry;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.assets.model.iceika.model.RenderWorkshopTinkerer;
import naturix.divinerpg.objects.entities.assets.render.RenderHat;
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
import naturix.divinerpg.objects.entities.assets.render.twilight.RenderReyvor;
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
import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderWildfire;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderAcidHag;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderBiphron;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderBohemite;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderCryptKeeper;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderCymesoid;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderDissiment;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderDreamwrecker;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderDuo;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderEnt;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderGalroid;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderGorgosion;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderHelio;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderHerbomancer;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderHiveQueen;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderHiveSoldier;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderHoverStinger;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderKaros;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderKazrotic;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderLadyLuna;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderLheiva;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderLorga;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderLorgaFlight;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderMandragora;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderMysteriousMan;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderQuadro;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderRaglokGogdure;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderShadahier;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderSpinarus;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderTheHunger;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderTocaxin;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderTwins;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderVermenous;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderVhraak;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderWreckForm;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderZone;
import naturix.divinerpg.objects.entities.assets.render.vethea.RenderZoragon;
import naturix.divinerpg.objects.entities.entity.EntityDisk;
import naturix.divinerpg.objects.entities.entity.EntityEMP;
import naturix.divinerpg.objects.entities.entity.EntityFrostCloud;
import naturix.divinerpg.objects.entities.entity.arcana.DeathHound;
import naturix.divinerpg.objects.entities.entity.arcana.Deathcryx;
import naturix.divinerpg.objects.entities.entity.arcana.Dramix;
import naturix.divinerpg.objects.entities.entity.arcana.DungeonDemon;
import naturix.divinerpg.objects.entities.entity.twilight.EdenCadillion;
import naturix.divinerpg.objects.entities.entity.twilight.EdenCori;
import naturix.divinerpg.objects.entities.entity.twilight.EdenTomo;
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
import naturix.divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityEnderTripletsFireball;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityFractiteShot;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityFrostShot;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityInfernoArrow;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityKingOfScorchersMeteor;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityKingOfScorchersShot;
import naturix.divinerpg.objects.entities.entity.projectiles.EntitySaguaroWormShot;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityScorcherShot;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityShuriken;
import naturix.divinerpg.objects.entities.entity.projectiles.EntitySnowflakeShuriken;
import naturix.divinerpg.objects.entities.entity.projectiles.EntitySparkler;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityVileStorm;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityWatcherShot;
import naturix.divinerpg.objects.entities.entity.twilight.AngryBunny;
import naturix.divinerpg.objects.entities.entity.twilight.ApalachiaCadillion;
import naturix.divinerpg.objects.entities.entity.twilight.ApalachiaGolem;
import naturix.divinerpg.objects.entities.entity.twilight.ApalachiaTomo;
import naturix.divinerpg.objects.entities.entity.twilight.Basilisk;
import naturix.divinerpg.objects.entities.entity.twilight.Behemoth;
import naturix.divinerpg.objects.entities.entity.twilight.Bunny;
import naturix.divinerpg.objects.entities.entity.twilight.DenseDemon;
import naturix.divinerpg.objects.entities.entity.twilight.Densos;
import naturix.divinerpg.objects.entities.entity.twilight.EnchantedArcher;
import naturix.divinerpg.objects.entities.entity.twilight.EnchantedWarrior;
import naturix.divinerpg.objects.entities.entity.twilight.Reyvor;
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
import naturix.divinerpg.objects.entities.entity.twilight.Vamacheron;
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
import naturix.divinerpg.objects.entities.entity.vanilla.Wildfire;
import naturix.divinerpg.objects.entities.entity.vethea.AcidHag;
import naturix.divinerpg.objects.entities.entity.vethea.Biphron;
import naturix.divinerpg.objects.entities.entity.vethea.Bohemite;
import naturix.divinerpg.objects.entities.entity.vethea.CryptKeeper;
import naturix.divinerpg.objects.entities.entity.vethea.Cymesoid;
import naturix.divinerpg.objects.entities.entity.vethea.Dissiment;
import naturix.divinerpg.objects.entities.entity.vethea.Dreamwrecker;
import naturix.divinerpg.objects.entities.entity.vethea.Duo;
import naturix.divinerpg.objects.entities.entity.vethea.Ent;
import naturix.divinerpg.objects.entities.entity.vethea.Galroid;
import naturix.divinerpg.objects.entities.entity.vethea.Gorgosion;
import naturix.divinerpg.objects.entities.entity.vethea.Helio;
import naturix.divinerpg.objects.entities.entity.vethea.Herbomancer;
import naturix.divinerpg.objects.entities.entity.vethea.HiveQueen;
import naturix.divinerpg.objects.entities.entity.vethea.HiveSoldier;
import naturix.divinerpg.objects.entities.entity.vethea.HoverStinger;
import naturix.divinerpg.objects.entities.entity.vethea.Karos;
import naturix.divinerpg.objects.entities.entity.vethea.Kazrotic;
import naturix.divinerpg.objects.entities.entity.vethea.LadyLuna;
import naturix.divinerpg.objects.entities.entity.vethea.Lheiva;
import naturix.divinerpg.objects.entities.entity.vethea.Lorga;
import naturix.divinerpg.objects.entities.entity.vethea.Lorgaflight;
import naturix.divinerpg.objects.entities.entity.vethea.Mandragora;
import naturix.divinerpg.objects.entities.entity.vethea.MysteriousMan;
import naturix.divinerpg.objects.entities.entity.vethea.Quadro;
import naturix.divinerpg.objects.entities.entity.vethea.RaglokGogdure;
import naturix.divinerpg.objects.entities.entity.vethea.Shadahier;
import naturix.divinerpg.objects.entities.entity.vethea.Spinarus;
import naturix.divinerpg.objects.entities.entity.vethea.TheHunger;
import naturix.divinerpg.objects.entities.entity.vethea.Tocaxin;
import naturix.divinerpg.objects.entities.entity.vethea.Twins;
import naturix.divinerpg.objects.entities.entity.vethea.Vermenous;
import naturix.divinerpg.objects.entities.entity.vethea.Vhraak;
import naturix.divinerpg.objects.entities.entity.vethea.WreckForm;
import naturix.divinerpg.objects.entities.entity.vethea.Zone;
import naturix.divinerpg.objects.entities.entity.vethea.Zoragon;
import naturix.divinerpg.utils.Reference;
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
	public static int projectileID = 0;
	public static int mobID = 500;

	public static void init() {
		// Projectiles
		registerProjectile(EntityEMP.class, "acid_arrow");
		registerProjectile(EntityCaveRock.class, "cave_rock");
		registerProjectile(EntityDeath.class, "death");
		registerProjectile(EntityDisk.class, "disk_amthrimis");
		registerProjectile(EntityDivineArrow.class, "divine_arrow");
		registerProjectile(EntityEnderTripletsFireball.class, "ender_triplets_fireball");
		registerProjectile(EntityFractiteShot.class, "fractite_shot");
		registerProjectile(EntityFrostShot.class, "frost_shot");
		registerProjectile(EntityFrostCloud.class, "frost_cloud");
		registerProjectile(EntityInfernoArrow.class, "inferno_arrow");
		registerProjectile(EntityKingOfScorchersMeteor.class, "king_of_scorchers_meteor");
		registerProjectile(EntityKingOfScorchersShot.class, "king_of_scorchers_shot");
		registerProjectile(EntitySaguaroWormShot.class, "saguaro_worm_shot");
		registerProjectile(EntityScorcherShot.class, "scorcher_shot");
		registerProjectile(EntityShuriken.class, "shuriken");
		registerProjectile(EntitySparkler.class, "sparkler");
		registerProjectile(EntityWatcherShot.class, "watcher_shot");
		registerProjectile(EntityVileStorm.class, "vilestorm");
		registerProjectile(EntitySnowflakeShuriken.class, "shuriken_snow");

		// Arcana
		// registerMobWithEgg(CaptianMerik.class, "captian_merik");
		// registerMobWithEgg(Constructor.class, "constructor");
		// registerMobWithEgg(Datticon.class, "datticon");
		registerMobWithEgg(Deathcryx.class, "deathcryx");
		registerMobWithEgg(DeathHound.class, "death_hound");
		registerMobWithEgg(Dramix.class, "dramix");
		registerMobWithEgg(DungeonDemon.class, "dungeon_demon");
		// registerMobWithEgg(DungeonPrisoner.class, "dungeon_prisoner");
		registerMobWithEgg(Leorna.class, "leorna");
		registerMobWithEgg(Parasecta.class, "parasecta");
		registerMobWithEgg(Paratiku.class, "paratiku");
		registerMobWithEgg(Razorback.class, "razorback");
		registerMobWithEgg(RejuvGolem.class, "rejuv_golem");
		registerMobWithEgg(Roamer.class, "roamer");
		registerMobWithEgg(Seimer.class, "seimer");
		registerMobWithEgg(Wraith.class, "wraith");

		// Iceika
		registerMobWithEgg(Alicanto.class, "alicanto");
		registerMobWithEgg(Fractite.class, "fractite");
		registerMobWithEgg(FrostArcher.class, "frost_archer");
		registerMobWithEgg(Frosty.class, "frosty");
		registerMobWithEgg(Glacide.class, "glacide");
		registerMobWithEgg(Hastreus.class, "hastreus");
		registerMobWithEgg(Rollum.class, "rollum");
		registerMobWithEgg(WorkshopMerchant.class, "workshop_merchant");
		registerMobWithEgg(WorkshopTinkerer.class, "workshop_tinkerer");

		// Twilight
		registerMobWithEgg(AngryBunny.class, "angry_bunny");
		registerMobWithEgg(ApalachiaCadillion.class, "apalachia_cadillion");
		registerMobWithEgg(ApalachiaGolem.class, "apalachia_golem");
		registerMobWithEgg(ApalachiaTomo.class, "apalachia_tomo");
		registerMobWithEgg(Basilisk.class, "basalisk");
		registerMobWithEgg(Behemoth.class, "behemoth");
		registerMobWithEgg(Bunny.class, "bunny");
		registerMobWithEgg(DenseDemon.class, "dense_demon");
		registerMobWithEgg(Densos.class, "densos");
		registerMobWithEgg(EdenCadillion.class, "eden_cadillion");
		registerMobWithEgg(EdenCori.class, "eden_cori");
		registerMobWithEgg(EdenTomo.class, "eden_tomo");
		registerMobWithEgg(EnchantedArcher.class, "enchanted_archer");
		registerMobWithEgg(EnchantedWarrior.class, "enchanted_warrior");
		registerMobWithEgg(Epiphite.class, "epiphite");
		registerMobWithEgg(EternalArcher.class, "eternal_archer");
		registerMobWithEgg(Greenfeet.class, "greenfeet");
		registerMobWithEgg(Karot.class, "karot");
		registerMobWithEgg(Madivel.class, "madivel");
		registerMobWithEgg(Mage.class, "mage");
		registerMobWithEgg(Megalith.class, "megalith");
		registerMobWithEgg(MoonWolf.class, "moon_wolf");
		registerMobWithEgg(MortumArcher.class, "mortum_archer");
		registerMobWithEgg(MortumCadillion.class, "mortum_cadillion");
		registerMobWithEgg(MortumDemon.class, "mortum_demon");
		registerMobWithEgg(Mystic.class, "mystic");
		registerMobWithEgg(Samek.class, "samek");
		registerMobWithEgg(SkythernArcher.class, "skythern_archer");
		registerMobWithEgg(SkythernCori.class, "skythern_cori");
		registerMobWithEgg(SkythernFiend.class, "skythern_fiend");
		registerMobWithEgg(SkythernGolem.class, "skythern_golem");
		registerMobWithEgg(Sorcerer.class, "sorcerer");
		registerMobWithEgg(SoulFiend.class, "soul_fiend");
		registerMobWithEgg(SoulSpider.class, "soul_spider");
		registerMobWithEgg(SoulStealer.class, "soul_stealer");
		registerMobWithEgg(SunArcher.class, "sun_archer");
		registerMobWithEgg(Reyvor.class, "reyvor");
		registerMobWithEgg(TameAngryBunny.class, "tamed_angry_bunny");
		registerMobWithEgg(TwilightArcher.class, "twilight_archer");
		registerMobWithEgg(TwilightDemon.class, "twilight_demon");
		registerMobWithEgg(Vamacheron.class, "vamacheron");
		registerMobWithEgg(Verek.class, "varek");
		registerMobWithEgg(WildwoodCadillion.class, "wildwood_cadillion");
		registerMobWithEgg(WildwoodGolem.class, "wildwood_golem");
		registerMobWithEgg(WildwoodTomo.class, "wildwood_tomo");

		// Vanilla
		registerMobWithEgg(AncientEntity.class, "ancient_entity");
		registerMobWithEgg(AridWarrior.class, "arid_warrior");
		registerMobWithEgg(AyeracoBlue.class, "ayeraco_blue");
		registerMobWithEgg(AyeracoGreen.class, "ayeraco_green");
		registerMobWithEgg(AyeracoPurple.class, "ayeraco_purple");
		registerMobWithEgg(AyeracoRed.class, "ayeraco_red");
		registerMobWithEgg(AyeracoYellow.class, "ayeraco_yellow");
		registerMobWithEgg(CaveCrawler.class, "cave_crawler");
		registerMobWithEgg(Caveclops.class, "caveclops");
		registerMobWithEgg(Crab.class, "crab");
		registerMobWithEgg(Cyclops.class, "cyclops");
		registerMobWithEgg(DesertCrawler.class, "desert_crawler");
		registerMobWithEgg(Ehu.class, "ehu");
		registerMobWithEgg(EnderSpider.class, "ender_spider");
		registerMobWithEgg(EnderTriplets.class, "ender_triplets");
		registerMobWithEgg(EnderWatcher.class, "ender_watcher");
		registerMobWithEgg(EnthralledDramcryx.class, "enthralled_dramcryx");
		registerMobWithEgg(Frost.class, "frost");
		registerMobWithEgg(Glacon.class, "glacon");
		registerMobWithEgg(Grizzle.class, "grizzle");
		registerMobWithEgg(GrizzleWhite.class, "grizzle_white");
		registerMobWithEgg(HellPig.class, "hell_pig");
		registerMobWithEgg(HellSpider.class, "hell_spider");
		registerMobWithEgg(Husk.class, "husk");
		registerMobWithEgg(JackOMan.class, "jackoman");
		registerMobWithEgg(JungleBat.class, "jungle_bat");
		registerMobWithEgg(JungleDramcryx.class, "jungle_dramcryx");
		registerMobWithEgg(JungleSpider.class, "jungle_spider");
		registerMobWithEgg(KingCrab.class, "king_crab");
		registerMobWithEgg(KingOfScorchers.class, "king_of_scorchers");
		registerMobWithEgg(Kobblin.class, "kobblin");
		registerMobWithEgg(Liopleurodon.class, "liopleurodon");
		registerMobWithEgg(LivestockMerchant.class, "livestock_merchant");
		registerMobWithEgg(Miner.class, "miner");
		registerMobWithEgg(PumpkinSpider.class, "pumpkin_spider");
		registerMobWithEgg(Rainbour.class, "rainbour");
		registerMobWithEgg(Rotatick.class, "rotatick");
		registerMobWithEgg(SaguaroWorm.class, "saguaro_worm");
		registerMobWithEgg(Scorcher.class, "scorcher");
		registerMobWithEgg(Shark.class, "shark");
		registerMobWithEgg(Smelter.class, "smelter");
		registerMobWithEgg(Snapper.class, "snapper");
		registerMobWithEgg(StoneGolem.class, "stone_golem");
		registerMobWithEgg(TheEye.class, "the_eye");
		registerMobWithEgg(TheGrue.class, "the_grue");
		registerMobWithEgg(TheWatcher.class, "the_watcher");
		registerMobWithEgg(Whale.class, "whale");
		registerMobWithEgg(Wildfire.class, "wildfire");

		// Vethia
		registerMobWithEgg(AcidHag.class, "acid_hag");
		registerMobWithEgg(Biphron.class, "biphron");
		registerMobWithEgg(Bohemite.class, "bohemite");
		registerMobWithEgg(CryptKeeper.class, "crypt_keeper");
		registerMobWithEgg(Cymesoid.class, "cymesoid");
		registerMobWithEgg(Dissiment.class, "dissiment");
		registerMobWithEgg(Dreamwrecker.class, "dreamwrecker");
		registerMobWithEgg(Duo.class, "duo");
		registerMobWithEgg(Ent.class, "ent");
		registerMobWithEgg(Galroid.class, "galroid");
		registerMobWithEgg(Gorgosion.class, "gorgosion");
		registerMobWithEgg(Helio.class, "helio");
		registerMobWithEgg(Herbomancer.class, "herbomancer");
		registerMobWithEgg(HiveQueen.class, "hive_queen");
		registerMobWithEgg(HiveSoldier.class, "hive_soldier");
		registerMobWithEgg(HoverStinger.class, "hover_stinger");
		registerMobWithEgg(Karos.class, "karos");
		registerMobWithEgg(Kazrotic.class, "kazrotic");
		registerMobWithEgg(LadyLuna.class, "lady_luna");
		registerMobWithEgg(Lheiva.class, "lheiva");
		registerMobWithEgg(Lorga.class, "lorga");
		registerMobWithEgg(Lorgaflight.class, "lorga_flight");
		registerMobWithEgg(Mandragora.class, "mandragora");
		registerMobWithEgg(MysteriousMan.class, "mysterious_man");
		registerMobWithEgg(Quadro.class, "quadro");
		registerMobWithEgg(RaglokGogdure.class, "raglok_gogdure");
		registerMobWithEgg(Shadahier.class, "shadahier");
		registerMobWithEgg(Spinarus.class, "spinarus");
		registerMobWithEgg(TheHunger.class, "the_hunger");
		registerMobWithEgg(Tocaxin.class, "tocaxin");
		registerMobWithEgg(Twins.class, "twins");
		registerMobWithEgg(Vermenous.class, "vermenous");
		registerMobWithEgg(Vhraak.class, "vhraak");
		registerMobWithEgg(WreckForm.class, "wreck_form");
		registerMobWithEgg(Zone.class, "zone");
		registerMobWithEgg(Zoragon.class, "zoragon");

		if (Config.debug) {
			DivineRPG.logger.info(Reference.MODID + " entities have been loaded");
		}
	}

	public static void initLoot() {
		LootTableList.register(AcidHag.LOOT);
		LootTableList.register(Alicanto.LOOT);
		LootTableList.register(AngryBunny.LOOT);
		LootTableList.register(ApalachiaGolem.LOOT);
		LootTableList.register(AridWarrior.LOOT);
		LootTableList.register(AyeracoBlue.LOOT);
		LootTableList.register(AyeracoGreen.LOOT);
		LootTableList.register(AyeracoPurple.LOOT);
		LootTableList.register(AyeracoRed.LOOT);
		LootTableList.register(AyeracoYellow.LOOT);
		LootTableList.register(Basilisk.LOOT);
		LootTableList.register(Behemoth.LOOT);
		LootTableList.register(Bunny.LOOT);
		LootTableList.register(CaveCrawler.LOOT);
		LootTableList.register(Caveclops.LOOT);
		LootTableList.register(Crab.LOOT);
		LootTableList.register(Cyclops.LOOT);
		LootTableList.register(DenseDemon.LOOT);
		LootTableList.register(Densos.LOOT);
		LootTableList.register(DesertCrawler.LOOT);
		LootTableList.register(EdenCadillion.LOOT);
		LootTableList.register(EdenCori.LOOT);
		LootTableList.register(EdenTomo.LOOT);
		LootTableList.register(EnchantedArcher.LOOT);
		LootTableList.register(EnchantedWarrior.LOOT);
		LootTableList.register(EnderSpider.LOOT);
		LootTableList.register(EnderTriplets.LOOT);
		LootTableList.register(EnderWatcher.LOOT);
		LootTableList.register(EnthralledDramcryx.LOOT);
		LootTableList.register(Epiphite.LOOT);
		LootTableList.register(EternalArcher.LOOT);
		LootTableList.register(Fractite.LOOT);
		LootTableList.register(Frost.LOOT);
		LootTableList.register(Frosty.LOOT);
		LootTableList.register(Glacide.LOOT);
		LootTableList.register(Glacon.LOOT);
		LootTableList.register(Greenfeet.LOOT);
		LootTableList.register(Hastreus.LOOT);
		LootTableList.register(HellSpider.LOOT);
		LootTableList.register(JungleBat.LOOT);
		LootTableList.register(JungleDramcryx.LOOT);
		LootTableList.register(JungleSpider.LOOT);
		LootTableList.register(Karot.LOOT);
		LootTableList.register(KingCrab.LOOT);
		LootTableList.register(KingOfScorchers.LOOT);
		LootTableList.register(Kobblin.LOOT);
		LootTableList.register(Leorna.LOOT);
		LootTableList.register(Liopleurodon.LOOT);
		LootTableList.register(Madivel.LOOT);
		LootTableList.register(Mage.LOOT);
		LootTableList.register(Megalith.LOOT);
		LootTableList.register(Miner.LOOT);
		LootTableList.register(MoonWolf.LOOT);
		LootTableList.register(Mystic.LOOT);
		LootTableList.register(Parasecta.LOOT);
		LootTableList.register(Paratiku.LOOT);
		LootTableList.register(PumpkinSpider.LOOT);
		LootTableList.register(Rainbour.LOOT);
		LootTableList.register(Razorback.LOOT);
		LootTableList.register(RejuvGolem.LOOT);
		LootTableList.register(Roamer.LOOT);
		LootTableList.register(Reyvor.LOOT);
		LootTableList.register(Rollum.LOOT);
		LootTableList.register(Rotatick.LOOT);
		LootTableList.register(Samek.LOOT);
		LootTableList.register(Scorcher.LOOT);
		LootTableList.register(Seimer.LOOT);
		LootTableList.register(Shark.LOOT);
		LootTableList.register(SkythernFiend.LOOT);
		LootTableList.register(Sorcerer.LOOT);
		LootTableList.register(SoulFiend.LOOT);
		LootTableList.register(SoulSpider.LOOT);
		LootTableList.register(SoulStealer.LOOT);
		LootTableList.register(SunArcher.LOOT);
		LootTableList.register(TameAngryBunny.LOOT);
		LootTableList.register(TheEye.LOOT);
		LootTableList.register(TheGrue.LOOT);
		LootTableList.register(TheWatcher.LOOT);
		LootTableList.register(TwilightArcher.LOOT);
		LootTableList.register(TwilightDemon.LOOT);
		LootTableList.register(Verek.LOOT);
		LootTableList.register(Whale.LOOT);
		LootTableList.register(Wildfire.LOOT);
		LootTableList.register(Wraith.LOOT);

		if (Config.debug) {
			DivineRPG.logger.info(Reference.MODID + " loot has been loaded");
		}
	}

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		// Projectiles
		EntityCaveRock.renderMe();
		EntityDivineArrow.renderMe();
		EntityEnderTripletsFireball.renderMe();
		EntityFractiteShot.renderMe();
		EntityFrostShot.renderMe();
		EntityFrostCloud.renderMe();
		EntityInfernoArrow.renderMe();
		EntityKingOfScorchersMeteor.renderMe();
		EntityKingOfScorchersShot.renderMe();
		EntitySaguaroWormShot.renderMe();
		EntityScorcherShot.renderMe();
		EntityEMP.renderMe();
		EntityVileStorm.renderMe();
		EntityWatcherShot.renderMe();
		EntitySnowflakeShuriken.renderMe();

		// RenderingRegistry.registerEntityRenderingHandler(EntityShuriken.class,
		// manager -> new RenderProjectile(ModItems.shuriken));

		// Arcana
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

		// Iceika
		RenderingRegistry.registerEntityRenderingHandler(Alicanto.class, RenderAlicanto.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(FrostArcher.class, RenderFrostArcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Fractite.class, RenderFractite.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Frosty.class, RenderFrosty.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Glacide.class, RenderGlacide.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Hastreus.class, RenderHastreus.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Rollum.class, RenderRollum.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(WorkshopTinkerer.class, RenderWorkshopTinkerer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(WorkshopMerchant.class, RenderWorkshopMerchant.FACTORY);

		// Twilight
		RenderingRegistry.registerEntityRenderingHandler(AngryBunny.class, RenderAngryBunny.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TameAngryBunny.class, RenderTameAngryBunny.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Basilisk.class, RenderBasalisk.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Behemoth.class, RenderBehemoth.FACTORY);
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
		RenderingRegistry.registerEntityRenderingHandler(Vamacheron.class, RenderVamacheron.FACTORY);
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
		RenderingRegistry.registerEntityRenderingHandler(Reyvor.class, RenderReyvor.FACTORY);

		// Vanilla
		RenderingRegistry.registerEntityRenderingHandler(JungleDramcryx.class, RenderJungleDramcryx.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(AncientEntity.class, RenderAncientEntity.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Shark.class, RenderShark.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Wildfire.class, RenderWildfire.FACTORY);
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

		// Vethia
		RenderingRegistry.registerEntityRenderingHandler(AcidHag.class, RenderAcidHag.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Basilisk.class, RenderBasalisk.FACTORY);
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

		// Other
		RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, RenderHat.FACTORY);

	}

	public static void initSpawns() {
		EntityRegistry.addSpawn(Alicanto.class, 2, 1, 10, EnumCreatureType.MONSTER, ModBiomes.Iceika);
		EntityRegistry.addSpawn(Fractite.class, 2, 1, 10, EnumCreatureType.MONSTER, ModBiomes.Iceika);
		EntityRegistry.addSpawn(Glacide.class, 2, 1, 10, EnumCreatureType.MONSTER, ModBiomes.Iceika);
		EntityRegistry.addSpawn(Hastreus.class, 2, 1, 10, EnumCreatureType.MONSTER, ModBiomes.Iceika);
		EntityRegistry.addSpawn(FrostArcher.class, 2, 1, 10, EnumCreatureType.MONSTER, ModBiomes.Iceika);
		EntityRegistry.addSpawn(Frosty.class, 2, 1, 10, EnumCreatureType.MONSTER, ModBiomes.Iceika);
		EntityRegistry.addSpawn(Rollum.class, 2, 1, 10, EnumCreatureType.MONSTER, ModBiomes.Iceika);

		EntityRegistry.addSpawn(EdenTomo.class, 20, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Eden);
		EntityRegistry.addSpawn(EdenCadillion.class, 20, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Eden);
		EntityRegistry.addSpawn(Bunny.class, 20, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Eden);
		EntityRegistry.addSpawn(EdenTomo.class, 20, 4, 4, EnumCreatureType.CREATURE, ModBiomes.Eden);
		EntityRegistry.addSpawn(EdenCadillion.class, 20, 4, 4, EnumCreatureType.CREATURE, ModBiomes.Eden);
		EntityRegistry.addSpawn(Bunny.class, 20, 4, 4, EnumCreatureType.CREATURE, ModBiomes.Eden);
		EntityRegistry.addSpawn(EdenCori.class, 1, 4, 4, EnumCreatureType.CREATURE, ModBiomes.Eden);
		EntityRegistry.addSpawn(EdenCori.class, 1, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Eden);
		EntityRegistry.addSpawn(Greenfeet.class, 20, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Eden);
		EntityRegistry.addSpawn(Madivel.class, 20, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Eden);
		EntityRegistry.addSpawn(SunArcher.class, 6, 4, 4, EnumCreatureType.CREATURE, ModBiomes.Eden);
		EntityRegistry.addSpawn(SunArcher.class, 6, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Eden);

		EntityRegistry.addSpawn(WildwoodCadillion.class, 4, 4, 4, EnumCreatureType.MONSTER, ModBiomes.WildWood);
		EntityRegistry.addSpawn(WildwoodTomo.class, 4, 4, 4, EnumCreatureType.MONSTER, ModBiomes.WildWood);
		EntityRegistry.addSpawn(WildwoodCadillion.class, 4, 4, 4, EnumCreatureType.CREATURE, ModBiomes.WildWood);
		EntityRegistry.addSpawn(WildwoodTomo.class, 4, 4, 4, EnumCreatureType.CREATURE, ModBiomes.WildWood);
		EntityRegistry.addSpawn(Epiphite.class, 1, 2, 2, EnumCreatureType.MONSTER, ModBiomes.WildWood);
		EntityRegistry.addSpawn(Epiphite.class, 1, 2, 2, EnumCreatureType.CREATURE, ModBiomes.WildWood);
		EntityRegistry.addSpawn(Behemoth.class, 1, 1, 1, EnumCreatureType.MONSTER, ModBiomes.WildWood);
		EntityRegistry.addSpawn(Behemoth.class, 1, 1, 1, EnumCreatureType.CREATURE, ModBiomes.WildWood);
		EntityRegistry.addSpawn(WildwoodGolem.class, 3, 4, 4, EnumCreatureType.MONSTER, ModBiomes.WildWood);
		EntityRegistry.addSpawn(Verek.class, 4, 4, 4, EnumCreatureType.MONSTER, ModBiomes.WildWood);
		EntityRegistry.addSpawn(Mage.class, 2, 4, 4, EnumCreatureType.MONSTER, ModBiomes.WildWood);
		EntityRegistry.addSpawn(MoonWolf.class, 4, 4, 4, EnumCreatureType.CREATURE, ModBiomes.WildWood);

		EntityRegistry.addSpawn(ApalachiaCadillion.class, 2, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Apalachia);
		EntityRegistry.addSpawn(ApalachiaGolem.class, 2, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Apalachia);
		EntityRegistry.addSpawn(ApalachiaTomo.class, 2, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Apalachia);
		// EntityRegistry.addSpawn(ApalachiaWarrior.class, 2, 4, 4,
		// EnumCreatureType.monster, ModBiomes.Apalachia);
		// EntityRegistry.addSpawn(ApalachiaArcher.class, 2, 4, 4,
		// EnumCreatureType.monster, ModBiomes.Apalachia);
		// EntityRegistry.addSpawn(Spellbinder.class, 1, 4, 4, EnumCreatureType.MONSTER,
		// ModBiomes.Apalachia);

		EntityRegistry.addSpawn(SkythernFiend.class, 4, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Skythern);
		EntityRegistry.addSpawn(SkythernGolem.class, 4, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Skythern);
		EntityRegistry.addSpawn(SkythernArcher.class, 4, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Skythern);
		EntityRegistry.addSpawn(Samek.class, 4, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Skythern);
		EntityRegistry.addSpawn(SkythernCori.class, 1, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Skythern);
		EntityRegistry.addSpawn(Mystic.class, 2, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Skythern);
		EntityRegistry.addSpawn(Megalith.class, 1, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Skythern);

		EntityRegistry.addSpawn(MortumDemon.class, 2, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Mortum);
		EntityRegistry.addSpawn(Basilisk.class, 2, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Mortum);
		EntityRegistry.addSpawn(SoulStealer.class, 2, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Mortum);
		EntityRegistry.addSpawn(MortumCadillion.class, 2, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Mortum);
		EntityRegistry.addSpawn(TwilightArcher.class, 2, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Mortum);
		EntityRegistry.addSpawn(Sorcerer.class, 1, 4, 4, EnumCreatureType.MONSTER, ModBiomes.Mortum);

		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
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

			if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.END)) {
				EntityRegistry.addSpawn(EnderSpider.class, 2, 1, 4, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(EnderTriplets.class, 1, 1, 4, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(EnderWatcher.class, 10, 4, 4, EnumCreatureType.MONSTER, biome);
			} else if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.NETHER)) {
				// EntityRegistry.addSpawn(HellBat.class, 50, 1, 1, EnumCreatureType.MONSTER,
				// biome);
				EntityRegistry.addSpawn(HellPig.class, 25, 5, 50, EnumCreatureType.CREATURE, biome);
				EntityRegistry.addSpawn(HellSpider.class, 50, 1, 1, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(Scorcher.class, 7, 4, 4, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(Wildfire.class, 50, 1, 1, EnumCreatureType.MONSTER, biome);
			}
			if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.SNOWY)) {
				EntityRegistry.addSpawn(Glacon.class, 30, 1, 1, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(Glacon.class, 30, 1, 1, EnumCreatureType.CREATURE, biome);
				EntityRegistry.addSpawn(Frost.class, 50, 1, 4, EnumCreatureType.MONSTER, biome);
			}
			if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.SANDY)) {
				EntityRegistry.addSpawn(DesertCrawler.class, 50, 1, 4, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(AridWarrior.class, 35, 1, 4, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(SaguaroWorm.class, 20, 1, 4, EnumCreatureType.MONSTER, biome);
			}
			if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.BEACH)) {
				EntityRegistry.addSpawn(Crab.class, 100, 4, 4, EnumCreatureType.MONSTER, biome);
				EntityRegistry.addSpawn(KingCrab.class, 40, 4, 4, EnumCreatureType.MONSTER, biome);
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
				EntityRegistry.addSpawn(Cyclops.class, 10, 2, 4, EnumCreatureType.MONSTER, biome);
			}
			if (BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.FOREST)) {
				EntityRegistry.addSpawn(PumpkinSpider.class, 20, 1, 1, EnumCreatureType.MONSTER, biome);
			}
		}

		if (Config.debug) {
			DivineRPG.logger.info(Reference.MODID + " spawns have been loaded");
		}
	}

	public static void registerMobWithEgg(Class entityClass, String entityName) {
		entityName = Reference.MODID + "." + entityName;
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, entityName), entityClass, entityName,
		        mobID++, DivineRPG.instance, 128, 3, true, 0x00000, 0xff0000);
	}

	public static void registerProjectile(Class entityClass, String entityName) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, Reference.MODID + "." + entityName),
		        entityClass, Reference.MODID + entityName + "Projectile", projectileID, DivineRPG.instance, 250, 5,
		        true);
		projectileID++;
	}

	public void registerEgglessMob(Class entityClass, String entityName) {
		entityName = Reference.MODID + "." + entityName;
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, entityName), entityClass, entityName,
		        mobID++, DivineRPG.instance, 128, 3, true);
	}
}