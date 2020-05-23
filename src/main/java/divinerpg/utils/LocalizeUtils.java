package divinerpg.utils;

import net.minecraft.command.ICommandSender;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.server.command.TextComponentHelper;

public class LocalizeUtils {
    /**
     * Here is stored rows with no String.format
     */
    private static final TextComponentBase
            InfiniteUses = new TextComponentTranslation("tooltip.uses.infinite"),
            NoProtection = new TextComponentTranslation("tooltip.noprotection"),
            InfiniteAmmo = new TextComponentTranslation("tooltip.ammo.infinite"),
            ExposiveShoots = new TextComponentTranslation("tooltip.shots.explosive"),
            HomingShoots = new TextComponentTranslation("tooltip.shots.homing"),
            SingleUse = new TextComponentTranslation("tooltip.uses.single");


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
    public static TextComponentBase getArmorAbility(String keyPart, Object... params) {
        String id = String.format("tooltip.armor_info.%s", keyPart);

        return params == null || params.length < 1
                ? new TextComponentTranslation(id)
                : new TextComponentTranslation(id, params);
    }

    /**
     * Shows how many uses remainig on item
     *
     * @param uses - remaining uses
     * @return
     */
    public static String usesRemaining(int uses) {
        return i18n(RemainingUses, uses);
    }

    /**
     * Shows infinite ammo tooltip
     *
     * @return
     */
    public static String infiniteAmmo() {
        return InfiniteAmmo.getFormattedText();
    }

    /**
     * Shows what ammo is using
     *
     * @param ammo
     * @return
     */
    public static String ammo(Item ammo) {
        return ammo(ammo, TextFormatting.GRAY);
    }

    /**
     * Shows what ammo is using. indicates if ammo is present
     *
     * @param ammo      - ammo for cannon
     * @param isPresent - if present print green else - red
     * @return
     */
    public static String ammo(Item ammo, boolean isPresent) {
        return ammo(ammo, isPresent ? TextFormatting.GREEN : TextFormatting.RED);
    }

    /**
     * Shows what ammo is using. indicates if ammo is present
     *
     * @param ammo       - ammo for cannon
     * @param formatting - color of ammo name
     * @return
     */
    public static String ammo(Item ammo, TextFormatting formatting) {
        ITextComponent ammoName = new TextComponentTranslation(ammo.getUnlocalizedName() + ".name");
        ammoName.getStyle().setColor(formatting);

        return i18n(Ammo, ammoName);
    }

    /**
     * Returns tooltip of arcana sonsuming
     *
     * @param ar - amount. Possible any value, for example range value 10-20
     * @return
     */
    public static String arcanaConsumed(Object ar) {
        return i18n(ArcanaConsuming, ar);
    }

    /**
     * Returns tooltip of special arcana damage source amount per shoot
     *
     * @param dam - arcana damage
     * @return
     */
    public static String arcanaDam(double dam) {
        return i18n(ArcanaDamageSource, dam);
    }

    /**
     * How much arcana regens on use
     *
     * @param ar - arcana amount
     * @return
     */
    public static String arcanaRegen(int ar) {
        return i18n(ArcanaRegen, ar);
    }

    /**
     * Bow damage on shoot
     *
     * @param dam - string range of damage
     * @return
     */
    public static String bowDam(String dam) {
        return i18n(BowDamage, dam);
    }

    public static String burn(int seconds) {
        return i18n(BurnMobs, seconds);
    }

    /**
     * Shows infinite uses info
     *
     * @return
     */
    public static String infiniteUses() {
        return InfiniteUses.getFormattedText();
    }

//    public static String cantBlock() {
//        return CannotBlock.getFormattedText();
//    }
//

    /**
     * Returns armor piece damage reduction info
     *
     * @param reduct     - aurrent peace reduction
     * @param fullReduct - full set reduction
     * @return
     */
    public static String damageReduction(double reduct, double fullReduct) {
        return i18n(DamageReductionStringFormat, reduct, fullReduct);
    }

    /**
     * Shows too efficiency
     *
     * @param eff - efficiency
     * @return
     */
    public static String efficiency(double eff) {
        return i18n(Efficency, eff);
    }

    /**
     * Shows tool harvest level
     *
     * @param lvl - harvest level
     * @return
     */
    public static String harvestLevel(int lvl) {
        return i18n(HarvestLevel, lvl);
    }

    /**
     * Exposive arrow Shoots
     *
     * @return
     */
    public static String explosiveShots() {
        return ExposiveShoots.getFormattedText();
    }

    /**
     * Homing arrow shoots
     *
     * @return
     */
    public static String homingShots() {
        return HomingShoots.getFormattedText();
    }

    /**
     * Items single use
     *
     * @return
     */
    public static String singleUse() {
        return SingleUse.getFormattedText();
    }

    /**
     * Melee damage info
     *
     * @param dam - melee gamage amount
     * @return
     */
    public static String meleeDam(double dam) {
        return i18n(MeleeDamage, dam);
    }

    /**
     * Poison mobs info
     *
     * @param seconds - effect duration
     * @return
     */
    public static String poison(float seconds) {
        return i18n(Poison, seconds);
    }

    /**
     * Adding range damage info
     *
     * @param dam - damage amount
     * @return
     */
    public static String rangedDam(double dam) {
        return i18n(BowDamage, dam);
    }

    /**
     * For how long mobs will be slowed down
     *
     * @param seconds effect duration
     * @return
     */
    public static String slow(double seconds) {
        return i18n(SlowMobs, seconds);
    }

    /**
     * No protection info
     *
     * @return
     */
    public static String noProtection() {
        return NoProtection.getFormattedText();
    }

    //
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
        ITextComponent text = new TextComponentTranslation(message);
        text.getStyle().setColor(format);

        return text.getFormattedText();
    }

    /**
     * Prints version info
     *
     * @param vers
     * @return
     */
    public static String version(String vers) {
        ITextComponent text = new TextComponentTranslation("message.version", vers);
        text.getStyle().setColor(TextFormatting.RED);

        return text.getFormattedText();
    }

    /**
     * Creates message fro mserver to translate on client
     *
     * @param sender - player (mostly) to send message
     * @param str    - lang key
     * @return
     */
    public static ITextComponent getClientSideTranslation(ICommandSender sender, String str, final Object... args) {
        return TextComponentHelper.createComponentTranslation(sender, str, args);
    }

    /**
     * Returns translated text
     *
     * @param text - lang key
     * @param args - string format args
     * @return
     */
    public static String i18n(String text, Object... args) {
        TextComponentTranslation result = new TextComponentTranslation(text, args);
        result.getStyle().setColor(TextFormatting.GRAY);
        return result.getFormattedText();
    }
}