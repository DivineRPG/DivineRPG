package divinerpg.util;

import net.minecraft.command.ICommandSource;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.server.command.TextComponentHelper;

public class LocalizeUtils {
    /**
     * Here is stored rows with no String.format
     */
    private static final TextComponent
            InfiniteUses = new TranslationTextComponent("tooltip.uses.infinite"),
            NoProtection = new TranslationTextComponent("tooltip.noprotection"),
            HomingShoots = new TranslationTextComponent("tooltip.shots.homing"),
            SingleUse = new TranslationTextComponent("tooltip.uses.single"),
            InstantConsumption = new TranslationTextComponent("tooltip.instant_consumption"),
            WeakenedWithoutArcana = new TranslationTextComponent("tooltip.weakened_without_arcana");


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
    public static TextComponent getArmorAbility(String keyPart, Object... params) {
        String id = String.format("tooltip.armor_info.%s", keyPart);

        return params == null || params.length < 1
                ? new TranslationTextComponent(id)
                : new TranslationTextComponent(id, params);
    }

    /**
     * Shows how many uses remainig on item
     *
     * @param uses - remaining uses
     * @return
     */
    public static ITextComponent usesRemaining(int uses) {
        return i18n(RemainingUses, uses);
    }

    /**
     * Shows infinite ammo tooltip
     *
     * @return
     */
    public static ITextComponent infiniteAmmo() {
        return LocalizeUtils.i18n("tooltip.ammo.infinite");

    }

    /**
     * Shows what ammo is using
     *
     * @param ammo
     * @return
     */
    public static ITextComponent ammo(Item ammo) {
        return ammo(ammo, TextFormatting.GRAY);
    }

    /**
     * Shows what ammo is using. indicates if ammo is present
     *
     * @param ammo      - ammo for cannon
     * @param isPresent - if present print green else - red
     * @return
     */
    public static ITextComponent ammo(Item ammo, boolean isPresent) {
        return ammo(ammo, isPresent ? TextFormatting.GREEN : TextFormatting.RED);
    }

    /**
     * Shows what ammo is using. indicates if ammo is present
     *
     * @param ammo       - ammo for cannon
     * @param formatting - color of ammo name
     * @return
     */
    public static ITextComponent ammo(Item ammo, TextFormatting formatting) {
        ITextComponent ammoName = new TranslationTextComponent(ammo.getDescriptionId());
        ammoName.getStyle().applyFormat(formatting);

        return i18n(Ammo, ammoName);
    }

    /**
     * Returns tooltip of arcana sonsuming
     *
     * @param ar - amount. Possible any value, for example range value 10-20
     * @return
     */
    public static ITextComponent arcanaConsumed(Object ar) {
        return i18n(ArcanaConsuming, ar);
    }

    /**
     * Returns tooltip of special arcana damage source amount per shoot
     *
     * @param dam - arcana damage
     * @return
     */
    public static ITextComponent arcanaDam(double dam) {
        return i18n(ArcanaDamageSource, dam);
    }

    /**
     * How much arcana regens on use
     *
     * @param ar - arcana amount
     * @return
     */
    public static ITextComponent arcanaRegen(int ar) {
        return i18n(ArcanaRegen, ar);
    }

    /**
     * Bow damage on shoot
     *
     * @param dam - string range of damage
     * @return
     */
    public static ITextComponent bowDam(String dam) {
        return i18n(BowDamage, dam);
    }

    public static ITextComponent burn(int seconds) {
        return i18n(BurnMobs, seconds);
    }

    /**
     * Shows infinite uses info
     *
     * @return
     */
    public static ITextComponent infiniteUses() {
        return InfiniteUses.withStyle(TextFormatting.BLUE);
    }

    public static ITextComponent instantConsumption() {
        return InstantConsumption.withStyle(TextFormatting.AQUA);
    }

    public static ITextComponent weakenedWithoutArcana() {
        return WeakenedWithoutArcana.withStyle(TextFormatting.RED);
    }

    /**
     * Returns armor piece damage reduction info
     *
     * @param reduct     - aurrent peace reduction
     * @param fullReduct - full set reduction
     * @return
     */
    public static ITextComponent damageReduction(double reduct, double fullReduct) {
        return i18n(DamageReductionStringFormat, reduct, fullReduct);
    }

    /**
     * Shows too efficiency
     *
     * @param eff - efficiency
     * @return
     */
    public static ITextComponent efficiency(double eff) {
        return i18n(Efficency, eff);
    }

    /**
     * Shows tool harvest level
     *
     * @param lvl - harvest level
     * @return
     */
    public static ITextComponent harvestLevel(int lvl) {
        return i18n(HarvestLevel, lvl);
    }

    /**
     * Exposive arrow Shoots
     *
     * @return
     */
    public static ITextComponent explosiveShots() {
        return LocalizeUtils.i18n("tooltip.shots.explosive");
    }

    /**
     * Homing arrow shoots
     *
     * @return
     */
    public static ITextComponent homingShots() {
        return HomingShoots;
    }

    /**
     * Items single use
     *
     * @return
     */
    public static ITextComponent singleUse() {
        return SingleUse;
    }

    /**
     * Melee damage info
     *
     * @param dam - melee gamage amount
     * @return
     */
    public static ITextComponent meleeDam(double dam) {
        return i18n(MeleeDamage, dam);
    }

    /**
     * Poison mobs info
     *
     * @param seconds - effect duration
     * @return
     */
    public static ITextComponent poison(float seconds) {
        return i18n(Poison, seconds);
    }

    /**
     * Adding range damage info
     *
     * @param dam - damage amount
     * @return
     */
    public static ITextComponent rangedDam(double dam) {
        return i18n(BowDamage, dam);
    }

    /**
     * For how long mobs will be slowed down
     *
     * @param seconds effect duration
     * @return
     */
    public static ITextComponent slow(double seconds) {
        return i18n(SlowMobs, seconds);
    }

    /**
     * No protection info
     *
     * @return
     */
    public static ITextComponent noProtection() {
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
    public static String normal(String message) {
        return normal(message, TextFormatting.WHITE);
    }

    /**
     * Prints text message with custom color
     *
     * @param message - lang key
     * @param format  - text color
     * @return
     */
    public static String normal(String message, TextFormatting format) {
        TextComponent text = new TranslationTextComponent(message);
        text.withStyle(format);

        return text.getContents();
    }

    /**
     * Prints version info
     *
     * @param vers
     * @return
     */
    public static String version(String vers) {
        TextComponent text = new TranslationTextComponent("message.version", vers);
        text.withStyle(TextFormatting.RED);

        return text.getContents();
    }

    /**
     * Creates message fro mserver to translate on client
     *
     * @param sender - player (mostly) to send message
     * @param str    - lang key
     * @return
     */
    public static ITextComponent getClientSideTranslation(ICommandSource sender, String str, final Object... args) {
        return TextComponentHelper.createComponentTranslation(sender, str, args);
    }

    /**
     * Returns translated text
     *
     * @param text - lang key
     * @param args - string format args
     * @return
     */
    public static ITextComponent i18n(String text, Object... args) {
        TranslationTextComponent result = new TranslationTextComponent(text, args);
        return result.withStyle(TextFormatting.GRAY);
    }

    public static ITextComponent i18n(TextFormatting color, String text, Object... args) {
        TranslationTextComponent result = new TranslationTextComponent(text, args);
        return result.withStyle(color);
    }
}