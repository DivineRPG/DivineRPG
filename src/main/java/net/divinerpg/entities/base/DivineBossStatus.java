package net.divinerpg.entities.base;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class DivineBossStatus {
	
	public static float healthScale;
    public static int statusBarTime, bossNumber;
    public static String bossName;

    public static void setBossStatus(EntityDivineRPGBoss b, int boss) {
    	// Make sure that the rendered Boss is real. (Fixes glitch caused by bosses rendered in NEI spawners).
        if (b.posX != 0 || b.posY != 0 || b.posZ != 0) {
        	healthScale = b.getHealth() / b.getMaxHealth();
            statusBarTime = 100;
            bossNumber = boss;
        }
    }
}