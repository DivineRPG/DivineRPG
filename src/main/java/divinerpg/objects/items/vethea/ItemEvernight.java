package divinerpg.objects.items.vethea;

import java.util.List;

import divinerpg.objects.blocks.vethea.BlockKarosDispenser;
import divinerpg.utils.*;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.*;

public class ItemEvernight extends ItemStaff {
    public ItemEvernight(int dam, int arcana, String name) {
        super(dam, arcana, name);
    }

    @Override
    protected void doPreUsageEffects(World world, EntityPlayer player) {
        player.attackEntityFrom(Utils.arcanaSource, 20);

        if(world.isRemote) {
            return;
        }

        for(int x = -8; x < 8; x++) {
            for(int y = -8; y < 8; y++) {
                for(int z = -8; z < 8; z++) {
                    BlockPos pos = new BlockPos(player.getPosition().add(x, y, z));
                    Block block = world.getBlockState(pos).getBlock();

                    if(block instanceof BlockKarosDispenser) {
                        ((BlockKarosDispenser)block).dispense(world, pos);
                    }
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> list, ITooltipFlag flagIn) {
        super.addInformation(stack,worldIn,list,flagIn);
        list.add(TooltipHelper.getInfoText("tooltip.staff.evernight.damage"));
    }
}
