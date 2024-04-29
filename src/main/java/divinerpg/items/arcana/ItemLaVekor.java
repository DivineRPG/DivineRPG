package divinerpg.items.arcana;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemLaVekor extends ItemModRanged {
    public ItemLaVekor() {super(BulletType.GRENADE, SoundRegistry.LA_VEKOR.get(), ItemRegistry.grenade.getId(), 0, 10, 15);}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam((int)bulletType.getDamage()));
        tooltip.add(LocalizeUtils.explosiveShots());
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}