package divinerpg.objects.blocks.vethea;

import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.config.Config;
import divinerpg.dimensions.vethea.TeleporterVetheaToOverworld;
import divinerpg.enums.ParticleType;
import divinerpg.objects.blocks.BlockModPortal;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import divinerpg.utils.DivineTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockVetheaPortal extends BlockModPortal {
    public BlockVetheaPortal(String name, int dimId, Block fireBlock, Block portalFrame, ParticleType particle) {
        super(name, dimId, fireBlock, portalFrame, particle);
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entity) {
        if ((entity.getRidingEntity() == null) && ((entity instanceof EntityPlayerMP))) {
            EntityPlayerMP playerIn = (EntityPlayerMP) entity;
            playerIn.mcServer.getWorld(playerIn.dimension);
            int dimensionID = dimId;
            if (playerIn.timeUntilPortal > 0) {
                playerIn.timeUntilPortal = 40;
            }
            else if (playerIn.dimension == Config.vetheaDimensionId) {

                NBTTagCompound persistentData = playerIn.getEntityData().getCompoundTag(playerIn.PERSISTED_NBT_TAG);
                persistentData.setTag("VetheaInv", playerIn.inventory.writeToNBT(new NBTTagList()));
                playerIn.getEntityData().setTag("PlayerPersisted", persistentData);
                playerIn.inventory.clear();
                NBTTagList inv = persistentData.getTagList("OverworldInv", 10);
                playerIn.inventory.readFromNBT(inv);
                playerIn.inventoryContainer.detectAndSendChanges();

                playerIn.timeUntilPortal = 40;
                playerIn.mcServer.getPlayerList().transferPlayerToDimension(playerIn, 0,
                        new TeleporterVetheaToOverworld(playerIn.mcServer.getWorld(0)));
            }
            else {
                return;
            }
        }
    }

}
