package divinerpg.blocks.base;

import divinerpg.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.registries.*;

import javax.annotation.*;

public class BlockModSpawner extends SpawnerBlock {
    protected String mobName;
    private final LazyValue<ITileEntityProvider> spawnerReference;
    public BlockModSpawner(String name, String mobName) {
        super(Properties.copy(Blocks.SPAWNER).strength(5.0F, 5.0F).randomTicks().noOcclusion());
        this.mobName = mobName;
        setRegistryName(name);
        //TODO - fix this bc it crashes when u place it

        spawnerReference = new LazyValue<>(() -> {
            Block spawner = ForgeRegistries.BLOCKS.getValue(Blocks.SPAWNER.getRegistryName());
            if (spawner instanceof ITileEntityProvider) {
                return ((ITileEntityProvider) spawner);
            }

            return null;
        });
    }

    @Override
    public TileEntity newBlockEntity(IBlockReader reader) {
        TileEntity spawner = spawnerReference.get().newBlockEntity(reader);

        ITileEntityProvider entityProvider = spawnerReference.get();
        if (entityProvider != null) {
            spawner = entityProvider.newBlockEntity(reader);

            if (spawner != null) {
                insertModData(spawner);
            }
        }

        return spawner;
    }

    /**
     * Inserting spawner data as reading from NBT
     *
     * @param spawner - spawner tile entity (take a look into TileEntityMobSpawner.class)
     */
    private void insertModData(@Nonnull TileEntity spawner) {
        CompoundNBT spawnerNBT = spawner.save(new CompoundNBT());
        spawnerNBT.putString("SpawnPotentials", mobName);

        CompoundNBT compound2 = new CompoundNBT();
        compound2.putString("id", DivineRPG.MODID + ":" + mobName);

        spawnerNBT.put("SpawnData", compound2);

        spawner.load(spawner.getLevel().getBlockState(spawner.getBlockPos()), spawnerNBT);
        spawner.setRemoved();
    }
}