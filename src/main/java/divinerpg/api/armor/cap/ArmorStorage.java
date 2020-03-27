package divinerpg.api.armor.cap;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
import java.util.Set;

public class ArmorStorage implements Capability.IStorage<IArmorPowers> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IArmorPowers> capability, IArmorPowers instance, EnumFacing side) {
        NBTTagCompound result = new NBTTagCompound();

        if (instance != null) {
            Set<ResourceLocation> wearing = instance.wearing();

            if (!wearing.isEmpty()) {
                NBTTagList list = new NBTTagList();
                wearing.forEach(x -> list.appendTag(new NBTTagString(x.toString())));
                result.setTag("Armors", list);
            }
        }

        return result;
    }

    @Override
    public void readNBT(Capability<IArmorPowers> capability, IArmorPowers instance, EnumFacing side, NBTBase nbt) {
        // we don't really need to restore prev items
        // we are performing checks every time
//        if (nbt instanceof NBTTagCompound){
//            NBTBase raw = ((NBTTagCompound) nbt).getTag("Armors");
//            if (raw instanceof NBTTagList){
//                NBTTagList armors = (NBTTagList) raw;
//                for (int i = 0; i < armors.tagCount(); i++) {
//                    instance.putOn(new ResourceLocation(armors.getStringTagAt(i)));
//                }
//            }
//        }
    }
}
