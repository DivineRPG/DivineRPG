package divinerpg.objects.blocks.vethea;

import divinerpg.enums.ParticleType;
import divinerpg.objects.blocks.BlockModPortal;
import net.minecraft.block.Block;
import net.minecraft.world.DimensionType;

import java.util.function.Supplier;

public class BlockVetheaPortal extends BlockModPortal {
    public BlockVetheaPortal(String name, DimensionType dimId, Supplier<Block> fireBlockSupplier, Supplier<Block> portalFrameSupplier, ParticleType particle) {
        super(name, dimId, fireBlockSupplier, portalFrameSupplier, particle);
    }
//
//    @Override
//    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entity) {
//        if ((entity.getRidingEntity() == null) && ((entity instanceof EntityPlayerMP))) {
//            EntityPlayerMP playerIn = (EntityPlayerMP) entity;
//            playerIn.mcServer.getWorld(playerIn.dimension);
//            int dimensionID = dimId;
//            if (playerIn.timeUntilPortal > 0) {
//                playerIn.timeUntilPortal = 40;
//            }
//            else if (playerIn.dimension == Config.vetheaDimensionId) {
//
//                NBTTagCompound persistentData = playerIn.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
//                persistentData.setTag("VetheaInv", playerIn.inventory.writeToNBT(new NBTTagList()));
//                playerIn.getEntityData().setTag("PlayerPersisted", persistentData);
//                playerIn.inventory.clear();
//                NBTTagList inv = persistentData.getTagList("OverworldInv", 10);
//                playerIn.inventory.readFromNBT(inv);
//                playerIn.inventoryContainer.detectAndSendChanges();
//
//                playerIn.timeUntilPortal = 40;
//                playerIn.mcServer.getPlayerList().transferPlayerToDimension(playerIn, 0,
//                        new TeleporterVetheaToOverworld(playerIn.mcServer.getWorld(0)));
//            }
//            else {
//                return;
//            }
//        }
//    }

}
