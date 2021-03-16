package divinerpg.capability;

import com.google.common.base.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.*;

import javax.annotation.*;

public class ArcanaProvider implements ICapabilitySerializable<INBT>
{
    @CapabilityInject(IArcana.class)
    public static final Capability<IArcana> ARCANA_CAP = null;

    @SuppressWarnings({"ConstantConditions", "FieldMayBeFinal"})
    private IArcana instance = ARCANA_CAP.getDefaultInstance();

    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable Direction side) {
        return capability == ARCANA_CAP;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == ARCANA_CAP ? LazyOptional.of((NonNullSupplier<T>) Optional.fromNullable(this.instance)) : LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        return ARCANA_CAP.getStorage().writeNBT(ARCANA_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        ARCANA_CAP.getStorage().readNBT(ARCANA_CAP, this.instance, null, nbt);
    }

    /**
     * Gets the arcana capability
     *
     * @param entity - any entity, but we are using player
     * @return - IArcana capability
     */
    @Nullable
    public static LazyOptional<IArcana> getArcana(Entity entity) {
        if (entity == null)
            return null;

        return entity.getCapability(ARCANA_CAP, null);
    }
}