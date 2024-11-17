package net.divinerpg.blocks.arcana;

import java.util.List;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockArcanaFrame extends BlockMod {

    protected Block portal;

    public BlockArcanaFrame(String name, Block portal) {
        super(EnumBlockType.ROCK, name, 5.0F);
        this.portal = portal;
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack stack) {
        int var6 = ((MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3) + 2) % 4;
        world.setBlockMetadataWithNotify(x, y, z, var6, 3);
        if (entityLiving instanceof EntityPlayerMP && entityLiving.dimension != ConfigurationHelper.arcana) {
            boolean validFrame = true;
            int startX = x;
            int startZ = z;

            /* Find upper left hand corner of frame */
            if (world.getBlock(startX - 1, y, startZ) == this || world.getBlock(startX + 1, y, startZ) == this) {
                while (world.getBlock(startX - 1, y, startZ) == this) {
                    startX--;
                }
                startX--;
                if (world.getBlock(startX, y, startZ - 1) == this) {
                    startZ = startZ - 4;
                }
            } else if (world.getBlock(startX, y, startZ - 1) == this || world.getBlock(startX, y, startZ + 1) == this) {
                while (world.getBlock(startX, y, startZ - 1) == this) {
                    startZ--;
                }
                startZ--;
                if (world.getBlock(startX - 1, y, startZ) == this) {
                    startX = startX - 4;
                }
            }

            /* Check if it is a valid Arcana portal frame */
            frameCheckLoops: for (int scanZ = startZ; scanZ < startZ + 5; scanZ++) {
                if ((scanZ == startZ || scanZ == startZ + 4)) {
                    for (int scanX = startX + 1; scanX < startX + 4; scanX++) {
                        if (world.getBlock(scanX, y, scanZ) != this) {
                            validFrame = false;
                            break frameCheckLoops;
                        }
                    }
                } else {
                    for (int scanX = startX; scanX < startX + 5; scanX++) {
                        if (scanX == startX || scanX == startX + 4) {
                            if (world.getBlock(scanX, y, scanZ) != this) {
                                validFrame = false;
                                break frameCheckLoops;
                            }
                        } else if (world.getBlock(scanX, y, scanZ) != Blocks.air) {
                            validFrame = false;
                            break frameCheckLoops;
                        }
                    }
                }
            }

            /* Set portal blocks */
            if (validFrame) {
                world.setBlock(startX + 1, y, startZ + 1, portal);
                world.setBlock(startX + 2, y, startZ + 1, portal);
                world.setBlock(startX + 3, y, startZ + 1, portal);
                world.setBlock(startX + 1, y, startZ + 2, portal);
                world.setBlock(startX + 2, y, startZ + 2, portal);
                world.setBlock(startX + 3, y, startZ + 2, portal);
                world.setBlock(startX + 1, y, startZ + 3, portal);
                world.setBlock(startX + 2, y, startZ + 3, portal);
                world.setBlock(startX + 3, y, startZ + 3, portal);
            }
        }
    }

}
