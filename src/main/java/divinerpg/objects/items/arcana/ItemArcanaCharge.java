package divinerpg.objects.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.api.DivineAPI;
import divinerpg.api.arcana.IArcana;
import divinerpg.enums.ParticleType;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemArcanaCharge extends ItemMod {
    private Random rand = new Random();

    public ItemArcanaCharge() {
        super("frozen_charge");
        setCreativeTab(DivineRPGTabs.utility);
        setFull3D();
        setMaxStackSize(4);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer p, World w, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    Block b = w.getBlockState(pos).getBlock();
    IArcana arcana = DivineAPI.getArcana(p);
    ItemStack stack = p.getHeldItem(hand);
        if (b == BlockRegistry.arcaniumPower && arcana.getArcana()>=200) {
            w.playSound(p, pos, SoundRegistry.STARLIGHT, SoundCategory.PLAYERS, 1, 1);
            arcana.consume(p, 200);

            Block lastb1 = null;
            for (int x = pos.getX() - 1; x <= pos.getX() + 1; x++) {
              lastb1 = null;
                for (int z = pos.getZ() - 1; z <= pos.getZ() + 1; z++) {
                    Block b1 = w.getBlockState(new BlockPos(x, pos.getY(), z)).getBlock();
                    if (b1 == BlockRegistry.arcaniumPower && lastb1 == Blocks.AIR) {
                        w.setBlockState(new BlockPos(x, pos.getY() - 1, z + 1), Blocks.AIR.getDefaultState());
                        w.setBlockState(new BlockPos(x, pos.getY() - 2, z + 1), Blocks.AIR.getDefaultState());
                        w.setBlockState(new BlockPos(x, pos.getY() - 1, z), Blocks.AIR.getDefaultState());
                        w.setBlockState(new BlockPos(x, pos.getY() - 2, z), Blocks.AIR.getDefaultState());
                        particles(w, x, pos.getY() - 1, z + 0.5);
                        lastb1 = b1;
                        break;
                    } else if (lastb1 == BlockRegistry.arcaniumPower && b1 == Blocks.AIR) {
                        w.setBlockState(new BlockPos(x, pos.getY() - 1, z - 2), Blocks.AIR.getDefaultState());
                        w.setBlockState(new BlockPos(x, pos.getY() - 2, z - 2), Blocks.AIR.getDefaultState());
                        w.setBlockState(new BlockPos(x, pos.getY() - 1, z - 1), Blocks.AIR.getDefaultState());
                        w.setBlockState(new BlockPos(x, pos.getY() - 2, z - 1), Blocks.AIR.getDefaultState());
                        particles(w, x, pos.getY() - 1, z - 1.5);
                        lastb1 = b1;
                        break;
                    }
                    lastb1 = b1;
                }
            }
            
            
            for (int z = pos.getZ() - 1; z <= pos.getZ() + 1; z++) {
                lastb1 = null;
                for (int x = pos.getX() - 1; x <= pos.getX() + 1; x++) {
                    Block b1 = w.getBlockState(new BlockPos(x, pos.getY(), z)).getBlock();
                    if (b1 == BlockRegistry.arcaniumPower && lastb1 == Blocks.AIR) {
                        
                       
                        w.setBlockState(new BlockPos(x + 1, pos.getY() - 1, z), Blocks.AIR.getDefaultState());
                        w.setBlockState(new BlockPos(x + 1, pos.getY() - 2, z), Blocks.AIR.getDefaultState());
                        w.setBlockState(new BlockPos(x, pos.getY() - 1, z), Blocks.AIR.getDefaultState());
                        w.setBlockState(new BlockPos(x, pos.getY() - 2, z), Blocks.AIR.getDefaultState());
                        particles(w, x + 0.5, pos.getY() - 1, z);
                        lastb1 = b1;
                        break;
                    } else if (lastb1 == BlockRegistry.arcaniumPower && b1 == Blocks.AIR) {
                        DivineRPG.logger.info(x + " " + pos.getY() + " " + z);
                        w.setBlockState(new BlockPos(x - 2, pos.getY() - 1, z), Blocks.AIR.getDefaultState());
                        w.setBlockState(new BlockPos(x - 2, pos.getY() - 2, z), Blocks.AIR.getDefaultState());
                        w.setBlockState(new BlockPos(x - 1, pos.getY() - 1, z), Blocks.AIR.getDefaultState());
                        w.setBlockState(new BlockPos(x - 1, pos.getY() - 2, z), Blocks.AIR.getDefaultState());
                        particles(w, x - 1.5, pos.getY() - 1, z);
                        lastb1 = b1;
                        break;
                    }
                    lastb1 = b1;
                }
            }
            stack.shrink(1);
            return EnumActionResult.PASS;
        }
        return EnumActionResult.FAIL;
    }

    private static void particles(World w, double x, double y, double z) {
        if (w.isRemote) {
            for (int i = 0; i < 30; i++) {
                DivineRPG.proxy.spawnParticle(w, ParticleType.BLUE_FLAME, x, y, z, 0, 0, 0);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(new TextComponentTranslation("tooltip.frozencharge").getFormattedText());
        list.add(LocalizeUtils.arcanaConsumed(200));
        list.add(LocalizeUtils.singleUse());
    }
}