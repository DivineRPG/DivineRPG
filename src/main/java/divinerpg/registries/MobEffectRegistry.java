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
		HEAVY_AIR = EFFECTS.register("heavy_air", () -> new HeavyAirEffect()),
		GRUZZORLUG_TARGET = EFFECTS.register("gruzzorlug_target", () -> new GruzzorlugTargetEffect()),
		GROGLIN_BOUNTY = EFFECTS.register("groglin_bounty", () -> new GroglinBountyEffect()),
		FREEZE_REDUCTION = EFFECTS.register("freeze_reduction", () -> new FreezeReductionEffect()),
		WARMTH = EFFECTS.register("warmth", () -> new WarmthEffect());
	
	//Armor
	public static final RegistryObject<MobEffect>
		//Base
		BLOCK_PROTECTION = EFFECTS.register("block_protection", () -> new MarkerEffect()),
		EXPLOSION_PROTECTION = EFFECTS.register("explosion_protection", () -> new MarkerEffect()),
		MELEE_PROTECTION = EFFECTS.register("melee_protection", () -> new MarkerEffect()),
		POISON_PROTECTION = EFFECTS.register("poison_protection", () -> new PoisonProtectionEffect()),
		PREVENT_FALL_DAMAGE = EFFECTS.register("prevent_fall_damage", () -> new PreventFallDamageEffect()),
		PROJECTILE_PROTECTION = EFFECTS.register("projectile_protection", () -> new MarkerEffect()),
		STEP_ASSIST = EFFECTS.register("step_assist", () -> new StepAssistEffect()),
		WITHER_PROTECTION = EFFECTS.register("wither_protection", () -> new WitherProtectionEffect()),
		//Vanilla
		ANGELIC_FLIGHT = EFFECTS.register("angelic_flight", () -> new AngelicFlightEffect()),
		CORRUPTED_STRENGTH = EFFECTS.register("corrupted_strength", () -> new MarkerEffect()),
		DIVINE_STRENGTH = EFFECTS.register("divine_strength", () -> new MarkerEffect()),
		SKELEMAN_FEED = EFFECTS.register("skeleman_feed", () -> new SkelemanFeedEffect()),
		//Twilight
		AWAKENED_HALITE_STRENGTH = EFFECTS.register("awakened_halite_strength", () -> new MarkerEffect()),
		HALITE_STRENGTH = EFFECTS.register("halite_strength", () -> new MarkerEffect()),
		WILDWOOD_HEAL = EFFECTS.register("wildwood_heal", () -> new WildwoodHealEffect()),
		//Arcana
		KORMA_ARCANA = EFFECTS.register("korma_arcana", () -> new MarkerEffect()),
		VEMOS_HEAL = EFFECTS.register("vemos_heal", () -> new VemosHealEffect()),
		//Iceika
		FROZEN_SLOWNESS = EFFECTS.register("frozen_slowness", () -> new FrozenSlownessEffect()),
		SENG_FUR = EFFECTS.register("seng_fur", () -> new SengFurEffect()),
		//Vethea
		DEGRADED_HELMET = EFFECTS.register("degraded_helmet", () -> new MarkerEffect()),
		DEGRADED_HOOD = EFFECTS.register("degraded_hood", () -> new MarkerEffect()),
		DEGRADED_MASK = EFFECTS.register("degraded_mask", () -> new MarkerEffect()),
		DEMONIZED_HELMET = EFFECTS.register("demonized_helmet", () -> new MarkerEffect()),
		DEMONIZED_HOOD = EFFECTS.register("demonized_hood", () -> new MarkerEffect()),
		DEMONIZED_MASK = EFFECTS.register("demonized_mask", () -> new MarkerEffect()),
		FINISHED_HELMET = EFFECTS.register("finished_helmet", () -> new MarkerEffect()),
		FINISHED_HOOD = EFFECTS.register("finished_hood", () -> new MarkerEffect()),
		FINISHED_MASK = EFFECTS.register("finished_mask", () -> new MarkerEffect()),
		GLISTENING_HELMET = EFFECTS.register("glistening_helmet", () -> new MarkerEffect()),
		GLISTENING_HOOD = EFFECTS.register("glistening_hood", () -> new MarkerEffect()),
		GLISTENING_MASK = EFFECTS.register("glistening_mask", () -> new MarkerEffect()),
		TORMENTED_HELMET = EFFECTS.register("tormented_helmet", () -> new MarkerEffect()),
		TORMENTED_HOOD = EFFECTS.register("tormented_hood", () -> new MarkerEffect()),
		TORMENTED_MASK = EFFECTS.register("tormented_mask", () -> new MarkerEffect());
}