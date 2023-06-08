package divinerpg.client.containers.screen;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import divinerpg.client.containers.AltarOfCorruptionContainer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.*;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.api.distmarker.*;

import java.util.*;

@OnlyIn(Dist.CLIENT)
public class AltarOfCorruptionScreen extends AbstractContainerScreen<AltarOfCorruptionContainer> {
    private static final ResourceLocation ENCHANTING_TABLE_LOCATION = new ResourceLocation("textures/gui/container/enchanting_table.png");
    private static final ResourceLocation ENCHANTING_BOOK_LOCATION = new ResourceLocation("textures/entity/enchanting_table_book.png");
    private BookModel BOOK_MODEL;
    private final Random random = new Random();
    public int time;
    public float flip;
    public float oFlip;
    public float flipT;
    public float flipA;
    public float open;
    public float oOpen;
    private ItemStack last = ItemStack.EMPTY;

    public AltarOfCorruptionScreen(AltarOfCorruptionContainer p_i51090_1_, Inventory p_i51090_2_, Component p_i51090_3_) {
        super(p_i51090_1_, p_i51090_2_, p_i51090_3_);
    }

    protected void init() {
        super.init();
        this.BOOK_MODEL = new BookModel(this.minecraft.getEntityModels().bakeLayer(ModelLayers.BOOK));
    }

    public boolean mouseClicked(double p_231044_1_, double p_231044_3_, int p_231044_5_) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;

        for(int k = 0; k < 3; ++k) {
            double d0 = p_231044_1_ - (double)(i + 60);
            double d1 = p_231044_3_ - (double)(j + 14 + 19 * k);
            if (d0 >= 0.0D && d1 >= 0.0D && d0 < 108.0D && d1 < 19.0D && this.menu.clickMenuButton(this.minecraft.player, k)) {
                this.minecraft.gameMode.handleInventoryButtonClick((this.menu).containerId, k);
                return true;
            }
        }

