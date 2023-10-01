package divinerpg.world.feature.config;

import java.util.List;

import com.mojang.serialization.Codec;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class NBTFeatureConfig implements FeatureConfiguration {
	public static final Codec<NBTFeatureConfig> CODEC = Codec.list(ResourceLocation.CODEC).fieldOf("locations").xmap(NBTFeatureConfig::new, (config) -> {
		return config.locations;
	}).codec();
	public final List<ResourceLocation> locations;
	public NBTFeatureConfig(List<ResourceLocation> location) {
		this.locations = location;
	}
}