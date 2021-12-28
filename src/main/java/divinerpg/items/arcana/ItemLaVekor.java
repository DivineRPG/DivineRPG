package divinerpg.items.arcana;

import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.ItemRegistry;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.RarityList;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemLaVekor extends ItemModRanged {

    public ItemLaVekor() {
        super("la_vekor", RarityList.COMMON, EntityRegistry.GRENADE, null, SoundRegistry.LA_VEKOR, SoundCategory.MASTER, -1, 0, () -> ItemRegistry.grenade,
                5);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.explosiveShots());
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
