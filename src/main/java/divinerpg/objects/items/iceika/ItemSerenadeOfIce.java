package divinerpg.objects.items.iceika;

import divinerpg.objects.entities.entity.projectiles.EntitySerenadeOfIce;
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

public class ItemSerenadeOfIce extends RangedWeaponBase {

    public ItemSerenadeOfIce(String name) {
        super(name,
                EntitySerenadeOfIce.class,
                null,
                SoundRegistry.SERENADE,
                SoundCategory.MASTER,
                100,
                0,
                null,
                0);
        this.setCreativeTab(DivineRPGTabs.utility);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.serenade_of_ice"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}