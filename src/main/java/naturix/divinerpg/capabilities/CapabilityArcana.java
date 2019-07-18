package naturix.divinerpg.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CapabilityArcana implements IStorage<IArcana>
{
    @Override
    public NBTBase writeNBT(Capability<IArcana> capability, IArcana instance, EnumFacing side)
    {
        return new NBTTagFloat(instance.getArcana());
    }

    @Override
    public void readNBT(Capability<IArcana> capability, IArcana instance, EnumFacing side, NBTBase nbt)
    {
        instance.set(((NBTTagFloat) nbt).getFloat());
    }
}