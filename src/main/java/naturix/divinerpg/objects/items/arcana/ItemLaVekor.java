package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityGrenade;
import naturix.divinerpg.objects.items.base.RangedWeaponBase;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemLaVekor extends RangedWeaponBase {

    public ItemLaVekor() {
        super("la_vekor", EntityGrenade.class, null, ModSounds.LA_VEKOR, SoundCategory.MASTER, -1, 0, ModItems.grenade,
                5);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TooltipLocalizer.explosiveShots());
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}