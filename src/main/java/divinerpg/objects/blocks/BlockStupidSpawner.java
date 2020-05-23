package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.tile.entity.TileEntityStupidSpawner;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStupidSpawner extends BlockMobSpawner  {
    protected String mobName;
    protected boolean spawnParticles;

    public BlockStupidSpawner(String name, String mobName, boolean spawnParticles) {
        this.mobName = mobName;
        this.spawnParticles = spawnParticles;
        setUnlocalizedName(name);
        setRegistryName(DivineRPG.MODID, name);
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
        setHardness(5.0F);
        this.setTickRandomly(true);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par1) {
        TileEntityStupidSpawner spawner = new TileEntityStupidSpawner();
        setEntityName(spawner);
        setSpawnParticles(spawner);
        return spawner;
    }

    protected void setEntityName(TileEntityStupidSpawner spawner) {
        spawner.setEntityName(mobName);
    }

    protected void setSpawnParticles(TileEntityStupidSpawner spawner) {
        spawner.setSpawnParticles(spawnParticles);
    }
}
