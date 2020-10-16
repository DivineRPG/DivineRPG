package divinerpg.objects.items.vanilla;

import divinerpg.objects.items.base.ItemModSword;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBurningSword extends ItemModSword {
    private int burnSeconds;

    public ItemBurningSword(ToolMaterial toolMaterial, String name, int seconds) {
        super(toolMaterial, name);
        this.burnSeconds = seconds;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase livingBase1, EntityLivingBase livingBase2) {
        stack.damageItem(1, livingBase2);
        livingBase1.setFire(this.burnSeconds);
        return true;
    }

    @Override
    protected void addAdditionalInformation(List list) {
        list.add(LocalizeUtils.burn(this.burnSeconds));
    }
}
