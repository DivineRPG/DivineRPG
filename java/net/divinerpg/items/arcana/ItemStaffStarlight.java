package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.api.items.ItemModRanged;
import net.divinerpg.client.ArcanaHelper;
import net.divinerpg.entities.arcana.projectile.EntityStar;
import net.divinerpg.libs.Sounds;
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
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        float rotationPitch = par3EntityPlayer.rotationPitch;
        float rotationYaw = par3EntityPlayer.rotationYaw;
        double x = par3EntityPlayer.posX;
        double y = par3EntityPlayer.posY + 1.62D - (double) par3EntityPlayer.yOffset;
        double z = par3EntityPlayer.posZ;
        Vec3 worldVector = Vec3.createVectorHelper(x, y, z);
        float yawAngleCos = MathHelper.cos(-rotationYaw * 0.01745329F - (float) Math.PI);
        float yawAngleSin = MathHelper.sin(-rotationYaw * 0.01745329F - (float) Math.PI);
        float pitchAngle = -MathHelper.cos(-rotationPitch * 0.01745329F);
        float yVec = MathHelper.sin(-rotationPitch * 0.01745329F);
        float xVec = yawAngleSin * pitchAngle;
        float zVec = yawAngleCos * pitchAngle;
        double multiplyer = 30.0D;
        Vec3 worldVector2 = worldVector.addVector((double) xVec * multiplyer, (double) yVec * multiplyer, (double) zVec * multiplyer);
        MovingObjectPosition objPos = par2World.rayTraceBlocks(worldVector, worldVector2);

        if (objPos == null) return par1ItemStack;
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

            if (par1ItemStack.getItem() == ArcanaItems.staffStarlight) {
                if (!par2World.isRemote && ArcanaHelper.useBar(25)) {
                    for (int i = 0; i < 8; i++)
                        par2World.spawnEntityInWorld(new EntityStar(par2World, (double) blockX + 0.5D, (double) blockY + 25D, (double) blockZ + 0.5D));
                    Sounds.playSound(Sounds.starlight, par2World, par3EntityPlayer, 1.0F, 0.5F);
                }
            } else {
                if (!par2World.isRemote && ArcanaHelper.useBar(5)) {
                    par2World.spawnEntityInWorld(new EntityStar(par2World, (double) blockX + 0.5D, (double) blockY + 25D, (double) blockZ + 0.5D));
                    Sounds.playSound(par3EntityPlayer, par2World, Sounds.starlight);
                }
            }
            par3EntityPlayer.getLook(1);
        }
        return par1ItemStack;
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
        list.add(arcana + " Arcana");
        list.add(stars ? "Drops several stars from the sky" : "Drops a star from the sky");
        list.add("40 Ranged Damage");
    }
}
