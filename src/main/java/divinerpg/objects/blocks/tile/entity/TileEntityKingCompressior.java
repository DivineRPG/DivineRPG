package divinerpg.objects.blocks.tile.entity;

import com.google.common.collect.Sets;
import divinerpg.api.DivineAPI;
import divinerpg.api.Reference;
import divinerpg.api.armor.ArmorEquippedEvent;
import divinerpg.api.armor.IItemContainer;
import divinerpg.config.Config;
import divinerpg.objects.blocks.tile.container.KingCompressorContainer;
import divinerpg.objects.blocks.tile.entity.base.IFuelProvider;
import divinerpg.objects.blocks.tile.entity.base.ModUpdatableTileEntity;
import divinerpg.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IInteractionObject;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

public class TileEntityKingCompressior extends ModUpdatableTileEntity implements ITickable, IInteractionObject, IFuelProvider {
    private final ResourceLocation id = new ResourceLocation(Reference.MODID, "king_compressor");
    private final NonNullList<ItemStack> container;
    /**
     * Amount of registered power sets need to create king set
     */
    private final int kingCreationLimit;

    /**
     * Count of items can be absordeb at once
     */
    private final int maxAbsorbedCount;
    private final Set<String> absorbedSets = new HashSet<>();
    public boolean keepInventory = false;
    private int burningTime = 0;
    private int cookTime = 0;

    public TileEntityKingCompressior() {
        kingCreationLimit = (int) (DivineAPI.getArmorDescriptionRegistry().getKeys().size() * (Config.kingCreationPercentage / 100.0));
        maxAbsorbedCount = Config.maxAbsorbedCount <= 0
                ? DivineAPI.getArmorDescriptionRegistry().getKeys().size()
                : Config.maxAbsorbedCount;

        container = NonNullList.withSize(EntityEquipmentSlot.values().length * 2 + 1, ItemStack.EMPTY);
    }

    @Override
    public void update() {
        updateBurningTick();
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new KingCompressorContainer(playerInventory, this);
    }

    @Override
    public String getGuiID() {
        return id.toString();
    }

