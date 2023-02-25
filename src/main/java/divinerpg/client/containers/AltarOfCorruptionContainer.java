package divinerpg.client.containers;

import divinerpg.DivineRPG;
import divinerpg.registries.MenuTypeRegistry;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class AltarOfCorruptionContainer extends AbstractContainerMenu {
    private final Container enchantSlots = new SimpleContainer(2) {
        public void setChanged() {
            super.setChanged();
            AltarOfCorruptionContainer.this.slotsChanged(this);
        }
    };
    private final ContainerLevelAccess access;
    private final RandomSource random = RandomSource.create();
    private final DataSlot enchantmentSeed = DataSlot.standalone();
    public final int[] costs = new int[3];
    public final int[] enchantClue = new int[]{-1, -1, -1};
    public final int[] levelClue = new int[]{-1, -1, -1};

    public AltarOfCorruptionContainer(int p_i50085_1_, Inventory p_i50085_2_) {
        this(p_i50085_1_, p_i50085_2_, ContainerLevelAccess.NULL);
    }

    public AltarOfCorruptionContainer(int p_i50086_1_, Inventory p_i50086_2_, ContainerLevelAccess p_i50086_3_) {
        super(MenuTypeRegistry.ALTAR_OF_CORRUPTION.get(), p_i50086_1_);
        this.access = p_i50086_3_;
        this.addSlot(new Slot(this.enchantSlots, 0, 15, 47) {
            public boolean mayPlace(ItemStack p_75214_1_) {
                return true;
            }

            public int getMaxStackSize() {
                return 1;
            }
        });
        this.addSlot(new Slot(this.enchantSlots, 1, 35, 47) {
            public boolean mayPlace(ItemStack stack) {
                return stack.is(Tags.Items.GEMS);
            }
        });

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(p_i50086_2_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(p_i50086_2_, k, 8 + k * 18, 142));
        }

        this.addDataSlot(DataSlot.shared(this.costs, 0));
        this.addDataSlot(DataSlot.shared(this.costs, 1));
        this.addDataSlot(DataSlot.shared(this.costs, 2));
        this.addDataSlot(this.enchantmentSeed).set(p_i50086_2_.player.getEnchantmentSeed());
        this.addDataSlot(DataSlot.shared(this.enchantClue, 0));
        this.addDataSlot(DataSlot.shared(this.enchantClue, 1));
        this.addDataSlot(DataSlot.shared(this.enchantClue, 2));
        this.addDataSlot(DataSlot.shared(this.levelClue, 0));
        this.addDataSlot(DataSlot.shared(this.levelClue, 1));
        this.addDataSlot(DataSlot.shared(this.levelClue, 2));
    }

    public AltarOfCorruptionContainer(int i, Inventory playerInventory, FriendlyByteBuf packetBuffer) {
        this(i, playerInventory);
    }

    private float getPower(net.minecraft.world.level.Level world, net.minecraft.core.BlockPos pos) {
        return 30;
    }

    @SuppressWarnings("deprecation")
	public void slotsChanged(Container p_75130_1_) {
        if (p_75130_1_ == this.enchantSlots) {
            ItemStack itemstack = p_75130_1_.getItem(0);
            if (!itemstack.isEmpty() && itemstack.isEnchantable()) {
                this.access.execute((p_217002_2_, p_217002_3_) -> {
                    int power = 0;

                    for(int k = -1; k <= 1; ++k) {
                        for(int l = -1; l <= 1; ++l) {
                            if ((k != 0 || l != 0) && p_217002_2_.isEmptyBlock(p_217002_3_.offset(l, 0, k)) && p_217002_2_.isEmptyBlock(p_217002_3_.offset(l, 1, k))) {
                                power += getPower(p_217002_2_, p_217002_3_.offset(l * 2, 0, k * 2));
                                power += getPower(p_217002_2_, p_217002_3_.offset(l * 2, 1, k * 2));

                                if (l != 0 && k != 0) {
                                    power += getPower(p_217002_2_, p_217002_3_.offset(l * 2, 0, k));
                                    power += getPower(p_217002_2_, p_217002_3_.offset(l * 2, 1, k));
                                    power += getPower(p_217002_2_, p_217002_3_.offset(l, 0, k * 2));
                                    power += getPower(p_217002_2_, p_217002_3_.offset(l, 1, k * 2));
                                }
                            }
                        }
                    }

                    this.random.setSeed((long)this.enchantmentSeed.get());

                    for(int i1 = 0; i1 < 3; ++i1) {
                        this.costs[i1] = EnchantmentHelper.getEnchantmentCost(this.random, i1, (int)power, itemstack);
                        this.enchantClue[i1] = -1;
                        this.levelClue[i1] = -1;
                        if (this.costs[i1] < i1 + 1) {
                            this.costs[i1] = 0;
                        }
                        this.costs[i1] = net.minecraftforge.event.ForgeEventFactory.onEnchantmentLevelSet(p_217002_2_, p_217002_3_, i1, (int)power, itemstack, costs[i1]);
                    }

                    for(int j1 = 0; j1 < 3; ++j1) {
                        if (this.costs[j1] > 0) {
                            List<EnchantmentInstance> list = this.getEnchantmentList(itemstack, j1, this.costs[j1]);
                            if (list != null && !list.isEmpty()) {
                                EnchantmentInstance enchantmentdata = list.get(this.random.nextInt(list.size()));
                                this.enchantClue[j1] = Registry.ENCHANTMENT.getId(enchantmentdata.enchantment);
                                this.levelClue[j1] = enchantmentdata.level;
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

    public boolean clickMenuButton(Player p_75140_1_, int p_75140_2_) {
        ItemStack itemstack = this.enchantSlots.getItem(0);
        ItemStack itemstack1 = this.enchantSlots.getItem(1);
        int i = p_75140_2_ + 1;
        if ((itemstack1.isEmpty() || itemstack1.getCount() < i) && !p_75140_1_.abilities.instabuild) {
            return false;
        } else if (this.costs[p_75140_2_] <= 0 || itemstack.isEmpty() || (p_75140_1_.experienceLevel < i || p_75140_1_.experienceLevel < this.costs[p_75140_2_]) && !p_75140_1_.abilities.instabuild) {
            return false;
        } else {
            this.access.execute((p_217003_6_, p_217003_7_) -> {
                ItemStack itemstack2 = itemstack;
                List<EnchantmentInstance> list = this.getEnchantmentList(itemstack, p_75140_2_, this.costs[p_75140_2_]);
                if (!list.isEmpty()) {
                    p_75140_1_.onEnchantmentPerformed(itemstack, i);
                    boolean flag = itemstack.getItem() == Items.BOOK;
                    if (flag) {
                        itemstack2 = new ItemStack(Items.ENCHANTED_BOOK);
                        CompoundTag compoundnbt = itemstack.getTag();
                        if (compoundnbt != null) {
                            itemstack2.setTag(compoundnbt.copy());
                        }

                        this.enchantSlots.setItem(0, itemstack2);
                    }

                    for(int j = 0; j < list.size(); ++j) {
                        EnchantmentInstance enchantmentdata = list.get(j);
                        if (flag) {
                            EnchantedBookItem.addEnchantment(itemstack2, enchantmentdata);
                        } else {
                            itemstack2.enchant(enchantmentdata.enchantment, enchantmentdata.level);
                        }
                    }

                    if (!p_75140_1_.abilities.instabuild) {
                        itemstack1.shrink(i);
                        if (itemstack1.isEmpty()) {
                            this.enchantSlots.setItem(1, ItemStack.EMPTY);
                        }
                    }

                    p_75140_1_.awardStat(Stats.ENCHANT_ITEM);
                    if (p_75140_1_ instanceof ServerPlayer) {
                        CriteriaTriggers.ENCHANTED_ITEM.trigger((ServerPlayer)p_75140_1_, itemstack2, i);
                    }

                    this.enchantSlots.setChanged();
                    this.enchantmentSeed.set(p_75140_1_.getEnchantmentSeed());
                    this.slotsChanged(this.enchantSlots);
                    p_217003_6_.playSound((Player)null, p_217003_7_, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1.0F, p_217003_6_.random.nextFloat() * 0.1F + 0.9F);
                }

            });
            return true;
        }
    }

    private List<EnchantmentInstance> getEnchantmentList(ItemStack p_178148_1_, int p_178148_2_, int p_178148_3_) {
        this.random.setSeed((long)(this.enchantmentSeed.get() + p_178148_2_));
        List<EnchantmentInstance> list = EnchantmentHelper.selectEnchantment(this.random, p_178148_1_, p_178148_3_, false);
        if (p_178148_1_.getItem() == Items.BOOK && list.size() > 1) {
            list.remove(this.random.nextInt(list.size()));
        }

        return list;
    }

    @OnlyIn(Dist.CLIENT)
    public int getGoldCount() {
        ItemStack itemstack = this.enchantSlots.getItem(1);
        return itemstack.isEmpty() ? 0 : itemstack.getCount();
    }

    @OnlyIn(Dist.CLIENT)
    public int getEnchantmentSeed() {
        return this.enchantmentSeed.get();
    }

    public void removed(Player player) {
        super.removed(player);
        this.access.execute((p_39469_, p_39470_) -> {
            this.clearContainer(player, this.enchantSlots);
        });
    }

    public boolean stillValid(Player p_75145_1_) {
        return stillValid(this.access, p_75145_1_, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "altar_of_corruption")));
    }

    public ItemStack quickMoveStack(Player player, int slotId) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotId);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (slotId == 0) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (slotId == 1) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (itemstack1.is(Tags.Items.GEMS)) {
                if (!this.moveItemStackTo(itemstack1, 1, 2, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (this.slots.get(0).hasItem() || !this.slots.get(0).mayPlace(itemstack1)) {
                    return ItemStack.EMPTY;
                }

                ItemStack itemstack2 = itemstack1.copy();
                itemstack2.setCount(1);
                itemstack1.shrink(1);
                this.slots.get(0).set(itemstack2);
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }
}
