package divinerpg.items.base;

import divinerpg.DivineRPG;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMod extends Item {
    private static final Item.Properties props = new Item.Properties().tab(DivineRPG.tabs.materials);
    private boolean hasGlint;

    public ItemMod(String name) {
        super(props);
        setRegistryName(name);
    }

    public ItemMod(String name, Properties properties) {
        super(properties);
        setRegistryName(name);
    }

    public ItemMod(String name, Rarity rarity, ItemGroup tab) {
        super(new Item.Properties().tab(tab).rarity(rarity));
        setRegistryName(name);
    }

    public ItemMod(String name, boolean hasGlint) {
        super(props);
        setRegistryName(name);
        this.hasGlint = hasGlint;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (this.getRegistryName().getPath().contains("torridite"))
            tooltip.add(new TranslationTextComponent(DivineRPG.MODID + ".torridite"));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return hasGlint || super.isEnchantable(stack);
    }
}
