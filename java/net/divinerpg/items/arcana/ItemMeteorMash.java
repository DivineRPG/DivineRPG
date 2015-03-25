package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.entities.arcana.projectile.EntityMeteor;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.items.base.ItemProjectileShooter;
import net.divinerpg.items.vethea.ItemStaff;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.events.ArcanaHelper;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemMeteorMash extends ItemMod {

    public ItemMeteorMash() {
        super("meteorMash", DivineRPGTabs.ranged);
        setMaxStackSize(1);
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

                if (!world.isRemote && ArcanaHelper.getProperties(player).useBar(35)) {
                    world.spawnEntityInWorld(new EntityMeteor(world, (double) blockX + 0.5D, (double) blockY + 25D, (double) blockZ + 0.5D));
                    Sounds.playSound(player, world, Sounds.starlight);
                }
            player.getLook(1);
        }
        return stack;
    }

    @Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add("Drops an explosive meteor from the sky");
        list.add(TooltipLocalizer.arcanaConsumed(35));
        list.add(TooltipLocalizer.infiniteUses());
    }
}
