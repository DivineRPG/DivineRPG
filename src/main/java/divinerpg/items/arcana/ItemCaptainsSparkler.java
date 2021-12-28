package divinerpg.items.arcana;

import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.RarityList;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemCaptainsSparkler extends ItemModRanged {

    public ItemCaptainsSparkler() {
        super("captains_sparkler", RarityList.COMMON, EntityRegistry.SPARKLER, null, SoundRegistry.SPARKLER, SoundCategory.MASTER, -1, 4, null, 7);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(20));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
