package divinerpg.util;

import net.minecraft.*;
import net.minecraft.commands.*;
import net.minecraft.network.chat.*;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.item.*;
import net.minecraftforge.server.command.*;

public class LocalizeUtils {
    /**
     * Here is stored rows with no String.format
     */
    private static final MutableComponent
            InfiniteUses = MutableComponent.create(new TranslatableContents("tooltip.uses.infinite")),
            NoProtection = MutableComponent.create(new TranslatableContents("tooltip.noprotection")),
            HomingShoots = MutableComponent.create(new TranslatableContents("tooltip.shots.homing")),
            SingleUse = MutableComponent.create(new TranslatableContents("tooltip.uses.single")),
            InstantConsumption = MutableComponent.create(new TranslatableContents("tooltip.instant_consumption")),
            WeakenedWithoutArcana = MutableComponent.create(new TranslatableContents("tooltip.weakened_without_arcana"));


    /**
     * Keys for string.format call
     */
    private static final String RemainingUses = "tooltip.uses",
            DamageReductionStringFormat = "tooltip.damage.reduction",
            Ammo = "tooltip.ammo",
            ArcanaConsuming = "tooltip.arcana",
            ArcanaDamageSource = "tooltip.damage.arcana",
            ArcanaRegen = "tooltip.arcana.regen",
            MeleeDamage = "tooltip.damage.melee",
            BowDamage = "tooltip.damage.ranged",
            RangedAndMeleeDamage = "tooltip.damage.both",
            Efficency = "tooltip.efficiency",
            HarvestLevel = "tooltip.harvest_level",
            Poison = "tooltip.effect.poisons",
            BurnMobs = "tooltip.effect.burns",
            SlowMobs = "tooltip.effect.slows";

    /**
     * Armor ability
     *
     * @param keyPart - part of localized key 'tooltip.armor_info.' + KEY_PART
     * @return
     */
    public static TranslatableContents getArmorAbility(String keyPart, Object... params) {
        String id = String.format("tooltip.armor_info.%s", keyPart);

        return params == null || params.length < 1
                ? new TranslatableContents(id)
                : new TranslatableContents(id, params);
    }

    /**
     * Shows how many uses remainig on item
     *
     * @param uses - remaining uses
     * @return
     */
    public static Component usesRemaining(int uses) {
        return i18n(RemainingUses, uses);
    }

    /**
     * Shows infinite ammo tooltip
     *
     * @return
     */
    public static Component infiniteAmmo() {
        return LocalizeUtils.i18n("tooltip.ammo.infinite");

    }

    /**
     * Shows what ammo is using
     *
     * @param ammo
     * @return
     */
    public static Component ammo(Item ammo) {
        return ammo(ammo, ChatFormatting.GRAY);
    }

    /**
     * Shows what ammo is using. indicates if ammo is present
     *
     * @param ammo      - ammo for cannon
     * @param isPresent - if present print green else - red
     * @return
     */
    public static Component ammo(Item ammo, boolean isPresent) {
        return ammo(ammo, isPresent ? ChatFormatting.GREEN : ChatFormatting.RED);
    }

    /**
     * Shows what ammo is using. indicates if ammo is present
     *
     * @param ammo       - ammo for cannon
     * @param formatting - color of ammo name
     * @return
     */
    public static Component ammo(Item ammo, ChatFormatting formatting) {
        Component ammoName = MutableComponent.create(new TranslatableContents(ammo.getDescriptionId()));
        ammoName.getStyle().applyFormat(formatting);

        return i18n(Ammo, ammoName);
    }

    /**
     * Returns tooltip of arcana sonsuming
     *
     * @param ar - amount. Possible any value, for example range value 10-20
     * @return
     */
    public static Component arcanaConsumed(Object ar) {
        return i18n(ArcanaConsuming, ar);
    }

    /**
     * Returns tooltip of special arcana damage source amount per shoot
     *
     * @param dam - arcana damage
     * @return
     */
    public static Component arcanaDam(double dam) {
        return i18n(ArcanaDamageSource, dam);
    }

    /**
     * How much arcana regens on use
     *
     * @param ar - arcana amount
     * @return
     */
    public static Component arcanaRegen(int ar) {
        return i18n(ArcanaRegen, ar);
    }

    /**
     * Bow damage on shoot
     *
     * @param dam - string range of damage
     * @return
     */
    public static Component bowDam(String dam) {
        return i18n(BowDamage, dam);
    }

