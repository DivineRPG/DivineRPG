package net.divinerpg.api.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class DivineBossStatus {
	
    public static float healthScale;
    public static int statusBarTime, bossNumber;
    public static String bossName;

    public static void setBossStatus(IDivineRPGBoss b, int boss) {
        healthScale = b.getHealth() / b.getMaxHealth();
        statusBarTime = 100;
        bossNumber = boss;
    }
}