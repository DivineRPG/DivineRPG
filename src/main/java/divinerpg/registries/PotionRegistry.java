package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PotionRegistry {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, DivineRPG.MODID);
    public static final DeferredHolder<Potion, Potion>
    	TEA = POTIONS.register("tea", () -> new Potion(new MobEffectInstance(MobEffectRegistry.FREEZE_REDUCTION, 1))),
    	WARMTH = POTIONS.register("warmth", () -> new Potion(new MobEffectInstance(MobEffectRegistry.WARMTH, 1800))),
    	LONG_WARMTH = POTIONS.register("long_warmth", () -> new Potion(new MobEffectInstance(MobEffectRegistry.WARMTH, 2500))),
    	GROG = POTIONS.register("grog", () -> new Potion(new MobEffectInstance(MobEffects.CONFUSION, 250)));
}