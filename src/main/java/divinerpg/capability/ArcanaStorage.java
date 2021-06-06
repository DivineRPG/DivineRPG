package divinerpg.capability;

import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraftforge.common.capabilities.*;

import javax.annotation.*;

public class ArcanaStorage implements Capability.IStorage<IArcana> {
    private static final String arcana = "arcana";
    private static final String regenDelay = "regenDelay";
    private static final String maxArcana = "maxArcana";

    @Nullable
    @Override
    public INBT writeNBT(Capability<IArcana> capability, IArcana instance, Direction side) {
        CompoundNBT result = new CompoundNBT();

        result.putFloat(arcana, instance.getArcana());
        result.putInt(regenDelay, instance.getRegenDelay());
        result.putFloat(maxArcana, instance.getMaxArcana());

        return result;
    }

    @Override
    public void readNBT(Capability<IArcana> capability, IArcana instance, Direction side, INBT nbt) {
            CompoundNBT saved = (CompoundNBT) nbt;

            instance.set(saved.getFloat(arcana));
            instance.setRegenDelay(Math.max(1, saved.getInt(regenDelay)));
            instance.setMaxArcana(Math.max(1, saved.getFloat(maxArcana)));
    }
}