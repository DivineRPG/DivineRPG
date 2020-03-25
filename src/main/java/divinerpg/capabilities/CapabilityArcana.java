package divinerpg.capabilities;

import divinerpg.api.arcana.IArcana;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CapabilityArcana implements IStorage<IArcana> {
    private static final String arcana = "arcana";
    private static final String regenDelay = "regenDelay";
    private static final String maxArcana = "maxArcana";

    @Override
    public NBTBase writeNBT(Capability<IArcana> capability, IArcana instance, EnumFacing side) {
        NBTTagCompound result = new NBTTagCompound();

        result.setFloat(arcana, instance.getArcana());
        result.setInteger(regenDelay, instance.getRegenDelay());
        result.setFloat(maxArcana, instance.getMaxArcana());

        return result;
    }

    @Override
    public void readNBT(Capability<IArcana> capability, IArcana instance, EnumFacing side, NBTBase nbt) {
        // Compatibility for previous versions
        if (NBTBase.getTagTypeName(nbt.getId()).equals("TAG_Compound")) {
            NBTTagCompound saved = (NBTTagCompound) nbt;

            instance.set(saved.getFloat(arcana));
            instance.setRegenDelay(Math.max(1, saved.getInteger(regenDelay)));
            instance.setMaxArcana(Math.max(1, saved.getFloat(maxArcana)));
        }
    }
}