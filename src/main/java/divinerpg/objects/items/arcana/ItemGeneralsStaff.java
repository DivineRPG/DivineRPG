package divinerpg.objects.items.arcana;

import divinerpg.objects.entities.entity.projectiles.EntityGeneralsStaff;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.ModSounds;
import divinerpg.utils.TooltipHelper;
import divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemGeneralsStaff extends RangedWeaponBase {
    public ItemGeneralsStaff() {
        super("generals_staff", EntityGeneralsStaff.class, null, ModSounds.STARLIGHT, SoundCategory.MASTER, -1, 4, null,
                20);
//        ItemStaff.staffList.add(this);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TooltipLocalizer.rangedDam(18));
        tooltip.add(TooltipHelper.getInfoText("tooltip.generals_staff.split"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}