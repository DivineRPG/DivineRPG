package divinerpg.util;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

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
    private Predicate<RegistryKey<World>> dimensionPredicate;

    public ArmorInfo(TextComponent... fullSetPerks) {
        FullSetPerks = new StringTextComponent("");

        if (fullSetPerks != null && fullSetPerks.length > 0) {
            Arrays.stream(fullSetPerks).forEach(FullSetPerks::append);
        }

        FullSetPerks.getStyle().withColor(Color.fromLegacyFormat(TextFormatting.GRAY));
    }

    public ArmorInfo withDimension(TextComponent dimensionName, Predicate<RegistryKey<World>> dimensionPredicate) {
        this.dimensionName = dimensionName;
        this.dimensionPredicate = dimensionPredicate;
        return this;
    }

    public List<String> toString(ItemStack item, @Nullable World worldIn) {
        StringTextComponent result = new StringTextComponent("");
        result.getStyle().withColor(Color.fromLegacyFormat(TextFormatting.GRAY));

        if (dimensionName != null) {
            boolean isBoosted = worldIn != null && worldIn.dimension() != null && dimensionPredicate != null && dimensionPredicate.test(worldIn.dimension());

            StringTextComponent dimName = new StringTextComponent(dimensionName.getString());
            if (isBoosted) {
                dimName.getStyle().withColor(Color.fromLegacyFormat(TextFormatting.GREEN));
            }

            result.append(dimName);
        }
        if (FullSetPerks != null && !FullSetPerks.getSiblings().isEmpty()) {
            ITextComponent fullSetDescription = new TranslationTextComponent("tooltip.fullset");
            fullSetDescription.getStyle().withColor(Color.fromLegacyFormat(TextFormatting.WHITE));
            result.append(fullSetDescription);

            FullSetPerks.getSiblings().forEach(result::append);
        }

        return result.getSiblings().stream().map(ITextComponent::getString).collect(Collectors.toList());
    }

}