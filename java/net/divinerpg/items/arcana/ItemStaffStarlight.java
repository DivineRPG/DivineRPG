package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.entities.arcana.projectile.EntityStar;
import net.divinerpg.items.base.ItemModRanged;
import net.divinerpg.items.base.ItemProjectileShooter;
import net.divinerpg.items.vethea.ItemStaff;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.events.ArcanaHelper;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemStaffStarlight extends ItemModRanged {

    public ItemStaffStarlight(String name) {
        super(name, -1, Sounds.starlight, EntityStar.class);
        ItemProjectileShooter.gunList.add(this);
        this.setFull3D();
        ItemStaff.staffList.add(this);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        float rotationPitch = player.rotationPitch;
        float rotationYaw = player.rotationYaw;
        double x = player.posX;
        double y = player.posY + 1.62D - (double) player.yOffset;
        double z = player.posZ;
        Vec3 worldVector = Vec3.createVectorHelper(x, y, z);
        float yawAngleCos = MathHelper.cos(-rotationYaw * 0.01745329F - (float) Math.PI);
        float yawAngleSin = MathHelper.sin(-rotationYaw * 0.01745329F - (float) Math.PI);
        float pitchAngle = -MathHelper.cos(-rotationPitch * 0.01745329F);
        float yVec = MathHelper.sin(-rotationPitch * 0.01745329F);
        float xVec = yawAngleSin * pitchAngle;
        float zVec = yawAngleCos * pitchAngle;
        double multiplyer = 30.0D;
        Vec3 worldVector2 = worldVector.addVector((double) xVec * multiplyer, (double) yVec * multiplyer, (double) zVec * multiplyer);
        MovingObjectPosition objPos = world.rayTraceBlocks(worldVector, worldVector2);

        if (objPos == null) return stack;
        if (objPos.typeOfHit == MovingObjectType.BLOCK) {
            int blockX = objPos.blockX;
            int blockY = objPos.blockY;
            int blockZ = objPos.blockZ;
            int side = objPos.sideHit;

            if (side == 0) --blockY;
            if (side == 1) ++blockY;
            if (side == 2) --blockZ;
            if (side == 3) ++blockZ;
            if (side == 4) --blockX;
            if (side == 5) ++blockX;

            if (stack.getItem() == ArcanaItems.staffStarlight) {
                if (!world.isRemote && ArcanaHelper.getProperties(player).useBar(25)) {
                    for (int i = 0; i < 8; i++)
                        world.spawnEntityInWorld(new EntityStar(world, (double) blockX + 0.5D, (double) blockY + 25D, (double) blockZ + 0.5D));
                    Sounds.playSound(Sounds.starlight, world, player, 1.0F, 0.5F);
                }
            } else {
                if (!world.isRemote && ArcanaHelper.getProperties(player).useBar(5)) {
                    world.spawnEntityInWorld(new EntityStar(world, (double) blockX + 0.5D, (double) blockY + 25D, (double) blockZ + 0.5D));
                    Sounds.playSound(player, world, Sounds.starlight);
                }
            }
            player.getLook(1);
        }
        return stack;
    }

    @Override
    protected void addAdditionalInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        int damage = 0;
        int arcana = 0;
        boolean stars = false;
        if (stack.getItem() == ArcanaItems.staffStarlight) {
            arcana = 25;
            stars = true;
        } else {
            arcana = 5;
            stars = false;
        }
        list.add(TooltipLocalizer.arcanaConsumed(25));
        list.add(stars ? "Drops several stars from the sky" : "Drops a star from the sky");
        list.add(TooltipLocalizer.rangedDam(20));
    }
}
