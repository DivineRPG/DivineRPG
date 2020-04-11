package divinerpg.objects.items.vethea;

import divinerpg.objects.blocks.vethea.BlockKarosDispenser;
import divinerpg.utils.LocalizeUtils;
import divinerpg.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

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
        super.addInformation(stack, worldIn, list, flagIn);
        list.add(LocalizeUtils.i18n("tooltip.staff.evernight.damage"));
    }
}
