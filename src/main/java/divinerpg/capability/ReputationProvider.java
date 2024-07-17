package divinerpg.capability;

import javax.annotation.*;

import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;

public class ReputationProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static final Capability<Reputation> REPUTATION = CapabilityManager.get(new CapabilityToken<>(){});
	private Reputation reputation = null;
	private final LazyOptional<Reputation> opt = LazyOptional.of(this::getOrCreateReputation);
	@Nonnull private Reputation getOrCreateReputation() {
		if(reputation == null) reputation = new Reputation();
		return reputation;
	}
    @Nonnull @Override public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
    	return REPUTATION.orEmpty(cap, opt);
    }
	@Override public CompoundTag serializeNBT(HolderLookup.Provider provider) {
        return getOrCreateReputation().saveTo(new CompoundTag());
    }
	@Override public void deserializeNBT(HolderLookup.Provider provider, CompoundTag nbt) {
    	getOrCreateReputation().loadFrom(nbt);
    }
}