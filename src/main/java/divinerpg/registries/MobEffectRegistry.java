package divinerpg.registries;

import divinerpg.effect.mob.*;
import divinerpg.effect.mob.armor.arcana.VemosHealEffect;
import divinerpg.effect.mob.armor.base.*;
import divinerpg.effect.mob.armor.iceika.*;
import divinerpg.effect.mob.armor.twilight.WildwoodHealEffect;
import divinerpg.effect.mob.armor.vanilla.*;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.*;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.core.registries.BuiltInRegistries.MOB_EFFECT;

public class MobEffectRegistry {
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(MOB_EFFECT, MODID);
	public static final DeferredHolder<MobEffect, MobEffect>
		//Base
		STEP_ASSIST = EFFECTS.register("step_assist", StepAssistEffect::new),
		PREVENT_FALL_DAMAGE = EFFECTS.register("prevent_fall_damage", PreventFallDamageEffect::new),
		MELEE_PROTECTION = EFFECTS.register("melee_protection", () -> new MarkerEffect(7364182)),
		PROJECTILE_PROTECTION = EFFECTS.register("projectile_protection", () -> new MarkerEffect(3817554)),
		BLOCK_PROTECTION = EFFECTS.register("block_protection", () -> new MarkerEffect(6592562)),
		EXPLOSION_PROTECTION = EFFECTS.register("explosion_protection", () -> new MarkerEffect(8461597)),
		POISON_PROTECTION = EFFECTS.register("poison_protection", PoisonProtectionEffect::new),
		WITHER_PROTECTION = EFFECTS.register("wither_protection", WitherProtectionEffect::new),

		//Vanilla
		SKELEMAN_FEED = EFFECTS.register("skeleman_feed", SkelemanFeedEffect::new),
		CORRUPTED_STRENGTH = EFFECTS.register("corrupted_strength", () -> new MarkerEffect(5593834)),
		DIVINE_STRENGTH = EFFECTS.register("divine_strength", () -> new MarkerEffect(16506215)),
		ANGELIC_FLIGHT = EFFECTS.register("angelic_flight", AngelicFlightEffect::new),

		//Iceika
		GROGLIN_BOUNTY = EFFECTS.register("groglin_bounty", GroglinBountyEffect::new),
		GRUZZORLUG_TARGET = EFFECTS.register("gruzzorlug_target", GruzzorlugTargetEffect::new),
		FREEZE_REDUCTION = EFFECTS.register("freeze_reduction", FreezeReductionEffect::new),
		WARMTH = EFFECTS.register("warmth", WarmthEffect::new),
		//Armor
		FROZEN_SLOWNESS = EFFECTS.register("frozen_slowness", FrozenSlownessEffect::new),
		SENG_FUR_STRENGTH = EFFECTS.register("seng_fur", SengFurEffect::new),

		//End
		ENDER_ATTACHMENT = EFFECTS.register("ender_attachment", EnderAttachmentEffect::new),

		//Arcana
		KORMA_ARCANA = EFFECTS.register("korma_arcana", () -> new MarkerEffect(10289142)),
		VEMOS_HEAL = EFFECTS.register("vemos_heal", VemosHealEffect::new),

		//Twilight
		WILDWOOD_HEAL = EFFECTS.register("wildwood_heal", WildwoodHealEffect::new),
		HALITE_STRENGTH = EFFECTS.register("halite_strength", () -> new MarkerEffect(6471301)),
		AWAKENED_HALITE_STRENGTH = EFFECTS.register("awakened_halite_strength", () -> new MarkerEffect(4451564)),

		//Vethea
		HEAVY_AIR = EFFECTS.register("heavy_air", HeavyAirEffect::new),
		//Armor
		DEGRADED_HELMET = EFFECTS.register("degraded_helmet", () -> new MarkerEffect(3342336)),
		DEGRADED_HOOD = EFFECTS.register("degraded_hood", () -> new MarkerEffect(3342336)),
		DEGRADED_MASK = EFFECTS.register("degraded_mask", () -> new MarkerEffect(3342336)),
		FINISHED_HELMET = EFFECTS.register("finished_helmet", () -> new MarkerEffect(4456448)),
		FINISHED_HOOD = EFFECTS.register("finished_hood", () -> new MarkerEffect(4456448)),
		FINISHED_MASK = EFFECTS.register("finished_mask", () -> new MarkerEffect(4456448)),
		GLISTENING_HELMET = EFFECTS.register("glistening_helmet", () -> new MarkerEffect(5570560)),
		GLISTENING_HOOD = EFFECTS.register("glistening_hood", () -> new MarkerEffect(5570560)),
		GLISTENING_MASK = EFFECTS.register("glistening_mask", () -> new MarkerEffect(5570560)),
		DEMONIZED_HELMET = EFFECTS.register("demonized_helmet", () -> new MarkerEffect(6684672)),
		DEMONIZED_HOOD = EFFECTS.register("demonized_hood", () -> new MarkerEffect(6684672)),
		DEMONIZED_MASK = EFFECTS.register("demonized_mask", () -> new MarkerEffect(6684672)),
		TORMENTED_HELMET = EFFECTS.register("tormented_helmet", () -> new MarkerEffect(7798784)),
		TORMENTED_HOOD = EFFECTS.register("tormented_hood", () -> new MarkerEffect(7798784)),
		TORMENTED_MASK = EFFECTS.register("tormented_mask", () -> new MarkerEffect(7798784));
}