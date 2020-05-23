package divinerpg.dimensions.iceika.structures;

import java.util.Random;

import divinerpg.objects.entities.entity.iceika.EntityWorkshopMerchant;
import divinerpg.objects.entities.entity.iceika.EntityWorkshopTinkerer;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenHouse1 extends WorldGenerator{

	public boolean locationIsValidSpawn(World w, int x, int y, int z){
		for(int i = 0; i < 10; i++) {
			for(int l = 0; l < 10; l++) {
				if(w.getBlockState(new BlockPos(x + i, y, z + l)) != BlockRegistry.frozenGrass) {
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
		WorldGenAPI.addRectangle(10, 10, 3, w, x, y + 1, z, BlockRegistry.snowBricks);
		WorldGenAPI.addRectangle(8, 8, 4, w, x + 1, y + 1, z + 1, Blocks.AIR);
		WorldGenAPI.addRectangle(8, 8, 1, w, x + 1, y + 4, z + 1, BlockRegistry.snowBricks);
		WorldGenAPI.addRectangle(6, 6, 1, w, x + 2, y + 4, z + 2, Blocks.AIR);
		WorldGenAPI.addRectangle(6, 6, 1, w, x + 2, y + 5, z + 2, BlockRegistry.snowBricks);
//		WorldGenAPI.addRectangle(8, 8, 1, w, x + 1, y, z + 1, BlockRegistry.workshopCarpet);
		WorldGenAPI.addRectangle(4, 1, 4, w, x + 3, y, z, BlockRegistry.coalstone);
		ItemDoor.placeDoor(w, new BlockPos(x + 5, y + 1, z), EnumFacing.NORTH, BlockRegistry.steelDoor, true);
		ItemDoor.placeDoor(w, new BlockPos(x + 4, y + 1, z), EnumFacing.NORTH, BlockRegistry.steelDoor, false);
		WorldGenAPI.addRectangle(1, 1, 3, w, x, y + 1, z, BlockRegistry.coalstone);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 9, y + 1, z, BlockRegistry.coalstone);
		WorldGenAPI.addRectangle(1, 1, 3, w, x, y + 1, z + 9, BlockRegistry.coalstone);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 9, y + 1, z + 9, BlockRegistry.coalstone);
		WorldGenAPI.addRectangle(1, 3, 3, w, x + 1, y + 1, z + 1, BlockRegistry.workshopBookcase);
		WorldGenAPI.addRectangle(3, 1, 1, w, x + 1, y + 1, z + 8, BlockRegistry.workshopBookcase);
		WorldGenAPI.addRectangle(1, 3, 3, w, x + 4, y + 1, z + 6, BlockRegistry.coalstone);
		WorldGenAPI.addRectangle(1, 2, 1, w, x + 4, y + 4, z + 6, BlockRegistry.coalstone);
		WorldGenAPI.addRectangle(1, 3, 4, w, x + 5, y + 1, z + 5, BlockRegistry.coalstone);
		WorldGenAPI.addRectangle(1, 2, 1, w, x + 5, y + 3, z + 7, BlockRegistry.workshopLamp);
		WorldGenAPI.addRectangle(1, 2, 2, w, x + 5, y + 1, z + 7, BlockRegistry.workshopBookcase);
		WorldGenAPI.addRectangle(1, 1, 4, w, x + 6, y + 1, z + 6, BlockRegistry.coalstone);
		WorldGenAPI.addBlock(w, x + 1, y + 2, z + 1, BlockRegistry.workshopLamp);
		WorldGenAPI.addBlock(w, x + 1, y, z + 8, BlockRegistry.workshopLamp);
		WorldGenAPI.addBlock(w, x + 8, y - 1, z + 1, BlockRegistry.workshopLamp);
		WorldGenAPI.addBlock(w, x + 8, y - 1, z + 8, BlockRegistry.workshopLamp);
		WorldGenAPI.addBlock(w, x + 5, y, z + 5, BlockRegistry.coalstoneFurnace);
        w.setBlockState(new BlockPos(x + 4, y + 1, z + 5), BlockRegistry.frostedChest.getDefaultState(), 1);
        WorldGenAPI.addBlock(w, x + 6, y + 1, z + 9, BlockRegistry.frostedGlass);
		WorldGenAPI.addBlock(w, x + 9, y + 1, z + 6, BlockRegistry.frostedGlass);
		WorldGenAPI.addBlock(w, x + 9, y + 1, z + 3, BlockRegistry.frostedGlass);
		WorldGenAPI.addBlock(w, x, y + 1, z + 7, BlockRegistry.frostedGlass);
		WorldGenAPI.addBlock(w, x, y + 1, z + 5, BlockRegistry.frostedGlass);
		EntityWorkshopMerchant mer = new EntityWorkshopMerchant(w);
		EntityWorkshopTinkerer tink = new EntityWorkshopTinkerer(w);
		
		TileEntity tileentity1 = w.getTileEntity(new BlockPos(x + 4, y + 1, z + 5));
        if (tileentity1 instanceof TileEntityLockableLoot) {
        	((TileEntityLockableLoot) tileentity1).setLootTable(LootTableRegistry.ICEIKA_CHEST_DUNGEON, rand.nextLong());
        }
		if(!w.isRemote){
			mer.setLocationAndAngles(x + 3, y + 1, z + 3, 0.0F, 0.0F);
			tink.setLocationAndAngles(x + 7, y + 1, z + 3, 0.0F, 0.0F);
			w.spawnEntity(tink);
			w.spawnEntity(mer);
		}
		return true;
	}
}