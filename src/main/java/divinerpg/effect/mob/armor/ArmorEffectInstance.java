package divinerpg.effect.mob.armor;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;

public class ArmorEffectInstance extends MobEffectInstance {
	public ArmorEffectInstance(MobEffect effect, int amplifier) {
		super(effect, -1, amplifier, false, false);
	}
	public ArmorEffectInstance(MobEffect effect, int amplifier, boolean ambient, boolean visible) {
		super(effect, -1, amplifier, ambient, visible);
	}
	public ArmorEffectInstance(MobEffect effect, int amplifier, boolean ambient, boolean visible, boolean showIcon) {
		super(effect, -1, amplifier, ambient, visible, showIcon);
	}
	@Override public List<ItemStack> getCurativeItems() {return new ArrayList<ItemStack>();}
	@Override public boolean isCurativeItem(ItemStack stack) {return false;}
	@Override public void addCurativeItem(ItemStack stack) {}
	@Override public void setCurativeItems(List<ItemStack> curativeItems) {}
	@Override public void writeCurativeItems(CompoundTag nbt) {}
	@Override public boolean isVisible() {return false;}
	@Override public boolean showIcon() {return false;}
}