    public static Component burn(int seconds) {
        return i18n(BurnMobs, seconds);
    }

    /**
     * Shows infinite uses info
     *
     * @return
     */
    public static Component infiniteUses() {
        return InfiniteUses.withStyle(ChatFormatting.BLUE);
    }

    public static Component instantConsumption() {
        return InstantConsumption.withStyle(ChatFormatting.AQUA);
    }

    public static Component weakenedWithoutArcana() {
        return WeakenedWithoutArcana.withStyle(ChatFormatting.RED);
    }

    /**
     * Returns armor piece damage reduction info
     *
     * @param reduct     - aurrent peace reduction
     * @param fullReduct - full set reduction
     * @return
     */
    public static Component damageReduction(double reduct, double fullReduct) {
        return i18n(DamageReductionStringFormat, reduct, fullReduct);
    }

    /**
     * Shows too efficiency
     *
     * @param eff - efficiency
     * @return
     */
    public static Component efficiency(double eff) {
        return i18n(Efficency, eff);
    }

    /**
     * Shows tool harvest level
     *
     * @param lvl - harvest level
     * @return
     */
    public static Component harvestLevel(int lvl) {
        return i18n(HarvestLevel, lvl);
    }

    /**
     * Exposive arrow Shoots
     *
     * @return
     */
    public static Component explosiveShots() {
        return LocalizeUtils.i18n("tooltip.shots.explosive");
    }

    /**
     * Homing arrow shoots
     *
     * @return
     */
    public static Component homingShots() {
        return HomingShoots;
    }

    /**
     * Items single use
     *
     * @return
     */
    public static Component singleUse() {
        return SingleUse;
    }

    /**
     * Melee damage info
     *
     * @param dam - melee gamage amount
     * @return
     */
    public static Component meleeDam(double dam) {
        return i18n(MeleeDamage, dam);
    }

    /**
     * Poison mobs info
     *
     * @param seconds - effect duration
     * @return
     */
    public static Component poison(float seconds) {
        return i18n(Poison, seconds);
    }

    /**
     * Adding range damage info
     *
     * @param dam - damage amount
     * @return
     */
    public static Component rangedDam(double dam) {
        return i18n(BowDamage, dam);
    }

    /**
     * For how long mobs will be slowed down
     *
     * @param seconds effect duration
     * @return
     */
    public static Component slow(double seconds) {
        return i18n(SlowMobs, seconds);
    }

    /**
     * No protection info
     *
     * @return
     */
    public static Component noProtection() {
        return NoProtection;
    }

//    public static String rangedAndMelee(double dam) {
//        return TooltipHelper.localize(RangedAndMeleeDamage).replace("#", String.valueOf(dam));
//    }

    /**
     * Prints white text message from lang key
     *
     * @param message - lang key
     * @return
     */
    public static ComponentContents normal(String message) {
        return normal(message, ChatFormatting.WHITE);
    }

    /**
     * Prints text message with custom color
     *
     * @param message - lang key
     * @param format  - text color
     * @return
     */
    public static ComponentContents normal(String message, ChatFormatting format) {
        MutableComponent text = MutableComponent.create(new TranslatableContents(message));
        text.withStyle(format);

        return text.getContents();
    }

    /**
     * Prints version info
     *
     * @param vers
     * @return
     */
    public static ComponentContents version(String vers) {
        MutableComponent text = MutableComponent.create(new TranslatableContents("message.version", vers));
        text.withStyle(ChatFormatting.RED);

        return text.getContents();
    }

    /**
     * Creates message fro mserver to translate on client
     *
     * @param sender - player (mostly) to send message
     * @param str    - lang key
     * @return
     */
    public static Component getClientSideTranslation(CommandSource sender, String str, final Object... args) {
        return TextComponentHelper.createComponentTranslation(sender, str, args);
    }

    /**
     * Returns translated text
     *
     * @param text - lang key
     * @param args - string format args
     * @return
     */
    public static Component i18n(String text, Object... args) {
        MutableComponent result = MutableComponent.create(new TranslatableContents(text, args));
        return result.withStyle(ChatFormatting.GRAY);
    }

    public static Component i18n(ChatFormatting color, String text, Object... args) {
        MutableComponent result = MutableComponent.create(new TranslatableContents(text, args));
        return result.withStyle(color);
    }
}