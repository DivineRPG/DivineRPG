package divinerpg.capability;

import javax.annotation.*;

import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;

public class DimensionalInventoryProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static final Capabilities<DimensionalInventory> DIMENSIONAL_INVENTORY = CapabilityManager.get(new CapabilityToken<>(){});
	private DimensionalInventory dimensionalInventory = null;
	private final LazyOptional<DimensionalInventory> opt = LazyOptional.of(this::getOrCreateDimensionalInventory);
	@Nonnull private DimensionalInventory getOrCreateDimensionalInventory() {
		if(dimensionalInventory == null) dimensionalInventory = new DimensionalInventory();
		return dimensionalInventory;
	}
    @Nonnull @Override public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
    	return DIMENSIONAL_INVENTORY.orEmpty(cap, opt);
    }
	@Override public CompoundTag serializeNBT(HolderLookup.Provider provider) {
        return getOrCreateDimensionalInventory().serializeNBT(provider);
    }
    @Override public void deserializeNBT(HolderLookup.Provider provider, CompoundTag nbt) {
    	getOrCreateDimensionalInventory().deserializeNBT(provider, nbt);
    }
}
