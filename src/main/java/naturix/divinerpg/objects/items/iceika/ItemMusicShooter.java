package naturix.divinerpg.objects.items.iceika;

import naturix.divinerpg.objects.items.base.RangedWeaponBase;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMusicShooter extends RangedWeaponBase {

    public ItemMusicShooter(String name, SoundEvent event, Class<? extends EntityThrowable> clazz) {
        super(name,
                clazz,
                null,
                event,
                SoundCategory.MASTER,
                4000,
                0,
                null,
                0);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (this == ModItems.soundOfCarols) {
            tooltip.add(TooltipLocalizer.rangedDam(16));
        } else {
            tooltip.add(TooltipLocalizer.rangedDam(10));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
