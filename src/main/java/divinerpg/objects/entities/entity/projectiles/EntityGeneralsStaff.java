package divinerpg.objects.entities.entity.projectiles;

import divinerpg.enums.BulletType;
import divinerpg.objects.entities.assets.render.projectiles.RenderStaff;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGeneralsStaff extends EntityParticleBullet {

	public EntityGeneralsStaff(World world) {
		super(world);
	}

	public EntityGeneralsStaff(World world, EntityPlayer player) {
		super(world, player, BulletType.APALACHIA_BLITZ_SHOT);
	}

	@SideOnly(Side.CLIENT)
	public static void renderMe() {
		RenderingRegistry.registerEntityRenderingHandler(EntityGeneralsStaff.class, RenderStaff::new);
	}

	@Override
	public void onImpact(RayTraceResult position) {
		super.onImpact(position);
		if (!this.world.isRemote) {
			for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 2) {
				EntityParticleBullet e = new EntityParticleBullet(this.world, this.thrower, this.getBulletType());
				setHere(e);
				e.shoot(Math.cos(theta), 0.4, Math.sin(theta), 0.7f, 0);
				this.world.spawnEntity(e);
			}

			EntityParticleBullet e = new EntityParticleBullet(this.world, this.thrower, this.getBulletType());
			setHere(e);
			e.shoot(0, 1, 0, 0.7f, 0);
			this.world.spawnEntity(e);
		}
	}

	private void setHere(Entity e) {
		e.setPosition(this.posX, this.posY, this.posZ);
	}
}