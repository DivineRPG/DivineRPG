package divinerpg.objects.items.arcana;

import divinerpg.objects.entities.entity.projectiles.EntityFirefly;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFirefly extends RangedWeaponBase {

    public ItemFirefly() {
        super("firefly", EntityFirefly.class, null, SoundRegistry.FIREFLY, SoundCategory.PLAYERS, -1, 0, null, 5);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.homingShots());
        tooltip.add(LocalizeUtils.rangedDam(15));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}