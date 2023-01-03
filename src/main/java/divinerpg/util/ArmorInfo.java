package divinerpg.util;

import net.minecraft.*;
import net.minecraft.network.chat.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.*;
import java.util.*;
import java.util.List;
import java.util.function.*;
import java.util.stream.*;

public class ArmorInfo {
    /**
     * Description of full set perks
     */
    public final MutableComponent FullSetPerks;
    /**
     * Need to detect if armor can work here
     */
    public MutableComponent dimensionName;

    /**
     * Predicate detects in which dimension powers will work
     */
    private Predicate<ResourceKey<Level>> dimensionPredicate;

    public ArmorInfo(Component... fullSetPerks) {
        FullSetPerks = Component.translatable("");

        if (fullSetPerks != null && fullSetPerks.length > 0) {
            Arrays.stream(fullSetPerks).forEach(FullSetPerks::append);
        }

        FullSetPerks.withStyle(ChatFormatting.GRAY);
    }

    public ArmorInfo withDimension(MutableComponent dimensionName, Predicate<ResourceKey<Level>> dimensionPredicate) {
        this.dimensionName = dimensionName;
        this.dimensionPredicate = dimensionPredicate;
        return this;
    }

    public List<String> toString(ItemStack item, @Nullable Level worldIn) {
        MutableComponent result = Component.translatable("");
        result.withStyle(ChatFormatting.GRAY);

        if (dimensionName != null) {
            boolean isBoosted = worldIn != null && worldIn.dimension() != null && dimensionPredicate != null && dimensionPredicate.test(worldIn.dimension());

            MutableComponent dimName = Component.translatable(dimensionName.getString());
            if (isBoosted) {
                dimName.getStyle().withColor(TextColor.fromLegacyFormat(ChatFormatting.GREEN));
            }

            result.append(dimName);
        }
        if (FullSetPerks != null && !FullSetPerks.getSiblings().isEmpty()) {
            MutableComponent fullSetDescription = MutableComponent.create(new TranslatableContents("tooltip.fullset"));
            fullSetDescription.withStyle(ChatFormatting.WHITE);
            result.append(fullSetDescription);

            FullSetPerks.getSiblings().forEach(result::append);
        }

        return result.getSiblings().stream().map(Component::getString).collect(Collectors.toList());
    }

}