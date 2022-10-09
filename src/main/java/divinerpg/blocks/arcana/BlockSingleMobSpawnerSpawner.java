package divinerpg.blocks.arcana;

import divinerpg.blocks.base.BlockMod;
import divinerpg.tiles.spawner.TileEntitySingleMobSpawner;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockSingleMobSpawnerSpawner extends BlockMod implements ITileEntityProvider {
    private ResourceLocation mobName;

    public BlockSingleMobSpawnerSpawner(String name, ResourceLocation mobName) {
        super(name, -1);
        this.mobName = mobName;
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader world) {
        return new TileEntitySingleMobSpawner(mobName);
    }
}
