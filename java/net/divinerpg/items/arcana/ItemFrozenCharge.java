package net.divinerpg.items.arcana;

import java.util.List;
import java.util.Random;

import net.divinerpg.DivineRPG;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.events.ArcanaHelper;
import net.divinerpg.utils.proxies.ClientProxy;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemFrozenCharge extends ItemMod {
    private Random rand = new Random();

    public ItemFrozenCharge() {
        super("frozenCharge");
        setCreativeTab(DivineRPGTabs.utility);
        setFull3D();
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer p, World w, int i, int j, int k, int side, float f1, float f2, float f3) {
        Block b = w.getBlock(i, j, k);

        if (b == ArcanaBlocks.arcaniumPower && ArcanaHelper.getProperties(p).useBar(200)) {
            w.playSoundAtEntity(p, Sounds.starlight.getPrefixedName(), 1.0F, 1.0F);

            Block lastb1 = null;
            for (int x = i - 1; x <= i + 1; x++) {
              lastb1 = null;
                for (int z = k - 1; z <= k + 1; z++) {
                    Block b1 = w.getBlock(x, j, z);
                    if (b1 == ArcanaBlocks.arcaniumPower && lastb1 == Blocks.air) {
                        w.setBlock(x, j - 1, z + 1, Blocks.air);
                        w.setBlock(x, j - 2, z + 1, Blocks.air);
                        w.setBlock(x, j - 1, z, Blocks.air);
                        w.setBlock(x, j - 2, z, Blocks.air);
                        particles(w, x, j - 1, z + 0.5);
                        lastb1 = b1;
                        break;
                    } else if (lastb1 == ArcanaBlocks.arcaniumPower && b1 == Blocks.air) {
                        w.setBlock(x, j - 1, z - 2, Blocks.air);
                        w.setBlock(x, j - 2, z - 2, Blocks.air);
                        w.setBlock(x, j - 1, z - 1, Blocks.air);
                        w.setBlock(x, j - 2, z - 1, Blocks.air);
                        particles(w, x, j - 1, z - 1.5);
                        lastb1 = b1;
                        break;
                    }
                    lastb1 = b1;
                }
            }
            
            
            for (int z = k - 1; z <= k + 1; z++) {
                lastb1 = null;
                for (int x = i - 1; x <= i + 1; x++) {
                    Block b1 = w.getBlock(x, j, z);
                    if (b1 == ArcanaBlocks.arcaniumPower && lastb1 == Blocks.air) {
                        
                       
                        w.setBlock(x + 1, j - 1, z, Blocks.air);
                        w.setBlock(x + 1, j - 2, z, Blocks.air);
                        w.setBlock(x, j - 1, z, Blocks.air);
                        w.setBlock(x, j - 2, z, Blocks.air);
                        particles(w, x + 0.5, j - 1, z);
                        lastb1 = b1;
                        break;
                    } else if (lastb1 == ArcanaBlocks.arcaniumPower && b1 == Blocks.air) {
                        System.out.println(x + " " + j + " " + z);
                        w.setBlock(x - 2, j - 1, z, Blocks.air);
                        w.setBlock(x - 2, j - 2, z, Blocks.air);
                        w.setBlock(x - 1, j - 1, z, Blocks.air);
                        w.setBlock(x - 1, j - 2, z, Blocks.air);
                        particles(w, x - 1.5, j - 1, z);
                        lastb1 = b1;
                        break;
                    }
                    lastb1 = b1;
                }
            }
            stack.stackSize--;
            return true;
        }
        return false;
    }

    private static void particles(World w, double x, double y, double z) {
        if (w.isRemote) {
            for (int i = 0; i < 30; i++) {
                DivineRPG.proxy.spawnParticle(w, x, y, z, "blueFlame", true, 4);
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(StatCollector.translateToLocal("tooltip.frozencharge"));
        list.add(TooltipLocalizer.arcanaConsumed(200));
        list.add(TooltipLocalizer.singleUse());
    }
}
