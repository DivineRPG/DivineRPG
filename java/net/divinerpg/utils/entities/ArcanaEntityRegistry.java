package net.divinerpg.utils.entities;

import net.divinerpg.entities.arcana.EntityCaptianMerik;
import net.divinerpg.entities.arcana.EntityConstructor;
import net.divinerpg.entities.arcana.EntityDatticon;
import net.divinerpg.entities.arcana.EntityDeathHound;
import net.divinerpg.entities.arcana.EntityDeathcryx;
import net.divinerpg.entities.arcana.EntityDramix;
import net.divinerpg.entities.arcana.EntityDungeonDemon;
import net.divinerpg.entities.arcana.EntityDungeonPrisoner;
import net.divinerpg.entities.arcana.EntityFyracryx;
import net.divinerpg.entities.arcana.EntityGolemOfRejuv;
import net.divinerpg.entities.arcana.EntityLeorna;
import net.divinerpg.entities.arcana.EntityLivingStatue;
import net.divinerpg.entities.arcana.EntityParasecta;
import net.divinerpg.entities.arcana.EntityParatiku;
import net.divinerpg.entities.arcana.EntityRazorback;
import net.divinerpg.entities.arcana.EntityRoamer;
import net.divinerpg.entities.arcana.EntitySeimer;
import net.divinerpg.entities.arcana.EntityVatticus;
import net.divinerpg.entities.arcana.EntityWraith;
import net.divinerpg.entities.arcana.EntityZelus;
import net.divinerpg.entities.arcana.projectile.EntityFirefly;
import net.divinerpg.entities.arcana.projectile.EntityFyracryxFireball;
import net.divinerpg.entities.arcana.projectile.EntityGrenade;
import net.divinerpg.entities.arcana.projectile.EntityLamona;
import net.divinerpg.entities.arcana.projectile.EntityLivingStatueArrow;
import net.divinerpg.entities.arcana.projectile.EntityMerikMissile;
import net.divinerpg.entities.arcana.projectile.EntitySparkler;
import net.divinerpg.entities.arcana.projectile.EntityStar;
import net.divinerpg.utils.Util;

public class ArcanaEntityRegistry {

	public static void init(){
		Util.registerProjectile(EntityStar.class, "divinerpg.Star");
		Util.registerProjectile(EntitySparkler.class, "divinerpg.Sparkler");
		Util.registerProjectile(EntityFirefly.class, "divinerpg.Firefly");
		Util.registerProjectile(EntityFyracryxFireball.class, "divinerpg.FyracryxFireball");
		Util.registerProjectile(EntityGrenade.class, "divinerpg.Grenade");
		Util.registerProjectile(EntityLamona.class, "divinerpg.Lamona");
		Util.registerProjectile(EntityLivingStatueArrow.class, "divinerpg.LivingStatueArrow");
		Util.registerProjectile(EntityMerikMissile.class, "divinerpg.MeriksMissile");

		Util.registerDivineRPGMob(EntityCaptianMerik.class, "divinerpg.CaptainMerik");
		Util.registerDivineRPGMob(EntityConstructor.class, "divinerpg.DungeonConstructor");
		Util.registerDivineRPGMob(EntityDatticon.class, "divinerpg.Datticon");
		Util.registerDivineRPGMob(EntityDeathcryx.class, "divinerpg.Deathcryx");
		Util.registerDivineRPGMob(EntityDeathHound.class, "divinerpg.DeathHound");
		Util.registerDivineRPGMob(EntityDramix.class, "divinerpg.Dramix");
		Util.registerDivineRPGMob(EntityDungeonPrisoner.class, "divinerpg.DungeonPrisoner");
		Util.registerDivineRPGMob(EntityDungeonDemon.class, "divinerpg.DungeonDemon");
		Util.registerDivineRPGMob(EntityFyracryx.class, "divinerpg.Fyracryx");
		Util.registerDivineRPGMob(EntityGolemOfRejuv.class, "divinerpg.GolemOfRejuv");
		Util.registerDivineRPGMob(EntityLeorna.class, "divinerpg.Leorna");
		Util.registerDivineRPGMob(EntityLivingStatue.class, "divinerpg.LivingStatue");
		Util.registerDivineRPGMob(EntityParasecta.class, "divinerpg.Parasecta");
		Util.registerDivineRPGMob(EntityRazorback.class, "divinerpg.Razorback");
		Util.registerDivineRPGMob(EntitySeimer.class, "divinerpg.Seimer");
		Util.registerDivineRPGMob(EntityVatticus.class, "divinerpg.LordVatticus");
		//Util.registerDivineRPGMob(EntityVermsillion.class, "divinerpg.Vermsillion", Util.mobID++);
		Util.registerDivineRPGMob(EntityParatiku.class, "divinerpg.Paratiku");
		Util.registerDivineRPGMob(EntityWraith.class, "divinerpg.Wraith");
		Util.registerDivineRPGMob(EntityZelus.class, "divinerpg.Zelus");
		Util.registerDivineRPGMob(EntityRoamer.class, "divinerpg.Roamer");
	}
}