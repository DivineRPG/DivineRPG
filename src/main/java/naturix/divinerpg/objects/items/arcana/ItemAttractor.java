package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityAttractor;
import naturix.divinerpg.objects.items.base.RangedWeaponBase;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemAttractor extends RangedWeaponBase {
    public ItemAttractor() {
        super("arcanium_attractor", EntityAttractor.class, null, ModSounds.REFLECTOR, SoundCategory.PLAYERS, -1, 0,
                null, 20);
        setCreativeTab(DivineRPGTabs.utility);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(TooltipHelper.getInfoText("tooltip.arcanium_attractor"));
    }
}