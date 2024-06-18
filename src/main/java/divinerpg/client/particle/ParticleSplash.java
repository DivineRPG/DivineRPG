package divinerpg.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;

public class ParticleSplash extends SimpleAnimatedParticle {
	public ParticleSplash(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet set) {
		super(world, x, y, z, set, 1F);
		this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
		setColor(world.getBiome(new BlockPos((int)x, (int)y, (int)z)).value().getWaterColor());
		lifetime = 20 + random.nextInt(40);
	}
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprites;
        public Provider(SpriteSet spriteSet) {
            sprites = spriteSet;
        }
        public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticleSplash particle = new ParticleSplash(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, sprites);
            particle.pickSprite(this.sprites);
            return particle;
        }
	}
}