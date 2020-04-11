package divinerpg.objects.items.arcana;

import divinerpg.objects.entities.entity.projectiles.EntityGrenade;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.ModItems;
import divinerpg.registry.ModSounds;
import divinerpg.utils.LocalizeKeys;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemLaVekor extends RangedWeaponBase {

    public ItemLaVekor() {
        super("la_vekor", EntityGrenade.class, null, ModSounds.LA_VEKOR, SoundCategory.MASTER, -1, 0, () -> ModItems.grenade,
                5);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeKeys.explosiveShots());
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}