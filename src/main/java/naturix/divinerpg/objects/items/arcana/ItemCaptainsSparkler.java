package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.projectiles.EntitySparkler;
import naturix.divinerpg.objects.items.base.RangedWeaponBase;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemCaptainsSparkler extends RangedWeaponBase {

    public ItemCaptainsSparkler(String name) {
        super(name, EntitySparkler.class, null, ModSounds.SPARKLER, SoundCategory.MASTER, -1, 4, null, 7);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TooltipLocalizer.rangedDam(20));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}