package divinerpg.client.menu;

import divinerpg.blocks.vanilla.BlockAltarOfCorruption;
import divinerpg.registries.*;
import net.minecraft.Util;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.*;
import net.minecraft.core.registries.*;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.*;
import net.minecraft.stats.Stats;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.EventHooks;

import java.util.List;
import java.util.Optional;

public class AltarOfCorruptionMenu extends AbstractContainerMenu {
    private final Container enchantSlots = new SimpleContainer(2) {
        public void setChanged() {
            super.setChanged();
            AltarOfCorruptionMenu.this.slotsChanged(this);
        }
    };
    private final ContainerLevelAccess access;
    private final RandomSource random = RandomSource.create();
    private final DataSlot enchantmentSeed = DataSlot.standalone();
    public final int[] costs = new int[3];
    public final int[] enchantClue = new int[]{-1, -1, -1};
    public final int[] levelClue = new int[]{-1, -1, -1};

    public AltarOfCorruptionMenu(int p_39454_, Inventory p_39455_) {
        this(p_39454_, p_39455_, ContainerLevelAccess.NULL);
    }

    public AltarOfCorruptionMenu(int p_39457_, Inventory p_39458_, ContainerLevelAccess p_39459_) {
        super(MenuTypeRegistry.ALTAR_OF_CORRUPTION.get(), p_39457_);
        this.access = p_39459_;
        this.addSlot(new Slot(this.enchantSlots, 0, 15, 47) {
            public boolean mayPlace(ItemStack p_39508_) {
                return true;
            }

            public int getMaxStackSize() {
                return 1;
            }
        });
        this.addSlot(new Slot(this.enchantSlots, 1, 35, 47) {
            public boolean mayPlace(ItemStack p_39517_) {
                return p_39517_.is(Tags.Items.ENCHANTING_FUELS);
            }
        });

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(p_39458_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(p_39458_, k, 8 + k * 18, 142));
        }

