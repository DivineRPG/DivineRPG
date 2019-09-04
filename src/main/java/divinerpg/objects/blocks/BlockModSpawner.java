package divinerpg.objects.blocks;

import divinerpg.Reference;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;

public class BlockModSpawner extends BlockMobSpawner  {
    protected String mobName;

    public BlockModSpawner(String name, String mobName) {
        this.mobName = mobName;
        setUnlocalizedName(name);
        setRegistryName(Reference.MODID, name);
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
        setHardness(5.0F);
        this.setTickRandomly(true);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par1) {
        TileEntityMobSpawner spawner = new TileEntityMobSpawner();
        NBTTagCompound compound = new NBTTagCompound();
        NBTTagCompound compound2 = new NBTTagCompound();
        spawner.writeToNBT(compound);
        compound2.setString("id", Reference.MODID + ":" + mobName);
        compound.setTag("SpawnData", compound2);
        compound.setString("SpawnPotentials", mobName);
        spawner.readFromNBT(compound);
        spawner.readFromNBT(compound2);
        spawner.markDirty();
        return spawner;
    }
}