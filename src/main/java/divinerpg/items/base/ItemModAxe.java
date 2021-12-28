package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ItemModAxe extends AxeItem {
    public ItemModAxe(IItemTier tier, String name, Rarity rarity, ItemGroup group) {
        super(tier, 0, -3.4F, new Item.Properties().tab(group).rarity(rarity));
        setRegistryName(name);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (getMaxDamage() == -1) {
            tooltip.add(LocalizeUtils.infiniteUses());
        }
    }
}
