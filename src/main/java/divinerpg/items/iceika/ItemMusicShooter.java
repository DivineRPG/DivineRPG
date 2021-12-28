package divinerpg.items.iceika;

import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.ItemRegistry;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.RarityList;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMusicShooter extends ItemModRanged {

    public ItemMusicShooter(String name, SoundEvent event, EntityType type) {
        super(name, RarityList.COMMON, type, null, event, SoundCategory.MASTER, 4000, 0,
                () -> null,
                0);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (this == ItemRegistry.soundOfCarols) {
            tooltip.add(LocalizeUtils.rangedDam(16));
        } else {
            tooltip.add(LocalizeUtils.rangedDam(10));
        }
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
