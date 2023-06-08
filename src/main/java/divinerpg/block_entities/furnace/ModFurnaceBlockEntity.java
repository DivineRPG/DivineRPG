package divinerpg.block_entities.furnace;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.*;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

import javax.annotation.Nullable;
import java.util.List;

public abstract class ModFurnaceBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeHolder, StackedContentsCompatible {
	private static final int[] SLOTS_FOR_UP = new int[]{0}, SLOTS_FOR_DOWN = new int[]{2, 1}, SLOTS_FOR_SIDES = new int[]{1};
	public final RecipeManager.CachedCheck<Container, ? extends AbstractCookingRecipe> quickCheck = RecipeManager.createCheck(RecipeType.SMELTING);
	private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
	protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
	public final String containerName;
	public final double speed;
	int litTime, litDuration, cookingProgress, cookingTotalTime;
	protected final ContainerData dataAccess = new ContainerData() {
	      public int get(int p_58431_) {
	         switch (p_58431_) {
	            case 0: return ModFurnaceBlockEntity.this.litTime;
	            case 1: return ModFurnaceBlockEntity.this.litDuration;
	            case 2:
	               return ModFurnaceBlockEntity.this.cookingProgress;
	            case 3: return ModFurnaceBlockEntity.this.cookingTotalTime;
	            default: return 0;
	         }
	      }
	      public void set(int p_58433_, int p_58434_) {
	         switch (p_58433_) {
	            case 0: ModFurnaceBlockEntity.this.litTime = p_58434_;
	               break;
	            case 1: ModFurnaceBlockEntity.this.litDuration = p_58434_;
	               break;
	            case 2: ModFurnaceBlockEntity.this.cookingProgress = p_58434_;
	               break;
	            case 3: ModFurnaceBlockEntity.this.cookingTotalTime = p_58434_;
	         }
	      }
	      public int getCount() {return 4;}
	};
	public ModFurnaceBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, String containerName, double speed) {
		super(type, pos, state);
		this.containerName = containerName;
		this.speed = speed;
	}
	@Override
	protected Component getDefaultName() {
		return Component.translatable(containerName);
	}
	protected int getBurnDuration(ItemStack stack) {
		if (stack.isEmpty()) return 0;
	    else return (int)(ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) / speed);
	}
	public static int getTotalCookTime(Level level, ModFurnaceBlockEntity tile) {
		return (int) (tile.quickCheck.getRecipeFor(tile, level).map(AbstractCookingRecipe::getCookingTime).orElse(200) / tile.speed);
	}
	public boolean isLit() {return this.litTime > 0;}
	@Override
	public void load(CompoundTag p_155025_) {
	      super.load(p_155025_);
	      items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
	      ContainerHelper.loadAllItems(p_155025_, items);
	      litTime = p_155025_.getInt("BurnTime");
	      cookingProgress = p_155025_.getInt("CookTime");
	      cookingTotalTime = p_155025_.getInt("CookTimeTotal");
	      litDuration = getBurnDuration(items.get(1));
	      CompoundTag compoundtag = p_155025_.getCompound("RecipesUsed");
	      for(String s : compoundtag.getAllKeys()) recipesUsed.put(new ResourceLocation(s), compoundtag.getInt(s));
	}
	@Override
	protected void saveAdditional(CompoundTag p_187452_) {
	      super.saveAdditional(p_187452_);
	      p_187452_.putInt("BurnTime", this.litTime);
	      p_187452_.putInt("CookTime", this.cookingProgress);
	      p_187452_.putInt("CookTimeTotal", this.cookingTotalTime);
	      ContainerHelper.saveAllItems(p_187452_, this.items);
	      CompoundTag compoundtag = new CompoundTag();
	      this.recipesUsed.forEach((p_187449_, p_187450_) -> {
	         compoundtag.putInt(p_187449_.toString(), p_187450_);
	      });
	      p_187452_.put("RecipesUsed", compoundtag);
	}
	public static void serverTick(Level p_155014_, BlockPos p_155015_, BlockState p_155016_, ModFurnaceBlockEntity p_155017_) {
	      boolean flag = p_155017_.isLit();
	      boolean flag1 = false;
	      if (p_155017_.isLit()) --p_155017_.litTime;
	      ItemStack itemstack = p_155017_.items.get(1);
	      boolean flag2 = !p_155017_.items.get(0).isEmpty();
	      boolean flag3 = !itemstack.isEmpty();
	      if (p_155017_.isLit() || flag3 && flag2) {
	         Recipe<?> recipe;
	         if (flag2) recipe = p_155017_.quickCheck.getRecipeFor(p_155017_, p_155014_).orElse(null);
	         else recipe = null;
	         int i = p_155017_.getMaxStackSize();
	         if (!p_155017_.isLit() && p_155017_.canBurn(recipe, p_155017_.items, i)) {
	            p_155017_.litTime = p_155017_.getBurnDuration(itemstack);
	            p_155017_.litDuration = p_155017_.litTime;
	            if (p_155017_.isLit()) {
	               flag1 = true;
	               if (itemstack.hasCraftingRemainingItem()) p_155017_.items.set(1, itemstack.getCraftingRemainingItem());
	               else if (flag3) {
	                  itemstack.shrink(1);
	                  if (itemstack.isEmpty()) p_155017_.items.set(1, itemstack.getCraftingRemainingItem());
	               }
	            }
	         }
	         if (p_155017_.isLit() && p_155017_.canBurn(recipe, p_155017_.items, i)) {
	            ++p_155017_.cookingProgress;
	            if (p_155017_.cookingProgress == p_155017_.cookingTotalTime) {
	               p_155017_.cookingProgress = 0;
	               p_155017_.cookingTotalTime = getTotalCookTime(p_155014_, p_155017_);
	               if (p_155017_.burn(recipe, p_155017_.items, i)) p_155017_.setRecipeUsed(recipe);
	               flag1 = true;
	            }
	         } else p_155017_.cookingProgress = 0;
	      } else if (!p_155017_.isLit() && p_155017_.cookingProgress > 0) p_155017_.cookingProgress = Mth.clamp(p_155017_.cookingProgress - 2, 0, p_155017_.cookingTotalTime);
	      if (flag != p_155017_.isLit()) {
	         flag1 = true;
	         p_155016_ = p_155016_.setValue(AbstractFurnaceBlock.LIT, Boolean.valueOf(p_155017_.isLit()));
	         p_155014_.setBlock(p_155015_, p_155016_, 3);
	      }
	      if (flag1) setChanged(p_155014_, p_155015_, p_155016_);
	}
	private boolean canBurn(@Nullable Recipe<?> p_155006_, NonNullList<ItemStack> p_155007_, int p_155008_) {
	      if (!p_155007_.get(0).isEmpty() && p_155006_ != null) {
	         ItemStack itemstack = ((Recipe<WorldlyContainer>) p_155006_).assemble(this, level.registryAccess());
	         if (itemstack.isEmpty()) return false;
	         else {
	            ItemStack itemstack1 = p_155007_.get(2);
	            if (itemstack1.isEmpty()) return true;
	            else if (!ItemStack.isSameItem(itemstack1, itemstack)) return false;
	            else if (itemstack1.getCount() + itemstack.getCount() <= p_155008_ && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) return true; // Forge fix: make furnace respect stack sizes in furnace recipes
	            else return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
	         }
	      } else return false;
	}
	private boolean burn(@Nullable Recipe<?> p_155027_, NonNullList<ItemStack> p_155028_, int p_155029_) {
	      if (p_155027_ != null && this.canBurn(p_155027_, p_155028_, p_155029_)) {
	         ItemStack itemstack = p_155028_.get(0);
	         ItemStack itemstack1 = ((Recipe<WorldlyContainer>) p_155027_).assemble(this, level.registryAccess());
	         ItemStack itemstack2 = p_155028_.get(2);
	         if (itemstack2.isEmpty()) p_155028_.set(2, itemstack1.copy());
	         else if (itemstack2.is(itemstack1.getItem())) itemstack2.grow(itemstack1.getCount());
	         if (itemstack.is(Blocks.WET_SPONGE.asItem()) && !p_155028_.get(1).isEmpty() && p_155028_.get(1).is(Items.BUCKET)) p_155028_.set(1, new ItemStack(Items.WATER_BUCKET));
	         itemstack.shrink(1);
	         return true;
	      } else return false;
	}
	public static boolean isFuel(ItemStack p_58400_) {
	      return ForgeHooks.getBurnTime(p_58400_, null) > 0;
	}
	@Override
	public int[] getSlotsForFace(Direction p_58363_) {
	      if (p_58363_ == Direction.DOWN) return SLOTS_FOR_DOWN;
	      else return p_58363_ == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
	}
	@Override
	public boolean canPlaceItemThroughFace(int p_58336_, ItemStack p_58337_, @Nullable Direction p_58338_) {
	      return this.canPlaceItem(p_58336_, p_58337_);
	}
	@Override
	public boolean canTakeItemThroughFace(int p_58392_, ItemStack p_58393_, Direction p_58394_) {
	      if (p_58394_ == Direction.DOWN && p_58392_ == 1) return p_58393_.is(Items.WATER_BUCKET) || p_58393_.is(Items.BUCKET);
	      else return true;
	}
	@Override
	public int getContainerSize() {
		return this.items.size();
	}
	@Override
	public boolean isEmpty() {
	      for(ItemStack itemstack : this.items) if (!itemstack.isEmpty()) return false;
	      return true;
	}
	@Override
	public ItemStack getItem(int p_58328_) {
	      return this.items.get(p_58328_);
	}
	@Override
	public ItemStack removeItem(int p_58330_, int p_58331_) {
	      return ContainerHelper.removeItem(this.items, p_58330_, p_58331_);
	}
	@Override
	public ItemStack removeItemNoUpdate(int p_58387_) {
	      return ContainerHelper.takeItem(this.items, p_58387_);
	}
	@Override
	public void setItem(int p_58333_, ItemStack p_58334_) {
	      ItemStack itemstack = this.items.get(p_58333_);
	      boolean flag = !p_58334_.isEmpty() && ItemStack.isSameItem(p_58334_, itemstack) && ItemStack.isSameItem(p_58334_, itemstack);
	      this.items.set(p_58333_, p_58334_);
	      if (p_58334_.getCount() > this.getMaxStackSize()) p_58334_.setCount(this.getMaxStackSize());
	      if (p_58333_ == 0 && !flag) {
	         this.cookingTotalTime = getTotalCookTime(this.level, this);
	         this.cookingProgress = 0;
	         this.setChanged();
	      }
	}
	@Override
	public boolean stillValid(Player p_58340_) {
	      if (this.level.getBlockEntity(this.worldPosition) != this) return false;
	      else return p_58340_.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
	}
	@Override
	public boolean canPlaceItem(int p_58389_, ItemStack p_58390_) {
	      if (p_58389_ == 2) return false;
	      else if (p_58389_ != 1) return true;
	      else {
	         ItemStack itemstack = this.items.get(1);
	         return ForgeHooks.getBurnTime(p_58390_, RecipeType.SMELTING) > 0 || p_58390_.is(Items.BUCKET) && !itemstack.is(Items.BUCKET);
	      }
	}
	@Override
	public void clearContent() {
		this.items.clear();
	}
	@Override
	public void setRecipeUsed(@Nullable Recipe<?> p_58345_) {
	      if (p_58345_ != null) {
	         ResourceLocation resourcelocation = p_58345_.getId();
	         this.recipesUsed.addTo(resourcelocation, 1);
	      }
	}
	@Override @Nullable
	public Recipe<?> getRecipeUsed() {return null;}

	@Override
	public void awardUsedRecipes(Player p_281647_, List<ItemStack> p_282578_) {
		RecipeHolder.super.awardUsedRecipes(p_281647_, p_282578_);
	}

	@Override
	public boolean setRecipeUsed(Level level, ServerPlayer player, Recipe<?> recipe) {
		List<Recipe<?>> list = this.getRecipesToAwardAndPopExperience(player.serverLevel(), player.position());
		player.awardRecipes(list);
		this.recipesUsed.clear();
		return RecipeHolder.super.setRecipeUsed(level, player, recipe);
	}

	public List<Recipe<?>> getRecipesToAwardAndPopExperience(ServerLevel p_154996_, Vec3 p_154997_) {
	      List<Recipe<?>> list = Lists.newArrayList();
	      for(Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
	         p_154996_.getRecipeManager().byKey(entry.getKey()).ifPresent((p_155023_) -> {
	            list.add(p_155023_);
	            createExperience(p_154996_, p_154997_, entry.getIntValue(), ((AbstractCookingRecipe)p_155023_).getExperience());
	         });
	      }
	      return list;
	}
	private static void createExperience(ServerLevel p_154999_, Vec3 p_155000_, int p_155001_, float p_155002_) {
	      int i = Mth.floor((float)p_155001_ * p_155002_);
	      float f = Mth.frac((float)p_155001_ * p_155002_);
	      if (f != 0.0F && Math.random() < (double)f) ++i;
	      ExperienceOrb.award(p_154999_, p_155000_, i);
	}
	@Override
	public void fillStackedContents(StackedContents p_58342_) {
	      for(ItemStack itemstack : this.items) p_58342_.accountStack(itemstack);
	}
	LazyOptional<? extends IItemHandler>[] handlers =
	           SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
	      if (!this.remove && facing != null && capability == ForgeCapabilities.ITEM_HANDLER) {
	         if (facing == Direction.UP) return handlers[0].cast();
	         else if (facing == Direction.DOWN) return handlers[1].cast();
	         else return handlers[2].cast();
	      }
	      return super.getCapability(capability, facing);
	}
	@Override
	public void invalidateCaps() {
	      super.invalidateCaps();
	      for (int x = 0; x < handlers.length; x++)handlers[x].invalidate();
	}
	@Override
	public void reviveCaps() {
	      super.reviveCaps();
	      this.handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
	}
}