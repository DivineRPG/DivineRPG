package divinerpg.client.screen;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import divinerpg.client.menu.AltarOfCorruptionMenu;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.*;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Holder;
import net.minecraft.core.IdMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.api.distmarker.*;

import java.util.List;
import java.util.Optional;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.client.model.geom.ModelLayers.BOOK;
import static net.minecraft.core.registries.Registries.ENCHANTMENT;

@OnlyIn(Dist.CLIENT)
public class AltarOfCorruptionScreen extends AbstractContainerScreen<AltarOfCorruptionMenu> {
    //TODO: to split sprites just like vanilla
    private static final ResourceLocation ENCHANTING_TABLE_LOCATION = ResourceLocation.fromNamespaceAndPath(MODID, "textures/gui/altar_of_corruption.png");
    private static final ResourceLocation ENCHANTING_BOOK_LOCATION = ResourceLocation.fromNamespaceAndPath(MODID, "textures/model/altar_book.png");
    private final RandomSource random = RandomSource.create();
    private BookModel bookModel;
    public int time;
    public float flip, oFlip, flipT, flipA, open, oOpen;
    private ItemStack last = ItemStack.EMPTY;
    public AltarOfCorruptionScreen(AltarOfCorruptionMenu menu, Inventory inventory, Component component) {super(menu, inventory, component);}
    @Override protected void init() {
        super.init();
        bookModel = new BookModel(minecraft.getEntityModels().bakeLayer(BOOK));
    }
    @Override public void containerTick() {
        super.containerTick();
        tickBook();
    }
    @Override public boolean mouseClicked(double mouseX, double mouseY, int mouseZ) {
        int i = (width - imageWidth) / 2;
        int j = (height - imageHeight) / 2;
        for(int k = 0; k < 3; k++) {
            double d0 = mouseX - (double)(i + 60);
            double d1 = mouseY - (double)(j + 14 + 19 * k);
            if(d0 >= 0 && d1 >= 0 && d0 < 108 && d1 < 19 && menu.clickMenuButton(minecraft.player, k)) {
                minecraft.gameMode.handleInventoryButtonClick(menu.containerId, k);
                return true;
            }
        } return super.mouseClicked(mouseX, mouseY, mouseZ);
    }
    @Override protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int i = (width - imageWidth) / 2;
        int j = (height - imageHeight) / 2;
        guiGraphics.blit(ENCHANTING_TABLE_LOCATION, i, j, 0, 0, imageWidth, imageHeight);
        renderBook(guiGraphics, i, j, partialTick);
        EnchantmentNames.getInstance().initSeed(menu.getEnchantmentSeed());
        int k = menu.getGoldCount();
        for(int l = 0; l < 3; l++) {
            int i1 = i + 60;
            int j1 = i1 + 20;
            int k1 = menu.costs[l];if (k1 == 0) {
                RenderSystem.enableBlend();
                guiGraphics.blit(ENCHANTING_TABLE_LOCATION, i1, j + 14 + 19 * l, 0, 185, 108, 19);
                RenderSystem.disableBlend();
            } else {
                String s = String.valueOf(k1);
                int l1 = 86 - font.width(s);
                FormattedText formattedtext = EnchantmentNames.getInstance().getRandomName(font, l1);
                int i2 = 6839882;
                if(((k < l + 1 || minecraft.player.experienceLevel < k1) && !minecraft.player.getAbilities().instabuild) || menu.enchantClue[l] == -1) {
                    RenderSystem.enableBlend();
                    guiGraphics.blit(ENCHANTING_TABLE_LOCATION, i1, j + 14 + 19 * l, 0, 185, 108, 19);
                    guiGraphics.blit(ENCHANTING_TABLE_LOCATION, i1 + 1, j + 15 + 19 * l, 16 * l, 239, 16, 16);
                    RenderSystem.disableBlend();
                    guiGraphics.drawWordWrap(font, formattedtext, j1, j + 16 + 19 * l, l1, (i2 & 16711422) >> 1);
                    i2 = 4226832;
                } else {
                    int j2 = mouseX - (i + 60);
                    int k2 = mouseY - (j + 14 + 19 * l);
                    if(j2 >= 0 && k2 >= 0 && j2 < 108 && k2 < 19) {
                        guiGraphics.blit(ENCHANTING_TABLE_LOCATION, i1, j + 14 + 19 * l, 0, 204, 108, 19);
                        i2 = 16777088;
                    } else guiGraphics.blit(ENCHANTING_TABLE_LOCATION, i1, j + 14 + 19 * l, 0, 166, 108, 19);
                    guiGraphics.blit(ENCHANTING_TABLE_LOCATION, i1 + 1, j + 15 + 19 * l, 16 * l, 223, 16, 16);
                    RenderSystem.disableBlend();
                    guiGraphics.drawWordWrap(font, formattedtext, j1, j + 16 + 19 * l, l1, i2);
                    i2 = 8453920;
                } guiGraphics.drawString(font, s, j1 + 86 - font.width(s), j + 16 + 19 * l + 7, i2);
            }
        }
    }
    private void renderBook(GuiGraphics guiGraphics, int x, int y, float partialTick) {
        float f = Mth.lerp(partialTick, oOpen, open);
        float f1 = Mth.lerp(partialTick, oFlip, flip);
        Lighting.setupForEntityInInventory();
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate((float)x + 33, (float)y + 31, 100);
        guiGraphics.pose().scale(-40, 40, 40);
        guiGraphics.pose().mulPose(Axis.XP.rotationDegrees(25));
        guiGraphics.pose().translate((1 - f) * .2F, (1 - f) * .1F, (1 - f) * .25F);
        float f3 = -(1 - f) * 90 - 90;
        guiGraphics.pose().mulPose(Axis.YP.rotationDegrees(f3));
        guiGraphics.pose().mulPose(Axis.XP.rotationDegrees(180));
        float f4 = Mth.clamp(Mth.frac(f1 + .25F) * 1.6F - .3F, 0, 1);
        float f5 = Mth.clamp(Mth.frac(f1 + .75F) * 1.6F - .3F, 0, 1);
        bookModel.setupAnim(0, f4, f5, f);
        VertexConsumer vertexconsumer = guiGraphics.bufferSource().getBuffer(bookModel.renderType(ENCHANTING_BOOK_LOCATION));
        bookModel.renderToBuffer(guiGraphics.pose(), vertexconsumer, 15728880, OverlayTexture.NO_OVERLAY);
        guiGraphics.flush();
        guiGraphics.pose().popPose();
        Lighting.setupFor3DItems();
    }
    @Override public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        renderTooltip(guiGraphics, mouseX, mouseY);
        boolean flag = minecraft.player.getAbilities().instabuild;
        int i = menu.getGoldCount();
        for(int j = 0; j < 3; j++) {
            int k = menu.costs[j];
            Optional<Holder.Reference<Enchantment>> optional = minecraft.level.registryAccess().registryOrThrow(ENCHANTMENT).getHolder(menu.enchantClue[j]);
            int l = menu.levelClue[j];
            int i1 = j + 1;
            if (isHovering(60, 14 + 19 * j, 108, 17, mouseX, mouseY) && k > 0) {
                List<Component> list = Lists.newArrayList();
                list.add(Component.translatable("container.enchant.clue", optional.isEmpty() ? "" : Enchantment.getFullname(optional.get(), l)).withStyle(ChatFormatting.WHITE));
                if(optional.isEmpty()) {
                    list.add(Component.literal(""));
                    list.add(Component.translatable("neoforge.container.enchant.limitedEnchantability").withStyle(ChatFormatting.RED));
                } else if (!flag) {
                    list.add(CommonComponents.EMPTY);
                    if(minecraft.player.experienceLevel < k) list.add(Component.translatable("container.enchant.level.requirement", menu.costs[j]).withStyle(ChatFormatting.RED));
                    else {
                        MutableComponent mutablecomponent;
                        if (i1 == 1) mutablecomponent = Component.translatable("container.enchant.lapis.one");
                        else mutablecomponent = Component.translatable("container.enchant.lapis.many", i1);
                        list.add(mutablecomponent.withStyle(i >= i1 ? ChatFormatting.GRAY : ChatFormatting.RED));
                        MutableComponent mutablecomponent1;
                        if(i1 == 1) mutablecomponent1 = Component.translatable("container.enchant.level.one");
                        else mutablecomponent1 = Component.translatable("container.enchant.level.many", i1);
                        list.add(mutablecomponent1.withStyle(ChatFormatting.GRAY));
                    }
                } guiGraphics.renderComponentTooltip(font, list, mouseX, mouseY);
                break;
            }
        }
    }
    public void tickBook() {
        ItemStack itemstack = menu.getSlot(0).getItem();
        if(!ItemStack.matches(itemstack, last)) {
            last = itemstack;
            do {
                flipT = flipT + (float)(random.nextInt(4) - random.nextInt(4));
            } while (flip <= flipT + 1 && flip >= flipT - 1);
        } time++;
        oFlip = flip;
        oOpen = open;
        boolean flag = false;

        for(int i = 0; i < 3; i++) {
            if(menu.costs[i] != 0) {
                flag = true;
                break;
            }
        } if(flag) open += .2F;
        else open -= .2F;
        open = Mth.clamp(open, 0, 1);
        float f1 = (flipT - flip) * .4F;
        f1 = Mth.clamp(f1, -.2F, .2F);
        flipA = flipA + (f1 - flipA) * .9F;
        flip = flip + flipA;
    }
}