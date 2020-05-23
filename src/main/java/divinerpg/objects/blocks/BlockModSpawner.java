package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.Lazy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Nonnull;

public class BlockModSpawner extends BlockMobSpawner {
    protected String mobName;
    private final LazyLoadBase<ITileEntityProvider> spawnerReference;

    public BlockModSpawner(String name, String mobName) {
        this.mobName = mobName;
        setUnlocalizedName(name);
        setRegistryName(DivineRPG.MODID, name);
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
        setHardness(5.0F);
        this.setTickRandomly(true);

        // Some mods (Apotheosis especially, that guy seriously need to fix that)
        // can replace vanilla mob spawner block.
        // Getting this reference to create tile entity below
        spawnerReference = new Lazy<>(() -> {
            Block spawner = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("mob_spawner"));
            if (spawner instanceof ITileEntityProvider) {
                return ((ITileEntityProvider) spawner);
            }

            return null;
        });
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par1) {
        TileEntity spawner = null;

        ITileEntityProvider entityProvider = spawnerReference.getValue();
        if (entityProvider != null) {
            spawner = entityProvider.createNewTileEntity(world, par1);

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
        NBTTagCompound spawnerNBT = spawner.writeToNBT(new NBTTagCompound());
        spawnerNBT.setString("SpawnPotentials", mobName);

        NBTTagCompound compound2 = new NBTTagCompound();
        compound2.setString("id", DivineRPG.MODID + ":" + mobName);

        spawnerNBT.setTag("SpawnData", compound2);

        spawner.readFromNBT(spawnerNBT);
        spawner.markDirty();
    }
}