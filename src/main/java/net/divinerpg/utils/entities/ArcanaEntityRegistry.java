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
import net.divinerpg.entities.arcana.EntityWarGeneral;
import net.divinerpg.entities.arcana.EntityWraith;
import net.divinerpg.entities.arcana.EntityZelus;
import net.divinerpg.entities.arcana.projectile.EntityAttractor;
import net.divinerpg.entities.arcana.projectile.EntityFirefly;
import net.divinerpg.entities.arcana.projectile.EntityFyracryxFireball;
import net.divinerpg.entities.arcana.projectile.EntityGrenade;
import net.divinerpg.entities.arcana.projectile.EntityLamona;
import net.divinerpg.entities.arcana.projectile.EntityLivingStatueArrow;
import net.divinerpg.entities.arcana.projectile.EntityMerikMissile;
import net.divinerpg.entities.arcana.projectile.EntityMeteor;
import net.divinerpg.entities.arcana.projectile.EntityReflector;
import net.divinerpg.entities.arcana.projectile.EntitySparkler;
import net.divinerpg.entities.arcana.projectile.EntityStar;
import net.divinerpg.utils.Util;

public class ArcanaEntityRegistry {

    public static void init() {
        Util.registerProjectile(EntityStar.class, "Star");
        Util.registerProjectile(EntitySparkler.class, "Sparkler");
        Util.registerProjectile(EntityFirefly.class, "Firefly");
        Util.registerProjectile(EntityFyracryxFireball.class, "FyracryxFireball");
        Util.registerProjectile(EntityGrenade.class, "Grenade");
        Util.registerProjectile(EntityLamona.class, "Lamona");
        Util.registerProjectile(EntityLivingStatueArrow.class, "LivingStatueArrow");
        Util.registerProjectile(EntityMerikMissile.class, "MeriksMissile");
        Util.registerProjectile(EntityMeteor.class, "MeteorMash");
        Util.registerProjectile(EntityAttractor.class, "Attractor");
        Util.registerProjectile(EntityReflector.class, "Reflector");

        Util.registerDivineRPGMob(EntityCaptianMerik.class, "CaptainMerik");
        Util.registerDivineRPGMob(EntityConstructor.class, "DungeonConstructor");
        Util.registerDivineRPGMob(EntityDatticon.class, "Datticon");
        Util.registerDivineRPGMob(EntityWarGeneral.class, "WarGeneral");
        Util.registerDivineRPGMob(EntityDeathcryx.class, "Deathcryx");
        Util.registerDivineRPGMob(EntityDeathHound.class, "DeathHound");
        Util.registerDivineRPGMob(EntityDramix.class, "Dramix");
        Util.registerDivineRPGMob(EntityDungeonPrisoner.class, "DungeonPrisoner");
        Util.registerDivineRPGMob(EntityDungeonDemon.class, "DungeonDemon");
        Util.registerDivineRPGMob(EntityLeorna.class, "Leorna");
        Util.registerDivineRPGMob(EntityLivingStatue.class, "LivingStatue");
        Util.registerDivineRPGMob(EntityParasecta.class, "Parasecta");
        Util.registerDivineRPGMob(EntityRazorback.class, "Razorback");
        Util.registerDivineRPGMob(EntityVatticus.class, "LordVatticus");
        Util.registerDivineRPGMob(EntityZelus.class, "Zelus");
        Util.registerDivineRPGMob(EntityRoamer.class, "Roamer");

        Util.registerEgglessMob(EntitySeimer.class, "Seimer");
        Util.registerEgglessMob(EntityParatiku.class, "Paratiku");
        Util.registerEgglessMob(EntityWraith.class, "Wraith");
        Util.registerEgglessMob(EntityFyracryx.class, "Fyracryx");
        Util.registerEgglessMob(EntityGolemOfRejuv.class, "GolemOfRejuv");
    }
}
