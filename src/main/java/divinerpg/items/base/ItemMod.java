package divinerpg.items.base;

import divinerpg.DivineRPG;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMod extends Item {
    private static final Item.Properties props = new Item.Properties();
    private boolean hasGlint;

    public ItemMod() {
        super(props);
    }

    public ItemMod(Properties properties) {
        super(properties);
    }

    public ItemMod(Rarity rarity) {
        super(new Item.Properties().rarity(rarity));
    }

    public ItemMod(boolean hasGlint) {
        super(props);
        this.hasGlint = hasGlint;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (this.getDescriptionId().contains("torridite"))
            tooltip.add(Component.translatable(DivineRPG.MODID + ".torridite").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return hasGlint || super.isEnchantable(stack);
    }
}
