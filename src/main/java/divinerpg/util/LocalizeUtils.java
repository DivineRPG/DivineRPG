package divinerpg.util;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.*;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

import static net.minecraft.ChatFormatting.*;

public class LocalizeUtils {
    private static final String
            Ammo = "ammo",
            ArcanaConsuming = "arcana",
            ArcanaDamage = "damage.arcana",
            ArcanaRegen = "arcana.regen",
            BaseDamage = "damage.base",
            BowFasterPull = "bow_speed.faster",
            BowSlowerPull = "bow_speed.slower",
            BurnMobs = "effect.burns",
            Cool = "cool",
            Efficiency = "tool.efficiency",
            HarvestLevel = "tool.harvest_level",
            HealthHeal = "heals",
            HealthRegen = "health.regen",
            HitEnder = "hit_ender",
            InfiniteAmmo = "ammo.infinite",
            Inflict = "inflict",
            InstantConsumption = "instant_consumption",
            LessDrag = "less_drag",
            LightningShot = "lightning_shot",
            MagicDamage = "damage.magic",
            OnUseDamage = "damage.use",
            Poison = "effect.poisons",
            Pull = "pull",
            Push = "push",
            RangedDamage = "damage.ranged",
            ReturnsToSender = "return",
            ShootingPower = "ranged.power",
            ShotsBlinding = "effect.blind",
            ShotsBouncing = "shots.bounce",
            ShotsBurning = "shots.burn",
            ShotsExplosive = "shots.explosive",
            ShotsHoming = "shots.homing",
            ShotsSky = "shots.sky",
            ShotsSplit = "shots.split",
            SlowMobs = "effect.slows",
            Summoned = "summon",
            SummonedDamage = "summon.damage",
            SummonedDespawn = "summon.despawn",
            SummonedHealth = "summon.health",
            TeleportAttached = "effect.teleport",
            WeakenedWithoutArcana = "weakened_without_arcana";
    /**
     * Indicates what ammunition is required.
     *
     * @param ammo - ammunition
     */
    public static Component ammo(TagKey<Item> ammo) {
        Component ammoName = MutableComponent.create(new TranslatableContents(Util.makeDescriptionId("tag", ammo.location()), null, new Object[0]));
        return i18n(WHITE, Ammo, ammoName);
    }
    /**
     * Indicates how much arcana is being consumed.
     *
     * @param arcana - arcana amount
     */
    public static Component arcanaConsumed(Object arcana) {return i18n(AQUA, ArcanaConsuming, arcana);}
    /**
     * Indicates how much damage the arcana deals.
     *
     * @param damage - arcana damage
     */
    public static Component arcanaDam(Object damage) {return i18n(DARK_AQUA, ArcanaDamage, damage);}
    /**
     * Indicates how much arcana is restored when used.
     *
     * @param arcana - arcana amount
     */
    public static Component arcanaRegen(int arcana) {return i18n(AQUA, ArcanaRegen, arcana);}
    /**
     * Indicates that the projectiles are bouncing.
     */
    public static Component bouncingShots() {return LocalizeUtils.i18n(GOLD, ShotsBouncing);}
    /**
     * Indicates how long the entity will burn.
     *
     * @param seconds - burning duration
     */
    public static Component burn(int seconds) {return i18n(DARK_RED, BurnMobs, seconds);}
    /**
     * Indicates that the weapon shoots flaming arrows.
     */
    public static Component burningShots() {return i18n(RED, ShotsBurning);}
    /**
     * Indicates the efficiency of the tools.
     *
     * @param eff - efficiency
     */
    public static Component efficiency(int eff) {return i18n(WHITE, Efficiency, eff);}
    /**
     * Indicates that the projectiles are explosive.
     */
    public static Component explosiveShots() {return LocalizeUtils.i18n(GOLD, ShotsExplosive);}
    /**
     * Creates message from server to translate on client.
     *
     * @param string - lang key
     */
    public static Component getClientSideTranslation(String string, final Object... argument) {return Component.translatable(string, argument);}
    /**
     * Indicates the harvest level of the tools.
     *
     * @param lvl - harvest level
     */
    public static Component harvestLevel(String lvl) {return i18n(WHITE, HarvestLevel, lvl);}
    /**
     * Indicates how much health is restored when used.
     */
    public static Component healthHeal(Object health) {return i18n(RED, HealthHeal, health);}
    /**
     * Indicates how much health is restored when used.
     */
    public static Component healthRegen(Object health) {return i18n(RED, HealthRegen, health);}
    /**
     * Indicates that the projectiles are homing.
     */
    public static Component homingShots() {return i18n(GOLD, ShotsHoming);}
    /**
     * Indicates that no ammo is required.
     */
    public static Component infiniteAmmo() {return i18n(BLUE, InfiniteAmmo);}
    /**
     * Header for what the weapon inflicts upon using it.
     */
    public static Component inflict() {return i18n(GRAY, Inflict);}
    /**
     * Indicates that the bowstring pull is faster than usual.
     *
     * @param speed - pull speed
     */
    public static Component bowFasterPull(float speed) {return i18n(DARK_GREEN, BowFasterPull, speed);}
    /**
     * Indicates that the bowstring pull is slower than usual.
     *
     * @param speed - pull speed
     */
    public static Component bowSlowerPull(float speed) {return i18n(RED, BowSlowerPull, speed);}
    /**
     * Indicates the speed of the shot projectiles.
     */
    public static Component shootingPower(float power) {return i18n(DARK_GREEN, ShootingPower, power);}
    /**
     * Indicates the base damage of the shot projectiles.
     */
    public static Component baseDamage(int damage) {return i18n(DARK_GREEN, BaseDamage, damage);}
    /**
     * Indicates that the item is consumed instantly.
     */
    public static Component instantConsumption() {return i18n(AQUA, InstantConsumption);}
    /**
     * Indicates that the weapon shoots lightning bolts when used.
     */
    public static Component lightningShots() {return i18n(YELLOW, LightningShot);}
    /**
     * Indicates how much damage the magic deals.
     *
     * @param damage - magic damage
     */
    public static Component magicDam(Object damage) {return i18n(DARK_PURPLE, MagicDamage, damage);}
    /**
     * Indicates how much damage the user takes.
     *
     * @param damage - on use damage
     */
    public static Component onUseDam(Object damage) {return i18n(RED, OnUseDamage, damage);}
    /**
     * Indicates how long the poison effect will last.
     *
     * @param seconds - effect duration
     */
    public static Component poison(int seconds) {return i18n(DARK_GREEN, Poison, seconds);}
    /**
     * Indicates that the item pulls mobs towards the player.
     */
    public static Component pull() {return i18n(Pull);}
    /**
     * Indicates that the item knocks mobs away.
     */
    public static Component push() {return i18n(Push);}
    /**
     * Indicates how much damage the non-arrow projectiles do.
     *
     * @param damage - damage amount
     */
    public static Component rangedDam(Object damage) {return i18n(DARK_GREEN, RangedDamage, damage);}
    /**
     * Indicates that the projectile returns back to the sender.
     */
    public static Component returnsToSender() {return i18n(ReturnsToSender);}
    /**
     * Indicates how long the slowness effect will last.
     *
     * @param seconds - effect duration
     */
    public static Component slow(int seconds) {return i18n(DARK_AQUA, SlowMobs, seconds);}
    /**
     * Indicates how long the weapon shoots blinding projectiles.
     *
     * @param seconds - effect duration
     */
    public static Component blind(int seconds) {return i18n(BLACK, ShotsBlinding, seconds);}
    /**
     * Indicates whether mobs get cooled.
     */
    public static Component cool() {return i18n(AQUA, Cool);}
    /**
     * Indicates that the object experiences less drag
     */
    public static Component lessDrag() {return i18n(DARK_GRAY, LessDrag);}
    /**
     * Indicates whether ender creatures can be hit.
     */
    public static Component hitEnder() {return i18n(DARK_PURPLE, HitEnder);}
    /**
     * Indicates that the weapon teleports the shooter to where the projectile hit.
     */
    public static Component teleportAttached() {return i18n(LIGHT_PURPLE, TeleportAttached);}
    /**
     * Indicates that the projectiles are splitting upon hitting something.
     */
    public static Component splitShots(int count) {return LocalizeUtils.i18n(GOLD, ShotsSplit, count);}
    /**
     * Indicates that the item shoots objects from the sky.
     *
     * @param count - amount of objects
     */
    public static Component skyShots(Object count) {return i18n(GOLD, ShotsSky, count);}
    /**
     * Specifies the summoned entity.
     *
     * @param entity - summoned entity
     */
    public static Component summoned(EntityType<?> entity) {
        Component name = MutableComponent.create(new TranslatableContents(entity.getDescriptionId(), null, new Object[0]));
        return i18n(Summoned, name);
    }
    /**
     * Specifies the damage of the summoned entity.
     *
     * @param damage - entity's damage
     */
    public static Component summonedDamage(int damage) {return i18n(DARK_GREEN, SummonedDamage, damage);}
    /**
     * Specifies that the summoned entity disappears after a while.
     */
    public static Component summonedDespawn() {return i18n(BLUE, SummonedDespawn);}
    /**
     * Specifies the health of the summoned entity.
     *
     * @param health - entity's health
     */
    public static Component summonedHealth(int health) {return i18n(RED, SummonedHealth, health);}
    /**
     * Indicates that the item is weakened without the arcana.
     */
    public static Component weakenedWithoutArcana() {return i18n(RED, WeakenedWithoutArcana);}
    /**
     * Returns translated text.
     * @param color - text color
     * @param text - lang key
     * @param args - string format arguments
     */
    public static Component i18n(ChatFormatting color, String text, Object... args) {
        if(args == null) {args = new Object[0];}
        MutableComponent result = MutableComponent.create(new TranslatableContents(String.format("tooltip.divinerpg.%s", text), null, args));
        return result.withStyle(color);
    }
    public static Component i18n(String text, Object... args) {
        if(args == null) {args = new Object[0];}
        MutableComponent result = MutableComponent.create(new TranslatableContents(String.format("tooltip.divinerpg.%s", text), null, args));
        return result.withStyle(GRAY);
    }
    public static Component clientMessage(ChatFormatting color, String text, Object... args) {
        if(args == null) {args = new Object[0];}
        MutableComponent result = MutableComponent.create(new TranslatableContents(String.format("message.divinerpg.%s", text), null, args));
        return result.withStyle(color);
    }
    public static Component clientMessage(String text, Object... args) {
        if(args == null) {args = new Object[0];}
        MutableComponent result = MutableComponent.create(new TranslatableContents(String.format("message.divinerpg.%s", text), null, args));
        return result.withStyle(WHITE);
    }
}