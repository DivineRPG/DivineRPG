package divinerpg.capability;

import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.*;

public class ArcanaProvider implements ICapabilitySerializable<CompoundNBT>
{
    @CapabilityInject(IArcana.class)
    public static final Capability<IArcana> ARCANA_CAP = null;

    private IArcana instance = ARCANA_CAP.getDefaultInstance();

    @SuppressWarnings("unchecked")
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side)
    {
        if (cap == ARCANA_CAP)
            return (LazyOptional<T>) LazyOptional.of(() -> {
                return new Arcana();
            });
        return LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT()
    {
        return (CompoundNBT) ARCANA_CAP.getStorage().writeNBT(ARCANA_CAP, instance, null);
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt)
    {
        ARCANA_CAP.getStorage().readNBT(ARCANA_CAP, instance, null, nbt);
    }

}