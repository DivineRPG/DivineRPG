package net.divinerpg.helper.entity;

import net.divinerpg.entity.arcana.EntityCaptianMerik;
import net.divinerpg.entity.arcana.EntityConstructor;
import net.divinerpg.entity.arcana.EntityDatticon;
import net.divinerpg.entity.arcana.EntityDeathHound;
import net.divinerpg.entity.arcana.EntityDeathcryx;
import net.divinerpg.entity.arcana.EntityDramix;
import net.divinerpg.entity.arcana.EntityDungeonDemon;
import net.divinerpg.entity.arcana.EntityDungeonPrisoner;
import net.divinerpg.entity.arcana.EntityFyracryx;
import net.divinerpg.entity.arcana.EntityGolemOfRejuv;
import net.divinerpg.entity.arcana.EntityLeorna;
import net.divinerpg.entity.arcana.EntityLivingStatue;
import net.divinerpg.entity.arcana.EntityParasecta;
import net.divinerpg.entity.arcana.EntityParatiku;
import net.divinerpg.entity.arcana.EntityRazorback;
import net.divinerpg.entity.arcana.EntityRoamer;
import net.divinerpg.entity.arcana.EntitySeimer;
import net.divinerpg.entity.arcana.EntityVatticus;
import net.divinerpg.entity.arcana.EntityVermsillion;
import net.divinerpg.entity.arcana.EntityWraith;
import net.divinerpg.entity.arcana.EntityZelus;
import net.divinerpg.entity.arcana.projectile.EntityFirefly;
import net.divinerpg.entity.arcana.projectile.EntityFyracryxFireball;
import net.divinerpg.entity.arcana.projectile.EntityGrenade;
import net.divinerpg.entity.arcana.projectile.EntityLamona;
import net.divinerpg.entity.arcana.projectile.EntityLivingStatueArrow;
import net.divinerpg.entity.arcana.projectile.EntityMerikMissile;
import net.divinerpg.entity.arcana.projectile.EntityReflector;
import net.divinerpg.entity.arcana.projectile.EntitySparkler;
import net.divinerpg.entity.arcana.projectile.EntityStar;
import net.divinerpg.helper.Util;

public class ArcanaEntityRegistry {

	public static void init(){
		Util.registerProjectile(EntityStar.class, "Star");
		Util.registerProjectile(EntitySparkler.class, "Sparkler");
		Util.registerProjectile(EntityFirefly.class, "Firefly");
		Util.registerProjectile(EntityFyracryxFireball.class, "Fyracryx fireball");
		Util.registerProjectile(EntityGrenade.class, "Grenade");
		Util.registerProjectile(EntityLamona.class, "Lamona");
		Util.registerProjectile(EntityLivingStatueArrow.class, "Living statue arrow");
		Util.registerProjectile(EntityMerikMissile.class, "Meriks Missile");
		Util.registerProjectile(EntityReflector.class, "Reflector");

		Util.registerDivineRPGMob(EntityCaptianMerik.class, "Captain Merik", Util.mobID++);
		Util.registerDivineRPGMob(EntityConstructor.class, "Dungeon Constructor", Util.mobID++);
		Util.registerDivineRPGMob(EntityDatticon.class, "Datticon", Util.mobID++);
		Util.registerDivineRPGMob(EntityDeathcryx.class, "Deathcryx", Util.mobID++);
		Util.registerDivineRPGMob(EntityDeathHound.class, "Death Hound", Util.mobID++);
		Util.registerDivineRPGMob(EntityDramix.class, "Dramix", Util.mobID++);
		Util.registerDivineRPGMob(EntityDungeonPrisoner.class, "Dungeon Prisoner", Util.mobID++);
		Util.registerDivineRPGMob(EntityDungeonDemon.class, "Dungeon Demon", Util.mobID++);
		Util.registerDivineRPGMob(EntityFyracryx.class, "Fyracryx", Util.mobID++);
		Util.registerDivineRPGMob(EntityGolemOfRejuv.class, "Golem Of Rejuv'", Util.mobID++);
		Util.registerDivineRPGMob(EntityLeorna.class, "Leorna", Util.mobID++);
		Util.registerDivineRPGMob(EntityLivingStatue.class, "Living Statue", Util.mobID++);
		Util.registerDivineRPGMob(EntityParasecta.class, "Parasecta", Util.mobID++);
		Util.registerDivineRPGMob(EntityRazorback.class, "Razorback", Util.mobID++);
		Util.registerDivineRPGMob(EntitySeimer.class, "Seimer", Util.mobID++);
		Util.registerDivineRPGMob(EntityVatticus.class, "Lord Vatticus", Util.mobID++);
		//Util.registerDivineRPGMob(EntityVermsillion.class, "Vermsillion", Util.mobID++);
		Util.registerDivineRPGMob(EntityParatiku.class, "Paratiku", Util.mobID++);
		Util.registerDivineRPGMob(EntityWraith.class, "Wraith", Util.mobID++);
		Util.registerDivineRPGMob(EntityZelus.class, "Zelus", Util.mobID++);
		Util.registerDivineRPGMob(EntityRoamer.class, "Roamer", Util.mobID++);
	}
}