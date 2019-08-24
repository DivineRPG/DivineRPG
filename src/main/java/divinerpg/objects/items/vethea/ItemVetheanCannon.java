package divinerpg.objects.items.vethea;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.enums.BulletType;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModItems;
import divinerpg.registry.ModSounds;
import divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemVetheanCannon extends RangedWeaponBase {
    public ItemVetheanCannon(String name, BulletType bullet) {
    	super(name,
                null,
                bullet,
                ModSounds.BLITZ,
                SoundCategory.MASTER,
                -1,
                0,
                ModItems.acid,
                0);
        this.setCreativeTab(DivineRPGTabs.vethea);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(TooltipLocalizer.vethean());
    }
}