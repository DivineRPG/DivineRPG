package divinerpg.items.iceika;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemModRanged;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMusicShooter extends ItemModRanged {

    public ItemMusicShooter(SoundEvent event, String name) {
        super(name, null, event, 4000, 5,
                null,
                0);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (this == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "sound_of_carols"))) {
            tooltip.add(LocalizeUtils.rangedDam(16));
        } else if (this == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "sound_of_whales"))) {
            tooltip.add(LocalizeUtils.rangedDam(20));
        } else {
            tooltip.add(LocalizeUtils.rangedDam(10));
        }
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
