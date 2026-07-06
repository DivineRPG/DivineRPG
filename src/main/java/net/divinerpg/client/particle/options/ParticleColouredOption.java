package net.divinerpg.client.particle.options;

import com.mojang.serialization.MapCodec;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ARGB;
import net.minecraft.util.ExtraCodecs;

public class ParticleColouredOption implements ParticleOptions {
    private final ParticleType<ParticleColouredOption> type;
    private final int color;

    public static MapCodec<ParticleColouredOption> codec(ParticleType<ParticleColouredOption> particleType) {
        return ExtraCodecs.ARGB_COLOR_CODEC.xmap(color -> new ParticleColouredOption(particleType, color), option -> option.color).fieldOf("color");
    }

    public static StreamCodec<? super ByteBuf, ParticleColouredOption> streamCodec(ParticleType<ParticleColouredOption> particleType) {
        return ByteBufCodecs.INT.map(color -> new ParticleColouredOption(particleType, color), option -> option.color);
    }

    public ParticleColouredOption(ParticleType<ParticleColouredOption> type, int color) {
        this.type = type;
        this.color = color;
    }

    @Override
    public ParticleType<ParticleColouredOption> getType() {
        return this.type;
    }

    public float getRed() {
        return (float) ARGB.red(this.color) / 255.0F;
    }

    public float getGreen() {
        return (float) ARGB.green(this.color) / 255.0F;
    }

    public float getBlue() {
        return (float) ARGB.blue(this.color) / 255.0F;
    }

    public float getAlpha() {
        return (float) ARGB.alpha(this.color) / 255.0F;
    }

    public static ParticleColouredOption create(ParticleType<ParticleColouredOption> type, int color) {
        return new ParticleColouredOption(type, color);
    }

    public static ParticleColouredOption create(ParticleType<ParticleColouredOption> type, float red, float green, float blue) {
        return create(type, ARGB.colorFromFloat(1.0F, red, green, blue));
    }

}