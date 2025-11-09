package divinerpg.items.base;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;

public class ItemModPickaxe extends PickaxeItem {
	public Integer nameColor;
    //Base constructor
    public ItemModPickaxe(Tier tier, Properties properties) {
        super(tier, (tier.getUses() == 0 ? properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true)) : properties).attributes(PickaxeItem.createAttributes(tier, 0, -2.8F)));
    }
    //Base pickaxes
    public ItemModPickaxe(Tier tier) {this(tier, new Properties());}
    //Pickaxes with custom rarity
    public ItemModPickaxe(Tier tier, int rarity) {
        this(tier, new Properties());
        nameColor = rarity;
    }
	@Override public Component getName(ItemStack pStack) {
    	return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}