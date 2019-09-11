package divinerpg.objects.entities.entity.projectiles;

import divinerpg.objects.entities.assets.render.projectiles.RenderGrenade;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGrenade extends EntitySnowball {

	public EntityGrenade(World worldIn) {
		super(worldIn);
	}
	public EntityGrenade(World var1, EntityPlayer par3EntityPlayer) {
        super(var1, par3EntityPlayer);
    }
	@Override
	protected void onImpact(RayTraceResult result) {
	if (!this.world.isRemote) {
    	this.world.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, false);
        this.setDead();
    }
}

}

