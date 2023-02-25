package divinerpg.items.base;

import divinerpg.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

public class ItemMod extends Item {
    private static final Item.Properties props = new Item.Properties().tab(DivineRPG.tabs.materials);
    private boolean hasGlint;

    public ItemMod() {
        super(props);
    }

    public ItemMod(Properties properties) {
        super(properties);
    }

    public ItemMod(CreativeModeTab tab) {
        super(new Item.Properties().tab(tab));
    }

    public ItemMod(Rarity rarity, CreativeModeTab tab) {
        super(new Item.Properties().tab(tab).rarity(rarity));
    }

    public ItemMod(boolean hasGlint) {
        super(props);
        this.hasGlint = hasGlint;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (this.getDescriptionId().contains("torridite"))
            tooltip.add(Component.translatable(DivineRPG.MODID + ".torridite"));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return hasGlint || super.isEnchantable(stack);
    }
}
