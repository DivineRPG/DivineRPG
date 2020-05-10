package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityLamona extends EntityThrowable {
	
	public EntityLamona(World var1) {
		super(var1);
	}

	public EntityLamona(World var1, EntityLivingBase var2) {
		super(var1, var2);
	}

	public EntityLamona(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		addLight();
	}

	@Override
	protected void onImpact(RayTraceResult var1) {
		if(!this.world.isRemote) {
			this.setDead();
			
		}
	}
	
	private void addLight() {
    	this.world.setLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 15);
        this.world.markBlockRangeForRenderUpdate((int)this.posX, (int)this.posY, (int)this.posX, 12, 12, 12);
//        this.world.markBlockForUpdate(new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ);
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX, (int)this.posY +1, (int)this.posZ));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX +1, (int)this.posY +1, (int)this.posZ));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX +1, (int)this.posY +1, (int)this.posZ +1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX +1, (int)this.posY +1, (int)this.posZ -1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX -1, (int)this.posY +1, (int)this.posZ +1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX -1, (int)this.posY +1, (int)this.posZ -1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX -1, (int)this.posY +1, (int)this.posZ));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX, (int)this.posY +1, (int)this.posZ +1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX, (int)this.posY +1, (int)this.posZ -1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX, (int)this.posY -1, (int)this.posZ));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX +1, (int)this.posY -1, (int)this.posZ));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX +1, (int)this.posY -1, (int)this.posZ +1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX +1, (int)this.posY -1, (int)this.posZ -1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX -1, (int)this.posY -1, (int)this.posZ +1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX -1, (int)this.posY -1, (int)this.posZ -1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX -1, (int)this.posY -1, (int)this.posZ));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX, (int)this.posY -1, (int)this.posZ +1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX, (int)this.posY -1, (int)this.posZ -1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX +1, (int)this.posY, (int)this.posZ));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX +1, (int)this.posY, (int)this.posZ +1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX +1, (int)this.posY, (int)this.posZ -1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX -1, (int)this.posY, (int)this.posZ +1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX -1, (int)this.posY, (int)this.posZ -1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX -1, (int)this.posY, (int)this.posZ));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ +1));
        this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ -1));
    }
}