package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraftforge.registries.DeferredRegister;

public final class NoiseRegistry {
	private NoiseRegistry() {}
	public static final DeferredRegister<NormalNoise.NoiseParameters> NOISE = DeferredRegister.create(Registry.NOISE_REGISTRY, DivineRPG.MODID);
}