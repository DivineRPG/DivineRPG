package net.divinerpg.items.twilight;

import cpw.mods.fml.common.registry.GameRegistry;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class ItemTwilightSeeds extends ItemSeeds {
	private Block grass, crop;
	public ItemTwilightSeeds(String name, Block block, Block grass) {
		super(block, grass);
		this.grass=grass;
		this.crop = block;
		setUnlocalizedName(name);
		setTextureName(Reference.PREFIX + name);
		LangRegistry.addItem(this);
		GameRegistry.registerItem(this, name);
	}
	
	@Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Plains;
    }
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (side != 1) return false;
        else if (player.canPlayerEdit(x, y, z, side, stack) && player.canPlayerEdit(x, y + 1, z, side, stack)) {
            if (world.getBlock(x, y, z) == grass && crop.canPlaceBlockAt(world, x, y, z) && world.isAirBlock(x, y + 1, z)) {
                world.setBlock(x, y + 1, z, this.crop);
                --stack.stackSize;
                return true;
            }
        }
        return false;
	}

}
