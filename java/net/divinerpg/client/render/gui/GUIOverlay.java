package net.divinerpg.client.render.gui;

import java.io.IOException;
import java.net.SocketException;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.events.EventArmorTick;
import net.divinerpg.utils.events.UpdateChecker;
import net.divinerpg.utils.items.TwilightItemsArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GUIOverlay {
    private String           text    = "";
    private String           text2   = "";
    public static int        guiTick = 600;
    private boolean          seen    = false;
    private ScaledResolution res;

    public void drawOverlay() {
        res = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
        text = Reference.MOD_NAME + " " + Util.GREEN + Reference.MOD_VERSION;

        if (!seen && ConfigurationHelper.updateChecker) {
            try {
                if (!UpdateChecker.isOnline()) {
                    text2 = Util.DARK_PURPLE + "Offline";
                } else if (UpdateChecker.isUpdateAvailable()) {
                    text2 = Util.DARK_BLUE + "DivineRPG: " + Util.DARK_RED + "Update Available (" + UpdateChecker.getCurrentVersion() + ")";
                } else {
                    text2 = "";
                }
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            seen = true;
        }

        GL11.glDisable(GL11.GL_BLEND);

        if (Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(EnumChatFormatting.DARK_BLUE + text, 2, res.getScaledHeight() - 10, 4210752);
        } else if (!Minecraft.getMinecraft().gameSettings.showDebugInfo && guiTick > 0) {
            Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(text2, 2, 2, 4210752);
        }
    }

    private static final ResourceLocation r = new ResourceLocation(Reference.PREFIX + "textures/gui/armorBar.png");;

    public void drawArmor() {
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        res = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
        int x = (res.getScaledWidth() / 2) - 11;
        int y = res.getScaledHeight() - 49;

        Item                 boots          = null;
        Item                 body           = null;
        Item                 legs           = null;
        Item                 helmet         = null;
        ItemStack stackBoots = Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(0);
        ItemStack stackLegs = Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(1);
        ItemStack stackBody = Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(2);
        ItemStack stackHelmet = Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(3);

        float speedMultiplier = 1;

        if (stackBoots != null) boots = stackBoots.getItem();
        else boots = null;

        if (stackBody != null) body = stackBody.getItem();
        else body = null;

        if (stackLegs != null) legs = stackLegs.getItem();
        else legs = null;

        if (stackHelmet != null) helmet = stackHelmet.getItem();
        else helmet = null;

        int size = 0;
        if (boots == TwilightItemsArmor.haliteBoots && legs == TwilightItemsArmor.haliteLeggings && body == TwilightItemsArmor.haliteChestplate && helmet == TwilightItemsArmor.haliteHelmet)
            size = 1;

        switch (size) {
            case 1:
                Minecraft.getMinecraft().getTextureManager().bindTexture(r);
                Util.drawTexturedModalRect(x, y, 0, 0, 9, 9);
                break;
            case 2: //Not used. Here if we need it.
                Minecraft.getMinecraft().getTextureManager().bindTexture(r);
                Util.drawTexturedModalRect(x, y, 9, 0, 18, 9);
                break;
        }
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }
}
