package divinerpg.util;


public final class EntityStats {
	private EntityStats(){}
	public static final double normalHealth = 20D, normalDamage = 5D, normalSpeed = .27000000417232513, normalFollowRange = 20D;

	public static final double //Boss
			ancientEntityHealth 	= 800D, ancientEntityDamage = 12D,
			ayeracoHealth 			= 600D,
			densosHealth 			= 1000D, densosDamage = 30D,
			dramixHealth 			= 1400D, dramixDamage = 30D,
			eternalArcherHealth 	= 1550D, eternalArcherDamage = 12D,
			experiencedCoriHealth	= 1150D, experiencedCoriDamage = 26D,
			hiveQueenHealth 		= 1500D, hiveQueenDamage = 60D,
			karosHealth 			= 4000D, karosDamage = 20D,
			karotHealth 			= 1250D, karotDamage = 32D,
			kingOfScorchersHealth 	= 1100D, kingOfScorchersDamage = 22D,
			ladyLunaHealth 			= 8000D, ladyLunaDamage = 20D,
			parasectaHealth 		= 1000D, parasectaDamage = 22D,
			quadroHealth 			= 4000D, quadroDamage = 12D, quadroSpeedFast = .5, quadroSpeedSlow = .25,
			raglokHealth 			= 5000D, raglokDamage = 30D,
			reyvorHealth 			= 1000D, reyvorDamage = 28D,
			soulFiendHealth 		= 1100D, soulFiendDamage = 26D,
			sunstormHealth 	    	= 1000D, sunstormDamage = 18D,
			termasectHealth			= 1050D, termasectDamage = 20D,
			theWatcherHealth 		= 950D, theWatcherDamage = 12D,
			twilightDemonHealth 	= 1600D, twilightDemonDamage = 30D,
			vamacheronHealth 		= 1350D, vamacheronDamage = 34D, vamacheronSpeed = normalSpeed * 1.5,
			wreckHealth 			= 5000D, wreckDamage = 30D;

	public static final double //Overworld
			aequoreaHealth         	= 4D, aequoreaDamage = 3D, aequoreaSpeed = normalSpeed / 2D, aequoreaFollowRange = normalFollowRange / 4D,
			aridWarriorHealth 		= 40D, aridWarriorDamage = 8D,
			enthralledDramcryxHealth= 80D, enthralledDramcryxDamage = 7D,
			caveclopsHealth 		= 60D, caveclopsDamage = 6D,
			caveCrawlerHealth 		= 30D, caveCrawlerDamage = 4D,
			crabHealth 				= 45D, crabDamage = 6D,
			cyclopsHealth 			= 35D,
			desertCrawlerHealth 	= 40D, desertCrawlerDamage = 6D,
			frostHealth 			= 50D, frostDamage = 6D,
			glaconHealth 			= 60D, glaconDamage = 7D, glaconSpeed = normalSpeed * 1.6,
			jungleDramcryxHealth 	= 40D, jungleDramcryxDamage = 7D,
			jungleBatHealth 		= 20D, jungleBatDamage = 5D,
			jungleSpiderHealth		= 45D, jungleSpiderDamage = 7D,
			rainbourHealth 			= 100D, rainbourDamage = 18D,
			kingCrabHealth 			= 100D, kingCrabDamage = 9D,
			minerHealth 			= 40D, minerArmor = 10D,
			rotatickHealth 			= 40D, rotatickDamage = 6D,
			sharkHealth 			= 80D, sharkDamage = 8D,
			theEyeHealth 			= 40D, theEyeDamage = 10D,
			whaleHealth 			= 120D, whaleDamage = 10D,
			liopleurodonHealth     	= 150D, liopleurodonDamage = 13D,
			kobblinHealth 		    = 35D, kobblinDamage = 7D,
			theGrueHealth 			= 30D, theGrueDamage = 10D, theGrueSpeed = normalSpeed * 1.3,
			saguaroWormHealth 		= 80D, saguaroWormDamage = 4D, saguaroWormSpeed = 0,
			pumpkinSpiderHealth 	= 50D, pumpkinSpiderDamage = 7D,

