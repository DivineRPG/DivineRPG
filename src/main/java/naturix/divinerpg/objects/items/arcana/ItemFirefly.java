package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityFirefly;
import naturix.divinerpg.objects.items.base.RangedWeaponBase;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemFirefly extends RangedWeaponBase {

    public ItemFirefly() {
        super("firefly", EntityFirefly.class, null, ModSounds.FIREFLY, SoundCategory.PLAYERS, -1, 0, null, 5);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TooltipLocalizer.homingShots());
        tooltip.add(TooltipLocalizer.rangedDam(15));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}