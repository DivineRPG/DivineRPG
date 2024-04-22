package divinerpg.items.arcana;

import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemReflector extends ItemModRanged {
    public ItemReflector() {super("reflector", null, SoundRegistry.REFLECTOR, SoundSource.PLAYERS, 0, 0, null, 20);}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.reflector.push"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}