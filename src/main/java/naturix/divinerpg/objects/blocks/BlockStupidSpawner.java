package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityStupidSpawner;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import naturix.divinerpg.utils.Reference;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStupidSpawner extends BlockMobSpawner implements IHasModel {
    protected String name;
    protected String mobName;
    protected boolean spawnParticles;

    public BlockStupidSpawner(String name, String mobName, boolean spawnParticles) {
        this.name = name;
        this.mobName = Reference.MODID + "." + mobName;
        this.spawnParticles = spawnParticles;
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
        setHardness(5.0F);
        this.setTickRandomly(true);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
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

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
