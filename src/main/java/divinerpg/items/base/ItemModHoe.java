package divinerpg.items.base;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;

public class ItemModHoe extends HoeItem {
    public Integer nameColor;
    //Base constructor
    public ItemModHoe(Tier tier, float attackSpeed, Properties properties) {
        super(tier, (tier.getUses() == 0 ? properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true)) : properties).attributes(HoeItem.createAttributes(tier, 0, attackSpeed)));
    }
    //Base hoes
    public ItemModHoe(Tier tier, float attackSpeed) {this(tier, attackSpeed, new Properties());}
    //Hoes with custom rarity
    public ItemModHoe(Tier tier, float attackSpeed, int rarity) {
        this(tier, attackSpeed, new Properties());
        nameColor = rarity;
    }
    @Override public Component getName(ItemStack pStack) {
        return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}