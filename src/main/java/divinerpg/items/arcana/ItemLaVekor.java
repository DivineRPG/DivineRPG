package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.*;
import java.util.*;

public class ItemLaVekor extends ItemModRanged {

    public ItemLaVekor() {
        super("grenade", null, () -> SoundRegistry.LA_VEKOR.get(), SoundSource.MASTER, -1, 0, new ResourceLocation(DivineRPG.MODID, "grenade"),
                5);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.explosiveShots());
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
