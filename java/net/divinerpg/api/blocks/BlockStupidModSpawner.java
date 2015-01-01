package net.divinerpg.api.blocks;

import java.util.Random;

import net.divinerpg.api.entity.tileentity.TileEntityStupidSpawner;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockStupidModSpawner extends BlockContainer {

    protected String name;
    protected String mobName;

    public BlockStupidModSpawner(String name, String mobName) {
        this(name, mobName, "frozenDungeonSpawner");
    }

    public BlockStupidModSpawner(String name, String mobName, String textureName) {
        super(Material.rock);
        this.name = name;
        this.mobName = "divinerpg." + mobName;
        setBlockName(name);
        setBlockTextureName(Reference.PREFIX + textureName);
        setCreativeTab(DivineRPGTabs.spawner);
        GameRegistry.registerBlock(this, name);
        LangRegistry.addBlock(this);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par1) {
        TileEntityStupidSpawner spawner = new TileEntityStupidSpawner();
        setEntityName(spawner);
        return spawner;
    }

    protected void setEntityName(TileEntityStupidSpawner spawner) {
        spawner.setEntityName(mobName);
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int par5, float par6, int par7) {
        super.dropBlockAsItemWithChance(world, x, y, z, par5, par6, par7);
        int var8 = 15 + world.rand.nextInt(15) + world.rand.nextInt(15);
        this.dropXpOnBlockBreak(world, x, y, z, var8);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

}
