package divinerpg.client.particle;

import divinerpg.DivineRPG;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.*;

import java.awt.*;

@OnlyIn(Dist.CLIENT)
public class ParticleSpawner {

    public void spawnParticle(ClientWorld w, double x, double y, double z, String particle, boolean random) {
        this.spawnParticle(w, x, y, z, particle, random);
    }
    public void spawnColoredParticle(ClientWorld world, double x, double y, double z, Color color, boolean bigger,
                                     boolean shortLived) {
            Minecraft.getInstance().particles.addEffect(new ParticleColored(world, x, y, z, 0, 0, 0, color, bigger, shortLived));
    }
    public static void spawnParticle(ClientWorld world, ParticleType particletype, double x, double y, double z, double velX,
                                     double velY, double velZ) {
            Particle particle = null;

            switch (particletype) {
                case NONE:
                    break;
                case APALACHIA_PORTAL:
//                    particle = new ParticleApalachiaPortal(world, x, y, z, velX, velY, velZ);
                    break;
                case EDEN_PORTAL:
//                    particle = new ParticleEdenPortal(world, x, y, z, velX, velY, velZ);
                    break;
                case MORTUM_PORTAL:
//                    particle = new ParticleMortumPortal(world, x, y, z, velX, velY, velZ);
                    break;
                case SKYTHERN_PORTAL:
//                    particle = new ParticleSkythernPortal(world, x, y, z, velX, velY, velZ);
                    break;
                case WILDWOOD_PORTAL:
//                    particle = new ParticleWildwoodPortal(world, x, y, z, velX, velY, velZ);
                    break;
                case GREEN_PORTAL:
//                    particle = new ParticleGreenPortal(world, x, y, z, velX, velY, velZ);
                    break;
                case BLACK_FLAME:
//                    particle = new ParticleColoredFlame(world, x, y, z, velX, velY, velZ, 0, 0, 0);
                    break;
                case BLUE_FLAME:
//                    particle = new ParticleColoredFlame(world, x, y, z, velX, velY, velZ, 0.3f, 0.7f, 1);
                    break;
                case GREEN_FLAME:
//                    particle = new ParticleColoredFlame(world, x, y, z, velX, velY, velZ, 0, 1, 0);
                    break;
                case PURPLE_FLAME:
//                    particle = new ParticleColoredFlame(world, x, y, z, velX, velY, velZ, 1, 0, 1);
                    break;
                case FROST:
//                    particle = new ParticleFrost(world, x, y, z, velX, velY, velZ);
                    break;
                case SPARKLER:
                    particle = new ParticleSparkler(world, x, y, z, velX, velY, velZ);
                    break;
                case ENDER_TRIPLET:
//                    particle = new ParticleEnderTriplet(world, x, y, z, velX, velY, velZ);
                    break;
            }

            if (particle != null) {
                Minecraft.getInstance().particles.addEffect(particle);
            }
    }

}
