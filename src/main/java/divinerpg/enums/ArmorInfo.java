package divinerpg.enums;

import com.mojang.realmsclient.gui.ChatFormatting;
import divinerpg.utils.LocalizeKeys;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArmorInfo {
    /**
     * Description of full set perks
     */
    public final TextComponentBase FullSetPerks;
    /**
     * Need to detect if armor can work here
     */
    public TextComponentBase dimensionName;


    public ArmorInfo() {
        this(null);
    }

    public ArmorInfo(TextComponentBase... fullSetPerks) {
        FullSetPerks = new TextComponentString("");

        if (fullSetPerks != null && fullSetPerks.length > 0) {
            Arrays.stream(fullSetPerks).forEach(FullSetPerks::appendSibling);
        }

        FullSetPerks.getStyle().setColor(TextFormatting.GRAY);
    }

    public ArmorInfo withDimension(TextComponentBase dimensionName) {
        this.dimensionName = dimensionName;
        return this;
    }

    public List<String> toString(ItemStack item, @Nullable World worldIn, double fullReduction, double damageReduction) {
        TextComponentString result = new TextComponentString("");

        result.getStyle().setColor(TextFormatting.GRAY);

        if (fullReduction <= 0) {
            result.appendSibling(new TextComponentTranslation(LocalizeKeys.NoProtection));
        } else {
            result.appendSibling(new TextComponentTranslation(LocalizeKeys.DamageReductionStringFormat, Math.round(damageReduction * 100), Math.round(fullReduction)));
        }

        if (item.getMaxDamage() <= 0) {
            result.appendSibling(new TextComponentTranslation(LocalizeKeys.InfiniteUses));
        } else {
            result.appendSibling(new TextComponentTranslation(LocalizeKeys.RemainingUses, item.getMaxDamage() - item.getItemDamage()));
        }

        if (dimensionName != null) {
            boolean isBoosted = worldIn != null && worldIn.provider != null && Objects.equals(worldIn.provider.getDimensionType().getName(), dimensionName.getFormattedText());

            result.appendText(String.format("%s%s", isBoosted
                    ? ChatFormatting.DARK_GREEN.toString()
                    : "", dimensionName.getFormattedText()));
        }

        if (FullSetPerks != null && !FullSetPerks.getSiblings().isEmpty()) {
            TextComponentString fullSetDescription = new TextComponentString("Full Set Perks:");
            result.appendSibling(fullSetDescription.setStyle(fullSetDescription.getStyle().setColor(TextFormatting.WHITE)));


            FullSetPerks.getSiblings().forEach(result::appendSibling);
        }

        return result.getSiblings().stream().map(ITextComponent::getFormattedText).collect(Collectors.toList());
    }

}