package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.*;

public class PotionRegistry {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, DivineRPG.MODID);
    public static final RegistryObject<Potion>
    	TEA = POTIONS.register("tea", () -> new Potion(new MobEffectInstance(MobEffectRegistry.FREEZE_REDUCTION.get(), 1))),
    	WARMTH = POTIONS.register("warmth", () -> new Potion(new MobEffectInstance(MobEffectRegistry.WARMTH.get(), 1800))),
    	LONG_WARMTH = POTIONS.register("long_warmth", () -> new Potion(new MobEffectInstance(MobEffectRegistry.WARMTH.get(), 2500))),
    	GROG = POTIONS.register("grog", () -> new Potion(new MobEffectInstance(MobEffects.CONFUSION, 250)));
}