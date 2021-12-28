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

public class ItemFirefly extends ItemModRanged {
    public ItemFirefly() {
        super("firefly", RarityList.COMMON, EntityRegistry.FIREFLY, null, SoundRegistry.FIREFLY, SoundCategory.PLAYERS, -1, 0, null, 5);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.homingShots());
        tooltip.add(LocalizeUtils.rangedDam(15));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
