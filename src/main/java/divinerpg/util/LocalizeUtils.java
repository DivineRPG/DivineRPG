package divinerpg.util;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.network.chat.*;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.item.Item;
import net.minecraftforge.server.command.TextComponentHelper;

public class LocalizeUtils {
    private static final String
            Ammo = "tooltip.ammo",
            ArcanaConsuming = "tooltip.arcana",
            ArcanaDamageSource = "tooltip.damage.arcana",
            ArcanaRegen = "tooltip.arcana.regen",
            BurnMobs = "tooltip.effect.burns",
            Efficency = "tooltip.efficiency",
            HarvestLevel = "tooltip.harvest_level",
            HealthRegen = "tooltip.heals",
            InfiniteAmmo = "tooltip.ammo.infinite",
            InfiniteUses = "tooltip.uses.infinite",
            InstantConsumption = "tooltip.instant_consumption",
            Poison = "tooltip.effect.poisons",
            RangedDamage = "tooltip.damage.ranged",
            RemainingUses = "tooltip.uses",
            ShotsExplosive = "tooltip.shots.explosive",
            ShotsHoming = "tooltip.shots.homing",
            SlowMobs = "tooltip.effect.slows",
            WeakenedWithoutArcana = "tooltip.weakened_without_arcana";
    /**
     * Indicates which ammo is required.
     *
     * @param ammo - ammunition
     */
    public static Component ammo(Item ammo) {
        return ammo(ammo, ChatFormatting.GRAY);
    }
    /**
     * Shows what ammo is using. indicates if ammo is present
     *
     * @param ammo - ammo for cannon
     * @param isPresent - if present print green else - red
     * @return
     */
    public static Component ammo(Item ammo, boolean isPresent) {
        return ammo(ammo, isPresent ? ChatFormatting.GREEN : ChatFormatting.RED);
    }
    /**
     * Shows what ammo is using. indicates if ammo is present
     *
     * @param ammo - ammo for cannon
     * @param formatting - color of ammo name
     * @return
     */
    public static Component ammo(Item ammo, ChatFormatting formatting) {
        Component ammoName = MutableComponent.create(new TranslatableContents(ammo.getDescriptionId(), null, null));
        ammoName.getStyle().applyFormat(formatting);
        return i18n(Ammo, ammoName);
    }
    /**
     * Indicates how much arcana is being consumed.
     *
     * @param arcana - arcana amount
     */
    public static Component arcanaConsumed(Object arcana) {return i18n(ChatFormatting.AQUA, ArcanaConsuming, arcana);}
    /**
     * Indicates how much damage the arcana does.
     *
     * @param damage - arcana damage
     */
    public static Component arcanaDam(double damage) {return i18n(ArcanaDamageSource, damage);}
    /**
     * Indicates how much arcana is restored when used.
     *
     * @param arcana - arcana amount
     */
    public static Component arcanaRegen(int arcana) {return i18n(ChatFormatting.AQUA, ArcanaRegen, arcana);}
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
    public static Component efficiency(double eff) {return i18n(Efficency, eff);}
    /**
     * Indicates that the projectiles are explosive.
     */
    public static Component explosiveShots() {return LocalizeUtils.i18n(ShotsExplosive);}
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
    public static Component healthRegen(float health) {return i18n(ChatFormatting.LIGHT_PURPLE, HealthRegen, health);}
    /**
     * Indicates that the projectiles are homing.
     */
    public static Component homingShots() {return LocalizeUtils.i18n(ShotsHoming);}
    /**
     * Indicates that no ammo is required.
     */
    public static Component infiniteAmmo() {return i18n(ChatFormatting.DARK_PURPLE, InfiniteAmmo);}
    /**
     * Indicates that the item has infinite uses.
     */
    public static Component infiniteUses() {return i18n(ChatFormatting.BLUE, InfiniteUses);}
    /**
     * Indicates that the item is consumed instantly.
     */
    public static Component instantConsumption() {return i18n(ChatFormatting.AQUA, InstantConsumption);}
    /**
     * Indicates how long the poison effect will last.
     *
     * @param seconds - effect duration
     */
    public static Component poison(int seconds) {return i18n(ChatFormatting.DARK_GREEN, Poison, seconds);}
    /**
     * Indicates how much damage the non-arrow projectiles do.
     *
     * @param damage - damage amount
     */
    public static Component rangedDam(int damage) {return i18n(RangedDamage, damage);}
    /**
     * Specifies the damage range of projectiles.
     *
     * @param damage - damage range
     */
    public static Component rangedDamString(String damage) {return i18n(RangedDamage, damage);}
    /**
     * Indicates how long the slowness effect will last.
     *
     * @param seconds - effect duration
     */
    public static Component slow(int seconds) {return i18n(ChatFormatting.DARK_AQUA, SlowMobs, seconds);}
    //TODO: ro remove usesRemaining, it's a bit redundant, basically f3+h
    public static Component usesRemaining(int uses) {return i18n(RemainingUses, uses);}
    /**
     * Indicates that the item is weakened without the arcana.
     */
    public static Component weakenedWithoutArcana() {return i18n(ChatFormatting.RED, WeakenedWithoutArcana);}
    /**
     * Prints version info.
     *
     * @param version
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