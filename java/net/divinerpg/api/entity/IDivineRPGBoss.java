package net.divinerpg.api.entity;

import net.minecraft.util.IChatComponent;

public interface IDivineRPGBoss {

	float getHealth();
	
	float getMaxHealth();
	public abstract String name();
	IChatComponent chat();
}