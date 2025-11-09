package divinerpg.items.base;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;

public class ItemModShovel extends ShovelItem {
	public Integer nameColor;
    //Base constructor
    public ItemModShovel(Tier tier, Properties properties) {
        super(tier, (tier.getUses() == 0 ? properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true)) : properties).attributes(ShovelItem.createAttributes(tier, 0, -3)));
    }
    //Base shovels
    public ItemModShovel(Tier tier) {this(tier, new Properties());}
    //Shovels with custom rarity
    public ItemModShovel(Tier tier, int rarity) {
        this(tier, new Properties());
        nameColor = rarity;
    }
	@Override public Component getName(ItemStack pStack) {
    	return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}