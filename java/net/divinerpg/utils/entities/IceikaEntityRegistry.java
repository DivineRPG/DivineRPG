package net.divinerpg.utils.entities;

import net.divinerpg.entities.iceika.EntityAlicanto;
import net.divinerpg.entities.iceika.EntityFractite;
import net.divinerpg.entities.iceika.EntityFrostArcher;
import net.divinerpg.entities.iceika.EntityGlacide;
import net.divinerpg.entities.iceika.EntityHastreus;
import net.divinerpg.entities.iceika.EntityRollum;
import net.divinerpg.entities.iceika.EntityWorkshopMerchant;
import net.divinerpg.entities.iceika.EntityWorkshopTinkerer;
import net.divinerpg.entities.iceika.projectile.EntityCarol;
import net.divinerpg.entities.iceika.projectile.EntityFrostclaw;
import net.divinerpg.entities.iceika.projectile.EntityMusic;
import net.divinerpg.utils.Util;

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
