package divinerpg.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.*;
import net.minecraft.client.multiplayer.ClientLevel;

@OnlyIn(Dist.CLIENT)
public class ParticleTar extends TextureSheetParticle {
    SpriteSet sprites;
    protected ParticleTar(ClientLevel level, double xCoord, double yCoord, double zCoord, double xd, double yd, double zd, SpriteSet sprite) {
        super(level, xCoord, yCoord, zCoord);
        this.xd *= xd * .2 + (Math.random() * 2 - 1) * .02;
        this.yd *= yd * .1 + (Math.random() * 2 - 1) * .01;
        this.zd *= zd * .2 + (Math.random() * 2 - 1) * .02;
        quadSize *= random.nextFloat() * .6 + .2;
        lifetime = (int)(16 / (Math.random() * .8 + .2));
        sprites = sprite;
    }
    @Override public void tick() {
        xo = x;
        yo = y;
        zo = z;
        if(lifetime-- <= 0) remove();
        else {
          yd += .002;
          move(xd, yd, zd);
          xd *= .85;
          yd *= .85;
          zd *= .85;
        }
    }
    @Override public ParticleRenderType getRenderType() {return ParticleRenderType.PARTICLE_SHEET_OPAQUE;}
    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public Provider(SpriteSet spriteSet) {sprites = spriteSet;}
        @Override public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticleTar particle = new ParticleTar(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, sprites);
            particle.pickSprite(sprites);
            return particle;
        }
    }
}