        return super.mouseClicked(p_231044_1_, p_231044_3_, p_231044_5_);
    }

    protected void renderBg(GuiGraphics p_282430_, float p_282530_, int p_281621_, int p_283333_) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        p_282430_.blit(ENCHANTING_TABLE_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);
        this.renderBook(p_282430_, i, j, p_282530_);
        EnchantmentNames.getInstance().initSeed((long)this.menu.getEnchantmentSeed());
        int k = this.menu.getGoldCount();

        for(int l = 0; l < 3; ++l) {
            int i1 = i + 60;
            int j1 = i1 + 20;
            int k1 = (this.menu).costs[l];
            if (k1 == 0) {
                p_282430_.blit(ENCHANTING_TABLE_LOCATION, i1, j + 14 + 19 * l, 0, 185, 108, 19);
            } else {
                String s = "" + k1;
                int l1 = 86 - this.font.width(s);
                FormattedText formattedtext = EnchantmentNames.getInstance().getRandomName(this.font, l1);
                int i2 = 6839882;
                if (((k < l + 1 || this.minecraft.player.experienceLevel < k1) && !this.minecraft.player.getAbilities().instabuild) || this.menu.enchantClue[i1] == -1) { // Forge: render buttons as disabled when enchantable but enchantability not met on lower levels
                    p_282430_.blit(ENCHANTING_TABLE_LOCATION, i1, j + 14 + 19 * l, 0, 185, 108, 19);
                    p_282430_.blit(ENCHANTING_TABLE_LOCATION, i1 + 1, j + 15 + 19 * l, 16 * l, 239, 16, 16);
                    p_282430_.drawWordWrap(this.font, formattedtext, j1, j + 16 + 19 * l, l1, (i2 & 16711422) >> 1);
                    i2 = 4226832;
                } else {
                    int j2 = p_281621_ - (i + 60);
                    int k2 = p_283333_ - (j + 14 + 19 * l);
                    if (j2 >= 0 && k2 >= 0 && j2 < 108 && k2 < 19) {
                        p_282430_.blit(ENCHANTING_TABLE_LOCATION, i1, j + 14 + 19 * l, 0, 204, 108, 19);
                        i2 = 16777088;
                    } else {
                        p_282430_.blit(ENCHANTING_TABLE_LOCATION, i1, j + 14 + 19 * l, 0, 166, 108, 19);
                    }

                    p_282430_.blit(ENCHANTING_TABLE_LOCATION, i1 + 1, j + 15 + 19 * l, 16 * l, 223, 16, 16);
                    p_282430_.drawWordWrap(this.font, formattedtext, j1, j + 16 + 19 * l, l1, i2);
                    i2 = 8453920;
                }

                p_282430_.drawString(this.font, s, j1 + 86 - this.font.width(s), j + 16 + 19 * l + 7, i2);
            }
        }

    }

    private void renderBook(GuiGraphics p_289697_, int p_289667_, int p_289669_, float p_289670_) {
        float f = Mth.lerp(p_289670_, this.oOpen, this.open);
        float f1 = Mth.lerp(p_289670_, this.oFlip, this.flip);
        Lighting.setupForEntityInInventory();
        p_289697_.pose().pushPose();
        p_289697_.pose().translate((float)p_289667_ + 33.0F, (float)p_289669_ + 31.0F, 100.0F);
        float f2 = 40.0F;
        p_289697_.pose().scale(-40.0F, 40.0F, 40.0F);
        p_289697_.pose().mulPose(Axis.XP.rotationDegrees(25.0F));
        p_289697_.pose().translate((1.0F - f) * 0.2F, (1.0F - f) * 0.1F, (1.0F - f) * 0.25F);
        float f3 = -(1.0F - f) * 90.0F - 90.0F;
        p_289697_.pose().mulPose(Axis.YP.rotationDegrees(f3));
        p_289697_.pose().mulPose(Axis.XP.rotationDegrees(180.0F));
        float f4 = Mth.clamp(Mth.frac(f1 + 0.25F) * 1.6F - 0.3F, 0.0F, 1.0F);
        float f5 = Mth.clamp(Mth.frac(f1 + 0.75F) * 1.6F - 0.3F, 0.0F, 1.0F);
        this.BOOK_MODEL.setupAnim(0.0F, f4, f5, f);
        VertexConsumer vertexconsumer = p_289697_.bufferSource().getBuffer(this.BOOK_MODEL.renderType(ENCHANTING_BOOK_LOCATION));
        this.BOOK_MODEL.renderToBuffer(p_289697_.pose(), vertexconsumer, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        p_289697_.flush();
        p_289697_.pose().popPose();
        Lighting.setupFor3DItems();
    }

    public void render(GuiGraphics p_283462_, int p_282491_, int p_281953_, float p_282182_) {
        p_282182_ = this.minecraft.getFrameTime();
        this.renderBackground(p_283462_);
        super.render(p_283462_, p_282491_, p_281953_, p_282182_);
        this.renderTooltip(p_283462_, p_282491_, p_281953_);
        boolean flag = this.minecraft.player.getAbilities().instabuild;
        int i = this.menu.getGoldCount();

        for(int j = 0; j < 3; ++j) {
            int k = (this.menu).costs[j];
            Enchantment enchantment = Enchantment.byId((this.menu).enchantClue[j]);
            int l = (this.menu).levelClue[j];
            int i1 = j + 1;
            if (this.isHovering(60, 14 + 19 * j, 108, 17, (double)p_282491_, (double)p_281953_) && k > 0) {
                List<Component> list = Lists.newArrayList();
                list.add((Component.translatable("container.enchant.clue", enchantment == null ? "" : enchantment.getFullname(l))).withStyle(ChatFormatting.WHITE));
                if (enchantment == null) {
                    list.add(Component.literal(""));
                    list.add(Component.translatable("forge.container.enchant.limitedEnchantability").withStyle(ChatFormatting.RED));
                } else if (!flag) {
                    list.add(CommonComponents.EMPTY);
                    if (this.minecraft.player.experienceLevel < k) {
                        list.add(Component.translatable("container.enchant.level.requirement", (this.menu).costs[j]).withStyle(ChatFormatting.RED));
                    } else {
                        MutableComponent mutablecomponent;
                        if (i1 == 1) {
                            mutablecomponent = Component.translatable("container.enchant.lapis.one");
                        } else {
                            mutablecomponent = Component.translatable("container.enchant.lapis.many", i1);
                        }

                        list.add(mutablecomponent.withStyle(i >= i1 ? ChatFormatting.GRAY : ChatFormatting.RED));
                        MutableComponent mutablecomponent1;
                        if (i1 == 1) {
                            mutablecomponent1 = Component.translatable("container.enchant.level.one");
                        } else {
                            mutablecomponent1 = Component.translatable("container.enchant.level.many", i1);
                        }

                        list.add(mutablecomponent1.withStyle(ChatFormatting.GRAY));
                    }
                }

                p_283462_.renderComponentTooltip(this.font, list, p_282491_, p_281953_);
                break;
            }
        }

    }

    public void tickBook() {
        ItemStack itemstack = this.menu.getSlot(0).getItem();
        if (!ItemStack.matches(itemstack, this.last)) {
            this.last = itemstack;

            do {
                this.flipT += (float)(this.random.nextInt(4) - this.random.nextInt(4));
            } while(this.flip <= this.flipT + 1.0F && this.flip >= this.flipT - 1.0F);
        }

        ++this.time;
        this.oFlip = this.flip;
        this.oOpen = this.open;
        boolean flag = false;

        for(int i = 0; i < 3; ++i) {
            if ((this.menu).costs[i] != 0) {
                flag = true;
            }
        }

        if (flag) {
            this.open += 0.2F;
        } else {
            this.open -= 0.2F;
        }

        this.open = Mth.clamp(this.open, 0.0F, 1.0F);
        float f1 = (this.flipT - this.flip) * 0.4F;
        float f = 0.2F;
        f1 = Mth.clamp(f1, -0.2F, 0.2F);
        this.flipA += (f1 - this.flipA) * 0.9F;
        this.flip += this.flipA;
    }
}
