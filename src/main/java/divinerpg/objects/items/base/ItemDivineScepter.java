package divinerpg.objects.items.base;

import divinerpg.api.DivineAPI;
import divinerpg.api.arcana.IArcana;
import divinerpg.utils.PositionHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemDivineScepter extends ItemMod {
    public ItemDivineScepter(String name,
                             CreativeTabs tab) {
        super(name, tab);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (tryConsumeArcana(DivineAPI.getArcana(playerIn))) {

            if (!playerIn.isCreative()) {
                playerIn.getHeldItem(handIn).damageItem(1, playerIn);
            }

            Tuple<Vec3d, Vec3d> vecs = PositionHelper.getRayTraceVecs(playerIn, getRange());

            Vec3d start = vecs.getFirst();
            Vec3d end = vecs.getSecond();

            RayTraceResult blockHit = worldIn.rayTraceBlocks(start, end, true, false, true);

            if (blockHit != null && blockHit.typeOfHit == RayTraceResult.Type.BLOCK) {
                if (onBlockHit(worldIn, playerIn, blockHit.getBlockPos())) {
                    return trySpawnParticles(playerIn, handIn, blockHit.getBlockPos());
                }
            }

            Entity victim = PositionHelper.rayTrace(playerIn, getRange());

            if (victim != null && onEntityHit(worldIn, playerIn, victim)) {
                return trySpawnParticles(playerIn, handIn, victim.getPosition());
            }
        }


        return new ActionResult<>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
    }

    /**
     * Tries to spawn particles on client side only
     * always return true
     *
     * @param player - player
     * @param hand   - hand
     * @param end    - target position
     * @return
     */
    private ActionResult<ItemStack> trySpawnParticles(EntityPlayer player, EnumHand hand, BlockPos end) {
        if (player.world.isRemote) {
            spawnParticle(player.world, player.getPositionEyes(1), end);
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @SideOnly(Side.CLIENT)
    protected void spawnParticle(World world, Vec3d start, BlockPos endRaw) {
        Vec3d end = new Vec3d(endRaw);

        // step is 1 block
        Vec3d step = end.subtract(start).normalize();

        while (start.distanceTo(end) > 1) {
            world.spawnParticle(EnumParticleTypes.FLAME, start.x, start.y, start.z, step.x, step.y, step.z);
            start = start.add(step);
        }
    }

    /**
     * Range of ray trace
     *
     * @return
     */
    protected abstract float getRange();

    /**
     * Checks if arcana is enougn and consumes it
     *
     * @param playerArcana - player arcana
     * @return
     */
    protected boolean tryConsumeArcana(IArcana playerArcana) {
        return true;
    }

    /**
     * Called on block hit. Returns success of operation
     *
     * @param world   - world
     * @param shooter - shooter
     * @param hitpos  - hitted pos
     */
    protected boolean onBlockHit(World world, EntityPlayer shooter, BlockPos hitpos) {
        return false;
    }

    /**
     * Called on entity hit. Returns success of operation
     *
     * @param world   - current world
     * @param shooter - player shooter
     * @param victim  - hitted entity
     */
    protected boolean onEntityHit(World world, EntityPlayer shooter, Entity victim) {
        return false;
    }
}
