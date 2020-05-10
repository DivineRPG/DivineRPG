package divinerpg.enums;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
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

    /**
     * Predicate detects in which dimension powers will work
     */
    private Predicate<DimensionType> dimensionPredicate;

    public ArmorInfo(TextComponentBase... fullSetPerks) {
        FullSetPerks = new TextComponentString("");

        if (fullSetPerks != null && fullSetPerks.length > 0) {
            Arrays.stream(fullSetPerks).forEach(FullSetPerks::appendSibling);
        }

        FullSetPerks.getStyle().setColor(TextFormatting.GRAY);
    }

    public ArmorInfo withDimension(TextComponentBase dimensionName, Predicate<DimensionType> dimensionPredicate) {
        this.dimensionName = dimensionName;
        this.dimensionPredicate = dimensionPredicate;
        return this;
    }

    public List<String> toString(ItemStack item, @Nullable World worldIn) {
        TextComponentString result = new TextComponentString("");
        result.getStyle().setColor(TextFormatting.GRAY);

        if (dimensionName != null) {
            boolean isBoosted = worldIn != null && worldIn.provider != null && dimensionPredicate != null && dimensionPredicate.test(worldIn.provider.getDimensionType());

            TextComponentString dimName = new TextComponentString(dimensionName.getFormattedText());
            if (isBoosted) {
                dimName.getStyle().setColor(TextFormatting.GREEN);
            }

            result.appendSibling(dimName);
        }
        if (FullSetPerks != null && !FullSetPerks.getSiblings().isEmpty()) {
            ITextComponent fullSetDescription = new TextComponentTranslation("tooltip.fullset");
            result.appendSibling(fullSetDescription.setStyle(fullSetDescription.getStyle().setColor(TextFormatting.WHITE)));

            FullSetPerks.getSiblings().forEach(result::appendSibling);
        }

        return result.getSiblings().stream().map(ITextComponent::getFormattedText).collect(Collectors.toList());
    }

}