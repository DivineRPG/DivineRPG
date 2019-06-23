package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityAttractor;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityMeteor;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.objects.items.vethea.ItemStaff;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipHelper;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemMeteorMash extends ItemMod {

    public ItemMeteorMash() {
        super("meteor_mash", DivineRPGTabs.ranged);
        setMaxStackSize(1);
        this.setFull3D();
        ItemStaff.staffList.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = new ItemStack(player.getHeldItem(hand).getItem());    float rotationPitch = player.rotationPitch;
		RayTraceResult pos = player.rayTrace(30, 1);
		int x = pos.getBlockPos().getX(), y = pos.getBlockPos().getY()+1, z = pos.getBlockPos().getZ();
		
		
        if (pos.typeOfHit == RayTraceResult.Type.BLOCK) {
            int blockX = pos.getBlockPos().getX();
            int blockY = pos.getBlockPos().getY();
            int blockZ = pos.getBlockPos().getZ();
            EnumFacing side = pos.sideHit;

            if (side == EnumFacing.DOWN) --blockY;
            if (side == EnumFacing.UP) ++blockY;
            if (side == EnumFacing.EAST) --blockZ;
            if (side == EnumFacing.WEST) ++blockZ;
            if (side == EnumFacing.SOUTH) --blockX;
            if (side == EnumFacing.NORTH) ++blockX;

                if (!world.isRemote) {
                	//FIXME - needs to consume arcana and spawn meteor
//                	&& ArcanaHelper.getProperties(player).useBar(35)) {
                	EntityThrowable entity = new EntityMeteor(world, (double) blockX + 0.5D, (double) blockY + 25D, (double) blockZ + 0.5D);
        			entity.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
        			world.spawnEntity(entity);
                    player.playSound(ModSounds.STARLIGHT, 1, 1);
                }
            player.getLook(1);
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn)
    {
    	list.add(TooltipHelper.getInfoText("tooltip.meteormash"));
        list.add(TooltipLocalizer.arcanaConsumed(35));
        list.add(TooltipLocalizer.infiniteUses());
    }
}