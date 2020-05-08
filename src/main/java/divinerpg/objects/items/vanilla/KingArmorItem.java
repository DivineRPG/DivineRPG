package divinerpg.objects.items.vanilla;

import divinerpg.api.armor.IFullSetInfo;
import divinerpg.api.armor.IItemContainer;
import divinerpg.enums.ArmorInfo;
import divinerpg.enums.EnumArmor;
import divinerpg.objects.items.base.ItemDivineArmor;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class KingArmorItem extends ItemDivineArmor implements IItemContainer {
    private final String ItemsKey = "ItemsKey";

    public KingArmorItem(String name, ArmorMaterial armorMaterial, EntityEquipmentSlot slot, ArmorInfo info) {
        super(name, armorMaterial, slot, info);
    }

    @Override
    public Set<ItemStack> getAbsorbedItemStacks(ItemStack item) {
        Set<ItemStack> set = new LinkedHashSet<>();

        if (item.getItem() instanceof IItemContainer) {
            if (!item.hasTagCompound()) {
                item.setTagCompound(new NBTTagCompound());
            }

            NBTTagCompound itemsTag = item.getTagCompound().getCompoundTag(ItemsKey);

            // same as in ItemStackHelper
            int itemsCount = itemsTag.getTagList("Items", 10).tagCount();
            NonNullList<ItemStack> items = NonNullList.withSize(itemsCount, ItemStack.EMPTY);

            ItemStackHelper.loadAllItems(itemsTag, items);

            set.addAll(items);
        }

        return set;
    }

    private void setAbsorbedItems(ItemStack stack, Collection<ItemStack> items) {
        if (stack.getItem() instanceof IItemContainer) {
            NonNullList<ItemStack> list = NonNullList.create();

            // todo compare stacks with NBT
            Set<ItemStack> set = items.stream().filter(x -> !x.isEmpty()).collect(Collectors.toSet());
            list.addAll(set);

            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
            }

            stack.getTagCompound().setTag(ItemsKey, ItemStackHelper.saveAllItems(new NBTTagCompound(), list));
        }
    }

    @Override
    public void absorb(ItemStack stack, ItemStack toAbsorb) {
        if (stack.isEmpty() || toAbsorb.isEmpty() || !(stack.getItem() instanceof IItemContainer))
            return;

        Set<ItemStack> newSet = getAbsorbedItemStacks(stack);
        newSet.add(toAbsorb);

        setAbsorbedItems(stack, newSet);
    }

    /*
    @Override
    public void damageArmor(EntityLivingBase livingBase, ItemStack stack, DamageSource source, int par4, int par5) {
        // getting all absorbed items
        Set<ItemStack> stacks = getAbsorbedItemStacks(stack);
        if (stacks.isEmpty())
            return;

        // looking for actual armor pieces
        List<ItemStack> armorPieces = stacks.stream().filter(x -> x.getItem() instanceof ISpecialArmor).collect(Collectors.toList());
        if (armorPieces.isEmpty())
            return;

        // Getting random one
        ItemStack toDamage = armorPieces.get(itemRand.nextInt(armorPieces.size()));
        // damaging it
        ((ISpecialArmor) toDamage.getItem()).damageArmor(livingBase, toDamage, source, par4, par5);

        // saving items after damage
        setAbsorbedItems(stack, stacks);
    }*/

    @Override
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        super.addInformation(item, worldIn, list, flagIn);

        if (item == null)
            return;

        Set<ItemStack> absorbedItemStacks = getAbsorbedItemStacks(item);
        if (absorbedItemStacks == null)
            return;

        List<ItemStack> specialArmors = absorbedItemStacks.stream().filter(x -> x.getItem() instanceof IFullSetInfo)
                .collect(Collectors.toList());

        if (specialArmors.isEmpty())
            return;

        list.add("Absorbed sets:");

        specialArmors.forEach(x -> {
            list.add("");

            String damageInfo = x.getMaxDamage() <= 0
                    ? LocalizeUtils.infiniteUses()
                    : LocalizeUtils.usesRemaining(x.getMaxDamage() - x.getItemDamage());

            TextComponentString name = new TextComponentString(x.getDisplayName() + " " + damageInfo);
            name.getStyle().setColor(TextFormatting.WHITE);
            list.add(name.getFormattedText());
            ((IFullSetInfo) x.getItem()).getFullSetPerks().getSiblings().forEach(t -> list.add(t.getFormattedText()));
        });
    }
}
