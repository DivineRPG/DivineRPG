package divinerpg.dimensions.vethea;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterVetheaToOverworld extends Teleporter {

    protected WorldServer world;

    public TeleporterVetheaToOverworld(WorldServer var1) {
        super(var1);
        this.world = var1;
    }

    @Override
    public void placeInPortal(Entity entity, float rotationYaw) {
        EntityPlayer player;
        if (!(entity instanceof EntityPlayer)) {
            return;
        } else {
            player = (EntityPlayer) entity;
        }

        if (world.provider.getDimension() == 0) {
            BlockPos bed = player.getBedLocation(0);
            if (bed == null) {
                bed = world.getSpawnPoint();
            }
            for (int i = bed.getY(); i < 255; i++) {
                if (world.getBlockState(new BlockPos(bed.getX(), i, bed.getZ())).getBlock() == Blocks.AIR && (world.getBlockState(new BlockPos(bed.getX(), i - 1, bed.getZ())) != Blocks.AIR || i == bed.getY())) {
                    player.setPositionAndUpdate(bed.getX(), i, bed.getZ());
                    break;
                }
            }
        }
    }

    @Override
    public boolean makePortal(Entity entity) {
        return true;
    }
}