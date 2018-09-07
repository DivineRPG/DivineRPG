package naturix.divinerpg.GUI;

import naturix.divinerpg.bases.blocks.tile.furnace.entity.TileEntityFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	
	public static final int GUI_FURNACE = 0;
	
	public Object getServerGuiElement(int id, EntityPlayer player, World world,	int x, int y, int z) {
		
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
	    switch (id)
	    {
	    case GUI_FURNACE: 
	      if ((tileEntity instanceof TileEntityFurnace)) {
	        return new ContainerFurnace(player.inventory, (TileEntityFurnace)tileEntity);
	      }
	      
	    }
	    return null;
	    
	}

	public Object getClientGuiElement(int id, EntityPlayer player, World world,	int x, int y, int z) {
		  
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
	    switch (id)
	    {
	    case GUI_FURNACE: 
	      if ((tileEntity instanceof TileEntityFurnace)) {
	        return new GuiFurnace(player.inventory, (TileEntityFurnace)tileEntity);
	      }
	      
	    }
	    
	    return null;
	  }

}