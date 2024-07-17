package divinerpg.capability;

import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;

import javax.annotation.*;

public class ArcanaProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static final Capability<Arcana> ARCANA = CapabilityManager.get(new CapabilityToken<>(){});
    private Arcana arcana = null;
    private final LazyOptional<Arcana> opt = LazyOptional.of(this::createArcana);
    @Nonnull private Arcana createArcana() {
        if(arcana == null) arcana = new Arcana();
        return arcana;
    }
    @Nonnull @Override public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if(cap == ARCANA) return opt.cast();
        return LazyOptional.empty();
    }
    @Nonnull @Override public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {return getCapability(cap);}
    @Override public CompoundTag serializeNBT(HolderLookup.Provider provider) {
        return createArcana().serializeNBT(provider);
    }
    @Override public void deserializeNBT(HolderLookup.Provider provider, CompoundTag nbt) {
        createArcana().deserializeNBT(provider, nbt);
    }
}