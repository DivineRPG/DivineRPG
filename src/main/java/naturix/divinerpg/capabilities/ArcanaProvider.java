package naturix.divinerpg.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ArcanaProvider implements ICapabilitySerializable<NBTBase>
{
    @CapabilityInject(IArcana.class)
    public static final Capability<IArcana> ARCANA_CAP = null;

    private IArcana instance = ARCANA_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        return capability == ARCANA_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        return capability == ARCANA_CAP ? ARCANA_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return ARCANA_CAP.getStorage().writeNBT(ARCANA_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        ARCANA_CAP.getStorage().readNBT(ARCANA_CAP, this.instance, null, nbt);
    }
}