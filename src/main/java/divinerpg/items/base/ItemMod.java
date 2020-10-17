package divinerpg.items.base;

import divinerpg.DivineRPG;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMod extends Item {
    private static final Item.Properties props = new Item.Properties().group(DivineRPG.tabs.materials);
    private boolean hasGlint;

    public ItemMod(String name) {
        super(props);
        setRegistryName(name);
    }

    public ItemMod(String name, Properties properties) {
        super(properties);
        setRegistryName(name);
    }

    public ItemMod(String name, ItemGroup tab) {
        super(new Item.Properties().group(tab));
        setRegistryName(name);
    }

    public ItemMod(String name, boolean hasGlint) {
        super(props);
        setRegistryName(name);
        this.hasGlint = hasGlint;
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (this.getRegistryName().getPath().contains("torridite"))
            tooltip.add(new TranslationTextComponent(DivineRPG.MODID + ".torridite"));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return hasGlint || super.hasEffect(stack);
    }
}
