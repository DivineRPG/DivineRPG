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
import java.util.function.Supplier;

public class ItemMusicShooter extends ItemModRanged {

    public ItemMusicShooter(Supplier<SoundEvent> event, String name) {
        super(name, null, event, SoundSource.MASTER, 4000, 1,
                null,
                0);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (this == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "sound_of_carols"))) {
            tooltip.add(LocalizeUtils.rangedDam(16));
        } else {
            tooltip.add(LocalizeUtils.rangedDam(10));
        }
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
