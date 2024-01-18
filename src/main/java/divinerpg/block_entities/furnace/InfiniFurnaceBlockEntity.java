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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;

public abstract class InfiniFurnaceBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible {
	private static final int[] SLOTS_FOR_UP = new int[]{0};
	private static final int[] SLOTS_FOR_DOWN = new int[]{1};
	public final RecipeManager.CachedCheck<Container, ? extends AbstractCookingRecipe> quickCheck = RecipeManager.createCheck(RecipeType.SMELTING);;
	private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
	protected NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);
	int cookingTotalTime, cookingProgress;
	protected final ContainerData dataAccess = new ContainerData() {
	      public int get(int type) {
	    	  return type == 0 ? InfiniFurnaceBlockEntity.this.cookingProgress : InfiniFurnaceBlockEntity.this.cookingTotalTime;
	      }
	      public void set(int type, int value) {
	    	  if(type == 0) InfiniFurnaceBlockEntity.this.cookingProgress = value;
	    	  else InfiniFurnaceBlockEntity.this.cookingTotalTime = value;
	      }
	      public int getCount() {return 2;}
	};
	
	public final String containerName;
	public final double speed;
	public boolean isLit = false;
	protected InfiniFurnaceBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, String containerName, double speed) {
		super(type, pos, state);
		this.containerName = containerName;
		this.speed = speed;
	}
	@Override public int getContainerSize() {return items.size();}
	@Override public ItemStack getItem(int slot) {return items.get(slot);}
	@Override public void clearContent() {this.items.clear();}
	@Nullable @Override public RecipeHolder<?> getRecipeUsed() {return null;}
	@Override public void setRecipeUsed(@Nullable RecipeHolder<?> recipeHolder) {if (recipeHolder != null) {ResourceLocation resourcelocation = recipeHolder.id();this.recipesUsed.addTo(resourcelocation, 1);}}
	@Override public boolean canPlaceItemThroughFace(int i, ItemStack stack, Direction direction) {return canPlaceItem(i, stack);}
	@Override public boolean canTakeItemThroughFace(int i, ItemStack stack, Direction direction) {return true;}
	@Override public boolean canPlaceItem(int slot, ItemStack stack) {return slot != 1;}
	@Override public void awardUsedRecipes(Player p_281647_, List<ItemStack> p_282578_) { RecipeCraftingHolder.super.awardUsedRecipes(p_281647_, p_282578_); }

	@Override
	public boolean isEmpty() {
		for(ItemStack itemstack : items) if (!itemstack.isEmpty()) return false;
		return true;
	}
	@Override
	public ItemStack removeItem(int i, int j) {
		return ContainerHelper.removeItem(items, i, j);
	}
	@Override
	public ItemStack removeItemNoUpdate(int slot) {
		return ContainerHelper.takeItem(items, slot);
	}
	@Override
	public void setItem(int slot, ItemStack stack) {
		ItemStack itemstack = items.get(slot);
		boolean flag = !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack) && ItemStack.isSameItem(stack, itemstack);
	    items.set(slot, stack);
	    if (stack.getCount() > getMaxStackSize()) stack.setCount(getMaxStackSize());
	    if (slot == 0 && !flag) {
	    	cookingTotalTime = getTotalCookTime(level, this);
	        cookingProgress = 0;
	        setChanged();
	    }
	}
	public static int getTotalCookTime(Level level, InfiniFurnaceBlockEntity tile) {
		return (int) (tile.quickCheck.getRecipeFor(tile, level).map(holder -> holder.value().getCookingTime()).orElse(200) / tile.speed);
	}
	@Override
	public boolean stillValid(Player player) {
		if (level.getBlockEntity(worldPosition) != this) return false;
	    else return player.distanceToSqr((double)worldPosition.getX() + 0.5D, (double)worldPosition.getY() + 0.5D, (double)worldPosition.getZ() + 0.5D) <= 64.0D;
	}
	@Override
	public void fillStackedContents(StackedContents contents) {
		for(ItemStack itemstack : items) contents.accountStack(itemstack);
	}
	@Override
	public int[] getSlotsForFace(Direction direction) {
		return direction == Direction.DOWN ? SLOTS_FOR_DOWN : SLOTS_FOR_UP;
	}
	@Override
	protected Component getDefaultName() {
		return Component.translatable(containerName);
	}


	public void awardUsedRecipesAndPopExperience(ServerPlayer p_155004_) {
		List<RecipeHolder<?>> list = this.getRecipesToAwardAndPopExperience(p_155004_.serverLevel(), p_155004_.position());
		p_155004_.awardRecipes(list);

		for(RecipeHolder<?> recipeholder : list) {
			if (recipeholder != null) {
				p_155004_.triggerRecipeCrafted(recipeholder, this.items);
			}
		}

		this.recipesUsed.clear();
	}

	public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(ServerLevel p_154996_, Vec3 p_154997_) {
		List<RecipeHolder<?>> list = Lists.newArrayList();

		for(Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
			p_154996_.getRecipeManager().byKey(entry.getKey()).ifPresent(p_300839_ -> {
				list.add(p_300839_);
				createExperience(p_154996_, p_154997_, entry.getIntValue(), ((AbstractCookingRecipe)p_300839_.value()).getExperience());
			});
		}

		return list;
	}

	private static void createExperience(ServerLevel level, Vec3 position, int entry, float amount) {
		int xpAmount = Mth.floor((float) entry * amount);
		float xpFraction = Mth.frac((float) entry * amount);
		if (xpFraction != 0.0F && Math.random() < (double) xpFraction) {
			++xpAmount;
		}

		ExperienceOrb.award(level, position, xpAmount);
	}

	@Override
	public boolean setRecipeUsed(Level level, ServerPlayer player, RecipeHolder<?> recipe) {
		List<RecipeHolder<?>> recipesToAward = getRecipesToAwardAndPopExperience(player.serverLevel(), player.position());
		player.awardRecipes(recipesToAward);
		recipesUsed.clear();
		return RecipeCraftingHolder.super.setRecipeUsed(level, player, recipe);
	}


	public static void serverTick(Level level, BlockPos pos, BlockState state, InfiniFurnaceBlockEntity block) {
		boolean changes = false;
		RecipeHolder<?> recipe = block.quickCheck.getRecipeFor(block, level).orElse(null);
        int maxStackSize = block.getMaxStackSize();
		if(block.isLit) {
	        if (block.canBurn(recipe, maxStackSize)) {
	            ++block.cookingProgress;
	            if (block.cookingProgress >= block.cookingTotalTime) {
		            block.cookingProgress = 0;
		            block.cookingTotalTime = getTotalCookTime(level, block);
		            if (block.burn(recipe, maxStackSize)) block.setRecipeUsed(recipe);
	            }
	        } else {
	        	block.isLit = false;
	        	changes = true;
	        }
		} else if(block.canLight(recipe, maxStackSize)) {
			block.isLit = true;
			changes = true;
		} else if (block.cookingProgress > 0) block.cookingProgress = Mth.clamp(block.cookingProgress - 2, 0, block.cookingTotalTime);
		if(block instanceof CoalstoneFurnaceBlockEntity && !block.isLit && level.getBlockState(pos.relative(state.getValue(AbstractFurnaceBlock.FACING).getOpposite())).is(Blocks.MAGMA_BLOCK)) {
			block.isLit = true;
			changes = true;
		}
		if(changes) {
	         state = state.setValue(AbstractFurnaceBlock.LIT, block.isLit);
	         level.setBlock(pos, state, 3);
	         setChanged(level, pos, state);
		}
	}
	public boolean canLight(@Nullable RecipeHolder<?> recipe, int maxStackSize) {
		return !items.get(0).isEmpty() && canBurn(recipe, maxStackSize);
	}
	private boolean canBurn(@Nullable RecipeHolder<?> recipe, int i) {
		if (recipe != null) {
			@SuppressWarnings("unchecked")
			ItemStack itemstack = ((RecipeHolder<Recipe<WorldlyContainer>>) recipe).value().assemble(this, level.registryAccess());
	        if (itemstack.isEmpty()) return false;
	        else {
	            ItemStack itemstack1 = items.get(1);
	            if (itemstack1.isEmpty()) return true;
	            else if (!ItemStack.isSameItem(itemstack1, itemstack)) return false;
	            else if (itemstack1.getCount() + itemstack.getCount() <= i && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) return true; // Forge fix: make furnace respect stack sizes in furnace recipes
	            else return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
	        }
		} else return false;
	}
	private boolean burn(@Nullable RecipeHolder<?> recipe, int maxStackSize) {
	      if (canBurn(recipe, maxStackSize)) {
	         @SuppressWarnings("unchecked")
			ItemStack itemstack = items.get(0), itemstack1 = ((RecipeHolder<Recipe<WorldlyContainer>>) recipe).value().assemble(this, level.registryAccess()), itemstack2 = items.get(1);
	         if (itemstack2.isEmpty()) items.set(1, itemstack1.copy());
	         else if (itemstack2.is(itemstack1.getItem())) itemstack2.grow(itemstack1.getCount());
	         itemstack.shrink(1);
	         return true;
	      } else return false;
	}
	@Override
	public void load(CompoundTag tag) {
	      super.load(tag);
	      items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
	      ContainerHelper.loadAllItems(tag, items);
	      isLit = tag.getBoolean("isLit");
	      cookingProgress = tag.getInt("CookTime");
	      cookingTotalTime = tag.getInt("CookTimeTotal");
	      CompoundTag compoundtag = tag.getCompound("RecipesUsed");
	      for(String s : compoundtag.getAllKeys()) recipesUsed.put(new ResourceLocation(s), compoundtag.getInt(s));
	}
	@Override
	protected void saveAdditional(CompoundTag tag) {
	      super.saveAdditional(tag);
	      tag.putBoolean("isLit", isLit);
	      tag.putInt("CookTime", cookingProgress);
	      tag.putInt("CookTimeTotal", cookingTotalTime);
	      ContainerHelper.saveAllItems(tag, items);
	      CompoundTag compoundtag = new CompoundTag();
	      recipesUsed.forEach((p_187449_, p_187450_) -> {
	         compoundtag.putInt(p_187449_.toString(), p_187450_);
	      });
	      tag.put("RecipesUsed", compoundtag);
	}

	//TODO - cap handlers
//	LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
//	@Override
//	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
//		if (!this.remove && facing != null && capability == ForgeCapabilities.ITEM_HANDLER) {
//	         if (facing == Direction.UP)
//	            return handlers[0].cast();
//	         else if (facing == Direction.DOWN)
//	            return handlers[1].cast();
//	         else
//	            return handlers[2].cast();
//	      }
//	      return super.getCapability(capability, facing);
//	}
//	@Override
//	public void invalidateCaps() {
//		super.invalidateCaps();
//		for (int x = 0; x < handlers.length; x++) handlers[x].invalidate();
//	}
//	@Override
//	public void reviveCaps() {
//		super.reviveCaps();
//		handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
//	}
}