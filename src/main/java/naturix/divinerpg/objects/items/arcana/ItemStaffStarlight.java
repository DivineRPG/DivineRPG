package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityStar;
import naturix.divinerpg.objects.items.base.ItemModRanged;
import naturix.divinerpg.objects.items.base.ItemProjectileShooter;
import naturix.divinerpg.objects.items.vethea.ItemStaff;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemStaffStarlight extends ItemModRanged {

    public ItemStaffStarlight(String name) {
        super(name, -1, ModSounds.STARLIGHT, EntityStar.class);
        ItemProjectileShooter.gunList.add(this);
        this.setFull3D();
        ItemStaff.staffList.add(this);
    }

    @Override
	public @Nonnull ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull EntityPlayer player, @Nonnull EnumHand hand) {
		RayTraceResult pos = player.rayTrace(32, 1);
		ItemStack stack = new ItemStack(player.getHeldItem(hand).getItem());
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

            if (stack.getItem() == ModItems.staffStarlight) {
                if (!world.isRemote) {
                	//FIXME - needs to consume arcana
//                		&& ArcanaHelper.getProperties(player).useBar(25)) {
                    for (int i = 0; i < 8; i++)
                        world.spawnEntity(new EntityStar(world, (double) blockX + 0.5D, (double) blockY + 25D, (double) blockZ + 0.5D));
                    player.playSound(ModSounds.STARLIGHT, 1, 0.5f);
                }
            } else {
            	if (!world.isRemote) {
                	//FIXME - needs to consume arcana
//                		&& ArcanaHelper.getProperties(player).useBar(5)) {
                    world.spawnEntity(new EntityStar(world, (double) blockX + 0.5D, (double) blockY + 25D, (double) blockZ + 0.5D));
                    player.playSound(ModSounds.STARLIGHT, 1, 1);
                }
            }
            player.getLook(1);
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItemMainhand());
    }

    @Override
    protected void addAdditionalInformation(ItemStack stack, @Nullable World worldIn, List<String> list,
            ITooltipFlag flagIn) {
        int damage = 0;
        int arcana = 0;
        boolean stars = false;
        if (stack.getItem() == ModItems.staffStarlight) {
            arcana = 25;
            stars = true;
        } else {
            arcana = 5;
            stars = false;
        }
        list.add(TooltipLocalizer.arcanaConsumed(25));
        //FIXME - needs to allow for translation
        list.add(stars ? "Drops several stars from the sky" : "Drops a star from the sky");
        list.add(TooltipLocalizer.rangedDam(20));
    }
}