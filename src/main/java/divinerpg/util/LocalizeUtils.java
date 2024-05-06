package divinerpg.util;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.network.chat.*;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.server.command.TextComponentHelper;

public class LocalizeUtils {
    private static final String
            Ammo = "tooltip.ammo",
            ArcanaConsuming = "tooltip.arcana",
            ArcanaDamage = "tooltip.damage.arcana",
            ArcanaRegen = "tooltip.arcana.regen",
            BurnMobs = "tooltip.effect.burns",
            Efficiency = "tooltip.efficiency",
            HarvestLevel = "tooltip.harvest_level",
            HealthRegen = "tooltip.heals",
            InfiniteAmmo = "tooltip.ammo.infinite",
            InstantConsumption = "tooltip.instant_consumption",
            LightningShot = "tooltip.lightning_shot",
            MagicDamage = "tooltip.damage.magic",
            OnUseDamage = "tooltip.damage.use",
            Poison = "tooltip.effect.poisons",
            Pull = "tooltip.pull",
            Push = "tooltip.push",
            RangedDamage = "tooltip.damage.ranged",
            ReturnsToSender = "tooltip.return",
            ShotsBouncing = "tooltip.shots.bounce",
            ShotsExplosive = "tooltip.shots.explosive",
            ShotsHoming = "tooltip.shots.homing",
            ShotsSky = "tooltip.shots.sky",
            ShotsSplit = "tooltip.shots.split",
            SlowMobs = "tooltip.effect.slows",
            Summoned = "tooltip.summon",
            SummonedDamage = "tooltip.summon.damage",
            SummonedDespawn = "tooltip.summon.despawn",
            SummonedHealth = "tooltip.summon.health",
            WeakenedWithoutArcana = "tooltip.weakened_without_arcana";
    /**
     * Indicates what ammunition is required.
     *
     * @param ammo - ammunition
     */
    public static Component ammo(Item ammo) {
        Component ammoName = MutableComponent.create(new TranslatableContents(ammo.getDescriptionId(), null, null));
        return i18n(ChatFormatting.DARK_GREEN, Ammo, ammoName);
    }
    /**
     * Indicates how much arcana is being consumed.
     *
     * @param arcana - arcana amount
     */
    public static Component arcanaConsumed(Object arcana) {return i18n(ChatFormatting.AQUA, ArcanaConsuming, arcana);}
    /**
     * Indicates how much damage the arcana deals.
     *
     * @param damage - arcana damage
     */
    public static Component arcanaDam(Object damage) {return i18n(ArcanaDamage, damage);}
    /**
     * Indicates how much arcana is restored when used.
     *
     * @param arcana - arcana amount
     */
    public static Component arcanaRegen(int arcana) {return i18n(ChatFormatting.AQUA, ArcanaRegen, arcana);}
    /**
     * Indicates that the projectiles are bouncing.
     */
    public static Component bouncingShots() {return LocalizeUtils.i18n(ShotsBouncing);}
    /**
     * Indicates how long the entity will burn.
     *
     * @param seconds - burning duration
     */
    public static Component burn(int seconds) {return i18n(ChatFormatting.DARK_RED, BurnMobs, seconds);}
    /**
     * Indicates the efficiency of the tools.
     *
     * @param eff - efficiency
     */
    public static Component efficiency(int eff) {return i18n(Efficiency, eff);}
    /**
     * Indicates that the projectiles are explosive.
     */
    public static Component explosiveShots() {return LocalizeUtils.i18n(ChatFormatting.GOLD, ShotsExplosive);}
    /**
     * Creates message from server to translate on client.
     *
     * @param sender - player (mostly) to send message
     * @param string - lang key
     */
    public static Component getClientSideTranslation(CommandSource sender, String string, final Object... argument) {return TextComponentHelper.createComponentTranslation(sender, string, argument);}
    /**
     * Indicates the harvest level of the tools.
     *
     * @param lvl - harvest level
     */
    public static Component harvestLevel(int lvl) {return i18n(HarvestLevel, lvl);}
    /**
     * Indicates how much health is restored when used.
     */
    public static Component healthRegen(Object health) {return i18n(ChatFormatting.LIGHT_PURPLE, HealthRegen, health);}
    /**
     * Indicates that the projectiles are homing.
     */
    public static Component homingShots() {return LocalizeUtils.i18n(ShotsHoming);}
    /**
     * Indicates that no ammo is required.
     */
    public static Component infiniteAmmo() {return i18n(ChatFormatting.DARK_PURPLE, InfiniteAmmo);}
    /**
     * Indicates that the item is consumed instantly.
     */
    public static Component instantConsumption() {return i18n(ChatFormatting.AQUA, InstantConsumption);}
    /**
     * Indicates that the weapon shoots lightning bolts when used.
     */
    public static Component lightningShots() {return i18n(ChatFormatting.YELLOW, LightningShot);}
    /**
     * Indicates how much damage the magic deals.
     *
     * @param damage - magic damage
     */
    public static Component magicDam(Object damage) {return i18n(MagicDamage, damage);}
    /**
     * Indicates how much damage the user takes.
     *
     * @param damage - on use damage
     */
    public static Component onUseDam(Object damage) {return i18n(ChatFormatting.RED, OnUseDamage, damage);}
    /**
     * Indicates how long the poison effect will last.
     *
     * @param seconds - effect duration
     */
    public static Component poison(int seconds) {return i18n(ChatFormatting.DARK_GREEN, Poison, seconds);}
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
    public static Component rangedDam(Object damage) {return i18n(RangedDamage, damage);}
    /**
     * Indicates that the projectile returns back to the sender.
     */
    public static Component returnsToSender() {return i18n(ReturnsToSender);}
    /**
     * Indicates how long the slowness effect will last.
     *
     * @param seconds - effect duration
     */
    public static Component slow(int seconds) {return i18n(ChatFormatting.DARK_AQUA, SlowMobs, seconds);}
    /**
     * Indicates that the projectiles are splitting upon hitting something.
     */
    public static Component splitShots() {return LocalizeUtils.i18n(ShotsSplit);}
    /**
     * Indicates that the item shoots objects from the sky.
     *
     * @param count - amount of objects
     */
    public static Component skyShots(Object count) {return i18n(ShotsSky, count);}
    /**
     * Specifies the summoned entity.
     *
     * @param entity - summoned entity
     */
    public static Component summoned(EntityType entity) {
        Component name = MutableComponent.create(new TranslatableContents(entity.getDescriptionId(), null, null));
        return i18n(Summoned, name);
    }
    /**
     * Specifies the damage of the summoned entity.
     *
     * @param damage - entity's damage
     */
    public static Component summonedDamage(int damage) {return i18n(SummonedDamage, damage);}
    /**
     * Specifies that the summoned entity disappears after a while.
     */
    public static Component summonedDespawn() {return i18n(SummonedDespawn);}
    /**
     * Specifies the health of the summoned entity.
     *
     * @param health - entity's health
     */
    public static Component summonedHealth(int health) {return i18n(SummonedHealth, health);}
    /**
     * Indicates that the item is weakened without the arcana.
     */
    public static Component weakenedWithoutArcana() {return i18n(ChatFormatting.RED, WeakenedWithoutArcana);}
    //TODO: this one is unused, to remove if it's no longer needed!
    /**
     * Prints version info.
     *
     * @param version - version
     */
    public static ComponentContents version(String version) {
        MutableComponent text = MutableComponent.create(new TranslatableContents("message.version", version, null));
        text.withStyle(ChatFormatting.RED);
        return text.getContents();
    }
    /**
     * Returns translated text.
     * @param color - text color
     * @param text - lang key
     * @param args - string format arguments
     */
    public static Component i18n(ChatFormatting color, String text, Object... args) {
        MutableComponent result = MutableComponent.create(new TranslatableContents(text, null, args));
        return result.withStyle(color);
    }
    public static Component i18n(String text, Object... args) {
        MutableComponent result = MutableComponent.create(new TranslatableContents(text, null, args));
        return result.withStyle(ChatFormatting.GRAY);
    }
}