package divinerpg.util;

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
    public final TextComponent FullSetPerks;
    /**
     * Need to detect if armor can work here
     */
    public TextComponent dimensionName;

    /**
     * Predicate detects in which dimension powers will work
     */
    private Predicate<DimensionType> dimensionPredicate;

    public ArmorInfo(TextComponent... fullSetPerks) {
        FullSetPerks = new StringTextComponent("");

        if (fullSetPerks != null && fullSetPerks.length > 0) {
            Arrays.stream(fullSetPerks).forEach(FullSetPerks::append);
        }

        FullSetPerks.getStyle().setColor(Color.fromTextFormatting(TextFormatting.GRAY));
    }

    public ArmorInfo withDimension(TextComponent dimensionName, Predicate<DimensionType> dimensionPredicate) {
        this.dimensionName = dimensionName;
        this.dimensionPredicate = dimensionPredicate;
        return this;
    }

    public List<String> toString(ItemStack item, @Nullable World worldIn) {
        StringTextComponent result = new StringTextComponent("");
        result.getStyle().setColor(Color.fromTextFormatting(TextFormatting.GRAY));

        if (dimensionName != null) {
            boolean isBoosted = worldIn != null && worldIn.getDimensionKey() != null && dimensionPredicate != null && dimensionPredicate.test(worldIn.getDimensionType());

            StringTextComponent dimName = new StringTextComponent(dimensionName.getString());
            if (isBoosted) {
                dimName.getStyle().setColor(Color.fromTextFormatting(TextFormatting.GREEN));
            }

            result.append(dimName);
        }
        if (FullSetPerks != null && !FullSetPerks.getSiblings().isEmpty()) {
            ITextComponent fullSetDescription = new TranslationTextComponent("tooltip.fullset");
            fullSetDescription.getStyle().setColor(Color.fromTextFormatting(TextFormatting.WHITE));
            result.append(fullSetDescription);

            FullSetPerks.getSiblings().forEach(result::append);
        }

        return result.getSiblings().stream().map(ITextComponent::getString).collect(Collectors.toList());
    }

}