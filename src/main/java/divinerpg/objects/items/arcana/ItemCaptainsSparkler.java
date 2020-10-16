package divinerpg.objects.items.arcana;

import divinerpg.objects.entities.entity.projectiles.EntitySparkler;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemCaptainsSparkler extends RangedWeaponBase {

    public ItemCaptainsSparkler(String name) {
        super(name, EntitySparkler.class, null, SoundRegistry.SPARKLER, SoundCategory.MASTER, -1, 4, null, 7);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(20));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}