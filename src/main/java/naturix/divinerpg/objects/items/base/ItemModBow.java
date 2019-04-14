package naturix.divinerpg.objects.items.base;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.enums.ArrowType;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityArrowShot;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemModBow extends ItemBow implements IHasModel {
    private net.minecraft.util.SoundEvent shootSound = SoundEvents.ENTITY_ARROW_SHOOT;
    public static final int DEFAULT_MAX_USE_DURATION = 72000;
    protected ArrowType arrowType;
    protected int maxUseDuration;
    protected boolean unbreakable;
    protected Item arrowAmmo = null;
    protected boolean needArrow = true;
    private boolean vethean = false;
    public String name;

    public ItemModBow(String name, ArrowType arrowType, int uses, Item arrow) {
        this(name, arrowType, uses, DEFAULT_MAX_USE_DURATION, arrow);
    }

    public ItemModBow(String name, ArrowType arrowType, int uses) {
        this(name, arrowType, uses, DEFAULT_MAX_USE_DURATION, null);
    }

    public ItemModBow(String name, ArrowType arrowType, int uses, int maxUseDuration) {
        this(name, arrowType, uses, maxUseDuration, null);
    }

    public ItemModBow(String name, ArrowType arrowType, int uses, int maxUseDuration, Item arrowAmmo) {
        setMaxDamage(uses);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.arrowType = arrowType;
        this.arrowAmmo = arrowAmmo;
        if (arrowAmmo == null)
            needArrow = false;
        this.setCreativeTab(DRPGCreativeTabs.ranged);
        this.maxUseDuration = maxUseDuration;
        unbreakable = true;
        this.maxStackSize = 1;

        addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter() {
            @Override
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {

                if (entityIn == null) {
                    return 0.0F;
                } else {
                    ItemStack itemstack = entityIn.getActiveItemStack();
                    return !itemstack.isEmpty() && itemstack.getItem() instanceof ItemModBow ?
                            (stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F : 0.0F;
                }
            }
        });
        addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter() {
            @Override
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {

                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F :
                        0.0F;
            }
        });

        ModItems.ITEMS.add(this);
    }

    @Override
    protected boolean isArrow(ItemStack stack) {
        return stack.getItem() == this.arrowAmmo;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TooltipLocalizer.bowDam(arrowType.getMinDamage() + "-" + arrowType.getMaxDamage()));
        double speed = (double) DEFAULT_MAX_USE_DURATION / (double) getMaxItemUseDuration(stack);
        if (speed > 1)
            tooltip.add(speed + " Times Faster");
        if (speed < 1)
            tooltip.add((1 / speed) + " Times Slower");
        tooltip.add(!unbreakable ? TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getItemDamage()) :
                TooltipLocalizer.infiniteUses());
        if (arrowType.poisonDamage())
            tooltip.add(TooltipLocalizer.poison(2));
        if (arrowType.fireDamage())
            tooltip.add(TooltipLocalizer.burn(12));
        if (arrowType.explosionDamage())
            tooltip.add(TooltipLocalizer.explosiveShots());
        tooltip.add(this.needArrow ? TooltipLocalizer.ammo(this.arrowAmmo) : TooltipLocalizer.infiniteAmmo());
        if (this.vethean)
            tooltip.add(TooltipLocalizer.vethean());
    }

    private ItemStack findAmmo(EntityPlayer player) {
        if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND))) {
            return player.getHeldItem(EnumHand.OFF_HAND);
        } else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND))) {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        } else {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
                ItemStack itemstack = player.inventory.getStackInSlot(i);
                if (this.isArrow(itemstack)) {
                    return itemstack;
                }
            }
            return ItemStack.EMPTY;
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return this.maxUseDuration;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        boolean hasAmmo = (!needArrow || !this.findAmmo(player).isEmpty());
        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(stack, world, player, hand,
                hasAmmo);
        if (ret != null) {
            return ret;
        }
        if (!player.capabilities.isCreativeMode && !hasAmmo) {
            return !hasAmmo ? new ActionResult<>(EnumActionResult.FAIL, stack) :
                    new ActionResult<>(EnumActionResult.PASS, stack);
        } else {
            player.setActiveHand(hand);
            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        }
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer) entityLiving;
            boolean infiniteAmmo = !needArrow || entityplayer.capabilities.isCreativeMode
                    || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemstack = this.findAmmo(entityplayer);

            int charge = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer,
                    this.maxUseDuration - timeLeft, !itemstack.isEmpty() || infiniteAmmo);
            if (charge < 0)
                return;

            if (!itemstack.isEmpty() || infiniteAmmo) {
                float f = getArrowVelocity(charge);
                if ((double) f >= 0.1D) {
                    if (!worldIn.isRemote) {
                        EntityArrowShot entityarrow = new EntityArrowShot(worldIn, arrowType, entityplayer);
                        entityarrow.setAmmoItem(arrowAmmo);
                        entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F,
                                f * 3.0F, 1.0F);
                        if (f == 1.0F) {
                            entityarrow.setIsCritical(true);
                        }
                        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
                        if (j > 0) {
                            entityarrow.setDamage(entityarrow.getDamage() + (double) j * 0.5D + 0.5D);
                        }
                        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
                        if (k > 0) {
                            entityarrow.setKnockbackStrength(k);
                        }
                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                            entityarrow.setFire(100);
                        }
                        if (!unbreakable)
                            stack.damageItem(1, entityplayer);
                        worldIn.spawnEntity(entityarrow);
                    }
                    worldIn.playSound((EntityPlayer) null, entityplayer.posX, entityplayer.posY, entityplayer.posZ,
                            this.shootSound, SoundCategory.MASTER, 1.0F,
                            1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!infiniteAmmo) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            entityplayer.inventory.deleteStack(itemstack);
                        }
                    }
                    entityplayer.addStat(StatList.getObjectUseStats(this));
                }
            }
        }
    }

    public ItemModBow setSound(net.minecraft.util.SoundEvent shootSound) {
        this.shootSound = shootSound;
        return this;
    }

    public ItemModBow setVethean() {
        this.setCreativeTab(DRPGCreativeTabs.vethea);
        this.vethean = true;
        return this;
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(this, 0, name);
    }
}
