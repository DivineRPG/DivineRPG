package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.effect.mob.HeavyAirEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.*;

public class MobEffectRegistry {
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DivineRPG.MODID);
	
	public static final RegistryObject<MobEffect> HEAVY_AIR = EFFECTS.register("heavy_air", () -> new HeavyAirEffect());
}