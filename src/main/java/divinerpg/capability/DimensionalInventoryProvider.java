package divinerpg.capability;

import javax.annotation.*;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.*;

public class DimensionalInventoryProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static final Capability<DimensionalInventory> DIMENIONAL_INVENTORY = CapabilityManager.get(new CapabilityToken<>(){});
	private DimensionalInventory dimensionalInventory = null;
	private final LazyOptional<DimensionalInventory> opt = LazyOptional.of(this::getOrCreateDimensionalInventory);
	@Nonnull private DimensionalInventory getOrCreateDimensionalInventory() {
		if(dimensionalInventory == null) dimensionalInventory = new DimensionalInventory();
		return dimensionalInventory;
	}
    @Nonnull @Override public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
    	return DIMENIONAL_INVENTORY.orEmpty(cap, opt);
    }
    @Override public CompoundTag serializeNBT() {
        return getOrCreateDimensionalInventory().serializeNBT();
    }
    @Override public void deserializeNBT(CompoundTag nbt) {
    	getOrCreateDimensionalInventory().deserializeNBT(nbt);
    }
}
