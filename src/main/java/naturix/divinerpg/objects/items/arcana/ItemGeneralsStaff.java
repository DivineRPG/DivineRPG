package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityGeneralsStaff;
import naturix.divinerpg.objects.items.base.RangedWeaponBase;
import naturix.divinerpg.objects.items.vethea.ItemStaff;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipHelper;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemGeneralsStaff extends RangedWeaponBase {
    public ItemGeneralsStaff() {
        super("generals_staff", EntityGeneralsStaff.class, null, ModSounds.STARLIGHT, SoundCategory.MASTER, -1, 4, null,
                20);
        ItemStaff.staffList.add(this);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TooltipLocalizer.rangedDam(18));
        tooltip.add(TooltipHelper.getInfoText("tooltip.generals_staff.split"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}