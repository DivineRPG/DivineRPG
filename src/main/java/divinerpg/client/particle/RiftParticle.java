package divinerpg.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RiftParticle extends TextureSheetParticle {
    final Vec3 origin;
    protected RiftParticle(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z);
        origin = new Vec3(x, y, z);
        Vec3 v = new Vec3(Math.random() - .5, Math.random() - .5, Math.random() - .5).normalize();
        setParticleSpeed(v.x, v.y, v.z);
        lifetime = 60;
    }
    @Override public void tick() {
        super.tick();
        Vec3 dv;
        if(age == 50) setParticleSpeed(0D, 0D, 0D);
        else if(age > 50) {
            dv = origin.subtract(x, y, z).scale(0.4);
            move(dv.x, dv.y, dv.z);
        } else {
            Vec3 dist = origin.subtract(x, y, z);
            dv = new Vec3(xd * .5, yd * .5, zd * .5).add(dist.cross(new Vec3(0D, -1D, 0D)).normalize()).add(dist.scale(0.5));
            setParticleSpeed(dv.x, dv.y, dv.z);
        }
    }
    @Override public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }
    public static TextureSheetParticle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
        return new RiftParticle(world, xCoordIn, yCoordIn, zCoordIn);
    }
}