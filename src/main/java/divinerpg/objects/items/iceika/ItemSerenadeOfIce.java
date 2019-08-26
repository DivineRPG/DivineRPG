package divinerpg.objects.items.iceika;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.objects.entities.entity.projectiles.EntitySerenadeOfIce;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModSounds;
import divinerpg.utils.TooltipHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemSerenadeOfIce extends RangedWeaponBase {

    public ItemSerenadeOfIce(String name) {
        super(name,
                EntitySerenadeOfIce.class,
                null,
                ModSounds.SERENADE,
                SoundCategory.MASTER,
                100,
                0,
                null,
                0);
        this.setCreativeTab(DivineRPGTabs.utility);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TooltipHelper.getInfoText("tooltip.serenade_of_ice"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}