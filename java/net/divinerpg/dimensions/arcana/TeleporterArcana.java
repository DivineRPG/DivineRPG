package net.divinerpg.dimensions.arcana;

import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.events.ArcanaHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class TeleporterArcana extends Teleporter {
	
	protected WorldServer myWorld;

	public TeleporterArcana(WorldServer var1) {
		super(var1);
		this.myWorld = var1;
	}

	@Override
	public boolean placeInExistingPortal(Entity entity, double notUsed_entityX, double notUsed_entityY, double notUsed_entityZ, float notUsed_entityRotation) {
        ArcanaHelper props = ArcanaHelper.getProperties((EntityPlayer)entity);
	    if (entity.dimension == ConfigurationHelper.arcana) {        
            props.setReturnPortalX(entity.posX);
            props.setReturnPortalY(entity.posY);
            props.setReturnPortalZ(entity.posZ);
            entity.setLocationAndAngles(7.5D, 9.5D, 7.5D, entity.rotationYaw, 0.0F);
	    } else {
            entity.setLocationAndAngles(props.getReturnPortalX(), props.getReturnPortalY(), props.getReturnPortalZ(), entity.rotationYaw, 0.0F);
	    }
        entity.motionX = entity.motionY = entity.motionZ = 0.0D;            
        return true;
	}

	@Override
	public boolean makePortal(Entity entity) {
	    return false;
	}
}
	
