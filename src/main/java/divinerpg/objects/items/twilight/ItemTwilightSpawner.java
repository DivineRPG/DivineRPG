package divinerpg.objects.items.twilight;

import divinerpg.objects.entities.entity.twilight.EntityDensos;
import divinerpg.objects.entities.entity.twilight.EntityEternalArcher;
import divinerpg.objects.entities.entity.twilight.EntityKarot;
import divinerpg.objects.entities.entity.twilight.EntityReyvor;
import divinerpg.objects.entities.entity.twilight.EntitySoulFiend;
import divinerpg.objects.entities.entity.twilight.EntityTwilightDemon;
import divinerpg.objects.entities.entity.twilight.EntityVamacheron;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModDimensions;
import divinerpg.registry.ModItems;
import divinerpg.utils.TooltipHelper;
import divinerpg.utils.log.Logging;
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
        this.setCreativeTab(DivineRPGTabs.spawner);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        if (!world.isRemote) {
            if (world.provider.getDimensionType().getId() == ModDimensions.mortumDimension.getId()) {
                if (stack.getItem() == ModItems.karotCrystal) {
                    EntityKarot e = new EntityKarot(world);
                    e.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                    if (world.getCollisionBoxes(e, e.getEntityBoundingBox()).isEmpty()) {
                        world.spawnEntity(e);
                        if (!player.capabilities.isCreativeMode) {
                            stack.shrink(1);
                        }
                        return EnumActionResult.SUCCESS;
                    }
                } else if (stack.getItem() == ModItems.densosCrystal || stack.getItem() == ModItems.reyvorCrystal) {
                    EntityDensos e = new EntityDensos(world);
                    EntityReyvor e1 = new EntityReyvor(world);
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
                    EntitySoulFiend e = new EntitySoulFiend(world);
                    e.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                    if (world.getCollisionBoxes(e, e.getEntityBoundingBox()).isEmpty()) {
                        world.spawnEntity(e);
                        if (!player.capabilities.isCreativeMode) {
                            stack.shrink(1);
                        }
                        return EnumActionResult.SUCCESS;
                    }
                } else if (stack.getItem() == ModItems.twilightDemonCrystal) {
                    EntityTwilightDemon e = new EntityTwilightDemon(world);
                    e.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                    if (world.getCollisionBoxes(e, e.getEntityBoundingBox()).isEmpty()) {
                        world.spawnEntity(e);
                        if (!player.capabilities.isCreativeMode) {
                            stack.shrink(1);
                        }
                        return EnumActionResult.SUCCESS;
                    }
                } else if (stack.getItem() == ModItems.vamacheronCrystal) {
                    EntityVamacheron e = new EntityVamacheron(world);
                    e.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                    if (world.getCollisionBoxes(e, e.getEntityBoundingBox()).isEmpty()) {
                        world.spawnEntity(e);
                        if (!player.capabilities.isCreativeMode) {
                            stack.shrink(1);
                        }
                        return EnumActionResult.SUCCESS;
                    }
                } else if (stack.getItem() == ModItems.eternalArcherCrystal) {
                    EntityEternalArcher e = new EntityEternalArcher(world);
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