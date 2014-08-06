package net.divinerpg.api.items;

import java.util.List;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemModBow extends ItemBow {

    public static final int                DEFAULT_MAX_USE_DURACTION = 72000;
    @SideOnly(Side.CLIENT)
    protected IIcon[]                      IIconArray;
    protected String                       name;
    protected String                       textureName;
    protected final String[]               texture;
    protected int                          damage;
    protected int                          maxUseDuraction;
    protected boolean                      unbreakable;
    protected Item                         arrow;
    protected Class<? extends EntityArrow> arrowClazz;
    protected boolean                      needArrow = true;

    public ItemModBow(String name, int uses, int damage, Item arrow, Class<? extends EntityArrow> arrowClazz) {
        this(name, uses, damage, DEFAULT_MAX_USE_DURACTION, arrow, arrowClazz);
    }
    
    public ItemModBow(String name, int uses, int damage, Class<? extends EntityArrow> arrowClazz) {
        this(name, uses, damage, DEFAULT_MAX_USE_DURACTION, null, arrowClazz);
    }
    
    public ItemModBow(String name, int uses, int damage, int maxUseDuraction, Class<? extends EntityArrow> arrowClazz) {
        this(name, uses, damage, maxUseDuraction, null, arrowClazz);
    }

    public ItemModBow(String name, int uses, int damage, int maxUseDuraction, Item arrow, Class<? extends EntityArrow> arrowClazz) {
        setMaxDamage(uses);
        this.name = name;
        this.textureName = Reference.PREFIX + name;
        if (arrow == null) needArrow = false;
        else this.arrow = arrow;
        this.damage = damage;
        this.maxUseDuraction = maxUseDuraction;
        unbreakable = true;
        this.maxStackSize = 1;
        this.setCreativeTab(DivineRPGTabs.ranged);
        this.texture = new String[] { textureName + "_0", textureName + "_1", textureName + "_2", textureName + "_3" };
        this.arrowClazz = arrowClazz;
        setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        LangRegistry.addItem(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon) {
        itemIcon = icon.registerIcon(texture[0]);
        IIconArray = new IIcon[texture.length];
        for(int i = 0; i < texture.length; i++)
            IIconArray[i] = icon.registerIcon(texture[i]);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int icon) {
        return IIconArray[icon];
    }

    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        if (player.getItemInUse() == null) return itemIcon;
        int pulling = stack.getMaxItemUseDuration() - useRemaining;
        if (pulling >= 18) return IIconArray[3];
        if (pulling > 13) return IIconArray[2];
        if (pulling > 0) return IIconArray[1];
        return IIconArray[0];
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int itemUseCount) {
        int maxItemUse = getMaxItemUseDuration(stack) - itemUseCount;
        ArrowLooseEvent event = new ArrowLooseEvent(player, stack, maxItemUse);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) return;
        maxItemUse = event.charge;
        boolean infiniteAmmo = !needArrow || player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;
        if (infiniteAmmo || player.inventory.hasItem(arrow)) {
            float scaledItemUse = (float) maxItemUse / 20.0F;
            scaledItemUse = (scaledItemUse * scaledItemUse + scaledItemUse * 2) / 3;
            if ((double) scaledItemUse < 0.1) return;
            if (scaledItemUse > 1) scaledItemUse = 1;
            EntityArrow entityarrow = null;
            try {
                entityarrow = arrowClazz.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, scaledItemUse * 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (scaledItemUse == 1) entityarrow.setIsCritical(true);
            int powerLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);
            if (powerLevel > 0) entityarrow.setDamage(entityarrow.getDamage() + (double) powerLevel * 0.5 + 0.5);
            int punchLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);
            if (punchLevel > 0) entityarrow.setKnockbackStrength(punchLevel);
            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0) entityarrow.setFire(100);
            if (!unbreakable) stack.damageItem(1, player);
            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + scaledItemUse * 0.5F);
            if (infiniteAmmo) entityarrow.canBePickedUp = 2;
            else player.inventory.consumeInventoryItem(arrow);
            if (!world.isRemote) world.spawnEntityInWorld(entityarrow);
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return maxUseDuraction;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(damage + " Max Ranged Damage");
        double speed = (double) DEFAULT_MAX_USE_DURACTION / (double) getMaxItemUseDuration(stack);
        if (speed > 1) list.add(Util.GOLD + speed + EnumChatFormatting.RESET + " Times Faster");
        if (speed < 1) list.add(Util.GOLD + (1 / speed) + EnumChatFormatting.RESET + " Times Slower");
        list.add(!unbreakable ? (stack.getMaxDamage() - stack.getItemDamage() + " Uses Remaining") : "Unlimited Uses");
        list.add(Util.DARK_AQUA + Reference.MOD_NAME);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack list, World world, EntityPlayer player) {
        ArrowNockEvent nockEvent = new ArrowNockEvent(player, list);
        MinecraftForge.EVENT_BUS.post(nockEvent);
        if (nockEvent.isCanceled()) return nockEvent.result;
        if (player.capabilities.isCreativeMode || player.inventory.hasItem(arrow))
            player.setItemInUse(list, this.getMaxItemUseDuration(list));
        return list;
    }
}