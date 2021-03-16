package divinerpg.items.base;

import divinerpg.DivineRPG;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.List;

public class ItemModNotReady extends Item {
    private static final Item.Properties props = new Item.Properties().tab(DivineRPG.tabs.materials);

    public ItemModNotReady(String name) {
        super(props);
        setRegistryName(name);
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent(DivineRPG.MODID + ".wip"));
    }
}
