package divinerpg.items.arcana;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModThrowable;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemGrenade extends ItemModThrowable {
    public ItemGrenade() {
        super(BulletType.GRENADE);
        cooldown = 20;
        sound = SoundEvents.TRIDENT_THROW;
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(LocalizeUtils.explosiveShots());
    }
}