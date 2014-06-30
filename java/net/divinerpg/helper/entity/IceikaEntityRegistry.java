package net.divinerpg.helper.entity;

import net.divinerpg.entity.iceika.EntityAlicanto;
import net.divinerpg.entity.iceika.EntityFractite;
import net.divinerpg.entity.iceika.EntityFrostArcher;
import net.divinerpg.entity.iceika.EntityGlacide;
import net.divinerpg.entity.iceika.EntityHastreus;
import net.divinerpg.entity.iceika.EntityRollum;
import net.divinerpg.entity.iceika.EntityWorkshopMerchant;
import net.divinerpg.entity.iceika.EntityWorkshopTinkerer;
import net.divinerpg.entity.iceika.projectile.EntityCarol;
import net.divinerpg.entity.iceika.projectile.EntityFrostclaw;
import net.divinerpg.entity.iceika.projectile.EntityMusic;
import net.divinerpg.helper.Util;

public class IceikaEntityRegistry {

	public static void init() {
		Util.registerProjectile(EntityCarol.class, "Carol");
		Util.registerProjectile(EntityMusic.class, "Music");
		Util.registerProjectile(EntityFrostclaw.class, "Frostclaw");
		
		Util.registerDivineRPGMob(EntityAlicanto.class, "Alicanto", Util.mobID++);
		Util.registerDivineRPGMob(EntityFractite.class, "Fractite", Util.mobID++);
		Util.registerDivineRPGMob(EntityGlacide.class, "Glacide", Util.mobID++);
		Util.registerDivineRPGMob(EntityHastreus.class, "Hastreus", Util.mobID++);
		Util.registerDivineRPGMob(EntityFrostArcher.class, "Frost Archer", Util.mobID++);
        Util.registerDivineRPGMob(EntityRollum.class, "Rollum", Util.mobID++);
        Util.registerDivineRPGMob(EntityWorkshopTinkerer.class, "Workshop Tinkerer", Util.mobID++);
        Util.registerDivineRPGMob(EntityWorkshopMerchant.class, "Workshop Merchant", Util.mobID++);
	}
	
}