	ehuHealth 				= 60D,
			huskHealth 				= 80D, huskDamage = 10D,
			stoneGolemHealth 		= 100D,
			smelterHealth 			= 120D, smelterDamage = 7D,
			grizzleHealth          	= 100D, grizzleDamage = 9D, grizzleSpeed = normalSpeed * 1.3,
			snapperHealth          	= 150D, snapperDamage = 4D, snapperSpeed = normalSpeed / 1.4;

	public static final double //Nether
			hellBatHealth 		    = 30D, hellBatDamage = 7D, hellBatFollowRange = normalFollowRange * 2D,
			hellPigHealth	 		= 50D, hellPigTamedHealth = 20D,
			hellSpiderHealth 		= 50D, hellSpiderDamage = 8D,
			scorcherHealth 			= 75D,
			wildFireHealth 			= 50D, wildFireDamage = 8D;

	public static final double //End
			enderSpiderHealth 		= 35D, enderSpiderDamage = 12D,
			enderTripletsHealth 	= 10D,
			enderWatcherHealth 		= 50D, enderWatcherDamage = 11D;

	public static final double //Iceika
			alicantoHealth 			= 75D, alicantoDamage = 11D,
			fractiteHealth 			= 50D,
			frostArcherHealth 		= 40D, frostArcherDamage = 2D,
			glacideHealth 			= 80D, glacideDamage = 12D, glacideSpeed = normalSpeed * 1.7,
			hastreusHealth 			= 120D, hastreusDamage = 16D,
			rollumHealth 			= 150D, rollumDamage = 12D, rollumSpeed = normalSpeed / 1.2,
			frostyHealth			= 140D, frostyDamage = 16D, frostySpeed = normalSpeed / 1.6,
			groglinHealth			= 40D,  groglinDamage = 5D, groglinSpeed = normalSpeed / 1.1,
			gruzzorlugHealth		= 60D,  gruzzorlugDamage = 3D, gruzzorlugSpeed = normalSpeed / 1.3,


	sengHealth				= 55D, sengSpeed = normalSpeed * 1.3, sengRange = normalFollowRange / 2,
			modVillagerHealth 		= 1000D;

	public static final double //Eden
			glinthopHealth 			= 10D, glinthopDamage = 12D,
			edenTomoHealth 			= 96D, edenTomoDamage = 16D,
			edenCadillionHealth 	= 120D, edenCadillionDamage = 18D,
			greenfeetHealth 		= 200D, greenfeetDamage = 22D,
			madivelHealth 			= 150D, madivelDamage = 20D,
			sunArcherHealth        	= 72D, sunArcherDamage = 15D,
			weakCoriHealth 			= 10D, weakCoriDamage = 30D;

	public static final double //Wildwood
			behemothHealth         	= 180D, behemothDamage = 16D,
			epiphiteHealth 			= 100D, epiphiteDamage = 16D,
			mageHealth             	= 90D, mageDamage = 12D,
			moonWolfHealth 			= 130D, moonWolfDamage = 12D,
			moonWolfTamedHealth 	= 160D, moonWolfTamedDamage = 12D,
			termidHealth           	= 50D, termidDamage = 12D,
			verekHealth 			= 78D, verekDamage = 18D,
			wildwoodCadillionHealth	= 130D, wildwoodCadillionDamage = 20D,
			wildwoodGolemHealth 	= 200D, wildwoodGolemDamage = 23D,
			wildwoodTomoHealth 		= 110D, wildwoodTomoDamage = 18D;

	public static final double //Apalachia
			apalachiaCadillionHealth= 145D, apalachiaCadillionDamage = 22D,
			apalachiaGolemHealth 	= 200D, apalachiaGolemDamage = 24D,
			apalachiaTomoHealth 	= 116D, apalachiaTomoDamage = 20D,
			enchantedArcherHealth 	= 87D,
			enchantedWarriorHealth 	= 87D, enchantedWarriorDamage = 22D,
			spellbinderHealth      	= 100D, spellbinderDamage = 14D;

