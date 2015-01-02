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
import net.divinerpg.entities.iceika.projectile.EntityMusic;
import net.divinerpg.entities.iceika.projectile.EntitySnowflakeShuriken;
import net.divinerpg.utils.Util;

public class IceikaEntityRegistry {

	public static void init() {
		Util.registerProjectile(EntityCarol.class, "divinerpg.Carol");
		Util.registerProjectile(EntityMusic.class, "divinerpg.Music");
		Util.registerProjectile(EntitySnowflakeShuriken.class, "divinerpg.SnowflakeShuriken");
		Util.registerProjectile(EntityFractiteShot.class, "divinerpg.FractiteShot");
		
		Util.registerDivineRPGMob(EntityAlicanto.class, "divinerpg.Alicanto");
		Util.registerDivineRPGMob(EntityFractite.class, "divinerpg.Fractite");
		Util.registerDivineRPGMob(EntityGlacide.class, "divinerpg.Glacide");
		Util.registerDivineRPGMob(EntityHastreus.class, "divinerpg.Hastreus");
		Util.registerDivineRPGMob(EntityFrostArcher.class, "divinerpg.FrostArcher");
        Util.registerDivineRPGMob(EntityRollum.class, "divinerpg.Rollum");
        Util.registerDivineRPGMob(EntityFrosty.class, "divinerpg.Frosty");
        Util.registerDivineRPGMob(EntityWorkshopTinkerer.class, "divinerpg.WorkshopTinkerer");
        Util.registerDivineRPGMob(EntityWorkshopMerchant.class, "divinerpg.WorkshopMerchant");
	}
	
}
