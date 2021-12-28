package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.util.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ItemModSword extends SwordItem {

    public ItemModSword(String name, Rarity rarity, IItemTier tier, ItemGroup group) {
        super(tier, 3, 1.6F, new Item.Properties().tab(group).rarity(rarity));
        setRegistryName(DivineRPG.MODID, name);
    }
    public ItemModSword(String name, IItemTier tier, Item.Properties properties) {
        super(tier, 3, 1.6F, properties);
        setRegistryName(DivineRPG.MODID, name);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        addAdditionalInformation(tooltip);
        if (getMaxDamage() == -1) {
            tooltip.add(LocalizeUtils.infiniteUses());
        }
    }

    protected void addAdditionalInformation(List<ITextComponent> list) {
    }
}