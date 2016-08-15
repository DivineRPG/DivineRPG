package net.divinerpg.utils.entities;

import net.divinerpg.entities.iceika.EntityAlicanto;
import net.divinerpg.entities.iceika.EntityFractite;
import net.divinerpg.entities.iceika.EntityFrostArcher;
import net.divinerpg.entities.iceika.EntityFrosty;
import net.divinerpg.entities.iceika.EntityGlacide;
import net.divinerpg.entities.iceika.EntityHastreus;
import net.divinerpg.entities.iceika.EntityRollum;
import net.divinerpg.entities.iceika.EntityWorkshopMerchant;
import net.divinerpg.entities.iceika.EntityWorkshopTinkerer;
import net.divinerpg.entities.iceika.projectile.EntityCarol;
import net.divinerpg.entities.iceika.projectile.EntityFractiteShot;
import net.divinerpg.entities.iceika.projectile.EntitySerenadeOfIce;
import net.divinerpg.entities.iceika.projectile.EntityMusic;
import net.divinerpg.entities.iceika.projectile.EntitySnowflakeShuriken;
import net.divinerpg.utils.Util;

public class IceikaEntityRegistry {

	public static void init() {
		Util.registerProjectile(EntityCarol.class, "Carol");
		Util.registerProjectile(EntityMusic.class, "Music");
		Util.registerProjectile(EntitySnowflakeShuriken.class, "SnowflakeShuriken");
		Util.registerProjectile(EntityFractiteShot.class, "FractiteShot");
		Util.registerProjectile(EntitySerenadeOfIce.class, "Ice");
		
		Util.registerDivineRPGMob(EntityAlicanto.class, "Alicanto");
		Util.registerDivineRPGMob(EntityFractite.class, "Fractite");
		Util.registerDivineRPGMob(EntityGlacide.class, "Glacide");
		Util.registerDivineRPGMob(EntityHastreus.class, "Hastreus");
		Util.registerDivineRPGMob(EntityFrostArcher.class, "FrostArcher");
        Util.registerDivineRPGMob(EntityRollum.class, "Rollum");
        Util.registerDivineRPGMob(EntityFrosty.class, "Frosty");
        Util.registerDivineRPGMob(EntityWorkshopTinkerer.class, "WorkshopTinkerer");
        Util.registerDivineRPGMob(EntityWorkshopMerchant.class, "WorkshopMerchant");
	}
	
}
