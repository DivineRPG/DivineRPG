package divinerpg.objects.items.base;

import divinerpg.api.armor.IFullSetInfo;
import divinerpg.enums.ArmorInfo;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDivineArmor extends ItemArmor implements IFullSetInfo {
    protected ArmorInfo armorInfo;

    public ItemDivineArmor(String name, ArmorMaterial armorMaterial, EntityEquipmentSlot slot, ArmorInfo info) {
        super(armorMaterial, 0, slot);
        this.armorInfo = info;

        setUnlocalizedName(name);
        setRegistryName(name);

        this.setCreativeTab(DivineRPGTabs.armor);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.addAll(armorInfo.toString(item, worldIn));
    }

    @Override
    public ITextComponent getFullSetPerks() {
        if (armorInfo == null)
            return null;

        return armorInfo.FullSetPerks;
    }
}