package divinerpg.dimensions.iceika.structures;

import java.util.Random;

import divinerpg.objects.entities.entity.iceika.EntityWorkshopMerchant;
import divinerpg.objects.entities.entity.iceika.EntityWorkshopTinkerer;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLibrary extends WorldGenerator{

	public boolean locationIsValidSpawn(World w, int x, int y, int z){
		for(int i = 0; i < 18; i++) {
			for(int l = 0; l < 10; l++) {
				if(w.getBlockState(new BlockPos(x + i, y, z + l)) != ModBlocks.frozenGrass.getDefaultState()) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean generate(World w, Random rand, BlockPos pos) {
		int x=pos.getX(), y=pos.getY(), z=pos.getZ();
		if(!locationIsValidSpawn(w, x, y, z))
			return false;
		WorldGenAPI.addRectangle(19, 11, 1, w, x, y, z, ModBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 7, 3, w, x + 1, y + 1, z + 2, ModBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 5, 2, w, x + 1, y + 1, z + 3, ModBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 3, 2, w, x + 1, y + 1, z + 4, ModBlocks.coalstone);
		WorldGenAPI.addRectangle(16, 9, 5, w, x + 2, y + 1, z + 1, ModBlocks.coalstone);
		WorldGenAPI.addRectangle(12, 7, 1, w, x + 2, y + 4, z + 2, ModBlocks.snowBricks);
		WorldGenAPI.addRectangle(14, 7, 1, w, x + 4, y + 6, z + 2, ModBlocks.snowBricks);
		WorldGenAPI.addRectangle(14, 5, 1, w, x + 4, y + 7, z + 3, ModBlocks.snowBricks);
		WorldGenAPI.addRectangle(3, 9, 5, w, x + 2, y + 4, z + 1, Blocks.AIR);
		WorldGenAPI.addRectangle(15, 7, 2, w, x + 2, y + 1, z + 2, Blocks.AIR);
		WorldGenAPI.addRectangle(11, 7, 5, w, x + 6, y + 1, z + 2, Blocks.AIR);
		WorldGenAPI.addRectangle(11, 5, 1, w, x + 6, y + 6, z + 3, Blocks.AIR);
//		WorldGenAPI.addRectangle(15, 7, 1, w, x + 2, y, z + 2, ModBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(10, 3, 1, w, x + 6, y, z + 4, ModBlocks.coalstone);
		WorldGenAPI.addRectangle(8, 1, 2, w, x + 7, y + 1, z + 5, ModBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(1, 7, 1, w, x + 5, y + 3, z + 2, Blocks.AIR);
		WorldGenAPI.addRectangle(11, 1, 3, w, x + 6, y + 1, z + 2, ModBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(11, 1, 3, w, x + 6, y + 1, z + 8, ModBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(14, 1, 2, w, x + 3, y + 1, z + 1, ModBlocks.snowBricks);
		WorldGenAPI.addRectangle(14, 1, 2, w, x + 3, y + 1, z + 9, ModBlocks.snowBricks);
		WorldGenAPI.addRectangle(11, 1, 2, w, x + 6, y + 3, z + 1, ModBlocks.snowBricks);
		WorldGenAPI.addRectangle(11, 1, 2, w, x + 6, y + 3, z + 9, ModBlocks.snowBricks);
		WorldGenAPI.addRectangle(3, 7, 1, w, x + 2, y + 3, z + 2, ModBlocks.snowBricks);
		w.setBlockState(new BlockPos(x + 1, y + 1, z + 4), Blocks.AIR.getDefaultState());
		w.setBlockState(new BlockPos(x + 1, y + 2, z + 4), Blocks.AIR.getDefaultState());
		w.setBlockState(new BlockPos(x + 1, y + 1, z + 6), Blocks.AIR.getDefaultState());
		w.setBlockState(new BlockPos(x + 1, y + 2, z + 6), Blocks.AIR.getDefaultState());
		w.setBlockState(new BlockPos(x + 6, y + 3, z + 2), ModBlocks.workshopLamp.getDefaultState());
		w.setBlockState(new BlockPos(x + 6, y + 3, z + 8), ModBlocks.workshopLamp.getDefaultState());
		w.setBlockState(new BlockPos(x + 16, y + 3, z + 2), ModBlocks.workshopLamp.getDefaultState());
		w.setBlockState(new BlockPos(x + 16, y + 3, z + 8), ModBlocks.workshopLamp.getDefaultState());
		WorldGenAPI.addRectangle(1, 7, 1, w, x + 5, y + 5, z + 2, ModBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 5, 1, w, x + 5, y + 6, z + 3, ModBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 7, 1, w, x + 17, y + 5, z + 2, ModBlocks.frostedGlass); 
		WorldGenAPI.addRectangle(1, 5, 1, w, x + 17, y + 6, z + 3, ModBlocks.frostedGlass);
		ItemDoor.placeDoor(w, new BlockPos(x + 1, y + 1, z + 4), EnumFacing.EAST, ModBlocks.steelDoor, true);
		ItemDoor.placeDoor(w, new BlockPos(x + 1, y + 1, z + 6), EnumFacing.WEST, ModBlocks.steelDoor, false);
		w.setBlockState(new BlockPos(x, y, z), ModBlocks.frozenGrass.getDefaultState());
		w.setBlockState(new BlockPos(x, y, z + 10), ModBlocks.frozenGrass.getDefaultState());
		w.setBlockState(new BlockPos(x + 15, y + 1, z + 5), ModBlocks.frostedChest.getDefaultState(), 0);
		TileEntity tileentity1 = w.getTileEntity(new BlockPos(x + 15, y + 1, z + 5));
        if (tileentity1 instanceof TileEntityLockableLoot) {
        	((TileEntityLockableLoot) tileentity1).setLootTable(DRPGLootTables.ICEIKA_CHEST_DUNGEON, rand.nextLong());
        }
    	
		EntityWorkshopMerchant mer = new EntityWorkshopMerchant(w);
    	EntityWorkshopTinkerer tink = new EntityWorkshopTinkerer(w);
    	if(!w.isRemote){
    		mer.setLocationAndAngles(x + 10, y + 1, z + 4, 0.0F, 0.0F);
    		tink.setLocationAndAngles(x + 10, y + 1, z + 8, 0.0F, 0.0F);
    		w.spawnEntity(mer);
    		w.spawnEntity(tink);
    	}
		return true;
	}
}