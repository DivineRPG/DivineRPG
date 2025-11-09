package divinerpg.items.base;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;

public class ItemModAxe extends AxeItem {
	public Integer nameColor;
    //Base constructor
    public ItemModAxe(Tier tier, float attackSpeed, Properties properties) {
        super(tier, (tier.getUses() == 0 ? properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true)) : properties).attributes(AxeItem.createAttributes(tier, 0, attackSpeed)));
    }
    //Base axes
    public ItemModAxe(Tier tier, float attackSpeed) {this(tier, attackSpeed, new Properties());}
    //Axes with custom rarity
    public ItemModAxe(Tier tier, float attackSpeed, int rarity) {
        this(tier, attackSpeed, new Properties());
        nameColor = rarity;
    }
	@Override public Component getName(ItemStack pStack) {
    	return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}