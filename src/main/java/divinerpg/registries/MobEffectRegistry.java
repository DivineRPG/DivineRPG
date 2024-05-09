package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.effect.mob.*;
import divinerpg.effect.mob.armor.arcana.*;
import divinerpg.effect.mob.armor.base.*;
import divinerpg.effect.mob.armor.iceika.*;
import divinerpg.effect.mob.armor.twilight.*;
import divinerpg.effect.mob.armor.vanilla.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.*;

public class MobEffectRegistry {
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DivineRPG.MODID);
	
	public static final RegistryObject<MobEffect>
		HEAVY_AIR = EFFECTS.register("heavy_air", HeavyAirEffect::new),
		GRUZZORLUG_TARGET = EFFECTS.register("gruzzorlug_target", GruzzorlugTargetEffect::new),
		GROGLIN_BOUNTY = EFFECTS.register("groglin_bounty", GroglinBountyEffect::new),
		FREEZE_REDUCTION = EFFECTS.register("freeze_reduction", FreezeReductionEffect::new),
		WARMTH = EFFECTS.register("warmth", WarmthEffect::new);
	
	//Armor
	public static final RegistryObject<MobEffect>
		//Base
		BLOCK_PROTECTION = EFFECTS.register("block_protection", MarkerEffect::new),
		EXPLOSION_PROTECTION = EFFECTS.register("explosion_protection", MarkerEffect::new),
		MELEE_PROTECTION = EFFECTS.register("melee_protection", MarkerEffect::new),
		POISON_PROTECTION = EFFECTS.register("poison_protection", PoisonProtectionEffect::new),
		PREVENT_FALL_DAMAGE = EFFECTS.register("prevent_fall_damage", PreventFallDamageEffect::new),
		PROJECTILE_PROTECTION = EFFECTS.register("projectile_protection", MarkerEffect::new),
		STEP_ASSIST = EFFECTS.register("step_assist", StepAssistEffect::new),
		WITHER_PROTECTION = EFFECTS.register("wither_protection", WitherProtectionEffect::new),
		//Vanilla
		ANGELIC_FLIGHT = EFFECTS.register("angelic_flight", AngelicFlightEffect::new),
		CORRUPTED_STRENGTH = EFFECTS.register("corrupted_strength", MarkerEffect::new),
		DIVINE_STRENGTH = EFFECTS.register("divine_strength", MarkerEffect::new),
		SKELEMAN_FEED = EFFECTS.register("skeleman_feed", SkelemanFeedEffect::new),
		//Twilight
		AWAKENED_HALITE_STRENGTH = EFFECTS.register("awakened_halite_strength", MarkerEffect::new),
		HALITE_STRENGTH = EFFECTS.register("halite_strength", MarkerEffect::new),
		WILDWOOD_HEAL = EFFECTS.register("wildwood_heal", WildwoodHealEffect::new),

		//Arcana
		KORMA_ARCANA = EFFECTS.register("korma_arcana", MarkerEffect::new),
		VEMOS_HEAL = EFFECTS.register("vemos_heal", VemosHealEffect::new),

		//Iceika
		FROZEN_SLOWNESS = EFFECTS.register("frozen_slowness", FrozenSlownessEffect::new),
		SENG_FUR = EFFECTS.register("seng_fur", SengFurEffect::new),

		//Vethea
		DEGRADED_HELMET = EFFECTS.register("degraded_helmet", MarkerEffect::new),
		DEGRADED_HOOD = EFFECTS.register("degraded_hood", MarkerEffect::new),
		DEGRADED_MASK = EFFECTS.register("degraded_mask", MarkerEffect::new),
		DEMONIZED_HELMET = EFFECTS.register("demonized_helmet", MarkerEffect::new),
		DEMONIZED_HOOD = EFFECTS.register("demonized_hood", MarkerEffect::new),
		DEMONIZED_MASK = EFFECTS.register("demonized_mask", MarkerEffect::new),
		FINISHED_HELMET = EFFECTS.register("finished_helmet", MarkerEffect::new),
		FINISHED_HOOD = EFFECTS.register("finished_hood", MarkerEffect::new),
		FINISHED_MASK = EFFECTS.register("finished_mask", MarkerEffect::new),
		GLISTENING_HELMET = EFFECTS.register("glistening_helmet", MarkerEffect::new),
		GLISTENING_HOOD = EFFECTS.register("glistening_hood", MarkerEffect::new),
		GLISTENING_MASK = EFFECTS.register("glistening_mask", MarkerEffect::new),
		TORMENTED_HELMET = EFFECTS.register("tormented_helmet", MarkerEffect::new),
		TORMENTED_HOOD = EFFECTS.register("tormented_hood", MarkerEffect::new),
		TORMENTED_MASK = EFFECTS.register("tormented_mask", MarkerEffect::new);
}