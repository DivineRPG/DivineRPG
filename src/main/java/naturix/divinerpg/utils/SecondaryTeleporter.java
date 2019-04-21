package naturix.divinerpg.utils;

import net.minecraft.world.Teleporter;


import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class SecondaryTeleporter extends Teleporter {
    private final WorldServer worldServerInstance;

    private double x;
    private double y;
    private double z;


    public SecondaryTeleporter(WorldServer world, double x, double y, double z) {
        super(world);
        this.worldServerInstance = world;
        this.x = x;
        this.y = y;
        this.z = z;

    }

    @Override
    	public void placeInPortal(Entity pEntity, float rotationYaw)
        {
    	this.worldServerInstance.getBlockState(pEntity.getPosition());
        pEntity.setPosition(this.x, this.y, this.z);
        pEntity.motionX = 0.0f;
        pEntity.motionY = 0.0f;
        pEntity.motionZ = 0.0f;
    }

}