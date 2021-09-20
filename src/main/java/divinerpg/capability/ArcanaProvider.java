package divinerpg.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ArcanaProvider implements ICapabilitySerializable<INBT> {

    private final Direction NO_SPECIFIC_SIDE = null;

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction facing) {
        if (ArcanaCapability.CAPABILITY_ARCANA == capability) {
            return (LazyOptional<T>)LazyOptional.of(()-> arcana);

        }

        return LazyOptional.empty();
    }

    private final static String ARCANA_NBT = "arcana";

    @Override
    public INBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        INBT arcanaNBT = ArcanaCapability.CAPABILITY_ARCANA.writeNBT(arcana, NO_SPECIFIC_SIDE);
        nbt.put(ARCANA_NBT, arcanaNBT);
        return nbt;
    }


    @Override
    public void deserializeNBT(INBT nbt) {
        if (nbt.getId() != new CompoundNBT().getId()) {
            LOGGER.warn("Unexpected NBT type:"+nbt);
            return;  // leave as default in case of error
        }
        CompoundNBT compoundNBT = (CompoundNBT)nbt;
        INBT arcanaNBT = compoundNBT.get(ARCANA_NBT);

        ArcanaCapability.CAPABILITY_ARCANA.readNBT(arcana, NO_SPECIFIC_SIDE, arcanaNBT);
    }

    private Arcana arcana = new Arcana();

    private static final Logger LOGGER = LogManager.getLogger();

}