	public static final double //Skythern
			advancedCoriHealth 		= 35D, advancedCoriDamage = 100D,
			megalithHealth         	= 310D, megalithDamage = 25D, megalithSpeed = normalSpeed * .9, megalithKnockbackResistance = 1D,
			mysticHealth           	= 120D, mysticDamage = 12D,
			samekHealth 			= 160D, samekDamage = 23D,
			skythernArcherHealth 	= 124D,
			skythernFiendHealth 	= 155D, skythernFiendDamage = 24D,
			skythernGolemHealth 	= 248D, skythernGolemDamage = 25D;

	public static final double //Mortum
			angryGlinthopHealth 	= 96D, angryGlinthopDamage = 23D,
			basliskHealth 			= 300D, basliskDamage = 23D,
			demonOfDarknessHealth 	= 200D, demonOfDarknessDamage = 24D,
			mortumCadillionHealth 	= 165D, mortumCadillionDamage = 26D,
			sorcererHealth         	= 132D, sorcererDamage = 14D,
			soulSpiderHealth 		= 64D, soulSpiderDamage = 21D,
			soulStealerHealth 		= 140D, soulStealerDamage = 26D,
			twilightArcherHealth 	= 96D;

	public static final double //Arcana
			paratikuHealth 			= 100D,
			seimerHealth 			= 150D,
			vermsillionHealth 		= 30D,
			razorbackHealth 		= 35D, razorbackDamage = 9D,
			skyreHealth 			= 35D, skyreDamage = 8D, skyreFollowRange = 16D,
			livingStatueHealth 		= 60D,
			golemRejuvHealth 		= 30D, golemRejuvDamage = 2D,
			fyracryxHealth 			= 60D, fyracryxDamage = 5D,
			dungeonPrisonerHealth 	= 85D, dungeonPrisonerDamage = 17D,
			deathHoundHealth 		= 120D, deathHoundDamage = 12D,
			deathcryxHealth 		= 160D, deathcryxDamage = 14D,
			constructorHealth 		= 100D, constructorDamage = 19D,
			roamerHealth 			= 110D, roamerDamage = 20D;

	public static final double //Vethea
			cryptKeeperHealth 		= 200D, cryptKeeperMovementSpeed = .32, cryptKeeperFollowRange = 35D,
			bohemiteHealth 			= 60D, bohemiteDamage = 13D, bohemiteSpeed = normalSpeed * 1.5,
			biphronHealth 			= 40D, biphronDamage = 14D,
			acidHagHealth 			= 25D,
			cymesoidHealth 			= 25D, cymesoidDamage = 8D,
			galroidHealth 			= 100D, galroidDamage = 25D,
			entHealth 				= 50D, entDamage = 20D,
			dissimentHealth 		= 70D, //Others empty
			dreamwreckerHealth 		= 60D, dreamwreckerDamage = 8D,
			duoHealth 				= 20D, duoDamage = 7D, duoSpeed = normalSpeed / 1.5,
			gorgosionHealth 		= 60D,
			helioHealth 			= 140D, helioDamage = 40D,
			herbomancerHealth 		= 40D,
			herbomancerMinionHealth = 10D,
			hiveSoldierHealth 		= 20D, hiveSoldierDamage = 6D,
			hoverStingerHealth 		= 20D, hoverStingerDamage = 4D, hoverStingerMovementSpeed = .32D, hoverStingerFollowRange = 35D,
			kazroticHealth 			= 65D, kazroticDamage = 1,
			lheivaHealth 			= 85D, lheivaDamage = 22D,
			lorgaHealth 			= 15D, lorgaDamage = 4D,
			lorgaFlightHealth 		= 40D, lorgaFlightDamage = 8D,
			mandragoraHealth 		= 35D,
			mysteriousManSpeed		= .32, mysteriousManFollowRange = 35D,
			shadahierHealth 		= 10D, shadahierDamage = 7D,
			tocaxinHealth 			= 65D, tocaxinDamage = 13D,
			twinsHealth 			= 10D,
			vermenousHealth 		= 100D, vermenousDamage = 14D,
			vhraakHealth 			= 100D, vhraakDamage = 30D,
			zoneHealth 				= 120D,
			zoragonHealth 			= 110D, zoragonDamage = 0D, zoragonSpeed = normalSpeed / 3;
}