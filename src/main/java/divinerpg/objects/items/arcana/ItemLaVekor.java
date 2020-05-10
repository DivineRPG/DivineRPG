package divinerpg.objects.items.arcana;

import divinerpg.objects.entities.entity.projectiles.EntityGrenade;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.ModSounds;
import divinerpg.registry.ModWeapons;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemLaVekor extends RangedWeaponBase {

    public ItemLaVekor() {
        super("la_vekor", EntityGrenade.class, null, ModSounds.LA_VEKOR, SoundCategory.MASTER, -1, 0, () -> ModWeapons.grenade,
                5);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.explosiveShots());
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}