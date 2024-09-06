package divinerpg.block_entities.furnace;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.*;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
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

import javax.annotation.Nullable;
import java.util.List;

public abstract class ModFurnaceBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible {
	private static final int[] SLOTS_FOR_UP = new int[]{0}, SLOTS_FOR_DOWN = new int[]{2, 1}, SLOTS_FOR_SIDES = new int[]{1};
	public final RecipeManager.CachedCheck<SingleRecipeInput, ? extends AbstractCookingRecipe> quickCheck = RecipeManager.createCheck(RecipeType.SMELTING);
	private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
	protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
	public final String containerName;
	public final double speed;
	int litTime, litDuration, cookingProgress, cookingTotalTime;
	protected final ContainerData dataAccess = new ContainerData() {
	      public int get(int p_58431_) {
			  return switch (p_58431_) {
				  case 0 -> ModFurnaceBlockEntity.this.litTime;
				  case 1 -> ModFurnaceBlockEntity.this.litDuration;
				  case 2 -> ModFurnaceBlockEntity.this.cookingProgress;
				  case 3 -> ModFurnaceBlockEntity.this.cookingTotalTime;
				  default -> 0;
			  };
	      }
	      public void set(int p_58433_, int p_58434_) {
			  switch (p_58433_) {
				  case 0 -> ModFurnaceBlockEntity.this.litTime = p_58434_;
				  case 1 -> ModFurnaceBlockEntity.this.litDuration = p_58434_;
				  case 2 -> ModFurnaceBlockEntity.this.cookingProgress = p_58434_;
				  case 3 -> ModFurnaceBlockEntity.this.cookingTotalTime = p_58434_;
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
	    else return (int)(stack.getBurnTime(RecipeType.SMELTING) / speed);
	}
	public static int getTotalCookTime(Level level, ModFurnaceBlockEntity tile) {
		return (int) (tile.quickCheck.getRecipeFor(new SingleRecipeInput(tile.getItem(0)), level).map(mapper -> mapper.value().getCookingTime()).orElse(200) / tile.speed);
	}
	public boolean isLit() {return this.litTime > 0;}
	@Override
	public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
	      super.loadAdditional(tag, registries);
	      items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
	      ContainerHelper.loadAllItems(tag, items, registries);
	      litTime = tag.getInt("BurnTime");
	      cookingProgress = tag.getInt("CookTime");
	      cookingTotalTime = tag.getInt("CookTimeTotal");
	      litDuration = getBurnDuration(items.get(1));
	      CompoundTag compoundtag = tag.getCompound("RecipesUsed");
	      for(String s : compoundtag.getAllKeys()) recipesUsed.put(ResourceLocation.withDefaultNamespace(s), compoundtag.getInt(s));
	}
	@Override
	protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
	      super.saveAdditional(tag, registries);
	      tag.putInt("BurnTime", this.litTime);
	      tag.putInt("CookTime", this.cookingProgress);
	      tag.putInt("CookTimeTotal", this.cookingTotalTime);
	      ContainerHelper.saveAllItems(tag, items, registries);
	      CompoundTag compoundtag = new CompoundTag();
	      this.recipesUsed.forEach((p_187449_, p_187450_) -> {
	         compoundtag.putInt(p_187449_.toString(), p_187450_);
	      });
	      tag.put("RecipesUsed", compoundtag);
	}
	public static void serverTick(Level level, BlockPos pos, BlockState state, ModFurnaceBlockEntity block) {
	      boolean flag = block.isLit();
	      boolean flag1 = false;
	      if (block.isLit()) --block.litTime;
	      ItemStack itemstack = block.items.get(1);
	      boolean flag2 = !block.items.get(0).isEmpty();
	      boolean flag3 = !itemstack.isEmpty();
	      if (block.isLit() || flag3 && flag2) {
	         RecipeHolder<?> recipe;
	         if (flag2) recipe = block.quickCheck.getRecipeFor(new SingleRecipeInput(block.items.get(0)), level).orElse(null);
	         else recipe = null;
	         int maxStackSize = block.getMaxStackSize();
	         if (!block.isLit() && block.canBurn(level.registryAccess(), recipe, block.items, maxStackSize, block)) {
	            block.litTime = block.getBurnDuration(itemstack);
	            block.litDuration = block.litTime;
	            if (block.isLit()) {
	               flag1 = true;
	               if (itemstack.hasCraftingRemainingItem()) block.items.set(1, itemstack.getCraftingRemainingItem());
	               else if (flag3) {
	                  itemstack.shrink(1);
	                  if (itemstack.isEmpty()) block.items.set(1, itemstack.getCraftingRemainingItem());
	               }
	            }
	         }
	         if(block.isLit() && block.canBurn(level.registryAccess(), recipe, block.items, maxStackSize, block)) {
	            ++block.cookingProgress;
	            if (block.cookingProgress == block.cookingTotalTime) {
	               block.cookingProgress = 0;
	               block.cookingTotalTime = getTotalCookTime(level, block);
	               if(block.burn(level.registryAccess(), recipe, block.items, maxStackSize, block)) block.setRecipeUsed(recipe);
	               flag1 = true;
	            }
	         } else block.cookingProgress = 0;
	      } else if (!block.isLit() && block.cookingProgress > 0) block.cookingProgress = Mth.clamp(block.cookingProgress - 2, 0, block.cookingTotalTime);
	      if (flag != block.isLit()) {
	         flag1 = true;
	         state = state.setValue(AbstractFurnaceBlock.LIT, Boolean.valueOf(block.isLit()));
	         level.setBlock(pos, state, 3);
	      }
	      if (flag1) setChanged(level, pos, state);
	}
	private boolean canBurn(RegistryAccess registryAccess, @Nullable RecipeHolder<?> recipe, NonNullList<ItemStack> inventory, int maxStackSize, ModFurnaceBlockEntity furnace) {
		if(!inventory.get(0).isEmpty() && recipe != null) {
			@SuppressWarnings("unchecked")
			ItemStack itemstack = ((RecipeHolder<? extends AbstractCookingRecipe>) recipe).value().assemble(new SingleRecipeInput(furnace.getItem(0)), registryAccess);
	        if(itemstack.isEmpty()) return false;
	        else {
	            ItemStack itemstack1 = items.get(2);
	            if(itemstack1.isEmpty()) return true;
	            else if(!ItemStack.isSameItemSameComponents(itemstack1, itemstack)) return false;
	            else if(itemstack1.getCount() + itemstack.getCount() <= maxStackSize && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) return true;
	            else return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
	        }
		} else return false;
	}
	private boolean burn(RegistryAccess registryAccess, @Nullable RecipeHolder<?> recipe, NonNullList<ItemStack> inventory, int maxStackSize, ModFurnaceBlockEntity furnace) {
		if(recipe != null && canBurn(registryAccess, recipe, inventory, maxStackSize, furnace)) {
            ItemStack itemstack = inventory.get(0);
            @SuppressWarnings("unchecked")
			ItemStack itemstack1 = ((RecipeHolder<? extends AbstractCookingRecipe>) recipe).value().assemble(new SingleRecipeInput(furnace.getItem(0)), registryAccess);
            ItemStack itemstack2 = inventory.get(2);
            if(itemstack2.isEmpty()) inventory.set(2, itemstack1.copy());
            else if(ItemStack.isSameItemSameComponents(itemstack2, itemstack1)) itemstack2.grow(itemstack1.getCount());
            if(itemstack.is(Blocks.WET_SPONGE.asItem()) && !inventory.get(1).isEmpty() && inventory.get(1).is(Items.BUCKET)) inventory.set(1, new ItemStack(Items.WATER_BUCKET));
            itemstack.shrink(1);
            return true;
        } else return false;
	}
	public boolean isFuel(ItemStack stack) {
	      return stack.getBurnTime(null) > 0;
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
	@Override protected NonNullList<ItemStack> getItems() {return items;}
	@Override protected void setItems(NonNullList<ItemStack> items) {this.items = items;}
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
	public boolean canPlaceItem(int p_58389_, ItemStack stack) {
	      if (p_58389_ == 2) return false;
	      else if (p_58389_ != 1) return true;
	      else {
	         ItemStack itemstack = this.items.get(1);
	         return stack.getBurnTime(RecipeType.SMELTING) > 0 || stack.is(Items.BUCKET) && !itemstack.is(Items.BUCKET);
	      }
	}
	@Override
	public void clearContent() {
		this.items.clear();
	}
	@Override public void setRecipeUsed(RecipeHolder<?> recipe) {if(recipe != null) recipesUsed.addTo(recipe.id(), 1);}
	@Nullable @Override public RecipeHolder<?> getRecipeUsed() {return null;}
	@Override public void awardUsedRecipes(Player p_281647_, List<ItemStack> p_282578_) {}
	public void awardUsedRecipesAndPopExperience(ServerPlayer player) {
		List<RecipeHolder<?>> list = getRecipesToAwardAndPopExperience(player.serverLevel(), player.position());
        player.awardRecipes(list);
        for(RecipeHolder<?> recipeholder : list) if(recipeholder != null) player.triggerRecipeCrafted(recipeholder, this.items);
        recipesUsed.clear();
	}
	public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(ServerLevel level, Vec3 position) {
		List<RecipeHolder<?>> list = Lists.newArrayList();
        for(Entry<ResourceLocation> entry : recipesUsed.object2IntEntrySet()) level.getRecipeManager().byKey(entry.getKey()).ifPresent(p_300839_ -> {
            list.add((RecipeHolder<?>)p_300839_);
            createExperience(level, position, entry.getIntValue(), ((AbstractCookingRecipe)p_300839_.value()).getExperience());
        });
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
	public void fillStackedContents(StackedContents p_58342_) {
	      for(ItemStack itemstack : this.items) p_58342_.accountStack(itemstack);
	}
}