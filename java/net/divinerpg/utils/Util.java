package net.divinerpg.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.divinerpg.DivineRPG;
import net.divinerpg.blocks.base.BlockModSlab;
import net.divinerpg.items.base.ItemModSlab;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class Util {
	
	private static final String[] devs = { "RadioactiveStud", "Eternaldoom1", "BossLetsPlays", "Xolova", "sheenrox82", "The_SlayerMC", "insanity414all", "deathman12e3", "Fire_Sight", "krwminer" };

    public static int      mobID                  = 500, projectileID = 0, entityListID = 2500;

    private static Object  reflectionFactory      = null;
    private static Method  newConstructorAccessor = null;
    private static Method  newInstance            = null;
    private static Method  newFieldAccessor       = null;
    private static Method  fieldAccessorSet       = null;
    private static boolean isSetup                = false;
    public static String   mobName;
    
    public static void addRecipe(ItemStack i, Object... o) {
        GameRegistry.addRecipe(i, o);
    }


    public static void addBucket(Fluid fluid, ItemStack modBucket) {
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(fluid.getName(), FluidContainerRegistry.BUCKET_VOLUME), modBucket, new ItemStack(Items.bucket));
    }

    public static void postForgeEvent(Object o) {
        MinecraftForge.EVENT_BUS.register(o);
    }

    public static void postFMLEvent(Object o) {
        FMLCommonHandler.instance().bus().register(o);
    }

    public static void addShapelessRecipe(ItemStack i, Object... o) {
        GameRegistry.addShapelessRecipe(i, o);
    }

    public static void addSmelting(ItemStack input, ItemStack output, float XP) {
        GameRegistry.addSmelting(input, output, XP);
    }

    public static void registerDivineRPGMob(Class entityClass, String entityName) {
    	LangRegistry.addMob(entityName);
        EntityRegistry.registerModEntity(entityClass, entityName, mobID++, DivineRPG.instance, 128, 3, true);
        int id = entityListID++;
        entityName = "DRPG" + entityName;
        EntityList.stringToClassMapping.put(entityName, entityClass);
        EntityList.classToStringMapping.put(entityClass, entityName);
        EntityList.idToClassMap.put(id, entityClass);
        ((Map)ObfuscationReflectionHelper.getPrivateValue(EntityList.class, null, new String[]{"f", "field_75624_e", "classToIDMapping"})).put(entityClass, id);
        ((Map)ObfuscationReflectionHelper.getPrivateValue(EntityList.class, null, new String[]{"g", "field_75622_f", "stringToIDMapping"})).put(entityName, id);
        EntityList.entityEggs.put(id, new EntityEggInfo(id, 0x000000, 0xFFFFFF));
    }
    
    public static void registerEgglessMob(Class entityClass, String entityName) {
        LangRegistry.addMob(entityName);
        EntityRegistry.registerModEntity(entityClass, entityName, mobID++, DivineRPG.instance, 128, 3, true);
        int id = entityListID++;
        entityName = "DRPG" + entityName;
        EntityList.stringToClassMapping.put(entityName, entityClass);
        EntityList.classToStringMapping.put(entityClass, entityName);
        EntityList.idToClassMap.put(id, entityClass);
        ((Map)ObfuscationReflectionHelper.getPrivateValue(EntityList.class, null, new String[]{"f", "field_75624_e", "classToIDMapping"})).put(entityClass, id);
        ((Map)ObfuscationReflectionHelper.getPrivateValue(EntityList.class, null, new String[]{"g", "field_75622_f", "stringToIDMapping"})).put(entityName, id);
    }

    public static void registerProjectile(Class entityClass, String entityName) {
        EntityRegistry.registerModEntity(entityClass, entityName + "Projectile", projectileID, DivineRPG.instance, 250, 5, true);
        projectileID++;
    }

    public static ArmorMaterial addArmorMaterial(String name, int durability, int enchantability, Item repair) {
        int duraNew = (int) Math.round(durability / 13.75);
        ArmorMaterial mat = EnumHelper.addEnum(ArmorMaterial.class, name, duraNew, new int[] {0, 0, 0, 0}, enchantability);
        mat.customCraftingMaterial = repair;
        return mat;
    }
    
    public static ArmorMaterial addArmorMaterial(String name, int durability, int enchantability) {
        int duraNew = (int) Math.round(durability / 13.75);
        return EnumHelper.addEnum(ArmorMaterial.class, name, duraNew, new int[] {0, 0, 0, 0}, enchantability);
    }

    public static ChatComponentTranslation addChatMessage(String str, Object... args) {
        ChatComponentTranslation ret = new ChatComponentTranslation(str, args);
        ret.getChatStyle().setColor(EnumChatFormatting.WHITE);
        return ret;
    }
    
    public static ChatComponentTranslation addChatMessage(EnumChatFormatting color, String str, Object... args) {
        ChatComponentTranslation ret = new ChatComponentTranslation(str, args);
        ret.getChatStyle().setColor(color);
        return ret;
    }

    public static IChatComponent getChatComponent(String str) {
        ChatComponentText ret = new ChatComponentText(str);
        return ret;
    }

    public static String BLACK = "\u00a70", DARK_BLUE = "\u00a71", DARK_GREEN = "\u00a72", DARK_AQUA = "\u00a73", DARK_RED = "\u00a74";
    public static String DARK_PURPLE = "\u00a75", GOLD = "\u00a76", GRAY = "\u00a77", DARK_GRAY = "\u00a78", BLUE = "\u00a79";
    public static String GREEN       = "\u00a7a", AQUA = "\u00a7b", RED = "\u00a7c", LIGHT_PURPLE = "\u00a7d", YELLOW = "\u00a7e";
    public static String WHITE       = "\u00a7f";

    public static void registerItemRenderer(Item i, IItemRenderer te) {
        MinecraftForgeClient.registerItemRenderer(i, te);
    }

    public static void registerItemRenderer(Block b, IItemRenderer te) {
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(b), te);
    }

    public static void sendMessageToAll(ChatComponentTranslation chatComponentTranslation) {
    	MinecraftServer.getServer().getConfigurationManager().sendChatMsg(chatComponentTranslation);
    }
    
    public static void sendMessageToAll(String message) {
    	MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentTranslation(message));
    }
    public static void sendMessageToAll(String message, String color) {
    	MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentTranslation(AQUA + "[" + BLUE + "DivineRPG" + AQUA + "] " + color + message));
    }

    public static ToolMaterial addMeleeMaterial(int maxUses, float damage, int enchantability, Item repair) {
        return EnumHelper.addEnum(ToolMaterial.class, "", 0, maxUses, 0, damage - 5, enchantability).setRepairItem(new ItemStack(repair, 1));
    }
    
    public static ToolMaterial addHammerMaterial(float damage) {
        return EnumHelper.addToolMaterial("sword", 0, -1, 0, damage - 4, 22);
    }

    public static ToolMaterial addMeleeMaterial(float damage, int enchantability) {
        return EnumHelper.addEnum(ToolMaterial.class, "", 0, -1, 0, damage - 5, enchantability);
    }

    public static ToolMaterial addAxeMaterial(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, Item repair) {
        return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, maxUses, efficiency, damage - 4, enchantability).setRepairItem(new ItemStack(repair, 1));
    }

    public static ToolMaterial addAxeMaterial(int harvestLevel, float efficiency, float damage, int enchantability) {
        return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, -1, efficiency, damage - 4, enchantability);
    }

    public static ToolMaterial addPickMaterial(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, Item repair) {
        return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, maxUses, efficiency, damage - 3, enchantability).setRepairItem(new ItemStack(repair, 1));
    }

    public static ToolMaterial addPickMaterial(int harvestLevel, float efficiency, float damage, int enchantability) {
        return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, -1, efficiency, damage - 3, enchantability);
    }

    public static ToolMaterial addSpadeMaterial(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, Item repair) {
        return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, maxUses, efficiency, damage - 2, enchantability).setRepairItem(new ItemStack(repair, 1));
    }

    public static ToolMaterial addSpadeMaterial(int harvestLevel, float efficiency, float damage, int enchantability) {
        return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, -1, efficiency, damage - 2, enchantability);
    }

    public static ToolMaterial addShickMaterial(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, Item repair) {
        return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, maxUses, efficiency, damage - 1, enchantability).setRepairItem(new ItemStack(repair, 1));
    }

    public static ToolMaterial addShickMaterial(int harvestLevel, float efficiency, float damage, int enchantability) {
        return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, -1, efficiency, damage - 1, enchantability);
    }
    
    public static Item toItem(Block block){
        return Item.getItemFromBlock(block);
    }
    
    public static void registerSlab(Block single, Block stack) {
        GameRegistry.registerBlock(single, ItemModSlab.class, ((BlockModSlab)single).NAME, (BlockModSlab)single, (BlockModSlab)stack, false);
        GameRegistry.registerBlock(stack, ItemModSlab.class, ((BlockModSlab)stack).NAME + "Double", (BlockModSlab)single, (BlockModSlab)stack, true);
    }
    
    //TODO: USE UUIDs!!!!!!!!!!!!!!!!!!!
    public static boolean isDeveloperName(String name) {
		for(int i = 0; i < devs.length; i++){
			if(name.equalsIgnoreCase(devs[i]))return true;
		}
		return false;
	}
    
    public static DamageSource causeArcanaDamage(Entity projectile, Entity shooter) {
        return new EntityDamageSourceIndirect("arrow", projectile, shooter).setMagicDamage();
    }
    
    public static DamageSource acidSource = new DamageSource("acid");
    public static DamageSource trapSource = new DamageSource("trap");
    public static DamageSource arcanaSource = new DamageSource("arcana");
    public static DamageSource spikeSource = new DamageSource("spikes");
    
    public static ChunkCoordinates getPlayerSpawnChunk(EntityPlayer player) {
    	String[] spawnChunkNames = new String[] { "c", "field_71077_c", "spawnChunk" };
    	ChunkCoordinates coords = (ChunkCoordinates)ObfuscationReflectionHelper.getPrivateValue(EntityPlayer.class, player, spawnChunkNames);
    	return coords;
    }
    
    public static HashMap<Integer, ChunkCoordinates> getPlayerSpawnChunkMap(EntityPlayer player) {
        String[] spawnChunkMapNames = new String[] { "spawnChunkMap", "spawnChunkMap", "spawnChunkMap" };
        HashMap<Integer, ChunkCoordinates> map = (HashMap<Integer, ChunkCoordinates>)ObfuscationReflectionHelper.getPrivateValue(EntityPlayer.class, player, spawnChunkMapNames);
        return map;
    }
    
    public static Entity findEntityByUUID(String uuid, World world) {
		for(int i = 0; i < world.loadedEntityList.size(); i++) {
		    Entity e = (Entity)world.loadedEntityList.get(i);
			if(((Entity)world.loadedEntityList.get(i)).getPersistentID().toString().equals(uuid)) {
				return ((Entity)world.loadedEntityList.get(i));
			}
		}
		return null;
	}
    
    public static void drawTexturedModalRect(int x1, int y1, int u, int v, int x2, int y2) {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(x1 + 0), (double)(y1 + y2), 1D, (double)((float)(u + 0) * f), (double)((float)(v + y2) * f1));
        tessellator.addVertexWithUV((double)(x1 + x2), (double)(y1 + y2), 1D, (double)((float)(u + x2) * f), (double)((float)(v + y2) * f1));
        tessellator.addVertexWithUV((double)(x1 + x2), (double)(y1 + 0), 1D, (double)((float)(u + x2) * f), (double)((float)(v + 0) * f1));
        tessellator.addVertexWithUV((double)(x1 + 0), (double)(y1 + 0), 1D, (double)((float)(u + 0) * f), (double)((float)(v + 0) * f1));
        tessellator.draw();
    }
    
    public static MovingObjectPosition rayTrace(EntityPlayer player, double distance) {
        Vec3 pos = Vec3.createVectorHelper(player.posX, player.posY + player.getEyeHeight(), player.posZ);
        Vec3 look = player.getLook(1);
        Vec3 vec32 = pos.addVector(look.xCoord * distance, look.yCoord * distance, look.zCoord * distance);
        return player.worldObj.rayTraceBlocks(pos, vec32, false, false, true);
    }
    
    public static boolean bordersTar(World w, int x, int y, int z) {
        for (int i = x - 4; i <= x + 4; ++i) {
            for (int j = y; j <= y + 1; ++j) {
                for (int k = z - 4; k <= z + 4; ++k) {
                    if (w.getBlock(i, j, k) == VanillaBlocks.tar) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    
    public static ChunkCoordinates newChunkCoordinates(int x, int y, int z) {
        ChunkCoordinates c = new ChunkCoordinates();
        c.set(x, y, z);
        return c;
    }
}
