package divinerpg.attachments.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public class ArcanaData {
    public static final Codec<ArcanaData> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.FLOAT.fieldOf("value").forGetter(ArcanaData::getValue), Codec.FLOAT.fieldOf("max").forGetter(ArcanaData::getMaxValue)).apply(instance, ArcanaData::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ArcanaData> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.FLOAT, ArcanaData::getValue, ByteBufCodecs.FLOAT, ArcanaData::getMaxValue, ArcanaData::new);
    private float value;
    private float max;

    public ArcanaData(float value, float max) {
        this.value = value;
        this.max = max;
    }

    public Float getValue() {
        return this.value;
    }

    public Float getMaxValue() {
        return this.max;
    }

    public Float setValue(float value) {
        return this.value = value;
    }

    public Float setMaxValue(float max) {
        return this.max = max;
    }
}