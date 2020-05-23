package divinerpg.objects.items.iceika;

import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.WeaponRegistry;
import divinerpg.utils.LocalizeUtils;
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
        super(name, clazz,null, event, SoundCategory.MASTER,4000, 0,
                () -> null,
                0);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (this == WeaponRegistry.soundOfCarols) {
            tooltip.add(LocalizeUtils.rangedDam(16));
        } else {
            tooltip.add(LocalizeUtils.rangedDam(10));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
