package divinerpg.client.particle.options;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.particles.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

import java.util.Locale;

public class ParticleColouredType extends ParticleType<ParticleColouredType.ParticleColour> {
    @SuppressWarnings("unchecked")
	public static final Codec<ParticleColour> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("particle_type").forGetter(data -> BuiltInRegistries.PARTICLE_TYPE.getKey(data.particleType).toString()),
            Codec.INT.fieldOf("red0").forGetter(data -> data.red),
            Codec.INT.fieldOf("green0").forGetter(data -> data.green),
            Codec.INT.fieldOf("blue0").forGetter(data -> data.blue)
    ).apply(instance, (type, red, green, blue) -> new ParticleColour((ParticleType<ParticleColour>) BuiltInRegistries.PARTICLE_TYPE.get(ResourceLocation.withDefaultNamespace(type)), red, green, blue)));

    public ParticleColouredType(boolean alwaysShow) {
        super(alwaysShow, ParticleColour.DESERIALIZER);
    }

    @Override
    public Codec<ParticleColour> codec() {
        return CODEC;
    }

    public static class ParticleColour implements ParticleOptions {

        @SuppressWarnings("deprecation")
		public static final Deserializer<ParticleColour> DESERIALIZER = new Deserializer<ParticleColour>() {
            public ParticleColour fromCommand(ParticleType<ParticleColour> particleType, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                int red = reader.readInt();
                reader.expect(' ');
                int green = reader.readInt();
                reader.expect(' ');
                int blue = reader.readInt();
                reader.expect(' ');

                return new ParticleColour(particleType, red, green, blue);
            }

            public ParticleColour fromNetwork(ParticleType<ParticleColour> particleType, FriendlyByteBuf buffer) {
                return new ParticleColour(particleType, buffer.readInt(), buffer.readInt(), buffer.readInt());
            }
        };

        private final ParticleType<ParticleColour> particleType;
        private final int red;
        private final int green;
        private final int blue;

        public ParticleColour(ParticleType<ParticleColour> particleType, int red, int green, int blue) {
            this.particleType = particleType;
            this.red = red;
            this.green = green;
            this.blue = blue;
        }


        @Override
        public String writeToString() {
            return String.format(Locale.ROOT, "%s Colour: %d %d %d", BuiltInRegistries.PARTICLE_TYPE.getKey(getType()), red, green, blue);
        }

        @Override
        public void writeToNetwork(FriendlyByteBuf buffer) {
            buffer.writeInt(red);
            buffer.writeInt(green);
            buffer.writeInt(blue);
        }

        @Override
        public ParticleType<?> getType() {
            return particleType;
        }

        @OnlyIn(Dist.CLIENT)
        public int getRed() {
            return red;
        }

        @OnlyIn(Dist.CLIENT)
        public int getGreen() {
            return green;
        }

        @OnlyIn(Dist.CLIENT)
        public int getBlue() {
            return blue;
        }

    }
}