        this.addDataSlot(DataSlot.shared(this.costs, 0));
        this.addDataSlot(DataSlot.shared(this.costs, 1));
        this.addDataSlot(DataSlot.shared(this.costs, 2));
        this.addDataSlot(this.enchantmentSeed).set(p_39458_.player.getEnchantmentSeed());
        this.addDataSlot(DataSlot.shared(this.enchantClue, 0));
        this.addDataSlot(DataSlot.shared(this.enchantClue, 1));
        this.addDataSlot(DataSlot.shared(this.enchantClue, 2));
        this.addDataSlot(DataSlot.shared(this.levelClue, 0));
        this.addDataSlot(DataSlot.shared(this.levelClue, 1));
        this.addDataSlot(DataSlot.shared(this.levelClue, 2));
    }

    public AltarOfCorruptionMenu(int i, Inventory inventory, FriendlyByteBuf buf) {
        this(i, inventory, ContainerLevelAccess.NULL);
    }

	public void slotsChanged(Container p_39461_) {
        if (p_39461_ == this.enchantSlots) {
            ItemStack itemstack = p_39461_.getItem(0);
            if (!itemstack.isEmpty() && itemstack.isEnchantable()) {
                this.access.execute((p_39485_, p_39486_) -> {
                	IdMap<Holder<Enchantment>> idmap = p_39485_.registryAccess().registryOrThrow(Registries.ENCHANTMENT).asHolderIdMap();
                    float j = 30;

                    for(BlockPos blockpos : BlockAltarOfCorruption.BOOKSHELF_OFFSETS) {
                        if (BlockAltarOfCorruption.isValidBookShelf(p_39485_, p_39486_, blockpos)) {
                            j += p_39485_.getBlockState(p_39486_.offset(blockpos)).getEnchantPowerBonus(p_39485_, p_39486_.offset(blockpos));
                        }
                    }

                    this.random.setSeed((long)this.enchantmentSeed.get());

                    for(int k = 0; k < 3; ++k) {
                        this.costs[k] = EnchantmentHelper.getEnchantmentCost(this.random, k, (int)j, itemstack);
                        this.enchantClue[k] = -1;
                        this.levelClue[k] = -1;
                        if (this.costs[k] < k + 1) {
                            this.costs[k] = 0;
                        }
                        this.costs[k] = EventHooks.onEnchantmentLevelSet(p_39485_, p_39486_, k, (int)j, itemstack, costs[k]);
                    }

                    for(int l = 0; l < 3; ++l) {
                        if (this.costs[l] > 0) {
                            List<EnchantmentInstance> list = this.getEnchantmentList(p_39485_.registryAccess(), itemstack, l, this.costs[l]);
                            if (list != null && !list.isEmpty()) {
                                EnchantmentInstance enchantmentinstance = list.get(this.random.nextInt(list.size()));
                                this.enchantClue[l] = idmap.getId(enchantmentinstance.enchantment);
                                this.levelClue[l] = enchantmentinstance.level;
                            }
                        }
                    }

                    this.broadcastChanges();
                });
            } else {
                for(int i = 0; i < 3; ++i) {
                    this.costs[i] = 0;
                    this.enchantClue[i] = -1;
                    this.levelClue[i] = -1;
                }
            }
        }

    }


    public boolean clickMenuButton(Player p_39465_, int p_39466_) {
        if (p_39466_ >= 0 && p_39466_ < this.costs.length) {
            ItemStack itemstack = this.enchantSlots.getItem(0);
            ItemStack itemstack1 = this.enchantSlots.getItem(1);
            int i = p_39466_ + 1;
            if ((itemstack1.isEmpty() || itemstack1.getCount() < i) && !p_39465_.getAbilities().instabuild) {
                return false;
            } else if (this.costs[p_39466_] <= 0 || itemstack.isEmpty() || (p_39465_.experienceLevel < i || p_39465_.experienceLevel < this.costs[p_39466_]) && !p_39465_.getAbilities().instabuild) {
                return false;
            } else {
                this.access.execute((p_39481_, p_39482_) -> {
                    ItemStack itemstack2 = itemstack;
                    List<EnchantmentInstance> list = this.getEnchantmentList(p_39481_.registryAccess(), itemstack, p_39466_, this.costs[p_39466_]);
                    if (!list.isEmpty()) {
                        p_39465_.onEnchantmentPerformed(itemstack, i);
                        itemstack2 = itemstack.getItem().applyEnchantments(itemstack, list);
                        this.enchantSlots.setItem(0, itemstack2);
                        net.neoforged.neoforge.common.CommonHooks.onPlayerEnchantItem(p_39465_, itemstack2, list);

                        itemstack1.consume(i, p_39465_);
                        if (itemstack1.isEmpty()) {
                            this.enchantSlots.setItem(1, ItemStack.EMPTY);
                        }

                        p_39465_.awardStat(Stats.ENCHANT_ITEM);
                        if (p_39465_ instanceof ServerPlayer) {
                            CriteriaTriggers.ENCHANTED_ITEM.trigger((ServerPlayer)p_39465_, itemstack2, i);
                        }

                        this.enchantSlots.setChanged();
                        this.enchantmentSeed.set(p_39465_.getEnchantmentSeed());
                        this.slotsChanged(this.enchantSlots);
                        p_39481_.playSound(
                            null, p_39482_, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1.0F, p_39481_.random.nextFloat() * 0.1F + 0.9F
                        );
                    }

                });
                return true;
            }
        } else {
            Util.logAndPauseIfInIde(p_39465_.getName() + " pressed invalid button id: " + p_39466_);
            return false;
        }
    }

    private List<EnchantmentInstance> getEnchantmentList(RegistryAccess registryAccess, ItemStack stack, int slot, int cost) {
    	this.random.setSeed((long)(this.enchantmentSeed.get() + slot));
        Optional<HolderSet.Named<Enchantment>> optional = registryAccess.registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE);
        if (optional.isEmpty()) {
            return List.of();
        } else {
            List<EnchantmentInstance> list = EnchantmentHelper.selectEnchantment(this.random, stack, cost, optional.get().stream());
            if (stack.is(Items.BOOK) && list.size() > 1) {
                list.remove(this.random.nextInt(list.size()));
            }

            return list;
        }
    }

    public int getGoldCount() {
        ItemStack itemstack = this.enchantSlots.getItem(1);
        return itemstack.isEmpty() ? 0 : itemstack.getCount();
    }

    public int getEnchantmentSeed() {
        return this.enchantmentSeed.get();
    }

    public void removed(Player p_39488_) {
        super.removed(p_39488_);
        this.access.execute((p_39469_, p_39470_) -> {
            this.clearContainer(p_39488_, this.enchantSlots);
        });
    }

    public boolean stillValid(Player p_39463_) {
        return stillValid(this.access, p_39463_, BlockRegistry.altarOfCorruption.get());
    }

    public ItemStack quickMoveStack(Player p_39490_, int p_39491_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_39491_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (p_39491_ == 0) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (p_39491_ == 1) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (itemstack1.is(Tags.Items.ENCHANTING_FUELS)) {
                if (!this.moveItemStackTo(itemstack1, 1, 2, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (this.slots.get(0).hasItem() || !this.slots.get(0).mayPlace(itemstack1)) {
                    return ItemStack.EMPTY;
                }

                ItemStack itemstack2 = itemstack1.copyWithCount(1);
                itemstack1.shrink(1);
                this.slots.get(0).setByPlayer(itemstack2);
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(p_39490_, itemstack1);
        }

        return itemstack;
    }
}
