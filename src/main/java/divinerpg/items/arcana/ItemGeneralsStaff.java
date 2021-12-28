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

public class ItemGeneralsStaff extends ItemModRanged {

    public ItemGeneralsStaff() {
        super("generals_staff", RarityList.COMMON, EntityRegistry.GENERALS_STAFF, null, SoundRegistry.STARLIGHT, SoundCategory.MASTER, -1, 12,
                null, 20);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(18));
        tooltip.add(LocalizeUtils.i18n("tooltip.generals_staff.split"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
