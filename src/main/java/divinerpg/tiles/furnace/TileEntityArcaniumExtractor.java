package divinerpg.tiles.furnace;

import com.google.common.collect.*;
import divinerpg.containers.*;
import divinerpg.recipe.*;
import divinerpg.registries.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.block.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class TileEntityArcaniumExtractor extends LockableTileEntity implements ISidedInventory, IRecipeHolder, IRecipeHelperPopulator, ITickableTileEntity {
    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2, 1};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
    private int litTime;
    private int litDuration;
    private int cookingProgress;
    private int cookingTotalTime;
    protected final IIntArray dataAccess = new IIntArray() {
        public int get(int p_221476_1_) {
            switch(p_221476_1_) {
                case 0:
                    return TileEntityArcaniumExtractor.this.litTime;
                case 1:
                    return TileEntityArcaniumExtractor.this.litDuration;
                case 2:
                    return TileEntityArcaniumExtractor.this.cookingProgress;
                case 3:
                    return TileEntityArcaniumExtractor.this.cookingTotalTime;
                default:
                    return 0;
            }
        }

        public void set(int p_221477_1_, int p_221477_2_) {
            switch(p_221477_1_) {
                case 0:
                    TileEntityArcaniumExtractor.this.litTime = p_221477_2_;
                    break;
                case 1:
                    TileEntityArcaniumExtractor.this.litDuration = p_221477_2_;
                    break;
                case 2:
                    TileEntityArcaniumExtractor.this.cookingProgress = p_221477_2_;
                    break;
                case 3:
                    TileEntityArcaniumExtractor.this.cookingTotalTime = p_221477_2_;
            }

        }

        public int getCount() {
            return 4;
        }
    };
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    protected final IRecipeType<? extends ArcaniumExtractorRecipe> recipeType;

    public TileEntityArcaniumExtractor() {
        super(TileRegistry.ARCANIUM_EXTRACTOR);
        this.recipeType = RecipeRegistry.RecipeTypes.ARCANIUM_EXTRACTORRECIPE_TYPE;
    }

    @Deprecated
    public static Map<Item, Integer> getFuel() {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        add(map, ItemRegistry.collector, 200);
        return map;
    }





    private static void add(Map<Item, Integer> map, IItemProvider itemProvider, int p_213996_2_) {
        Item item = itemProvider.asItem();
        map.put(item, p_213996_2_);
    }

    private boolean isLit() {
        return this.litTime > 0;
    }

    public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        super.load(p_230337_1_, p_230337_2_);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(p_230337_2_, this.items);
        this.litTime = p_230337_2_.getInt("BurnTime");
        this.cookingProgress = p_230337_2_.getInt("CookTime");
        this.cookingTotalTime = p_230337_2_.getInt("CookTimeTotal");
        this.litDuration = this.getBurnDuration(this.items.get(1));
        CompoundNBT compoundnbt = p_230337_2_.getCompound("RecipesUsed");

        for(String s : compoundnbt.getAllKeys()) {
            this.recipesUsed.put(new ResourceLocation(s), compoundnbt.getInt(s));
        }

    }

    public CompoundNBT save(CompoundNBT p_189515_1_) {
        super.save(p_189515_1_);
        p_189515_1_.putInt("BurnTime", this.litTime);
        p_189515_1_.putInt("CookTime", this.cookingProgress);
        p_189515_1_.putInt("CookTimeTotal", this.cookingTotalTime);
        ItemStackHelper.saveAllItems(p_189515_1_, this.items);
        CompoundNBT compoundnbt = new CompoundNBT();
        this.recipesUsed.forEach((p_235643_1_, p_235643_2_) -> {
            compoundnbt.putInt(p_235643_1_.toString(), p_235643_2_);
        });
        p_189515_1_.put("RecipesUsed", compoundnbt);
        return p_189515_1_;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("block.divinerpg.arcanium_extractor");
    }

    @Override
    protected Container createMenu(int i, PlayerInventory playerInventory) {
        return new ArcaniumExtractorContainer(i, playerInventory, this, this.dataAccess);
    }

    protected int getBurnDuration(ItemStack stack) {
        if (stack == null || stack.getItem() != ItemRegistry.collector)
            return 0;
        return 100;
    }
    public void tick() {
        boolean flag = this.isLit();
        boolean flag1 = false;
        if (this.isLit()) {
            --this.litTime;
        }

        if (!this.level.isClientSide) {
            ItemStack itemstack = this.items.get(1);
            if (this.isLit() || !itemstack.isEmpty() && !this.items.get(0).isEmpty()) {
                IRecipe<?> irecipe = this.level.getRecipeManager().getRecipeFor((IRecipeType<ArcaniumExtractorRecipe>)this.recipeType, this, this.level).orElse(null);
                if (!this.isLit() && this.canBurn(irecipe)) {
                    this.litTime = this.getBurnDuration(itemstack);
                    this.litDuration = this.litTime;
                    if (this.isLit()) {
                        flag1 = true;
                        if (itemstack.hasContainerItem())
                            this.items.set(1, itemstack.getContainerItem());
                        else
                        if (!itemstack.isEmpty()) {
                            Item item = itemstack.getItem();
                            itemstack.shrink(1);
                            if (itemstack.isEmpty()) {
                                this.items.set(1, itemstack.getContainerItem());
                            }
                        }
                    }
                }

                if (this.isLit() && this.canBurn(irecipe)) {
                    ++this.cookingProgress;
                    if (this.cookingProgress == this.cookingTotalTime) {
                        this.cookingProgress = 0;
                        this.cookingTotalTime = this.getTotalCookTime();
                        this.burn(irecipe);
                        flag1 = true;
                    }
                } else {
                    this.cookingProgress = 0;
                }
            } else if (!this.isLit() && this.cookingProgress > 0) {
                this.cookingProgress = MathHelper.clamp(this.cookingProgress - 2, 0, this.cookingTotalTime);
            }

        }

        if (flag1) {
            this.setChanged();
        }

    }

    protected boolean canBurn(@Nullable IRecipe<?> iRecipe) {
        if (!this.items.get(0).isEmpty() && iRecipe != null) {
            ItemStack itemstack = iRecipe.getResultItem();
            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = this.items.get(2);
                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!itemstack1.sameItem(itemstack)) {
                    return false;
                } else if (itemstack1.getCount() + itemstack.getCount() <= this.getMaxStackSize() && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) {
                    return true;
                } else {
                    return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
                }
            }
        } else {
            return false;
        }
    }

    private void burn(@Nullable IRecipe<?> iRecipe) {
        if (iRecipe != null && this.canBurn(iRecipe)) {
            ItemStack itemstack = this.items.get(0);
            ItemStack itemstack1 = iRecipe.getResultItem();
            ItemStack itemstack2 = this.items.get(2);
            if (itemstack2.isEmpty()) {
                this.items.set(2, itemstack1.copy());
            } else if (itemstack2.getItem() == itemstack1.getItem()) {
                itemstack2.grow(itemstack1.getCount());
            }

            if (!this.level.isClientSide) {
                this.setRecipeUsed(iRecipe);
            }

            itemstack.shrink(1);
            if(!isLit())
            items.get(1).shrink(1);
        }
    }

    protected int getTotalCookTime() {
        return this.level.getRecipeManager().getRecipeFor((IRecipeType<ArcaniumExtractorRecipe>)this.recipeType, this, this.level).map(ArcaniumExtractorRecipe::getCookingTime).orElse(200);
    }

    public int[] getSlotsForFace(Direction direction) {
        if (direction == Direction.DOWN) {
            return SLOTS_FOR_DOWN;
        } else {
            return direction == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
        }
    }

    public boolean canPlaceItemThroughFace(int slot, ItemStack stack, @Nullable Direction direction) {
        return this.canPlaceItem(slot, stack);
    }

    public boolean canTakeItemThroughFace(int p_180461_1_, ItemStack p_180461_2_, Direction p_180461_3_) {
        if (p_180461_3_ == Direction.DOWN && p_180461_1_ == 1) {
            Item item = p_180461_2_.getItem();
            if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
                return false;
            }
        }

        return true;
    }

    public int getContainerSize() {
        return this.items.size();
    }

    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public ItemStack getItem(int slot) {
        return this.items.get(slot);
    }

    public ItemStack removeItem(int p_70298_1_, int p_70298_2_) {
        return ItemStackHelper.removeItem(this.items, p_70298_1_, p_70298_2_);
    }

    public ItemStack removeItemNoUpdate(int p_70304_1_) {
        return ItemStackHelper.takeItem(this.items, p_70304_1_);
    }

    public void setItem(int slot, ItemStack stack) {
        ItemStack itemstack = this.items.get(slot);
        boolean flag = !stack.isEmpty() && stack.sameItem(itemstack) && ItemStack.tagMatches(stack, itemstack);
        this.items.set(slot, stack);
        if (stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }

        if (slot == 0 && !flag) {
            this.cookingTotalTime = this.getTotalCookTime();
            this.cookingProgress = 0;
            this.setChanged();
        }

    }

    public boolean stillValid(PlayerEntity player) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return player.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
        }
    }

    public boolean canPlaceItem(int slot, ItemStack stack) {
        if (slot == 2) {
            return false;
        } else if (slot != 1) {
            return true;
        } else {
            ItemStack itemstack = this.items.get(1);
            return TileEntityArcaniumExtractor.getFuel().containsKey(stack.getItem());
        }
    }

    public List<IRecipe<?>> getRecipesToAwardAndPopExperience(World world, Vector3d vector) {
        List<IRecipe<?>> list = Lists.newArrayList();

        for(Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
            world.getRecipeManager().byKey(entry.getKey()).ifPresent((p_235642_4_) -> {
                list.add(p_235642_4_);
                createExperience(world, vector, entry.getIntValue(), ((ArcaniumExtractorRecipe)p_235642_4_).getExperience());
            });
        }

        return list;
    }

    private static void createExperience(World world, Vector3d vector3d, int p_235641_2_, float p_235641_3_) {
        int i = MathHelper.floor((float)p_235641_2_ * p_235641_3_);
        float f = MathHelper.frac((float)p_235641_2_ * p_235641_3_);
        if (f != 0.0F && Math.random() < (double)f) {
            ++i;
        }

        while(i > 0) {
            int j = ExperienceOrbEntity.getExperienceValue(i);
            i -= j;
            world.addFreshEntity(new ExperienceOrbEntity(world, vector3d.x, vector3d.y, vector3d.z, j));
        }

    }

    public void clearContent() {
        this.items.clear();
    }

    public void setRecipeUsed(@Nullable IRecipe<?> p_193056_1_) {
        if (p_193056_1_ != null) {
            ResourceLocation resourcelocation = p_193056_1_.getId();
            this.recipesUsed.addTo(resourcelocation, 1);
        }

    }

    @Nullable
    public IRecipe<?> getRecipeUsed() {
        return null;
    }

    public void awardUsedRecipes(PlayerEntity p_201560_1_) {
    }

    public void fillStackedContents(RecipeItemHelper p_194018_1_) {
        for(ItemStack itemstack : this.items) {
            p_194018_1_.accountStack(itemstack);
        }

    }

    net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers =
            net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
        if (!this.remove && facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (facing == Direction.UP)
                return handlers[0].cast();
            else if (facing == Direction.DOWN)
                return handlers[1].cast();
            else
                return handlers[2].cast();
        }
        return super.getCapability(capability, facing);
    }

    @Override
    protected void invalidateCaps() {
        super.invalidateCaps();
        for (int x = 0; x < handlers.length; x++)
            handlers[x].invalidate();
    }
}