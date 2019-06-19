package naturix.divinerpg.objects.items.twilight;

import naturix.divinerpg.objects.entities.entity.twilight.Densos;
import naturix.divinerpg.objects.entities.entity.twilight.EternalArcher;
import naturix.divinerpg.objects.entities.entity.twilight.Karot;
import naturix.divinerpg.objects.entities.entity.twilight.Reyvor;
import naturix.divinerpg.objects.entities.entity.twilight.SoulFiend;
import naturix.divinerpg.objects.entities.entity.twilight.TwilightDemon;
import naturix.divinerpg.objects.entities.entity.twilight.Vamacheron;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModDimensions;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.TooltipHelper;
import naturix.divinerpg.utils.log.Logging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemTwilightSpawner extends ItemMod {

    public ItemTwilightSpawner(String name) {
        super(name);
        setMaxStackSize(1);
        this.setCreativeTab(DRPGCreativeTabs.spawner);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        if (!world.isRemote) {
            if (world.provider.getDimensionType().getId() == ModDimensions.mortumDimension.getId()) {
                if (stack.getItem() == ModItems.karotCrystal) {
                    Karot e = new Karot(world);
                    e.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                    if (world.getCollisionBoxes(e, e.getEntityBoundingBox()).isEmpty()) {
                        world.spawnEntity(e);
                        if (!player.capabilities.isCreativeMode) {
                            stack.shrink(1);
                        }
                        return EnumActionResult.SUCCESS;
                    }
                } else if (stack.getItem() == ModItems.densosCrystal || stack.getItem() == ModItems.reyvorCrystal) {
                    Densos e = new Densos(world);
                    Reyvor e1 = new Reyvor(world);
                    e.setPosition(pos.getX() + 1, pos.getY() + 1, pos.getZ());
                    e1.setPosition(pos.getX() - 1, pos.getY() + 1, pos.getZ());
                    if (world.getCollisionBoxes(e, e.getEntityBoundingBox()).isEmpty()
                            && world.getCollisionBoxes(e1, e1.getEntityBoundingBox()).isEmpty()) {
                        world.spawnEntity(e);
                        world.spawnEntity(e1);
                        if (!player.capabilities.isCreativeMode) {
                            stack.shrink(1);
                        }
                        return EnumActionResult.SUCCESS;
                    }
                } else if (stack.getItem() == ModItems.soulFiendCrystal) {
                    SoulFiend e = new SoulFiend(world);
                    e.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                    if (world.getCollisionBoxes(e, e.getEntityBoundingBox()).isEmpty()) {
                        world.spawnEntity(e);
                        if (!player.capabilities.isCreativeMode) {
                            stack.shrink(1);
                        }
                        return EnumActionResult.SUCCESS;
                    }
                } else if (stack.getItem() == ModItems.twilightDemonCrystal) {
                    TwilightDemon e = new TwilightDemon(world);
                    e.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                    if (world.getCollisionBoxes(e, e.getEntityBoundingBox()).isEmpty()) {
                        world.spawnEntity(e);
                        if (!player.capabilities.isCreativeMode) {
                            stack.shrink(1);
                        }
                        return EnumActionResult.SUCCESS;
                    }
                } else if (stack.getItem() == ModItems.vamacheronCrystal) {
                    Vamacheron e = new Vamacheron(world);
                    e.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                    if (world.getCollisionBoxes(e, e.getEntityBoundingBox()).isEmpty()) {
                        world.spawnEntity(e);
                        if (!player.capabilities.isCreativeMode) {
                            stack.shrink(1);
                        }
                        return EnumActionResult.SUCCESS;
                    }
                } else if (stack.getItem() == ModItems.eternalArcherCrystal) {
                    EternalArcher e = new EternalArcher(world);
                    e.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                    if (world.getCollisionBoxes(e, e.getEntityBoundingBox()).isEmpty()) {
                        world.spawnEntity(e);
                        if (!player.capabilities.isCreativeMode) {
                            stack.shrink(1);
                        }
                        return EnumActionResult.SUCCESS;
                    }
                }
            } else {
                Logging.message(player, TextFormatting.AQUA + TooltipHelper.getInfoText("tooltip.mortum_only"));
            }
        }
        return EnumActionResult.FAIL;
    }
}