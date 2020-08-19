package divinerpg.capabilities.item;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class DivineItemStackCapabilityStorage implements Capability.IStorage<DivineItemStackCapability> {
    public NBTBase writeNBT(Capability<DivineItemStackCapability> capability, DivineItemStackCapability instance, EnumFacing side) {
        return null;
    }

    public void readNBT(Capability<DivineItemStackCapability> capability, DivineItemStackCapability instance, EnumFacing side, NBTBase nbt) {
    }
}