    @Override
    public String getName() {
        return String.format("tile.%s.name", id.getResourcePath());
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public boolean needFuel() {
        return true;
    }

    @Override
    public int consumeFuel() {
        for (int i = EntityEquipmentSlot.values().length * 2; i < getSizeInventory(); i++) {
            int time = getBurnTime(getStackInSlot(i));
            if (time > 0) {
                decrStackSize(i, 1);
                return time;
            }
        }

        return 0;
    }

    @Override
    public void onFinished() {

        if (!world.isRemote)
            onFinish(getPossibleOperation());

        markDirty();
    }

    private void onFinish(OperationTypes operation) {
        if (operation == null)
            return;

        EntityEquipmentSlot[] values = EntityEquipmentSlot.values();

        switch (operation) {
            case Absorning:
                Set<ResourceLocation> names = getCurrentSetPowerNames();
                absorbedSets.addAll(names.stream().map(ResourceLocation::toString).collect(Collectors.toList()));

                EntityEquipmentSlot[] slots = values;

                for (EntityEquipmentSlot id : slots) {
                    setInventorySlotContents(id.getSlotIndex() + slots.length, ItemStack.EMPTY);
                }
                break;

            case KingSetCreation:
                absorbedSets.clear();

//                setInventorySlotContents(EntityEquipmentSlot.HEAD.getSlotIndex(), new ItemStack(ModArmor.king_helmet));
//                setInventorySlotContents(EntityEquipmentSlot.CHEST.getSlotIndex(), new ItemStack(ModArmor.king_chestplate));
//                setInventorySlotContents(EntityEquipmentSlot.LEGS.getSlotIndex(), new ItemStack(ModArmor.king_leggings));
//                setInventorySlotContents(EntityEquipmentSlot.FEET.getSlotIndex(), new ItemStack(ModArmor.king_boots));
                break;

            case Infusion:
                for (EntityEquipmentSlot id : values) {
                    int outputIndex = id.getSlotIndex();
                    int input = outputIndex + values.length;

                    ItemStack toAbsorb = getStackInSlot(input);
                    if (toAbsorb.isEmpty())
                        continue;

                    ItemStack stack = getStackInSlot(outputIndex);
                    if (stack.getItem() instanceof IItemContainer) {
                        ((IItemContainer) stack.getItem()).absorb(stack, toAbsorb);
                    }

                    setInventorySlotContents(input, ItemStack.EMPTY);
                }

                break;
        }
    }

    @Override
    public void onStart() {

    }

    @Override
    public boolean haveItemsToSmelt() {
        OperationTypes types = getPossibleOperation();

        if (types == null)
            return false;

        switch (types) {
            case KingSetCreation:
                return true;

            case Infusion:
                // checking max size of abrobing items
                for (ItemStack stack : Arrays.stream(EntityEquipmentSlot.values())
                        .map(x -> getStackInSlot(x.getSlotIndex()))
                        .filter(x -> !x.isEmpty() && x.getItem() instanceof IItemContainer)
                        .collect(Collectors.toList())
                ) {
                    if (((IItemContainer) stack.getItem()).getAbsorbedItemStacks(stack).size() >= maxAbsorbedCount)
                        return false;
                }
            case Absorning:
                // can absorb power set inside
                return getCurrentSetPowerNames()
                        .stream()
                        .anyMatch(x -> !absorbedSets.contains(x.toString()));

            default:
                return false;

        }
    }

    @Override
    public int getBurningTicks() {
        return burningTime;
    }

    @Override
    public void setBurningTicks(int value) {
        burningTime = value;
    }

    @Override
    public int getCurrentCookTime() {
        return cookTime;
    }

    @Override
    public void setCookTime(int value) {
        cookTime = value;
    }

    @Override
    public int getCookTimeLength() {
        return 600;
    }

    @Override
    public void changeBurnState(boolean isBurning) {
        TileEntity tileentity = world.getTileEntity(pos);

//        Block block = isBurning
//                ? ModBlocks.king_compression
//                : ModBlocks.king_compression_still;

        keepInventory = true;
//        world.setBlockState(pos, block.getDefaultState(), 3);
        keepInventory = false;

        if (tileentity != null) {
            tileentity.validate();
            world.setTileEntity(pos, tileentity);
        }
    }

    @Override
    public NonNullList<ItemStack> getInventoryRef() {
        return container;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return player.world.getTileEntity(pos) == this && player.getDistanceSq(pos) < 64;
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        EntityEquipmentSlot[] values = EntityEquipmentSlot.values();

        // fuel
        if (index == values.length * 2) {
            return needFuel() && getBurnTime(stack) > 0;
        }

        // king set
        if (0 <= index && index < values.length) {
            return stack.getItem() instanceof IItemContainer;
        }

        // input
        if (values.length <= index && index < values.length * 2) {
            return getPossibleOperation() != OperationTypes.KingSetCreation;
        }

        return index > values.length + 1;
    }

    @Nullable
    public OperationTypes getPossibleOperation() {
        boolean anyInputSlot = false;
        boolean anyOutputSlot = false;

        for (int i = 0, end = EntityEquipmentSlot.values().length; i < end; i++) {
            if (!getStackInSlot(i).isEmpty())
                anyOutputSlot = true;

            if (!getStackInSlot(i + end).isEmpty())
                anyInputSlot = true;
        }

        if (!anyOutputSlot && anyInputSlot)
            return OperationTypes.Absorning;

        if (!anyOutputSlot && absorbedSets.size() >= getKingCreationLimit())
            return OperationTypes.KingSetCreation;

        if (anyOutputSlot && anyInputSlot)
            return OperationTypes.Infusion;

        return null;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagCompound result = super.writeToNBT(compound);

        result.setTag("content", ItemStackHelper.saveAllItems(new NBTTagCompound(), getInventoryRef()));
        result.setInteger("burn", getBurningTicks());
        result.setInteger("cook", getCurrentCookTime());

        NBTTagList sets = new NBTTagList();
        absorbedSets.forEach(x -> sets.appendTag(new NBTTagString(x)));

        result.setTag("absorbed", sets);

        return result;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        ItemStackHelper.loadAllItems(compound.getCompoundTag("content"), getInventoryRef());
        setBurningTicks(compound.getInteger("burn"));
        setCookTime(compound.getInteger("cook"));

        absorbedSets.clear();
        NBTBase raw = compound.getTag("absorbed");
        if (raw instanceof NBTTagList) {
            ((NBTTagList) raw).forEach(x -> {
                if (x instanceof NBTTagString) {
                    absorbedSets.add(((NBTTagString) x).getString());
                }
            });
        }
    }

    private Set<ResourceLocation> getCurrentSetPowerNames() {
        Map<EntityEquipmentSlot, ItemStack> input = new HashMap<>();

        EntityEquipmentSlot[] slots = EntityEquipmentSlot.values();
        for (EntityEquipmentSlot id : slots) {
            input.put(id, getStackInSlot(id.getSlotIndex() + slots.length));
        }

        if (input.values().stream().allMatch(ItemStack::isEmpty))
            return Sets.newHashSet();

        ArmorEquippedEvent event = new ArmorEquippedEvent(input);
        MinecraftForge.EVENT_BUS.post(event);
        return event.getConfirmed();
    }

    /**
     * Gets burn time for machine
     *
     * @param stack - item stack
     * @return
     */
    public int getBurnTime(@Nonnull ItemStack stack) {
        if (stack.getItem() == ModItems.shadowStone) {
            return getCookTimeLength() / 2;
        }

        return 0;
    }

    /**
     * Return list of absorbed sets
     *
     * @return
     */
    public Set<String> getAbsorbedSets() {
        return absorbedSets;
    }

    /**
     * Return sets amount needed to absorb
     *
     * @return
     */
    public int getKingCreationLimit() {
        return kingCreationLimit;
    }

    /**
     * Current work type
     */
    public enum OperationTypes {
        Absorning,
        KingSetCreation,
        Infusion,
    }
}
