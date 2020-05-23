package divinerpg.objects.items.arcana;

import divinerpg.objects.entities.entity.projectiles.EntityAttractor;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemAttractor extends RangedWeaponBase {
    public ItemAttractor() {
        super("arcanium_attractor", EntityAttractor.class, null, SoundRegistry.REFLECTOR, SoundCategory.PLAYERS, -1, 0,
                null, 20);
        setCreativeTab(DivineRPGTabs.utility);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(LocalizeUtils.i18n("tooltip.arcanium_attractor"));
    }
}