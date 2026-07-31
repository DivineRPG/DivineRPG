package divinerpg.registries;

import divinerpg.effect.mob.*;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MobEffectRegistry {
    public static final DeferredHolder<MobEffect, MobEffect>
            //Base
//            STEP_ASSIST = DivineRegistries.MOB_EFFECTS.register("step_assist", StepAssistEffect::new),
//            PREVENT_FALL_DAMAGE = DivineRegistries.MOB_EFFECTS.register("prevent_fall_damage", PreventFallDamageEffect::new),
//            MELEE_PROTECTION = DivineRegistries.MOB_EFFECTS.register("melee_protection", () -> new MarkerEffect(7364182)),
//            PROJECTILE_PROTECTION = DivineRegistries.MOB_EFFECTS.register("projectile_protection", () -> new MarkerEffect(3817554)),
//            BLOCK_PROTECTION = DivineRegistries.MOB_EFFECTS.register("block_protection", () -> new MarkerEffect(6592562)),
//            EXPLOSION_PROTECTION = DivineRegistries.MOB_EFFECTS.register("explosion_protection", () -> new MarkerEffect(8461597)),
//            POISON_PROTECTION = DivineRegistries.MOB_EFFECTS.register("poison_protection", PoisonProtectionEffect::new),
//            WITHER_PROTECTION = DivineRegistries.MOB_EFFECTS.register("wither_protection", WitherProtectionEffect::new),

    //Vanilla
//    SKELEMAN_FEED = DivineRegistries.MOB_EFFECTS.register("skeleman_feed", SkelemanFeedEffect::new),
//            CORRUPTED_STRENGTH = DivineRegistries.MOB_EFFECTS.register("corrupted_strength", () -> new MarkerEffect(5593834)),
//            DIVINE_STRENGTH = DivineRegistries.MOB_EFFECTS.register("divine_strength", () -> new MarkerEffect(16506215)),
//            ANGELIC_FLIGHT = DivineRegistries.MOB_EFFECTS.register("angelic_flight", AngelicFlightEffect::new),

    //Iceika
    GROGLIN_BOUNTY = DivineRegistries.MOB_EFFECTS.register("groglin_bounty", GroglinBountyEffect::new),
            GRUZZORLUG_TARGET = DivineRegistries.MOB_EFFECTS.register("gruzzorlug_target", GruzzorlugTargetEffect::new),
            FREEZE_REDUCTION = DivineRegistries.MOB_EFFECTS.register("freeze_reduction", FreezeReductionEffect::new),
            WARMTH = DivineRegistries.MOB_EFFECTS.register("warmth", WarmthEffect::new),
    //Armor
//    FROZEN_SLOWNESS = DivineRegistries.MOB_EFFECTS.register("frozen_slowness", FrozenSlownessEffect::new),
//            SENG_FUR_STRENGTH = DivineRegistries.MOB_EFFECTS.register("seng_fur", SengFurEffect::new),

    //End
    ENDER_ATTACHMENT = DivineRegistries.MOB_EFFECTS.register("ender_attachment", EnderAttachmentEffect::new),

    //Arcana
//    KORMA_ARCANA = DivineRegistries.MOB_EFFECTS.register("korma_arcana", () -> new MarkerEffect(10289142)),
//            VEMOS_HEAL = DivineRegistries.MOB_EFFECTS.register("vemos_heal", VemosHealEffect::new),

    //Twilight
//    WILDWOOD_HEAL = DivineRegistries.MOB_EFFECTS.register("wildwood_heal", WildwoodHealEffect::new),
//            HALITE_STRENGTH = DivineRegistries.MOB_EFFECTS.register("halite_strength", () -> new MarkerEffect(6471301)),
//            AWAKENED_HALITE_STRENGTH = DivineRegistries.MOB_EFFECTS.register("awakened_halite_strength", () -> new MarkerEffect(4451564)),

    //Vethea
    HEAVY_AIR = DivineRegistries.MOB_EFFECTS.register("heavy_air", HeavyAirEffect::new)
//    ,
    //Armor
//    DEGRADED_HELMET = DivineRegistries.MOB_EFFECTS.register("degraded_helmet", () -> new MarkerEffect(3342336)),
//            DEGRADED_HOOD = DivineRegistries.MOB_EFFECTS.register("degraded_hood", () -> new MarkerEffect(3342336)),
//            DEGRADED_MASK = DivineRegistries.MOB_EFFECTS.register("degraded_mask", () -> new MarkerEffect(3342336)),
//            FINISHED_HELMET = DivineRegistries.MOB_EFFECTS.register("finished_helmet", () -> new MarkerEffect(4456448)),
//            FINISHED_HOOD = DivineRegistries.MOB_EFFECTS.register("finished_hood", () -> new MarkerEffect(4456448)),
//            FINISHED_MASK = DivineRegistries.MOB_EFFECTS.register("finished_mask", () -> new MarkerEffect(4456448)),
//            GLISTENING_HELMET = DivineRegistries.MOB_EFFECTS.register("glistening_helmet", () -> new MarkerEffect(5570560)),
//            GLISTENING_HOOD = DivineRegistries.MOB_EFFECTS.register("glistening_hood", () -> new MarkerEffect(5570560)),
//            GLISTENING_MASK = DivineRegistries.MOB_EFFECTS.register("glistening_mask", () -> new MarkerEffect(5570560)),
//            DEMONIZED_HELMET = DivineRegistries.MOB_EFFECTS.register("demonized_helmet", () -> new MarkerEffect(6684672)),
//            DEMONIZED_HOOD = DivineRegistries.MOB_EFFECTS.register("demonized_hood", () -> new MarkerEffect(6684672)),
//            DEMONIZED_MASK = DivineRegistries.MOB_EFFECTS.register("demonized_mask", () -> new MarkerEffect(6684672)),
//            TORMENTED_HELMET = DivineRegistries.MOB_EFFECTS.register("tormented_helmet", () -> new MarkerEffect(7798784)),
//            TORMENTED_HOOD = DivineRegistries.MOB_EFFECTS.register("tormented_hood", () -> new MarkerEffect(7798784)),
//            TORMENTED_MASK = DivineRegistries.MOB_EFFECTS.register("tormented_mask", () -> new MarkerEffect(7798784))
            ;
    public static void load() {}
}
