package divinerpg.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class NBTFeatureConfig implements FeatureConfiguration {
	public static final Codec<NBTFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(ResourceLocation.CODEC.fieldOf("location").forGetter((config) -> {
	           return config.location;
        })).apply(instance, NBTFeatureConfig::new);
	});
	public final ResourceLocation location;
	public NBTFeatureConfig(ResourceLocation location) {
		this.location = location;
	}
}